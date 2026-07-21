# LangChain4j Ordliste

## Innholdsfortegnelse

- [Kjernebegreper](#kjernebegreper)
- [LangChain4j-komponenter](#langchain4j-komponenter)
- [AI/ML-begreper](#aiml-begreper)
- [Guardrails](#guardrails)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenter og Verktøy](#agents-and-tools---module-04)
- [Agentmodul](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure-tjenester](#azure-services---module-01)
- [Testing og Utvikling](#testing-and-development---testing-guide)

Raske referanser for begreper og konsepter brukt gjennom hele kurset.

## Kjernebegreper

**AI-agent** - System som bruker AI for å resonnere og handle autonomt. [Modul 04](../04-tools/README.md)

**Kjede** - Sekvens av operasjoner der output går videre til neste steg.

**Chunking** - Dele dokumenter i mindre deler. Typisk: 300-500 tokens med overlapp. [Modul 03](../03-rag/README.md)

**Kontekstvindu** - Maksimalt antall tokens en modell kan prosessere. GPT-5.2: 400K tokens (inntil 272K input, 128K output).

**Inbeddinger** - Numeriske vektorer som representerer tekstens betydning. [Modul 03](../03-rag/README.md)

**Funksjonskalling** - Modell genererer strukturerte forespørsler for å kalle eksterne funksjoner. [Modul 04](../04-tools/README.md)

**Hallusinasjon** - Når modeller genererer feilaktig men plausibel informasjon.

**Prompt** - Tekstinput til et språkmodell. [Modul 02](../02-prompt-engineering/README.md)

**Semantisk søk** - Søk basert på mening ved hjelp av inbeddinger, ikke nøkkelord. [Modul 03](../03-rag/README.md)

**Tilstandsbasert vs Tilstandsløs** - Tilstandsløs: uten minne. Tilstandsbasert: opprettholder samtalehistorikk. [Modul 01](../01-introduction/README.md)

**Tokens** - Grunnenheter tekst som modeller prosesserer. Påvirker kostnader og grenser. [Modul 01](../01-introduction/README.md)

**Verktøykjedning** - Sekvensiell verktøyutførelse hvor output påvirker neste kall. [Modul 04](../04-tools/README.md)

## LangChain4j-komponenter

**AiServices** - Lager typesikre AI-tjenestegrensesnitt.

**OpenAiOfficialChatModel** - Enhetlig klient for OpenAI og Azure OpenAI-modeller.

**OpenAiOfficialEmbeddingModel** - Lager inbeddinger ved bruk av OpenAI Official-klient (støtter både OpenAI og Azure OpenAI).

**ChatModel** - Kjernegrensesnitt for språkmodeller.

**ChatMemory** - Opprettholder samtalehistorikk.

**ContentRetriever** - Finner relevante dokumentbiter for RAG.

**DocumentSplitter** - Deler dokumenter i biter.

**EmbeddingModel** - Konverterer tekst til numeriske vektorer.

**EmbeddingStore** - Lagrer og henter inbeddinger.

**MessageWindowChatMemory** - Opprettholder et skyvbart vindu med nylige meldinger.

**PromptTemplate** - Lager gjenbrukbare prompts med `{{variabel}}`-plassholdere.

**TextSegment** - Tekstbit med metadata. Brukes i RAG.

**ToolExecutionRequest** - Representerer verktøyutførelsesforespørsel.

**UserMessage / AiMessage / SystemMessage** - Samtale meldings-typer.

## AI/ML-begreper

**Few-Shot Learning** - Gir eksempler i prompts. [Modul 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI-modeller trent på store mengder tekstdata.

**Resonneringsinnsats** - GPT-5.2-parameter som kontrollerer tenkedybde. [Modul 02](../02-prompt-engineering/README.md)

**Temperatur** - Styrer utdataens tilfeldighet. Lav=deterministisk, høy=kreativ.

**Vektor Database** - Spesialisert database for inbeddinger. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Utfører oppgaver uten eksempler. [Modul 02](../02-prompt-engineering/README.md)

## Guardrails

**Forsvar i dypet** - Flerlags sikkerhetstilnærming som kombinerer applikasjonsnivå guardrails med leverandørsikkerhetsfiltre.

**Hard blokkering** - Leverandør gir HTTP 400-feil for alvorlige innholdsbrudd.

**InputGuardrail** - LangChain4j-grensesnitt for validering av brukerinput før det når LLM. Spar kostnader og ventetid ved å blokkere skadelige prompts tidlig.

**InputGuardrailResult** - Returtype for guardrail-validering: `success()` eller `fatal("årsak")`.

**OutputGuardrail** - Grensesnitt for å validere AI-responser før de returneres til brukere.

**Leverandørsikkerhetsfiltre** - Innebygde innholdsfiltre fra AI-leverandører (f.eks. Azure OpenAI) som fanger brudd på API-nivå.

**Myk avvisning** - Modell høflig nekter å svare uten å kaste feil.

## Prompt Engineering - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Trinnvis resonnement for bedre nøyaktighet.

**Begrenset utdata** - Påtvinge spesifikt format eller struktur.

**Høy ivrighet** - GPT-5.2-mønster for grundig resonnering.

**Lav ivrighet** - GPT-5.2-mønster for raske svar.

**Multi-Turn Conversation** - Opprettholde kontekst over flere utvekslinger.

**Rollebasert prompting** - Sette modellpersonlighet via systemmeldinger.

**Selvrefleksjon** - Modell evaluerer og forbedrer sin utdata.

**Strukturert analyse** - Fast evalueringsrammeverk.

**Oppgaveutførelsesmønster** - Planlegg → Utfør → Oppsummer.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Dokumentbehandlingspipeline** - Last inn → chunk → embed → lagre.

**I-Minne Embedding Store** - Ikke-persistente lagring for testing.

**RAG** - Kombinerer henting med generering for å forankre svar.

**Lignende poengsum** - Måling (0-1) av semantisk likhet.

**Kilderreferanse** - Metadata om hentet innhold.

## Agenter og Verktøy - [Modul 04](../04-tools/README.md)

**@Tool-annotasjon** - Marker Java-metoder som AI-kallbare verktøy.

**ReAct-mønster** - Resonner → Aksjoner → Observer → Gjenta.

**Sesjonsstyring** - Separate kontekster for forskjellige brukere.

**Verktøy** - Funksjon en AI-agent kan kalle.

**Verktøybeskrivelse** - Dokumentasjon av verktøyets formål og parametere.

## Agentmodul - [Modul 05](../05-mcp/README.md)

**@Agent-annotasjon** - Marker grensesnitt som AI-agenter med deklarativ atferdsdefinisjon.

**Agentlytter** - Krok for overvåkning av agentutførelse via `beforeAgentInvocation()` og `afterAgentInvocation()`.

**Agentisk omfang** - Delt minne hvor agenter lagrer output med `outputKey` for at downstream-agenter skal bruke.

**AgenticServices** - Fabrikk for å lage agenter ved bruk av `agentBuilder()` og `supervisorBuilder()`.

**Betinget arbeidsflyt** - Ruteføring basert på betingelser til ulike spesialistagenter.

**Mennesket-i-loopen** - Arbeidsflytmønster som legger til menneskelige sjekkpunkter for godkjenning eller innholdsgranskning.

**langchain4j-agentic** - Maven-avhengighet for deklarativ agentbygging (eksperimentell).

**Loop-arbeidsflyt** - Iterer agentutførelse til betingelse er oppfylt (f.eks. kvalitetspoeng ≥ 0.8).

**outputKey** - Agent-annotasjonsparameter som spesifiserer hvor resultater lagres i Agentisk omfang.

**Parallell arbeidsflyt** - Kjøre flere agenter samtidig for uavhengige oppgaver.

**Responsstrategi** - Hvordan veilederen formulerer endelig svar: SISTE, SAMMENDRAG eller POENGSATT.

**Sekvensiell arbeidsflyt** - Utfør agenter i rekkefølge der output går til neste steg.

**Veilederagentmønster** - Avansert agentisk mønster der en veileder-LLM dynamisk bestemmer hvilke sub-agenter som skal kalles.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven-avhengighet for MCP-integrasjon i LangChain4j.

**MCP** - Model Context Protocol: standard for å koble AI-apper til eksterne verktøy. Bygg én gang, bruk overalt.

**MCP-klient** - Applikasjon som kobler til MCP-servere for å oppdage og bruke verktøy.

**MCP-server** - Tjeneste som eksponerer verktøy via MCP med klare beskrivelser og parameterskjemaer.

**McpToolProvider** - LangChain4j-komponent som pakker MCP-verktøy for bruk i AI-tjenester og agenter.

**McpTransport** - Grensesnitt for MCP-kommunikasjon. Implementasjoner inkluderer Stdio og HTTP.

**Stdio Transport** - Lokalt prosess-transport via stdin/stdout. Nyttig for filsystemtilgang eller kommandolinjeverktøy.

**StdioMcpTransport** - LangChain4j-implementering som starter MCP-server som underprosess.

**Verktøyoppdagelse** - Klient spør server om tilgjengelige verktøy med beskrivelser og skjemaer.

## Azure-tjenester - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Skybasert søk med vektorkapasiteter. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Distribuerer Azure-ressurser.

**Azure OpenAI** - Microsofts bedrifts-AI-tjeneste.

**Bicep** - Azures infrastruktur-som-kode-språk. [Infrastrukturveiledning](../01-introduction/infra/README.md)

**Distribusjonsnavn** - Navn for modellutplassering i Azure.

**GPT-5.2** - Siste OpenAI-modell med resonneringskontroll. [Modul 02](../02-prompt-engineering/README.md)

## Testing og Utvikling - [Testing Guide](TESTING.md)

**Dev Container** - Kontainerisert utviklingsmiljø. [Konfigurasjon](../../../.devcontainer/devcontainer.json)

**Testing i minnet** - Testing med minnelagring.

**Integrasjonstesting** - Testing med ekte infrastruktur.

**Maven** - Java-byggverktøy.

**Mockito** - Java mocking-rammeverk.

**Spring Boot** - Java-applikasjonsrammeverk. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiske oversettelser kan inneholde feil eller unøyaktigheter. Det opprinnelige dokumentet på originalspråket skal betraktes som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->