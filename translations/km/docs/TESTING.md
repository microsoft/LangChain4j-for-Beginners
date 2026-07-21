# ការធ្វើតេស្តកម្មវិធី LangChain4j

## មាតិការដ្ឋាន

- [ចាប់ផ្តើមយ៉ាងឆាប់រហ័ស](#ចាប់ផ្តើមយ៉ាងឆាប់រហ័ស)
- [តេស្តបានគ្របដណ្តប់អ្វីខ្លះ](#តេស្តបានគ្របដណ្តប់អ្វីខ្លះ)
- [របៀបរត់តេស្ត](#របៀបរត់តេស្ត)
- [របៀបរត់តេស្តក្នុង VS Code](#របៀបរត់តេស្តក្នុង-vs-code)
- [រចនាប័ទ្មតេស្ត](#រចនាប័ទ្មតេស្ត)
- [ទស្សនៈការធ្វើតេស្ត](#ទស្សនៈការធ្វើតេស្ត)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)

មេរៀននេះនឹងដើរតាមជំហានតេស្តដែលបង្ហាញពីរបៀបធ្វើតេស្តកម្មវិធី AI ដោយមិនត្រូវការខ្សែសោ API ឬសេវាកម្មខាងក្រៅ។

## ចាប់ផ្តើមយ៉ាងឆាប់រហ័ស

រត់តេស្តទាំងអស់ជាមួយពាក្យបញ្ជា​មួយ៖

**Bash:**
```bash
mvn test
```

**PowerShell:**
```powershell
mvn --% test
```

ពេលតេស្តទាំងអស់ជោគជ័យ អ្នកគួរតែឃើញលទ្ធផលដូចក្នុងរូបថតអេក្រង់ខាងក្រោម — តេស្តប្រារព្ធដោយគ្មានកំហុសទេ។

<img src="../../../translated_images/km/test-results.ea5c98d8f3642043.webp" alt="Successful Test Results" width="800"/>

*ការរត់តេស្តបានជោគជ័យ បង្ហាញឲ្យឃើញថាតេស្តទាំងអស់ជោគជ័យដោយគ្មានកំហុស*

## តេស្តបានគ្របដណ្តប់អ្វីខ្លះ

វគ្គនេះផ្ដោតលើ **តេស្តឯកត្តា** ដែលរត់នៅក្នុងម៉ាស៊ីនមួយខ្នាត។ តេស្តនីមួយៗបង្ហាញពីគំនិត LangChain4j ជាក់លាក់ដោយផ្តោតលើឯកត្តា។ ពិរាម៉ីតតេស្តខាងក្រោមបង្ហាញកន្លែងដែលតេស្តឯកត្តាទៅ ដោយវាបង្កើតមូលដ្ឋានរហ័ស និងទុកទុកដើម្បីឱ្យយុទ្ធសាស្រ្តតេស្តផ្សេងទៀតមានស្ថេរភាព។

<img src="../../../translated_images/km/testing-pyramid.2dd1079a0481e53e.webp" alt="Testing Pyramid" width="800"/>

*ពិរាម៉ីតតេស្តបង្ហាញពីតុល្យភាពចន្លោះតេស្តឯកត្តា (រហ័ស និងឯកទ្ទឹម), តេស្តបញ្ចូលគ្នា (សមាសភាគពិត), និងតេស្តចប់ដល់បញ្ចប់។ ការបណ្តុះបណ្តាលនេះគ្របដណ្តប់តេស្តឯកត្តា។*

| ម៉ូឌុល | តេស្ត | ការផ្តោតលើ | កាលវិភាគ សំខាន់ៗ |
|--------|-------|--------------|--------------------|
| **01 - ការណែនាំ** | 8 | ការចងចាំការសន្ទនា និងស្ថានភាពការច្រើនបញ្ចូល | `SimpleConversationTest.java` |
| **02 - هندسة الطلبات (Prompt Engineering)** | 12 | លំនាំ GPT-5.2, កម្រិតភាពចង់បាន, លទ្ធផលប្រកបដោយរចនាសម្ព័ន | `SimpleGpt5PromptTest.java` |
| **03 - RAG** | 10 | ការច្រោះឯកសារ, embeddings, ស្វែងរកស្រដៀងគ្នា | `DocumentServiceTest.java` |
| **04 - Tools** | 12 | ការហៅមុខងារ និងការចងខ្សែឧបករណ៍ | `SimpleToolsTest.java` |
| **05 - MCP** | 8 | Model Context Protocol ជាមួយការដឹកជញ្ជូន stdio | `SimpleMcpTest.java` |

## របៀបរត់តេស្ត

**រត់តេស្តទាំងអស់ពីថតឫស៖**

**Bash:**
```bash
mvn test
```

**PowerShell:**
```powershell
mvn --% test
```

**រត់តេស្តម៉ូឌុលជាក់លាក់៖**

**Bash:**
```bash
cd 01-introduction && mvn test
# ឬពីរួត
mvn test -pl 01-introduction
```

**PowerShell:**
```powershell
cd 01-introduction; mvn --% test
# ឬពីរគោល
mvn --% test -pl 01-introduction
```

**រត់តេស្តថ្នាក់មួយចំណាត់ថ្នាក់៖**

**Bash:**
```bash
mvn test -Dtest=SimpleConversationTest
```

**PowerShell:**
```powershell
mvn --% test -Dtest=SimpleConversationTest
```

**រត់វិធីសាស្រ្តតេស្តជាក់លាក់៖**

**Bash:**
```bash
mvn test -Dtest=SimpleConversationTest#ត្រូវតែរក្សាប្រវត្តិសន្ទនា
```

**PowerShell:**
```powershell
mvn --% test -Dtest=SimpleConversationTest#គួរត្រូវរក្សាទុកប្រវត្តិការជជែក
```

## របៀបរត់តេស្តក្នុង VS Code

បើអ្នកប្រើ Visual Studio Code ភាសារតេស្តបង្ហាញផ្ទាំងក្រាហ្វិកសម្រាប់រត់ និងបង្រៀនកំហុសតេស្ត។

<img src="../../../translated_images/km/vscode-testing.f02dd5917289dced.webp" alt="VS Code Test Explorer" width="800"/>

*Test Explorer នៅ VS Code បង្ហាញខ្សែព្រំតេស្តជាមួយថ្នាក់ Java ទាំងអស់ និងវិធីសាស្រ្តតេស្តនីមួយៗ*

**របៀបរត់តេស្តនៅក្នុង VS Code៖**

1. បើក Test Explorer ដោយចុចរូបសញ្ញាកែវគ្រឿងក្នុង Activity Bar
2. ពង្រីកខ្សែព្រំតេស្ត ដើម្បីឃើញម៉ូឌុល និងថ្នាក់តេស្តទាំងអស់
3. ចុចប៊ូតុងលេងនៅក្បែរ តេស្តណាមួយ ដើម្បីរត់វាផ្ទាល់ខ្លួន
4. ចុច “Run All Tests” ដើម្បីអនុវត្តស៊ុមរុំទាំងអស់
5. ចុចស្ដាំលើតេស្តណាមួយ ហើយជ្រើស “Debug Test” ដើម្បីកំណត់ចំណុចបំបែក ហើយធ្វើជំហានហ្គេហ្វតាមកូដ

Test Explorer បង្ហាញសញ្ញាឆែកបៃតងសម្រាប់តេស្តជោគជ័យ ហើយផ្ដល់សារ​កំហុស​លំអិត​ពេលមានការបរាជ័យ។

## រចនាប័ទ្មតេស្ត

### រចនាប័ទ្ម 1៖ តេស្តទាន់គំរូរ Prompt

រចនាប័ទ្មងាយៗបំផុតគឺតេស្តទាន់គំរូនៃ prompt ដោយមិនហៅម៉ូដែល AI ណាមួយទេ។ អ្នកធ្វើការត្រួតពិនិត្យថាការប្តូរតម្លៃចម្លើយត្រូវបានអនុវត្តបានត្រឹមត្រូវ និងការបង្ហាញ prompt ត្រូវបានបំរែបំរួលតាមលក្ខណៈដែលបានរំពឹងទុក។

<img src="../../../translated_images/km/prompt-template-testing.b902758ddccc8dee.webp" alt="Prompt Template Testing" width="800"/>

*តេស្តទាន់គំរូ prompt បង្ហាញលំហ្វុកាល ប្តូរតម្លៃ៖ គំរូមានកន្លែងទុកតម្លៃ → តម្លៃត្រូវបានដាក់ → ផលបញ្ចេញសម្រេចបានត្រឹមត្រូវ*

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

រចនាប័ទ្មនេះបញ្ចាក់ថាការប្តូរតម្លៃអថេរបានប្រតិបត្តិនៅត្រឹមត្រូវ និង prompt មានរចនាសម្ព័នត្រឹមត្រូវ — មិនត្រូវការខ្សែសោ API ឬការហៅម៉ូដែលឡើយ។

### រចនាប័ទ្ម 2៖ ពាក់ម៉ូឌែលភាសា (Mocking Language Models)

ពេលធ្វើតេស្តตรវិទ្យាសន្ទនា សូមប្រើ Mockito ដើម្បីបង្កើតម៉ូឌែលបន្លំដែលត្រឡប់ចម្លើយដែលបានកំណត់ជាមុន។ វាធ្វើឱ្យតេស្តរហ័ស មិនគិតថ្លៃ និងមានលទ្ធផលមិនបម្លែង។

<img src="../../../translated_images/km/mock-vs-real.3b8b1f85bfe6845e.webp" alt="Mock vs Real API Comparison" width="800"/>

*ការប្រៀបធៀបបង្ហាញថា mocks ត្រូវបានពេញចិត្តសម្រាប់ធ្វើតេស្ត ហៅគេថារហ័ស មិនគិតថ្លៃ មានលទ្ធផលមិនបម្លែង និងមិនត្រូវការខ្សែសោ API*

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
        assertThat(history).hasSize(6); // ៣ សាររបស់អ្នកប្រើ + ៣ សាររបស់អ៊ីធី
    }
}
```

រចនាប័ទ្មនេះបង្ហាញក្នុង `01-introduction/src/test/java/com/example/langchain4j/service/SimpleConversationTest.java`។ Mock ផ្តល់ឱ្យមានអាកប្បកិរិយាដូចគ្នា ដូច្នេះអ្នកអាចពិនិត្យមើលថាការគ្រប់គ្រងចងចាំដំណើរការត្រឹមត្រូវ។

### រចនាប័ទ្ម 3៖ តេស្តការបំបែកសន្ទនា

ចងចាំសន្ទនានឹងត្រូវកាន់តែបំបែកអ្នកប្រើប្រាស់ជាច្រើន។ តេស្តនេះធ្វើការបញ្ជាក់ថាសន្ទនាគ្មានការលាយបញ្ចូលប្រភេទត្រួតពិនិត្យ context។

<img src="../../../translated_images/km/conversation-isolation.e00336cf8f7a3e3f.webp" alt="Conversation Isolation" width="800"/>

*តេស្តការបំបែកសន្ទនា បង្ហាញពីការផ្ទុកចងចាំជាច្រើនបំបែកសម្រាប់អ្នកប្រើប្រាស់ផ្សេងៗ ដើម្បីមិនឱ្យមានការលាយ context*

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

សន្ទនាទីមួយៗរក្សាប្រវត្តិសាស្រ្តឯករាជ្យរបស់ខ្លួន។ ក្នុងប្រព័ន្ធផលិតកម្ម ការបំបែកនេះសំខាន់សម្រាប់កម្មវិធីអ្នកប្រើជាច្រើន។

### រចនាប័ទ្ម 4៖ តេស្តឧបករណ៍ដោយឡែក

ឧបករណ៍គឺជាមុខងារដែល AI អាចហៅ។ តេស្តវាដោយផ្ទាល់ ដើម្បីធានាថាវាធ្វើការត្រឹមត្រូវដោយមិនគិតពីការសម្រេចចិត្ត AI។

<img src="../../../translated_images/km/tools-testing.3e1706817b0b3924.webp" alt="Tools Testing" width="800"/>

*តេស្តឧបករណ៍ដោយឡែក បង្ហាញពីរត់ឧបករណ៍ mock ដោយគ្មានការចូលរួម AI ដើម្បីពិនិត្យលទ្ធផលអាជីវកម្ម*

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

តេស្តទាំងនេះពី `04-tools/src/test/java/com/example/langchain4j/agents/tools/SimpleToolsTest.java` សម្គាល់លទ្ធផលឧបករណ៍ដោយមិនរួមបញ្ចូល AI។ ឧទាហរណ៍ចងខ្សែបង្ហាញពីរបៀបចេញលទ្ធផលឧបករណ៍មួយដល់ការបញ្ចូលឧបករណ៍មួយផ្សេងទៀត។

### រចនាប័ទ្ម 5៖ តេស្ត RAG In-Memory

ប្រព័ន្ធ RAG ជាទូទៅត្រូវការមូលដ្ឋានទិន្នន័យវ៉ិចទ័រ និងសេវាកម្ម embedding។ រៀងរាល់រចនាប័ទ្ម in-memory អនុញ្ញាតឱ្យអ្នកធ្វើតេស្តផ្ទាល់pipelineទាំងមូលដោយគ្មានការពឹងផ្អែកខាងក្រៅ។

<img src="../../../translated_images/km/rag-testing.ee7541b1e23934b1.webp" alt="In-Memory RAG Testing" width="800"/>

*ដំណើរការតេស្ត RAG in-memory បង្ហាញពីការបំបែកឯកសារ, ជំនួយ embedding និងស្វែងរកស្រដៀង គ្មានតម្រូវការមូលដ្ឋានទិន្នន័យ*

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

តេស្តនេះពី `03-rag/src/test/java/com/example/langchain4j/rag/service/DocumentServiceTest.java` បង្កើតឯកសារនៅក្នុងចងចាំ ហើយពិនិត្យមើលការបំបែកខ្នាត និងការដាក់ទិន្នន័យ meta។

### រចនាប័ទ្ម 6៖ តេស្តរួមបញ្ចូល MCP

ម៉ូឌុល MCP តេស្តការរួមបញ្ចូល Model Context Protocol ដោយប្រើការដឹកជញ្ជូន stdio។ តេស្តទាំងនោះបញ្ជាក់ថាកម្មវិធីរបស់អ្នកអាចបង្កើត និងទំនាក់ទំនងជាមួយម៉ាស៊ីនមេ MCP ជាទម្រង់ subprocess ។

តេស្តក្នុង `05-mcp/src/test/java/com/example/langchain4j/mcp/SimpleMcpTest.java` សម្គាល់អាកប្បកិរិយាអតិថិជន MCP។

**រត់វា៖**

**Bash:**
```bash
cd 05-mcp && mvn test
```

**PowerShell:**
```powershell
cd 05-mcp; mvn --% test
```

## ទស្សនៈការធ្វើតេស្ត

តេស្តកូដរបស់អ្នក មិនមែន AI ទេ។ តេស្តរបស់អ្នកគួរតែបញ្ជាក់ពីកូដដែលអ្នកសរសេរដោយពិនិត្យពីរបៀបកសាង prompt របៀបគ្រប់គ្រងការចងចាំ និងរបៀបអនុវត្តឧបករណ៍។ ប្រតិកម្ម AI ពេញចិត្តធ្វើការប្រែប្រួល ហើយមិនគួរជាផ្នែកនៃការត្រួតពិនិត្យតេស្តទេ។ សួរខ្លួនឯងថាតើទាន់គំរូ prompt របស់អ្នកប្ដូរអថេរបានត្រឹមត្រូវ, មិនមែន AI ទេ។

ប្រើ mocks សម្រាប់ម៉ូឌែលភាសា។ វាធ្វើជាមូលដ្ឋានខាងក្រៅ ដែលយឺត, ខ្លីថ្លៃ, និងមិនមានលទ្ធផលថេរ។ การ mock ធ្វើឲ្យតេស្តរហ័សក្នុងម៉ីលីវិនាទី មិនគិតថ្លៃ និងមានលទ្ធផលដោយមិនផ្លាស់ប្តូរ។

រក្សាតេស្តឲ្យដោយឯករាជ្យ។ តេស្តនីមួយៗគួរតែបង្កើតទិន្នន័យរបស់ខ្លួន ដោយមិនពឹងផ្អែកលើតេស្តផ្សេងទៀត និងសម្អាតបន្ទាប់ពីការរត់។ តេស្តគួរតែជោគជ័យដោយមិនគិតពីលំដាប់អនុវត្ត។

តេស្តករណីស៊ីតគែមៗក្រៅផ្លូវការអំណោយសុភមង្គល។ សាកល្បងបញ្ចូលទិន្នន័យទទេ, ទិន្នន័យធំ, តួអក្សរពិសេស, ប៉ារ៉ាម៉ែត្រខុសប្រក្រតី, និងលក្ខខណ្ឌគែម។ ពួកវាជាប់ឲ្យគ្រប់បញ្ហាដែលប្រើប្រាស់ធម្មតាមិនបង្ហាញ។

ប្រើឈ្មោះពណ៌នាថ្មីៗ។ ប្រៀបធៀប `shouldMaintainConversationHistoryAcrossMultipleMessages()` ជាមួយ `test1()`។ វាឲ្យដឹងជាក់លាក់ថាអ្វីត្រូវតេស្ត និងធ្វើឱ្យការបកស្រាយកំហុសកាន់តែងាយស្រួល។

## ជំហានបន្ទាប់

ឥឡូវនេះដែលអ្នកយល់ពីរចនាប័ទ្មតេស្ត ចូលរៀនជ្រាលជ្រៅក្នុងម៉ូឌុលនីមួយៗ៖

- **[01 - ការណែនាំ](../01-introduction/README.md)** - ធ្វើការគ្រប់គ្រងចងចាំសន្ទនា
- **[02 - هندسة الطلبات (Prompt Engineering)](../02/prompt-engineering/README.md)** - អនុវត្តលំនាំ GPT-5.2
- **[03 - RAG](../03-rag/README.md)** - បង្កើតប្រព័ន្ធបង្កើតឡើងវិញដោយការទាញយក
- **[04 - Tools](../04-tools/README.md)** - អនុវត្តហៅមុខងារ និងខ្សែឧបករណ៍
- **[05 - MCP](../05-mcp/README.md)** - រួមបញ្ចូល Model Context Protocol

README នៃម៉ូឌុលនិមួយៗផ្ដល់ការពន្យល់លម្អិតនៃគំនិតដែលបានតេស្តនៅទីនេះ។

---

**ច្រកចេញ៖** [← ត្រឡប់ទៅមុខវិចិត្រសាល](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:
ឯកសារនេះត្រូវបានបម្លែងភាសា ដោយប្រើសេវាបម្លែងភាសា AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ទោះយើងខ្ញុំមានក្តីប្រាថ្នាឱ្យបានច្បាស់លាស់ តែសូមយល់ដឹងថាការបម្លែងដោយស្វ័យប្រវត្តិក៏អាចមានកំហុសឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមជាភាសាទីតាំងគួរត្រូវបានគេប្រើជាប្រភពច្បាស់លាស់។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមណែនាំឱ្យប្រើប្រាស់ការប្រែដោយមនុស្សជំនាញ។ យើងខ្ញុំមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការបកស្រាយខុសបន្ទាប់ពីការប្រើប្រាស់ការបម្លែងនេះនោះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->