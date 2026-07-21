# Glosar LangChain4j

## Cuprins

- [Concepte de bază](#concepte-de-bază)
- [Componente LangChain4j](#componente-langchain4j)
- [Concepte AI/ML](#concepte-aiml)
- [Măsuri de protecție](#măsuri-de-protecție)
- [Ingineria Promptului](#prompt-engineering---module-02)
- [RAG (Generare augmentată prin recuperare)](#rag-retrieval-augmented-generation---module-03)
- [Agenți și Unelte](#agents-and-tools---module-04)
- [Modul Agentic](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Servicii Azure](#azure-services---module-01)
- [Testare și Dezvoltare](#testing-and-development---testing-guide)

Referință rapidă pentru termeni și concepte utilizate pe parcursul cursului.

## Concepte de bază

**Agent AI** - Sistem care folosește AI pentru a raționa și acționa autonom. [Modul 04](../04-tools/README.md)

**Lanț** - Secvență de operații unde ieșirea alimentează pasul următor.

**Fragmentare** - Împărțirea documentelor în bucăți mai mici. Tipic: 300-500 tokeni cu suprapunere. [Modul 03](../03-rag/README.md)

**Fereastră de Context** - Numărul maxim de tokeni pe care un model îi poate procesa. GPT-5.2: 400K tokeni (până la 272K input, 128K output).

**Embeddings** - Vectori numerici care reprezintă sensul textului. [Modul 03](../03-rag/README.md)

**Apel de Funcție** - Modelul generează cereri structurate pentru a apela funcții externe. [Modul 04](../04-tools/README.md)

**Halucinație** - Când modelele generează informații incorecte dar plauzibile.

**Prompt** - Textul de intrare pentru un model lingvistic. [Modul 02](../02-prompt-engineering/README.md)

**Căutare Semantică** - Căutare după sens folosind embeddings, nu cuvinte cheie. [Modul 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: fără memorie. Stateful: păstrează istoricul conversației. [Modul 01](../01-introduction/README.md)

**Tokeni** - Unități fundamentale de text procesate de modele. Afectează costuri și limite. [Modul 01](../01-introduction/README.md)

**Lanț de Unelte** - Execuția secvențială a uneltelor unde ieșirea informează următorul apel. [Modul 04](../04-tools/README.md)

## Componente LangChain4j

**AiServices** - Creează interfețe de servicii AI cu tipuri sigure.

**OpenAiOfficialChatModel** - Client unificat pentru modelele OpenAI și Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Creează embeddings folosind clientul oficial OpenAI (suportă atât OpenAI cât și Azure OpenAI).

**ChatModel** - Interfața de bază pentru modelele de limbaj.

**ChatMemory** - Menține istoricul conversațiilor.

**ContentRetriever** - Găsește fragmente relevante de documente pentru RAG.

**DocumentSplitter** - Împarte documentele în fragmente.

**EmbeddingModel** - Convertește textul în vectori numerici.

**EmbeddingStore** - Stochează și recuperează embeddings.

**MessageWindowChatMemory** - Menține o fereastră mobilă a mesajelor recente.

**PromptTemplate** - Creează prompturi reutilizabile cu substituenți `{{variable}}`.

**TextSegment** - Fragment de text cu metadate. Folosit în RAG.

**ToolExecutionRequest** - Reprezintă o cerere de execuție a uneltei.

**UserMessage / AiMessage / SystemMessage** - Tipuri de mesaje din conversație.

## Concepte AI/ML

**Few-Shot Learning** - Furnizarea de exemple în prompturi. [Modul 02](../02-prompt-engineering/README.md)

**Model de Limbaj Mare (LLM)** - Modele AI antrenate pe volume mari de text.

**Efort de Raționare** - Parametru GPT-5.2 care controlează profunzimea gândirii. [Modul 02](../02-prompt-engineering/README.md)

**Temperatură** - Controlează gradul de aleatoriu al ieșirii. Low=deterministic, high=creativ.

**Bază de Date Vectorială** - Bază de date specializată pentru embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Efectuarea sarcinilor fără exemple. [Modul 02](../02-prompt-engineering/README.md)

## Măsuri de protecție

**Apărare în Straturi** - Abordare de securitate multi-strat combinând măsuri la nivel de aplicație cu filtre de siguranță ale furnizorului.

**Blocare Dură** - Furnizorul emite eroare HTTP 400 pentru încălcări grave ale conținutului.

**InputGuardrail** - Interfață LangChain4j pentru validarea inputului utilizator înainte să ajungă la LLM. Economisește cost și latență blocând prompturile dăunătoare devreme.

**InputGuardrailResult** - Tip returnat pentru validarea măsurii de protecție: `success()` sau `fatal("motiv")`.

**OutputGuardrail** - Interfață pentru validarea răspunsurilor AI înainte de a le returna utilizatorilor.

**Filtre de Siguranță ale Furnizorului** - Filtre de conținut integrate de la furnizorii AI (ex. Azure OpenAI) care detectează încălcări la nivel de API.

**Refuz Moale** - Modelul refuză politicos să răspundă fără să arunce o eroare.

## Ingineria Promptului - [Modul 02](../02-prompt-engineering/README.md)

**Lanț de Gândire** - Raționare pas-cu-pas pentru o acuratețe mai bună.

**Ieșire Constrânsă** - Impunerea unui format sau structură specifică.

**Entuziasm Ridicat** - Tipar GPT-5.2 pentru raționare amănunțită.

**Entuziasm Scăzut** - Tipar GPT-5.2 pentru răspunsuri rapide.

**Conversație Multi-Rotundă** - Menținerea contextului pe parcursul schimburilor.

**Promptare pe Bază de Rol** - Setarea personalității modelului prin mesaje de sistem.

**Auto-Reflecție** - Modelul evaluează și își îmbunătățește ieșirea.

**Analiză Structurată** - Cadru fix pentru evaluare.

**Tipar Execuție Sarcină** - Planifică → Execută → Rezumă.

## RAG (Generare augmentată prin recuperare) - [Modul 03](../03-rag/README.md)

**Pipelină Procesare Documente** - Încarcă → fragmentează → încorporează → stochează.

**Stocare Embeddings în Memorie** - Stocare nepermanentă pentru testare.

**RAG** - Combină recuperarea cu generarea pentru a fundamenta răspunsurile.

**Scor de Similaritate** - Măsură (0-1) a similitudinii semantice.

**Referință de Sursă** - Metadate despre conținutul recuperat.

## Agenți și Unelte - [Modul 04](../04-tools/README.md)

**Anotare @Tool** - Marchează metode Java ca unelte apelabile de AI.

**Tipar ReAct** - Raționează → Acționează → Observă → Repetă.

**Managementul Sesiunii** - Contexturi separate pentru utilizatori diferiți.

**Unealtă** - Funcție pe care un agent AI o poate apela.

**Descrierea Uneltei** - Documentația scopului și parametrilor uneltei.

## Modul Agentic - [Modul 05](../05-mcp/README.md)

**Anotare @Agent** - Marchează interfețele ca agenți AI cu definiții de comportament declarative.

**Ascultător Agent** - Hook pentru monitorizarea execuției agentului prin `beforeAgentInvocation()` și `afterAgentInvocation()`.

**Domeniu Agentic** - Memorie partajată unde agenții stochează ieșiri folosind `outputKey` pentru consumul agentilor downstream.

**AgenticServices** - Fabrica pentru crearea de agenți folosind `agentBuilder()` și `supervisorBuilder()`.

**Flux Condițional** - Rutare pe bază de condiții către agenți specialiști diferiți.

**Omul în Buclă** - Tipar de flux ce adaugă puncte de control umane pentru aprobare sau revizuire a conținutului.

**langchain4j-agentic** - Dependență Maven pentru construcție declarativă de agenți (experimental).

**Flux în Buclă** - Iterează execuția agentului până când o condiție este îndeplinită (ex. scor de calitate ≥ 0.8).

**outputKey** - Parametru al anotării agentului care specifică unde se stochează rezultatele în Domeniul Agentic.

**Flux Paralel** - Rulează mai mulți agenți simultan pentru sarcini independente.

**Strategie de Răspuns** - Cum formulează supraveghetorul răspunsul final: LAST, SUMMARY sau SCORED.

**Flux Secvențial** - Execută agenții în ordine unde ieșirea curge către pasul următor.

**Tipar Agent Supraveghetor** - Tipar agentic avansat în care un LLM supraveghetor decide dinamic ce subagenți să invoce.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependență Maven pentru integrarea MCP în LangChain4j.

**MCP** - Model Context Protocol: standard pentru conectarea aplicațiilor AI la unelte externe. Construiește o dată, folosește oriunde.

**Client MCP** - Aplicație care se conectează la servere MCP pentru a descoperi și folosi unelte.

**Server MCP** - Serviciu ce expune unelte prin MCP cu descrieri clare și scheme de parametri.

**McpToolProvider** - Componentă LangChain4j care înfășoară uneltele MCP pentru utilizare în servicii și agenți AI.

**McpTransport** - Interfață pentru comunicarea MCP. Implementările includ Stdio și HTTP.

**Transport Stdio** - Transport local prin stdin/stdout. Util pentru acces la sistemul de fișiere sau unelte din linia de comandă.

**StdioMcpTransport** - Implementarea LangChain4j care pornește server MCP ca proces subprocess.

**Descoperire Unelte** - Clientul interoghează serverul pentru unelte disponibile cu descrieri și scheme.

## Servicii Azure - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Căutare în cloud cu capabilități vectoriale. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Depune resurse Azure.

**Azure OpenAI** - Serviciul AI enterprise Microsoft.

**Bicep** - Limbaj Azure pentru infrastructură ca cod. [Ghid Infrastructură](../01-introduction/infra/README.md)

**Numele Deployerii** - Numele implementării modelului în Azure.

**GPT-5.2** - Modelul OpenAI cel mai nou cu control de raționare. [Modul 02](../02-prompt-engineering/README.md)

## Testare și Dezvoltare - [Ghid de Testare](TESTING.md)

**Container Dev** - Mediu containerizat de dezvoltare. [Configurație](../../../.devcontainer/devcontainer.json)

**Testare în Memorie** - Testare cu stocare în memorie.

**Testare de Integrare** - Testare cu infrastructură reală.

**Maven** - Unealtă de automatizare build Java.

**Mockito** - Framework Java pentru simulări.

**Spring Boot** - Framework aplicații Java. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Declinare a responsabilității**:
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). În timp ce ne străduim pentru acuratețe, vă rugăm să rețineți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa nativă trebuie considerat sursa autorizată. Pentru informații critice, se recomandă traducerea profesională realizată de un om. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care decurg din utilizarea acestei traduceri.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->