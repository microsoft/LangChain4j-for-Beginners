# Start script for 02-prompt-engineering module
# Loads environment variables from parent .env file

$ErrorActionPreference = "Stop"

$ScriptDir = $PSScriptRoot
$RootDir = Split-Path $ScriptDir -Parent
$EnvFile = Join-Path $RootDir ".env"

# Change to module directory
Set-Location $ScriptDir

# Check if .env exists
if (-not (Test-Path $EnvFile)) {
    Write-Error ".env file not found at $EnvFile. Please copy .env.example to .env in the root directory"
    exit 1
}

# Load environment variables
Write-Host "Loading environment variables from $EnvFile"
Get-Content $EnvFile | ForEach-Object {
    if ($_ -match '^([^=]+)=(.*)$') {
        [Environment]::SetEnvironmentVariable($matches[1], $matches[2], 'Process')
    }
}

# Verify required variables
$endpoint = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_ENDPOINT', 'Process')
$apiKey = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_API_KEY', 'Process')
$deployment = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_DEPLOYMENT', 'Process')

if (-not $endpoint -or -not $apiKey -or -not $deployment) {
    Write-Error "Missing required environment variables (AZURE_OPENAI_ENDPOINT, AZURE_OPENAI_API_KEY, AZURE_OPENAI_DEPLOYMENT)"
    exit 1
}

Write-Host "Starting 02-prompt-engineering on port 8083..."

$JarFile = Join-Path $ScriptDir "target\prompt-engineering-1.0.0.jar"

if (-not (Test-Path $JarFile)) {
    Write-Host "JAR file not found. Building..."
    mvn clean package -DskipTests
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Build failed"
        exit 1
    }
    
    if (-not (Test-Path $JarFile)) {
        Write-Error "Build succeeded but JAR file not created at $JarFile"
        exit 1
    }
    Write-Host "Build completed successfully"
}

java -jar $JarFile
