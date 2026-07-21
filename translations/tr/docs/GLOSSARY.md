# LangChain4j Sözlüğü

## İçindekiler

- [Temel Kavramlar](#temel-kavramlar)
- [LangChain4j Bileşenleri](#langchain4j-bileşenleri)
- [AI/ML Kavramları](#aiml-kavramları)
- [Koruma Yolları](#koruma-yolları)
- [Prompt Mühendisliği](#prompt-engineering---module-02)
- [RAG (Alkılımsal Üretim)](#rag-retrieval-augmented-generation---module-03)
- [Ajanlar ve Araçlar](#agents-and-tools---module-04)
- [Ajan Modülü](#agentic-module---module-05)
- [Model Bağlam Protokolü (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Hizmetleri](#azure-services---module-01)
- [Test ve Geliştirme](#testing-and-development---testing-guide)

Kurs boyunca kullanılan terimler ve kavramlar için hızlı referans.

## Temel Kavramlar

**AI Agent** - Yapay zekayı kullanarak otonom şekilde düşünen ve hareket eden sistem. [Modül 04](../04-tools/README.md)

**Chain** - Bir sonraki adıma çıktı veren operasyonlar zinciri.

**Chunking** - Belgeleri daha küçük parçalara ayırma. Tipik: 300-500 token arası, örtüşmeli. [Modül 03](../03-rag/README.md)

**Context Window** - Bir modelin işleyebileceği maksimum token sayısı. GPT-5.2: 400K token (en fazla 272K girdi, 128K çıktı).

**Embeddings** - Metin anlamını temsil eden sayısal vektörler. [Modül 03](../03-rag/README.md)

**Function Calling** - Modelin harici fonksiyonları çağırmak için yapılandırılmış istekler oluşturması. [Modül 04](../04-tools/README.md)

**Hallucination** - Modellerin yanlış fakat makul görünen bilgi üretmesi.

**Prompt** - Dil modeline verilen metin girdisi. [Modül 02](../02-prompt-engineering/README.md)

**Semantic Search** - Anahtar kelime yerine anlam kullanarak arama yapma. [Modül 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: hafızasız. Stateful: konuşma geçmişini tutar. [Modül 01](../01-introduction/README.md)

**Tokens** - Modellerin işlediği temel metin birimleri. Maliyet ve sınırları etkiler. [Modül 01](../01-introduction/README.md)

**Tool Chaining** - Çıktısı sonraki çağrıyı yönlendiren ardışık araç çalıştırma. [Modül 04](../04-tools/README.md)

## LangChain4j Bileşenleri

**AiServices** - Tür güvenli yapay zeka hizmet arayüzleri oluşturur.

**OpenAiOfficialChatModel** - OpenAI ve Azure OpenAI modelleri için birleşik istemci.

**OpenAiOfficialEmbeddingModel** - OpenAI Official istemci kullanarak embedding oluşturur (OpenAI ve Azure OpenAI destekler).

**ChatModel** - Dil modelleri için temel arayüz.

**ChatMemory** - Konuşma geçmişini tutar.

**ContentRetriever** - RAG için ilgili belge parçalarını bulur.

**DocumentSplitter** - Belgeleri parçalara ayırır.

**EmbeddingModel** - Metni sayısal vektörlere dönüştürür.

**EmbeddingStore** - Embeddingleri depolar ve alır.

**MessageWindowChatMemory** - Son mesajların kayan penceresini tutar.

**PromptTemplate** - `{{değişken}}` yer tutucularıyla yeniden kullanılabilir promptlar oluşturur.

**TextSegment** - Metadata içeren metin parçası. RAG’de kullanılır.

**ToolExecutionRequest** - Araç yürütme isteğini temsil eder.

**UserMessage / AiMessage / SystemMessage** - Konuşma mesaj türleri.

## AI/ML Kavramları

**Few-Shot Learning** - Promptlarda örnekler sağlama. [Modül 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Devasa metin veri ile eğitilmiş yapay zeka modelleri.

**Reasoning Effort** - Düşünme derinliğini kontrol eden GPT-5.2 parametresi. [Modül 02](../02-prompt-engineering/README.md)

**Temperature** - Çıktı rastgeleliğini kontrol eder. Düşük=kesin, yüksek=yaratıcı.

**Vector Database** - Embeddingler için özelleşmiş veritabanı. [Modül 03](../03-rag/README.md)

**Zero-Shot Learning** - Örnek olmadan görev yapma. [Modül 02](../02-prompt-engineering/README.md)

## Koruma Yolları

**Defense in Depth** - Uygulama seviyesinde koruma ve sağlayıcı güvenlik filtrelerini birleştiren çok katmanlı güvenlik yaklaşımı.

**Hard Block** - Sağlayıcının ciddi içerik ihlallerinde HTTP 400 hatası vermesi.

**InputGuardrail** - Kullanıcı girdisini LLM’ye ulaşmadan önce doğrulayan LangChain4j arayüzü. Zararlı promptları erken engelleyerek maliyet ve gecikmeyi azaltır.

**InputGuardrailResult** - Koruma doğrulama dönüş tipi: `success()` veya `fatal("sebep")`.

**OutputGuardrail** - AI yanıtlarını kullanıcıya dönmeden önce doğrulayan arayüz.

**Provider Safety Filters** - AI sağlayıcılarından (ör. Azure OpenAI) gelen, API seviyesinde ihlalleri yakalayan yerleşik içerik filtreleri.

**Soft Refusal** - Model nazikçe cevap vermeyi reddeder, hata vermez.

## Prompt Mühendisliği - [Modül 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Daha doğru sonuç için adım adım akıl yürütme.

**Constrained Output** - Belirli format veya yapıyı zorlamak.

**High Eagerness** - GPT-5.2 için detaylı akıl yürütme örüntüsü.

**Low Eagerness** - GPT-5.2 için hızlı yanıt örüntüsü.

**Multi-Turn Conversation** - Alışverişler arasında bağlam tutma.

**Role-Based Prompting** - Model kişiliğini sistem mesajlarıyla belirleme.

**Self-Reflection** - Model kendi çıktısını değerlendirip geliştirir.

**Structured Analysis** - Sabit değerlendirme çerçevesi.

**Task Execution Pattern** - Planla → Uygula → Özetle.

## RAG (Alkılımsal Üretim) - [Modül 03](../03-rag/README.md)

**Document Processing Pipeline** - Yükle → parçalara ayır → embedle → depola.

**In-Memory Embedding Store** - Test için geçici bellek içi depolama.

**RAG** - Yanıtları temellendirmek için retrieval ile üretimi birleştirme.

**Similarity Score** - Anlamsal benzerlik ölçüsü (0-1 arası).

**Source Reference** - Alınan içeriğin meta verisi.

## Ajanlar ve Araçlar - [Modül 04](../04-tools/README.md)

**@Tool Annotation** - Java metodlarını AI çağrılabilir araç olarak işaretler.

**ReAct Pattern** - Düşün → Hareket Et → Gözlemle → Tekrarla.

**Session Management** - Farklı kullanıcılar için ayrı bağlamlar.

**Tool** - AI ajanının çağırabileceği fonksiyon.

**Tool Description** - Araç amacı ve parametre dokümantasyonu.

## Ajan Modülü - [Modül 05](../05-mcp/README.md)

**@Agent Annotation** - AI ajanlarını deklaratif davranış tanımıyla işaretler.

**Agent Listener** - `beforeAgentInvocation()` ve `afterAgentInvocation()` ile ajan yürütmesini izleme kancası.

**Agentic Scope** - Ajanların sonuçları `outputKey` ile paylaşıp sonraki ajanların kullanabileceği paylaşılan bellek.

**AgenticServices** - `agentBuilder()` ve `supervisorBuilder()` ile ajan yaratma fabrikası.

**Conditional Workflow** - Şartlara göre farklı uzman ajanlara yönlendirme.

**Human-in-the-Loop** - Onay veya içerik inceleme için insan kontrol noktaları ekleyen iş akışı.

**langchain4j-agentic** - Deklaratif ajan oluşturma için Maven bağımlılığı (deneysel).

**Loop Workflow** - Bir koşul sağlanana kadar ajan yürütmesini yineleme (örneğin kalite puanı ≥ 0.8).

**outputKey** - Sonuçların Agentic Scope’da depolanacağı yeri belirten ajan anotasyonu parametresi.

**Parallel Workflow** - Bağımsız görevler için birden fazla ajanı eşzamanlı çalıştırma.

**Response Strategy** - Süpervizörün son cevabı formüle etme biçimi: LAST, SUMMARY veya SCORED.

**Sequential Workflow** - Çıktıların sonraki adıma aktığı sıralı ajan yürütme.

**Supervisor Agent Pattern** - Süpervizör LLM’nin hangi alt ajanları çağıracağını dinamik olarak belirlediği gelişmiş ajan modeli.

## Model Bağlam Protokolü (MCP) - [Modül 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j için MCP entegrasyonu Maven bağımlılığı.

**MCP** - Model Context Protocol: Yapay zeka uygulamalarını harici araçlara bağlamak için standart. Bir defa oluştur, her yerde kullan.

**MCP Client** - MCP sunucularına bağlanan, araçları keşfedip kullanan uygulama.

**MCP Server** - MCP aracılığıyla araçları açıklamalar ve parametre şemalarıyla sunan hizmet.

**McpToolProvider** - MCP araçlarını AI servisleri ve ajanlarında kullanmak için saran LangChain4j bileşeni.

**McpTransport** - MCP iletişim arayüzü. Stdio ve HTTP uygulamaları mevcut.

**Stdio Transport** - stdin/stdout üzerinden yerel süreç iletişimi. Dosya sistemi erişimi veya komut satırı araçları için ideal.

**StdioMcpTransport** - MCP sunucusunu alt süreç olarak başlatan LangChain4j uygulaması.

**Tool Discovery** - İstemcinin kullanılabilir araçlar için sunucuya açıklamalar ve şemalarla sorgu yapması.

## Azure Hizmetleri - [Modül 01](../01-introduction/README.md)

**Azure AI Search** - Vektör özellikli bulut araması. [Modül 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azure kaynaklarını dağıtma aracı.

**Azure OpenAI** - Microsoft’un kurumsal AI servisi.

**Bicep** - Azure altyapı kodlama dili. [Altyapı Kılavuzu](../01-introduction/infra/README.md)

**Deployment Name** - Azure’daki model dağıtımı adı.

**GPT-5.2** - Düşünme kontrolüne sahip en yeni OpenAI modeli. [Modül 02](../02-prompt-engineering/README.md)

## Test ve Geliştirme - [Test Kılavuzu](TESTING.md)

**Dev Container** - Konteyner tabanlı geliştirme ortamı. [Yapılandırma](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Bellek içi depolama ile test.

**Integration Testing** - Gerçek altyapı ile test.

**Maven** - Java yapı otomasyon aracı.

**Mockito** - Java taklit kütüphanesi.

**Spring Boot** - Java uygulama çatısı. [Modül 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Feragatname**:
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba sarf etsek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayınız. Orijinal belge, kendi dilinde yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımı sonucu ortaya çıkabilecek yanlış anlamalardan veya yanlış yorumlamalardan sorumlu değiliz.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->