# LangChain4j Sõnastik

## Sisukord

- [Põhikontseptsioonid](#põhikontseptsioonid)
- [LangChain4j Komponendid](#langchain4j-komponendid)
- [AI/ML Kontseptsioonid](#aiml-kontseptsioonid)
- [Kaitsemehhanismid](#kaitsemehhanismid)
- [Promptide Loomine](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agendid ja Tööriistad](#agents-and-tools---module-04)
- [Agentne Moodul](#agentic-module---module-05)
- [Mudeli Konteksti Protokoll (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Teenused](#azure-services---module-01)
- [Testimine ja Arendus](#testing-and-development---testing-guide)

Kiire viide kursuse jooksul kasutatud terminitele ja kontseptsioonidele.

## Põhikontseptsioonid

**AI Agent** - Süsteem, mis kasutab tehisintellekti mõtlemiseks ja autonoomseks tegutsemiseks. [Moodul 04](../04-tools/README.md)

**Kett (Chain)** - Tegevuste jada, kus väljund läheb järgmise sammu sisendiks.

**Tükeldamine (Chunking)** - Dokumentide jaotamine väiksemateks osadeks. Tavaliselt 300-500 märki ülekattega. [Moodul 03](../03-rag/README.md)

**Kontekstiakna suurus** - Maksimaalne märgiste arv, mida mudel saab töödelda. GPT-5.2: 400K märki (kuni 272K sisend, 128K väljund).

**Koodvektorid (Embeddings)** - Numbrilised vektorid, mis esindavad teksti tähendust. [Moodul 03](../03-rag/README.md)

**Funktsiooni Kutsumine** - Mudel genereerib struktureeritud päringuid väliste funktsioonide kutsumiseks. [Moodul 04](../04-tools/README.md)

**Hallutsinatsioon** - Kui mudelid genereerivad vale, kuid usutavat infot.

**Prompt** - Tekstisisend keelemudelile. [Moodul 02](../02-prompt-engineering/README.md)

**Semantiline Otsing** - Otsing tähenduse järgi, kasutades koodvektoreid, mitte märksõnu. [Moodul 03](../03-rag/README.md)

**Riigipõhine vs Riigivaba (Stateful vs Stateless)** - Riigivaba: pole mälulugu. Riigipõhine: säilitab vestluse ajaloo. [Moodul 01](../01-introduction/README.md)

**Märgid (Tokens)** - Mudelite töödeldavad põhiühikud. Mõjutab kulusid ja piiranguid. [Moodul 01](../01-introduction/README.md)

**Tööriistade Kettimine** - Tööriistade järjestikune käivitamine, kus väljund suunab järgmist funktsioonikõnet. [Moodul 04](../04-tools/README.md)

## LangChain4j Komponendid

**AiServices** - Loob tüübikindlaid AI teenuste liideseid.

**OpenAiOfficialChatModel** - Ühtne klient OpenAI ja Azure OpenAI mudelitele.

**OpenAiOfficialEmbeddingModel** - Loob koodvektoreid OpenAI ametliku kliendi abil (toetab nii OpenAI kui Azure OpenAI).

**ChatModel** - Keelemudelite põhiline liides.

**ChatMemory** - Hoiab vestluse ajalugu.

**ContentRetriever** - Leiab olulised dokumenditükid RAG jaoks.

**DocumentSplitter** - Jagab dokumendid osadeks.

**EmbeddingModel** - Muudab teksti numbrilisteks vektoriteks.

**EmbeddingStore** - Salvestab ja hangib koodvektoreid.

**MessageWindowChatMemory** - Hoiab järjepidevalt viimaste sõnumite liugakent.

**PromptTemplate** - Loob taaskasutatavaid prompte koos `{{variable}}` asendustega.

**TextSegment** - Tekstitükk koos metainfo ja kasutatakse RAGis.

**ToolExecutionRequest** - Esindab tööriista täitmise päringut.

**UserMessage / AiMessage / SystemMessage** - Vestluse sõnumitüübid.

## AI/ML Kontseptsioonid

**Few-Shot Learning** - Näidete pakkumine promptides. [Moodul 02](../02-prompt-engineering/README.md)

**Suur Keelemudel (LLM)** - AI mudelid, mis on treenitud suurte tekstikorpuste peal.

**Loogiline Pingutus (Reasoning Effort)** - GPT-5.2 parameeter, mis kontrollib mõtlemise sügavust. [Moodul 02](../02-prompt-engineering/README.md)

**Temperatuur** - Juhtib väljundi juhuslikkust. Madal=deterministlik, kõrge=loov.

**Vektorandmebaas** - Spetsiaalne andmebaas koodvektorite jaoks. [Moodul 03](../03-rag/README.md)

**Zero-Shot Learning** - Ülesannete sooritamine ilma näideteta. [Moodul 02](../02-prompt-engineering/README.md)

## Kaitsemehhanismid

**Kaitsekihid (Defense in Depth)** - Turvalisuse mitmetasandiline lähenemine, mis ühendab rakenduse tasandi kaitsed pakkuja turvafiltritega.

**Tõsine Blokeerimine (Hard Block)** - Pakkuja tõstab HTTP 400 vea tõsiste sisurikkumiste korral.

**InputGuardrail** - LangChain4j liides kasutaja sisendi valideerimiseks enne LLMi jõudmist. Säästab kulusid ja latentsust, blokeerides kahjulikud promptid varakult.

**InputGuardrailResult** - Tagastustüüp kaitse valideerimiseks: `success()` või `fatal("põhjus")`.

**OutputGuardrail** - Liides AI vastuste valideerimiseks enne kasutajale tagastamist.

**Pakkuja Turvafiltrid** - AI pakkujate (nt Azure OpenAI) sisseehitatud sisufiltrid, mis tabavad rikkumisi API tasandil.

**Pehme Keeldumine (Soft Refusal)** - Mudel keeldub viisakalt vastamast vigade tekitamiseta.

## Promptide Loomine - [Moodul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Järkjärguline loogika parema täpsuse saavutamiseks.

**Piiratud Väljund (Constrained Output)** - Sundida kindlat formaati või struktuuri.

**Suur Pühendumus (High Eagerness)** - GPT-5.2 muster põhjalikuks mõtlemiseks.

**Madal Pühendumus (Low Eagerness)** - GPT-5.2 muster kiireteks vastusteks.

**Mitme-Korra Vestlus (Multi-Turn Conversation)** - Mõtteviisi säilitamine vestluse jooksul.

**Rollipõhine Promptimine** - Mudeli persona määramine süsteemsete sõnumite kaudu.

**Eneseanalüüs (Self-Reflection)** - Mudel hindab ja täiustab oma väljundit.

**Struktureeritud Analüüs** - Kindel hindamismeetod.

**Ülesande Täitmise Muster** - Plaan → Täida → Kokkuvõtte tee.

## RAG (Retrieval-Augmented Generation) - [Moodul 03](../03-rag/README.md)

**Dokumenditöötlusvoog** - Lae → tükelda → kodeeri → salvesta.

**Mälupõhine Koodvektoripood** - Ajutine hoidla testimiseks.

**RAG** - Ühendab info hankimise ja genereerimise, et vastused oleksid põhjendatud.

**Sarnasuse Hinne** - Semantilise sarnasuse mõõt (0-1).

**Allika Viide** - Metaandmed hangitud sisu kohta.

## Agendid ja Tööriistad - [Moodul 04](../04-tools/README.md)

**@Tool Märgend** - Märgistab Java meetodid AI-kõlbulikeks tööriistadeks.

**ReAct Muster** - Mõtle → Tegutse → Vaata → Korda.

**Sessiooni Halduse** - Erinevad kontekstid kasutajate jaoks.

**Tööriist** - Funktsioon, mida AI agent saab kutsuda.

**Tööriista Kirjeldus** - Dokumentatsioon tööriista eesmärgi ja parameetrite kohta.

## Agentne Moodul - [Moodul 05](../05-mcp/README.md)

**@Agent Märgend** - Märgistab liidesed AI agentideks deklaratiivse käitumise kirjeldamiseks.

**Agendi Kuulaja (Agent Listener)** - Konks agentide täitmise jälgimiseks meetoditega `beforeAgentInvocation()` ja `afterAgentInvocation()`.

**Agentne Ulatus (Agentic Scope)** - Jagatud mälu, kuhu agentide tulemused salvestatakse, et teised agentid saaksid neid kasutada.

**AgenticServices** - Tehas agentide loomiseks kasutades `agentBuilder()` ja `supervisorBuilder()`.

**Tingimuslik Töövoog** - Tähtis marsruut tingimuse põhjal erinevatele spetsialistagentidele.

**Inimene Ahelas (Human-in-the-Loop)** - Töövoo muster, mis lisab inimsektsioonid heakskiiduks või sisukontrolliks.

**langchain4j-agentic** - Maven sõltuvus deklaratiivseks agentide loomiseks (katsefaasis).

**Tsükliline Töövoog (Loop Workflow)** - Iteratiivne agentide täitmine kuni tingimus täitub (nt kvaliteediskoor ≥ 0.8).

**outputKey** - Agendi märgendiparameeter, mis määrab, kuhu Agentse Ulatuses tulemused salvestatakse.

**Paralleeltöövoog (Parallel Workflow)** - Mitme agendi samaaegne täitmine iseseisvate ülesannete jaoks.

**Vastustrateegia** - Kuidas juhendaja vormistab lõpliku vastuse: VIIMANE, KOKKUVÕTE või SKOORITUD.

**Järjestikune Töövoog (Sequential Workflow)** - Agentide järjestikune täitmine, kus väljund liigub järgmisesse sammu.

**Juhendaja Agendi Muster (Supervisor Agent Pattern)** - Täiustatud agentne muster, kus juhendaja LLM otsustab dünaamiliselt, milliseid alamagente kutsuda.

## Mudeli Konteksti Protokoll (MCP) - [Moodul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven sõltuvus MCP integreerimiseks LangChain4j-s.

**MCP** - Mudeli Konteksti Protokoll: standard AI rakenduste ühendamiseks väliste tööriistadega. Ehita üks kord, kasuta kõikjal.

**MCP Klient** - Rakendus, mis ühendub MCP serveritega tööriistade avastamiseks ja kasutamiseks.

**MCP Server** - Teenus, mis pakub tööriistu MCP kaudu selgete kirjelduste ja parameetrite skeemidega.

**McpToolProvider** - LangChain4j komponent, mis pakendab MCP tööriistad kasutamiseks AI teenustes ja agentides.

**McpTransport** - Liides MCP kommunikatsiooni jaoks. Implementatsioonid sisaldavad Stdio ja HTTP.

**Stdio Transport** - Kohalik protsessi transport läbi stdin/stdout. Kasulik failisüsteemi ligipääsu või käsureatööriistade jaoks.

**StdioMcpTransport** - LangChain4j implementatsioon, mis käivitab MCP serveri alamprotsessina.

**Tööriistade Avastamine** - Klient pärib serverilt saadaolevad tööriistad koos kirjelduste ja skeemidega.

## Azure Teenused - [Moodul 01](../01-introduction/README.md)

**Azure AI Otsing** - Pilveotsing vektorvõimalustega. [Moodul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azure ressursside juurutamine.

**Azure OpenAI** - Microsofti ettevõtte AI teenus.

**Bicep** - Azure infrastruktuuri kui koodi keel. [Infrastruktuuri juhend](../01-introduction/infra/README.md)

**Juurutuse Nimi** - Mudeli juurutuse nimi Azure'is.

**GPT-5.2** - Viimane OpenAI mudel mõtlemise kontrolliga. [Moodul 02](../02-prompt-engineering/README.md)

## Testimine ja Arendus - [Testimise Juhend](TESTING.md)

**Dev Container** - Konteineriseeritud arenduskeskkond. [Konfiguratsioon](../../../.devcontainer/devcontainer.json)

**Mälupõhine Testimine** - Testimine mälusalvestusega.

**Integreerimistestimine** - Testimine reaalse infrastruktuuriga.

**Maven** - Java ehitamise automatiseerimise tööriist.

**Mockito** - Java teema jäljendamise raamistik.

**Spring Boot** - Java rakenduse raamistik. [Moodul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Lahtiütlus**:
See dokument on tõlgitud kasutades AI tõlketeenust [Co-op Translator](https://github.com/Azure/co-op-translator). Kuigi me püüdleme täpsuse poole, palun pange tähele, et automatiseeritud tõlgetes võib esineda vigu või ebatäpsusi. Originaaldokument selle emakeeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitatakse kasutada professionaalset inimtõlget. Me ei vastuta selle tõlkega seotud eksimustest või valesti mõistmistest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->