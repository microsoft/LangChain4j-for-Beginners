# LangChain4j 词汇表

## 目录

- [核心概念](#核心概念)
- [LangChain4j 组件](#langchain4j-组件)
- [AI/ML 概念](#aiml-概念)
- [防护机制](#防护机制)
- [提示工程](#prompt-engineering---module-02)
- [RAG（检索增强生成）](#rag-retrieval-augmented-generation---module-03)
- [代理与工具](#agents-and-tools---module-04)
- [代理模块](#agentic-module---module-05)
- [模型上下文协议（MCP）](#model-context-protocol-mcp---module-05)
- [Azure 服务](#azure-services---module-01)
- [测试与开发](#testing-and-development---testing-guide)

课程中使用术语和概念的快速参考。

## 核心概念

**AI Agent** - 使用 AI 进行推理和自主行动的系统。[模块 04](../04-tools/README.md)

**Chain** - 输出作为下一步输入的操作序列。

**Chunking** - 将文档拆分为更小部分。典型为 300-500 令牌，带重叠。[模块 03](../03-rag/README.md)

**Context Window** - 模型可处理的最大令牌数。GPT-5.2：400K 令牌（最多 272K 输入，128K 输出）。

**Embeddings** - 表示文本含义的数值向量。[模块 03](../03-rag/README.md)

**Function Calling** - 模型生成结构化请求调用外部函数。[模块 04](../04-tools/README.md)

**Hallucination** - 模型生成错误但看似合理的信息。

**Prompt** - 语言模型的文本输入。[模块 02](../02-prompt-engineering/README.md)

**Semantic Search** - 利用嵌入进行基于意义的搜索，而非基于关键词。[模块 03](../03-rag/README.md)

**Stateful vs Stateless** - 无状态：无记忆；有状态：维护对话历史。[模块 01](../01-introduction/README.md)

**Tokens** - 模型处理的基本文本单位。影响成本和限制。[模块 01](../01-introduction/README.md)

**Tool Chaining** - 顺序执行工具，输出用作下一个调用的信息。[模块 04](../04-tools/README.md)

## LangChain4j 组件

**AiServices** - 创建类型安全的 AI 服务接口。

**OpenAiOfficialChatModel** - OpenAI 和 Azure OpenAI 模型的统一客户端。

**OpenAiOfficialEmbeddingModel** - 使用 OpenAI 官方客户端创建嵌入（支持 OpenAI 和 Azure OpenAI）。

**ChatModel** - 语言模型的核心接口。

**ChatMemory** - 维护对话历史。

**ContentRetriever** - 查找 RAG 所需的相关文档块。

**DocumentSplitter** - 将文档拆分为块。

**EmbeddingModel** - 将文本转换为数值向量。

**EmbeddingStore** - 存储和检索嵌入。

**MessageWindowChatMemory** - 维护最近消息的滑动窗口。

**PromptTemplate** - 创建带有 `{{variable}}` 占位符的可重用提示。

**TextSegment** - 带元数据的文本块。用于 RAG。

**ToolExecutionRequest** - 表示工具执行请求。

**UserMessage / AiMessage / SystemMessage** - 对话消息类型。

## AI/ML 概念

**Few-Shot Learning** - 在提示中提供示例。[模块 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - 基于大量文本数据训练的 AI 模型。

**Reasoning Effort** - GPT-5.2 控制推理深度的参数。[模块 02](../02-prompt-engineering/README.md)

**Temperature** - 控制输出随机程度。低=确定性，高=创造性。

**Vector Database** - 用于嵌入的专用数据库。[模块 03](../03-rag/README.md)

**Zero-Shot Learning** - 无示例完成任务。[模块 02](../02-prompt-engineering/README.md)

## 防护机制

**Defense in Depth** - 多层安全方法，结合应用层防护和提供商安全过滤。

**Hard Block** - 提供商因严重内容违规返回 HTTP 400 错误。

**InputGuardrail** - LangChain4j 接口，用于在输入进入 LLM 前验证用户输入，节省成本和延迟。

**InputGuardrailResult** - 防护验证返回类型：`success()` 或 `fatal("reason")`。

**OutputGuardrail** - 验证 AI 回复的接口，防止违规输出给用户。

**Provider Safety Filters** - AI 提供商（如 Azure OpenAI）内置的内容过滤器，API 级别捕捉违规。

**Soft Refusal** - 模型礼貌拒绝回答，且不抛出错误。

## 提示工程 - [模块 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - 分步推理以提高准确度。

**Constrained Output** - 强制特定格式或结构。

**High Eagerness** - GPT-5.2 的全面推理模式。

**Low Eagerness** - GPT-5.2 的快速回答模式。

**Multi-Turn Conversation** - 跨轮保持上下文。

**Role-Based Prompting** - 通过系统消息设定模型角色。

**Self-Reflection** - 模型自我评估并改进输出。

**Structured Analysis** - 固定的评估框架。

**Task Execution Pattern** - 计划 → 执行 → 总结。

## RAG（检索增强生成） - [模块 03](../03-rag/README.md)

**Document Processing Pipeline** - 加载 → 拆分 → 嵌入 → 存储。

**In-Memory Embedding Store** - 用于测试的非持久存储。

**RAG** - 将检索与生成结合以增强响应可靠性。

**Similarity Score** - 表示语义相似度的分数（0-1）。

**Source Reference** - 检索内容的元数据信息。

## 代理与工具 - [模块 04](../04-tools/README.md)

**@Tool 注解** - 标记 Java 方法为 AI 可调用工具。

**ReAct Pattern** - 推理 → 行动 → 观察 → 重复。

**Session Management** - 不同用户分离上下文管理。

**Tool** - AI 代理可调用的功能。

**Tool Description** - 工具用途和参数的文档说明。

## 代理模块 - [模块 05](../05-mcp/README.md)

**@Agent 注解** - 标记接口为 AI 代理，支持声明式行为定义。

**Agent Listener** - 通过 `beforeAgentInvocation()` 和 `afterAgentInvocation()` 监控代理执行的挂钩。

**Agentic Scope** - 共享内存，代理使用 `outputKey` 存储输出以供下游代理使用。

**AgenticServices** - 使用 `agentBuilder()` 和 `supervisorBuilder()` 创建代理的工厂。

**Conditional Workflow** - 基于条件路由到不同领域专家代理。

**Human-in-the-Loop** - 增加人工检查站点的工作流程模式，用于审批或内容审核。

**langchain4j-agentic** - 用于声明式代理构建的 Maven 依赖（实验性）。

**Loop Workflow** - 代理执行迭代，直到满足条件（例如质量评分 ≥ 0.8）。

**outputKey** - 代理注解参数，指定结果存储在 Agentic Scope 的位置。

**Parallel Workflow** - 同时运行多个代理处理独立任务。

**Response Strategy** - 主管如何制定最终答案：LAST、SUMMARY 或 SCORED。

**Sequential Workflow** - 依次执行代理，输出用于下一步骤。

**Supervisor Agent Pattern** - 高级代理模式，主管 LLM 动态决定调用哪些子代理。

## 模型上下文协议（MCP） - [模块 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j 中 MCP 集成的 Maven 依赖。

**MCP** - 模型上下文协议：连接 AI 应用与外部工具的标准。一次构建，处处可用。

**MCP Client** - 连接 MCP 服务器以发现并使用工具的应用。

**MCP Server** - 通过 MCP 暴露工具，并提供清晰描述和参数模式的服务。

**McpToolProvider** - LangChain4j 组件，封装 MCP 工具供 AI 服务和代理使用。

**McpTransport** - MCP 通信接口。实现包括 Stdio 和 HTTP。

**Stdio Transport** - 通过 stdin/stdout 进行本地进程传输。适用于文件系统访问或命令行工具。

**StdioMcpTransport** - LangChain4j 实现，将 MCP 服务器作为子进程启动。

**Tool Discovery** - 客户端查询服务器，获取可用工具及其描述和模式。

## Azure 服务 - [模块 01](../01-introduction/README.md)

**Azure AI Search** - 具有向量功能的云搜索服务。[模块 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - 部署 Azure 资源的命令行工具。

**Azure OpenAI** - 微软的企业级 AI 服务。

**Bicep** - Azure 基础设施即代码语言。[基础架构指南](../01-introduction/infra/README.md)

**Deployment Name** - Azure 中模型部署名称。

**GPT-5.2** - 最新的 OpenAI 模型，支持推理控制。[模块 02](../02-prompt-engineering/README.md)

## 测试与开发 - [测试指南](TESTING.md)

**Dev Container** - 容器化开发环境。[配置](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - 使用内存存储进行测试。

**Integration Testing** - 使用真实基础设施进行测试。

**Maven** - Java 构建自动化工具。

**Mockito** - Java 模拟框架。

**Spring Boot** - Java 应用框架。[模块 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免责声明**：
本文件由 AI 翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 翻译完成。尽管我们力求准确，但请注意，自动翻译可能包含错误或不准确之处。原始语言版文件应视为权威来源。对于重要信息，建议使用专业人工翻译。我们对因使用本翻译而产生的任何误解或误释不承担责任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->