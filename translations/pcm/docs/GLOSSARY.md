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

Quick reference for terms and concepts wey dem use throughout di course.

## Core Concepts

**AI Agent** - System wey dey use AI take reason and act on im own. [Module 04](../04-tools/README.md)

**Chain** - Sequence of operations wey output dey feed into di next step.

**Chunking** - Breaking documents into smaller pieces dem. Typical: 300-500 tokens wit overlap. [Module 03](../03-rag/README.md)

**Context Window** - Maximum tokens wey model fit process. GPT-5.2: 400K tokens (up to 272K input, 128K output).

**Embeddings** - Numerical vectors wey dey represent text meaning. [Module 03](../03-rag/README.md)

**Function Calling** - Model dey generate structured requests to call external functions. [Module 04](../04-tools/README.md)

**Hallucination** - When models dey generate wrong but e fit make sense information.

**Prompt** - Text input wey you dey give language model. [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - Search by meaning wey dey use embeddings, no be keywords. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: no memory. Stateful: e dey maintain conversation history. [Module 01](../01-introduction/README.md)

**Tokens** - Basic text units wey models dey process. E dey affect costs and limits. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Sequential tool execution wey output dey guide next call. [Module 04](../04-tools/README.md)

## LangChain4j Components

**AiServices** - E dey create type-safe AI service interfaces.

**OpenAiOfficialChatModel** - Unified client for OpenAI and Azure OpenAI models.

**OpenAiOfficialEmbeddingModel** - E dey create embeddings dey use OpenAI Official client (e support both OpenAI and Azure OpenAI).

**ChatModel** - Core interface for language models.

**ChatMemory** - E dey maintain conversation history.

**ContentRetriever** - E dey find relevant document chunks for RAG.

**DocumentSplitter** - E dey break documents into chunks.

**EmbeddingModel** - E dey convert text into numerical vectors.

**EmbeddingStore** - E dey store and retrieve embeddings.

**MessageWindowChatMemory** - E dey maintain sliding window of recent messages.

**PromptTemplate** - E dey create reusable prompts with `{{variable}}` placeholders.

**TextSegment** - Text chunk with metadata. E dey use for RAG.

**ToolExecutionRequest** - Na tool execution request e represent.

**UserMessage / AiMessage / SystemMessage** - Different types of conversation message.

## AI/ML Concepts

**Few-Shot Learning** - To provide examples inside prompt. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI models wey dem train on plenty text data.

**Reasoning Effort** - GPT-5.2 parameter wey dey control how deep e go reason. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - E dey control how random output go be. Low na deterministic, high na creative.

**Vector Database** - Specialized database for embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - To perform task without examples. [Module 02](../02-prompt-engineering/README.md)

## Guardrails

**Defense in Depth** - Multi-layer security approach wey combine application-level guardrails with provider safety filters.

**Hard Block** - Provider go throw HTTP 400 error if content break serious rule.

**InputGuardrail** - LangChain4j interface wey dey validate user input before e reach LLM. E dey save cost and latency by blocking harmful prompts early.

**InputGuardrailResult** - Na return type for guardrail validation: `success()` or `fatal("reason")`.

**OutputGuardrail** - Interface wey validate AI responses before e go return to users.

**Provider Safety Filters** - Built-in content filters from AI providers (for example Azure OpenAI) wey dey catch violations for API level.

**Soft Refusal** - Model dey politely refuse answer without throwing error.

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Step-by-step reasoning for better accuracy.

**Constrained Output** - To enforce specific format or structure.

**High Eagerness** - GPT-5.2 pattern for serious thorough reasoning.

**Low Eagerness** - GPT-5.2 pattern for quick answers.

**Multi-Turn Conversation** - To maintain context across multiple exchanges.

**Role-Based Prompting** - To set model persona through system messages.

**Self-Reflection** - Model go check and improve im output.

**Structured Analysis** - Fixed evaluation framework.

**Task Execution Pattern** - Plan → Execute → Summarize.

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Load → chunk → embed → store.

**In-Memory Embedding Store** - Non-persistent storage wey dem dey use for testing.

**RAG** - E combine retrieval with generation to ground responses.

**Similarity Score** - Measure (0-1) wey show semantic similarity.

**Source Reference** - Metadata about di content wey dem retrieve.

## Agents and Tools - [Module 04](../04-tools/README.md)

**@Tool Annotation** - E dey mark Java methods as AI-callable tools.

**ReAct Pattern** - Reason → Act → Observe → Repeat.

**Session Management** - E dey separate contexts for different users.

**Tool** - Na function wey AI agent fit call.

**Tool Description** - Documentation about tool purpose and parameters.

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - E dey mark interfaces as AI agents with declarative behavior definition.

**Agent Listener** - Hook wey dey monitor agent execution via `beforeAgentInvocation()` and `afterAgentInvocation()`.

**Agentic Scope** - Shared memory wey agents dey store outputs using `outputKey` for downstream agents to use.

**AgenticServices** - Factory to create agents dey use `agentBuilder()` and `supervisorBuilder()`.

**Conditional Workflow** - Route based on conditions go different specialist agents.

**Human-in-the-Loop** - Workflow pattern wey add human checkpoint for approval or content review.

**langchain4j-agentic** - Maven dependency for declarative agent building (experimental).

**Loop Workflow** - To repeat agent execution till condition meet (for example quality score ≥ 0.8).

**outputKey** - Agent annotation parameter wey tell where dem go store results inside Agentic Scope.

**Parallel Workflow** - To run multiple agents together for independent tasks.

**Response Strategy** - How supervisor go arrange final answer: LAST, SUMMARY, or SCORED.

**Sequential Workflow** - To run agents in order wey output flow go next step.

**Supervisor Agent Pattern** - Advanced agentic pattern wey supervisor LLM go dynamically decide which sub-agents to invoke.

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven dependency for MCP integration for LangChain4j.

**MCP** - Model Context Protocol: na standard to connect AI apps to external tools. Build once, use everywhere.

**MCP Client** - Application wey connect to MCP servers to find and use tools.

**MCP Server** - Service wey expose tools via MCP with clear descriptions and parameter schemas.

**McpToolProvider** - LangChain4j component wey dey wrap MCP tools to use for AI services and agents.

**McpTransport** - Interface for MCP communication. Implementation include Stdio and HTTP.

**Stdio Transport** - Local process transport wey use stdin/stdout. E good for filesystem access or command-line tools.

**StdioMcpTransport** - LangChain4j implementation wey dey launch MCP server as subprocess.

**Tool Discovery** - Client dey ask server for available tools with descriptions and schemas.

## Azure Services - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud search wey get vector capabilities. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - E dey deploy Azure resources.

**Azure OpenAI** - Microsoft's enterprise AI service.

**Bicep** - Azure infrastructure-as-code language. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Name wey you go take deploy model for Azure.

**GPT-5.2** - Latest OpenAI model wey get reasoning control. [Module 02](../02-prompt-engineering/README.md)

## Testing and Development - [Testing Guide](TESTING.md)

**Dev Container** - Containerized development environment. [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Testing wey dey use in-memory storage.

**Integration Testing** - Testing with real infrastructure.

**Maven** - Java build automation tool.

**Mockito** - Java mocking framework.

**Spring Boot** - Java application framework. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:
Dis document don translate wit AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). Even tho we dey try make am correct, abeg make you know say automated translation fit get errors or mistakes. Di original document for dia own language na im be di correct source. For important info, make person wey sabi human translation do am. We no go responsible for any misunderstanding or wrong understanding wey fit happen because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->