# LangChain4j Sanasto

## Sisällysluettelo

- [Peruskäsitteet](#peruskäsitteet)
- [LangChain4j Komponentit](#langchain4j-komponentit)
- [AI/ML Käsitteet](#aiml-käsitteet)
- [Suojakaiteet](#suojakaiteet)
- [Prompt-suunnittelu](#prompt-engineering---module-02)
- [RAG (Hakua Tehostettu Generointi)](#rag-retrieval-augmented-generation---module-03)
- [Agentit ja Työkalut](#agents-and-tools---module-04)
- [Agenttien Moduuli](#agentic-module---module-05)
- [Mallin Kontekstiprotokolla (MCP)](#model-context-protocol-mcp---module-05)
- [Azure-palvelut](#azure-services---module-01)
- [Testaus ja Kehitys](#testing-and-development---testing-guide)

Pikaviite kurssin aikana käytettyihin termeihin ja käsitteisiin.

## Peruskäsitteet

**AI Agentti** - Järjestelmä, joka käyttää tekoälyä päättelemiseen ja toimimiseen itsenäisesti. [Moduuli 04](../04-tools/README.md)

**Ketju** - Toimintojen sarja, jossa yksi tuotanto syöttää seuraavaan vaiheeseen.

**Paloittelu** - Asiakirjojen jakaminen pienempiin osiin. Tyypillinen: 300–500 tokenia päällekkäin. [Moduuli 03](../03-rag/README.md)

**Kontekstin Ikkuna** - Maksimimäärä tokeneita, joita malli voi käsitellä. GPT-5.2: 400K tokenia (jopa 272K syöte, 128K tuloste).

**Upotukset** - Numeromuotoisia vektoreita, jotka kuvaavat tekstin merkitystä. [Moduuli 03](../03-rag/README.md)

**Funktiokutsut** - Malli tuottaa jäsenneltyjä pyyntöjä ulkoisten funktioiden kutsumiseksi. [Moduuli 04](../04-tools/README.md)

**Hallusinaatio** - Tilanne, jossa mallit tuottavat virheellistä mutta uskottavaa tietoa.

**Prompt** - Tekstisyöte kielimallille. [Moduuli 02](../02-prompt-engineering/README.md)

**Semanttinen Haku** - Haku merkityksen mukaan upotuksia käyttäen, ei avainsanoilla. [Moduuli 03](../03-rag/README.md)

**Tilan säilyttäminen vs. tilaton** - Tilaton: ei muistia. Tilallinen: säilyttää keskusteluhistorian. [Moduuli 01](../01-introduction/README.md)

**Tokenit** - Perusyksiköt, joita mallit käsittelevät. Vaikuttavat kustannuksiin ja rajoihin. [Moduuli 01](../01-introduction/README.md)

**Työkaluketjutus** - Työkalujen peräkkäinen suoritus, jossa tuotanto ohjaa seuraavaa kutsua. [Moduuli 04](../04-tools/README.md)

## LangChain4j Komponentit

**AiServices** - Luo tyyppiturvalliset AI-palvelurajapinnat.

**OpenAiOfficialChatModel** - Yhtenäinen asiakas OpenAI:n ja Azure OpenAI:n malleille.

**OpenAiOfficialEmbeddingModel** - Luo upotuksia OpenAI Official -asiakkaalla (tukee sekä OpenAI:ta että Azure OpenAI:ta).

**ChatModel** - Kielimallien ydinrajapinta.

**ChatMemory** - Säilyttää keskusteluhistorian.

**ContentRetriever** - Löytää olennaisia asiakirjapaloja RAG:ia varten.

**DocumentSplitter** - Jakaa asiakirjat paloihin.

**EmbeddingModel** - Muuntaa tekstin numeerisiksi vektoreiksi.

**EmbeddingStore** - Tallentaa ja hakee upotuksia.

**MessageWindowChatMemory** - Säilyttää liukuvan ikkunan viimeisimmistä viesteistä.

**PromptTemplate** - Luo uudelleenkäytettäviä prompt-malleja `{{variable}}` paikkamerkeillä.

**TextSegment** - Tekstipala metatiedolla. Käytetään RAG:issa.

**ToolExecutionRequest** - Edustaa työkalun suorituspyyntöä.

**UserMessage / AiMessage / SystemMessage** - Keskusteluviestityypit.

## AI/ML Käsitteet

**Few-Shot Learning** - Esimerkkien antaminen promptissa. [Moduuli 02](../02-prompt-engineering/README.md)

**Suuri Kielimalli (LLM)** - Tekoälymalleja, jotka on koulutettu laajalla tekstidatalla.

**Päätelmätarkkuus** - GPT-5.2:n parametri, joka säätelee pohdinnan syvyyttä. [Moduuli 02](../02-prompt-engineering/README.md)

**Lämpötila** - Säätää tuotannon satunnaisuutta. Matala=deterministinen, korkea=luova.

**Vektoripohjainen Tietokanta** - Erikoistunut tietokanta upotuksille. [Moduuli 03](../03-rag/README.md)

**Nollakoeoppiminen** - Tehtävien suorittaminen ilman esimerkkejä. [Moduuli 02](../02-prompt-engineering/README.md)

## Suojakaiteet

**Monitasoinen Suojaus** - Usean kerroksen turvamenetelmä, joka yhdistää sovellustason suojakaiteet tarjoajan turvallisuussuodattimiin.

**Hard Block** - Tarjoaja palauttaa HTTP 400 virheen vakavista sisältörikkomuksista.

**InputGuardrail** - LangChain4j-rajapinta käyttäjän syötteen validointiin ennen LLM:ää. Säästää kustannuksia ja viivettä blokkaamalla haitalliset promptit varhaisessa vaiheessa.

**InputGuardrailResult** - Palautustyyppi suojakaiteen validoinnissa: `success()` tai `fatal("syy")`.

**OutputGuardrail** - Rajapinta AI-vastausten validointiin ennen palauttamista käyttäjälle.

**Providerin Turvasuodattimet** - AI-palveluntarjoajien (esim. Azure OpenAI) sisäänrakennetut sisältösuodattimet, jotka havaitsevat rikkomukset API-tasolla.

**Pehmeä Kieltäytyminen** - Malli kohteliaasti kieltäytyy vastaamasta ilman virhettä.

## Prompt-suunnittelu - [Moduuli 02](../02-prompt-engineering/README.md)

**Ajatusketju** - Askel askeleelta -päätelmät paremman tarkkuuden saavuttamiseksi.

**Rajoitettu Tuotos** - Tietyn muodon tai rakenteen pakottaminen.

**Korkea Innokkuus** - GPT-5.2 kuvio perusteelliseen päättelyyn.

**Matala Innokkuus** - GPT-5.2 kuvio nopeisiin vastauksiin.

**Monikierroksinen Keskustelu** - Kontekstin ylläpito vaihtojen välillä.

**Roolipohjainen Prompttaus** - Mallipersoonan asettaminen järjestelmäviestein.

**Itsetutkiskelu** - Malli arvioi ja parantaa omaa tuotostaan.

**Rakenteellinen Analyysi** - Kiinteä arviointikehys.

**Tehtävän Suorituskuvio** - Suunnittele → Suorita → Yhteenveto.

## RAG (Hakua Tehostettu Generointi) - [Moduuli 03](../03-rag/README.md)

**Asiakirjaprosessointiputki** - Lataa → paloita → upota → tallenna.

**Muistipohjainen Upotusvarasto** - Ei-pysyvä tallennus testaukseen.

**RAG** - Yhdistää tiedonhakua ja generointia vastauksen perustaksi.

**Samanlaisuuspisteet** - Mitta (0-1) semanttisen samankaltaisuuden asteesta.

**Lähdeviite** - Metatiedot haetusta sisällöstä.

## Agentit ja Työkalut - [Moduuli 04](../04-tools/README.md)

**@Tool Annotaation** - Merkitsee Java-metodit tekoälyn kutsumiksi työkaluiksi.

**ReAct Kuvio** - Pätee → Toimi → Havainnoi → Toista.

**Istunnon Hallinta** - Eri käyttäjille erilliset kontekstit.

**Työkalu** - Toiminto, jonka tekoälyagentti voi kutsua.

**Työkalun Kuvaus** - Dokumentaatio työkalun tarkoituksesta ja parametreista.

## Agenttien Moduuli - [Moduuli 05](../05-mcp/README.md)

**@Agent Annotaation** - Merkitsee rajapinnat tekoälyagenteiksi deklaratiivisella käyttäytymismäärittelyllä.

**Agentin Kuuntelija** - Hook agentin suorituksen valvontaan `beforeAgentInvocation()` ja `afterAgentInvocation()` kautta.

**Agenttien Muisti** - Jaettu muisti, johon agentit tallentavat tuotoksia `outputKey` avulla, jota alemmat agentit voivat käyttää.

**Agenttien Palvelut** - Tehdas agenttien luomiseen `agentBuilder()` ja `supervisorBuilder()` -menetelmillä.

**Ehdollinen Työnkulku** - Reititys ehdon perusteella eri erikoisagentteihin.

**Ihminen Silmukassa** - Työnkulku, jossa on ihmisen tarkastuspisteet hyväksynnälle tai sisällön tarkastukselle.

**langchain4j-agentic** - Maven-riippuvuus deklaratiiviseen agentinrakentamiseen (kokeellinen).

**Silmukka Työnkulku** - Toistetaan agentin suoritus, kunnes ehto täyttyy (esim. laatuarvo ≥ 0.8).

**outputKey** - Agenttiannotaation parametri, joka määrittää minne tulokset tallennetaan agenttien muistissa.

**Rinnakkainen Työnkulku** - Usean agentin samanaikainen suoritus riippumattomille tehtäville.

**Vastausstrategia** - Miten valvoja muotoilee lopullisen vastauksen: VIIMEINEN, YHTEENVETO tai ARVIOITU.

**Järjestyksellinen Työnkulku** - Suoritetaan agentit peräkkäin, jolloin tuotanto virtaa seuraavaan vaiheeseen.

**Valvojan Agenttikuvio** - Edistynyt agenttikuva, jossa valvoja-LLM päättää dynaamisesti, mitä ala-agentteja kutsutaan.

## Mallin Kontekstiprotokolla (MCP) - [Moduuli 05](../05-mcp/README.md)

**langchain4j-mcp** - Maven-riippuvuus MCP-integraatioon LangChain4j:ssä.

**MCP** - Model Context Protocol: standardi AI-sovellusten liittämiseksi ulkoisiin työkaluihin. Rakennetaan kerran, käytetään kaikkialla.

**MCP Client** - Sovellus, joka yhdistää MCP-palvelimiin työkalujen löytöä ja käyttöä varten.

**MCP Server** - Palvelu, joka tarjoaa työkalut MCP:n kautta selkeine kuvauksineen ja parametriskaaloineen.

**McpToolProvider** - LangChain4j-komponentti, joka käärii MCP-työkalut AI-palvelujen ja agenttien käyttöön.

**McpTransport** - Rajapinta MCP-viestintään. Toteutuksia ovat Stdio ja HTTP.

**Stdio Transport** - Paikallinen prosessikuljetus stdin/stdoutin kautta. Kätevä tiedostojärjestelmän käyttöön tai komentorivityökaluihin.

**StdioMcpTransport** - LangChain4j-toteutus, joka käynnistää MCP-palvelimen aliprosessina.

**Työkalujen Löytäminen** - Client kysyy palvelimelta saatavilla olevat työkalut kuvauksineen ja skeemoineen.

## Azure-palvelut - [Moduuli 01](../01-introduction/README.md)

**Azure AI Search** - Pilvihakuratkaisu vektoritoiminnoilla. [Moduuli 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azure-resurssien käyttöönotto.

**Azure OpenAI** - Microsoftin yritystason tekoälypalvelu.

**Bicep** - Azure infrastruktuurikaavan kieli. [Infrastruktuuriohje](../01-introduction/infra/README.md)

**Käyttöönoton Nimi** - Mallin käyttöönoton nimi Azure-palvelussa.

**GPT-5.2** - Uusin OpenAI:n malli, jossa on päätelmien ohjaus. [Moduuli 02](../02-prompt-engineering/README.md)

## Testaus ja Kehitys - [Testausopas](TESTING.md)

**Dev Container** - Kontitetty kehitysympäristö. [Konfiguraatio](../../../.devcontainer/devcontainer.json)

**Muistitestaus** - Testaus muistipohjaisen tallennuksen avulla.

**Integraatiotestaus** - Testaus todellisella infrastruktuurilla.

**Maven** - Java build-automaatio työkalu.

**Mockito** - Java-kirjaston testauskirjasto.

**Spring Boot** - Java sovelluskehys. [Moduuli 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastuuvapauslauseke**:
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, otathan huomioon, että automaattiset käännökset saattavat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäiskielellä on virallinen lähde. Tärkeissä asioissa suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa tämän käännöksen käytöstä aiheutuvista väärinymmärryksistä tai tulkinnoista.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->