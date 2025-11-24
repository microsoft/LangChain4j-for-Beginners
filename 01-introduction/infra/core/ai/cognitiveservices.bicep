param name string
param location string = resourceGroup().location
param tags object = {}
param kind string = 'OpenAI'
param sku string = 'S0'
param deployments array = []

resource cognitiveServices 'Microsoft.CognitiveServices/accounts@2024-10-01' = {
  name: name
  location: location
  tags: tags
  kind: kind
  sku: {
    name: sku
  }
  properties: {
    customSubDomainName: name
    publicNetworkAccess: 'Enabled'
    networkAcls: {
      defaultAction: 'Allow'
    }
  }
}

// First deployment - gpt-5
// NOTE: raiPolicyName *must* be set to null here.
// Leaving it out causes long-running / stuck deployments for some models
// in this tenant/region, due to how the RP auto-attaches RAI policies.
// Do not remove unless you've tested end-to-end.
// NOTE: We hard-code two deployments and sequence them with dependsOn
// to avoid parallel deployment conflicts on the same OpenAI account.
// Previous attempts with a for-loop + concurrent deployments caused timeouts.
resource deployment1 'Microsoft.CognitiveServices/accounts/deployments@2024-10-01' = if (length(deployments) > 0) {
  parent: cognitiveServices
  name: deployments[0].name
  sku: deployments[0].sku
  properties: {
    model: deployments[0].model
    raiPolicyName: null
  }
}

// Second deployment - text-embedding-3-small (explicit dependency on first)
resource deployment2 'Microsoft.CognitiveServices/accounts/deployments@2024-10-01' = if (length(deployments) > 1) {
  parent: cognitiveServices
  name: deployments[1].name
  sku: deployments[1].sku
  properties: {
    model: deployments[1].model
    raiPolicyName: null
  }
  dependsOn: [
    deployment1
  ]
}

output id string = cognitiveServices.id
output name string = cognitiveServices.name
output endpoint string = cognitiveServices.properties.endpoint
output deploymentNames array = length(deployments) > 0 ? (length(deployments) > 1 ? [deployment1.name, deployment2.name] : [deployment1.name]) : []

#disable-next-line outputs-should-not-contain-secrets  
output key string = cognitiveServices.listKeys().key1
