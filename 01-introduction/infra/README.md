# Azure Infrastructure for LangChain4j Getting Started

## Table of Contents

- [Prerequisites](#prerequisites)
- [Architecture](#architecture)
- [Resources Created](#resources-created)
- [Quick Start](#quick-start)
- [Configuration](#configuration)
- [Management Commands](#management-commands)
- [Cost Optimization](#cost-optimization)
- [Monitoring](#monitoring)
- [Troubleshooting](#troubleshooting)
- [Updating Infrastructure](#updating-infrastructure)
- [Clean Up](#clean-up)
- [File Structure](#file-structure)
- [Security Recommendations](#security-recommendations)
- [Additional Resources](#additional-resources)

This directory contains the Azure infrastructure as code (IaC) using Bicep and Azure Developer CLI (azd) for deploying Azure OpenAI resources.

## Prerequisites

- [Azure CLI](https://docs.microsoft.com/cli/azure/install-azure-cli) (version 2.50.0 or later)
- [Azure Developer CLI (azd)](https://learn.microsoft.com/azure/developer/azure-developer-cli/install-azd) (version 1.5.0 or later)
- An Azure subscription with permissions to create resources

## Architecture

**Simplified Local Development Setup** - Deploy Azure OpenAI only, run all apps locally.

The infrastructure deploys the following Azure resources:

### AI Services
- **Azure OpenAI**: Cognitive Services with two model deployments:
  - **gpt-5**: Chat completion model (20K TPM capacity)
  - **text-embedding-3-small**: Embedding model for RAG (20K TPM capacity)

### Local Development
All Spring Boot applications run locally on your machine:
- 01-introduction (port 8080)
- 02-prompt-engineering (port 8083)
- 03-rag (port 8081)
- 04-tools (port 8084)

## Resources Created

| Resource Type | Resource Name Pattern | Purpose |
|--------------|----------------------|---------|
| Resource Group | `rg-{environmentName}` | Contains all resources |
| Azure OpenAI | `aoai-{resourceToken}` | AI model hosting |

> **Note:** `{resourceToken}` is a unique string generated from subscription ID, environment name, and location

## Quick Start

### 1. Deploy Azure OpenAI

```bash
cd 01-introduction
azd up
```

When prompted:
- Select your Azure subscription
- Choose a location (recommended: `eastus2` or `swedencentral` for GPT-5 availability)
- Confirm the environment name (default: `langchain4j-dev`)

This will create:
- Azure OpenAI resource with GPT-5 and text-embedding-3-small
- Output connection details

> **Note:** On first deployment, you may encounter a "RequestConflict" or "provisioning state is not terminal" error. This is a known Azure timing issue. Simply run `azd up` again and it will complete successfully.

### 2. Get Connection Details

```bash
azd env get-values
```

This displays:
- `AZURE_OPENAI_ENDPOINT`: Your Azure OpenAI endpoint URL
- `AZURE_OPENAI_KEY`: API key for authentication
- `AZURE_OPENAI_DEPLOYMENT`: Chat model name (gpt-5)
- `AZURE_OPENAI_EMBEDDING_DEPLOYMENT`: Embedding model name

### 3. Run Applications Locally

The `azd up` command automatically creates a `.env` file in the root directory with all necessary environment variables.

**Recommended:** Start all web applications:

```bash
# From the root directory
cd ../..
./start-all.sh
```

Or start a single module:

```bash
# Example: Start just the introduction module
cd ../01-introduction
./start.sh
```

Both scripts automatically load environment variables from the root `.env` file created by `azd up`.

## Configuration

### Customizing Model Deployments

To change model deployments, edit `infra/main.bicep` and modify the `openAiDeployments` parameter:

```bicep
param openAiDeployments array = [
  {
    name: 'gpt-5'  // Model deployment name
    model: {
      format: 'OpenAI'
      name: 'gpt-5'
      version: '2025-08-07'  // Model version
    }
    sku: {
      name: 'Standard'
      capacity: 20  // TPM in thousands
    }
  }
  // Add more deployments...
]
```

Available models and versions: https://learn.microsoft.com/azure/ai-services/openai/concepts/models

### Changing Azure Regions

To deploy in a different region, edit `infra/main.bicep`:

```bicep
param openAiLocation string = 'swedencentral'  // or other GPT-5 region
```

Check GPT-5 availability: https://learn.microsoft.com/azure/ai-services/openai/concepts/models#model-summary-table-and-region-availability

To update the infrastructure after making changes to Bicep files:

```bash
# Rebuild the ARM template
az bicep build --file infra/main.bicep

# Preview changes
azd provision --preview

# Apply changes
azd provision
```

## Clean Up

To delete all resources:

```bash
# Delete all resources
azd down

# Delete everything including the environment
azd down --purge
```

**Warning**: This will permanently delete all Azure resources.

## File Structure

## Cost Optimization

### Development/Testing
For dev/test environments, you can reduce costs:
- Use Standard tier (S0) for Azure OpenAI
- Set lower capacity (10K TPM instead of 20K) in `infra/core/ai/cognitiveservices.bicep`
- Delete resources when not in use: `azd down`

### Production
For production:
- Increase OpenAI capacity based on usage (50K+ TPM)
- Enable zone redundancy for higher availability
- Implement proper monitoring and cost alerts

### Cost Estimation
- Azure OpenAI: Pay-per-token (input + output)
- GPT-5: ~$3-5 per 1M tokens (check current pricing)
- text-embedding-3-small: ~$0.02 per 1M tokens

Pricing calculator: https://azure.microsoft.com/pricing/calculator/

## Monitoring

### View Azure OpenAI Metrics

Go to Azure Portal → Your OpenAI resource → Metrics:
- Token-Based Utilization
- HTTP Request Rate
- Time To Response
- Active Tokens

## Troubleshooting

### Issue: GPT-5 not available in selected region

**Solution:**
- Choose a region with GPT-5 access (e.g., eastus, swedencentral)
- Check availability: https://learn.microsoft.com/azure/ai-services/openai/concepts/models

### Issue: "RequestConflict" or "provisioning state is not terminal" on first deployment

**Error Message:**
```
Cannot modify resource... because the resource entity provisioning state is not terminal
```

**Solution:**
This is a known Azure race condition when deploying OpenAI resources. Simply **run `azd up` again** - it will succeed on the second attempt after the initial resource provisioning completes.

### Issue: Insufficient quota for deployment

**Solution:**
1. Request quota increase in Azure Portal
2. Or use lower capacity in `main.bicep` (e.g., capacity: 10)

### Issue: "Resource not found" when running locally

**Solution:**
1. Verify deployment: `azd env get-values`
2. Check endpoint and key are correct
3. Ensure resource group exists in Azure Portal

### Issue: Authentication failed

**Solution:**
- Verify `AZURE_OPENAI_API_KEY` is set correctly
- Key format should be 32-character hexadecimal string
- Get new key from Azure Portal if needed

### Deployment Fails

**Issue**: `azd provision` fails with quota or capacity errors

**Solution**: 
1. Try a different region - See [Changing Azure Regions](#changing-azure-regions) section for how to configure regions
2. Check your subscription has Azure OpenAI quota:
   ```bash
   az cognitiveservices account list-skus --location <your-region>
   ```

### Application Not Connecting

**Issue**: Java application shows connection errors

**Solution**:
1. Verify environment variables are exported:
   ```bash
   echo $AZURE_OPENAI_ENDPOINT
   echo $AZURE_OPENAI_API_KEY
   ```
2. Check endpoint format is correct (should be `https://xxx.openai.azure.com`)
3. Verify API key is the primary or secondary key from Azure Portal

**Issue**: 401 Unauthorized from Azure OpenAI

**Solution**:
1. Get a fresh API key from Azure Portal → Keys and Endpoint
2. Re-export the `AZURE_OPENAI_API_KEY` environment variable
3. Ensure model deployments are complete (check Azure Portal)

### Performance Issues

**Issue**: Slow response times

**Solution**:
1. Check OpenAI token usage and throttling in Azure Portal metrics
2. Increase TPM capacity if you're hitting limits
3. Consider using a higher reasoning-effort level (low/medium/high)

## Updating Infrastructure

```
infra/
├── main.bicep                       # Main infrastructure definition
├── main.json                        # Compiled ARM template (auto-generated)
├── main.bicepparam                  # Parameter file
├── README.md                        # This file
└── core/
    └── ai/
        └── cognitiveservices.bicep  # Azure OpenAI module
```

## Security Recommendations

1. **Never commit API keys** - Use environment variables
2. **Use .env files locally** - Add `.env` to `.gitignore`
3. **Rotate keys regularly** - Generate new keys in Azure Portal
4. **Limit access** - Use Azure RBAC to control who can access resources
5. **Monitor usage** - Set up cost alerts in Azure Portal

## Additional Resources

- [Azure OpenAI Service Documentation](https://learn.microsoft.com/azure/ai-services/openai/)
- [GPT-5 Model Documentation](https://learn.microsoft.com/azure/ai-services/openai/concepts/models#gpt-5)
- [Azure Developer CLI Documentation](https://learn.microsoft.com/azure/developer/azure-developer-cli/)
- [Bicep Documentation](https://learn.microsoft.com/azure/azure-resource-manager/bicep/)
- [LangChain4j Azure OpenAI Integration](https://docs.langchain4j.dev/integrations/language-models/azure-open-ai)

## Support

For issues:
1. Check the [troubleshooting section](#troubleshooting) above
2. Review Azure OpenAI service health in Azure Portal
3. Open an issue in the repository

## License

See the root [LICENSE](../../LICENSE) file for details.
