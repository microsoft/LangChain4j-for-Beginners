# Λεξικό LangChain4j

## Περιεχόμενα

- [Βασικές Έννοιες](#βασικές-έννοιες)
- [Συστατικά LangChain4j](#συστατικά-langchain4j)
- [Έννοιες AI/ML](#έννοιες-aiml)
- [Προστατευτικά Μέτρα](#προστατευτικά-μέτρα)
- [Σχεδίαση Προτροπών](#prompt-engineering---module-02)
- [RAG (Ανάκτηση-Ενισχυμένη Γενιά)](#rag-retrieval-augmented-generation---module-03)
- [Πράκτορες και Εργαλεία](#agents-and-tools---module-04)
- [Agentic Module](#agentic-module---module-05)
- [Πρωτόκολλο Πλαισίου Μοντέλου (MCP)](#model-context-protocol-mcp---module-05)
- [Υπηρεσίες Azure](#azure-services---module-01)
- [Δοκιμές και Ανάπτυξη](#testing-and-development---testing-guide)

Γρήγορη αναφορά για όρους και έννοιες που χρησιμοποιούνται καθ’ όλη τη διάρκεια του μαθήματος.

## Βασικές Έννοιες

**AI Agent** - Σύστημα που χρησιμοποιεί ΤΝ για να συλλογιστεί και να δράσει αυτόνομα. [Module 04](../04-tools/README.md)

**Chain** - Ακολουθία λειτουργιών όπου η έξοδος τροφοδοτεί το επόμενο βήμα.

**Chunking** - Διαχωρισμός εγγράφων σε μικρότερα τμήματα. Τυπικά: 300-500 tokens με επικάλυψη. [Module 03](../03-rag/README.md)

**Context Window** - Μέγιστος αριθμός token που ένα μοντέλο μπορεί να επεξεργαστεί. GPT-5.2: 400Κ tokens (έως 272Κ εισόδου, 128Κ εξόδου).

**Embeddings** - Αριθμητικοί διανύσματα που αναπαριστούν το νόημα του κειμένου. [Module 03](../03-rag/README.md)

**Function Calling** - Το μοντέλο δημιουργεί δομημένα αιτήματα για κλήση εξωτερικών συναρτήσεων. [Module 04](../04-tools/README.md)

**Hallucination** - Όταν τα μοντέλα παράγουν λανθασμένες αλλά πιθανές πληροφορίες.

**Prompt** - Κείμενο εισόδου σε ένα γλωσσικό μοντέλο. [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - Αναζήτηση με βάση το νόημα χρησιμοποιώντας embeddings, όχι λέξεις-κλειδιά. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: χωρίς μνήμη. Stateful: διατηρεί ιστορικό συνομιλίας. [Module 01](../01-introduction/README.md)

**Tokens** - Βασικές μονάδες κειμένου που τα μοντέλα επεξεργάζονται. Επηρεάζουν κόστος και όρια. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Αλληλουχία εκτέλεσης εργαλείων όπου η έξοδος ενημερώνει την επόμενη κλήση. [Module 04](../04-tools/README.md)

## Συστατικά LangChain4j

**AiServices** - Δημιουργεί τύπος-ασφαλείς διεπαφές υπηρεσιών ΤΝ.

**OpenAiOfficialChatModel** - Ενοποιημένος πελάτης για μοντέλα OpenAI και Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Δημιουργεί embeddings χρησιμοποιώντας τον επίσημο πελάτη OpenAI (υποστηρίζει OpenAI και Azure OpenAI).

**ChatModel** - Βασική διεπαφή για γλωσσικά μοντέλα.

**ChatMemory** - Διατηρεί ιστορικό συνομιλίας.

**ContentRetriever** - Βρίσκει σχετικά κομμάτια εγγράφων για RAG.

**DocumentSplitter** - Διαχωρίζει έγγραφα σε κομμάτια.

**EmbeddingModel** - Μετατρέπει κείμενο σε αριθμητικά διανύσματα.

**EmbeddingStore** - Αποθηκεύει και ανακτά embeddings.

**MessageWindowChatMemory** - Διατηρεί κυλιόμενο παράθυρο πρόσφατων μηνυμάτων.

**PromptTemplate** - Δημιουργεί επαναχρησιμοποιήσιμες προτροπές με placeholders `{{variable}}`.

**TextSegment** - Τμήμα κειμένου με μεταδεδομένα. Χρησιμοποιείται στο RAG.

**ToolExecutionRequest** - Αναπαριστά αίτημα εκτέλεσης εργαλείου.

**UserMessage / AiMessage / SystemMessage** - Τύποι μηνυμάτων συνομιλίας.

## Έννοιες AI/ML

**Few-Shot Learning** - Παροχή παραδειγμάτων σε προτροπές. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Μοντέλα ΤΝ εκπαιδευμένα σε τεράστιο όγκο κειμένων.

**Reasoning Effort** - Παράμετρος GPT-5.2 που ελέγχει το βάθος σκέψης. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - Ελέγχει το βαθμό τυχαιότητας της εξόδου. Χαμηλό=ντετερμινιστικό, υψηλό=δημιουργικό.

**Vector Database** - Εξειδικευμένη βάση δεδομένων για embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Εκτέλεση εργασιών χωρίς παραδείγματα. [Module 02](../02-prompt-engineering/README.md)

## Προστατευτικά Μέτρα

**Defense in Depth** - Πολυεπίπεδη προσέγγιση ασφάλειας που συνδυάζει προστατευτικά σε επίπεδο εφαρμογής με φίλτρα ασφαλείας του παρόχου.

**Hard Block** - Ο πάροχος επιστρέφει σφάλμα HTTP 400 για σοβαρές παραβιάσεις περιεχομένου.

**InputGuardrail** - Διεπαφή LangChain4j για επικύρωση εισόδου χρήστη πριν φτάσει στο LLM. Εξοικονομεί κόστος και καθυστέρηση εμποδίζοντας επιβλαβείς προτροπές νωρίς.

**InputGuardrailResult** - Τύπος επιστροφής για επικύρωση guardrail: `success()` ή `fatal("reason")`.

**OutputGuardrail** - Διεπαφή για επικύρωση απαντήσεων ΤΝ πριν επιστραφούν στον χρήστη.

**Provider Safety Filters** - Ενσωματωμένα φίλτρα περιεχομένου από παρόχους ΤΝ (π.χ. Azure OpenAI) που ανιχνεύουν παραβάσεις σε επίπεδο API.

**Soft Refusal** - Το μοντέλο αρνείται ευγενικά να απαντήσει χωρίς να επιστρέφει σφάλμα.

## Σχεδίαση Προτροπών - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Βήμα-βήμα συλλογιστική για καλύτερη ακρίβεια.

**Constrained Output** - Εφαρμογή συγκεκριμένης μορφής ή δομής.

**High Eagerness** - Πρότυπο GPT-5.2 για προσεκτική συλλογιστική.

**Low Eagerness** - Πρότυπο GPT-5.2 για γρήγορες απαντήσεις.

**Multi-Turn Conversation** - Διατήρηση πλαισίου κατά τη διάρκεια πολλαπλών ανταλλαγών.

**Role-Based Prompting** - Ορισμός προσωπικότητας μοντέλου μέσω συστημικών μηνυμάτων.

**Self-Reflection** - Το μοντέλο αξιολογεί και βελτιώνει το αποτέλεσμα του.

**Structured Analysis** - Σταθερό πλαίσιο αξιολόγησης.

**Task Execution Pattern** - Σχεδιάζει → Εκτελεί → Συνοψίζει.

## RAG (Ανάκτηση-Ενισχυμένη Γενιά) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Φόρτωση → διαχωρισμός → ενσωμάτωση → αποθήκευση.

**In-Memory Embedding Store** - Μη μόνιμη αποθήκευση για δοκιμές.

**RAG** - Συνδυάζει ανάκτηση με γενιά για τεκμηρίωση απαντήσεων.

**Similarity Score** - Μέτρηση (0-1) σημασιολογικής ομοιότητας.

**Source Reference** - Μεταδεδομένα για το ανακτηθέν περιεχόμενο.

## Πράκτορες και Εργαλεία - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Σημαδεύει μεθόδους Java ως εργαλεία κλήσιμα από ΤΝ.

**ReAct Pattern** - Σκέψη → Δράση → Παρατήρηση → Επανάληψη.

**Session Management** - Ξεχωριστά πλαίσια για διαφορετικούς χρήστες.

**Tool** - Συνάρτηση που μπορεί να καλέσει ένας πράκτορας ΤΝ.

**Tool Description** - Τεκμηρίωση σκοπού και παραμέτρων εργαλείου.

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - Σηματοδοτεί διεπαφές ως πράκτορες ΤΝ με δηλωτικό ορισμό συμπεριφοράς.

**Agent Listener** - Γάντζος για παρακολούθηση εκτέλεσης πράκτορα μέσω `beforeAgentInvocation()` και `afterAgentInvocation()`.

**Agentic Scope** - Κοινόχρηστη μνήμη όπου οι πράκτορες αποθηκεύουν αποτελέσματα με `outputKey` για να τα χρησιμοποιήσουν επόμενοι πράκτορες.

**AgenticServices** - Εργοστάσιο δημιουργίας πρακτόρων με `agentBuilder()` και `supervisorBuilder()`.

**Conditional Workflow** - Διαδρομή βάσει συνθηκών σε διαφορετικούς ειδικούς πράκτορες.

**Human-in-the-Loop** - Πρότυπο ροής εργασίας με ανθρώπινους σταθμούς ελέγχου για έγκριση ή αναθεώρηση περιεχομένου.

**langchain4j-agentic** - Εξάρτηση Maven για δηλωτική δημιουργία πρακτόρων (πειραματική).

**Loop Workflow** - Επανάληψη εκτέλεσης πράκτορα μέχρι να πληρωθεί συνθήκη (π.χ. σκορ ποιότητας ≥ 0.8).

**outputKey** - Παράμετρος σχολιασμού πράκτορα που καθορίζει πού αποθηκεύονται τα αποτελέσματα στο Agentic Scope.

**Parallel Workflow** - Εκτέλεση πολλαπλών πρακτόρων ταυτόχρονα για ανεξάρτητες εργασίες.

**Response Strategy** - Πώς ο επιβλέπων διαμορφώνει την τελική απάντηση: LAST, SUMMARY ή SCORED.

**Sequential Workflow** - Εκτέλεση πρακτόρων με σειρά όπου η έξοδος ρέει στο επόμενο βήμα.

**Supervisor Agent Pattern** - Προχωρημένο agentic πρότυπο όπου ένας επιβλέπων LLM αποφασίζει δυναμικά ποιους υπο-πράκτορες να καλέσει.

## Πρωτόκολλο Πλαισίου Μοντέλου (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Εξάρτηση Maven για ενσωμάτωση MCP στο LangChain4j.

**MCP** - Πρωτόκολλο Πλαισίου Μοντέλου: πρότυπο για σύνδεση εφαρμογών ΤΝ με εξωτερικά εργαλεία. Φτιάχνεις μία φορά, χρησιμοποιείς παντού.

**MCP Client** - Εφαρμογή που συνδέεται με διακομιστές MCP για ανακάλυψη και χρήση εργαλείων.

**MCP Server** - Υπηρεσία που εκθέτει εργαλεία μέσω MCP με σαφείς περιγραφές και σχήματα παραμέτρων.

**McpToolProvider** - Συστατικό LangChain4j που υλοποιεί MCP εργαλεία για χρήση σε υπηρεσίες ΤΝ και πράκτορες.

**McpTransport** - Διεπαφή για επικοινωνία MCP. Υλοποιήσεις περιλαμβάνουν Stdio και HTTP.

**Stdio Transport** - Τοπικός μεταφορέας διαδικασιών μέσω stdin/stdout. Χρήσιμος για πρόσβαση σε σύστημα αρχείων ή εργαλεία γραμμής εντολών.

**StdioMcpTransport** - Υλοποίηση LangChain4j που εκκινεί MCP server ως υποδιαδικασία.

**Tool Discovery** - Ο πελάτης ζητά από το διακομιστή διαθέσιμα εργαλεία με περιγραφές και σχήματα.

## Υπηρεσίες Azure - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud αναζήτηση με δυνατότητες διανυσμάτων. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Ανάπτυξη πόρων Azure.

**Azure OpenAI** - Επιχειρησιακή υπηρεσία ΤΝ της Microsoft.

**Bicep** - Γλώσσα υποδομής ως κώδικας Azure. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Όνομα ανάπτυξης μοντέλου στο Azure.

**GPT-5.2** - Τελευταίο μοντέλο OpenAI με έλεγχο συλλογιστικής. [Module 02](../02-prompt-engineering/README.md)

## Δοκιμές και Ανάπτυξη - [Testing Guide](TESTING.md)

**Dev Container** - Περιβάλλον ανάπτυξης με κοντέινερ. [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Δοκιμή με αποθήκευση στη μνήμη.

**Integration Testing** - Δοκιμή με πραγματική υποδομή.

**Maven** - Εργαλείο αυτοματισμού κατασκευής Java.

**Mockito** - Πλαίσιο mocking για Java.

**Spring Boot** - Πλαίσιο εφαρμογής Java. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Αποποίηση ευθυνών**:
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία μετάφρασης με τεχνητή νοημοσύνη [Co-op Translator](https://github.com/Azure/co-op-translator). Ενώ επιδιώκουμε την ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή λανθασμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->