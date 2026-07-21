# LangChain4j Ordlist

## Indholdsfortegnelse

- [Kernebegreber](#kernebegreber)
- [LangChain4j Komponenter](#langchain4j-komponenter)
- [AI/ML Begreber](#aiml-begreber)
- [Sikkerhedsspærrer](#sikkerhedsspærrer)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenter og Værktøjer](#agents-and-tools---module-04)
- [Agentisk Modul](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Tjenester](#azure-services---module-01)
- [Test og Udvikling](#testing-and-development---testing-guide)

Hurtig reference for termer og begreber brugt gennem hele kurset.

## Kernebegreber

**AI Agent** - System der bruger AI til at ræsonnere og handle autonomt. [Modul 04](../04-tools/README.md)

**Chain** - Sekvens af operationer hvor output føres ind i næste trin.

**Chunking** - Opdeling af dokumenter i mindre stykker. Typisk: 300-500 tokens med overlap. [Modul 03](../03-rag/README.md)

**Context Window** - Maksimalt antal tokens en model kan behandle. GPT-5.2: 400K tokens (op til 272K input, 128K output).

**Embeddings** - Numeriske vektorer der repræsenterer teksts betydning. [Modul 03](../03-rag/README.md)

**Function Calling** - Model genererer strukturerede forespørgsler til at kalde eksterne funktioner. [Modul 04](../04-tools/README.md)

**Hallucination** - Når modeller genererer ukorrekt, men plausibel information.

**Prompt** - Tekstinput til en sprogmodel. [Modul 02](../02-prompt-engineering/README.md)

**Semantic Search** - Søgning efter betydning vha. embeddings, ikke nøgleord. [Modul 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: ingen hukommelse. Stateful: opretholder samtalehistorik. [Modul 01](../01-introduction/README.md)

**Tokens** - Grundlæggende tekst-enheder modeller behandler. Påvirker omkostninger og begrænsninger. [Modul 01](../01-introduction/README.md)

**Tool Chaining** - Sekventiel udførelse af værktøjer hvor output informerer næste kald. [Modul 04](../04-tools/README.md)

## LangChain4j Komponenter

**AiServices** - Opretter type-sikre AI service interfaces.

**OpenAiOfficialChatModel** - Unified klient til OpenAI og Azure OpenAI modeller.

**OpenAiOfficialEmbeddingModel** - Opretter embeddings med OpenAI Official klient (understøtter både OpenAI og Azure OpenAI).

**ChatModel** - Kerneinterface for sprogmodeller.

**ChatMemory** - Opretholder samtalehistorik.

**ContentRetriever** - Finder relevante dokumentudsnit til RAG.

**DocumentSplitter** - Opdeler dokumenter i stykker.

**EmbeddingModel** - Konverterer tekst til numeriske vektorer.

**EmbeddingStore** - Gemmer og henter embeddings.

**MessageWindowChatMemory** - Opretholder glidende vindue af seneste beskeder.

**PromptTemplate** - Opretter genanvendelige prompts med `{{variable}}` pladsholdere.

**TextSegment** - Tekststykke med metadata. Bruges i RAG.

**ToolExecutionRequest** - Repræsenterer værktøjsudførelsesanmodning.

**UserMessage / AiMessage / SystemMessage** - Samtale beskedtyper.

## AI/ML Begreber

**Few-Shot Learning** - Tilvejebringer eksempler i prompts. [Modul 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI modeller trænet på enorm tekstdata.

**Reasoning Effort** - GPT-5.2 parameter der styrer tænkedybde. [Modul 02](../02-prompt-engineering/README.md)

**Temperature** - Styrer output-tilfældighed. Lav=deterministisk, høj=kreativ.

**Vector Database** - Specialiseret database til embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Udfører opgaver uden eksempler. [Modul 02](../02-prompt-engineering/README.md)

## Sikkerhedsspærrer

**Defense in Depth** - Flerlags sikkerhedstilgang der kombinerer applikationsniveau sikkerhedsspærrer med providersikkerhedsfiltre.

**Hard Block** - Provider kaster HTTP 400 fejl ved alvorlige indholdsbrud.

**InputGuardrail** - LangChain4j interface til validering af brugerinput før det når LLM. Sparrer omkostninger og latenstid ved tidligt at blokere skadelige prompts.

**InputGuardrailResult** - Returneringstype for sikkerhedsspærrevalidering: `success()` eller `fatal("grund")`.

**OutputGuardrail** - Interface til validering af AI-svar før returnering til brugere.

**Provider Safety Filters** - Indbyggede indholdsfiltre fra AI-udbydere (fx Azure OpenAI) der fanger overtrædelser på API-niveau.

**Soft Refusal** - Model afviser høfligt at svare uden at kaste fejl.

## Prompt Engineering - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Trinvis ræsonnering for bedre nøjagtighed.

**Constrained Output** - Håndhæver specifikt format eller struktur.

**High Eagerness** - GPT-5.2 mønster til grundig ræsonnering.

**Low Eagerness** - GPT-5.2 mønster til hurtige svar.

**Multi-Turn Conversation** - Opretholder kontekst på tværs af udvekslinger.

**Role-Based Prompting** - Indstiller modelpersona via systembeskeder.

**Self-Reflection** - Model evaluerer og forbedrer sit output.

**Structured Analysis** - Fastsat evalueringsramme.

**Task Execution Pattern** - Plan → Udfør → Opsummer.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Document Processing Pipeline** - Indlæs → opdel → embed → gem.

**In-Memory Embedding Store** - Ikke-permanent lagring til test.

**RAG** - Kombinerer søgning med generering for at forankre svar.

**Similarity Score** - Mål (0-1) af semantisk lighed.

**Source Reference** - Metadata om hentet indhold.

## Agenter og Værktøjer - [Modul 04](../04-tools/README.md)

**@Tool Annotation** - Marker Java metoder som AI-kaldbare værktøjer.

**ReAct Pattern** - Tænk → Handle → Observer → Gentag.

**Session Management** - Separate kontekster for forskellige brugere.

**Tool** - Funktion en AI-agent kan kalde.

**Tool Description** - Dokumentation af værktøjets formål og parametre.

## Agentisk Modul - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** - Marker interfaces som AI-agenter med deklarativ adfærdsdefinition.

**Agent Listener** - Krog til overvågning af agentudførelse via `beforeAgentInvocation()` og `afterAgentInvocation()`.

**Agentic Scope** - Delt hukommelse hvor agenter gemmer output med `outputKey` til efterfølgende agenter.

**AgenticServices** - Fabrik til at skabe agenter via `agentBuilder()` og `supervisorBuilder()`.

**Conditional Workflow** - Rute baseret på betingelser til forskellige specialistagenter.

**Human-in-the-Loop** - Arbejdsgangsmønster der tilføjer menneskelige tjekpunkter til godkendelse eller indholdsrevision.

**langchain4j-agentic** - Maven-afhængighed til deklarativ agentbygning (eksperimentel).

**Loop Workflow** - Iterér agentudførelse indtil en betingelse er opfyldt (fx kvalitetsscore ≥ 0.8).

**outputKey** - Agentannoteringsparameter der angiver hvor resultater gemmes i Agentic Scope.

**Parallel Workflow** - Kør flere agenter samtidigt til uafhængige opgaver.

**Response Strategy** - Hvordan supervisor formulerer endeligt svar: LAST, SUMMARY eller SCORED.

**Sequential Workflow** - Udfør agenter i rækkefølge hvor output flyder til næste trin.

**Supervisor Agent Pattern** - Avanceret agentisk mønster hvor en supervisor LLM dynamisk beslutter hvilke underagenter der skal kaldes.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven-afhængighed til MCP integration i LangChain4j.

**MCP** - Model Context Protocol: standard for at forbinde AI apps til eksterne værktøjer. Byg én gang, brug overalt.

**MCP Client** - Applikation der forbinder til MCP servere for at opdage og bruge værktøjer.

**MCP Server** - Service der eksponerer værktøjer via MCP med klare beskrivelser og parameterskemaer.

**McpToolProvider** - LangChain4j komponent der indkapsler MCP værktøjer til brug i AI tjenester og agenter.

**McpTransport** - Interface til MCP kommunikation. Implementeringer inkluderer Stdio og HTTP.

**Stdio Transport** - Lokal procestransport via stdin/stdout. Nyttig til filsystemadgang eller kommandolinjeværktøjer.

**StdioMcpTransport** - LangChain4j implementering der starter MCP server som underproces.

**Tool Discovery** - Client spørger server om tilgængelige værktøjer med beskrivelser og skemaer.

## Azure Tjenester - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Cloud-søgning med vektor kapabiliteter. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Udruller Azure ressourcer.

**Azure OpenAI** - Microsofts enterprise AI service.

**Bicep** - Azure infra-as-code sprog. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Navn til modeludrulning i Azure.

**GPT-5.2** - Seneste OpenAI model med ræsonneringskontrol. [Modul 02](../02-prompt-engineering/README.md)

## Test og Udvikling - [Testing Guide](TESTING.md)

**Dev Container** - Containeriseret udviklingsmiljø. [Konfiguration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Test med in-memory lagring.

**Integration Testing** - Test med ægte infrastruktur.

**Maven** - Java byggeautomatiseringsværktøj.

**Mockito** - Java mocking framework.

**Spring Boot** - Java applikationsframework. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal du være opmærksom på, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os intet ansvar for misforståelser eller fejltolkninger, der opstår som følge af brugen af denne oversættelse.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->