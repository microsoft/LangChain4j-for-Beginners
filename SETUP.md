# Setup Guide for LangChain4j-for-Beginners

This guide helps you get started with the LangChain4j training repository, especially if you're new to Java, Maven, or Azure.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Initial Setup](#initial-setup)
- [Module 00 & 05: GitHub Models Setup](#module-00--05-github-models-setup)
- [Modules 01-04: Azure OpenAI Setup](#modules-01-04-azure-openai-setup)
- [Common Issues & Troubleshooting](#common-issues--troubleshooting)

## Prerequisites

### Required Software

1. **Java 21 or later**
   ```bash
   # Check your Java version
   java --version
   # Should show version 21 or higher
   ```

2. **Maven 3.9 or later**
   ```bash
   # Check your Maven version
   mvn --version
   # Should show version 3.9 or higher
   ```

3. **Azure CLI** (for Modules 01-04)
   - Download from: https://learn.microsoft.com/cli/azure/install-azure-cli

4. **Azure Developer CLI (azd)** (for Modules 01-04)
   - Download from: https://learn.microsoft.com/azure/developer/azure-developer-cli/install-azd

5. **Node.js 16+** (for Module 05 - MCP)
   ```bash
   # Check your Node.js version
   node --version
   # Should show version 16 or higher
   ```

6. **Docker Desktop** (for Module 05 - MCP Git example)
   - Download from: https://www.docker.com/products/docker-desktop
   - **Important**: Docker Desktop must be RUNNING, not just installed!

### Recommended IDE

- **Visual Studio Code** with the following extensions:
  - Extension Pack for Java
  - Spring Boot Extension Pack
  - GitHub Copilot (optional but helpful)

## Initial Setup

### 1. Clone the Repository

```bash
git clone https://github.com/microsoft/LangChain4j-for-Beginners.git
cd LangChain4j-for-Beginners
```

### 2. Verify Project Structure

```bash
# Build all modules to check everything compiles
mvn clean compile
```

This should download dependencies and compile all modules without errors.

## Module 00 & 05: GitHub Models Setup

Modules 00 (Quick Start) and 05 (MCP) use GitHub Models, which is free and doesn't require an Azure subscription.

### Step 1: Create GitHub Personal Access Token

1. Go to https://github.com/settings/personal-access-tokens
2. Click **"Generate new token"** (Fine-grained token)
3. Set these values:
   - **Token name**: `LangChain4j-Training`
   - **Expiration**: 7 days (or longer if you prefer)
   - **Resource owner**: Your GitHub username
4. Under **Account permissions**, find **Models** and set to **Read-only**
5. Click **"Generate token"**
6. **IMPORTANT**: Copy your token immediately - you won't see it again!

### Step 2: Set Environment Variable

**Option A: Create .env File (Recommended for VS Code)**

1. Create a file named `.env` in the project root directory:
   ```bash
   # On macOS/Linux
   touch .env
   
   # On Windows
   type nul > .env
   ```

2. Add your token to the `.env` file:
   ```bash
   GITHUB_TOKEN=your_token_here_without_quotes
   ```

3. If using VS Code, you can now right-click any demo file and select "Run Java"

**Option B: Set in Terminal (for command-line execution)**

```bash
# macOS/Linux
export GITHUB_TOKEN="your_token_here"

# Windows PowerShell
$env:GITHUB_TOKEN="your_token_here"

# Windows CMD
set GITHUB_TOKEN=your_token_here
```

**Verify it's set:**
```bash
# macOS/Linux
echo $GITHUB_TOKEN

# Windows PowerShell
echo $env:GITHUB_TOKEN
```

### Step 3: Test Module 00

```bash
cd 00-quick-start

# Test Basic Chat Demo
mvn clean compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.BasicChatDemo"
```

If you see a response from the AI, you're all set!

## Modules 01-04: Azure OpenAI Setup

Modules 01-04 use Azure OpenAI with GPT-5 and require an Azure subscription.

### Step 1: Azure Prerequisites

1. **Azure Subscription** with Azure OpenAI access
   - If you don't have access, request it at: https://aka.ms/oai/access

2. **Azure CLI login**
   ```bash
   az login
   # Follow the browser prompt to sign in
   ```

### Step 2: Deploy Azure Resources

```bash
cd 01-introduction

# Run Azure Developer CLI deployment
azd up
```

During `azd up`, you'll be prompted for:
- **Environment name**: Choose something like `langchain4j-dev`
- **Azure subscription**: Select your subscription from the list
- **Azure region**: Choose `eastus2` (recommended for GPT-5 availability)

The deployment will:
- Create an Azure OpenAI resource
- Deploy GPT-5 model
- Deploy text-embedding-3-small model
- Generate a `.env` file with all credentials

**Common Issue**: If you see "RequestConflict" error, wait 30 seconds and run `azd up` again. This is a known Azure timing issue.

### Step 3: Verify Deployment

```bash
# Check that .env was created
ls -la ../.env

# View the generated configuration (be careful not to share these values!)
cat ../.env
```

You should see:
- `AZURE_OPENAI_ENDPOINT`
- `AZURE_OPENAI_API_KEY`
- `AZURE_OPENAI_DEPLOYMENT`
- `AZURE_EMBEDDING_DEPLOYMENT`

### Step 4: Test Module 01

```bash
# Start the application
./start.sh

# Open browser to http://localhost:8080
# Test both Simple Chat and Conversational Chat

# Stop the application
./stop.sh
```

## Common Issues & Troubleshooting

### Issue: "GITHUB_TOKEN not found"

**Problem**: Environment variable not set or not loaded

**Solutions**:
1. **VS Code users**: Make sure you created the `.env` file in the project ROOT directory, not inside module folders
2. **Terminal users**: Re-run the export command in your current shell session
3. **Verify**: Run `echo $GITHUB_TOKEN` (macOS/Linux) or `echo $env:GITHUB_TOKEN` (Windows PowerShell)

### Issue: Maven command fails with "command not found"

**Problem**: Maven not in system PATH

**Solution**:
```bash
# macOS with Homebrew
brew install maven

# Ubuntu/Debian
sudo apt install maven

# Windows with Chocolatey
choco install maven
```

### Issue: "azd: command not found"

**Problem**: Azure Developer CLI not installed

**Solution**: Install from https://learn.microsoft.com/azure/developer/azure-developer-cli/install-azd

### Issue: PowerShell Maven parameter error

**Problem**: PowerShell interprets `-Dexec.mainClass=...` incorrectly

**Solution**: Use quotes around the parameter:
```powershell
mvn exec:java "-Dexec.mainClass=com.example.langchain4j.quickstart.BasicChatDemo"
```

### Issue: Module 05 Docker example fails

**Problem**: Docker Desktop not running

**Solution**:
1. Start Docker Desktop application
2. Wait for it to fully initialize (look for green "running" status)
3. Verify with: `docker ps` (should not error)
4. Re-run the demo

### Issue: "Cannot find file document.txt"

**Problem**: Running demo from wrong directory

**Solution**: Make sure you `cd` into the module directory first:
```bash
cd 00-quick-start
mvn exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.SimpleReaderDemo"
```

### Issue: Azure deployment fails with "Quota exceeded"

**Problem**: Azure OpenAI quota reached for your subscription/region

**Solutions**:
1. Try a different Azure region: `eastus`, `westus`, `northeurope`
2. Request quota increase in Azure Portal
3. Check existing deployments: `az cognitiveservices account list`

### Issue: Port already in use (e.g., 8080, 8081)

**Problem**: Another application is using the port

**Solution**:
```bash
# Find what's using the port (macOS/Linux)
lsof -i :8080

# Find what's using the port (Windows)
netstat -ano | findstr :8080

# Kill the process or change the port in application.yaml
```

## Getting Help

If you encounter issues not covered here:

1. **Azure AI Foundry Discord**: https://aka.ms/foundry/discord
2. **Azure AI Foundry Developer Forum**: https://aka.ms/foundry/forum
3. **Check the module-specific README**: Each module has additional troubleshooting tips

## Next Steps

Once your setup is complete:

1. Start with [Module 00: Quick Start](00-quick-start/README.md)
2. Progress through modules in order
3. Experiment with the code and ask GitHub Copilot questions
4. Complete the [Testing Guide](docs/TESTING.md) to see best practices

Happy coding!

