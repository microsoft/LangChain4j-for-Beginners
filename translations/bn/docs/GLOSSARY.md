# LangChain4j শব্দকোষ

## সূচিপত্র

- [কোর ধারণা](#কোর-ধারণা)
- [LangChain4j উপাদানসমূহ](#langchain4j-উপাদানসমূহ)
- [AI/ML ধারণা](#aiml-ধারণা)
- [গার্ডরেলস](#গার্ডরেলস)
- [প্রম্পট ইঞ্জিনিয়ারিং](#prompt-engineering---module-02)
- [RAG (রিট্রিভাল-অগমেন্টেড জেনারেশন)](#rag-retrieval-augmented-generation---module-03)
- [এজেন্ট এবং সরঞ্জামসমূহ](#agents-and-tools---module-04)
- [এজেন্টিক মডিউল](#agentic-module---module-05)
- [মডেল কনটেক্সট প্রোটোকল (MCP)](#model-context-protocol-mcp---module-05)
- [আজুর সেবা](#azure-services---module-01)
- [পরীক্ষা ও উন্নয়ন](#testing-and-development---testing-guide)

কোর্স জুড়ে ব্যবহৃত শব্দ এবং ধারণাগুলির দ্রুত রেফারেন্স।

## কোর ধারণা

**AI Agent** - এমন সিস্টেম যা AI ব্যবহার করে যুক্তি করে এবং স্বায়ত্তশাসিতভাবে কাজ করে। [Module 04](../04-tools/README.md)

**Chain** - অপারেশনগুলোর ক্রম যেখানে আউটপুট পরবর্তী ধাপে ইনপুট হিসাবে ব্যবহৃত হয়।

**Chunking** - ডকুমেন্টগুলোকে ছোট ছোট অংশে ভাগ করা। সাধারণত: ৩০০-৫০০ টোকেন ওভারল্যাপের সাথে। [Module 03](../03-rag/README.md)

**Context Window** - সর্বাধিক টোকেন যা একটি মডেল প্রসেস করতে পারে। GPT-5.2: ৪০০কে টোকেন (২৭২কে ইনপুট পর্যন্ত, ১২৮কে আউটপুট)।

**Embeddings** - টেক্সটের অর্থ প্রকাশকারী সংখ্যাসূচক ভেক্টর। [Module 03](../03-rag/README.md)

**Function Calling** - মডেল কাঠামোবদ্ধ অনুরোধ তৈরি করে বাহ্যিক ফাংশন কল করার জন্য। [Module 04](../04-tools/README.md)

**Hallucination** - মডেলগুলি যখন ভুল কিন্তু বিশ্বাসযোগ্য তথ্য তৈরি করে।

**Prompt** - ভাষা মডেলের ইনপুট টেক্সট। [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - অর্থ অনুযায়ী অনুসন্ধান যা কীওয়ার্ড নয়, এমবেডিং ব্যবহার করে। [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: কোনো মেমোরি নেই। Stateful: কথোপকথনের ইতিহাস সংরক্ষণ করে। [Module 01](../01-introduction/README.md)

**Tokens** - মডেলগুলো যেসব মৌলিক টেক্সট ইউনিট প্রক্রিয়া করে। খরচ এবং সীমাতে প্রভাব ফেলে। [Module 01](../01-introduction/README.md)

**Tool Chaining** - ধারাবাহিক সরঞ্জাম কার্যক্রম যেখানে আউটপুট পরবর্তী কলের তথ্য দেয়। [Module 04](../04-tools/README.md)

## LangChain4j উপাদানসমূহ

**AiServices** - টাইপ-সেফ AI সেবা ইন্টারফেস তৈরি করে।

**OpenAiOfficialChatModel** - OpenAI এবং Azure OpenAI মডেলগুলোর জন্য একীকৃত ক্লায়েন্ট।

**OpenAiOfficialEmbeddingModel** - OpenAI অফিসিয়াল ক্লায়েন্ট ব্যবহার করে এমবেডিং তৈরি করে (OpenAI এবং Azure OpenAI উভয় সমর্থিত)।

**ChatModel** - ভাষা মডেলগুলোর জন্য মূল ইন্টারফেস।

**ChatMemory** - কথোপকথনের ইতিহাস সংরক্ষণ করে।

**ContentRetriever** - RAG এর জন্য প্রাসঙ্গিক ডকুমেন্ট চাঙ্ক খুঁজে বের করে।

**DocumentSplitter** - ডকুমেন্টগুলোকে চাঙ্কে ভাগ করে।

**EmbeddingModel** - টেক্সটকে সংখ্যাসূচক ভেক্টরে রূপান্তর করে।

**EmbeddingStore** - এমবেডিং সংরক্ষণ ও পুনরুদ্ধার করে।

**MessageWindowChatMemory** - সাম্প্রতিক বার্তাগুলোর স্লাইডিং উইন্ডো বজায় রাখে।

**PromptTemplate** - `{{variable}}` প্লেসহোল্ডারসহ পুনরায় ব্যবহারযোগ্য প্রম্পট তৈরি করে।

**TextSegment** - মেটাডেটাসহ টেক্সট অংশ। RAG এ ব্যবহৃত।

**ToolExecutionRequest** - সরঞ্জাম কার্যকলাপের অনুরোধ উপস্থাপন করে।

**UserMessage / AiMessage / SystemMessage** - কথোপকথনের বার্তার ধরন।

## AI/ML ধারণা

**Few-Shot Learning** - প্রম্পটে উদাহরণ দেয়া। [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - বিশাল টেক্সট ডেটাতে প্রশিক্ষিত AI মডেল।

**Reasoning Effort** - GPT-5.2 প্যারামিটার যা চিন্তার গভীরতা নিয়ন্ত্রণ করে। [Module 02](../02-prompt-engineering/README.md)

**Temperature** - আউটপুটের র‍্যান্ডমনেস নিয়ন্ত্রণ করে। কম=নির্ধারিত, বেশি=সৃষ্টিশীল।

**Vector Database** - এমবেডিংয়ের জন্য বিশেষায়িত ডেটাবেজ। [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - উদাহরণ ছাড়াই কাজ করা। [Module 02](../02-prompt-engineering/README.md)

## গার্ডরেলস

**Defense in Depth** - মাল্টি-লেয়ার সিকিউরিটি অ্যাপ্রোচ যা অ্যাপ্লিকেশন-স্তরের গার্ডরেলস ও প্রোভাইডার সুরক্ষা ফিল্টার মিলায়।

**Hard Block** - গুরুতর কনটেন্ট লঙ্ঘনের জন্য প্রোভাইডার HTTP 400 ত্রুটি ফেলে।

**InputGuardrail** - LangChain4j ইন্টারফেস যা ব্যবহারকারীর ইনপুট যাচাই করে LLM পৌঁছানোর আগে। ক্ষতিকারক প্রম্পট অগ্রিম বন্ধ করে খরচ ও বিলম্ব বাঁচায়।

**InputGuardrailResult** - গার্ডরেল যাচাইয়ের রিটার্ন টাইপ: `success()` অথবা `fatal("reason")`।

**OutputGuardrail** - AI উত্তর যাচাই করে ব্যবহারকারীর কাছে ফেরত দেওয়ার আগে।

**Provider Safety Filters** - AI প্রোভাইডার (যেমন Azure OpenAI) থেকে বিল্ট-ইন কনটেন্ট ফিল্টার যা API স্তরে লঙ্ঘন আটকায়।

**Soft Refusal** - মডেল বিনীতভাবে উত্তর দিতে অস্বীকার করে ত্রুটি ছাড়াই।

## প্রম্পট ইঞ্জিনিয়ারিং - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - ধাপে ধাপে যুক্তি যা সঠিকতা বাড়ায়।

**Constrained Output** - নির্দিষ্ট ফরম্যাট বা কাঠামো বলবৎ রাখা।

**High Eagerness** - GPT-5.2 প্যাটার্ন যা গভীর যুক্তি তৈরি করে।

**Low Eagerness** - GPT-5.2 প্যাটার্ন যা দ্রুত উত্তর দেয়।

**Multi-Turn Conversation** - কথোপকথনের প্রসঙ্গ রক্ষা।

**Role-Based Prompting** - সিস্টেম মেসেজের মাধ্যমে মডেল ব্যক্তিত্ব সেট করা।

**Self-Reflection** - মডেল নিজের আউটপুট মূল্যায়ন ও উন্নতি করে।

**Structured Analysis** - নির্দিষ্ট মূল্যায়ন কাঠামো।

**Task Execution Pattern** - পরিকল্পনা → সম্পাদন → সারসংক্ষেপ।

## RAG (রিট্রিভাল-অগমেন্টেড জেনারেশন) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - লোড → চাঙ্ক → এমবেড → সংরক্ষণ।

**In-Memory Embedding Store** - পরীক্ষার জন্য অস্থায়ী স্টোরেজ।

**RAG** - রিট্রিভাল ও জেনারেশন একত্রে ব্যবহার করে উত্তর ভিত্তি গড়ে তোলে।

**Similarity Score** - সেমান্টিক সাদৃশ্যের পরিমাপ (০-১)।

**Source Reference** - পুনরুদ্ধারকৃত বিষয়বস্তুর মেটাডেটা।

## এজেন্ট এবং সরঞ্জামসমূহ - [Module 04](../04-tools/README.md)

**@Tool Annotation** - Java মেথডকে AI-কলে সক্ষম সরঞ্জাম হিসেবে চিহ্নিত করে।

**ReAct Pattern** - যুক্তি → কর্ম → পর্যবেক্ষণ → পুনরাবৃত্তি।

**Session Management** - বিভিন্ন ব্যবহারকারীর জন্য পৃথক প্রসঙ্গ।

**Tool** - একটি ফাংশন যা AI এজেন্ট কল করতে পারে।

**Tool Description** - সরঞ্জামের উদ্দেশ্য ও প্যারামিটারসমূহের দলিল।

## এজেন্টিক মডিউল - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - AI এজেন্ট হিসাবে ইন্টারফেস চিহ্নিত করে ডিক্লারেটিভ বিহেভিয়ার সংজ্ঞা সহ।

**Agent Listener** - এজেন্ট কার্যক্রম পর্যবেক্ষণের জন্য হুক `beforeAgentInvocation()` এবং `afterAgentInvocation()` এর মাধ্যমে।

**Agentic Scope** - শেয়ার করা মেমোরি যেখানে এজেন্টগণ আউটপুট সংরক্ষণ করে `outputKey` ব্যবহার করে পরবর্তী এজেন্টদের জন্য।

**AgenticServices** - `agentBuilder()` এবং `supervisorBuilder()` ব্যবহার করে এজেন্ট তৈরি করার ফ্যাক্টরি।

**Conditional Workflow** - শর্ত অনুযায়ী আলাদা বিশেষজ্ঞ এজেন্টদের মধ্যে রুট নির্ধারণ।

**Human-in-the-Loop** - মানব যাচাইকরণ বা বিষয়বস্তু পর্যালোচনার জন্য চেকপয়েন্টসহ ওয়ার্কফ্লো প্যাটার্ন।

**langchain4j-agentic** - ডিক্লারেটিভ এজেন্ট বিল্ডিংয়ের জন্য মেভেন ডিপেন্ডেন্সি (প্রায়োগিক)।

**Loop Workflow** - একটি শর্ত পূরণ না হওয়া পর্যন্ত এজেন্ট কার্যক্রম পুনরাবৃত্তি করা (যেমন গুণমান স্কোর ≥ 0.৮)।

**outputKey** - এজেন্ট নোটেশন প্যারামিটার যা Agentic Scope-এ ফলাফল সংরক্ষণের জায়গা নির্ধারণ করে।

**Parallel Workflow** - স্বাধীন কাজের জন্য একাধিক এজেন্ট একসাথে চালানো।

**Response Strategy** - সুপারভাইজার কিভাবে চূড়ান্ত উত্তর গঠন করে: LAST, SUMMARY, অথবা SCORED।

**Sequential Workflow** - এজেন্টগুলোকে ক্রম অনুসারে চালানো যেখানে আউটপুট পরবর্তী ধাপে প্রবাহিত হয়।

**Supervisor Agent Pattern** - উন্নত এজেন্টিক প্যাটার্ন যেখানে সুপারভাইজার LLM চলবে কোন সাব-এজেন্ট কল করবে তা গতিশীলভাবে নির্ধারণ করে।

## মডেল কনটেক্সট প্রোটোকল (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j-এ MCP ইন্টিগ্রেশনের জন্য মেভেন ডিপেন্ডেন্সি।

**MCP** - Model Context Protocol: AI অ্যাপসকে বাহ্যিক সরঞ্জামের সাথে সংযুক্ত করার স্ট্যান্ডার্ড। একবার তৈরি করুন, সর্বত্র ব্যবহার করুন।

**MCP Client** - MCP সার্ভারে সংযোগ স্থাপন করে সরঞ্জাম আবিষ্কার ও ব্যবহার করে এমন অ্যাপ্লিকেশন।

**MCP Server** - MCP ব্যবহার করে স্পষ্ট বর্ণনা ও প্যারামিটার স্কিমাসহ সরঞ্জাম এক্সপোজ করে এমন সেবা।

**McpToolProvider** - LangChain4j উপাদান যা MCP সরঞ্জামগুলোকে AI সেবা ও এজেন্টে ব্যবহারের জন্য র‍্যাপ করে।

**McpTransport** - MCP যোগাযোগের ইন্টারফেস। বাস্তবায়নের মধ্যে রয়েছে Stdio ও HTTP।

**Stdio Transport** - স্থানীয় প্রসেস পরিবহন stdin/stdout মাধ্যমে। ফাইল সিস্টেম অ্যাক্সেস বা কমান্ড-লাইন সরঞ্জামের জন্য কার্যকর।

**StdioMcpTransport** - LangChain4j বাস্তবায়ন যা সাবপ্রসেস হিসেবে MCP সার্ভার চালায়।

**Tool Discovery** - ক্লায়েন্ট সার্ভারকে প্রশ্ন করে উপলব্ধ সরঞ্জামের বিবরণ ও স্কিমাস নেয়।

## আজুর সেবা - [Module 01](../01-introduction/README.md)

**Azure AI Search** - ভেক্টর সক্ষমতা সহ ক্লাউড অনুসন্ধান। [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - আজুর রিসোর্স ডিপ্লয় করে।

**Azure OpenAI** - মাইক্রোসফটের এন্টারপ্রাইজ AI সেবা।

**Bicep** - আজুর ইনফ্রাস্ট্রাকচার-অ্যাজ-কোড ভাষা। [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - আজুরে মডেল ডিপ্লয়মেন্টের নাম।

**GPT-5.2** - reasoning নিয়ন্ত্রণযোগ্য সর্বশেষ OpenAI মডেল। [Module 02](../02-prompt-engineering/README.md)

## পরীক্ষা ও উন্নয়ন - [Testing Guide](TESTING.md)

**Dev Container** - কন্টেইনার ভিত্তিক উন্নয়ন পরিবেশ। [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - মেমোরি-ভিত্তিক স্টোরেজে পরীক্ষা।

**Integration Testing** - বাস্তব অবকাঠামোর সাথে পরীক্ষা।

**Maven** - Java বিল্ড অটোমেশন টুল।

**Mockito** - Java মকিং ফ্রেমওয়ার্ক।

**Spring Boot** - Java অ্যাপ্লিকেশন ফ্রেমওয়ার্ক। [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**অস্বীকৃতি**:
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনূদিত হয়েছে। যদিও আমরা শুদ্ধতার জন্য চেষ্টা করি, অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল নথিটি তার স্বভাষায় কর্তৃত্বপূর্ণ উৎস হিসেবে বিবেচিত হওয়া উচিত। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদের ব্যবহারে প্রয়োজনীয় ভুল বোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়বদ্ধ নই।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->