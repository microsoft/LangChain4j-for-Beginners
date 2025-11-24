# LangChain4j Glossary

## Table of Contents

- [Core Concepts](#core-concepts)
- [LangChain4j Components](#langchain4j-components)
- [AI/ML Concepts](#aiml-concepts)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agents and Tools](#agents-and-tools---module-04)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Services](#azure-services---module-01)
- [Testing and Development](#testing-and-development---testing-guide)

Quick reference for terms and concepts used throughout the course.

## Core Concepts

**AI Agent** - System that uses AI to reason and act autonomously. [Module 04](../04-tools/README.md)

**Chain** - Sequence of operations where output feeds into the next step.

**Chunking** - Breaking documents into smaller pieces. Typical: 300-500 tokens with overlap. [Module 03](../03-rag/README.md)

**Context Window** - Maximum tokens a model can process. GPT-5: 400K tokens.

**Embeddings** - Numerical vectors representing text meaning. [Module 03](../03-rag/README.md)

**Function Calling** - Model generates structured requests to call external functions. [Module 04](../04-tools/README.md)

**Hallucination** - When models generate incorrect but plausible information.

**Prompt** - Text input to a language model. [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - Search by meaning using embeddings, not keywords. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: no memory. Stateful: maintains conversation history. [Module 01](../01-introduction/README.md)

**Tokens** - Basic text units models process. Affects costs and limits. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Sequential tool execution where output informs next call. [Module 04](../04-tools/README.md)

## LangChain4j Components

**AiServices** - Creates type-safe AI service interfaces.

**OpenAiOfficialChatModel** - Unified client for OpenAI and Azure OpenAI models.

**OpenAiOfficialEmbeddingModel** - Creates embeddings using OpenAI Official client (supports both OpenAI and Azure OpenAI).

**ChatModel** - Core interface for language models.

**ChatMemory** - Maintains conversation history.

**ContentRetriever** - Finds relevant document chunks for RAG.

**DocumentSplitter** - Breaks documents into chunks.

**EmbeddingModel** - Converts text into numerical vectors.

**EmbeddingStore** - Stores and retrieves embeddings.

**MessageWindowChatMemory** - Maintains sliding window of recent messages.

**PromptTemplate** - Creates reusable prompts with `{{variable}}` placeholders.

**TextSegment** - Text chunk with metadata. Used in RAG.

**ToolExecutionRequest** - Represents tool execution request.

**UserMessage / AiMessage / SystemMessage** - Conversation message types.

## AI/ML Concepts

**Few-Shot Learning** - Providing examples in prompts. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI models trained on vast text data.

**Reasoning Effort** - GPT-5 parameter controlling thinking depth. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - Controls output randomness. Low=deterministic, high=creative.

**Vector Database** - Specialized database for embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Performing tasks without examples. [Module 02](../02-prompt-engineering/README.md)

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Step-by-step reasoning for better accuracy.

**Constrained Output** - Enforcing specific format or structure.

**High Eagerness** - GPT-5 pattern for thorough reasoning.

**Low Eagerness** - GPT-5 pattern for quick answers.

**Multi-Turn Conversation** - Maintaining context across exchanges.

**Role-Based Prompting** - Setting model persona via system messages.

**Self-Reflection** - Model evaluates and improves its output.

**Structured Analysis** - Fixed evaluation framework.

**Task Execution Pattern** - Plan → Execute → Summarize.

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Load → chunk → embed → store.

**In-Memory Embedding Store** - Non-persistent storage for testing.

**RAG** - Combines retrieval with generation to ground responses.

**Similarity Score** - Measure (0-1) of semantic similarity.

**Source Reference** - Metadata about retrieved content.

## Agents and Tools - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Marks Java methods as AI-callable tools.

**ReAct Pattern** - Reason → Act → Observe → Repeat.

**Session Management** - Separate contexts for different users.

**Tool** - Function an AI agent can call.

**Tool Description** - Documentation of tool purpose and parameters.

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**Docker Transport** - MCP server in Docker container.

**MCP** - Standard for connecting AI apps to external tools.

**MCP Client** - Application that connects to MCP servers.

**MCP Server** - Service exposing tools via MCP.

**Server-Sent Events (SSE)** - Server-to-client streaming over HTTP.

**Stdio Transport** - Server as subprocess via stdin/stdout.

**Streamable HTTP Transport** - HTTP with SSE for real-time communication.

**Tool Discovery** - Client queries server for available tools.

## Azure Services - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud search with vector capabilities. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Deploys Azure resources.

**Azure OpenAI** - Microsoft's enterprise AI service.

**Bicep** - Azure infrastructure-as-code language. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Name for model deployment in Azure.

**GPT-5** - Latest OpenAI model with reasoning control. [Module 02](../02-prompt-engineering/README.md)

## Testing and Development - [Testing Guide](TESTING.md)

**Dev Container** - Containerized development environment. [Configuration](../.devcontainer/devcontainer.json)

**GitHub Models** - Free AI model playground. [Module 00](../00-quick-start/README.md)

**In-Memory Testing** - Testing with in-memory storage.

**Integration Testing** - Testing with real infrastructure.

**Maven** - Java build automation tool.

**Mockito** - Java mocking framework.

**Spring Boot** - Java application framework. [Module 01](../01-introduction/README.md)

**Testcontainers** - Docker containers in tests.
