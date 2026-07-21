# LangChain4j အသုံးအနှုန်းစာအုပ်

## အကြောင်းအရာစာရင်း

- [အဓိကအယူအဆများ](#အဓိကအယူအဆများ)
- [LangChain4j အစိတ်အပိုင်းများ](#langchain4j-အစိတ်အပိုင်းများ)
- [AI/ML အယူအဆများ](#aiml-အယူအဆများ)
- [လုံခြုံရေးစနစ်များ](#လုံခြုံရေးစနစ်များ)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agents နှင့် Tools](#agents-and-tools---module-04)
- [Agentic Module](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure ဝန်ဆောင်မှုများ](#azure-services---module-01)
- [စမ်းသပ်ခြင်းနှင့် ဖွံ့ဖြိုးတိုးတက်မှု](#testing-and-development---testing-guide)

သင်တန်းအတွင်း အသုံးပြုသော အသုံးအနှုန်းများနှင့် အယူအဆများအတွက် အရှိန်အဟုန်မြန်စွာ ရှာဖွေရန်။

## အဓိကအယူအဆများ

**AI Agent** - AI ကို အသုံးပြုပြီး အလိုက်သင့်စိတ်ဖြင့် စဉ်းစား၍ လုပ်ဆောင်နိုင်သော စနစ်။ [Module 04](../04-tools/README.md)

**Chain** - အဆင့်ဆင့် လုပ်ဆောင်ချက်များစဉ်မှာ ထုတ်လွှင့်ချက်သည် နောက်တစ်ဆင့်တွင် သုံးစွဲသည်။

**Chunking** - စာရွက်စာတမ်းများကို အစိတ်အပိုင်းသေးသည်အထိ ခွဲခြားခြင်း။ ပုံမှန်: ၃၀၀-၅၀၀ token အတွင်း overlap ဖြင့်။ [Module 03](../03-rag/README.md)

**Context Window** - မော်ဒယ်တစ်ခု လက်ခံနိုင်သည့် အများဆုံး tokens အရေအတွက်။ GPT-5.2: ၄၀၀K tokens (အထိ ၂၇၂K input, ၁၂၈K output)။

**Embeddings** - စာသား အဓိပ္ပာယ်ကို သရုပ်ဖော်သည့် ကိန်းရေဗက်တာများ။ [Module 03](../03-rag/README.md)

**Function Calling** - မော်ဒယ်က ဂဏန်းပုံစံ အတောင်းခံချက်များဖန်တီး၍ ပြင်ပ function များကို ခေါ်ဆောင်သည်။ [Module 04](../04-tools/README.md)

**Hallucination** - မော်ဒယ်မှ မှားယွင်းသည့် သို့သော် ယုံကြည်နိုင်သော အချက်အလက်ကို ဖန်တီးခြင်း။

**Prompt** - ဘာသာစကားမော်ဒယ်ထံစာသားထည့်သွင်းချက်။ [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - keywords မဟုတ်ဘဲ အဓိပ္ပာယ်အရ ရှာဖွေမှု။ [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: မှတ်ဉာဏ်မရှိပါ။ Stateful: စကားပြောဆိုမှုပြီးခဲ့သည်များကို ထိန်းသိမ်းသည်။ [Module 01](../01-introduction/README.md)

**Tokens** - မော်ဒယ်များက လုပ်ဆောင်သော အခြေခံစာသားအချက်များ။ ကုန်ကျစရိတ်နှင့် ကန့်သတ်ချက်များကို သက်ရောက်စေသည်။ [Module 01](../01-introduction/README.md)

**Tool Chaining** - တစ်ခုချင်းစီ တိုးတက်အောင်သုံးသည့် tools များကို စဉ်ဆက်မပြတ် ချိတ်ဆက်အသုံးပြုခြင်း။ [Module 04](../04-tools/README.md)

## LangChain4j အစိတ်အပိုင်းများ

**AiServices** - Type-safe AI ဝန်ဆောင်မှု အင်တာဖေ့စ်များ ဖန်တီးသည်။

**OpenAiOfficialChatModel** - OpenAI နှင့် Azure OpenAI မော်ဒယ်များအတွက် အမျိုးသား client တစ်ခု။

**OpenAiOfficialEmbeddingModel** - OpenAI Official client ဖြင့် embeddings ဖန်တီးသည် (OpenAI နှင့် Azure OpenAI နှစ်မျိုးလုံးကို ထောက်ပံ့သည်)။

**ChatModel** - ဘာသာစကားမော်ဒယ်များအတွက် အဓိက အင်တာဖေ့စ်။

**ChatMemory** - စကားပြောဆိုမှုမှတ်တမ်း ထိန်းသိမ်းသည်။

**ContentRetriever** - RAG အတွက် သက်ဆိုင်ရာ စာရွက်စာတမ်း အစိတ်အပိုင်းများ ရှာဖွေသည်။

**DocumentSplitter** - စာရွက်စာတမ်းများကို ခွဲခြားသည်။

**EmbeddingModel** - စာသားကို ကိန်းရေဗက်တာများသို့ ပြောင်းလဲသည်။

**EmbeddingStore** - Embeddings များကို သိမ်းဆည်းပြီး ပြန်လည် ရယူနိုင်သည်။

**MessageWindowChatMemory** - နောက်ဆုံးပို့သော စာတိုများကို စိမ့်ကပ်ထားသော အပြေးအစီအစဉ်။

**PromptTemplate** - `{{variable}}` ထည့်သွင်းထားသော ပြန်လည်အသုံးပြုနိုင်သော prompt များ ဖန်တီးသည်။

**TextSegment** - metadata ပါသော စာသားအစိတ်အပိုင်း။ RAG တွင် အသုံးပြုသည်။

**ToolExecutionRequest** - tool အသုံးပြုမှု အတွက် တင်သွင်းချက်ကို ဖော်ပြသည်။

**UserMessage / AiMessage / SystemMessage** - စကားပြောဆိုမှု သတင်းပို့အစုံ။

## AI/ML အယူအဆများ

**Few-Shot Learning** - Prompt များတွင် ဥပမာများ ထည့်သွင်းပေးခြင်း။ [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - စာသားကြီးများအားပေါင်းစည်း၍ လေ့ကျင့်ထားသော AI မော်ဒယ်များ။

**Reasoning Effort** - GPT-5.2 ၏ စဉ်းစားနက်ရှိုင်းမှု ထိန်းချုပ်ရန် ပါရာမီတာ။ [Module 02](../02-prompt-engineering/README.md)

**Temperature** - ထွက်ရှိမည့် အချက်အလက် အမှားလွတ်နည်းသတ်မှတ်ချက်။ နိမ့်ရင် စနစ်တကျ၊ မြင့်ရင် ဖန်တီးမှုမြင့်။

**Vector Database** - Embeddings များ အတွက် အထူးသီးသန့်ဒေတာဘေ့စ်။ [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - ဥပမာများ မပါဘဲ အလုပ်လုပ်ဆောင်နိုင်ခြင်း။ [Module 02](../02-prompt-engineering/README.md)

## လုံခြုံရေးစနစ်များ

**Defense in Depth** - အလွှာအနှစ်သာရများဖြင့် အလုံအလောက် လုံခြုံရေးတန်ခိုးတိုးမြှင့်ခြင်း။

**Hard Block** - ပြင်းထန်သော အကြောင်းပြချက်များအတွက် ကုန်ကြမ်း HTTP 400 အမှားပစ်ခြင်း။

**InputGuardrail** - LangChain4j ၏ interface တစ်ခုဖြစ်ပြီး၊ LLM တွင် ကြိုတင်ရောက်မည့် အသုံးပြုသူ input များကို အတည်ပြုမှုလုပ်သည်။ ဒါမှတဆင့် ကုန်ကျစရိတ်နှင့် ကြာချိန်လျော့ကြေးတယ်။

**InputGuardrailResult** - guardrail အတည်ပြုမှု အမျိုးအစား။ `success()` သို့မဟုတ် `fatal("reason")` ဖြင့် ပြန်လည်ထုတ်ပေးသည်။

**OutputGuardrail** - AI အဖြေများ အသုံးပြုသူထံ ပေးပို့ရန်မတိုင်မှီ စစ်ဆေးခြင်းအတွက် interface။

**Provider Safety Filters** - AI ပံ့ပိုးသူများ (ဥပမာ Azure OpenAI) မှ ဆက်သွယ်မှု API အဆင့်တွင် ချုပ်ဆိုထားသော အကြောင်းအရာ စစ်တမ်းများ။

**Soft Refusal** - မော်ဒယ်က အမှားမဖြစ်ပေါ်ဘဲ စိတ်ညစ်ဓာတ်မပေးဘဲ ဖြေရှင်းပေးတယ်။

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - တဆင့်ဆင့် စဉ်းစားချက် များဖြင့် တိကျမှန်ကန်မှုပိုမိုရရှိစေခြင်း။

**Constrained Output** - အတိုးစနစ်တကျ အသုံးပြုရန် ပုံစံသတ်မှတ်ခြင်း။

**High Eagerness** - GPT-5.2 ၏ နက်ရှိုင်းစွာ စဉ်းစားမှုပုံစံ။

**Low Eagerness** - GPT-5.2 ၏ မြန်ဆန်စွာ ဖြေကြားပုံ။

**Multi-Turn Conversation** - ဆက်လက်အောင် တုံ့ပြန်မှုရှိရန် သတင်းအချက်အလက် ထိန်းသိမ်းခြင်း။

**Role-Based Prompting** - မော်ဒယ်ကို အမျိုးအစားသတ်မှတ်ရန် system messages ဖြင့် သတ်မှတ်ခြင်း။

**Self-Reflection** - မော်ဒယ်သည် မိမိ၏ထွက်ရှိမှုကို စစ်ဆေး၊ တိုးတက်စေရန် ကြိုးစားခြင်း။

**Structured Analysis** - ကန့်သတ်ထားသော အကဲဖြတ်စနစ်။

**Task Execution Pattern** - အစီအစဉ်ရေးဆွဲ → လုပ်ဆောင် → အကျဉ်းချုပ်။

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - တွဲဆက်: ယူရန် → အစိတ်အပိုင်း ခွဲရန် → Embed ဆွဲရန် → သိမ်းဆည်းရန်။

**In-Memory Embedding Store** - စမ်းသပ်မှုအတွက် ထိန်းသိမ်းမှု မရှိသော ဒေတာသိုလှောင်ခြင်း။

**RAG** - ရှာဖွေမှုနှင့် ဖန်တီးမှုကို ပေါင်းစပ်၍ တုံ့ပြန်ချက်အခြေခံမှု ပေးသည်။

**Similarity Score** - Semantic တူညီမှု ရမှတ် (0-1)။

**Source Reference** - ရရှိသော အကြောင်းအရာ metadata။

## Agents နှင့် Tools - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Java နည်းစနစ်များအား AI ခေါ်နိုင်သော tools အဖြစ် သတ်မှတ်သည်။

**ReAct Pattern** - စဉ်းစား → လုပ်ဆောင် → လေ့လာ → ထပ်မံလုပ်ဆောင်ခြင်း။

**Session Management** - အသုံးပြုသူများအလိုက် ဖွင့်ထားသော context များကို သီးခြားထားပေးခြင်း။

**Tool** - AI agent တိုက်ရိုက်ခေါ်နိုင်သော function တစ်ခု။

**Tool Description** - tool ၏ ရည်ရွယ်ချက် နှင့် ပါရာမီတာ ဖော်ပြချက်။

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - AI agent များအဖြစ် interface များ သတ်မှတ်ပြီး ချကောင်းပြုမူ အကျဉ်းဖော်ခြင်း။

**Agent Listener** - Agent လုပ်ငန်းစဉ်ကို `beforeAgentInvocation()` နှင့် `afterAgentInvocation()` မှတဆင့် ကြည့်လိုက်ခြင်း။

**Agentic Scope** - agent များ output ကို သိမ်းဆည်းထားသော memory ပိုင်း။

**AgenticServices** - `agentBuilder()` နှင့် `supervisorBuilder()` ဖြင့် agent ဖန်တီးရာ factory။

**Conditional Workflow** - အခြေအနေများပေါ်မူတည်၍ သီးခြား agent များဖွင့်သုံးခြင်း။

**Human-in-the-Loop** - အတည်ပြုခြင်း သို့မဟုတ် အကြောင်းအရာ ကြည့်ရှုရန် လူကို ထည့်သွင်းသည့် workflow ပုံစံ။

**langchain4j-agentic** - Declarative agent ဖန်တီးရေးရန် Maven သတ်မှတ်ချက် (စမ်းသပ်မှုအစိတ်အပိုင်း)။

**Loop Workflow** - အခြေအနေဖြစ်တဲ့အထိ agent များ တစ်ကြိမ်ပြီးတစ်ကြိမ် ဆက်လုပ်ခြင်း (ဥပမာ quality score ≥ 0.8)။

**outputKey** - Agent annotation parameter ဖြစ်ပြီး agentic Scope တွင် ပြန်သိမ်းရာများ။

**Parallel Workflow** - လွတ်လပ်သော အလုပ်များအတွက် agent များကို တပြိုင်နက် ဆောင်ရွက်ခြင်း။

**Response Strategy** - supervisor သည် နောက်ဆုံးဖြေချက်ကို LAST, SUMMARY, သို့မဟုတ် SCORED အနေနှင့် ဖော်ပြခြင်း။

**Sequential Workflow** - အဆင့်လိုက် agent များကို ဆောင်ရွက်၍  outputသည် နောက်တစ်ဆင့်သို့ စီးဆင်းမှု။

**Supervisor Agent Pattern** - တိုးတက်သော agentic ပုံစံဖြစ်ပြီး supervisor LLM သည် စိတ်ကြိုက် sub-agent များခေါ်ယူခြင်း။

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j ထဲတွင် MCP ပေါင်းစည်းမှုအတွက် Maven သတ်မှတ်ချက်။

**MCP** - Model Context Protocol: AI အပ်ပလီကေးရှင်းများကို ပြင်ပ tools နှင့် ချိတ်ဆက်မှုစံကြားစနစ်။ တစ်ကြိမ်တည်ဆောက်၍ အားလုံးတွင် အသုံးပြုနိုင်သည်။

**MCP Client** - MCP server များနှင့် ချိတ်ဆက်၍ tool များ ရှာဖွေ သုံးစွဲသည့် အက်ပ်။

**MCP Server** - Tool များကို MCP ဖြင့် ထုတ်ဖေါ်ထားသော ဝန်ဆောင်မှု။ ဖော်ပြချက်နှင့် ပြင္ပ parameter schema ပါရှိသည်။

**McpToolProvider** - AI ဝန်ဆောင်မှုများနှင့် agent များတွင် MCP tools အသုံးပြုရန် LangChain4j အစိတ်အပိုင်း။

**McpTransport** - MCP ဆက်သွယ်ရေး interface။ စနစ်အသုံးချချက်များတွင် Stdio နှင့် HTTP ပါဝင်သည်။

**Stdio Transport** - ဒေသန္တရ လုပ်ငန်းစဉ်များအတွက် stdin/stdout ဖြင့် ဆက်သွယ်သော транспорт။

**StdioMcpTransport** - MCP server ကို subprocess အဖြစ် ဖန်တီးသော LangChain4j အကောင်အထည်ဖော်မှု။

**Tool Discovery** - Client သည် မြှင့်တင်မှု နှင့် schemas များနဲ့ tool များ ရှာဖွေမေးမြန်းခြင်း။

## Azure ဝန်ဆောင်မှုများ - [Module 01](../01-introduction/README.md)

**Azure AI Search** - vector ဆိုင်ရာ လက္ခဏာဖြင့် cloud search။ [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azure အရင်းအမြစ်များ ထုတ်လုပ်ခြင်း။

**Azure OpenAI** - Microsoft ၏ စီးပွားရေး AI ဝန်ဆောင်မှု။

**Bicep** - Azure အခြေခံအချက်အလက်-ကုဒ် ဘာသာစကား။ [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Azure တွင် မော်ဒယ် deployment အမည်။

**GPT-5.2** - reasoning ထိန်းချုပ်မှုပါသော နောက်ဆုံး OpenAI မော်ဒယ်။ [Module 02](../02-prompt-engineering/README.md)

## စမ်းသပ်ခြင်းနှင့် ဖွံ့ဖြိုးတိုးတက်မှု - [Testing Guide](TESTING.md)

**Dev Container** - ကွန်တိန်နာ အခြေပြု ဖွံ့ဖြိုးရေး ပတ်ဝန်းကျင်။ [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - မွမ်းမံထားသော မှတ်ဉာဏ်တွင် စမ်းသပ်ခြင်း။

**Integration Testing** - တကယ့် အခြေခံအဆောက်အအုံဖြင့် စမ်းသပ်ခြင်း။

**Maven** - Java build automation မော်ဂျူး။

**Mockito** - Java mocking framework။

**Spring Boot** - Java application framework။ [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ပြောကြားချက်**
ဤစာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးပမ်းနေသော်လည်း၊ စက်ကိရိယာဘာသာပြန်ခြင်းများတွင် အမှားများ သို့မဟုတ် မှားယွင်းချက်များ ပါဝင်နိုင်ကြောင်း သတိပြုပါရန် လိုအပ်ပါသည်။ မူလစာတမ်းကို မူရင်းဘာသာဖြင့်သာ ယုံကြည်စိတ်ချရသော အချက်အလက်အဖြစ် သတ်မှတ်သင့်သည်။ အရေးကြီးသည့် သတင်းအချက်အလက်များအတွက် ပရော်ဖက်ရှင်နယ် လူသားဘာသာပြန်သူဝန်ဆောင်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော နားလည်မှုကွာခြားမှုများ သို့မဟုတ် မမှန်ကန်သော အသုံးပြုမှုများအတွက် ကျွန်ုပ်တို့ တာဝန်မခံပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->