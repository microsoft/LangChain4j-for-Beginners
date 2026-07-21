# LangChain4j 術語表

## 目錄

- [核心概念](#核心概念)
- [LangChain4j 組件](#langchain4j-組件)
- [AI/ML 概念](#aiml-概念)
- [Guardrails](#guardrails)
- [提示工程](#prompt-engineering---module-02)
- [RAG（檢索增強生成）](#rag-retrieval-augmented-generation---module-03)
- [代理與工具](#agents-and-tools---module-04)
- [Agentic 模組](#agentic-module---module-05)
- [模型上下文協定 (MCP)](#model-context-protocol-mcp---module-05)
- [Azure 服務](#azure-services---module-01)
- [測試與開發](#testing-and-development---testing-guide)

課程中使用的術語與概念快速參考。

## 核心概念

**AI 代理** - 使用 AI 進行推理與自主行動的系統。[模組 04](../04-tools/README.md)

<strong>鏈</strong> - 輸出作為下一步輸入的操作序列。

<strong>分塊</strong> - 將文件拆分成較小的部分。典型大小：300-500 個 token 並帶交疊。[模組 03](../03-rag/README.md)

<strong>上下文窗口</strong> - 模型可處理的最大 tokens 数量。GPT-5.2：400K tokens（最多 272K 輸入，128K 輸出）。

<strong>嵌入</strong> - 表示文本含義的數值向量。[模組 03](../03-rag/README.md)

<strong>函式調用</strong> - 模型生成結構化請求以調用外部函式。[模組 04](../04-tools/README.md)

<strong>幻覺</strong> - 模型生成錯誤但看似合理的資訊。

<strong>提示</strong> - 輸入給語言模型的文本。[模組 02](../02-prompt-engineering/README.md)

<strong>語義搜尋</strong> - 以含義搜尋，使用嵌入而非關鍵字。[模組 03](../03-rag/README.md)

**有狀態 vs 無狀態** - 無狀態：無記憶。有狀態：維護對話歷史。[模組 01](../01-introduction/README.md)

**Token** - 模型處理的基本文本單位，影響成本與限制。[模組 01](../01-introduction/README.md)

<strong>工具鏈</strong> - 工具按順序執行，輸出作為下一次調用依據。[模組 04](../04-tools/README.md)

## LangChain4j 組件

**AiServices** - 建立類型安全的 AI 服務介面。

**OpenAiOfficialChatModel** - 統一用戶端，支持 OpenAI 和 Azure OpenAI 模型。

**OpenAiOfficialEmbeddingModel** - 使用官方 OpenAI 用戶端建立嵌入（同時支持 OpenAI 與 Azure OpenAI）。

**ChatModel** - 語言模型核心介面。

**ChatMemory** - 保持對話歷史。

**ContentRetriever** - 為 RAG 找到相關文件分塊。

**DocumentSplitter** - 將文件拆分成分塊。

**EmbeddingModel** - 將文本轉換成數值向量。

**EmbeddingStore** - 存取嵌入向量。

**MessageWindowChatMemory** - 維護最近訊息的滑動視窗。

**PromptTemplate** - 建立帶有 `{{variable}}` 佔位符的可重用提示。

**TextSegment** - 搭配元資料的文本分塊，用於 RAG。

**ToolExecutionRequest** - 表示工具執行請求。

**UserMessage / AiMessage / SystemMessage** - 對話訊息類型。

## AI/ML 概念

<strong>少量示範學習</strong> - 在提示中提供範例。[模組 02](../02-prompt-engineering/README.md)

**大型語言模型 (LLM)** - 以大量文本資料訓練的 AI 模型。

<strong>推理深度</strong> - GPT-5.2 中控制思考深度的參數。[模組 02](../02-prompt-engineering/README.md)

<strong>溫度</strong> - 控制生成輸出的隨機性。低=決定性，高=創意。

<strong>向量資料庫</strong> - 專門存取嵌入的資料庫。[模組 03](../03-rag/README.md)

<strong>零示範學習</strong> - 無範例執行任務。[模組 02](../02-prompt-engineering/README.md)

## Guardrails

<strong>多層防禦</strong> - 結合應用層 Guardrails 與供應商安全過濾的多層安全策略。

<strong>嚴格封鎖</strong> - 供應商對嚴重違規內容回傳 HTTP 400 錯誤。

**InputGuardrail** - LangChain4j 用於在送入 LLM 前驗證用戶輸入的介面。提前阻止有害提示節省成本與延遲。

**InputGuardrailResult** - Guardrail 驗證回傳類型：`success()` 或 `fatal("原因")`。

**OutputGuardrail** - 驗證 AI 回應是否合規的介面，回傳使用者前進行檢查。

<strong>供應商安全過濾</strong> - AI 供應商（例如 Azure OpenAI）的內建內容過濾，API 級別捕獲違規。

<strong>委婉拒絕</strong> - 模型禮貌拒絕回答但不丟錯誤。

## 提示工程 - [模組 02](../02-prompt-engineering/README.md)

**思維鏈 (Chain-of-Thought)** - 逐步推理以提升準確率。

<strong>限制輸出</strong> - 強制特定格式或結構。

<strong>高度積極</strong> - GPT-5.2 中用於深入推理的模式。

<strong>低度積極</strong> - GPT-5.2 中用於快速回答的模式。

<strong>多輪對話</strong> - 跨輪保持上下文。

<strong>角色提示</strong> - 透過系統訊息設定模型人物角色。

<strong>自我反思</strong> - 模型評估並改進自己的輸出。

<strong>結構化分析</strong> - 固定評估框架。

<strong>任務執行模式</strong> - 計畫→執行→總結。

## RAG（檢索增強生成）- [模組 03](../03-rag/README.md)

<strong>文件處理管線</strong> - 載入 → 分塊 → 嵌入 → 儲存。

<strong>記憶體中嵌入庫</strong> - 用於測試的非持久化儲存。

**RAG** - 結合檢索與生成以提供有根據的回答。

<strong>相似度分數</strong> - 語義相似度的量度（0-1）。

<strong>來源引用</strong> - 取回內容的元資料。

## 代理與工具 - [模組 04](../04-tools/README.md)

**@Tool 註解** - 標記 Java 方法為 AI 可調用工具。

**ReAct 模式** - 推理→行動→觀察→重複。

<strong>會話管理</strong> - 不同用戶分離上下文。

<strong>工具</strong> - AI 代理可調用的函式。

<strong>工具說明</strong> - 工具用途及參數文件。

## Agentic 模組 - [模組 05](../05-mcp/README.md)

**@Agent 註解** - 標記介面為 AI 代理並宣告行為定義。

<strong>代理監聽器</strong> - 透過 `beforeAgentInvocation()` 和 `afterAgentInvocation()` 監控代理執行。

**Agentic Scope** - 代理使用的共享記憶，透過 `outputKey` 儲存結果以供後續代理使用。

**AgenticServices** - 用於創建代理的工廠，包含 `agentBuilder()` 和 `supervisorBuilder()`。

<strong>條件工作流</strong> - 根據條件導向不同專家代理。

**人類審核（Human-in-the-Loop）** - 加入人工審核或內容審查的工作流模式。

**langchain4j-agentic** - 用於宣告式代理構建的 Maven 依賴（實驗中）。

<strong>迴圈工作流</strong> - 重複代理執行直到達到條件（例如品質分數 ≥ 0.8）。

**outputKey** - 代理註解參數，指定結果在 Agentic Scope 中存儲位置。

<strong>平行工作流</strong> - 多代理同時執行獨立任務。

<strong>回應策略</strong> - 監督者組裝最終答案方式：LAST、SUMMARY 或 SCORED。

<strong>串行工作流</strong> - 代理依序執行，輸出流向下一步。

<strong>監督者代理模式</strong> - 先進的代理模式，監督者 LLM 動態決定調用哪些子代理。

## 模型上下文協定 (MCP) - [模組 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j 中 MCP 整合的 Maven 依賴。

**MCP** - 模型上下文協定：連結 AI 應用與外部工具的標準。一次建造，到處使用。

**MCP 用戶端** - 連接 MCP 伺服器以發現及使用工具的應用。

**MCP 伺服器** - 透過 MCP 暴露工具，附帶明確描述與參數結構的服務。

**McpToolProvider** - LangChain4j 組件，封裝 MCP 工具用於 AI 服務和代理。

**McpTransport** - MCP 通訊介面。實現包括 Stdio 和 HTTP。

**Stdio 傳輸** - 透過 stdin/stdout 的本地進程傳輸。適用於檔案系統存取或命令行工具。

**StdioMcpTransport** - LangChain4j 實作，以子程序形式啟動 MCP 伺服器。

<strong>工具發現</strong> - 用戶端查詢伺服器可用工具及其描述與結構。

## Azure 服務 - [模組 01](../01-introduction/README.md)

**Azure AI 搜尋** - 支援向量功能的雲端搜尋。[模組 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - 部署 Azure 資源工具。

**Azure OpenAI** - 微軟的企業 AI 服務。

**Bicep** - Azure 基礎設施即代碼語言。[基礎設施指南](../01-introduction/infra/README.md)

<strong>部署名稱</strong> - Azure 上模型部署的名稱。

**GPT-5.2** - 最新 OpenAI 模型，具推理控制功能。[模組 02](../02-prompt-engineering/README.md)

## 測試與開發 - [測試指南](TESTING.md)

<strong>開發容器</strong> - 容器化的開發環境。[設定](../../../.devcontainer/devcontainer.json)

<strong>記憶體中測試</strong> - 使用記憶體中儲存進行測試。

<strong>整合測試</strong> - 使用實際基礎設施的測試。

**Maven** - Java 構建自動化工具。

**Mockito** - Java 模擬框架。

**Spring Boot** - Java 應用框架。[模組 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：
本文件由 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 翻譯而成。雖然我們致力於確保準確性，但請注意，機器自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要資訊，建議進行專業人工翻譯。我們不對因使用本翻譯而產生的任何誤解或誤釋承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->