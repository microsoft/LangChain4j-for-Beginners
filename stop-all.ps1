# Stop all LangChain4j applications

$ErrorActionPreference = "Continue"

$ScriptDir = $PSScriptRoot

Write-Host "Stopping all LangChain4j applications..."

# Function to stop applications on a specific port
function Stop-OnPort {
    param(
        [int]$Port,
        [string]$Module
    )
    
    $stopped = $false
    
    try {
        $connections = Get-NetTCPConnection -LocalPort $Port -State Listen -ErrorAction SilentlyContinue
        if ($connections) {
            $pids = $connections | Select-Object -ExpandProperty OwningProcess -Unique
            Write-Host "Stopping $Module on port $Port (PIDs: $($pids -join ', '))"
            
            foreach ($pid in $pids) {
                try {
                    Stop-Process -Id $pid -Force -ErrorAction Stop
                    $stopped = $true
                } catch {
                    Write-Host "Warning: Could not stop process $pid"
                }
            }
            
            if ($stopped) {
                Write-Host "✓ Successfully stopped $Module" -ForegroundColor Green
            }
        } else {
            Write-Host "No process found for $Module on port $Port"
        }
    } catch {
        Write-Host "No process found for $Module on port $Port"
    }
}

# Stop all modules
Stop-OnPort -Port 8080 -Module "01-introduction"
Stop-OnPort -Port 8083 -Module "02-prompt-engineering"
Stop-OnPort -Port 8081 -Module "03-rag"
Stop-OnPort -Port 8084 -Module "04-tools"

# Also try to find and kill any Java processes running our JARs (as fallback)
$javaProcesses = Get-Process -Name java -ErrorAction SilentlyContinue
foreach ($proc in $javaProcesses) {
    $cmdLine = (Get-CimInstance Win32_Process -Filter "ProcessId = $($proc.Id)").CommandLine
    if ($cmdLine -match "introduction-1\.0\.0\.jar|prompt-engineering-1\.0\.0\.jar|rag-1\.0\.0\.jar|tools-1\.0\.0\.jar") {
        try {
            Stop-Process -Id $proc.Id -Force
            Write-Host "✓ Stopped Java process $($proc.Id)" -ForegroundColor Green
        } catch {
            Write-Host "Warning: Could not stop Java process $($proc.Id)"
        }
    }
}

Write-Host ""
Write-Host "All applications stopped." -ForegroundColor Green
