# Module 00: Quick Start

## Table of Contents

- [Introduction](#introduction)
- [What is LangChain4j?](#what-is-langchain4j)
- [LangChain4j Dependencies](#langchain4j-dependencies)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
  - [1. Get Your GitHub Token](#1-get-your-github-token)
  - [2. Set Your Token](#2-set-your-token)
- [Run the Examples](#run-the-examples)
  - [1. Basic Chat](#1-basic-chat)
  - [2. Prompt Patterns](#2-prompt-patterns)
  - [3. Function Calling](#3-function-calling)
  - [4. Document Q&A (RAG)](#4-document-qa-rag)
- [What Each Example Shows](#what-each-example-shows)
- [Next Steps](#next-steps)

## Introduction

This quickstart is meant to get you up and running with LangChain4j as quickly as possible. It covers the absolute basics of building AI applications with LangChain4j and GitHub Models. In the next modules you'll use Azure OpenAI with LangChain4j to build more advanced applications.

## What is LangChain4j?

LangChain4j is a Java library that simplifies building AI-powered applications. Instead of dealing with HTTP clients and JSON parsing, you work with clean Java APIs. 

The "chain" in LangChain refers to chaining together multiple components - you might chain a prompt to a model to a parser, or chain multiple AI calls together where one output feeds into the next input. This quick start focuses on the fundamentals before exploring more complex chains.

<img src="images/langchain-concept.png" alt="LangChain4j Chaining Concept" width="800"/>

*Chaining components in LangChain4j - building blocks connect to create powerful AI workflows*

We'll use three core components:

**ChatLanguageModel** - The interface for AI model interactions. Call `model.chat("prompt")` and get a response string. We use `OpenAiChatModel` which works with OpenAI-compatible endpoints like GitHub Models.

**AiServices** - Creates type-safe AI service interfaces. Define methods, annotate them with `@Tool`, and LangChain4j handles the orchestration. The AI automatically calls your Java methods when needed.

**MessageWindowChatMemory** - Maintains conversation history. Without this, each request is independent. With it, the AI remembers previous messages and maintains context across multiple turns.

<img src="images/architecture.png" alt="LangChain4j Architecture" width="800"/>

*LangChain4j architecture - core components working together to power your AI applications*

## LangChain4j Dependencies

This quick start uses two Maven dependencies in the [`pom.xml`](pom.xml):

```xml
<!-- Core LangChain4j library -->
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j</artifactId> <!-- Inherited from BOM in root pom.xml -->
</dependency>

<!-- OpenAI integration (works with GitHub Models) -->
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-open-ai</artifactId> <!-- Inherited from BOM in root pom.xml -->
</dependency>
```

The `langchain4j-open-ai` module provides the `OpenAiChatModel` class that connects to OpenAI-compatible APIs. GitHub Models uses the same API format, so no special adapter is needed - just point the base URL to `https://models.github.ai/inference`.

## Prerequisites

**Using the Dev Container?** Java and Maven are already installed. You only need a GitHub Personal Access Token.

**Local Development:**
- Java 21+, Maven 3.9+
- GitHub Personal Access Token (instructions below)

## Setup

### 1. Get Your GitHub Token

1. Go to [GitHub Settings → Personal Access Tokens](https://github.com/settings/personal-access-tokens)
2. Click "Generate new token"
3. Set a descriptive name (e.g., "LangChain4j Demo")
4. Set expiration (7 days recommended)
5. Under "Account permissions", find "Models" and set to "Read-only"
6. Click "Generate token"
7. Copy and save your token - you won't see it again

### 2. Set Your Token

**Option 1: Using VS Code (Recommended)**

If you're using VS Code, add your token to the `.env` file in the project root:

If the `.env` file does not exist, copy `.env.example` to `.env` or create a new `.env` file in the project root.
```bash
# In /workspaces/LangChain4j-for-Beginners/.env
GITHUB_TOKEN=your_token_here
```

Then you can simply right-click on any demo file (e.g., `BasicChatDemo.java`) in the Explorer and select **"Run Java"** or use the launch configurations from the Run and Debug panel.

**Option 2: Using Terminal**

Set the token as an environment variable:

```bash
export GITHUB_TOKEN="your_token_here"  # macOS/Linux
$env:GITHUB_TOKEN="your_token_here"    # Windows PowerShell
```

## Run the Examples

**Using VS Code:** Simply right-click on any demo file in the Explorer and select **"Run Java"**, or use the launch configurations from the Run and Debug panel (make sure you've added your token to the `.env` file first).

**Using Maven:** Alternatively, you can run from the command line:

### 1. Basic Chat

```bash
mvn compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.BasicChatDemo"
```

### 2. Prompt Patterns

```bash
mvn compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.PromptEngineeringDemo"
```

Shows zero-shot, few-shot, chain-of-thought, and role-based prompting.

### 3. Function Calling

```bash
mvn compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.ToolIntegrationDemo"
```

AI automatically calls your Java methods when needed.

### 4. Document Q&A (RAG)

```bash
mvn compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.SimpleReaderDemo"
```

Ask questions about content in `document.txt`.

## What Each Example Shows

**Basic Chat** - [BasicChatDemo.java](src/main/java/com/example/langchain4j/quickstart/BasicChatDemo.java)

Start here to see LangChain4j at its simplest. You'll create an `OpenAiChatModel`, send a prompt with `.chat()`, and get back a response. This demonstrates the foundation: how to initialize models with custom endpoints and API keys. Once you understand this pattern, everything else builds on it.

```java
ChatLanguageModel model = OpenAiChatModel.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(System.getenv("GITHUB_TOKEN"))
    .modelName("gpt-4.1-nano")
    .build();

String response = model.chat("What is LangChain4j?");
System.out.println(response);
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`BasicChatDemo.java`](src/main/java/com/example/langchain4j/quickstart/BasicChatDemo.java) and ask:
> - "How would I switch from GitHub Models to Azure OpenAI in this code?"
> - "What other parameters can I configure in OpenAiChatModel.builder()?"
> - "How do I add streaming responses instead of waiting for the complete response?"
> - "What's the difference between logRequests and logResponses, and when should I use them?"

**Prompt Engineering** - [PromptEngineeringDemo.java](src/main/java/com/example/langchain4j/quickstart/PromptEngineeringDemo.java)

Now that you know how to talk to a model, let's explore what you say to it. This demo uses the same model setup but shows four different prompting patterns. Try zero-shot prompts for direct instructions, few-shot prompts that learn from examples, chain-of-thought prompts that reveal reasoning steps, and role-based prompts that set context. You'll see how the same model gives dramatically different results based on how you frame your request.

```java
PromptTemplate template = PromptTemplate.from(
    "What's the best time to visit {{destination}} for {{activity}}?"
);

Prompt prompt = template.apply(Map.of(
    "destination", "Paris",
    "activity", "sightseeing"
));

String response = model.chat(prompt.text());
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`PromptEngineeringDemo.java`](src/main/java/com/example/langchain4j/quickstart/PromptEngineeringDemo.java) and ask:
> - "What's the difference between zero-shot and few-shot prompting, and when should I use each?"
> - "How does the temperature parameter affect the model's responses?"
> - "What are some techniques to prevent prompt injection attacks in production?"
> - "How can I create reusable PromptTemplate objects for common patterns?"

**Tool Integration** - [ToolIntegrationDemo.java](src/main/java/com/example/langchain4j/quickstart/ToolIntegrationDemo.java)

This is where LangChain4j gets powerful. You'll use `AiServices` to create an AI assistant that can call your Java methods. Just annotate methods with `@Tool("description")` and LangChain4j handles the rest - the AI automatically decides when to use each tool based on what the user asks. This demonstrates function calling, a key technique for building AI that can take actions, not just answer questions.

```java
@Tool("Performs addition of two numeric values")
public double add(double a, double b) {
    return a + b;
}

MathAssistant assistant = AiServices.create(MathAssistant.class, model);
String response = assistant.chat("What is 25 plus 17?");
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`ToolIntegrationDemo.java`](src/main/java/com/example/langchain4j/quickstart/ToolIntegrationDemo.java) and ask:
> - "How does the @Tool annotation work and what does LangChain4j do with it behind the scenes?"
> - "Can the AI call multiple tools in sequence to solve complex problems?"
> - "What happens if a tool throws an exception - how should I handle errors?"
> - "How would I integrate a real API instead of this calculator example?"

**Document Q&A (RAG)** - [SimpleReaderDemo.java](src/main/java/com/example/langchain4j/quickstart/SimpleReaderDemo.java)

Here you'll see the foundation of RAG (retrieval-augmented generation). Instead of relying on the model's training data, you load content from [`document.txt`](document.txt) and include it in the prompt. The AI answers based on your document, not its general knowledge. This is the first step toward building systems that can work with your own data.

```java
Document document = FileSystemDocumentLoader.loadDocument("document.txt");
String content = document.text();

String prompt = "Based on this document: " + content + 
                "\nQuestion: What is the main topic?";
String response = model.chat(prompt);
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`SimpleReaderDemo.java`](src/main/java/com/example/langchain4j/quickstart/SimpleReaderDemo.java) and ask:
> - "How does RAG prevent AI hallucinations compared to using the model's training data?"
> - "What's the difference between this simple approach and using vector embeddings for retrieval?"
> - "How would I scale this to handle multiple documents or larger knowledge bases?"
> - "What are best practices for structuring the prompt to ensure the AI uses only the provided context?"

## Troubleshooting

### Error: "GITHUB_TOKEN not found"

**Problem:** Environment variable not set or not accessible.

**Solutions:**

1. **VS Code users:**
   - Ensure `.env` file is in the project **root directory** (`LangChain4j-for-Beginners/.env`), not in the module folder
   - Restart VS Code after creating the `.env` file
   - Check file contents: `GITHUB_TOKEN=your_token_without_quotes`

2. **Terminal users:**
   - Verify the variable is set: `echo $GITHUB_TOKEN` (macOS/Linux) or `echo $env:GITHUB_TOKEN` (Windows PowerShell)
   - If empty, re-run the export/set command in your current shell session
   - Note: Environment variables are session-specific - you'll need to set them again in new terminal windows

### Error: Maven command fails on Windows PowerShell

**Problem:** PowerShell interprets `-Dexec.mainClass` parameter incorrectly.

**Solution:** Use quotes around the Maven parameter:
```powershell
mvn compile exec:java "-Dexec.mainClass=com.example.langchain4j.quickstart.BasicChatDemo"
```

### Error: "Cannot find file document.txt"

**Problem:** Running the demo from the wrong directory.

**Solution:** Make sure you're in the `00-quick-start` directory:
```bash
cd 00-quick-start
mvn compile exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.SimpleReaderDemo"
```

### Error: "Unauthorized" or "Invalid authentication credentials"

**Problem:** GitHub token is invalid, expired, or doesn't have correct permissions.

**Solutions:**
1. Verify your token has the **Models (Read-only)** permission
2. Check if the token has expired
3. Generate a new token and update your `.env` file or environment variable
4. Make sure there are no extra spaces or quotes around the token value

### Error: Rate limiting or "Too many requests"

**Problem:** GitHub Models has rate limits for free tier usage.

**Solution:**
- Wait a few minutes before trying again
- The models use `gpt-4.1-nano` which has generous limits for learning
- If persistent, consider using Azure OpenAI (covered in Module 01)

### Maven dependency download is slow or failing

**Problem:** Network issues or Maven repository connectivity.

**Solutions:**
1. Check your internet connection
2. Try running `mvn clean compile` again - Maven will resume downloads
3. If using a corporate network, you may need proxy settings in `~/.m2/settings.xml`
4. Try a different Maven mirror if downloads are consistently slow

### Need More Help?

- Check the comprehensive [SETUP.md](../SETUP.md) guide in the project root
- Join the [Azure AI Foundry Discord](https://aka.ms/foundry/discord)
- Visit the [Azure AI Foundry Developer Forum](https://aka.ms/foundry/forum)

## Next Steps

**Next Module:** [01-introduction - Getting Started with LangChain4j and gpt-5 on Azure](../01-introduction/README.md)

---

**Navigation:** [← Back to Main](../README.md) | [Next: Module 01 - Introduction →](../01-introduction/README.md)