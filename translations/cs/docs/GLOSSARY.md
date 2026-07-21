# Slovník LangChain4j

## Obsah

- [Základní pojmy](#základní-pojmy)
- [Komponenty LangChain4j](#komponenty-langchain4j)
- [Koncepty AI/ML](#koncepty-aiml)
- [Bezpečnostní opatření](#bezpečnostní-opatření)
- [Tvorba promptů](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agentové a nástroje](#agents-and-tools---module-04)
- [Agentní modul](#agentic-module---module-05)
- [Modelový kontextový protokol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure služby](#azure-services---module-01)
- [Testování a vývoj](#testing-and-development---testing-guide)

Rychlá reference pojmů a konceptů používaných v celém kurzu.

## Základní pojmy

**AI Agent** - Systém, který používá AI k autonomnímu uvažování a jednání. [Modul 04](../04-tools/README.md)

**Chain** - Sekvence operací, kde výstup jde jako vstup do dalšího kroku.

**Chunking** - Rozdělování dokumentů na menší části. Typicky: 300-500 tokenů s překryvem. [Modul 03](../03-rag/README.md)

**Context Window** - Maximální počet tokenů, které model může zpracovat. GPT-5.2: 400 tisíc tokenů (až 272 tisíc vstup, 128 tisíc výstup).

**Embeddings** - Číselné vektory reprezentující význam textu. [Modul 03](../03-rag/README.md)

**Function Calling** - Model generuje strukturované požadavky na volání externích funkcí. [Modul 04](../04-tools/README.md)

**Halucinace** - Když modely generují nesprávné, ale věrohodné informace.

**Prompt** - Textový vstup do jazykového modelu. [Modul 02](../02-prompt-engineering/README.md)

**Sémantické vyhledávání** - Vyhledávání podle významu pomocí embeddings, ne podle klíčových slov. [Modul 03](../03-rag/README.md)

**Stavový vs Bezstavový** - Bezstavový: bez paměti. Stavový: udržuje historii konverzace. [Modul 01](../01-introduction/README.md)

**Tokeny** - Základní textové jednotky, které modely zpracovávají. Ovlivňují náklady a limity. [Modul 01](../01-introduction/README.md)

**Tool Chaining** - Sekvenční spouštění nástrojů, kde výstup ovlivňuje další volání. [Modul 04](../04-tools/README.md)

## Komponenty LangChain4j

**AiServices** - Vytváří typově bezpečné AI rozhraní služeb.

**OpenAiOfficialChatModel** - Jednotný klient pro OpenAI a Azure OpenAI modely.

**OpenAiOfficialEmbeddingModel** - Vytváří embeddings pomocí oficiálního klienta OpenAI (podporuje OpenAI i Azure OpenAI).

**ChatModel** - Základní rozhraní pro jazykové modely.

**ChatMemory** - Udržuje historii konverzace.

**ContentRetriever** - Vyhledává relevantní kusy dokumentů pro RAG.

**DocumentSplitter** - Rozděluje dokumenty na části.

**EmbeddingModel** - Převádí text na číselné vektory.

**EmbeddingStore** - Ukládá a načítá embeddings.

**MessageWindowChatMemory** - Udržuje posuvné okno nedávných zpráv.

**PromptTemplate** - Vytváří znovupoužitelné prompty s `{{variable}}` zástupnými symboly.

**TextSegment** - Textový segment s metadaty. Používá se v RAG.

**ToolExecutionRequest** - Reprezentuje požadavek na spuštění nástroje.

**UserMessage / AiMessage / SystemMessage** - Typy zpráv v konverzaci.

## Koncepty AI/ML

**Few-Shot Learning** - Poskytování příkladů v promptech. [Modul 02](../02-prompt-engineering/README.md)

**Velký jazykový model (LLM)** - AI modely trénované na rozsáhlých textových datech.

**Reasoning Effort** - Parametr GPT-5.2 ovlivňující hloubku uvažování. [Modul 02](../02-prompt-engineering/README.md)

**Teplota (Temperature)** - Řídí náhodnost výstupu. Nízká=deterministická, vysoká=tvůrčí.

**Vektorová databáze** - Specializovaná databáze pro embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Plnění úloh bez příkladů. [Modul 02](../02-prompt-engineering/README.md)

## Bezpečnostní opatření

**Defense in Depth** - Vícevrstvý bezpečnostní přístup kombinující aplikační bezpečnostní opatření s bezpečnostními filtry poskytovatele.

**Hard Block** - Poskytovatel vrací chybu HTTP 400 při závažném porušení obsahu.

**InputGuardrail** - Rozhraní LangChain4j pro validaci uživatelského vstupu před jeho zpracováním LLM. Šetří náklady a latenci tím, že blokuje škodlivé prompty včas.

**InputGuardrailResult** - Návratový typ validace guardrail: `success()` nebo `fatal("důvod")`.

**OutputGuardrail** - Rozhraní pro validaci AI odpovědí před jejich předáním uživatelům.

**Bezpečnostní filtry poskytovatele** - Vestavěné filtry obsahu od AI poskytovatelů (např. Azure OpenAI), které zachytávají porušení na úrovni API.

**Soft Refusal** - Model zdvořile odmítne odpovědět, aniž by vyhodil chybu.

## Tvorba promptů - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Krok za krokem odůvodňování pro lepší přesnost.

**Omezený výstup** - Vynucení specifického formátu nebo struktury.

**High Eagerness** - Vzor GPT-5.2 pro důkladné uvažování.

**Low Eagerness** - Vzor GPT-5.2 pro rychlé odpovědi.

**Vícekolová konverzace** - Udržování kontextu přes výměny.

**Role-Based Prompting** - Nastavení modelové persóny pomocí systémových zpráv.

**Sebereflexe** - Model hodnotí a vylepšuje svůj výstup.

**Strukturovaná analýza** - Fixní rámec hodnocení.

**Vzor vykonání úkolu** - Plánuj → Vykonej → Shrň.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Pipeline zpracování dokumentů** - Načti → rozděluj → embeduj → ulož.

**In-Memory Embedding Store** - Nepersistentní úložiště pro testování.

**RAG** - Kombinuje vyhledávání a generování pro ověřené odpovědi.

**Podobnostní skóre** - Míra (0-1) sémantické podobnosti.

**Reference zdroje** - Metadata o načteném obsahu.

## Agentové a nástroje - [Modul 04](../04-tools/README.md)

**@Tool Annotation** - Označuje Java metody jako AI-volatelné nástroje.

**ReAct Pattern** - Uvažuj → jednej → pozoruj → opakuj.

**Správa sezení** - Oddělené kontexty pro různé uživatele.

**Nástroj (Tool)** - Funkce, kterou může AI agent volat.

**Popis nástroje** - Dokumentace účelu nástroje a parametrů.

## Agentní modul - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** - Označuje rozhraní jako AI agenty s deklarativní definicí chování.

**Agent Listener** - Háček pro monitorování spuštění agenta přes `beforeAgentInvocation()` a `afterAgentInvocation()`.

**Agentic Scope** - Sdílená paměť, kam agenti ukládají výsledky pomocí `outputKey` pro další agenty.

**AgenticServices** - Továrna pro vytváření agentů použitím `agentBuilder()` a `supervisorBuilder()`.

**Podmíněný workflow** - Směrování na základě podmínek k různým specializovaným agentům.

**Human-in-the-Loop** - Vzorec workflow přidávající lidské kontroly pro schválení nebo revizi obsahu.

**langchain4j-agentic** - Maven závislost pro deklarativní tvorbu agentů (experimentální).

**Loop Workflow** - Iterace vykonávání agenta dokud není splněna podmínka (např. skóre kvality ≥ 0.8).

**outputKey** - Parametr anotace agenta určující, kde jsou výsledky ukládány v Agentic Scope.

**Paralelní workflow** - Současné spuštění více agentů pro nezávislé úkoly.

**Strategie odpovědi** - Jak supervisor formuluje finální odpověď: POSLEDNÍ, SHRNUTÍ nebo SKÓROVANÉ.

**Sekvenční workflow** - Spouštění agentů za sebou, kde výstup jde do dalšího kroku.

**Supervisor Agent Pattern** - Pokročilý agentní vzorec, kde supervisorský LLM dynamicky rozhoduje, které pod-agenty zavolat.

## Modelový kontextový protokol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven závislost pro integraci MCP v LangChain4j.

**MCP** - Model Context Protocol: standard pro připojení AI aplikací k externím nástrojům. Napiš jednou, používej všude.

**MCP Client** - Aplikace, která se připojuje k MCP serverům, aby objevovala a používala nástroje.

**MCP Server** - Služba zpřístupňující nástroje přes MCP s jasnými popisy a schématy parametrů.

**McpToolProvider** - Komponenta LangChain4j, která obaluje MCP nástroje pro použití v AI službách a agentech.

**McpTransport** - Rozhraní pro MCP komunikaci. Implementace zahrnují Stdio a HTTP.

**Stdio Transport** - Lokální procesní transport přes stdin/stdout. Vhodné pro přístup k souborovému systému nebo příkazové nástroje.

**StdioMcpTransport** - Implementace LangChain4j spouštějící MCP server jako podproces.

**Objevování nástrojů** - Klient dotazuje server na dostupné nástroje s popisy a schématy.

## Azure služby - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Cloudové vyhledávání s vektorovými schopnostmi. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Nasazování Azure zdrojů.

**Azure OpenAI** - Enterprise AI služba Microsoftu.

**Bicep** - Jazyk pro infrastrukturu jako kód na Azure. [Průvodce infrastrukturou](../01-introduction/infra/README.md)

**Název nasazení** - Název pro nasazení modelu v Azure.

**GPT-5.2** - Nejnovější model OpenAI s řízením uvažování. [Modul 02](../02-prompt-engineering/README.md)

## Testování a vývoj - [Průvodce testováním](TESTING.md)

**Vývojový kontejner** - Kontejnerizované vývojové prostředí. [Konfigurace](../../../.devcontainer/devcontainer.json)

**Testování v paměti** - Testování s paměťovým úložištěm.

**Integrační testování** - Testování s reálnou infrastrukturou.

**Maven** - Nástroj pro automatizaci buildů v Javě.

**Mockito** - Java framework pro mockování.

**Spring Boot** - Java aplikační framework. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Prohlášení o omezení odpovědnosti**:
Tento dokument byl přeložen pomocí AI překladatelské služby [Co-op Translator](https://github.com/Azure/co-op-translator). Přestože usilujeme o co největší přesnost, mějte prosím na paměti, že automatizované překlady mohou obsahovat chyby nebo nepřesnosti. Originální dokument v jeho mateřském jazyce by měl být považován za autoritativní zdroj. Pro kritické informace se doporučuje profesionální lidský překlad. Nejsme odpovědní za jakékoli nedorozumění nebo nesprávné interpretace vzniklé použitím tohoto překladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->