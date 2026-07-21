# Thuật ngữ LangChain4j

## Mục lục

- [Khái niệm cốt lõi](#khái-niệm-cốt-lõi)
- [Thành phần LangChain4j](#thành-phần-langchain4j)
- [Khái niệm AI/ML](#khái-niệm-aiml)
- [Hàng rào bảo vệ](#hàng-rào-bảo-vệ)
- [Kỹ thuật Prompt](#prompt-engineering---module-02)
- [RAG (Sinh Tăng cường Truy xuất)](#rag-retrieval-augmented-generation---module-03)
- [Tác nhân và Công cụ](#agents-and-tools---module-04)
- [Module Agentic](#agentic-module---module-05)
- [Giao thức Ngữ cảnh Mô hình (MCP)](#model-context-protocol-mcp---module-05)
- [Dịch vụ Azure](#azure-services---module-01)
- [Kiểm thử và Phát triển](#testing-and-development---testing-guide)

Tham khảo nhanh các thuật ngữ và khái niệm sử dụng xuyên suốt khóa học.

## Khái niệm cốt lõi

**AI Agent** - Hệ thống sử dụng AI để suy luận và hành động tự chủ. [Module 04](../04-tools/README.md)

**Chain** - Chuỗi các thao tác, đầu ra của bước trước là đầu vào cho bước tiếp theo.

**Chunking** - Chia nhỏ tài liệu thành các đoạn nhỏ hơn. Thông thường: 300-500 token với phần chồng lấn. [Module 03](../03-rag/README.md)

**Context Window** - Số token tối đa mà mô hình có thể xử lý. GPT-5.2: 400K token (tối đa 272K đầu vào, 128K đầu ra).

**Embeddings** - Vector số biểu diễn ý nghĩa văn bản. [Module 03](../03-rag/README.md)

**Function Calling** - Mô hình tạo yêu cầu có cấu trúc để gọi hàm bên ngoài. [Module 04](../04-tools/README.md)

**Hallucination** - Khi mô hình tạo ra thông tin sai nhưng có vẻ hợp lý.

**Prompt** - Văn bản đầu vào cho mô hình ngôn ngữ. [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - Tìm kiếm theo nghĩa sử dụng embeddings, không dùng từ khóa. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: không nhớ. Stateful: duy trì lịch sử hội thoại. [Module 01](../01-introduction/README.md)

**Tokens** - Đơn vị văn bản cơ bản mà mô hình xử lý. Ảnh hưởng đến chi phí và giới hạn. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Thực thi công cụ tuần tự, đầu ra của công cụ này là đầu vào cho công cụ tiếp theo. [Module 04](../04-tools/README.md)

## Thành phần LangChain4j

**AiServices** - Tạo giao diện dịch vụ AI kiểu an toàn.

**OpenAiOfficialChatModel** - Client thống nhất cho các mô hình OpenAI và Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Tạo embeddings sử dụng client OpenAI Official (hỗ trợ cả OpenAI và Azure OpenAI).

**ChatModel** - Giao diện lõi cho các mô hình ngôn ngữ.

**ChatMemory** - Duy trì lịch sử hội thoại.

**ContentRetriever** - Tìm các đoạn tài liệu phù hợp cho RAG.

**DocumentSplitter** - Chia tài liệu thành các đoạn nhỏ.

**EmbeddingModel** - Chuyển văn bản thành vector số.

**EmbeddingStore** - Lưu trữ và truy vấn embeddings.

**MessageWindowChatMemory** - Duy trì cửa sổ trượt các tin nhắn gần đây.

**PromptTemplate** - Tạo các prompt tái sử dụng với các chỗ giữ chỗ `{{variable}}`.

**TextSegment** - Đoạn văn bản kèm siêu dữ liệu. Dùng trong RAG.

**ToolExecutionRequest** - Biểu diễn yêu cầu thực thi công cụ.

**UserMessage / AiMessage / SystemMessage** - Các loại tin nhắn trong hội thoại.

## Khái niệm AI/ML

**Few-Shot Learning** - Cung cấp ví dụ trong prompt. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Mô hình AI được huấn luyện trên lượng lớn dữ liệu văn bản.

**Reasoning Effort** - Tham số GPT-5.2 điều chỉnh độ sâu suy luận. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - Điều chỉnh độ ngẫu nhiên đầu ra. Thấp = xác định, cao = sáng tạo.

**Vector Database** - Cơ sở dữ liệu chuyên dụng cho embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Thực hiện nhiệm vụ mà không có ví dụ. [Module 02](../02-prompt-engineering/README.md)

## Hàng rào bảo vệ

**Defense in Depth** - Cách tiếp cận an ninh đa lớp kết hợp hàng rào cấp ứng dụng và bộ lọc an toàn của nhà cung cấp.

**Hard Block** - Nhà cung cấp trả lỗi HTTP 400 cho vi phạm nội dung nghiêm trọng.

**InputGuardrail** - Giao diện LangChain4j để kiểm tra đầu vào người dùng trước khi tới LLM. Tiết kiệm chi phí và giảm độ trễ bằng cách chặn prompt có hại từ sớm.

**InputGuardrailResult** - Kiểu trả về kiểm tra hàng rào: `success()` hoặc `fatal("lý do")`.

**OutputGuardrail** - Giao diện kiểm tra phản hồi AI trước khi trả lại cho người dùng.

**Provider Safety Filters** - Bộ lọc nội dung tích hợp của các nhà cung cấp AI (ví dụ Azure OpenAI) bắt lỗi ở cấp API.

**Soft Refusal** - Mô hình lịch sự từ chối trả lời mà không lỗi.

## Kỹ thuật Prompt - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Suy luận từng bước để tăng độ chính xác.

**Constrained Output** - Bắt đầu theo định dạng hoặc cấu trúc cụ thể.

**High Eagerness** - Mẫu GPT-5.2 cho suy luận kỹ lưỡng.

**Low Eagerness** - Mẫu GPT-5.2 cho trả lời nhanh.

**Multi-Turn Conversation** - Duy trì ngữ cảnh qua nhiều lượt trao đổi.

**Role-Based Prompting** - Thiết lập cá tính mô hình qua tin nhắn hệ thống.

**Self-Reflection** - Mô hình đánh giá và cải tiến đầu ra của chính nó.

**Structured Analysis** - Khung đánh giá cố định.

**Task Execution Pattern** - Lên kế hoạch → Thực thi → Tóm tắt.

## RAG (Sinh Tăng cường Truy xuất) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Tải → chia đoạn → chuyển vector → lưu trữ.

**In-Memory Embedding Store** - Bộ lưu trữ không bền dùng để kiểm thử.

**RAG** - Kết hợp truy xuất với sinh để tăng độ xác thực của câu trả lời.

**Similarity Score** - Thang đo (0-1) về mức độ tương đồng ngữ nghĩa.

**Source Reference** - Siêu dữ liệu về nội dung được truy xuất.

## Tác nhân và Công cụ - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Đánh dấu phương thức Java là công cụ có thể gọi bởi AI.

**ReAct Pattern** - Suy luận → Hành động → Quan sát → Lặp lại.

**Session Management** - Quản lý ngữ cảnh riêng biệt cho từng người dùng.

**Tool** - Hàm mà AI agent có thể gọi.

**Tool Description** - Tài liệu về mục đích và tham số công cụ.

## Module Agentic - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - Đánh dấu giao diện là agent AI với hành vi khai báo.

**Agent Listener** - Hook để giám sát thực thi agent qua `beforeAgentInvocation()` và `afterAgentInvocation()`.

**Agentic Scope** - Bộ nhớ chia sẻ nơi các agent lưu kết quả sử dụng `outputKey` cho agent phía sau truy xuất.

**AgenticServices** - Nhà máy tạo agent dùng `agentBuilder()` và `supervisorBuilder()`.

**Conditional Workflow** - Chuyển hướng theo điều kiện tới các agent chuyên môn khác nhau.

**Human-in-the-Loop** - Mẫu quy trình thêm bước kiểm duyệt hoặc xem xét nội dung từ con người.

**langchain4j-agentic** - Định nghĩa Maven cho xây dựng agent khai báo (thử nghiệm).

**Loop Workflow** - Thực thi agent lặp lại tới khi thỏa điều kiện (ví dụ điểm chất lượng ≥ 0.8).

**outputKey** - Tham số đánh dấu agent chỉ định nơi lưu kết quả trong Agentic Scope.

**Parallel Workflow** - Chạy đồng thời nhiều agent cho các nhiệm vụ độc lập.

**Response Strategy** - Cách supervisor xác định câu trả lời cuối cùng: LAST, SUMMARY, hoặc SCORED.

**Sequential Workflow** - Thực thi tuần tự các agent, đầu ra là đầu vào tiếp theo.

**Supervisor Agent Pattern** - Mẫu agent nâng cao, nơi supervisor LLM quyết định động các sub-agent cần gọi.

## Giao thức Ngữ cảnh Mô hình (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Định nghĩa Maven cho tích hợp MCP trong LangChain4j.

**MCP** - Model Context Protocol: chuẩn kết nối ứng dụng AI với công cụ bên ngoài. Viết một lần, dùng khắp nơi.

**MCP Client** - Ứng dụng kết nối tới MCP server để khám phá và sử dụng công cụ.

**MCP Server** - Dịch vụ phơi bày công cụ qua MCP với mô tả rõ ràng và schema tham số.

**McpToolProvider** - Thành phần LangChain4j đóng gói công cụ MCP dùng trong dịch vụ AI và agent.

**McpTransport** - Giao diện giao tiếp MCP. Các triển khai gồm Stdio và HTTP.

**Stdio Transport** - Giao thức truyền tại máy qua stdin/stdout. Dùng cho truy cập hệ thống tập tin hoặc công cụ dòng lệnh.

**StdioMcpTransport** - Triển khai LangChain4j khởi tạo MCP server làm tiến trình con.

**Tool Discovery** - Client truy vấn server về công cụ sẵn có cùng mô tả và schema.

## Dịch vụ Azure - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Dịch vụ tìm kiếm đám mây với khả năng vector. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Triển khai tài nguyên Azure.

**Azure OpenAI** - Dịch vụ AI doanh nghiệp của Microsoft.

**Bicep** - Ngôn ngữ hạ tầng dưới dạng mã cho Azure. [Hướng dẫn hạ tầng](../01-introduction/infra/README.md)

**Deployment Name** - Tên triển khai mô hình trên Azure.

**GPT-5.2** - Mô hình OpenAI mới nhất với kiểm soát suy luận. [Module 02](../02-prompt-engineering/README.md)

## Kiểm thử và Phát triển - [Hướng dẫn kiểm thử](TESTING.md)

**Dev Container** - Môi trường phát triển đóng gói. [Cấu hình](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Kiểm thử với lưu trữ trong bộ nhớ.

**Integration Testing** - Kiểm thử với hạ tầng thật.

**Maven** - Công cụ tự động hóa xây dựng Java.

**Mockito** - Framework tạo mocking trong Java.

**Spring Boot** - Framework ứng dụng Java. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tuyên bố miễn trừ trách nhiệm**:
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng bản dịch tự động có thể chứa lỗi hoặc sai sót. Tài liệu gốc bằng ngôn ngữ gốc nên được coi là nguồn tin chính thức. Đối với thông tin quan trọng, nên sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm về bất kỳ hiểu lầm hoặc giải thích sai nào phát sinh từ việc sử dụng bản dịch này.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->