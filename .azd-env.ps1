# Azure Developer CLI (azd) environment integration
# This script loads environment variables from azd and creates/updates .env file

$ErrorActionPreference = "Stop"

$ScriptDir = $PSScriptRoot
$EnvFile = Join-Path $ScriptDir ".env"

Write-Host "Loading Azure Developer CLI (azd) environment..."

# Check if azd is installed
if (-not (Get-Command azd -ErrorAction SilentlyContinue)) {
    Write-Error "Azure Developer CLI (azd) is not installed. Install it from: https://learn.microsoft.com/azure/developer/azure-developer-cli/install-azd"
    exit 1
}

# Load existing .env for fallback values
$ExistingVars = @{}
if (Test-Path $EnvFile) {
    Get-Content $EnvFile | ForEach-Object {
        if ($_ -match '^([^=]+)=(.*)$') {
            $ExistingVars[$matches[1]] = $matches[2]
        }
    }
}

# Change to 01-introduction directory to access the azd environment
Push-Location (Join-Path $ScriptDir "01-introduction")

try {
    # Get all environment variables from azd
    $AzdEnvVars = @{}
    $azdOutput = azd env get-values 2>$null
    if ($azdOutput) {
        $azdOutput | ForEach-Object {
            if ($_ -match '^([^=]+)="?([^"]*)"?$') {
                $AzdEnvVars[$matches[1]] = $matches[2]
            }
        }
    }

    # Use azd values if available, otherwise use existing or defaults
    $AzureOpenAiEndpoint = if ($AzdEnvVars['AZURE_OPENAI_ENDPOINT']) { $AzdEnvVars['AZURE_OPENAI_ENDPOINT'] } else { $ExistingVars['AZURE_OPENAI_ENDPOINT'] }
    $AzureOpenAiApiKey = if ($AzdEnvVars['AZURE_OPENAI_KEY']) { $AzdEnvVars['AZURE_OPENAI_KEY'] } else { $ExistingVars['AZURE_OPENAI_API_KEY'] }
    $AzureOpenAiDeployment = if ($AzdEnvVars['AZURE_OPENAI_DEPLOYMENT']) { $AzdEnvVars['AZURE_OPENAI_DEPLOYMENT'] } elseif ($ExistingVars['AZURE_OPENAI_DEPLOYMENT']) { $ExistingVars['AZURE_OPENAI_DEPLOYMENT'] } else { 'gpt-5' }
    $AzureOpenAiEmbeddingDeployment = if ($AzdEnvVars['AZURE_OPENAI_EMBEDDING_DEPLOYMENT']) { $AzdEnvVars['AZURE_OPENAI_EMBEDDING_DEPLOYMENT'] } elseif ($ExistingVars['AZURE_OPENAI_EMBEDDING_DEPLOYMENT']) { $ExistingVars['AZURE_OPENAI_EMBEDDING_DEPLOYMENT'] } else { 'text-embedding-3-small' }

    # Validate required variables
    if (-not $AzureOpenAiEndpoint) {
        Write-Error "AZURE_OPENAI_ENDPOINT not found in azd environment or existing .env. Set it with: azd env set AZURE_OPENAI_ENDPOINT <value>"
        exit 1
    }

    if (-not $AzureOpenAiApiKey) {
        Write-Error "AZURE_OPENAI_API_KEY not found in azd environment or existing .env. Set it with: azd env set AZURE_OPENAI_KEY <value>"
        exit 1
    }

    # Return to script directory
    Pop-Location

    # Create/update .env file
    Write-Host "Creating/updating .env file from azd environment..."

    @"
AZURE_OPENAI_ENDPOINT=$AzureOpenAiEndpoint
AZURE_OPENAI_API_KEY=$AzureOpenAiApiKey
AZURE_OPENAI_DEPLOYMENT=$AzureOpenAiDeployment
AZURE_OPENAI_EMBEDDING_DEPLOYMENT=$AzureOpenAiEmbeddingDeployment
"@ | Set-Content -Path $EnvFile

    # Create .env files in module directories
    $Modules = @('01-introduction', '02-prompt-engineering', '03-rag', '04-tools')
    foreach ($Module in $Modules) {
        $ModuleDir = Join-Path $ScriptDir $Module
        $ModuleEnv = Join-Path $ModuleDir ".env"
        
        if (Test-Path $ModuleDir) {
            Write-Host "Creating .env in $Module..."
            Copy-Item $EnvFile $ModuleEnv -Force
            
            # Add module-specific variables
            if ($Module -eq '04-tools') {
                Add-Content -Path $ModuleEnv -Value "TOOLS_BASE_URL=http://localhost:8084"
            }
        }
    }

    Write-Host "✓ Environment variables successfully loaded from azd" -ForegroundColor Green
    Write-Host "✓ .env file created/updated at: $EnvFile" -ForegroundColor Green
    Write-Host "✓ .env files created in all module directories" -ForegroundColor Green
    Write-Host ""
    Write-Host "Configuration:"
    Write-Host "  AZURE_OPENAI_ENDPOINT: $AzureOpenAiEndpoint"
    Write-Host "  AZURE_OPENAI_API_KEY: [HIDDEN]"
    Write-Host "  AZURE_OPENAI_DEPLOYMENT: $AzureOpenAiDeployment"
    Write-Host "  AZURE_OPENAI_EMBEDDING_DEPLOYMENT: $AzureOpenAiEmbeddingDeployment"
    Write-Host ""
    Write-Host "You can now run: .\start-all.ps1"

} catch {
    Pop-Location
    throw
}
