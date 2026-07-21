# LangChain4j 詞彙表

## 目錄

- [核心概念](#核心概念)
- [LangChain4j 元件](#langchain4j-元件)
- [AI/ML 概念](#aiml-概念)
- [安全防護](#安全防護)
- [提示詞工程](#prompt-engineering---module-02)
- [RAG（檢索增強生成）](#rag-retrieval-augmented-generation---module-03)
- [代理與工具](#agents-and-tools---module-04)
- [代理模組](#agentic-module---module-05)
- [模型上下文協定 (MCP)](#model-context-protocol-mcp---module-05)
- [Azure 服務](#azure-services---module-01)
- [測試與開發](#testing-and-development---testing-guide)

課程中使用的術語與概念快速參考。

## 核心概念

**AI 代理** – 使用 AI 進行推理並自主行動的系統。[模組 04](../04-tools/README.md)

**鏈（Chain）** – 操作序列，其輸出餵給下一步。

**分塊（Chunking）** – 把文件拆成較小片段。典型為300-500個標記，有重疊。[模組 03](../03-rag/README.md)

<strong>上下文視窗</strong> – 模型可處理的最大標記數。GPT-5.2：400K標記（最多272K輸入，128K輸出）。

**嵌入（Embeddings）** – 表示文字意義的數值向量。[模組 03](../03-rag/README.md)

<strong>函式呼叫</strong> – 模型生成結構化請求以呼叫外部函式。[模組 04](../04-tools/README.md)

**幻覺（Hallucination）** – 模型產生錯誤但看似合理的資訊。

**提示詞（Prompt）** – 輸入給語言模型的文字。[模組 02](../02-prompt-engineering/README.md)

<strong>語義搜尋</strong> – 使用嵌入按意義搜尋，而非關鍵字。[模組 03](../03-rag/README.md)

**有狀態 vs 無狀態** – 無狀態：無記憶。 有狀態：保留對話歷史。[模組 01](../01-introduction/README.md)

**標記（Tokens）** – 模型處理的基本文字單位。影響成本與限制。[模組 01](../01-introduction/README.md)

<strong>工具鏈接</strong> – 按序執行工具，輸出成為後續調用依據。[模組 04](../04-tools/README.md)

## LangChain4j 元件

**AiServices** – 創建型別安全的 AI 服務接口。

**OpenAiOfficialChatModel** – 用於 OpenAI 及 Azure OpenAI 模型的統一客戶端。

**OpenAiOfficialEmbeddingModel** – 使用 OpenAI 官方客戶端建立嵌入（同時支持 OpenAI 和 Azure OpenAI）。

**ChatModel** – 語言模型核心介面。

**ChatMemory** – 維護對話歷史。

**ContentRetriever** – 查找與 RAG 相關的文件片段。

**DocumentSplitter** – 將文件拆成片段。

**EmbeddingModel** – 將文字轉為數值向量。

**EmbeddingStore** – 儲存及檢索嵌入。

**MessageWindowChatMemory** – 維護近期訊息的滑動視窗。

**PromptTemplate** – 使用 `{{variable}}` 佔位符創建可重用的提示詞。

**TextSegment** – 含有元資料的文字區段，用於 RAG。

**ToolExecutionRequest** – 代表工具執行請求。

**UserMessage / AiMessage / SystemMessage** – 對話訊息類型。

## AI/ML 概念

**少量示例學習（Few-Shot Learning）** – 在提示中提供示例。[模組 02](../02-prompt-engineering/README.md)

**大型語言模型 (LLM)** – 在大量文本資料上訓練的 AI 模型。

**推理努力（Reasoning Effort）** – GPT-5.2 控制推理深度的參數。[模組 02](../02-prompt-engineering/README.md)

**溫度（Temperature）** – 控制輸出隨機性。低＝確定性，高＝創造性。

<strong>向量資料庫</strong> – 專為嵌入設計的資料庫。[模組 03](../03-rag/README.md)

**零示例學習（Zero-Shot Learning）** – 在無示例情況下執行任務。[模組 02](../02-prompt-engineering/README.md)

## 安全防護

**多層防禦（Defense in Depth）** – 結合應用層防護與提供者安全過濾的多層安全策略。

**硬性封鎖（Hard Block）** – 提供者針對嚴重內容違規回傳 HTTP 400 錯誤。

**InputGuardrail** – LangChain4j 介面，用於在提示送入 LLM 前驗證用戶輸入。透過早期阻擋有害提示節省成本與延遲。

**InputGuardrailResult** – 防護驗證返回類型：`success()` 或 `fatal("reason")`。

**OutputGuardrail** – 驗證 AI 回應再返回使用者前的接口。

<strong>提供者安全過濾器</strong> – AI 提供者（如 Azure OpenAI）內建的內容過濾器，在 API 層捕捉違規。

**軟性拒絕（Soft Refusal）** – 模型禮貌拒答，無錯誤丟出。

## 提示詞工程 - [模組 02](../02-prompt-engineering/README.md)

**鏈式思考（Chain-of-Thought）** – 逐步推理以提高精準度。

**約束輸出（Constrained Output）** – 強制特定格式或結構。

**高熱情（High Eagerness）** – GPT-5.2 的細緻推理模式。

**低熱情（Low Eagerness）** – GPT-5.2 的快速回應模式。

**多輪對話（Multi-Turn Conversation）** – 在多次交流中維持上下文。

**角色提示（Role-Based Prompting）** – 透過系統訊息設定模型角色。

**自我反思（Self-Reflection）** – 模型評估並改進自身輸出。

**結構化分析（Structured Analysis）** – 固定評估框架。

**任務執行模式（Task Execution Pattern）** – 計劃 → 執行 → 總結。

## RAG（檢索增強生成） - [模組 03](../03-rag/README.md)

<strong>文件處理管線</strong> – 載入 → 分塊 → 嵌入 → 儲存。

<strong>記憶體嵌入庫</strong> – 用於測試的非持久性儲存。

**RAG** – 結合檢索與生成以增強回答的依據。

<strong>相似度分數</strong> – 語義相似度量度（0-1）。

<strong>來源參考</strong> – 取回內容的元資料。

## 代理與工具 - [模組 04](../04-tools/README.md)

**@Tool 標註** – 標記 Java 方法為 AI 可調用工具。

**ReAct 模式** – 推理 → 行動 → 觀察 → 重複。

<strong>會話管理</strong> – 為不同用戶分離上下文。

<strong>工具</strong> – AI 代理可呼叫的函式。

<strong>工具描述</strong> – 工具目的與參數的文件。

## 代理模組 - [模組 05](../05-mcp/README.md)

**@Agent 標註** – 將介面標註為 AI 代理，並用聲明式定義行為。

<strong>代理監聽器</strong> – 透過 `beforeAgentInvocation()` 與 `afterAgentInvocation()` 監控代理執行的鉤子。

<strong>代理作用域</strong> – 共享記憶體，代理使用 `outputKey` 儲存輸出，供後續代理使用。

**AgenticServices** – 透過 `agentBuilder()` 和 `supervisorBuilder()` 創建代理的工廠。

<strong>條件工作流程</strong> – 根據條件路由至不同專家代理。

**人機協同流程（Human-in-the-Loop）** – 增加人工審核或內容審查的工作流模式。

**langchain4j-agentic** – 用於聲明式代理構建的 Maven 依賴（實驗性）。

<strong>迴圈工作流程</strong> – 迭代執行代理直到達成條件（例如品質分數 ≥ 0.8）。

**outputKey** – 代理標註參數，指定結果在代理作用域中的存放位置。

<strong>平行工作流程</strong> – 同時執行多名代理以處理獨立任務。

<strong>回應策略</strong> – 主管代理形成最終答覆的方法：LAST、SUMMARY 或 SCORED。

<strong>序列工作流程</strong> – 按順序執行代理，輸出流向下一步。

**監督代理模式（Supervisor Agent Pattern）** – 進階代理模式，由主管 LLM 動態決定召喚哪些子代理。

## 模型上下文協定 (MCP) - [模組 05](../05-mcp/README.md)

**langchain4j-mcp** – LangChain4j 中 MCP 整合的 Maven 依賴。

**MCP** – 模型上下文協定：將 AI 應用與外部工具連接的標準。一次構建，到處使用。

**MCP 客戶端** – 連接 MCP 伺服器以發現和使用工具的應用程式。

**MCP 伺服器** – 透過 MCP 提供工具的服務，附帶明確描述與參數結構。

**McpToolProvider** – LangChain4j 元件，封裝 MCP 工具供 AI 服務與代理使用。

**McpTransport** – MCP 通訊介面。實作包括 Stdio 與 HTTP。

**Stdio 傳輸** – 經 stdin/stdout 的本地處理程序傳輸。適用於檔案系統存取或命令列工具。

**StdioMcpTransport** – LangChain4j 實作，啟動 MCP 伺服器作為子程序。

<strong>工具發現</strong> – 客戶端查詢伺服器提供的工具及其描述與結構。

## Azure 服務 - [模組 01](../01-introduction/README.md)

**Azure AI Search** – 支援向量能力的雲端搜尋。[模組 03](../03-rag/README.md)

**Azure Developer CLI (azd)** – 部署 Azure 資源。

**Azure OpenAI** – 微軟企業級 AI 服務。

**Bicep** – Azure 基礎架構即程式碼語言。[基礎架構指南](../01-introduction/infra/README.md)

<strong>部署名稱</strong> – Azure 中模型部署的名稱。

**GPT-5.2** – 最新 OpenAI 模型，帶有推理控制。[模組 02](../02-prompt-engineering/README.md)

## 測試與開發 - [測試指南](TESTING.md)

<strong>開發容器</strong> – 容器化的開發環境。[設定](../../../.devcontainer/devcontainer.json)

<strong>記憶體測試</strong> – 使用記憶體儲存的測試。

<strong>整合測試</strong> – 使用真實基礎架構的測試。

**Maven** – Java 建置自動化工具。

**Mockito** – Java 模擬框架。

**Spring Boot** – Java 應用框架。[模組 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：
本文件使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們力求準確，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要資訊，建議尋求專業人工翻譯。我們不對因使用本翻譯而引起的任何誤解或曲解承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->