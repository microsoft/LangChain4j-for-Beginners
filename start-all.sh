#!/bin/bash

# Start all LangChain4j applications
# This script sources the centralized .env file and starts all modules

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ENV_FILE="$SCRIPT_DIR/.env"

# Check if .env exists
if [ ! -f "$ENV_FILE" ]; then
    echo "Error: .env file not found at $ENV_FILE"
    echo "Please copy .env.example to .env and fill in your credentials"
    exit 1
fi

# Source environment variables
echo "Loading environment variables from $ENV_FILE"
set -a
source "$ENV_FILE"
set +a

# Verify required variables are set
if [ -z "$AZURE_OPENAI_ENDPOINT" ] || [ -z "$AZURE_OPENAI_API_KEY" ] || [ -z "$AZURE_OPENAI_DEPLOYMENT" ]; then
    echo "Error: Missing required environment variables"
    echo "Please ensure AZURE_OPENAI_ENDPOINT, AZURE_OPENAI_API_KEY, and AZURE_OPENAI_DEPLOYMENT are set in .env"
    exit 1
fi

echo "Environment variables loaded successfully"
echo "AZURE_OPENAI_ENDPOINT: $AZURE_OPENAI_ENDPOINT"
echo "AZURE_OPENAI_DEPLOYMENT: $AZURE_OPENAI_DEPLOYMENT"

# Function to check if port is in use
is_port_in_use() {
    local port=$1
    if command -v lsof &> /dev/null; then
        lsof -Pi :$port -sTCP:LISTEN -t >/dev/null 2>&1
    else
        netstat -ano | grep "LISTENING" | grep -w ":$port" >/dev/null 2>&1
    fi
}

# Function to wait for port to be ready
wait_for_port() {
    local port=$1
    local max_wait=30
    local count=0
    
    while [ $count -lt $max_wait ]; do
        if is_port_in_use $port; then
            return 0
        fi
        sleep 1
        count=$((count + 1))
    done
    return 1
}

# Function to start an application
start_app() {
    local module=$1
    local port=$2
    local jar_name=$3
    local jar_file="$SCRIPT_DIR/$module/target/$jar_name"
    local log_file="$SCRIPT_DIR/$module/$module.log"
    
    echo ""
    echo "Starting $module on port $port..."
    
    # Check if port is already in use
    if is_port_in_use $port; then
        echo "Warning: Port $port is already in use. Skipping $module"
        return 0
    fi
    
    # Build if JAR doesn't exist
    if [ ! -f "$jar_file" ]; then
        echo "JAR file not found. Building $module..."
        cd "$SCRIPT_DIR/$module"
        if ! mvn clean package -DskipTests; then
            echo "Error: Build failed for $module"
            cd "$SCRIPT_DIR"
            return 1
        fi
        
        if [ ! -f "$jar_file" ]; then
            echo "Error: Build succeeded but JAR file not created at $jar_file"
            cd "$SCRIPT_DIR"
            return 1
        fi
        echo "Build completed successfully"
        cd "$SCRIPT_DIR"
    fi
    
    # Start application in background
    cd "$SCRIPT_DIR/$module"
    java -jar "$jar_file" &
    local pid=$!
    cd "$SCRIPT_DIR"
    
    echo "Started $module with PID $pid, waiting for port $port to be ready..."
    
    # Wait for port to become available
    if wait_for_port $port; then
        echo "✓ $module is running on port $port"
        return 0
    else
        echo "✗ $module failed to start"
        return 1
    fi
}

# Start all modules
failed_modules=()

if ! start_app "01-introduction" 8080 "introduction-1.0.0.jar"; then
    failed_modules+=("01-introduction")
fi

if ! start_app "02-prompt-engineering" 8083 "prompt-engineering-1.0.0.jar"; then
    failed_modules+=("02-prompt-engineering")
fi

if ! start_app "03-rag" 8081 "rag-1.0.0.jar"; then
    failed_modules+=("03-rag")
fi

if ! start_app "04-tools" 8084 "tools-1.0.0.jar"; then
    failed_modules+=("04-tools")
fi

echo ""
echo "============================================"
if [ ${#failed_modules[@]} -eq 0 ]; then
    echo "All applications started successfully!"
else
    echo "Some applications failed to start:"
    for module in "${failed_modules[@]}"; do
        echo "  - $module"
    done
fi
echo ""
echo "Running applications:"
echo "01-introduction:       http://localhost:8080"
echo "02-prompt-engineering: http://localhost:8083"
echo "03-rag:                http://localhost:8081"
echo "04-tools:              http://localhost:8084"
echo "============================================"
echo ""
echo "To stop all applications, run: ./stop-all.sh"

