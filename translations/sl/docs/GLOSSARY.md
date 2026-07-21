# Slovar LangChain4j

## Kazalo

- [Osnovni pojmi](#osnovni-pojmi)
- [Komponente LangChain4j](#komponente-langchain4j)
- [Pojmi AI/ML](#pojmi-aiml)
- [Zaščitni mehanizmi](#zaščitni-mehanizmi)
- [Inženiring pozivov](#prompt-engineering---module-02)
- [RAG (Generiranje z nadgradnjo pridobivanja)](#rag-retrieval-augmented-generation---module-03)
- [Agentje in orodja](#agents-and-tools---module-04)
- [Agentni modul](#agentic-module---module-05)
- [Protokol modelnega konteksta (MCP)](#model-context-protocol-mcp---module-05)
- [Azure storitve](#azure-services---module-01)
- [Testiranje in razvoj](#testing-and-development---testing-guide)

Hiter pregled pojmov in konceptov, ki se uporabljajo skozi celoten tečaj.

## Osnovni pojmi

**AI agent** - Sistem, ki uporablja AI za samostojno razmišljanje in delovanje. [Modul 04](../04-tools/README.md)

**Veriga** - Zaporedje operacij, kjer izhod vstopa v naslednji korak.

**Razbitje na dele** - Razbijanje dokumentov na manjše koščke. Tipično: 300-500 tokenov s prekrivanjem. [Modul 03](../03-rag/README.md)

**Kontekstno okno** - Največje število tokenov, ki jih model lahko obdela. GPT-5.2: 400K tokenov (do 272K vhod, 128K izhod).

**Vdelave** - Numerični vektorji, ki predstavljajo pomen besedila. [Modul 03](../03-rag/README.md)

**Klic funkcije** - Model ustvari strukturirane zahteve za klic zunanjih funkcij. [Modul 04](../04-tools/README.md)

**Halucinacija** - Ko modeli generirajo napačne, a verjetne informacije.

**Poziv** - Besedilni vhod za jezikovni model. [Modul 02](../02-prompt-engineering/README.md)

**Semantično iskanje** - Iskanje po pomenu z uporabo vdelav, ne ključnih besed. [Modul 03](../03-rag/README.md)

**Stanje z in brez pomnilnika** - Brezpomnilnično: ni spomina. S pomnilnikom: ohranja zgodovino pogovora. [Modul 01](../01-introduction/README.md)

**Tokeni** - Osnovne enote besedila, ki jih modeli obdelujejo. Vplivajo na stroške in omejitve. [Modul 01](../01-introduction/README.md)

**Verižna uporaba orodij** - Zaporedno izvajanje orodij, kjer izhod vpliva na naslednji klic. [Modul 04](../04-tools/README.md)

## Komponente LangChain4j

**AiServices** - Ustvarja tipno varne vmesnike AI storitev.

**OpenAiOfficialChatModel** - Enoten odjemalec za modele OpenAI in Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Ustvarja vdelave z uradnim odjemalcem OpenAI (podpira OpenAI in Azure OpenAI).

**ChatModel** - Osnovni vmesnik za jezikovne modele.

**ChatMemory** - Ohranja zgodovino pogovora.

**ContentRetriever** - Najde relevantne dele dokumenta za RAG.

**DocumentSplitter** - Razbija dokumente na dele.

**EmbeddingModel** - Pretvori besedilo v numerične vektorje.

**EmbeddingStore** - Shrani in odpira vdelave.

**MessageWindowChatMemory** - Ohranja drseče okno nedavnih sporočil.

**PromptTemplate** - Ustvarja ponovno uporabne pozive z `{{variable}}` mestnimi označevalci.

**TextSegment** - Besedilni kos z metapodatki. Uporablja se v RAG.

**ToolExecutionRequest** - Predstavlja zahtevo za izvedbo orodja.

**UserMessage / AiMessage / SystemMessage** - Vrste sporočil v pogovoru.

## Pojmi AI/ML

**Učenje z malo primeri** - Zagotavljanje primerov v pozivih. [Modul 02](../02-prompt-engineering/README.md)

**Veliki jezikovni model (LLM)** - AI modeli, trenirani na ogromnih količinah besedil.

**Napor razmišljanja** - Parameter GPT-5.2, ki nadzoruje globino razmišljanja. [Modul 02](../02-prompt-engineering/README.md)

**Temperatura** - Nadzoruje naključnost izhoda. Nizka=deterministična, visoka=kreativna.

**Vektorska baza podatkov** - Specializirana baza za vdelave. [Modul 03](../03-rag/README.md)

**Učenje brez primerov** - Izvajanje nalog brez primerov. [Modul 02](../02-prompt-engineering/README.md)

## Zaščitni mehanizmi

**Zmogljiva zaščita** - Večplastni varnostni pristop, ki združuje zaščite na ravni aplikacije z varnostnimi filtri ponudnikov.

**Trda blokada** - Ponudnik vrže napako HTTP 400 za hujše kršitve vsebine.

**InputGuardrail** - LangChain4j vmesnik za preverjanje uporabniškega vnosa pred posredovanjem LLM-ju. Prihrani stroške in latenco z zgodnjim blokiranjem škodljivih pozivov.

**InputGuardrailResult** - Vrsta vrnitve preverjanja varovalke: `success()` ali `fatal("reason")`.

**OutputGuardrail** - Vmesnik za preverjanje AI odgovorov pred vračanjem uporabnikom.

**Provider Safety Filters** - Vgrajeni filtri vsebine AI ponudnikov (npr. Azure OpenAI), ki zaznavajo kršitve na ravni API-ja.

**Mehki odklon** - Model vljudno zavrne odgovor brez vrženja napake.

## Inženiring pozivov - [Modul 02](../02-prompt-engineering/README.md)

**Veriga razmišljanja** - Korak-po-korak razmišljanje za boljšo natančnost.

**Omejen izhod** - Uveljavljanje specifične oblike ali strukture.

**Visoka vnema** - Vzorec GPT-5.2 za temeljito razmišljanje.

**Nizka vnema** - Vzorec GPT-5.2 za hitre odgovore.

**Večvrstni pogovor** - Ohranjanje konteksta čez menjave.

**Pozivanje na podlagi vloge** - Nastavitev osebnosti modela preko sistemskih sporočil.

**Samoocena** - Model oceni in izboljšuje svoj izhod.

**Strukturirana analiza** - Fiksni okvir za ocenjevanje.

**Vzorec izvajanja naloge** - Načrtuj → Izvedi → Povzemi.

## RAG (Generiranje z nadgradnjo pridobivanja) - [Modul 03](../03-rag/README.md)

**Procesna veriga za dokumente** - Naloži → razdeli → vdelaj → shrani.

**Shranjevanje vdelav v spominu** - Ne-persistenčno shranjevanje za testiranje.

**RAG** - Združuje pridobivanje z generiranjem za utemeljitev odgovorov.

**Ocena podobnosti** - Merilo (0-1) semantične podobnosti.

**Referenca vira** - Metapodatki o pridobljeni vsebini.

## Agentje in orodja - [Modul 04](../04-tools/README.md)

**@Tool oznaka** - Označuje Java metode kot orodja, dostopna AI-ju.

**ReAct vzorec** - Razmišljaj → Ukrepaj → Opazuj → Ponovi.

**Upravljanje sej** - Ločeni konteksti za različne uporabnike.

**Orodje** - Funkcija, ki jo AI agent lahko pokliče.

**Opis orodja** - Dokumentacija namena orodja in parametrov.

## Agentni modul - [Modul 05](../05-mcp/README.md)

**@Agent oznaka** - Označuje vmesnike kot AI agente z deklarativno definicijo vedenja.

**Agentni poslušalec** - Hook za spremljanje izvajanja agentov preko `beforeAgentInvocation()` in `afterAgentInvocation()`.

**Agentni obseg** - Deljeni pomnilnik, kjer agenti shranjujejo rezultate z uporabo `outputKey` za nadaljnjo uporabo.

**AgenticServices** - Tovarna za ustvarjanje agentov z `agentBuilder()` in `supervisorBuilder()`.

**Pogojni potek dela** - Usmeritev na različne specializirane agente glede na pogoje.

**Človek v zanki** - Vzorec poteka dela z dodanimi človekovimi kontrolnimi točkami za odobritev ali pregled vsebine.

**langchain4j-agentic** - Maven odvisnost za deklarativno izdelavo agentov (eksperimentalno).

**Zanke potek dela** - Iterativno izvajanje agenta dokler ni dosežen pogoj (npr. ocena kakovosti ≥ 0,8).

**outputKey** - Parameter oznake agenta, ki določa, kje se rezultati shranjujejo v agentnem obsegu.

**Vzporedni potek dela** - Sočasno izvajanje več agentov za neodvisne naloge.

**Strategija odgovora** - Kako nadzornik oblikuje končni odgovor: ZADNJI, POVZETEK ali OCENJENO.

**Zaporedni potek dela** - Izvedba agentov po vrsti, kjer izhod teče v naslednji korak.

**Vzorec nadzornega agenta** - Napreden agentni vzorec, kjer nadzorni LLM dinamično odloča, katere pod-agente poklicati.

## Protokol modelnega konteksta (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven odvisnost za integracijo MCP v LangChain4j.

**MCP** - Protokol modelnega konteksta: standard za povezovanje AI aplikacij z zunanjimi orodji. Naredi enkrat, uporabi povsod.

**MCP odjemalec** - Aplikacija, ki se poveže na MCP strežnike za odkrivanje in uporabo orodij.

**MCP strežnik** - Storitev, ki preko MCP izpostavlja orodja z jasnimi opisi in shemami parametrov.

**McpToolProvider** - Komponenta LangChain4j, ki ovije MCP orodja za uporabo v AI storitvah in agentih.

**McpTransport** - Vmesnik za MCP komunikacijo. Implementacije vključujejo Stdio in HTTP.

**Stdio transport** - Lokalni transport procesa preko stdin/stdout. Koristen za dostop do datotečnega sistema ali ukaznih orodij.

**StdioMcpTransport** - Implementacija LangChain4j, ki zažene MCP strežnik kot podproces.

**Odkritje orodij** - Odjemalec povpraša strežnik o razpoložljivih orodjih z opisi in shemami.

## Azure storitve - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Oblačno iskanje z vektorskimi zmožnostmi. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Razmestitev Azure virov.

**Azure OpenAI** - Microsoftova podjetniška AI storitev.

**Bicep** - Jezik za infrastrukturo kot koda za Azure. [Vodnik za infrastrukturo](../01-introduction/infra/README.md)

**Ime razmestitve** - Ime za razmestitev modela v Azure.

**GPT-5.2** - Najnovejši OpenAI model z nadzorom razmišljanja. [Modul 02](../02-prompt-engineering/README.md)

## Testiranje in razvoj - [Vodnik za testiranje](TESTING.md)

**Razvojni kontejner** - Kontejnerizirano razvojno okolje. [Konfiguracija](../../../.devcontainer/devcontainer.json)

**Testiranje v spominu** - Testiranje s shrambo v spominu.

**Integracijsko testiranje** - Testiranje z realno infrastrukturo.

**Maven** - Orodje za avtomatizacijo gradnje Java.

**Mockito** - Okvir za lažno ustvarjanje v Java.

**Spring Boot** - Okvir za razvoj aplikacij Java. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Omejitev odgovornosti**:
Ta dokument je bil preveden z uporabo AI prevajalske storitve [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da avtomatizirani prevodi lahko vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku je treba obravnavati kot avtoritativni vir. Za kritične informacije je priporočljiv strokovni človeški prevod. Ne odgovarjamo za morebitna nesporazume ali napačne interpretacije, ki izhajajo iz uporabe tega prevoda.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->