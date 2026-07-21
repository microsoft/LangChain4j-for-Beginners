# LangChain4j Ordlista

## Innehållsförteckning

- [Kärnkoncept](#kärnkoncept)
- [LangChain4j Komponenter](#langchain4j-komponenter)
- [AI/ML Koncept](#aiml-koncept)
- [Guardrails](#guardrails)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenter och Verktyg](#agents-and-tools---module-04)
- [Agentic Modul](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Tjänster](#azure-services---module-01)
- [Testning och Utveckling](#testing-and-development---testing-guide)

Snabbreferens för termer och koncept som används i hela kursen.

## Kärnkoncept

**AI Agent** - System som använder AI för att resonera och agera autonomt. [Modul 04](../04-tools/README.md)

**Chain** - Sekvens av operationer där output matas in i nästa steg.

**Chunking** - Bryta dokument i mindre bitar. Typiskt: 300-500 tokens med överlappning. [Modul 03](../03-rag/README.md)

**Context Window** - Max antal tokens en modell kan bearbeta. GPT-5.2: 400K tokens (upp till 272K input, 128K output).

**Embeddings** - Numeriska vektorer som representerar textens mening. [Modul 03](../03-rag/README.md)

**Function Calling** - Modell genererar strukturerade förfrågningar för att anropa externa funktioner. [Modul 04](../04-tools/README.md)

**Hallucination** - När modeller genererar felaktig men trovärdig information.

**Prompt** - Texteingång till en språkmodell. [Modul 02](../02-prompt-engineering/README.md)

**Semantic Search** - Sökning baserad på mening med embeddings, inte nyckelord. [Modul 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: inget minne. Stateful: bibehåller konversationshistorik. [Modul 01](../01-introduction/README.md)

**Tokens** - Grundläggande textenheter som modeller bearbetar. Påverkar kostnader och begränsningar. [Modul 01](../01-introduction/README.md)

**Tool Chaining** - Sekventiell verktygsexekvering där output informerar nästa anrop. [Modul 04](../04-tools/README.md)

## LangChain4j Komponenter

**AiServices** - Skapar typsäkra AI-tjänstegränssnitt.

**OpenAiOfficialChatModel** - Enhetlig klient för OpenAI och Azure OpenAI modeller.

**OpenAiOfficialEmbeddingModel** - Skapar embeddings med OpenAI Official klient (stöder både OpenAI och Azure OpenAI).

**ChatModel** - Kärngränssnitt för språkmodeller.

**ChatMemory** - Bibehåller konversationshistorik.

**ContentRetriever** - Hittar relevanta dokumentbitar för RAG.

**DocumentSplitter** - Delar upp dokument i bitar.

**EmbeddingModel** - Omvandlar text till numeriska vektorer.

**EmbeddingStore** - Lagrar och hämtar embeddings.

**MessageWindowChatMemory** - Bibehåller ett glidande fönster av senaste meddelanden.

**PromptTemplate** - Skapar återanvändbara prompts med `{{variable}}` platshållare.

**TextSegment** - Textbit med metadata. Används i RAG.

**ToolExecutionRequest** - Representerar begäran om verktygsexekvering.

**UserMessage / AiMessage / SystemMessage** - Typer av meddelanden i konversation.

## AI/ML Koncept

**Few-Shot Learning** - Tillhandahålla exempel i prompts. [Modul 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI-modeller tränade på stora mängder textdata.

**Reasoning Effort** - GPT-5.2 parameter som styr tänkardjup. [Modul 02](../02-prompt-engineering/README.md)

**Temperature** - Styr slumpmässighet i output. Låg=deterministisk, hög=kreativ.

**Vector Database** - Specialiserad databas för embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Utföra uppgifter utan exempel. [Modul 02](../02-prompt-engineering/README.md)

## Guardrails

**Defense in Depth** - Flerlagerssäkerhetsstrategi som kombinerar applikationsnivå guardrails med leverantörers säkerhetsfilter.

**Hard Block** - Leverantör kastar HTTP 400-fel vid allvarliga innehållsbrott.

**InputGuardrail** - LangChain4j-gränssnitt för validering av användarinmatning innan den når LLM. Sparar kostnad och latens genom att blockera skadliga prompts tidigt.

**InputGuardrailResult** - Returtyp för guardrail-validering: `success()` eller `fatal("anledning")`.

**OutputGuardrail** - Gränssnitt för validering av AI-svar innan de returneras till användare.

**Provider Safety Filters** - Inbyggda innehållsfilter från AI-leverantörer (t.ex. Azure OpenAI) som fångar överträdelser på API-nivå.

**Soft Refusal** - Modell artigt avböjer att svara utan att kasta fel.

## Prompt Engineering - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Steg-för-steg-resonemang för bättre noggrannhet.

**Constrained Output** - Påtvinga specifikt format eller struktur.

**High Eagerness** - GPT-5.2 mönster för grundligt resonemang.

**Low Eagerness** - GPT-5.2 mönster för snabba svar.

**Multi-Turn Conversation** - Bibehålla kontext genom utbyten.

**Role-Based Prompting** - Sätta modellpersona via systemmeddelanden.

**Self-Reflection** - Modell utvärderar och förbättrar sin output.

**Structured Analysis** - Fast utvärderingsramverk.

**Task Execution Pattern** - Planera → Utför → Sammanfatta.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Document Processing Pipeline** - Ladda → dela upp → embedda → lagra.

**In-Memory Embedding Store** - Icke-persistenta lagring för testning.

**RAG** - Kombinerar återvinning med generering för att markförankra svar.

**Similarity Score** - Mått (0-1) på semantisk likhet.

**Source Reference** - Metadata om hämtat innehåll.

## Agenter och Verktyg - [Modul 04](../04-tools/README.md)

**@Tool Annotation** - Markerar Java-metoder som AI-anropbara verktyg.

**ReAct Pattern** - Resonera → Agera → Observera → Upprepa.

**Session Management** - Separata kontexter för olika användare.

**Tool** - Funktion som en AI-agent kan anropa.

**Tool Description** - Dokumentation av verktygets syfte och parametrar.

## Agentic Modul - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** - Markerar gränssnitt som AI-agenter med deklarativ beteendedefinition.

**Agent Listener** - Hook för att övervaka agentexekvering via `beforeAgentInvocation()` och `afterAgentInvocation()`.

**Agentic Scope** - Delat minne där agenter lagrar output med `outputKey` för nedströmsagenter att konsumera.

**AgenticServices** - Fabrik för att skapa agenter med `agentBuilder()` och `supervisorBuilder()`.

**Conditional Workflow** - Rutterar baserat på villkor till olika specialagentern.

**Human-in-the-Loop** - Arbetsflödesmönster som lägger till mänskliga kontrollpunkter för godkännande eller innehållsgranskning.

**langchain4j-agentic** - Maven-beroende för deklarativ agentbyggnad (experimentell).

**Loop Workflow** - Iterera agentexekvering tills ett villkor uppfylls (t.ex. kvalitetspoäng ≥ 0.8).

**outputKey** - Agentannotationsparameter som specificerar var resultat ska lagras i Agentic Scope.

**Parallel Workflow** - Kör flera agenter samtidigt för oberoende uppgifter.

**Response Strategy** - Hur supervisor formulerar slutligt svar: LAST, SUMMARY eller SCORED.

**Sequential Workflow** - Kör agenter i ordning där output flyter till nästa steg.

**Supervisor Agent Pattern** - Avancerat agentmönster där en supervisor-LLM dynamiskt bestämmer vilka underagenter som ska anropas.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven-beroende för MCP-integration i LangChain4j.

**MCP** - Model Context Protocol: standard för att koppla AI-appar till externa verktyg. Bygg en gång, använd överallt.

**MCP Client** - Applikation som kopplar till MCP-servrar för att upptäcka och använda verktyg.

**MCP Server** - Tjänst som exponerar verktyg via MCP med tydliga beskrivningar och parameterscheman.

**McpToolProvider** - LangChain4j-komponent som kapslar MCP-verktyg för användning i AI-tjänster och agenter.

**McpTransport** - Gränssnitt för MCP-kommunikation. Implementationer inkluderar Stdio och HTTP.

**Stdio Transport** - Lokal processtransport via stdin/stdout. Användbart för filsystemåtkomst eller kommandoradsverktyg.

**StdioMcpTransport** - LangChain4j-implementation som startar MCP-server som subprocess.

**Tool Discovery** - Klient frågar server om tillgängliga verktyg med beskrivningar och scheman.

## Azure Tjänster - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Molnsökning med vektor kapabiliteter. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Distribuerar Azure-resurser.

**Azure OpenAI** - Microsofts företags-AI-tjänst.

**Bicep** - Azure infrastruktur-som-kod språk. [Infrastruktur Guide](../01-introduction/infra/README.md)

**Deployment Name** - Namn för modellutplacering i Azure.

**GPT-5.2** - Senaste OpenAI-modellen med styrning av resonemang. [Modul 02](../02-prompt-engineering/README.md)

## Testning och Utveckling - [Testningsguide](TESTING.md)

**Dev Container** - Containeriserad utvecklingsmiljö. [Konfiguration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Testning med minneslagring.

**Integration Testing** - Testning med riktig infrastruktur.

**Maven** - Java-byggautomationsverktyg.

**Mockito** - Java mockningsramverk.

**Spring Boot** - Java applikationsramverk. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfriskrivning**:
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, var vänlig notera att automatiska översättningar kan innehålla fel eller brister. Det ursprungliga dokumentet på dess modersmål bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för några missförstånd eller feltolkningar som uppstår till följd av användningen av denna översättning.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->