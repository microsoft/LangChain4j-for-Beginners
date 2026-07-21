# 测试 LangChain4j 应用程序

## 目录

- [快速开始](#快速开始)
- [测试涵盖内容](#测试涵盖内容)
- [运行测试](#运行测试)
- [在 VS Code 中运行测试](#在-vs-code-中运行测试)
- [测试模式](#测试模式)
- [测试理念](#测试理念)
- [下一步](#下一步)

本指南将带您了解展示如何测试 AI 应用程序的测试，这些测试不需要 API 密钥或外部服务。

## 快速开始

使用以下单个命令运行所有测试：

**Bash:**
```bash
mvn test
```

**PowerShell:**
```powershell
mvn --% test
```

当所有测试通过时，您应该看到如下截图中的输出——测试零失败运行。

<img src="../../../translated_images/zh-CN/test-results.ea5c98d8f3642043.webp" alt="Successful Test Results" width="800"/>

*成功的测试执行，显示所有测试均通过且无失败*

## 测试涵盖内容

本课程专注于在本地运行的<strong>单元测试</strong>。每个测试都展示了一个特定的 LangChain4j 概念的隔离演示。下图的测试金字塔展示了单元测试的位置——它们构成了快速、可靠的基础，其他测试策略在此基础上构建。

<img src="../../../translated_images/zh-CN/testing-pyramid.2dd1079a0481e53e.webp" alt="Testing Pyramid" width="800"/>

*测试金字塔显示单元测试（快速、隔离）、集成测试（真实组件）和端到端测试之间的平衡。本培训涵盖单元测试。*

| 模块 | 测试数量 | 关注点 | 关键文件 |
|--------|-------|-------|-----------|
| **01 - 介绍** | 8 | 会话内存与有状态对话 | `SimpleConversationTest.java` |
| **02 - 提示工程** | 12 | GPT-5.2 模式、急切度等级、结构化输出 | `SimpleGpt5PromptTest.java` |
| **03 - RAG** | 10 | 文档摄取、嵌入、相似度搜索 | `DocumentServiceTest.java` |
| **04 - 工具** | 12 | 函数调用与工具链 | `SimpleToolsTest.java` |
| **05 - MCP** | 8 | 使用 stdio 传输的模型上下文协议 | `SimpleMcpTest.java` |

## 运行测试

**从根目录运行所有测试：**

**Bash:**
```bash
mvn test
```

**PowerShell:**
```powershell
mvn --% test
```

**运行特定模块的测试：**

**Bash:**
```bash
cd 01-introduction && mvn test
# 或从根目录
mvn test -pl 01-introduction
```

**PowerShell:**
```powershell
cd 01-introduction; mvn --% test
# 或者从根目录开始
mvn --% test -pl 01-introduction
```

**运行单个测试类：**

**Bash:**
```bash
mvn test -Dtest=SimpleConversationTest
```

**PowerShell:**
```powershell
mvn --% test -Dtest=SimpleConversationTest
```

**运行特定测试方法：**

**Bash:**
```bash
mvn test -Dtest=SimpleConversationTest#应该保持对话历史
```

**PowerShell:**
```powershell
mvn --% test -Dtest=SimpleConversationTest#应该保持对话历史
```

## 在 VS Code 中运行测试

如果您使用 Visual Studio Code，测试资源管理器提供了一个用于运行和调试测试的图形界面。

<img src="../../../translated_images/zh-CN/vscode-testing.f02dd5917289dced.webp" alt="VS Code Test Explorer" width="800"/>

*VS Code 测试资源管理器显示测试树，包含所有 Java 测试类和单独测试方法*

**在 VS Code 中运行测试步骤：**

1. 点击活动栏中的烧杯图标打开测试资源管理器
2. 展开测试树查看所有模块和测试类
3. 点击任意测试旁的播放按钮单独运行该测试
4. 点击“运行所有测试”执行整个测试套件
5. 右击任何测试选择“调试测试”设置断点并逐步调试代码

测试资源管理器用绿色勾号表示通过的测试，失败时会提供详细的失败信息。

## 测试模式

### 模式 1：测试提示模板

最简单的模式是测试提示模板，不调用任何 AI 模型。您验证变量替换是否正确，并确保提示格式符合预期。

<img src="../../../translated_images/zh-CN/prompt-template-testing.b902758ddccc8dee.webp" alt="Prompt Template Testing" width="800"/>

*测试提示模板显示变量替换流程：包含占位符的模板 → 应用值 → 验证格式化输出*

```java
@Test
@DisplayName("Should format prompt template with variables")
void testPromptTemplateFormatting() {
    PromptTemplate template = PromptTemplate.from(
        "Best time to visit {{destination}} for {{activity}}?"
    );
    
    Prompt prompt = template.apply(Map.of(
        "destination", "Paris",
        "activity", "sightseeing"
    ));
    
    assertThat(prompt.text()).isEqualTo("Best time to visit Paris for sightseeing?");
}
```

此模式验证变量替换是否正确，提示是否格式化如预期—无须 API 密钥或模型调用。

### 模式 2：模拟语言模型

测试会话逻辑时，使用 Mockito 创建返回预设响应的假模型。这使测试快速、免费且确定性强。

<img src="../../../translated_images/zh-CN/mock-vs-real.3b8b1f85bfe6845e.webp" alt="Mock vs Real API Comparison" width="800"/>

*比较说明为何测试首选模拟：它们快速、免费、确定性高，无需 API 密钥*

```java
@ExtendWith(MockitoExtension.class)
class SimpleConversationTest {
    
    private ConversationService conversationService;
    
    @Mock
    private OpenAiOfficialChatModel mockChatModel;
    
    @BeforeEach
    void setUp() {
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("This is a test response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);
        
        conversationService = new ConversationService(mockChatModel);
    }
    
    @Test
    void shouldMaintainConversationHistory() {
        String conversationId = conversationService.startConversation();
        
        ChatResponse mockResponse1 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 1"))
            .build();
        ChatResponse mockResponse2 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 2"))
            .build();
        ChatResponse mockResponse3 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 3"))
            .build();
        
        when(mockChatModel.chat(anyList()))
            .thenReturn(mockResponse1)
            .thenReturn(mockResponse2)
            .thenReturn(mockResponse3);

        conversationService.chat(conversationId, "First message");
        conversationService.chat(conversationId, "Second message");
        conversationService.chat(conversationId, "Third message");

        List<ChatMessage> history = conversationService.getHistory(conversationId);
        assertThat(history).hasSize(6); // 3 个用户 + 3 个 AI 消息
    }
}
```

此模式见于 `01-introduction/src/test/java/com/example/langchain4j/service/SimpleConversationTest.java`。模拟确保行为一致，便于验证内存管理正确。

### 模式 3：测试会话隔离

会话内存必须保持多用户隔离。此测试验证对话不会混淆上下文。

<img src="../../../translated_images/zh-CN/conversation-isolation.e00336cf8f7a3e3f.webp" alt="Conversation Isolation" width="800"/>

*测试会话隔离，显示不同用户的独立内存存储，防止上下文混淆*

```java
@Test
void shouldIsolateConversationsByid() {
    String conv1 = conversationService.startConversation();
    String conv2 = conversationService.startConversation();
    
    ChatResponse mockResponse = ChatResponse.builder()
        .aiMessage(AiMessage.from("Response"))
        .build();
    when(mockChatModel.chat(anyList())).thenReturn(mockResponse);

    conversationService.chat(conv1, "Message for conversation 1");
    conversationService.chat(conv2, "Message for conversation 2");

    List<ChatMessage> history1 = conversationService.getHistory(conv1);
    List<ChatMessage> history2 = conversationService.getHistory(conv2);
    
    assertThat(history1).hasSize(2);
    assertThat(history2).hasSize(2);
}
```

每个会话维护独立历史。生产系统中，这种隔离对于多用户应用至关重要。

### 模式 4：独立测试工具

工具是 AI 可以调用的函数。直接测试它们，确保其工作正常，无论 AI 决策如何。

<img src="../../../translated_images/zh-CN/tools-testing.3e1706817b0b3924.webp" alt="Tools Testing" width="800"/>

*独立测试工具，显示模拟工具执行，无 AI 调用验证业务逻辑*

```java
@Test
void shouldConvertCelsiusToFahrenheit() {
    TemperatureTool tempTool = new TemperatureTool();
    String result = tempTool.celsiusToFahrenheit(25.0);
    assertThat(result).containsPattern("77[.,]0°F");
}

@Test
void shouldDemonstrateToolChaining() {
    WeatherTool weatherTool = new WeatherTool();
    TemperatureTool tempTool = new TemperatureTool();

    String weatherResult = weatherTool.getCurrentWeather("Seattle");
    assertThat(weatherResult).containsPattern("\\d+°C");

    String conversionResult = tempTool.celsiusToFahrenheit(22.0);
    assertThat(conversionResult).containsPattern("71[.,]6°F");
}
```

这些测试来自 `04-tools/src/test/java/com/example/langchain4j/agents/tools/SimpleToolsTest.java`，验证工具逻辑不依赖 AI。链式示例演示一个工具的输出如何作为另一个工具的输入。

### 模式 5：内存中 RAG 测试

RAG 系统传统上依赖向量数据库和嵌入服务。内存中模式让您无需外部依赖即可测试整个流程。

<img src="../../../translated_images/zh-CN/rag-testing.ee7541b1e23934b1.webp" alt="In-Memory RAG Testing" width="800"/>

*内存中 RAG 测试工作流，展示文档解析、嵌入存储和相似度搜索，无需数据库*

```java
@Test
void testProcessTextDocument() {
    String content = "This is a test document.\nIt has multiple lines.";
    InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
    
    DocumentService.ProcessedDocument result = 
        documentService.processDocument(inputStream, "test.txt");

    assertNotNull(result);
    assertTrue(result.segments().size() > 0);
    assertEquals("test.txt", result.segments().get(0).metadata().getString("filename"));
}
```

此测试来自 `03-rag/src/test/java/com/example/langchain4j/rag/service/DocumentServiceTest.java`，在内存中创建文档，验证分块和元数据处理。

### 模式 6：MCP 集成测试

MCP 模块测试使用 stdio 传输的模型上下文协议集成。这些测试验证您的应用程序可以作为子进程启动 MCP 服务器并通信。

`05-mcp/src/test/java/com/example/langchain4j/mcp/SimpleMcpTest.java` 中的测试验证 MCP 客户端行为。

**运行：**

**Bash:**
```bash
cd 05-mcp && mvn test
```

**PowerShell:**
```powershell
cd 05-mcp; mvn --% test
```

## 测试理念

测试您的代码，而非 AI。您的测试应通过检查提示构造方式、内存管理和工具执行来验证代码。AI 响应各异，不应成为测试断言的一部分。问自己提示模板是否正确替换了变量，而不是 AI 是否给出了正确答案。

对语言模型使用模拟。它们是外部依赖，速度慢、费用高且非确定性。模拟让测试快速（毫秒级而非秒级），免费且结果确定。

保持测试独立。每个测试应自行设置数据，不依赖其他测试，并自行清理。无论执行顺序如何，测试都应通过。

测试边界情况，超出正常路径。尝试空输入、超大输入、特殊字符、无效参数和边界条件。这些往往揭露正常使用不易发现的漏洞。

使用描述性名称。比较 `shouldMaintainConversationHistoryAcrossMultipleMessages()` 和 `test1()`。前者准确说明测试内容，调试失败更容易。

## 下一步

既然您了解了测试模式，深入学习各模块：

- **[01 - 介绍](../01-introduction/README.md)** - 学习会话内存管理
- **[02 - 提示工程](../02/prompt-engineering/README.md)** - 掌握 GPT-5.2 提示模式
- **[03 - RAG](../03-rag/README.md)** - 构建检索增强生成系统
- **[04 - 工具](../04-tools/README.md)** - 实现函数调用和工具链
- **[05 - MCP](../05-mcp/README.md)** - 集成模型上下文协议

每个模块的自述文件详细讲解此处测试的概念。

---

**导航：** [← 返回主页面](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免责声明**：
本文件由 AI 翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 翻译完成。尽管我们力求准确，但请注意，自动翻译可能包含错误或不准确之处。原始语言版文件应视为权威来源。对于重要信息，建议使用专业人工翻译。我们对因使用本翻译而产生的任何误解或误释不承担责任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->