# Stop script for 01-introduction module

$ErrorActionPreference = "Continue"

$ScriptDir = $PSScriptRoot
$Port = 8080
$ModuleName = "01-introduction"
$JarName = "introduction-1.0.0.jar"

Write-Host "Stopping $ModuleName..."

$stopped = $false

# Stop by port
try {
    $connections = Get-NetTCPConnection -LocalPort $Port -State Listen -ErrorAction SilentlyContinue
    if ($connections) {
        $pids = $connections | Select-Object -ExpandProperty OwningProcess -Unique
        Write-Host "Stopping processes on port $Port (PIDs: $($pids -join ', '))"
        
        foreach ($pid in $pids) {
            try {
                Stop-Process -Id $pid -Force -ErrorAction Stop
                $stopped = $true
            } catch {
                Write-Host "Warning: Could not stop process $pid"
            }
        }
        
        if ($stopped) {
            Write-Host "✓ Successfully stopped processes on port $Port" -ForegroundColor Green
        }
    }
} catch {
    # No process on port
}

# Also try to kill by JAR name if not already stopped
if (-not $stopped) {
    $javaProcesses = Get-Process -Name java -ErrorAction SilentlyContinue
    foreach ($proc in $javaProcesses) {
        $cmdLine = (Get-CimInstance Win32_Process -Filter "ProcessId = $($proc.Id)").CommandLine
        if ($cmdLine -match [regex]::Escape($JarName)) {
            try {
                Stop-Process -Id $proc.Id -Force
                Write-Host "✓ Stopped $JarName process" -ForegroundColor Green
                $stopped = $true
            } catch {
                Write-Host "Warning: Could not stop Java process $($proc.Id)"
            }
        }
    }
}

if (-not $stopped) {
    Write-Host "No running instance of $ModuleName found"
    exit 1
} else {
    Write-Host "$ModuleName stopped successfully" -ForegroundColor Green
    exit 0
}
