# Start all LangChain4j applications
# This script loads the centralized .env file and starts all modules

$ErrorActionPreference = "Stop"

$ScriptDir = $PSScriptRoot
$EnvFile = Join-Path $ScriptDir ".env"

# Check if .env exists
if (-not (Test-Path $EnvFile)) {
    Write-Error ".env file not found at $EnvFile. Please copy .env.example to .env and fill in your credentials"
    exit 1
}

# Load environment variables
Write-Host "Loading environment variables from $EnvFile"
Get-Content $EnvFile | ForEach-Object {
    if ($_ -match '^([^=]+)=(.*)$') {
        [Environment]::SetEnvironmentVariable($matches[1], $matches[2], 'Process')
    }
}

# Verify required variables are set
$endpoint = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_ENDPOINT', 'Process')
$apiKey = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_API_KEY', 'Process')
$deployment = [Environment]::GetEnvironmentVariable('AZURE_OPENAI_DEPLOYMENT', 'Process')

if (-not $endpoint -or -not $apiKey -or -not $deployment) {
    Write-Error "Missing required environment variables. Please ensure AZURE_OPENAI_ENDPOINT, AZURE_OPENAI_API_KEY, and AZURE_OPENAI_DEPLOYMENT are set in .env"
    exit 1
}

Write-Host "Environment variables loaded successfully" -ForegroundColor Green
Write-Host "AZURE_OPENAI_ENDPOINT: $endpoint"
Write-Host "AZURE_OPENAI_DEPLOYMENT: $deployment"
Write-Host ""

# Function to check if port is in use
function Test-PortInUse {
    param([int]$Port)
    $connections = Get-NetTCPConnection -LocalPort $Port -State Listen -ErrorAction SilentlyContinue
    return $null -ne $connections
}

# Function to wait for port to be ready
function Wait-ForPort {
    param(
        [int]$Port,
        [int]$MaxWaitSeconds = 30
    )
    
    $count = 0
    while ($count -lt $MaxWaitSeconds) {
        if (Test-PortInUse -Port $Port) {
            return $true
        }
        Start-Sleep -Seconds 1
        $count++
    }
    return $false
}

# Function to start an application
function Start-App {
    param(
        [string]$Module,
        [int]$Port,
        [string]$JarName
    )
    
    $JarFile = Join-Path $ScriptDir "$Module\target\$JarName"
    $LogFile = Join-Path $ScriptDir "$Module\$Module.log"
    
    Write-Host ""
    Write-Host "Starting $Module on port $Port..." -ForegroundColor Yellow
    
    # Check if port is already in use
    if (Test-PortInUse -Port $Port) {
        Write-Host "Warning: Port $Port is already in use. Skipping $Module" -ForegroundColor Yellow
        return $true
    }
    
    # Build if JAR doesn't exist
    if (-not (Test-Path $JarFile)) {
        Write-Host "JAR file not found. Building $Module..."
        Push-Location (Join-Path $ScriptDir $Module)
        mvn clean package -DskipTests
        if ($LASTEXITCODE -ne 0) {
            Write-Host "Error: Build failed for $Module" -ForegroundColor Red
            Pop-Location
            return $false
        }
        
        if (-not (Test-Path $JarFile)) {
            Write-Host "Error: Build succeeded but JAR file not created at $JarFile" -ForegroundColor Red
            Pop-Location
            return $false
        }
        Write-Host "Build completed successfully" -ForegroundColor Green
        Pop-Location
    }
    
    # Start application in background
    Push-Location (Join-Path $ScriptDir $Module)
    $process = Start-Process -FilePath "java" -ArgumentList "-jar", $JarFile -NoNewWindow -PassThru
    Pop-Location
    
    Write-Host "Started $Module with PID $($process.Id), waiting for port $Port to be ready..."
    
    # Wait for port to become available
    if (Wait-ForPort -Port $Port -MaxWaitSeconds 30) {
        Write-Host "✓ $Module is running on port $Port" -ForegroundColor Green
        return $true
    } else {
        Write-Host "✗ $Module failed to start. Check $Module\$Module.log for details" -ForegroundColor Red
        return $false
    }
}

# Start all modules
$failedModules = @()

if (-not (Start-App -Module "01-introduction" -Port 8080 -JarName "introduction-1.0.0.jar")) {
    $failedModules += "01-introduction"
}

if (-not (Start-App -Module "02-prompt-engineering" -Port 8083 -JarName "prompt-engineering-1.0.0.jar")) {
    $failedModules += "02-prompt-engineering"
}

if (-not (Start-App -Module "03-rag" -Port 8081 -JarName "rag-1.0.0.jar")) {
    $failedModules += "03-rag"
}

if (-not (Start-App -Module "04-tools" -Port 8084 -JarName "tools-1.0.0.jar")) {
    $failedModules += "04-tools"
}

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
if ($failedModules.Count -eq 0) {
    Write-Host "All applications started successfully!" -ForegroundColor Green
} else {
    Write-Host "Some applications failed to start:" -ForegroundColor Red
    foreach ($module in $failedModules) {
        Write-Host "  - $module" -ForegroundColor Red
    }
}
Write-Host ""
Write-Host "Running applications:"
Write-Host "01-introduction:       http://localhost:8080"
Write-Host "02-prompt-engineering: http://localhost:8083"
Write-Host "03-rag:                http://localhost:8081"
Write-Host "04-tools:              http://localhost:8084"
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "To stop all applications, run: .\stop-all.ps1"
