# LangChain4j 詞彙表

## 目錄

- [核心概念](#核心概念)
- [LangChain4j 元件](#langchain4j-元件)
- [AI/ML 概念](#aiml-概念)
- [防護欄](#防護欄)
- [提示工程](#prompt-engineering---module-02)
- [RAG（檢索增強生成）](#rag-retrieval-augmented-generation---module-03)
- [代理和工具](#agents-and-tools---module-04)
- [Agentic 模組](#agentic-module---module-05)
- [模型上下文協定（MCP）](#model-context-protocol-mcp---module-05)
- [Azure 服務](#azure-services---module-01)
- [測試與開發](#testing-and-development---testing-guide)

快速參考課程中使用的術語和概念。

## 核心概念

**AI 代理** - 使用 AI 進行推理並自主行動的系統。[模組 04](../04-tools/README.md)

**鏈（Chain）** - 輸出作為下一步的輸入的一系列操作。

**拆塊（Chunking）** - 將文件拆分為較小部分。典型大小：300-500 個標記，帶有重疊。[模組 03](../03-rag/README.md)

<strong>上下文窗口</strong> - 模型可處理的最大標記數。GPT-5.2：400K 標記（輸入最高 272K，輸出最高 128K）。

**嵌入（Embeddings）** - 表示文本意義的數值向量。[模組 03](../03-rag/README.md)

<strong>函數調用</strong> - 模型生成結構化請求來調用外部函數。[模組 04](../04-tools/README.md)

**幻覺（Hallucination）** - 模型生成錯誤但貌似合理的信息。

**提示（Prompt）** - 輸入給語言模型的文本。[模組 02](../02-prompt-engineering/README.md)

<strong>語義搜索</strong> - 使用嵌入按意義進行搜索，而非關鍵字。[模組 03](../03-rag/README.md)

**有狀態 vs 無狀態** - 無狀態：無記憶；有狀態：保持對話記錄。[模組 01](../01-introduction/README.md)

**標記（Tokens）** - 模型處理的基本文本單位。影響成本和限制。[模組 01](../01-introduction/README.md)

<strong>工具鏈接</strong> - 按順序執行工具，其中輸出用於下一次調用。[模組 04](../04-tools/README.md)

## LangChain4j 元件

**AiServices** - 創建類型安全的 AI 服務介面。

**OpenAiOfficialChatModel** - 用於 OpenAI 和 Azure OpenAI 模型的統一客戶端。

**OpenAiOfficialEmbeddingModel** - 使用 OpenAI 官方客戶端創建嵌入（支援 OpenAI 和 Azure OpenAI）。

**ChatModel** - 語言模型的核心介面。

**ChatMemory** - 保持對話歷史。

**ContentRetriever** - 為 RAG 尋找相關文件塊。

**DocumentSplitter** - 將文件拆分為塊。

**EmbeddingModel** - 將文本轉換為數值向量。

**EmbeddingStore** - 存儲和檢索嵌入。

**MessageWindowChatMemory** - 保持最近消息的滑動窗口。

**PromptTemplate** - 使用 `{{variable}}` 佔位符創建可重用提示。

**TextSegment** - 帶有元資料的文本塊。用於 RAG。

**ToolExecutionRequest** - 代表工具執行請求。

**UserMessage / AiMessage / SystemMessage** - 對話消息類型。

## AI/ML 概念

**少量示例學習（Few-Shot Learning）** - 在提示中提供範例。[模組 02](../02-prompt-engineering/README.md)

**大型語言模型（LLM）** - 在大量文本資料上訓練的 AI 模型。

**推理力度（Reasoning Effort）** - GPT-5.2 中控制思考深度的參數。[模組 02](../02-prompt-engineering/README.md)

**溫度（Temperature）** - 控制輸出隨機性。低值=確定性，高值=創造性。

<strong>向量資料庫</strong> - 專為嵌入設計的資料庫。[模組 03](../03-rag/README.md)

**零樣本學習（Zero-Shot Learning）** - 無示例執行任務。[模組 02](../02-prompt-engineering/README.md)

## 防護欄

**深度防護（Defense in Depth）** - 多層安全策略，結合應用層防護欄與服務提供商安全過濾器。

**硬性阻擋（Hard Block）** - 嚴重內容違規時，供應商拋出 HTTP 400 錯誤。

**輸入防護欄（InputGuardrail）** - LangChain4j 介面，用於在輸入到 LLM 前驗證用戶輸入。提前阻擋有害提示，可節省成本和延遲。

**輸入防護欄結果（InputGuardrailResult）** - 防護欄驗證的返回類型：`success()` 或 `fatal("reason")`。

**輸出防護欄（OutputGuardrail）** - 驗證 AI 回應後，才返回給用戶的介面。

<strong>供應商安全過濾器</strong> - AI 供應商（例如 Azure OpenAI）在 API 級別捕捉違規內容的內建過濾器。

**軟性拒絕（Soft Refusal）** - 模型禮貌地拒絕回答，無錯誤拋出。

## 提示工程 - [模組 02](../02-prompt-engineering/README.md)

**思維鏈（Chain-of-Thought）** - 分步推理以提高準確性。

**受限輸出（Constrained Output）** - 強制特定格式或結構。

**高推理力度（High Eagerness）** - GPT-5.2 推理深入模式。

**低推理力度（Low Eagerness）** - GPT-5.2 快速回答模式。

**多輪對話（Multi-Turn Conversation）** - 保持交流上下文。

**角色基礎提示（Role-Based Prompting）** - 通過系統消息設定模型角色。

**自我反思（Self-Reflection）** - 模型評估並改進自身輸出。

**結構化分析（Structured Analysis）** - 固定的評估框架。

**任務執行模式（Task Execution Pattern）** - 計劃 → 執行 → 總結。

## RAG（檢索增強生成）- [模組 03](../03-rag/README.md)

<strong>文件處理管線</strong> - 載入 → 拆塊 → 嵌入 → 存儲。

<strong>記憶體內嵌入存儲</strong> - 非持久化存儲，用於測試。

**RAG** - 結合檢索和生成以根據來源回答。

<strong>相似度分數</strong> - 意義相似度度量（0-1）。

<strong>來源參考</strong> - 取回內容的元資料。

## 代理和工具 - [模組 04](../04-tools/README.md)

**@Tool 註解** - 標記 Java 方法為 AI 可調用工具。

**ReAct 模式** - 推理 → 行動 → 觀察 → 重複。

<strong>會話管理</strong> - 為不同用戶分離上下文。

**工具（Tool）** - AI 代理可調用的函數。

<strong>工具描述</strong> - 工具目的和參數的文檔。

## Agentic 模組 - [模組 05](../05-mcp/README.md)

**@Agent 註解** - 將介面標記為帶聲明式行為定義的 AI 代理。

**代理監聽器（Agent Listener）** - 通過 `beforeAgentInvocation()` 和 `afterAgentInvocation()` 監控代理執行的鉤子。

**Agentic 範圍** - 代理使用 `outputKey` 存儲輸出的共享記憶供下游代理使用。

**AgenticServices** - 使用 `agentBuilder()` 和 `supervisorBuilder()` 創建代理的工廠。

**條件工作流（Conditional Workflow）** - 根據條件路由到不同專家代理。

**人類介入環（Human-in-the-Loop）** - 工作流程模式，增加人類審核或內容檢查點。

**langchain4j-agentic** - 用於聲明式代理構建的 Maven 依賴（實驗性）。

**循環工作流（Loop Workflow）** - 迭代代理執行直到條件達成（如質量分 ≥ 0.8）。

**outputKey** - 代理註解參數，指定結果存放於 Agentic 範圍的位置。

**並行工作流（Parallel Workflow）** - 同時運行多個代理以執行獨立任務。

**回應策略（Response Strategy）** - 監督者形成最終答案的方式：LAST、SUMMARY 或 SCORED。

**序列工作流（Sequential Workflow）** - 按順序執行代理，輸出流向下一步。

**監督代理模式（Supervisor Agent Pattern）** - 高級 agentic 模式，由監督者 LLM 動態決定調用哪些子代理。

## 模型上下文協定（MCP）- [模組 05](../05-mcp/README.md)

**langchain4j-mcp** - 用於 LangChain4j 中 MCP 集成的 Maven 依賴。

**MCP** - 模型上下文協定：連接 AI 應用與外部工具的標準。一次構建，到處使用。

**MCP 客戶端** - 連接 MCP 服務器以發現和使用工具的應用。

**MCP 服務器** - 通過 MCP 對外暴露工具，提供清晰描述和參數結構。

**McpToolProvider** - LangChain4j 元件，將 MCP 工具包裝為 AI 服務和代理可用。

**McpTransport** - MCP 通信介面。實現包括 Stdio 和 HTTP。

**Stdio 傳輸** - 使用 stdin/stdout 的本地進程傳輸。適用於檔案系統訪問或命令行工具。

**StdioMcpTransport** - LangChain4j 實現，作為子進程啟動 MCP 服務器。

<strong>工具發現</strong> - 客戶端查詢服務器獲取可用工具及其說明和結構。

## Azure 服務 - [模組 01](../01-introduction/README.md)

**Azure AI 搜索** - 支援向量功能的雲端搜索。[模組 03](../03-rag/README.md)

**Azure 開發者 CLI (azd)** - 部署 Azure 資源。

**Azure OpenAI** - 微軟企業級 AI 服務。

**Bicep** - Azure 基礎架構即代碼語言。[基礎架構指南](../01-introduction/infra/README.md)

<strong>部署名稱</strong> - Azure 中模型部署的名稱。

**GPT-5.2** - 最新 OpenAI 模型，具備推理控制。[模組 02](../02-prompt-engineering/README.md)

## 測試與開發 - [測試指南](TESTING.md)

**開發容器（Dev Container）** - 容器化開發環境。[配置](../../../.devcontainer/devcontainer.json)

<strong>記憶體內測試</strong> - 使用記憶體中存儲進行測試。

<strong>整合測試</strong> - 使用實際基礎設施進行測試。

**Maven** - Java 建構自動化工具。

**Mockito** - Java 模擬框架。

**Spring Boot** - Java 應用程式框架。[模組 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：
此文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們努力追求準確性，但請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應視為權威來源。對於關鍵資訊，建議採用專業人工翻譯。我們不對因使用此翻譯所產生的任何誤解或誤譯承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->