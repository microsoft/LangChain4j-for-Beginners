# LangChain4j Szószedet

## Tartalomjegyzék

- [Alapfogalmak](#alapfogalmak)
- [LangChain4j Összetevők](#langchain4j-összetevők)
- [AI/ML Fogalmak](#aiml-fogalmak)
- [Biztonsági Keretek](#biztonsági-keretek)
- [Prompt Tervezés](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Ügynökök és Eszközök](#agents-and-tools---module-04)
- [Agentikus Modul](#agentic-module---module-05)
- [Modell Kontextus Protokoll (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Szolgáltatások](#azure-services---module-01)
- [Tesztelés és Fejlesztés](#testing-and-development---testing-guide)

Gyors hivatkozás a kurzus során használt kifejezésekhez és fogalmakhoz.

## Alapfogalmak

**AI Ügynök** - Olyan rendszer, amely AI-t használ önálló érvelésre és cselekvésre. [Module 04](../04-tools/README.md)

**Lánc** - Műveletsorozat, ahol az eredmény a következő lépés bemenetévé válik.

**Darabolás (Chunking)** - Dokumentumok kisebb darabokra bontása. Általános: 300-500 token átfedéssel. [Module 03](../03-rag/README.md)

**Kontekstus Ablak** - Maximális tokenek száma, amit a modell képes feldolgozni. GPT-5.2: 400K token (legfeljebb 272K bemenet, 128K kimenet).

**Beágyazások (Embeddings)** - Numerikus vektorok, amelyek a szöveg jelentését reprezentálják. [Module 03](../03-rag/README.md)

**Függvényhívás (Function Calling)** - A modell strukturált kéréseket generál külső függvények meghívására. [Module 04](../04-tools/README.md)

**Hallucináció** - Amikor a modellek helytelen, de hihető információt generálnak.

**Prompt** - Szöveges bemenet egy nyelvi modellhez. [Module 02](../02-prompt-engineering/README.md)

**Szemantikus Keresés** - A jelentés alapján keres, beágyazásokat használva, nem kulcsszavakat. [Module 03](../03-rag/README.md)

**Állapotkezelés nélküli vs Állapotkezelő** - Stateless: nincs memória. Stateful: megőrzi a beszélgetés történetét. [Module 01](../01-introduction/README.md)

**Tokenek** - Alapvető szövegegységek, amelyeket a modellek feldolgoznak. Befolyásolja a költségeket és korlátokat. [Module 01](../01-introduction/README.md)

**Eszközláncolás** - Eszközök egymás utáni végrehajtása, ahol az eredmény befolyásolja a következő hívást. [Module 04](../04-tools/README.md)

## LangChain4j Összetevők

**AiServices** - Típusbiztos AI szolgáltatás interfészek létrehozása.

**OpenAiOfficialChatModel** - Egyesített kliens az OpenAI és Azure OpenAI modellekhez.

**OpenAiOfficialEmbeddingModel** - Beágyazások létrehozása az OpenAI Official klienssel (támogatja az OpenAI-t és Azure OpenAI-t is).

**ChatModel** - Alapvető interfész nyelvi modellekhez.

**ChatMemory** - A beszélgetés előzményeinek tárolása.

**ContentRetriever** - Releváns dokumentumdarabokat keres RAG-hoz.

**DocumentSplitter** - Dokumentumokat darabol darabokra.

**EmbeddingModel** - Szöveget numerikus vektorokká alakít.

**EmbeddingStore** - Beágyazások tárolása és előhívása.

**MessageWindowChatMemory** - Az utóbbi üzenetek csúszó ablakának tárolása.

**PromptTemplate** - Újrahasználható promptok létrehozása `{{variable}}` helyőrzőkkel.

**TextSegment** - Metadatákkal ellátott szövegrész. Használt RAG-ban.

**ToolExecutionRequest** - Eszközvégrehajtási kérés reprezentációja.

**UserMessage / AiMessage / SystemMessage** - Beszélgetés üzenettípusai.

## AI/ML Fogalmak

**Few-Shot Tanulás** - Példák megadása a promptokban. [Module 02](../02-prompt-engineering/README.md)

**Nagy Nyelvi Modell (LLM)** - Hatalmas szövegadatokon tanított AI modellek.

**Érvelési Erőfeszítés** - GPT-5.2 paraméter, amely az érvelés mélységét szabályozza. [Module 02](../02-prompt-engineering/README.md)

**Hőmérséklet** - A kimenet véletlenszerűségének szabályozása. Alacsony=detereminisztikus, magas=alkotó.

**Vektor Adatbázis** - Beágyazásokhoz specializált adatbázis. [Module 03](../03-rag/README.md)

**Zero-Shot Tanulás** - Feladatok elvégzése példák nélkül. [Module 02](../02-prompt-engineering/README.md)

## Biztonsági Keretek

**Mélységi Védelem** - Többrétegű biztonsági megközelítés, amely az alkalmazásszintű biztonsági kereteket szolgáltatói biztonsági szűrőkkel kombinálja.

**Kemény Blokkolás** - A szolgáltató HTTP 400-as hibát dob súlyos tartalmi megsértések esetén.

**InputGuardrail** - LangChain4j interfész a felhasználói bemenet érvényesítésére, mielőtt az eléri az LLM-et. Költség- és késleltetés-megtakarítás az ártalmas promptok korai blokkolásával.

**InputGuardrailResult** - Guardrail ellenőrzés visszatérési típusa: `success()` vagy `fatal("ok")`.

**OutputGuardrail** - Interfész az AI válaszok érvényesítésére, mielőtt visszaküldik a felhasználónak.

**Szolgáltatói Biztonsági Szűrők** - Beépített tartalmi szűrők AI szolgáltatóktól (pl. Azure OpenAI), amelyek az API szinten fogják az áthágásokat.

**Lágy Elutasítás** - A modell udvariasan megtagadja a választ anélkül, hogy hibát dobna.

## Prompt Tervezés - [Module 02](../02-prompt-engineering/README.md)

**Gondolatmenet Lánc** - Lépésenkénti érvelés a jobb pontosságért.

**Korlátozott Kimenet** - Meghatározott formátum vagy struktúra érvényesítése.

**Magas Lelkesedés** - GPT-5.2 minta a mélyreható érveléshez.

**Alacsony Lelkesedés** - GPT-5.2 minta gyors válaszokhoz.

**Többfordulós Beszélgetés** - Kontextus megőrzése az üzenetváltások között.

**Szerepalapú Promptolás** - Modell személyiségének beállítása rendszerüzeneteken keresztül.

**Önreflexió** - A modell értékeli és javítja a saját kimenetét.

**Strukturált Elemzés** - Rögzített értékelési keretrendszer.

**Feladatvégrehajtási Minta** - Terv → Végrehajtás → Összegzés.

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Dokumentumfeldolgozó Folyamat** - Betöltés → darabolás → beágyazás → tárolás.

**Memóriabeli Beágyazás Tároló** - Nem perzisztens tároló teszteléshez.

**RAG** - Összekapcsolja a lekérdezést a generálással, hogy megalapozott válaszokat adjon.

**Hasonlósági Pontszám** - A szemantikai hasonlóság mértéke (0-1 között).

**Forrás Hivatkozás** - Metaadat a lekért tartalomról.

## Ügynökök és Eszközök - [Module 04](../04-tools/README.md)

**@Tool Annotáció** - Java metódusokat jelöl AI-hívható eszközökként.

**ReAct Minta** - Érvelés → Cselekvés → Megfigyelés → Ismétlés.

**Munkamenet Kezelés** - Különálló kontextusok különböző felhasználók számára.

**Eszköz** - Olyan funkció, amelyet az AI ügynök meghívhat.

**Eszköz Leírás** - Dokumentáció az eszköz céljáról és paramétereiről.

## Agentikus Modul - [Module 05](../05-mcp/README.md)

**@Agent Annotáció** - Interfészeket jelöl AI ügynökökként deklaratív viselkedésdefinícióval.

**Agent Listener** - Horog az ügynök végrehajtásának figyelésére `beforeAgentInvocation()` és `afterAgentInvocation()` segítségével.

**Agentikus Terület** - Megosztott memória, ahol az ügynökök az outputokat tárolják `outputKey` használatával, hogy a downstream ügynökök hozzáférjenek.

**AgenticServices** - Ügynökök létrehozására szolgáló gyár `agentBuilder()` és `supervisorBuilder()` segítségével.

**Feltételes Munkafolyamat** - Feltételek alapján irányítás különböző szakértő ügynökökhöz.

**Humán a Hurokban** - Munkafolyamat minta emberi ellenőrző pontokkal jóváhagyás vagy tartalmi átvizsgálás céljából.

**langchain4j-agentic** - Maven függőség deklaratív ügynöképítéshez (kísérleti).

**Ciklus Munkafolyamat** - Az ügynök végrehajtásának ismétlése, amíg a feltétel teljesül (pl. minőségi pontszám ≥ 0.8).

**outputKey** - Ügynök annotációs paraméter, amely megadja, hová kerülnek az eredmények az Agentikus Területen.

**Párhuzamos Munkafolyamat** - Több ügynök egyidejű futtatása független feladatokra.

**Válasz Stratégia** - Hogyan fogalmazza meg a felügyelő a végső választ: LAST, SUMMARY, vagy SCORED.

**Sorrendiségi Munkafolyamat** - Ügynökök végrehajtása sorrendben, ahol az eredmény továbbáramlik a következő lépésre.

**Felügyelő Ügynök Minta** - Haladó agentikus minta, ahol egy felügyelő LLM dinamikusan dönt a részügynökök meghívásáról.

## Modell Kontextus Protokoll (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven függőség az MCP integrációhoz LangChain4j-ben.

**MCP** - Modell Kontextus Protokoll: szabvány AI alkalmazások külső eszközökhöz való csatlakoztatására. Egyszer építed, mindenhol használod.

**MCP Kliens** - Alkalmazás, amely MCP szerverekhez csatlakozik eszközök felderítésére és használatára.

**MCP Szerver** - Szolgáltatás, amely MCP-n keresztül elérhető eszközöket kínál világos leírásokkal és paraméter sémákkal.

**McpToolProvider** - LangChain4j komponens, amely MCP eszközöket csomagol AI szolgáltatások és ügynökök számára.

**McpTransport** - Interfész az MCP kommunikációhoz. Megvalósítások között szerepel a Stdio és HTTP.

**Stdio Szállítás** - Helyi folyamat szállítás stdin/stdout-on keresztül. Hasznos fájlrendszer-hozzáféréshez vagy parancssori eszközökhöz.

**StdioMcpTransport** - LangChain4j megvalósítás, amely MCP szervert szubprocesszként indít.

**Eszköz Felderítés** - A kliens lekérdezi a szervert az elérhető eszközökről leírásokkal és sémákkal.

## Azure Szolgáltatások - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Felhőalapú keresés vektoros képességekkel. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azure erőforrásokat telepít.

**Azure OpenAI** - A Microsoft vállalati AI szolgáltatása.

**Bicep** - Azure infrastruktúra kódnyelve. [Infrastruktúra Útmutató](../01-introduction/infra/README.md)

**Telepítés Neve** - Modell telepítésének neve Azure-ban.

**GPT-5.2** - Legújabb OpenAI modell az érvelés szabályozásával. [Module 02](../02-prompt-engineering/README.md)

## Tesztelés és Fejlesztés - [Tesztelési Útmutató](TESTING.md)

**Fejlesztői Konténer** - Konténerizált fejlesztési környezet. [Konfiguráció](../../../.devcontainer/devcontainer.json)

**Memóriabeli Tesztelés** - Tesztelés memóriabeli tárolóval.

**Integrációs Tesztelés** - Tesztelés valós infrastruktúrával.

**Maven** - Java build automatizációs eszköz.

**Mockito** - Java mockolási keretrendszer.

**Spring Boot** - Java alkalmazás keretrendszer. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Jogi nyilatkozat**:
Ez a dokumentum az AI fordítási szolgáltatás, a [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével készült. Bár az pontosságra törekszünk, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az anyanyelvén tekintendő hiteles forrásnak. Fontos információk esetén professzionális emberi fordítást javasolunk. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely ebből a fordításból ered.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->