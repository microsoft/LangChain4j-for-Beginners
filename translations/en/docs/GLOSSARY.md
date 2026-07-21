# LangChain4j Glossary

## Table of Contents

- [Core Concepts](#core-concepts)
- [LangChain4j Components](#langchain4j-components)
- [AI/ML Concepts](#aiml-concepts)
- [Guardrails](#guardrails)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agents and Tools](#agents-and-tools---module-04)
- [Agentic Module](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Services](#azure-services---module-01)
- [Testing and Development](#testing-and-development---testing-guide)

Quick reference for terms and concepts used throughout the course.

## Core Concepts

**AI Agent** - System that uses AI to reason and act autonomously. [Module 04](../04-tools/README.md)

**Chain** - Sequence of operations where output feeds into the next step.

**Chunking** - Breaking documents into smaller pieces. Typical: 300-500 tokens with overlap. [Module 03](../03-rag/README.md)

**Context Window** - Maximum tokens a model can process. GPT-5.2: 400K tokens (up to 272K input, 128K output).

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

**Reasoning Effort** - GPT-5.2 parameter controlling thinking depth. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - Controls output randomness. Low=deterministic, high=creative.

**Vector Database** - Specialized database for embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Performing tasks without examples. [Module 02](../02-prompt-engineering/README.md)

## Guardrails

**Defense in Depth** - Multi-layer security approach combining application-level guardrails with provider safety filters.

**Hard Block** - Provider throws HTTP 400 error for severe content violations.

**InputGuardrail** - LangChain4j interface for validating user input before it reaches the LLM. Saves cost and latency by blocking harmful prompts early.

**InputGuardrailResult** - Return type for guardrail validation: `success()` or `fatal("reason")`.

**OutputGuardrail** - Interface for validating AI responses before returning to users.

**Provider Safety Filters** - Built-in content filters from AI providers (e.g., Azure OpenAI) that catch violations at the API level.

**Soft Refusal** - Model politely declines to answer without throwing an error.

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Step-by-step reasoning for better accuracy.

**Constrained Output** - Enforcing specific format or structure.

**High Eagerness** - GPT-5.2 pattern for thorough reasoning.

**Low Eagerness** - GPT-5.2 pattern for quick answers.

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

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - Marks interfaces as AI agents with declarative behavior definition.

**Agent Listener** - Hook for monitoring agent execution via `beforeAgentInvocation()` and `afterAgentInvocation()`.

**Agentic Scope** - Shared memory where agents store outputs using `outputKey` for downstream agents to consume.

**AgenticServices** - Factory for creating agents using `agentBuilder()` and `supervisorBuilder()`.

**Conditional Workflow** - Route based on conditions to different specialist agents.

**Human-in-the-Loop** - Workflow pattern adding human checkpoints for approval or content review.

**langchain4j-agentic** - Maven dependency for declarative agent building (experimental).

**Loop Workflow** - Iterate agent execution until a condition is met (e.g., quality score ≥ 0.8).

**outputKey** - Agent annotation parameter specifying where results are stored in Agentic Scope.

**Parallel Workflow** - Run multiple agents simultaneously for independent tasks.

**Response Strategy** - How supervisor formulates final answer: LAST, SUMMARY, or SCORED.

**Sequential Workflow** - Execute agents in order where output flows to the next step.

**Supervisor Agent Pattern** - Advanced agentic pattern where a supervisor LLM dynamically decides which sub-agents to invoke.

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven dependency for MCP integration in LangChain4j.

**MCP** - Model Context Protocol: standard for connecting AI apps to external tools. Build once, use everywhere.

**MCP Client** - Application that connects to MCP servers to discover and use tools.

**MCP Server** - Service exposing tools via MCP with clear descriptions and parameter schemas.

**McpToolProvider** - LangChain4j component that wraps MCP tools for use in AI services and agents.

**McpTransport** - Interface for MCP communication. Implementations include Stdio and HTTP.

**Stdio Transport** - Local process transport via stdin/stdout. Useful for filesystem access or command-line tools.

**StdioMcpTransport** - LangChain4j implementation spawning MCP server as subprocess.

**Tool Discovery** - Client queries server for available tools with descriptions and schemas.

## Azure Services - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud search with vector capabilities. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Deploys Azure resources.

**Azure OpenAI** - Microsoft's enterprise AI service.

**Bicep** - Azure infrastructure-as-code language. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Name for model deployment in Azure.

**GPT-5.2** - Latest OpenAI model with reasoning control. [Module 02](../02-prompt-engineering/README.md)

## Testing and Development - [Testing Guide](TESTING.md)

**Dev Container** - Containerized development environment. [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Testing with in-memory storage.

**Integration Testing** - Testing with real infrastructure.

**Maven** - Java build automation tool.

**Mockito** - Java mocking framework.

**Spring Boot** - Java application framework. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:
This document has been translated using AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). While we strive for accuracy, please be aware that automated translations may contain errors or inaccuracies. The original document in its native language should be considered the authoritative source. For critical information, professional human translation is recommended. We are not liable for any misunderstandings or misinterpretations arising from the use of this translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->