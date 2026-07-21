# LangChain4j Glossar

## Inhaltsverzeichnis

- [Kernkonzepte](#kernkonzepte)
- [LangChain4j-Komponenten](#langchain4j-komponenten)
- [KI/ML-Konzepte](#kiml-konzepte)
- [Schutzmaßnahmen](#schutzmaßnahmen)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agenten und Werkzeuge](#agents-and-tools---module-04)
- [Agentisches Modul](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure-Dienste](#azure-services---module-01)
- [Testen und Entwicklung](#testing-and-development---testing-guide)

Kurze Referenz für Begriffe und Konzepte, die im gesamten Kurs verwendet werden.

## Kernkonzepte

**KI-Agent** – System, das KI nutzt, um autonom zu denken und zu handeln. [Modul 04](../04-tools/README.md)

**Kette** – Abfolge von Operationen, bei denen die Ausgabe in den nächsten Schritt fließt.

**Chunking** – Aufteilen von Dokumenten in kleinere Stücke. Typisch: 300-500 Tokens mit Überlappung. [Modul 03](../03-rag/README.md)

**Kontextfenster** – Maximale Tokens, die ein Modell verarbeiten kann. GPT-5.2: 400K Tokens (bis zu 272K Eingabe, 128K Ausgabe).

**Embeddings** – Numerische Vektoren, die die Bedeutung von Text darstellen. [Modul 03](../03-rag/README.md)

**Funktionsaufruf** – Modell generiert strukturierte Anfragen, um externe Funktionen aufzurufen. [Modul 04](../04-tools/README.md)

**Halluzination** – Wenn Modelle falsche, aber plausible Informationen erzeugen.

**Prompt** – Texteingabe an ein Sprachmodell. [Modul 02](../02-prompt-engineering/README.md)

**Semantische Suche** – Suche nach Bedeutung mit Embeddings, nicht mit Schlüsselwörtern. [Modul 03](../03-rag/README.md)

**Zustandsbehaftet vs. Zustandslos** – Zustandslos: kein Gedächtnis. Zustandsbehaftet: speichert Gesprächshistorie. [Modul 01](../01-introduction/README.md)

**Tokens** – Basiseinheiten von Text, die Modelle verarbeiten. Beeinflussen Kosten und Limits. [Modul 01](../01-introduction/README.md)

**Tool Chaining** – Sequenzielle Ausführung von Werkzeugen, bei der die Ausgabe den nächsten Aufruf informiert. [Modul 04](../04-tools/README.md)

## LangChain4j-Komponenten

**AiServices** – Erstellt typsichere KI-Service-Schnittstellen.

**OpenAiOfficialChatModel** – Vereinheitlichter Client für OpenAI und Azure OpenAI Modelle.

**OpenAiOfficialEmbeddingModel** – Erstellt Embeddings mittels OpenAI Official Client (unterstützt sowohl OpenAI als auch Azure OpenAI).

**ChatModel** – Kernschnittstelle für Sprachmodelle.

**ChatMemory** – Speichert die Gesprächshistorie.

**ContentRetriever** – Findet relevante Dokumentausschnitte für RAG.

**DocumentSplitter** – Teilt Dokumente in Stücke.

**EmbeddingModel** – Wandelt Text in numerische Vektoren um.

**EmbeddingStore** – Speichert und ruft Embeddings ab.

**MessageWindowChatMemory** – Speichert einen gleitenden Fensterbereich der letzten Nachrichten.

**PromptTemplate** – Erzeugt wiederverwendbare Prompts mit `{{variable}}` Platzhaltern.

**TextSegment** – Textabschnitt mit Metadaten. Wird in RAG verwendet.

**ToolExecutionRequest** – Stellt eine Anfrage zur Tool-Ausführung dar.

**UserMessage / AiMessage / SystemMessage** – Nachrichtentypen in Gesprächen.

## KI/ML-Konzepte

**Few-Shot Learning** – Beispiele in Prompts geben. [Modul 02](../02-prompt-engineering/README.md)

**Großes Sprachmodell (LLM)** – KI-Modelle, die auf großen Textmengen trainiert sind.

**Reasoning Effort** – GPT-5.2 Parameter zur Steuerung der Denkintensität. [Modul 02](../02-prompt-engineering/README.md)

**Temperatur** – Steuert die Zufälligkeit der Ausgabe. Niedrig=deterministisch, hoch=kreativ.

**Vektor-Datenbank** – Spezialisierte Datenbank für Embeddings. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** – Aufgaben ohne Beispiele ausführen. [Modul 02](../02-prompt-engineering/README.md)

## Schutzmaßnahmen

**Verteidigung in der Tiefe** – Mehrschichtiger Sicherheitsansatz, der Anwendungsschutz mit Anbietersicherheitsfiltern kombiniert.

**Hard Block** – Provider wirft HTTP 400 Fehler bei schweren Inhaltsverstößen.

**InputGuardrail** – LangChain4j-Schnittstelle zur Validierung der Benutzereingabe vor Übergabe an das LLM. Spart Kosten und Latenz, indem schädliche Prompts früh blockiert werden.

**InputGuardrailResult** – Rückgabetyp für Guardrail-Validierung: `success()` oder `fatal("Grund")`.

**OutputGuardrail** – Schnittstelle zur Validierung von KI-Antworten, bevor sie an Benutzer zurückgegeben werden.

**Provider Safety Filters** – Eingebaute Inhaltsfilter der KI-Anbieter (z. B. Azure OpenAI), die Verstöße auf API-Ebene erkennen.

**Soft Refusal** – Modell lehnt höflich ab zu antworten, ohne einen Fehler auszulösen.

## Prompt Engineering - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** – Schritt-für-Schritt-Denken für höhere Genauigkeit.

**Eingeschränkte Ausgabe** – Erzwingt bestimmtes Format oder Struktur.

**Hohe Eiferbereitschaft** – GPT-5.2 Muster für gründliches Nachdenken.

**Niedrige Eiferbereitschaft** – GPT-5.2 Muster für schnelle Antworten.

**Multi-Turn Conversation** – Kontext über mehrere Austausche beibehalten.

**Rollenbasiertes Prompting** – Modell-Persona durch Systemnachrichten festlegen.

**Selbstreflexion** – Modell bewertet und verbessert seine Ausgabe.

**Strukturierte Analyse** – Fester Bewertungsrahmen.

**Aufgaben-Ausführungsmuster** – Planen → Ausführen → Zusammenfassen.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Dokumentenverarbeitungspipeline** – Laden → chunking → embedding → speichern.

**In-Memory Embedding Store** – Nicht persistenter Speicher für Tests.

**RAG** – Kombiniert Abruf mit Generierung, um Antworten zu belegen.

**Ähnlichkeitsscore** – Maß (0-1) für semantische Ähnlichkeit.

**Quellenreferenz** – Metadaten über abgerufene Inhalte.

## Agenten und Werkzeuge - [Modul 04](../04-tools/README.md)

**@Tool Annotation** – Markiert Java-Methoden als von KI aufrufbare Werkzeuge.

**ReAct Muster** – Überlegen → Handeln → Beobachten → Wiederholen.

**Sitzungsmanagement** – Getrennte Kontexte für verschiedene Benutzer.

**Werkzeug** – Funktion, die ein KI-Agent aufrufen kann.

**Werkzeugbeschreibung** – Dokumentation von Zweck und Parametern.

## Agentisches Modul - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** – Markiert Schnittstellen als KI-Agenten mit deklarativer Verhaltensdefinition.

**Agent Listener** – Hook zur Überwachung der Agentausführung via `beforeAgentInvocation()` und `afterAgentInvocation()`.

**Agentic Scope** – Gemeinsamer Speicher, in dem Agenten Ergebnisse unter `outputKey` ablegen, damit nachfolgende Agenten sie verwenden können.

**AgenticServices** – Fabrik für das Erstellen von Agenten über `agentBuilder()` und `supervisorBuilder()`.

**Conditional Workflow** – Weiterleitung basierend auf Bedingungen zu verschiedenen Spezial-Agenten.

**Human-in-the-Loop** – Workflow-Muster mit menschlichen Kontrollpunkten für Freigabe oder Inhaltsprüfung.

**langchain4j-agentic** – Maven-Abhängigkeit für deklaratives Agentenbauen (experimentell).

**Loop Workflow** – Wiederholte Agentenausführung bis eine Bedingung erfüllt ist (z. B. Qualitätswert ≥ 0.8).

**outputKey** – Agentenannotation-Parameter, der angibt, wo Ergebnisse im Agentic Scope gespeichert werden.

**Parallel Workflow** – Gleichzeitiges Ausführen mehrerer Agenten für unabhängige Aufgaben.

**Response Strategy** – Wie der Supervisor die finale Antwort formuliert: LAST, SUMMARY oder SCORED.

**Sequential Workflow** – Agenten nacheinander ausführen, wobei die Ausgabe zum nächsten Schritt fließt.

**Supervisor Agent Pattern** – Fortgeschrittenes agentisches Muster, bei dem ein Supervisor-LLM dynamisch entscheidet, welche Unteragenten aufgerufen werden.

## Model Context Protocol (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** – Maven-Abhängigkeit für MCP-Integration in LangChain4j.

**MCP** – Model Context Protocol: Standard zur Verbindung von KI-Anwendungen mit externen Werkzeugen. Einmal bauen, überall verwenden.

**MCP Client** – Anwendung, die sich mit MCP-Servern verbindet, um Werkzeuge zu entdecken und zu nutzen.

**MCP Server** – Dienst, der Werkzeuge via MCP mit klaren Beschreibungen und Parameterschemata bereitstellt.

**McpToolProvider** – LangChain4j-Komponente, die MCP-Werkzeuge für KI-Services und Agenten einbindet.

**McpTransport** – Schnittstelle für MCP-Kommunikation. Implementierungen umfassen Stdio und HTTP.

**Stdio Transport** – Lokaler Prozess-Transport über stdin/stdout. Nützlich für Dateisystemzugriff oder Kommandozeilenwerkzeuge.

**StdioMcpTransport** – LangChain4j-Implementierung, die den MCP-Server als Unterprozess startet.

**Werkzeugentdeckung** – Client fragt Server nach verfügbaren Werkzeugen mit Beschreibungen und Schemata ab.

## Azure-Dienste - [Modul 01](../01-introduction/README.md)

**Azure AI Search** – Cloudsuche mit Vektorfähigkeiten. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** – Stellt Azure-Ressourcen bereit.

**Azure OpenAI** – Microsofts KI-Enterprise-Dienst.

**Bicep** – Infrastructure-as-Code-Sprache für Azure. [Infrastruktur-Anleitung](../01-introduction/infra/README.md)

**Bereitstellungsname** – Name für Modellbereitstellung in Azure.

**GPT-5.2** – Neuestes OpenAI-Modell mit Steuerung der Denkweise. [Modul 02](../02-prompt-engineering/README.md)

## Testen und Entwicklung - [Testing Guide](TESTING.md)

**Dev Container** – Containerisierte Entwicklungsumgebung. [Konfiguration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** – Testen mit im Speicher gehaltenen Daten.

**Integration Testing** – Testen mit echter Infrastruktur.

**Maven** – Java-Build-Automatisierungstool.

**Mockito** – Java-Mocking-Framework.

**Spring Boot** – Java-Anwendungsframework. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Haftungsausschluss**:
Dieses Dokument wurde mit dem KI-Übersetzungsdienst [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, beachten Sie bitte, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner Ursprungssprache gilt als maßgebliche Quelle. Bei kritischen Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die aus der Verwendung dieser Übersetzung entstehen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->