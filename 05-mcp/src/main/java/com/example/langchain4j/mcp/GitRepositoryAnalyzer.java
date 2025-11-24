package com.example.langchain4j.mcp;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.stdio.StdioMcpTransport;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolProvider;

import java.io.File;
import java.util.List;

/**
 * GitRepositoryAnalyzer - MCP Integration via Docker Transport
 * Run: mvn exec:java -Dexec.mainClass="com.example.langchain4j.mcp.GitRepositoryAnalyzer"
 * 
 * Demonstrates GitHub repository analysis using MCP git server.
 * 
 * This example shows how to use Docker-based MCP servers, mount volumes,
 * and perform repository analysis through AI with git tools.
 * 
 * Prerequisites:
 * - Docker installed and running
 * - mcp/git Docker image built
 * - GITHUB_TOKEN environment variable set
 * 
 * Build Docker image:
 * 1. Clone https://github.com/modelcontextprotocol/servers
 * 2. cd servers/src/git
 * 3. docker build -t mcp/git .
 * 
 * Key Concepts:
 * - Docker-based MCP server deployment
 * - Volume mounting for repository access
 * - Git operations through MCP tools
 * - Container lifecycle management
 * 
 * 💡 Ask GitHub Copilot:
 * - "How does Docker transport isolate MCP servers and what are the benefits?"
 * - "How do I configure volume mounts to share data between host and MCP containers?"
 * - "What are best practices for managing Docker-based MCP server lifecycles in production?"
 * - "How can I create custom Docker-based MCP servers for my own tools?"
 */
public class GitRepositoryAnalyzer {

    private static final String GITHUB_MODELS_URL = "https://models.github.ai/inference";
    private static final String MODEL_NAME = "gpt-4.1-nano";
    private static final String REPO_MOUNT_PATH = "/app/LangChain4j-for-Beginners";

    public static void main(String[] args) throws Exception {

        // Configure chat model
        ChatModel chatModel = buildChatModel();

        // Setup Docker-based MCP transport
        McpTransport dockerTransport = buildDockerTransport();

        // Initialize MCP client
        McpClient client = buildMcpClient(dockerTransport);

        // Create tool provider
        ToolProvider tools = McpToolProvider.builder()
                .mcpClients(List.of(client))
                .build();

        // Build AI service
        Bot assistant = AiServices.builder(Bot.class)
                .chatModel(chatModel)
                .toolProvider(tools)
                .build();

        try {
            String query = String.format(
                "Analyze the Git repository located at %s and provide a summary of its contents, structure, and any notable features.",
                REPO_MOUNT_PATH
            );
            String analysis = assistant.chat(query);
            System.out.println("Repository Analysis:");
            System.out.println(analysis);
        } finally {
            client.close();
        }
    }

    private static ChatModel buildChatModel() {
        return OpenAiOfficialChatModel.builder()
                .baseUrl(GITHUB_MODELS_URL)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName(MODEL_NAME)
                .build();
    }

    private static McpTransport buildDockerTransport() {
        // Determine project root directory (go up from 05-mcp to root)
        String workingDir = System.getProperty("user.dir");
        String projectRoot = workingDir;
        
        if (workingDir.endsWith("05-mcp")) {
            projectRoot = new File(workingDir)
                    .getParentFile()
                    .getAbsolutePath();
        }
        
        // Normalize path for Docker
        String dockerPath = projectRoot.replace("\\", "/");
        String volumeMapping = dockerPath + ":" + REPO_MOUNT_PATH;

        return new StdioMcpTransport.Builder()
                .command(List.of(
                    "docker", "run",
                    "-e", "GITHUB_PERSONAL_ACCESS_TOKEN=" + System.getenv("GITHUB_TOKEN"),
                    "-v", volumeMapping,
                    "-i", "mcp/git"
                ))
                .logEvents(true)
                .build();
    }

    private static McpClient buildMcpClient(McpTransport transport) {
        return new DefaultMcpClient.Builder()
                .transport(transport)
                .build();
    }
}
