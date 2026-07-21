# LangChain4j Verklarende Woordenlijst

## Inhoudsopgave

- [Kernconcepten](#kernconcepten)
- [LangChain4j Componenten](#langchain4j-componenten)
- [AI/ML Concepten](#aiml-concepten)
- [Beveiligingsmaatregelen](#beveiligingsmaatregelen)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenten en Tools](#agenten-en-tools---module-04)
- [Agentic Module](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Diensten](#azure-diensten---module-01)
- [Testen en Ontwikkeling](#testen-en-ontwikkeling---testing-guide)

Snelle referentie voor termen en concepten die door de cursus heen worden gebruikt.

## Kernconcepten

**AI Agent** - Systeem dat AI gebruikt om autonoom te redeneren en te handelen. [Module 04](../04-tools/README.md)

**Chain** - Reeks bewerkingen waarbij uitgang gebruikt wordt als invoer voor de volgende stap.

**Chunking** - Documenten opdelen in kleinere stukjes. Typisch: 300-500 tokens met overlap. [Module 03](../03-rag/README.md)

**Context Window** - Maximale tokens die een model kan verwerken. GPT-5.2: 400K tokens (tot 272K input, 128K output).

**Embeddings** - Numerieke vectoren die de betekenis van tekst representeren. [Module 03](../03-rag/README.md)

**Function Calling** - Model genereert gestructureerde verzoeken om externe functies aan te roepen. [Module 04](../04-tools/README.md)

**Hallucinatie** - Wanneer modellen onjuiste maar geloofwaardige informatie genereren.

**Prompt** - Tekstinvoer voor een taalmodel. [Module 02](../02-prompt-engineering/README.md)

**Semantisch Zoeken** - Zoeken op betekenis met embeddings, niet met trefwoorden. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: geen geheugen. Stateful: houdt gesprekshistorie bij. [Module 01](../01-introduction/README.md)

**Tokens** - Basiseenheden van tekst die modellen verwerken. Beïnvloeden kosten en limieten. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Aaneenschakeling van tools waarbij output invoer is voor de volgende tool. [Module 04](../04-tools/README.md)

## LangChain4j Componenten

**AiServices** - Maakt type-veilige AI service interfaces aan.

**OpenAiOfficialChatModel** - Gefedereerde client voor OpenAI en Azure OpenAI modellen.

**OpenAiOfficialEmbeddingModel** - Maakt embeddings met OpenAI Official client (ondersteunt OpenAI en Azure OpenAI).

**ChatModel** - Kerninterface voor taalmodellen.

**ChatMemory** - Houdt de gesprekshistorie bij.

**ContentRetriever** - Vindt relevante documentstukken voor RAG.

**DocumentSplitter** - Verdeelt documenten in stukken.

**EmbeddingModel** - Zet tekst om in numerieke vectoren.

**EmbeddingStore** - Slaat embeddings op en haalt ze op.

**MessageWindowChatMemory** - Houdt een schuifvenster bij van recente berichten.

**PromptTemplate** - Maakt herbruikbare prompts met `{{variable}}`-plaatsen.

**TextSegment** - Tekststuk met metadata. Gebruikt in RAG.

**ToolExecutionRequest** - Vertegenwoordigt een tooluitvoeringsverzoek.

**UserMessage / AiMessage / SystemMessage** - Gesprekstypen berichten.

## AI/ML Concepten

**Few-Shot Learning** - Voorzien van voorbeelden in prompts. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI-modellen getraind op enorme hoeveelheden tekst.

**Reasoning Effort** - GPT-5.2 parameter die de diepte van het denken regelt. [Module 02](../02-prompt-engineering/README.md)

**Temperatuur** - Stuurt de willekeurigheid van output aan. Laag=deterministisch, hoog=creatief.

**Vector Database** - Gespecialiseerde database voor embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Taken uitvoeren zonder voorbeelden. [Module 02](../02-prompt-engineering/README.md)

## Beveiligingsmaatregelen

**Defense in Depth** - Meerdere beveiligingslagen die applicatiebeveiliging combineren met provider veiligheidsfilters.

**Hard Block** - Provider geeft HTTP 400 fout bij ernstige inhoudsovertredingen.

**InputGuardrail** - LangChain4j interface voor validatie van gebruikersinvoer voordat die bij het LLM terechtkomt. Bespaart kosten en vertraging door schadelijke prompts vroeg te blokkeren.

**InputGuardrailResult** - Retourtype voor beveiligingsvalidatie: `success()` of `fatal("reden")`.

**OutputGuardrail** - Interface voor het valideren van AI-antwoorden voordat ze aan gebruikers worden teruggegeven.

**Provider Safety Filters** - Ingebouwde inhoudsfilters van AI-providers (zoals Azure OpenAI) die overtredingen op API-niveau onderscheppen.

**Soft Refusal** - Model weigert beleefd om te antwoorden zonder een foutmelding te geven.

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Stapsgewijze redenatie voor betere nauwkeurigheid.

**Constrained Output** - Afdwingen van een specifiek formaat of structuur.

**High Eagerness** - GPT-5.2 patroon voor grondige redenering.

**Low Eagerness** - GPT-5.2 patroon voor snelle antwoorden.

**Multi-Turn Conversation** - Context behouden over meerdere uitwisselingen.

**Role-Based Prompting** - Modelpersoon instellen via systeemberichten.

**Self-Reflection** - Model evalueert en verbetert zijn eigen output.

**Structured Analysis** - Vast evaluatiekader.

**Task Execution Pattern** - Plannen → Uitvoeren → Samenvatten.

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Laden → opdelen → embedden → opslaan.

**In-Memory Embedding Store** - Niet-persistente opslag voor testen.

**RAG** - Combineert ophalen met genereren om antwoorden te funderen.

**Similarity Score** - Maat (0-1) van semantische gelijkenis.

**Source Reference** - Metadata over opgehaalde inhoud.

## Agenten en Tools - [Module 04](../04-tools/README.md)

**@Tool Annotatie** - Markeert Java-methoden als AI-oproepbare tools.

**ReAct Pattern** - Redeneren → Handelen → Observeren → Herhalen.

**Session Management** - Gescheiden contexten voor verschillende gebruikers.

**Tool** - Functie die een AI-agent kan aanroepen.

**Tool Description** - Documentatie over doel en parameters van tool.

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotatie** - Markeert interfaces als AI-agenten met declaratieve gedragsdefinitie.

**Agent Listener** - Hook voor monitoring van agentuitvoering via `beforeAgentInvocation()` en `afterAgentInvocation()`.

**Agentic Scope** - Gedeeld geheugen waar agenten uitvoer opslaan met `outputKey` voor andere agenten om te gebruiken.

**AgenticServices** - Fabriek voor het maken van agenten met `agentBuilder()` en `supervisorBuilder()`.

**Conditional Workflow** - Routeren naar verschillende specialistische agenten op basis van voorwaarden.

**Human-in-the-Loop** - Workflow patroon met menselijke controlepunten voor goedkeuring of inhoudsbeoordeling.

**langchain4j-agentic** - Maven dependency voor declaratief agenten bouwen (experimenteel).

**Loop Workflow** - Agent-uitvoering herhalen tot aan een voorwaarde is voldaan (bijv. kwaliteitscore ≥ 0.8).

**outputKey** - Agentannotatieparameter die aangeeft waar resultaten in de Agentic Scope worden opgeslagen.

**Parallel Workflow** - Meerdere agenten gelijktijdig laten draaien voor onafhankelijke taken.

**Response Strategy** - Hoe de supervisor het eindantwoord formuleert: LAATSTE, SAMENVATTING, of SCORE.

**Sequential Workflow** - Agenten opeenvolgend uitvoeren waarbij output gebruikt wordt voor de volgende stap.

**Supervisor Agent Pattern** - Geavanceerd agentisch patroon waarbij een supervisor LLM dynamisch bepaalt welke sub-agenten worden aangeroepen.

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven dependency voor MCP integratie in LangChain4j.

**MCP** - Model Context Protocol: standaard voor het koppelen van AI-apps aan externe tools. Eenmaal bouwen, overal gebruiken.

**MCP Client** - Applicatie die verbinding maakt met MCP-servers om tools te ontdekken en gebruiken.

**MCP Server** - Dienst die tools via MCP blootstelt met duidelijke beschrijvingen en parameterschema’s.

**McpToolProvider** - LangChain4j component die MCP-tools verpakt voor gebruik in AI-services en agenten.

**McpTransport** - Interface voor MCP-communicatie. Implementaties omvatten Stdio en HTTP.

**Stdio Transport** - Lokale procestransport via stdin/stdout. Handig voor bestandssysteemtoegang of commandoregeltools.

**StdioMcpTransport** - LangChain4j-implementatie die MCP-server als subprocess opstart.

**Tool Discovery** - Client vraagt server om beschikbare tools met beschrijvingen en schema’s.

## Azure Diensten - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud-zoekdienst met vectorfunctionaliteit. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Zet Azure-resources uit.

**Azure OpenAI** - Enterprise AI-dienst van Microsoft.

**Bicep** - Azure infrastructuur-als-code taal. [Infrastructuurhandleiding](../01-introduction/infra/README.md)

**Deployment Name** - Naam voor modelimplementatie in Azure.

**GPT-5.2** - Nieuwste OpenAI-model met redeneerbesturing. [Module 02](../02-prompt-engineering/README.md)

## Testen en Ontwikkeling - [Testhandleiding](TESTING.md)

**Dev Container** - Gecontaineriseerde ontwikkelomgeving. [Configuratie](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Testen met geheugenopslag.

**Integratietesten** - Testen met echte infrastructuur.

**Maven** - Java bouwautomatiseringstool.

**Mockito** - Java mocking-framework.

**Spring Boot** - Java applicatiekader. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:
Dit document is vertaald met behulp van de AI vertaaldienst [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u er rekening mee te houden dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor kritieke informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->