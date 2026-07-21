# Kamusi ya LangChain4j

## Orodha ya Maudhui

- [Madhumuni Muhimu](#madhumuni-muhimu)
- [Vijumlisho vya LangChain4j](#vijumlisho-vya-langchain4j)
- [Madhumuni ya AI/ML](#madhumuni-ya-aiml)
- [Barabara za Usalama](#barabara-za-usalama)
- [Uhandisi wa Msaada wa Maandishi](#prompt-engineering---module-02)
- [RAG (Uundaji ulioboreshwa kwa Urejelezaji)](#rag-retrieval-augmented-generation---module-03)
- [Wakala na Zana](#agents-and-tools---module-04)
- [Moduli ya Kiwakilishi](#agentic-module---module-05)
- [Itifaki ya Muktadha wa Mfano (MCP)](#model-context-protocol-mcp---module-05)
- [Huduma za Azure](#azure-services---module-01)
- [Upimaji na Maendeleo](#testing-and-development---testing-guide)

Marejeleo ya haraka kwa maneno na dhana zinazotumika katika kozi.

## Madhumuni Muhimu

**Wakala wa AI** - Mfumo unaotumia AI kufikiri na kutenda kwa uhuru. [Moduli 04](../04-tools/README.md)

**Mnyororo** - Mfuatano wa shughuli ambapo matokeo hutumiwa katika hatua inayofuata.

**Kugawanya** - Kuvunja hati katika vipande vidogo. Za kawaida: tokeni 300-500 zikiwa na mchanganyiko. [Moduli 03](../03-rag/README.md)

**Dirisha la Muktadha** - Kiasi kikubwa cha tokeni mfano unaweza kushughulikia. GPT-5.2: tokeni 400K (yaa 272K ya ingizo, 128K ya matokeo).

**Embedding** - Vekteta za nambari zinazowakilisha maana ya maandishi. [Moduli 03](../03-rag/README.md)

**Kupiga Simu ya Kazi** - Mfano hutengeneza maombi yaliyo sanifu kwa kupiga simu kazi za nje. [Moduli 04](../04-tools/README.md)

**Ku Halushinatia** - Wakati mifano inazalisha taarifa zisizo sahihi lakini zinaonekana kuwa za kweli.

**Msaada wa Maandishi** - Maandishi yaliyo ingizwa kwenye mfano wa lugha. [Moduli 02](../02-prompt-engineering/README.md)

**Utafutaji wa Kimaana** - Utafutaji kwa maana kwa kutumia embedding, si maneno muhimu. [Moduli 03](../03-rag/README.md)

**Mimi au Msingi** - Msingi: huna kumbukumbu. Mimi: huthamini historia ya mazungumzo. [Moduli 01](../01-introduction/README.md)

**Tokeni** - Vitengo vya msingi vya maandishi ambavyo mifano hushughulikia. Huidhinisha gharama na vizingiti. [Moduli 01](../01-introduction/README.md)

**Uunganishaji wa Zana** - Kutekeleza zana mfululizo ambapo matokeo hutumika kwa simu inayofuata. [Moduli 04](../04-tools/README.md)

## Vijumlisho vya LangChain4j

**AiServices** - Inaunda interfaces za huduma za AI zenye usalama wa aina.

**OpenAiOfficialChatModel** - Mteja wa umoja kwa ajili ya mifano ya OpenAI na Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Inaunda embedding kwa kutumia mteja Rasmi wa OpenAI (huunga mkono OpenAI na Azure OpenAI).

**ChatModel** - Kiolesura cha msingi kwa mifano ya lugha.

**ChatMemory** - Huhifadhi historia ya mazungumzo.

**ContentRetriever** - Huona vipande vya hati vinavyofaa kwa RAG.

**DocumentSplitter** - Huvunja hati katika vipande.

**EmbeddingModel** - Hubadilisha maandishi kuwa vekteta za nambari.

**EmbeddingStore** - Huhifadhi na hurudisha embedding.

**MessageWindowChatMemory** - Huhifadhi dirisha linaloelea la ujumbe wa karibuni.

**PromptTemplate** - Huutengeneza misaada inayorudiwa na sehemu za `{{variable}}`.

**TextSegment** - Kipande cha maandishi chenye metadata. Kinatumika katika RAG.

**ToolExecutionRequest** - Huonyesha ombi la utekelezaji wa zana.

**UserMessage / AiMessage / SystemMessage** - Aina za ujumbe za mazungumzo.

## Madhumuni ya AI/ML

**Kujifunza kwa Mfano Mdogo** - Kutoa mifano ndani ya msaada. [Moduli 02](../02-prompt-engineering/README.md)

**Mfano Mkubwa wa Lugha (LLM)** - Mifano ya AI iliyofunzwa kwa data kubwa ya maandishi.

**Juhudi za Kufikiri** - Kigezo cha GPT-5.2 kinachodhibiti kina cha kufikiri. [Moduli 02](../02-prompt-engineering/README.md)

**Joto** - Hudhibiti mwendelezo wa matokeo. Chini=sahihi, juu=mbunifu.

**Hifadhidata ya Vekteta** - Hifadhidata maalum kwa embedding. [Moduli 03](../03-rag/README.md)

**Kujifunza Bila Mfano** - Kutekeleza kazi bila mifano. [Moduli 02](../02-prompt-engineering/README.md)

## Barabara za Usalama

**Ulinzi wa Kina** - Mbinu ya usalama wa tabaka nyingi inayounganisha barabara za usalama kwa ngazi ya programu pamoja na vichujio vya usalama vya mtoa huduma.

**Kizuizi Mkali** - Mtoa huduma hutoa kosa la HTTP 400 kwa ukiukaji mkubwa wa maudhui.

**InputGuardrail** - Kiolesura cha LangChain4j cha kuthibitisha pembejeo za mtumiaji kabla hazijafika kwa LLM. Huokoa gharama na ucheleweshaji kwa kuzuia misaada hatari mapema.

**InputGuardrailResult** - Aina ya kurudisha uthibitishaji wa barabara za pembejeo: `success()` au `fatal("reason")`.

**OutputGuardrail** - Kiolesura cha kuthibitisha majibu ya AI kabla ya kurudisha kwa watumiaji.

**Vichujio vya Usalama vya Mtoa Huduma** - Vichujio vya maudhui vilivyojengwa ndani kutoka kwa watoa huduma wa AI (mfano, Azure OpenAI) vinavyokamata ukiukaji kwenye ngazi ya API.

**Kukataa kwa Hadhari** - Mfano unakataa kwa heshima kujibu bila kutoa kosa.

## Uhandisi wa Msaada wa Maandishi - [Moduli 02](../02-prompt-engineering/README.md)

**Mnyororo wa Mawazo** - Kufikiri hatua kwa hatua kwa usahihi bora.

**Matokeo yaliyo Thibitiwa** - Kudumisha muundo au mfumo mahususi.

**Hamasa ya Juu** - Muundo wa GPT-5.2 wa kufikiri kwa undani.

**Hamasa ya Chini** - Muundo wa GPT-5.2 wa majibu ya haraka.

**Mazungumzo ya Mizunguko Mingi** - Kudumisha muktadha katika kubadilishana.

**Msaada wa Kulingana na Nafasi** - Kuweka tabia ya mfano kupitia ujumbe wa mfumo.

**Kujitathmini** - Mfano huchambua na kuboresha matokeo yake.

**Uchambuzi ulio Pangwa** - Mfumo thabiti wa tathmini.

**Mfumo wa Kutekeleza Kazi** - Panga → Tekeleza → Fupisha.

## RAG (Uundaji ulioboreshwa kwa Urejelezaji) - [Moduli 03](../03-rag/README.md)

**Mtiririko wa Usindikaji wa Hati** - Pakua → gawanya → fanya embedding → hifadhi.

**Hifadhi ya Embedding Kabla ya Uhifadhi wa Kudumu** - Hifadhi isiyodumu kwa ajili ya upimaji.

**RAG** - Inachanganya urejelezaji na uundaji kutegemeza majibu.

**Alama ya Ulinganifu** - Kipimo (0-1) cha ulinganifu wa maana.

**Marejeo ya Chanzo** - Metadata kuhusu maudhui yaliyorejelewa.

## Wakala na Zana - [Moduli 04](../04-tools/README.md)

**@Tool Annotation** - Inaashiria njia za Java kama zana zinazoweza kupigiwa na AI.

**Muundo wa ReAct** - Fikiria → Tenda → Angalia → Rudia.

**Usimamizi wa Kikao** - Muktadha tofauti kwa watumiaji tofauti.

**Zana** - Kazi ambayo wakala wa AI anaweza kupiga simu.

**Maelezo ya Zana** - Nyaraka za kusudio la zana na vigezo.

## Moduli ya Kiwakilishi - [Moduli 05](../05-mcp/README.md)

**@Agent Annotation** - Inaashiria interfaces kama wakala wa AI zenye ufafanuzi wa tabia kwa njia ya tamko.

**Msikilizaji wa Wakala** - Kiungo cha kufuatilia utekelezaji wa wakala kwa `beforeAgentInvocation()` na `afterAgentInvocation()`.

**Eneo la Kiwakilishi** - Kumbukumbu ya pamoja ambamo mawakala hifadhi matokeo kwa kutumia `outputKey` kwa mawakala wa downstream kuyatumia.

**AgenticServices** - Kiwanda cha kuunda mawakala kwa kutumia `agentBuilder()` na `supervisorBuilder()`.

**Mtiririko wa Kazi wa Masharti** - Njia inayochagua mtoa huduma wa maalum kulingana na masharti.

**Binadamu Katika Mzunguko** - Muundo wa mtiririko wa kazi unaoongeza sehemu za binadamu kwa idhini au ukaguzi wa maudhui.

**langchain4j-agentic** - Tegemezi la Maven la ujenzi wa mawakala kwa njia ya matamko (jaribio).

**Mtiririko wa Kazi wa Mzunguko** - Rudia utekelezaji wa wakala hadi sharti lipatikane (mfano, alama ya ubora ≥ 0.8).

**outputKey** - Kigezo cha maelezo ya wakala kinachobainisha mahali ambapo matokeo yatahifadhiwa katika Eneo la Kiwakilishi.

**Mtiririko wa Kazi Sambamba** - Endesha mawakala wengi kwa wakati mmoja kwa kazi huru.

**Mkakati wa Majibu** - Jinsi msimamizi anavyoandaa jibu la mwisho: MWISHO, MUHTASARI, au ALAMA.

**Mtiririko wa Kazi Mfuatano** - Tekeleza mawakala kwa mpangilio ambapo matokeo huenda kwenye hatua inayofuata.

**Muundo wa Wakala Msimamizi** - Muundo wa kipekee wa wakala ambapo msimamizi LLM huchagua kwa nguvu mawakala madogo wa kuitwa.

## Itifaki ya Muktadha wa Mfano (MCP) - [Moduli 05](../05-mcp/README.md)

**langchain4j-mcp** - Tegemezi la Maven kwa ushirikiano wa MCP katika LangChain4j.

**MCP** - Itifaki ya Muktadha wa Mfano: kiwango cha kuunganisha programu za AI na zana za nje. Jenga mara moja, tumia kila mahali.

**MCP Client** - Programu inayounganisha kwa seva za MCP kugundua na kutumia zana.

**MCP Server** - Huduma inayoonyesha zana kupitia MCP na maelezo wazi pamoja na miundo ya vigezo.

**McpToolProvider** - Kijumlisho cha LangChain4j kinachozunguka zana za MCP kwa matumizi katika huduma za AI na mawakala.

**McpTransport** - Kiolesura cha mawasiliano ya MCP. Utekelezaji ni pamoja na Stdio na HTTP.

**Usafirishaji wa Stdio** - Usafirishaji wa mchakato wa ndani kupitia stdin/stdout. Inafaa kwa upatikanaji wa mfumo wa faili au zana za mstari wa amri.

**StdioMcpTransport** - Utekelezaji wa LangChain4j unaozindua seva ya MCP kama mchakato mdogo.

**Gundua Zana** - Mteja huuliza seva kuhusu zana zinazopatikana zilizo na maelezo na muundo.

## Huduma za Azure - [Moduli 01](../01-introduction/README.md)

**Azure AI Search** - Utafutaji wa wingu wenye uwezo wa vekteta. [Moduli 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Hupeleka rasilimali za Azure.

**Azure OpenAI** - Huduma ya AI ya kampuni ya Microsoft.

**Bicep** - Lugha ya Azure ya miundombinu kama msimbo. [Mwongozo wa Miundombinu](../01-introduction/infra/README.md)

**Jina la Uwekaji** - Jina la uwekaji wa mfano katika Azure.

**GPT-5.2** - Mfano wa OpenAI wa hivi karibuni wenye udhibiti wa fikra. [Moduli 02](../02-prompt-engineering/README.md)

## Upimaji na Maendeleo - [Mwongozo wa Upimaji](TESTING.md)

**Kifurushi cha Maendeleo** - Mazingira yaliyofungashwa kwa maendeleo. [Marekebisho](../../../.devcontainer/devcontainer.json)

**Upimaji wa Kumbukumbu ndani ya Kumbukumbu** - Upimaji kwa hifadhi ya muda.

**Upimaji wa Uunganishaji** - Upimaji kwa miundombinu halisi.

**Maven** - Zana ya uendeshaji majengo ya Java.

**Mockito** - Mfumo wa kuiga katika Java.

**Spring Boot** - Mfumo wa programu wa Java. [Moduli 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Kionyozo**:
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kupata usahihi, tafadhali fahamu kwamba tafsiri za kiotomatiki zinaweza kuwa na makosa au upungufu wa usahihi. Hati ya asili katika lugha yake halisi inapaswa kuchukuliwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu inayofanywa na binadamu inapendekezwa. Hatutojibu kwa kuelewa vibaya au tafsiri potofu zinazotokea kutokana na matumizi ya tafsiri hii.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->