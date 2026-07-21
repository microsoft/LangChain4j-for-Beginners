# LangChain4j Slovník pojmov

## Obsah

- [Základné koncepty](#základné-koncepty)
- [Komponenty LangChain4j](#komponenty-langchain4j)
- [Koncepty AI/ML](#koncepty-aiml)
- [Bezpečnostné opatrenia](#bezpečnostné-opatrenia)
- [Návrh promptov](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenti a nástroje](#agents-and-tools---module-04)
- [Agentic modul](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure služby](#azure-services---module-01)
- [Testovanie a vývoj](#testing-and-development---testing-guide)

Rýchly prehľad termínov a konceptov používaných v celom kurze.

## Základné koncepty

**AI Agent** - Systém využívajúci AI na uvažovanie a autonómne konanie. [Modul 04](../04-tools/README.md)

**Reťazec (Chain)** - Sekvencia operácií, kde výstup slúži ako vstup ďalšieho kroku.

**Rozdeľovanie na časti (Chunking)** - Rozdeľovanie dokumentov na menšie kúsky. Typické: 300-500 tokenov s prekrytím. [Modul 03](../03-rag/README.md)

**Kontextové okno (Context Window)** - Maximálny počet tokenov, ktoré model dokáže spracovať. GPT-5.2: 400K tokenov (až 272K vstup, 128K výstup).

**Embeddings** - Číselné vektory reprezentujúce význam textu. [Modul 03](../03-rag/README.md)

**Volanie funkcií (Function Calling)** - Model generuje štruktúrované požiadavky na volanie externých funkcií. [Modul 04](../04-tools/README.md)

**Halucinácie (Hallucination)** - Keď modely generujú nesprávne, no na prvý pohľad pravdepodobné informácie.

**Prompt** - Textový vstup do jazykového modelu. [Modul 02](../02-prompt-engineering/README.md)

**Sémantické vyhľadávanie (Semantic Search)** - Vyhľadávanie podľa významu pomocou embeddings, nie podľa kľúčových slov. [Modul 03](../03-rag/README.md)

**Stavové vs. bezstavové (Stateful vs Stateless)** - Bezstavové: bez pamäte. Stavové: uchováva históriu konverzácie. [Modul 01](../01-introduction/README.md)

**Tokény (Tokens)** - Základné textové jednotky, ktoré modely spracúvajú. Ovplyvňujú náklady a limity. [Modul 01](../01-introduction/README.md)

**Zreťazenie nástrojov (Tool Chaining)** - Sekvenčné spúšťanie nástrojov, kde výstup informuje ďalšie volanie. [Modul 04](../04-tools/README.md)

## Komponenty LangChain4j

**AiServices** - Vytvára typovo bezpečné rozhrania AI služieb.

**OpenAiOfficialChatModel** - Uniformný klient pre OpenAI a Azure OpenAI modely.

**OpenAiOfficialEmbeddingModel** - Vytvára embeddings pomocou oficiálneho klienta OpenAI (podporuje OpenAI aj Azure OpenAI).

**ChatModel** - Základné rozhranie pre jazykové modely.

**ChatMemory** - Uchováva históriu konverzácie.

**ContentRetriever** - Nájdu relevantné kúsky dokumentov pre RAG.

**DocumentSplitter** - Rozdeľuje dokumenty na časti.

**EmbeddingModel** - Konvertuje text na číselné vektory.

**EmbeddingStore** - Ukladá a získava embeddings.

**MessageWindowChatMemory** - Uchováva posuvné okno nedávnych správ.

**PromptTemplate** - Vytvára znovupoužiteľné prompty s {{variable}} zástupcami.

**TextSegment** - Textový úsek s metadátami. Používa sa v RAG.

**ToolExecutionRequest** - Reprezentuje požiadavku na spustenie nástroja.

**UserMessage / AiMessage / SystemMessage** - Typy správ v konverzácii.

## Koncepty AI/ML

**Few-Shot Learning** - Poskytnutie príkladov v promptoch. [Modul 02](../02-prompt-engineering/README.md)

**Veľký jazykový model (LLM)** - AI modely trénované na obrovskom množstve textových dát.

**Úsilie o uvažovanie (Reasoning Effort)** - Parameter GPT-5.2 regulujúci hĺbku uvažovania. [Modul 02](../02-prompt-engineering/README.md)

**Teplota (Temperature)** - Riadi náhodnosť výstupu. Nízka = deterministický, vysoká = kreatívny.

**Vektorová databáza** - Špecializovaná databáza pre embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Vykonávanie úloh bez príkladov. [Modul 02](../02-prompt-engineering/README.md)

## Bezpečnostné opatrenia

**Obrana v hĺbke (Defense in Depth)** - Viacvrstvový bezpečnostný prístup kombinujúci aplikačné ochrany s bezpečnostnými filtrami poskytovateľa.

**Tvrdý blok (Hard Block)** - Poskytovateľ vracia HTTP 400 chybu pri vážnych porušeniach obsahu.

**InputGuardrail** - Rozhranie LangChain4j na validáciu používateľského vstupu pred odoslaním do LLM. Šetrí náklady a latenciu blokovaním škodlivých promptov včas.

**InputGuardrailResult** - Typ návratovej hodnoty validácie: `success()` alebo `fatal("dôvod")`.

**OutputGuardrail** - Rozhranie na validáciu odpovedí AI pred ich odoslaním používateľom.

**Bezpečnostné filtre poskytovateľa** - Vstavané filtre obsahu od AI poskytovateľov (napr. Azure OpenAI), ktoré zachytávajú porušenia na úrovni API.

**Mäkké odmietnutie (Soft Refusal)** - Model slušne odmietne odpovedať bez chyby.

## Návrh promptov - [Modul 02](../02-prompt-engineering/README.md)

**Reťazec myšlienok (Chain-of-Thought)** - Krokovanie uvažovania pre lepšiu presnosť.

**Obmedzený výstup (Constrained Output)** - Vynucovanie konkrétneho formátu alebo štruktúry.

**Vysoká snaha (High Eagerness)** - Vzorec GPT-5.2 pre dôkladné uvažovanie.

**Nízka snaha (Low Eagerness)** - Vzorec GPT-5.2 pre rýchle odpovede.

**Viackolová konverzácia (Multi-Turn Conversation)** - Udržiavanie kontextu naprieč výmenami.

**Promptovanie podľa rolí (Role-Based Prompting)** - Nastavenie modelovej persony pomocou systémových správ.

**Sebareflexia (Self-Reflection)** - Model hodnotí a zlepšuje svoj výstup.

**Štruktúrovaná analýza (Structured Analysis)** - Fixný rámec hodnotenia.

**Vzor vykonávania úlohy (Task Execution Pattern)** - Plánuj → Vykonaj → Zhrni.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Pracovný tok spracovania dokumentov (Document Processing Pipeline)** - Načítaj → rozdeľ → vlož do embeddingov → ulož.

**Pamäťové úložisko embeddingov (In-Memory Embedding Store)** - Nepersistentné úložisko na testovanie.

**RAG** - Kombinuje vyhľadávanie a generovanie pre overené odpovede.

**Miera podobnosti (Similarity Score)** - Miera (0-1) sémantickej podobnosti.

**Zdrojová referencia (Source Reference)** - Metadáta o načítanom obsahu.

## Agenti a nástroje - [Modul 04](../04-tools/README.md)

**@Tool anotácia** - Označuje Java metódy ako AI-volateľné nástroje.

**ReAct vzorec** - Uvažuj → Konaj → Pozoruj → Opakuj.

**Správa relácií (Session Management)** - Oddelené kontexty pre rôznych používateľov.

**Nástroj (Tool)** - Funkcia, ktorú môže AI agent volať.

**Popis nástroja (Tool Description)** - Dokumentácia účelu a parametrov nástroja.

## Agentic modul - [Modul 05](../05-mcp/README.md)

**@Agent anotácia** - Označuje rozhrania ako AI agentov s deklaratívnym definovaním správania.

**Agent Listener** - Háčik na monitorovanie vykonávania agenta cez `beforeAgentInvocation()` a `afterAgentInvocation()`.

**Agentic Scope** - Zdieľaná pamäť, kde agenti ukladajú výstupy pomocou `outputKey` pre ďalších agentov.

**AgenticServices** - Fabrika na tvorbu agentov cez `agentBuilder()` a `supervisorBuilder()`.

**Podmienený pracovný tok (Conditional Workflow)** - Trasa podľa podmienok k rôznym špecializovaným agentom.

**Človek v slučke (Human-in-the-Loop)** - Vzorec pracovného toku pridávajúci ľudské kontroly na schválenie alebo revíziu obsahu.

**langchain4j-agentic** - Maven závislosť na deklaratívnu tvorbu agentov (experimentálne).

**Cyklický pracovný tok (Loop Workflow)** - Iteruje vykonávanie agenta, kým nie je splnená podmienka (napr. skóre kvality ≥ 0.8).

**outputKey** - Parameter anotácie agenta určujúci, kde sa výsledky ukladajú v Agentic Scope.

**Paralelný pracovný tok (Parallel Workflow)** - Súbežné spúšťanie viacerých agentov pre nezávislé úlohy.

**Stratégia odpovede (Response Strategy)** - Ako supervízor formuluje finálnu odpoveď: LAST, SUMMARY alebo SCORED.

**Sekvenčný pracovný tok (Sequential Workflow)** - Vykonanie agentov za sebou, kde výstup tečie do ďalšieho kroku.

**Supervisor Agent Pattern** - Pokročilý agentický vzorec, kde supervízor LLM dynamicky rozhoduje, ktorých podagentov zavolať.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven závislosť pre integráciu MCP v LangChain4j.

**MCP** - Model Context Protocol: štandard na prepojenie AI aplikácií s externými nástrojmi. Spoj raz, používaj všade.

**MCP klient** - Aplikácia, ktorá sa pripája na MCP servery, aby objavila a používala nástroje.

**MCP server** - Služba vystavujúca nástroje cez MCP s jasnými popismi a schémami parametrov.

**McpToolProvider** - Komponent LangChain4j, ktorý obalí MCP nástroje pre použitie v AI službách a agentoch.

**McpTransport** - Rozhranie pre komunikáciu MCP. Implementácie zahŕňajú Stdio a HTTP.

**Stdio transport** - Lokálny transport procesov cez stdin/stdout. Vhodný na prístup k súborovému systému alebo príkazovým nástrojom.

**StdioMcpTransport** - Implementácia LangChain4j, ktorá spúšťa MCP server ako podsproces.

**Objavovanie nástrojov (Tool Discovery)** - Klient zisťuje dostupné nástroje so špecifikáciami a popismi.

## Azure služby - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Cloudové vyhľadávanie so schopnosťou práce s vektormi. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Nasadzuje Azure zdroje.

**Azure OpenAI** - Podniková AI služba od Microsoftu.

**Bicep** - Jazyk infraštruktúry ako kódu pre Azure. [Infrastructure Guide](../01-introduction/infra/README.md)

**Názov nasadenia (Deployment Name)** - Názov pre nasadenie modelu v Azure.

**GPT-5.2** - Najnovší OpenAI model s riadením uvažovania. [Modul 02](../02-prompt-engineering/README.md)

## Testovanie a vývoj - [Testing Guide](TESTING.md)

**Dev Container** - Kontajnerizované vývojové prostredie. [Konfigurácia](../../../.devcontainer/devcontainer.json)

**Testovanie v pamäti (In-Memory Testing)** - Testovanie s úložiskom v pamäti.

**Integračné testovanie (Integration Testing)** - Testovanie s reálnou infraštruktúrou.

**Maven** - Nástroj na automatizáciu buildov v Jave.

**Mockito** - Framework na mocking v Jave.

**Spring Boot** - Framework pre Java aplikácie. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vyhlásenie o zodpovednosti**:
Tento dokument bol preložený pomocou AI prekladateľskej služby [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, vezmite prosím na vedomie, že automatické preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho natívnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za žiadne nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->