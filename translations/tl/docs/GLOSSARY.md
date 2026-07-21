# LangChain4j Glossary

## Table of Contents

- [Core Concepts](#core-concepts)
- [LangChain4j Components](#langchain4j-components)
- [AI/ML Concepts](#aiml-concepts)
- [Guardrails](#guardrails)
- [Prompt Engineering](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agents and Tools](#agents-and-tools---module-04)
- [Agentic Module](#agentic-module---module-05)
- [Model Context Protocol (MCP)](#model-context-protocol-mcp---module-05)
- [Azure Services](#azure-services---module-01)
- [Testing and Development](#testing-and-development---testing-guide)

Mabilisang sanggunian para sa mga termino at konsepto na ginagamit sa buong kurso.

## Core Concepts

**AI Agent** - Sistema na gumagamit ng AI upang mag-isip at kumilos nang awtonomo. [Module 04](../04-tools/README.md)

**Chain** - Sunod-sunod na operasyon kung saan ang output ay nagsisilbing input sa susunod na hakbang.

**Chunking** - Paghahati ng mga dokumento sa maliliit na bahagi. Karaniwan: 300-500 na token na may overlap. [Module 03](../03-rag/README.md)

**Context Window** - Pinakamalaking bilang ng token na kayang proseso ng modelo. GPT-5.2: 400K token (hanggang 272K input, 128K output).

**Embeddings** - Numerikal na vectors na kumakatawan sa kahulugan ng teksto. [Module 03](../03-rag/README.md)

**Function Calling** - Ang modelo ay gumagawa ng istrukturadong hinihiling upang tawagan ang mga panlabas na function. [Module 04](../04-tools/README.md)

**Hallucination** - Kapag ang mga modelo ay lumilikha ng maling ngunit kapanipaniwala na impormasyon.

**Prompt** - Input na teksto sa isang language model. [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - Paghahanap batay sa kahulugan gamit ang embeddings, hindi keywords. [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: walang memorya. Stateful: nagpapanatili ng kasaysayan ng pag-uusap. [Module 01](../01-introduction/README.md)

**Tokens** - Pangunahing yunit ng teksto na pinoproseso ng mga modelo. Nakakaapekto sa gastos at limitasyon. [Module 01](../01-introduction/README.md)

**Tool Chaining** - Sunud-sunod na pagpapatakbo ng mga tool kung saan ang output ay ginagamit sa susunod na tawag. [Module 04](../04-tools/README.md)

## LangChain4j Components

**AiServices** - Lumilikha ng type-safe na mga interface para sa AI services.

**OpenAiOfficialChatModel** - Pinag-isang kliyente para sa OpenAI at Azure OpenAI na mga modelo.

**OpenAiOfficialEmbeddingModel** - Lumilikha ng embeddings gamit ang OpenAI Official client (sumusuporta sa parehong OpenAI at Azure OpenAI).

**ChatModel** - Pangunahing interface para sa mga language model.

**ChatMemory** - Nagpapanatili ng kasaysayan ng pag-uusap.

**ContentRetriever** - Naghahanap ng mga kaugnay na bahagi ng dokumento para sa RAG.

**DocumentSplitter** - Humahati sa mga dokumento sa mga chunks.

**EmbeddingModel** - Nagko-convert ng teksto sa numerikal na vectors.

**EmbeddingStore** - Nag-iimbak at kumukuha ng embeddings.

**MessageWindowChatMemory** - Nagpapanatili ng sliding window ng mga pinakabagong mensahe.

**PromptTemplate** - Lumilikha ng mga reusable na prompt na may `{{variable}}` na placeholders.

**TextSegment** - Bahagi ng teksto na may metadata. Ginagamit sa RAG.

**ToolExecutionRequest** - Kumakatawan sa hiling na pagpapatakbo ng tool.

**UserMessage / AiMessage / SystemMessage** - Mga uri ng mensahe sa pag-uusap.

## AI/ML Concepts

**Few-Shot Learning** - Nagbibigay ng mga halimbawa sa mga prompt. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - AI models na sinanay gamit ang napakaraming tekstuwal na datos.

**Reasoning Effort** - Parameter ng GPT-5.2 na kumokontrol sa lalim ng pag-iisip. [Module 02](../02-prompt-engineering/README.md)

**Temperature** - Kumokontrol sa randomness ng output. Mababang halaga=deterministic, mataas=malikhain.

**Vector Database** - Espesyal na database para sa embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Pagsasagawa ng mga gawain nang walang mga halimbawa. [Module 02](../02-prompt-engineering/README.md)

## Guardrails

**Defense in Depth** - Maramihang antas ng seguridad na pinagsasama ang mga guardrail sa antas ng application at mga provider safety filter.

**Hard Block** - Nagbibigay ang provider ng HTTP 400 error para sa seryosong paglabag sa nilalaman.

**InputGuardrail** - Interface ng LangChain4j para i-validate ang input ng user bago ito makarating sa LLM. Nakakatipid sa gastos at latency sa pamamagitan ng maagang pagharang sa mapanganib na mga prompt.

**InputGuardrailResult** - Uri ng return para sa validation ng guardrail: `success()` o `fatal("reason")`.

**OutputGuardrail** - Interface para sa pag-validate ng mga sagot ng AI bago ibalik sa mga user.

**Provider Safety Filters** - Mga built-in na filter ng nilalaman mula sa mga AI provider (hal. Azure OpenAI) na humahuli ng paglabag sa API level.

**Soft Refusal** - Magalang na pagtanggi ng modelo na sumagot nang hindi nagkakaroon ng error.

## Prompt Engineering - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Hakbang-hakbang na pag-unlad ng pag-iisip para sa mas mahusay na katumpakan.

**Constrained Output** - Pagpapatupad ng espesipikong format o istruktura.

**High Eagerness** - Pattern ng GPT-5.2 para sa masusing pag-iisip.

**Low Eagerness** - Pattern ng GPT-5.2 para sa mabilis na sagot.

**Multi-Turn Conversation** - Pagpapanatili ng konteksto sa iba't ibang palitan.

**Role-Based Prompting** - Pagtatakda ng persona ng modelo sa pamamagitan ng system messages.

**Self-Reflection** - Pagsusuri at pagpapabuti ng output ng modelo.

**Structured Analysis** - Nakapirming balangkas ng ebalwasyon.

**Task Execution Pattern** - Plano → Isagawa → Buodin.

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - Load → chunk → embed → store.

**In-Memory Embedding Store** - Hindi permanenteng imbakan para sa testing.

**RAG** - Pinagsasama ang retrieval at generation para masigurong nakabase ang mga sagot.

**Similarity Score** - Sukatan (0-1) ng semantic similarity.

**Source Reference** - Metadata tungkol sa nakuha na nilalaman.

## Agents and Tools - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Nagmamarka ng mga Java method bilang mga AI-callable na tool.

**ReAct Pattern** - Mag-isip → Kumilos → Obserbahan → Ulitin.

**Session Management** - Hiwa-hiwalay na mga konteksto para sa iba't ibang user.

**Tool** - Function na maaaring tawagin ng AI agent.

**Tool Description** - Dokumentasyon ng layunin at mga parameter ng tool.

## Agentic Module - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - Nagmamarka ng mga interface bilang AI agents na may deklaratibong depinisyon ng behavior.

**Agent Listener** - Hook para sa pagmamanman ng pagpapatupad ng agent sa pamamagitan ng `beforeAgentInvocation()` at `afterAgentInvocation()`.

**Agentic Scope** - Shared memory kung saan nag-iimbak ang mga agent ng output gamit ang `outputKey` para magamit ng mga downstream na agent.

**AgenticServices** - Pabrika para sa paggawa ng mga agent gamit ang `agentBuilder()` at `supervisorBuilder()`.

**Conditional Workflow** - Daan batay sa kondisyon patungo sa iba't ibang espesyalistang agent.

**Human-in-the-Loop** - Workflow pattern na naglalagay ng human checkpoint para sa pag-apruba o pagsusuri ng nilalaman.

**langchain4j-agentic** - Dependency sa Maven para sa deklaratibong paggawa ng agent (eksperimento).

**Loop Workflow** - Paulit-ulit na pagpapatakbo ng agent hanggang sa matugunan ang kondisyon (hal. quality score ≥ 0.8).

**outputKey** - Parameter ng annotation ng agent na nagsasaad kung saan iniimbak ang resulta sa Agentic Scope.

**Parallel Workflow** - Sabay-sabay na pagpapatakbo ng maraming agent para sa magkahiwalay na gawain.

**Response Strategy** - Paraan ng supervisor sa pagbubuo ng huling sagot: LAST, SUMMARY, o SCORED.

**Sequential Workflow** - Sunod-sunod na pagpapatakbo ng mga agent kung saan dumadaloy ang output sa susunod na hakbang.

**Supervisor Agent Pattern** - Advanced na pattern ng agentic kung saan ang isang supervisor LLM ang dinamiko na nagpapasya kung aling mga sub-agent ang tatawagin.

## Model Context Protocol (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependency sa Maven para sa integrasyon ng MCP sa LangChain4j.

**MCP** - Model Context Protocol: pamantayan para sa pagkonekta ng mga AI app sa mga panlabas na tool. Isa lang buuin, gamitin saanman.

**MCP Client** - Aplikasyon na nakakonekta sa MCP server para magdiskubre at gumamit ng mga tool.

**MCP Server** - Serbisyo na nagpapakita ng mga tool sa pamamagitan ng MCP na may malinaw na paglalarawan at parameter schema.

**McpToolProvider** - Komponent ng LangChain4j na bumabalot sa mga MCP tool para gamitin sa AI services at mga agent.

**McpTransport** - Interface para sa komunikasyon ng MCP. Ang mga implementasyon ay kinabibilangan ng Stdio at HTTP.

**Stdio Transport** - Lokal na proseso ng transportasyon gamit ang stdin/stdout. Kapaki-pakinabang para sa filesystem access o command-line tools.

**StdioMcpTransport** - Implementasyon ng LangChain4j na nagpapasimula ng MCP server bilang subprocess.

**Tool Discovery** - Kliyente na nagsusuri sa server para sa mga magagamit na tool kasama ang mga paglalarawan at schema.

## Azure Services - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Cloud search na may vector na kakayahan. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Nagde-deploy ng mga Azure resource.

**Azure OpenAI** - Enterprise AI service ng Microsoft.

**Bicep** - Wika para sa Azure infrastructure-as-code. [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - Pangalan para sa deployment ng modelo sa Azure.

**GPT-5.2** - Pinakabagong model ng OpenAI na may kontrol sa pag-iisip. [Module 02](../02-prompt-engineering/README.md)

## Testing and Development - [Testing Guide](TESTING.md)

**Dev Container** - Containerized na development environment. [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - Pagsubok gamit ang in-memory na imbakan.

**Integration Testing** - Pagsubok gamit ang tunay na imprastraktura.

**Maven** - Java build automation tool.

**Mockito** - Java mocking framework.

**Spring Boot** - Java application framework. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Pagtatanggi**:
Ang dokumentong ito ay isinalin gamit ang serbisyo ng AI translation na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't nagsusumikap kami para sa katumpakan, pakatandaan na ang awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa orihinal nitong wika ang dapat ituring na pangunahing sanggunian. Para sa mahahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang maling pagkakaintindi o maling interpretasyon na nagmula sa paggamit ng pagsasaling ito.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->