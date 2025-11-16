# Module 05: Model Context Protocol (MCP)

## Table of Contents

- [What You'll Learn](#what-youll-learn)
- [Understanding MCP](#understanding-mcp)
- [How MCP Works](#how-mcp-works)
  - [Server-Client Architecture](#server-client-architecture)
  - [Tool Discovery](#tool-discovery)
  - [Transport Mechanisms](#transport-mechanisms)
- [Prerequisites](#prerequisites)
- [What This Module Covers](#what-this-module-covers)
- [Quick Start](#quick-start)
  - [Example 1: Remote Calculator (Streamable HTTP)](#example-1-remote-calculator-streamable-http)
  - [Example 2: File Operations (Stdio)](#example-2-file-operations-stdio)
  - [Example 3: Git Analysis (Docker)](#example-3-git-analysis-docker)
- [Key Concepts](#key-concepts)
  - [Transport Selection](#transport-selection)
  - [Tool Discovery](#tool-discovery-1)
  - [Session Management](#session-management)
  - [Cross-Platform Considerations](#cross-platform-considerations)
- [When to Use MCP](#when-to-use-mcp)
- [MCP Ecosystem](#mcp-ecosystem)
- [Congratulations!](#congratulations)
  - [What's Next?](#whats-next)

## What You'll Learn

You've built conversational AI, mastered prompts, grounded responses in documents, and created agents with tools. But all those tools were custom-built for your specific application. What if you could give your AI access to a standardized ecosystem of tools that anyone can create and share?

The Model Context Protocol (MCP) provides exactly that - a standard way for AI applications to discover and use external tools. Instead of writing custom integrations for each data source or service, you connect to MCP servers that expose their capabilities in a consistent format. Your AI agent can then discover and use these tools automatically.

<img src="images/mcp-comparison.png" alt="MCP Comparison" width="800"/>

*Before MCP: Complex point-to-point integrations. After MCP: One protocol, endless possibilities.*

## Understanding MCP

MCP solves a fundamental problem in AI development: every integration is custom. Want to access GitHub? Custom code. Want to read files? Custom code. Want to query a database? Custom code. And none of these integrations work with other AI applications.

MCP standardizes this. An MCP server exposes tools with clear descriptions and schemas. Any MCP client can connect, discover available tools, and use them. Build once, use everywhere.

<img src="images/mcp-architecture.png" alt="MCP Architecture" width="800"/>

*Model Context Protocol architecture - standardized tool discovery and execution*

## How MCP Works

**Server-Client Architecture**

MCP uses a client-server model. Servers provide tools - reading files, querying databases, calling APIs. Clients (your AI application) connect to servers and use their tools.

**Tool Discovery**

When your client connects to an MCP server, it asks "What tools do you have?" The server responds with a list of available tools, each with descriptions and parameter schemas. Your AI agent can then decide which tools to use based on user requests.

**Transport Mechanisms**

MCP supports different ways to connect:

<img src="images/transport-mechanisms.png" alt="Transport Mechanisms" width="800"/>

*Three MCP transport mechanisms for different integration scenarios*

**Streamable HTTP** - [StreamableHttpDemo.java](src/main/java/com/example/langchain4j/mcp/StreamableHttpDemo.java)

For remote servers. Your application makes HTTP requests to a server running somewhere on the network. Uses Server-Sent Events for real-time communication.

```java
McpClient client = McpClient.builder()
    .transport(StreamableHttpTransport.of("http://localhost:3000/sse"))
    .build();

client.initialize();
List<Tool> tools = client.listTools();
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`StreamableHttpDemo.java`](src/main/java/com/example/langchain4j/mcp/StreamableHttpDemo.java) and ask:
> - "How does MCP differ from direct tool integration like in Module 04?"
> - "What are the benefits of using MCP for tool sharing across applications?"
> - "How do I handle connection failures or timeouts to MCP servers?"

**Stdio** - [StdioTransportDemo.java](src/main/java/com/example/langchain4j/mcp/StdioTransportDemo.java)

For local processes. Your application spawns a server as a subprocess and communicates through standard input/output. Useful for filesystem access or command-line tools.

```java
McpClient client = McpClient.builder()
    .transport(StdioTransport.builder()
        .command("node")
        .arguments("path/to/server.js")
        .build())
    .build();

client.initialize();
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`StdioTransportDemo.java`](src/main/java/com/example/langchain4j/mcp/StdioTransportDemo.java) and ask:
> - "How does Stdio transport work and when should I use it vs HTTP?"
> - "How does LangChain4j manage the lifecycle of spawned MCP server processes?"
> - "What are the security implications of giving AI access to the file system?"

**Docker** - [GitRepositoryAnalyzer.java](src/main/java/com/example/langchain4j/mcp/GitRepositoryAnalyzer.java)

For containerized services. Your application launches a Docker container that exposes MCP tools. Good for complex dependencies or isolated environments.

```java
McpClient client = McpClient.builder()
    .transport(DockerTransport.builder()
        .imageName("mcp/git")
        .arguments("--repository", "/repo")
        .containerVolume("/repo", localRepoPath)
        .build())
    .build();

client.initialize();
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`GitRepositoryAnalyzer.java`](src/main/java/com/example/langchain4j/mcp/GitRepositoryAnalyzer.java) and ask:
> - "How does Docker transport isolate MCP servers and what are the benefits?"
> - "How do I configure volume mounts to share data between host and MCP containers?"
> - "What are best practices for managing Docker-based MCP server lifecycles in production?"

## Prerequisites

- Java 21+, Maven 3.9+
- Node.js 16+ and npm (for MCP servers)
- Docker (for Git integration example)
- GitHub Personal Access Token configured in `.env` file (from Module 00)

> **Note:** If you haven't set up your GitHub token yet, see [Module 00 - Quick Start](../00-quick-start/README.md) for instructions.

## What This Module Covers

In this final module, we'll use GitHub Models again as its rate limits are more generous for the demo servers we'll run locally. You'll work through three examples that demonstrate different MCP integration patterns:

**Streamable HTTP Transport** - Connect to a remote calculator service. See how networked tool integration works with session management.

**Stdio Transport** - Spawn a local filesystem server. Understand subprocess-based tool execution for local operations.

**Docker-Based Git Server** - Launch a containerized Git analysis service. Learn how to work with Docker-based MCP servers and mount local repositories.

Each example shows a different transport mechanism and use case, giving you the foundation to integrate any MCP server.

## Quick Start

**Using VS Code:** Simply right-click on any demo file in the Explorer and select **"Run Java"**, or use the launch configurations from the Run and Debug panel (make sure you've added your token to the `.env` file first).

**Using Maven:** Alternatively, you can run from the command line with the examples below.

**⚠️ Important:** Some examples have prerequisites (like starting an MCP server or building Docker images). Check each example's requirements before running.

### Example 1: Remote Calculator (Streamable HTTP)

This demonstrates network-based tool integration.

**⚠️ Prerequisite:** You need to start the MCP server first (see Terminal 1 below).

**Terminal 1 - Start the MCP server:**
```bash
git clone https://github.com/modelcontextprotocol/servers.git
cd servers/src/everything
npm install
node dist/streamableHttp.js
```

**Terminal 2 - Run the example:**

**Using VS Code:** Right-click on `StreamableHttpDemo.java` and select **"Run Java"**.

**Using Maven:**
```bash
export GITHUB_TOKEN=your_token_here
cd 05-mcp
mvn compile exec:java -Dexec.mainClass=com.example.langchain4j.mcp.StreamableHttpDemo
```

Watch the agent discover available tools, then use the calculator to perform addition.

### Example 2: File Operations (Stdio)

This demonstrates local subprocess-based tools.

**✅ No prerequisites needed** - the MCP server is spawned automatically.

**Using VS Code:** Right-click on `StdioTransportDemo.java` and select **"Run Java"**.

**Using Maven:**
```bash
export GITHUB_TOKEN=your_token_here
cd 05-mcp
mvn compile exec:java -Dexec.mainClass=com.example.langchain4j.mcp.StdioTransportDemo
```

The application spawns a filesystem MCP server automatically and reads a local file. Notice how the subprocess management is handled for you.

### Example 3: Git Analysis (Docker)

This demonstrates containerized tool servers.

**⚠️ Prerequisites:** 
1. **Docker Desktop must be RUNNING** (not just installed). Verify with: `docker ps`
2. Build the Docker image first (see Terminal 1 below)

**Terminal 1 - Build the Docker image:**
```bash
cd servers/src/git
docker build -t mcp/git .
```

**Terminal 2 - Run the analyzer:**

**Using VS Code:** Right-click on `GitRepositoryAnalyzer.java` and select **"Run Java"**.

**Using Maven:**
```bash
export GITHUB_TOKEN=your_token_here
cd 05-mcp
mvn compile exec:java -Dexec.mainClass=com.example.langchain4j.mcp.GitRepositoryAnalyzer
```

The application launches a Docker container, mounts your repository, and analyzes the repository structure and contents through the AI agent.

## Key Concepts

**Transport Selection**

Choose based on where your tools live:
- Remote services → Streamable HTTP
- Local file system → Stdio
- Complex dependencies → Docker

**Tool Discovery**

MCP clients automatically discover available tools when connecting. Your AI agent sees tool descriptions and decides which ones to use based on the user's request.

**Session Management**

Streamable HTTP transport maintains sessions, allowing stateful interactions with remote servers. Stdio and Docker transports are typically stateless.

**Cross-Platform Considerations**

The examples handle platform differences automatically (Windows vs Unix command differences, path conversions for Docker). This is important for production deployments across different environments.

## When to Use MCP

**Use MCP when:**
- You want to leverage existing tool ecosystems
- Building tools that multiple applications will use
- Integrating third-party services with standard protocols
- You need to swap tool implementations without code changes

**Use custom tools (Module 04) when:**
- Building application-specific functionality
- Performance is critical (MCP adds overhead)
- Your tools are simple and won't be reused
- You need complete control over execution


## MCP Ecosystem

The Model Context Protocol is an open standard with a growing ecosystem:

- Official MCP servers for common tasks (filesystem, Git, databases)
- Community-contributed servers for various services
- Standardized tool descriptions and schemas
- Cross-framework compatibility (works with any MCP client)

This standardization means tools built for one AI application work with others, creating a shared ecosystem of capabilities.

## Congratulations!

You've completed the LangChain4j for Beginners course. You've learned:

- How to build conversational AI with memory (Module 01)
- Prompt engineering patterns for different tasks (Module 02)
- Grounding responses in your documents with RAG (Module 03)
- Creating AI agents with custom tools (Module 04)
- Integrating standardized tools through MCP (Module 05)

You now have the foundation to build production AI applications. The concepts you've learned apply regardless of specific frameworks or models - they're fundamental patterns in AI engineering.

### What's Next?

After completing the modules, explore the [Testing Guide](../docs/TESTING.md) to see LangChain4j testing concepts in action.

**Official Resources:**
- [LangChain4j Documentation](https://docs.langchain4j.dev/) - Comprehensive guides and API reference
- [LangChain4j GitHub](https://github.com/langchain4j/langchain4j) - Source code and examples
- [LangChain4j Tutorials](https://docs.langchain4j.dev/tutorials/) - Step-by-step tutorials for various use cases

Thank you for completing this course!

---

**Navigation:** [← Previous: Module 04 - Tools](../04-tools/README.md) | [Back to Main](../README.md)
