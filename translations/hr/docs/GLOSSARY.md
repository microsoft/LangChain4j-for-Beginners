# Rječnik LangChain4j

## Sadržaj

- [Osnovni pojmovi](#osnovni-pojmovi)
- [Komponente LangChain4j](#komponente-langchain4j)
- [Pojmovi iz AI/ML](#pojmovi-iz-aiml)
- [Zaštitne mjere](#zaštitne-mjere)
- [Inženjering promptova](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agent i alati](#agents-and-tools---module-04)
- [Agentni modul](#agentic-module---module-05)
- [Protokol konteksta modela (MCP)](#model-context-protocol-mcp---module-05)
- [Azure usluge](#azure-services---module-01)
- [Testiranje i razvoj](#testing-and-development---testing-guide)

Brzi pregled termina i koncepata korištenih kroz cijeli tečaj.

## Osnovni pojmovi

**AI agent** - Sustav koji koristi AI za zaključivanje i autonomno djelovanje. [Modul 04](../04-tools/README.md)

**Lanac** - Niz operacija gdje izlaz služi kao ulaz u sljedeći korak.

**Chunking** - Dijeljenje dokumenata na manje dijelove. Tipično: 300-500 tokena s preklapanjem. [Modul 03](../03-rag/README.md)

**Prozor konteksta** - Maksimalni broj tokena koje model može obraditi. GPT-5.2: 400K tokena (do 272K ulaz, 128K izlaz).

**Ugrađivanja (Embeddings)** - Numerički vektori koji predstavljaju značenje teksta. [Modul 03](../03-rag/README.md)

**Pozivanje funkcija** - Model generira strukturirane zahtjeve za pozivanje vanjskih funkcija. [Modul 04](../04-tools/README.md)

**Halucinacija** - Kada modeli generiraju netočne, ali uvjerljive informacije.

**Prompt** - Tekstualni ulaz za jezični model. [Modul 02](../02-prompt-engineering/README.md)

**Semantičko pretraživanje** - Pretraživanje po značenju pomoću embeddingsa, ne ključnih riječi. [Modul 03](../03-rag/README.md)

**Stanje s memorijom vs bez memorije** - Bez memorije: nema pamćenja. Sa memorijom: održava povijest razgovora. [Modul 01](../01-introduction/README.md)

**Tokeni** - Osnovne jedinice teksta koje modeli obrađuju. Utječu na troškove i ograničenja. [Modul 01](../01-introduction/README.md)

**Lančano korištenje alata** - Sekvencijalno izvođenje alata gdje izlaz informira sljedeći poziv. [Modul 04](../04-tools/README.md)

## Komponente LangChain4j

**AiServices** - Kreira tip-sigurne sučelje AI servisa.

**OpenAiOfficialChatModel** - Unificirani klijent za OpenAI i Azure OpenAI modele.

**OpenAiOfficialEmbeddingModel** - Kreira embeddings koristeći OpenAI Official klijent (podržava i OpenAI i Azure OpenAI).

**ChatModel** - Osnovno sučelje za jezične modele.

**ChatMemory** - Održava povijest razgovora.

**ContentRetriever** - Pronalazi relevantne dijelove dokumenata za RAG.

**DocumentSplitter** - Dijeli dokumente na dijelove.

**EmbeddingModel** - Pretvara tekst u numeričke vektore.

**EmbeddingStore** - Sprema i dohvaća embeddings.

**MessageWindowChatMemory** - Održava klizni prozor s nedavnim porukama.

**PromptTemplate** - Kreira ponovo iskoristive promptove s `{{promjenjiva}}` rezerviranim mjestima.

**TextSegment** - Tekstualni dio s metapodacima. Koristi se u RAG-u.

**ToolExecutionRequest** - Predstavlja zahtjev za izvođenje alata.

**UserMessage / AiMessage / SystemMessage** - Tipovi poruka u razgovoru.

## Pojmovi iz AI/ML

**Few-Shot Learning** - Davanje primjera u promptovima. [Modul 02](../02-prompt-engineering/README.md)

**Veliki jezični model (LLM)** - AI modeli trenirani na ogromnim tekstualnim podacima.

**Poteškoća rezoniranja** - GPT-5.2 parametar koji kontrolira dubinu razmišljanja. [Modul 02](../02-prompt-engineering/README.md)

**Temperatura** - Kontrolira nasumičnost izlaza. Niska = deterministički, visoka = kreativno.

**Vektorska baza podataka** - Specijalizirana baza za embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Izvođenje zadataka bez primjera. [Modul 02](../02-prompt-engineering/README.md)

## Zaštitne mjere

**Defenziva u dubini** - Višeslojni sigurnosni pristup koji kombinira zaštitne mjere na razini aplikacije i sigurnosne filtre pružatelja.

**Hard Block** - Pružatelj daje HTTP 400 grešku za teška kršenja sadržaja.

**InputGuardrail** - LangChain4j sučelje za validaciju korisničkog unosa prije nego dođe do LLM-a. Štedi troškove i latenciju blokirajući štetne unose na početku.

**InputGuardrailResult** - Povratni tip za validaciju pravilnika: `success()` ili `fatal("razlog")`.

**OutputGuardrail** - Sučelje za validaciju AI odgovora prije vraćanja korisnicima.

**Provider Safety Filters** - Ug built-in filtri sadržaja od AI pružatelja usluga (npr. Azure OpenAI) koji sprečavaju kršenja na razini API-ja.

**Soft Refusal** - Model uljudno odbija odgovoriti bez bacanja greške.

## Inženjering promptova - [Modul 02](../02-prompt-engineering/README.md)

**Lanac razmišljanja (Chain-of-Thought)** - Korak-po-korak razmišljanje za bolju točnost.

**Ograničeni izlaz** - Nametanje određenog formata ili strukture.

**Visoka motivacija** - GPT-5.2 obrazac za temeljito rezoniranje.

**Niska motivacija** - GPT-5.2 obrazac za brze odgovore.

**Višekratni dijalog** - Održavanje konteksta kroz razmjene.

**Prompt po ulozi** - Postavljanje modela na određenu osobu putem sistemskih poruka.

**Samo-refleksija** - Model evaluira i poboljšava vlastiti izlaz.

**Strukturirana analiza** - Fiksni okvir za evaluaciju.

**Obrazac izvršavanja zadataka** - Planirati → Izvršiti → Sažeti.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Procesiranje dokumenata** - Učitavanje → dijeljenje → ugrađivanje → pohrana.

**Ugrađivanje u memoriji** - Nepostojana pohrana za testiranje.

**RAG** - Kombinira dohvaćanje podataka s generiranjem za utemeljene odgovore.

**Ocjena sličnosti** - Mjera (0-1) semantičke sličnosti.

**Referenca izvora** - Metapodaci o dohvaćenom sadržaju.

## Agent i alati - [Modul 04](../04-tools/README.md)

**@Tool oznaka** - Označava Java metode kao alate dostupne za AI pozive.

**ReAct obrazac** - Razmišljaj → Djeluj → Promatraj → Ponavljaj.

**Upravljanje sesijama** - Odvojeni konteksti za različite korisnike.

**Alat** - Funkcija koju AI agent može pozvati.

**Opis alata** - Dokumentacija svrhe i parametara alata.

## Agentni modul - [Modul 05](../05-mcp/README.md)

**@Agent oznaka** - Označava sučelja kao AI agente s deklarativnim definiranjem ponašanja.

**Agent Listener** - Kuka za praćenje izvođenja agenta putem `beforeAgentInvocation()` i `afterAgentInvocation()`.

**Agentni opseg (Agentic Scope)** - Dijeljena memorija u koju agenti pohranjuju rezultate koristeći `outputKey` za konzumaciju od strane drugih agenata.

**AgenticServices** - Tvornica za kreiranje agenata koristeći `agentBuilder()` i `supervisorBuilder()`.

**Uvjetni tijek rada** - Usmjeravanje prema uvjetima različitim specijaliziranim agentima.

**Human-in-the-Loop** - Obrazac tijeka rada koji uključuje ljudske točke odobravanja ili pregleda sadržaja.

**langchain4j-agentic** - Maven ovisnost za deklarativno građenje agenata (eksperimentalno).

**Petlja u tijeku rada** - Iteracija izvođenja agenta dok se ne ispuni uvjet (npr. ocjena kvalitete ≥ 0.8).

**outputKey** - Parametar oznake agenta koji specificira gdje se rezultati spremaju u Agentni opseg.

**Paralelni tijek rada** - Istovremeno pokretanje više agenata za nezavisne zadatke.

**Strategija odgovora** - Kako nadzornik formulira konačni odgovor: LAST, SUMMARY ili SCORED.

**Sekvencijalni tijek rada** - Izvršavanje agenata redom gdje izlaz teče u sljedeći korak.

**Obrazac nadzornog agenta** - Napredni agentni obrazac gdje nadzorni LLM dinamički odlučuje koje pod-agente pozvati.

## Protokol konteksta modela (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven ovisnost za integraciju MCP-a u LangChain4j.

**MCP** - Model Context Protocol: standard za povezivanje AI aplikacija s vanjskim alatima. Izradi jednom, koristi svugdje.

**MCP klijent** - Aplikacija koja se povezuje na MCP servere radi otkrivanja i korištenja alata.

**MCP server** - Usluga koja izlaže alate putem MCP-a s jasnim opisima i shemama parametara.

**McpToolProvider** - Komponenta LangChain4j koja umotava MCP alate za korištenje u AI servisima i agentima.

**McpTransport** - Sučelje za MCP komunikaciju. Implementacije uključuju Stdio i HTTP.

**Stdio transport** - Lokalni procesni transport putem stdin/stdout. Koristan za pristup datotečnom sustavu ili CLI alate.

**StdioMcpTransport** - LangChain4j implementacija koja pokreće MCP server kao podproces.

**Otkrivanje alata** - Klijent upituje server za dostupne alate s opisima i shemama.

## Azure usluge - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Cloud pretraživanje s vektorskim mogućnostima. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Alat za deploy Azure resursa.

**Azure OpenAI** - Microsoftova enterprise AI usluga.

**Bicep** - Jezik za infrastrukturu kao kod u Azure-u. [Vodič za infrastrukturu](../01-introduction/infra/README.md)

**Ime deploymenta** - Naziv za postavljanje modela u Azure.

**GPT-5.2** - Najnoviji OpenAI model s kontrolom rezoniranja. [Modul 02](../02-prompt-engineering/README.md)

## Testiranje i razvoj - [Vodič za testiranje](TESTING.md)

**Dev Container** - Kontejnerizirano razvojno okruženje. [Konfiguracija](../../../.devcontainer/devcontainer.json)

**Testiranje u memoriji** - Testiranje s pohranom u memoriji.

**Integracijsko testiranje** - Testiranje s pravom infrastrukturom.

**Maven** - Alat za automatizaciju gradnje za Javu.

**Mockito** - Java framework za izradu lažnih objekata.

**Spring Boot** - Java aplikacijski framework. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Napomena**:
Ovaj dokument je preveden korištenjem AI prevoditeljskog servisa [Co-op Translator](https://github.com/Azure/co-op-translator). Iako težimo točnosti, imajte na umu da automatski prijevodi mogu sadržavati greške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za važne informacije preporuča se profesionalni ljudski prijevod. Nismo odgovorni za bilo kakva nesporazumevanja ili pogrešne interpretacije koje proizlaze iz korištenja ovog prijevoda.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->