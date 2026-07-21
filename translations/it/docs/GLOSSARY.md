# Glossario LangChain4j

## Indice

- [Concetti Principali](#concetti-principali)
- [Componenti LangChain4j](#componenti-langchain4j)
- [Concetti AI/ML](#concetti-aiml)
- [Guardrails](#guardrails)
- [Prompt Engineering](#prompt-engineering---modulo-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---modulo-03)
- [Agenti e Strumenti](#agenti-e-strumenti---modulo-04)
- [Modulo Agentic](#modulo-agentic---modulo-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---modulo-05)
- [Servizi Azure](#servizi-azure---modulo-01)
- [Testing e Sviluppo](#testing-e-sviluppo---guida-al-testing)

Riferimento rapido per termini e concetti utilizzati durante il corso.

## Concetti Principali

**Agente AI** - Sistema che utilizza AI per ragionare e agire in autonomia. [Modulo 04](../04-tools/README.md)

**Catena** - Sequenza di operazioni in cui l'output alimenta il passo successivo.

**Chunking** - Suddivisione di documenti in pezzi più piccoli. Tipico: 300-500 token con sovrapposizione. [Modulo 03](../03-rag/README.md)

**Finestra di Contesto** - Numero massimo di token che un modello può processare. GPT-5.2: 400K token (fino a 272K input, 128K output).

**Embedding** - Vettori numerici che rappresentano il significato del testo. [Modulo 03](../03-rag/README.md)

**Chiamata di Funzione** - Il modello genera richieste strutturate per chiamare funzioni esterne. [Modulo 04](../04-tools/README.md)

**Allucinazione** - Quando i modelli generano informazioni errate ma plausibili.

**Prompt** - Input testuale per un modello di linguaggio. [Modulo 02](../02-prompt-engineering/README.md)

**Ricerca Semantica** - Ricerca basata sul significato usando embedding, non parole chiave. [Modulo 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: senza memoria. Stateful: mantiene la cronologia della conversazione. [Modulo 01](../01-introduction/README.md)

**Token** - Unità base di testo processata dai modelli. Incide su costi e limiti. [Modulo 01](../01-introduction/README.md)

**Catena di Strumenti** - Esecuzione sequenziale di strumenti in cui l'output informa la chiamata successiva. [Modulo 04](../04-tools/README.md)

## Componenti LangChain4j

**AiServices** - Crea interfacce di servizio AI type-safe.

**OpenAiOfficialChatModel** - Client unificato per modelli OpenAI e Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Crea embedding usando il client OpenAI Official (supporta sia OpenAI che Azure OpenAI).

**ChatModel** - Interfaccia core per modelli di linguaggio.

**ChatMemory** - Mantiene la cronologia della conversazione.

**ContentRetriever** - Trova chunk di documenti rilevanti per RAG.

**DocumentSplitter** - Suddivide documenti in chunk.

**EmbeddingModel** - Converte testo in vettori numerici.

**EmbeddingStore** - Salva e recupera embedding.

**MessageWindowChatMemory** - Mantiene una finestra mobile dei messaggi recenti.

**PromptTemplate** - Crea prompt riutilizzabili con segnaposto `{{variable}}`.

**TextSegment** - Chunk di testo con metadata. Usato in RAG.

**ToolExecutionRequest** - Rappresenta la richiesta di esecuzione di uno strumento.

**UserMessage / AiMessage / SystemMessage** - Tipi di messaggi di conversazione.

## Concetti AI/ML

**Few-Shot Learning** - Fornire esempi nei prompt. [Modulo 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Modelli AI addestrati su grandi quantità di testo.

**Sforzo di Ragionamento** - Parametro GPT-5.2 che controlla la profondità del ragionamento. [Modulo 02](../02-prompt-engineering/README.md)

**Temperatura** - Controlla la casualità dell'output. Bassa=deterministico, alta=creativo.

**Database Vettoriale** - Database specializzato per embedding. [Modulo 03](../03-rag/README.md)

**Zero-Shot Learning** - Eseguire compiti senza esempi. [Modulo 02](../02-prompt-engineering/README.md)

## Guardrails

**Difesa in Profondità** - Approccio di sicurezza multilivello che combina guardrails a livello applicativo con filtri di sicurezza del provider.

**Blocco Duro** - Il provider restituisce errore HTTP 400 per violazioni gravi dei contenuti.

**InputGuardrail** - Interfaccia LangChain4j per convalidare l'input utente prima che raggiunga l'LLM. Riduce costi e latenza bloccando prompt dannosi in anticipo.

**InputGuardrailResult** - Tipo di ritorno per la validazione guardrail: `success()` o `fatal("reason")`.

**OutputGuardrail** - Interfaccia per convalidare le risposte AI prima di restituirle agli utenti.

**Filtri di Sicurezza del Provider** - Filtri di contenuto integrati dai provider AI (es. Azure OpenAI) che intercettano violazioni a livello API.

**Rifiuto Morbido** - Il modello declina educatamente di rispondere senza generare errore.

## Prompt Engineering - [Modulo 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Ragionamento passo dopo passo per maggiore accuratezza.

**Output Vincolato** - Forzare un formato o struttura specifica.

**Alta Voglia** - Pattern GPT-5.2 per ragionamento approfondito.

**Bassa Voglia** - Pattern GPT-5.2 per risposte rapide.

**Conversazione Multi-Turno** - Mantenere il contesto tra scambi.

**Prompting Basato su Ruolo** - Impostare la persona del modello tramite messaggi di sistema.

**Auto-Riflessione** - Il modello valuta e migliora il proprio output.

**Analisi Strutturata** - Framework di valutazione fisso.

**Pattern di Esecuzione compiti** - Pianifica → Esegui → Riepiloga.

## RAG (Retrieval-Augmented Generation) - [Modulo 03](../03-rag/README.md)

**Pipeline di Elaborazione Documenti** - Carica → spezza → embedd → archivia.

**Embedding Store in Memoria** - Storage non persistente per test.

**RAG** - Combina retrieval con generazione per ancorare le risposte.

**Punteggio di Similarità** - Misura (0-1) di similarità semantica.

**Riferimento alla Fonte** - Metadata sul contenuto recuperato.

## Agenti e Strumenti - [Modulo 04](../04-tools/README.md)

**Annotazione @Tool** - Marca metodi Java come strumenti richiamabili dall’AI.

**Pattern ReAct** - Ragiona → Agisci → Osserva → Ripeti.

**Gestione Sessione** - Contesti separati per utenti diversi.

**Strumento** - Funzione che un agente AI può chiamare.

**Descrizione Strumento** - Documentazione dello scopo e parametri dello strumento.

## Modulo Agentic - [Modulo 05](../05-mcp/README.md)

**Annotazione @Agent** - Marca interfacce come agenti AI con definizione comportamentale dichiarativa.

**Agent Listener** - Hook per monitorare esecuzione agente via `beforeAgentInvocation()` e `afterAgentInvocation()`.

**Ambito Agentic** - Memoria condivisa dove agenti salvano output usando `outputKey` per agenti a valle.

**AgenticServices** - Factory per creare agenti usando `agentBuilder()` e `supervisorBuilder()`.

**Flusso Condizionale** - Routing basato su condizioni verso agenti specialisti differenti.

**Human-in-the-Loop** - Pattern di flusso che aggiunge checkpoint umani per approvazione o revisione contenuti.

**langchain4j-agentic** - Dipendenza Maven per costruzione dichiarativa agenti (sperimentale).

**Flusso a Ciclo** - Itera esecuzione agente fino a soddisfare una condizione (es. punteggio qualità ≥ 0.8).

**outputKey** - Parametro annotazione agente che specifica dove salvare i risultati in Ambito Agentic.

**Flusso Parallelo** - Esegue più agenti simultaneamente per compiti indipendenti.

**Strategia di Risposta** - Come il supervisore formula la risposta finale: LAST, SUMMARY, o SCORED.

**Flusso Sequenziale** - Esecuzione agente in ordine in cui l'output fluisce al passo successivo.

**Pattern Agente Supervisore** - Pattern agentic avanzato in cui un supervisore LLM decide dinamicamente quali sotto-agenti invocare.

## Model Context Protocol (MCP) - [Modulo 05](../05-mcp/README.md)

**langchain4j-mcp** - Dipendenza Maven per integrazione MCP in LangChain4j.

**MCP** - Model Context Protocol: standard per connettere app AI a strumenti esterni. Costruisci una volta, usa ovunque.

**Client MCP** - Applicazione che si connette a server MCP per scoprire e utilizzare strumenti.

**Server MCP** - Servizio che espone strumenti via MCP con descrizioni chiare e schemi parametri.

**McpToolProvider** - Componente LangChain4j che incapsula strumenti MCP per uso in servizi AI e agenti.

**McpTransport** - Interfaccia per comunicazione MCP. Implementazioni includono Stdio e HTTP.

**Trasporto Stdio** - Trasporto processo locale via stdin/stdout. Utile per accesso filesystem o strumenti CLI.

**StdioMcpTransport** - Implementazione LangChain4j che avvia server MCP come subprocesso.

**Scoperta Strumenti** - Il client interroga il server per strumenti disponibili con descrizioni e schemi.

## Servizi Azure - [Modulo 01](../01-introduction/README.md)

**Azure AI Search** - Ricerca cloud con capacità vettoriali. [Modulo 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Distribuisce risorse Azure.

**Azure OpenAI** - Servizio AI enterprise di Microsoft.

**Bicep** - Linguaggio infrastructure-as-code per Azure. [Guida Infrastructure](../01-introduction/infra/README.md)

**Nome Distribuzione** - Nome per il deployment del modello in Azure.

**GPT-5.2** - Ultimo modello OpenAI con controllo del ragionamento. [Modulo 02](../02-prompt-engineering/README.md)

## Testing e Sviluppo - [Guida al Testing](TESTING.md)

**Dev Container** - Ambiente di sviluppo containerizzato. [Configurazione](../../../.devcontainer/devcontainer.json)

**Testing in Memoria** - Test con storage in memoria.

**Testing di Integrazione** - Test con infrastruttura reale.

**Maven** - Strumento di automazione build Java.

**Mockito** - Framework mocking Java.

**Spring Boot** - Framework applicazioni Java. [Modulo 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:
Questo documento è stato tradotto utilizzando il servizio di traduzione AI [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire la precisione, si prega di notare che le traduzioni automatizzate possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa deve essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un essere umano. Non siamo responsabili per eventuali malintesi o interpretazioni errate derivanti dall’uso di questa traduzione.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->