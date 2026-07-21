# Słownik LangChain4j

## Spis treści

- [Podstawowe pojęcia](#podstawowe-pojęcia)
- [Komponenty LangChain4j](#komponenty-langchain4j)
- [Pojęcia AI/ML](#pojęcia-aiml)
- [Zabezpieczenia](#zabezpieczenia)
- [Inżynieria promptów](#prompt-engineering---module-02)
- [RAG (Generowanie wspomagane wyszukiwaniem)](#rag-retrieval-augmented-generation---module-03)
- [Agenci i narzędzia](#agents-and-tools---module-04)
- [Moduł Agentic](#agentic-module---module-05)
- [Protokół kontekstu modelu (MCP)](#model-context-protocol-mcp---module-05)
- [Usługi Azure](#azure-services---module-01)
- [Testowanie i rozwój](#testing-and-development---testing-guide)

Szybkie odniesienie do terminów i pojęć używanych w trakcie kursu.

## Podstawowe pojęcia

**Agent AI** - System wykorzystujący AI do samodzielnego rozumowania i działania. [Moduł 04](../04-tools/README.md)

**Łańcuch** - Sekwencja operacji, w której wyjście zasila następny krok.

**Dzielenie na kawałki** - Dzielnie dokumentów na mniejsze części. Typowo: 300-500 tokenów z nakładką. [Moduł 03](../03-rag/README.md)

**Okno kontekstu** - Maksymalna liczba tokenów, które model może przetworzyć. GPT-5.2: 400K tokenów (do 272K wejścia, 128K wyjścia).

**Wektory osadzeń (Embeddings)** - Numeryczne wektory reprezentujące znaczenie tekstu. [Moduł 03](../03-rag/README.md)

**Wywołanie funkcji** - Model generuje strukturalne żądania wywołania funkcji zewnętrznych. [Moduł 04](../04-tools/README.md)

**Halucynacje** - Gdy modele generują nieprawdziwe, lecz wiarygodne informacje.

**Prompt** - Tekstowy input do modelu językowego. [Moduł 02](../02-prompt-engineering/README.md)

**Wyszukiwanie semantyczne** - Szukanie po znaczeniu używając embeddings, a nie słów kluczowych. [Moduł 03](../03-rag/README.md)

**Stanowe vs bezstanowe** - Bezstanowe: brak pamięci. Stanowe: utrzymuje historię rozmowy. [Moduł 01](../01-introduction/README.md)

**Tokeny** - Podstawowe jednostki tekstu przetwarzane przez modele. Wpływają na koszty i limity. [Moduł 01](../01-introduction/README.md)

**Łączenie narzędzi** - Sekwencyjne wykonywanie narzędzi, gdzie wyjście służy do kolejnego wywołania. [Moduł 04](../04-tools/README.md)

## Komponenty LangChain4j

**AiServices** - Tworzy typowo-bezpieczne interfejsy usług AI.

**OpenAiOfficialChatModel** - Ujednolicony klient dla modeli OpenAI i Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Tworzy embeddings używając oficjalnego klienta OpenAI (obsługuje OpenAI oraz Azure OpenAI).

**ChatModel** - Główny interfejs dla modeli językowych.

**ChatMemory** - Utrzymuje historię rozmowy.

**ContentRetriever** - Znajduje odpowiednie kawałki dokumentów dla RAG.

**DocumentSplitter** - Dzieli dokumenty na fragmenty.

**EmbeddingModel** - Konwertuje tekst na numeryczne wektory.

**EmbeddingStore** - Przechowuje i pobiera embeddings.

**MessageWindowChatMemory** - Utrzymuje przesuwne okno ostatnich wiadomości.

**PromptTemplate** - Tworzy wielokrotnego użytku prompt-y z `{{zmienna}}` jako miejscem na dane.

**TextSegment** - Fragment tekstu z metadanymi. Używany w RAG.

**ToolExecutionRequest** - Reprezentuje żądanie wykonania narzędzia.

**UserMessage / AiMessage / SystemMessage** - Typy wiadomości w rozmowie.

## Pojęcia AI/ML

**Uczenie na kilku przykładach (Few-Shot Learning)** - Podawanie przykładów w promptach. [Moduł 02](../02-prompt-engineering/README.md)

**Duży model językowy (LLM)** - Modele AI wytrenowane na ogromnej ilości danych tekstowych.

**Wysiłek rozumowania** - Parametr GPT-5.2 kontrolujący głębokość rozumowania. [Moduł 02](../02-prompt-engineering/README.md)

**Temperatura** - Kontroluje losowość wyjścia. Niska=deterministyczne, wysoka=kreatywne.

**Baza danych wektorów** - Specjalistyczna baza dla embeddings. [Moduł 03](../03-rag/README.md)

**Uczenie zerowego przykładu (Zero-Shot Learning)** - Wykonywanie zadań bez przykładów. [Moduł 02](../02-prompt-engineering/README.md)

## Zabezpieczenia

**Obrona warstwowa** - Wielowarstwowe podejście zabezpieczeń łączące zabezpieczenia na poziomie aplikacji z filtrami bezpieczeństwa dostawcy.

**Blokada krytyczna** - Dostawca zwraca błąd HTTP 400 dla poważnych naruszeń treści.

**InputGuardrail** - Interfejs LangChain4j walidujący dane wejściowe użytkownika zanim dotrą do LLM. Oszczędza koszty i opóźnienia blokując szkodliwe prompt-y na wczesnym etapie.

**InputGuardrailResult** - Typ zwracany przez walidację guardrail: `success()` lub `fatal("powód")`.

**OutputGuardrail** - Interfejs walidujący odpowiedzi AI przed przekazaniem użytkownikom.

**Filtry bezpieczeństwa dostawcy** - Wbudowane filtry treści od dostawców AI (np. Azure OpenAI) wykrywające naruszenia na poziomie API.

**Łagodne odmowa** - Model uprzejmie odmawia odpowiedzi bez zgłaszania błędu.

## Inżynieria promptów - [Moduł 02](../02-prompt-engineering/README.md)

**Chain-of-Thought (łańcuch myślowy)** - Krok po kroku rozumowanie dla lepszej dokładności.

**Ograniczone wyjście** - Wymuszanie określonego formatu lub struktury.

**Wysoka dokładność** - Wzorzec GPT-5.2 dla dogłębnego rozumowania.

**Niska dokładność** - Wzorzec GPT-5.2 dla szybkich odpowiedzi.

**Wieloturnowa rozmowa** - Utrzymywanie kontekstu przez wymianę wiadomości.

**Promptowanie oparte na roli** - Ustawianie persony modelu poprzez wiadomości systemowe.

**Auto-refleksja** - Model ocenia i poprawia swoje wyjście.

**Analiza strukturalna** - Stałe ramy ewaluacyjne.

**Wzorzec wykonania zadania** - Planowanie → Wykonanie → Podsumowanie.

## RAG (Generowanie wspomagane wyszukiwaniem) - [Moduł 03](../03-rag/README.md)

**Pipeline przetwarzania dokumentów** - Załaduj → podziel → zakotwicz → przechowuj.

**Pamięć podręczna embeddingów w pamięci (In-Memory Embedding Store)** - Nieperzystentne przechowywanie do testów.

**RAG** - Łączy wyszukiwanie z generowaniem, by ugruntować odpowiedzi.

**Wskaźnik podobieństwa** - Miara (0-1) semantycznego podobieństwa.

**Źródłowa referencja** - Metadane o znalezionym materiale.

## Agenci i narzędzia - [Moduł 04](../04-tools/README.md)

**Adnotacja @Tool** - Oznacza metody Java jako narzędzia wywoływane przez AI.

**Wzorzec ReAct** - Rozumuj → Działaj → Obserwuj → Powtarzaj.

**Zarządzanie sesjami** - Oddzielne konteksty dla różnych użytkowników.

**Narzędzie** - Funkcja, którą agent AI może wywołać.

**Opis narzędzia** - Dokumentacja celu narzędzia i jego parametrów.

## Moduł Agentic - [Moduł 05](../05-mcp/README.md)

**Adnotacja @Agent** - Oznacza interfejsy jako agentów AI z deklaratywną definicją zachowania.

**Listener agenta** - Hak do monitorowania wykonania agenta poprzez `beforeAgentInvocation()` i `afterAgentInvocation()`.

**Zakres agentic** - Wspólna pamięć, gdzie agenci zapisują wyniki używając `outputKey` do dalszego wykorzystania przez innych agentów.

**AgenticServices** - Fabryka tworząca agentów przez `agentBuilder()` i `supervisorBuilder()`.

**Warunkowy workflow** - Ruch na podstawie warunków do różnych specjalistycznych agentów.

**Człowiek w pętli (Human-in-the-Loop)** - Wzorzec workflow dodający ludzkie punkty kontrolne do zatwierdzania lub przeglądu treści.

**langchain4j-agentic** - Zależność Maven do deklaratywnej budowy agentów (eksperymentalne).

**Pętla workflow (Loop Workflow)** - Iteracja wykonania agenta aż do spełnienia warunku (np. wynik jakości ≥ 0.8).

**outputKey** - Parametr adnotacji agenta wskazujący miejsce zapisu wyników w Zakresie Agentic.

**Równoległy workflow** - Uruchamianie wielu agentów równocześnie dla niezależnych zadań.

**Strategia odpowiedzi** - Sposób formułowania ostatecznej odpowiedzi przez supervisor: OSTANIA, PODSUMOWANIE lub OCENIANA.

**Sekwencyjny workflow** - Wykonanie agentów po kolei, gdzie wyjście przepływa do następnego kroku.

**Wzorzec agenta supervisor** - Zaawansowany wzorzec, w którym agent supervisor LLM dynamicznie decyduje, których podagentów wywołać.

## Protokół kontekstu modelu (MCP) - [Moduł 05](../05-mcp/README.md)

**langchain4j-mcp** - Zależność Maven do integracji MCP w LangChain4j.

**MCP** - Protokół kontekstu modelu: standard łączenia aplikacji AI z zewnętrznymi narzędziami. Zbuduj raz, używaj wszędzie.

**Klient MCP** - Aplikacja łącząca się z serwerami MCP do odkrywania i używania narzędzi.

**Serwer MCP** - Usługa udostępniająca narzędzia przez MCP z jasnymi opisami i schematami parametrów.

**McpToolProvider** - Komponent LangChain4j opakowujący narzędzia MCP dla usług AI i agentów.

**McpTransport** - Interfejs komunikacji MCP. Implementacje to m.in. Stdio i HTTP.

**Transport Stdio** - Lokalny transport procesu przez stdin/stdout. Przydatny do dostępu do systemu plików lub narzędzi CLI.

**StdioMcpTransport** - Implementacja LangChain4j uruchamiająca serwer MCP jako podproces.

**Odkrywanie narzędzi** - Klient pyta serwer o dostępne narzędzia z opisami i schematami.

## Usługi Azure - [Moduł 01](../01-introduction/README.md)

**Azure AI Search** - Chmurowa wyszukiwarka z funkcjami wektorowymi. [Moduł 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Wdraża zasoby Azure.

**Azure OpenAI** - Usługa AI przedsiębiorstwa Microsoft.

**Bicep** - Język infrastruktury jako kod dla Azure. [Przewodnik infrastruktury](../01-introduction/infra/README.md)

**Nazwa wdrożenia** - Nazwa wdrożenia modelu w Azure.

**GPT-5.2** - Najnowszy model OpenAI z kontrolą rozumowania. [Moduł 02](../02-prompt-engineering/README.md)

## Testowanie i rozwój - [Przewodnik testowania](TESTING.md)

**Dev Container** - Konteneryzowane środowisko programistyczne. [Konfiguracja](../../../.devcontainer/devcontainer.json)

**Testowanie w pamięci** - Testowanie z pamięcią tymczasową.

**Testowanie integracyjne** - Testowanie z prawdziwą infrastrukturą.

**Maven** - Narzędzie automatyzacji kompilacji Java.

**Mockito** - Framework do mockowania w Javie.

**Spring Boot** - Framework aplikacji Java. [Moduł 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zastrzeżenie**:
Niniejszy dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Choć dążymy do dokładności, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub niedokładności. Oryginalny dokument w jego języku źródłowym należy uznawać za autorytatywne źródło. W przypadku informacji krytycznych zalecane jest skorzystanie z profesjonalnego tłumaczenia wykonanego przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->