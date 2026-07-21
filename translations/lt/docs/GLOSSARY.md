# LangChain4j Žodynas

## Turinys

- [Pagrindinės sąvokos](#pagrindinės-sąvokos)
- [LangChain4j komponentai](#langchain4j-komponentai)
- [AI/ML sąvokos](#aiml-sąvokos)
- [Saugumo priemonės](#saugumo-priemonės)
- [Užklausų kūrimas](#prompt-engineering---module-02)
- [RAG (paieškos praturtinta generacija)](#rag-retrieval-augmented-generation---module-03)
- [Agentai ir įrankiai](#agents-and-tools---module-04)
- [Agentinis modulis](#agentic-module---module-05)
- [Modelio konteksto protokolas (MCP)](#model-context-protocol-mcp---module-05)
- [Azure paslaugos](#azure-services---module-01)
- [Testavimas ir vystymas](#testing-and-development---testing-guide)

Greitos nuorodos terminams ir sąvokoms, naudojamoms viso kurso metu.

## Pagrindinės sąvokos

**AI agentas** – sistema, kuri naudoja dirbtinį intelektą savarankiškai mąstyti ir veikti. [Modulis 04](../04-tools/README.md)

**Grandinė** – operacijų seka, kurioje kiekvieno žingsnio išvestis patenka į kitą žingsnį.

**Dokumentų skaidymas** – dokumentų padalijimas į mažesnes dalis. Tipiškai: 300–500 žodžių su persidengimu. [Modulis 03](../03-rag/README.md)

**Konteksto langas** – maksimalus modelio apdorojamų žodžių skaičius. GPT-5.2: 400K žodžių (iki 272K įvesties, 128K išvesties).

**Įterpimai** – skaitmeniniai vektoriai, atspindintys teksto prasmę. [Modulis 03](../03-rag/README.md)

**Funkcijų iškvietimas** – modelis generuoja struktūruotus prašymus iškviesti išorines funkcijas. [Modulis 04](../04-tools/README.md)

**Halucinacija** – kai modeliai generuoja neteisingą, bet įtikinamą informaciją.

**Užklausa** – teksto įvestis kalbos modeliui. [Modulis 02](../02-prompt-engineering/README.md)

**Semantinė paieška** – paieška pagal reikšmę naudojant įterpimus, o ne raktinius žodžius. [Modulis 03](../03-rag/README.md)

**Būsenoje laikomi prieš tai buvę duomenys (Stateful) prieš neprisimenančius (Stateless)** – Statelesni modeliai neturi atminties, stateful palaiko pokalbio istoriją. [Modulis 01](../01-introduction/README.md)

**Tokenai** – bazinės teksto vienetai, su kuriais modeliai dirba. Veikia kainas ir ribas. [Modulis 01](../01-introduction/README.md)

**Įrankių grandinimas** – įrankių nuoseklus vykdymas, kur vieno išvestis informuoja kitą kvietimą. [Modulis 04](../04-tools/README.md)

## LangChain4j komponentai

**AiServices** – kuria tipui saugias AI paslaugų sąsajas.

**OpenAiOfficialChatModel** – vieningas klientas OpenAI ir Azure OpenAI modeliams.

**OpenAiOfficialEmbeddingModel** – kuria įterpimus naudodamas OpenAI oficialų klientą (palaiko tiek OpenAI, tiek Azure OpenAI).

**ChatModel** – pagrindinė kalbos modelių sąsaja.

**ChatMemory** – palaiko pokalbio istoriją.

**ContentRetriever** – randa aktualius dokumentų gabalus RAG.

**DocumentSplitter** – padalija dokumentus į gabalus.

**EmbeddingModel** – paverčia tekstą skaitmeniniais vektoriais.

**EmbeddingStore** – saugo ir gauna įterpimus.

**MessageWindowChatMemory** – palaiko ritinį iš naujausių žinučių.

**PromptTemplate** – kuria pakartotinai naudojamas užklausas su `{{variable}}` vietų žymėmis.

**TextSegment** – teksto gabalas su metaduomenimis. Naudojamas RAG.

**ToolExecutionRequest** – atvaizduoja įrankio vykdymo užklausą.

**UserMessage / AiMessage / SystemMessage** – pokalbio žinučių tipai.

## AI/ML sąvokos

**Few-Shot mokymas** – pateikiami pavyzdžiai užklausose. [Modulis 02](../02-prompt-engineering/README.md)

**Didelis kalbos modelis (LLM)** – DI modeliai, apmokyti dideliuose teksto duomenyse.

**Mąstymo intensyvumas** – GPT-5.2 parametras, reguliuojantis mąstymo gylį. [Modulis 02](../02-prompt-engineering/README.md)

**Temperatūra** – reguliuoja išvesties atsitiktinumą. Žema = deterministinė, aukšta = kūrybiška.

**Vektorinė duomenų bazė** – specializuota duomenų bazė įterpimams. [Modulis 03](../03-rag/README.md)

**Zero-Shot mokymas** – užduočių vykdymas be pavyzdžių. [Modulis 02](../02-prompt-engineering/README.md)

## Saugumo priemonės

**Gynyba keliuose sluoksniuose** – daugiasluoksnė saugumo strategija, apjungianti programos lygio apsaugas su teikėjo saugumo filtrais.

**Griežtas blokavimas** – teikėjas grąžina HTTP 400 klaidą už itin sunkius turinio pažeidimus.

**InputGuardrail** – LangChain4j sąsaja vartotojo įvesties validavimui prieš perduodant LLM. Taupo kaštus ir vėlavimus anksčiau blokuojant kenksmingas užklausas.

**InputGuardrailResult** – saugumo validacijos rezultato tipas: `success()` arba `fatal("priežastis")`.

**OutputGuardrail** – sąsaja AI atsakymų validavimui prieš grąžinant vartotojui.

**Teikėjo saugumo filtrai** – AI teikėjų (pvz., Azure OpenAI) įmontuoti turinio filtrai, kurie fiksuoja pažeidimus API lygyje.

**Minkštas atsisakymas** – modelis mandagiai atsisako atsakyti, negrąžindamas klaidos.

## Užklausų kūrimas - [Modulis 02](../02-prompt-engineering/README.md)

**Minties grandinė (Chain-of-Thought)** – žingsnis po žingsnio mąstymas dėl geresnio tikslumo.

**Apribota išvestis** – įvedamos specifinės formatavimo taisyklės ar struktūra.

**Didelis noras veikti** – GPT-5.2 modelio šablonas išsamiai analizei.

**Mažas noras veikti** – GPT-5.2 šablonas greitiems atsakymams.

**Daugiarūšis pokalbis** – konteksto išlaikymas per keitimus.

**Vaidmens pagrindu užklausos** – modelio asmenybės nustatymas per sistemos žinutes.

**Savarankiškas atspindys** – modelis vertina ir gerina savo išvestį.

**Struktūruota analizė** – fiksuotas vertinimo rėmėjas.

**Užduočių vykdymo modelis** – planuoti → vykdyti → apibendrinti.

## RAG (paieškos praturtinta generacija) - [Modulis 03](../03-rag/README.md)

**Dokumentų apdorojimo grandinė** – įkelti → padalyti → įterpti → saugoti.

**Laikinas įterpimų saugyklos atmintyje variantas** – nepermanentiška saugykla testavimui.

**RAG** – kombinuoja paiešką su generavimu, pagrindžia atsakymus.

**Panašumo įvertis** – semantinio panašumo matas (0–1).

**Šaltinio nuoroda** – metaduomenys apie rastą turinį.

## Agentai ir įrankiai - [Modulis 04](../04-tools/README.md)

**@Tool anotacija** – pažymi Java metodus kaip DI kviečiamus įrankius.

**ReAct modelis** – mąstyk → veik → stebėk → kartok.

**Sesijų valdymas** – atskiri kontekstai skirtingiems vartotojams.

**Įrankis** – funkcija, kurią gali kviesti DI agentas.

**Įrankio aprašymas** – dokumentacija apie įrankio paskirtį ir parametrus.

## Agentinis modulis - [Modulis 05](../05-mcp/README.md)

**@Agent anotacija** – pažymi sąsajas kaip DI agentus su deklaratyviu elgesio aprašymu.

**Agentų klausytojas** – kabliukas stebėti agentų vykdymą per `beforeAgentInvocation()` ir `afterAgentInvocation()`.

**Agentinis kontekstas** – bendra atmintis, kurioje agentai saugo rezultatus naudodami `outputKey`, kad kiti agentai galėtų juos panaudoti.

**AgenticServices** – fabrikas agentams kurti naudojant `agentBuilder()` ir `supervisorBuilder()`.

**Sąlyginis darbo srautas** – maršrutas pagal sąlygas į skirtingus specialistų agentus.

**Žmogiškasis įsiterpimas (Human-in-the-Loop)** – darbo srauto modelis, pridedantis žmonių patvirtinimo ar turinio peržiūros etapus.

**langchain4j-agentic** – Maven priklausomybė deklaratyviam agentų kūrimui (eksperimentinis).

**Ciklinis darbo srautas** – kartoti agento vykdymą, kol bus pasiektas sąlygos kriterijus (pvz., kokybės įvertis ≥ 0.8).

**outputKey** – agento anotacijos parametras, nurodantis, kur Agentiniame kontekste saugomi rezultatai.

**Lygiagretus darbo srautas** – vienu metu vykdyti kelis agentus nepriklausomoms užduotims.

**Atsako strategija** – kaip prižiūrėtojas formuluoja galutinį atsakymą: PASKUTINIS, SANTRAUKA arba ĮVERTINTAS.

**Nuoseklus darbo srautas** – vykdyti agentus iš eilės taip, kad vieno išvestis patenka į kitą žingsnį.

**Prižiūrėtojo agento modelis** – pažangus agentinis modelis, kai prižiūrintysis LLM dinamiškai nusprendžia, kuriuos subagentus kviesti.

## Modelio konteksto protokolas (MCP) - [Modulis 05](../05-mcp/README.md)

**langchain4j-mcp** – Maven priklausomybė MCP integracijai LangChain4j.

**MCP** – Modelio konteksto protokolas: standartas, jungiantis DI programas su išoriniais įrankiais. Sukurk vieną kartą, naudok visur.

**MCP klientas** – programa, jungiantis prie MCP serverių ieškoti ir naudoti įrankius.

**MCP serveris** – paslauga, atverianti įrankius per MCP su aiškiais aprašymais ir parametrų schemomis.

**McpToolProvider** – LangChain4j komponentas, kuris apgaubia MCP įrankius, kad jie būtų panaudojami DI paslaugose ir agentuose.

**McpTransport** – sąsaja MCP komunikacijai. Implementacijos: Stdio ir HTTP.

**Stdio transportas** – vietinis proceso transportas per stdin/stdout. Naudinga prieigai prie failų ar komandų eilutės įrankių.

**StdioMcpTransport** – LangChain4j įgyvendinimas, kuris paleidžia MCP serverį kaip pagalbinį procesą.

**Įrankių atradimas** – klientas užklausia serverį apie turimus įrankius su aprašymais ir schemomis.

## Azure paslaugos - [Modulis 01](../01-introduction/README.md)

**Azure AI Search** – debesų paieška su vektorinėmis galimybėmis. [Modulis 03](../03-rag/README.md)

**Azure Developer CLI (azd)** – Azure išteklių diegimas.

**Azure OpenAI** – Microsoft įmonių DI paslauga.

**Bicep** – Azure infrastruktūros kaip kodo kalba. [Infrastruktūros vadovas](../01-introduction/infra/README.md)

**Diegimo pavadinimas** – modelio diegimo Azure pavadinimas.

**GPT-5.2** – naujausias OpenAI modelis su mąstymo valdymu. [Modulis 02](../02-prompt-engineering/README.md)

## Testavimas ir vystymas - [Testavimo vadovas](TESTING.md)

**Dev Container** – containerizuota vystymo aplinka. [Konfigūracija](../../../.devcontainer/devcontainer.json)

**Testavimas atmintyje** – testavimas naudojant laikiną atmintinę.

**Integracijos testavimas** – testavimas su realia infrastruktūra.

**Maven** – Java automatizuoto išrinkimo įrankis.

**Mockito** – Java imitavimo karkasas.

**Spring Boot** – Java taikomųjų programų karkasas. [Modulis 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:
Šis dokumentas buvo išverstas naudojant dirbtinio intelekto vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba laikomas autoritetingu šaltiniu. Svarbiai informacijai rekomenduojama naudoti profesionalų žmogiškąjį vertimą. Mes neatsakome už jokius nesusipratimus ar neteisingą interpretaciją, kilusią naudojantis šiuo vertimu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->