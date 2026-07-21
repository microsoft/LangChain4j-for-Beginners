# LangChain4j พจนานุกรมศัพท์

## สารบัญ

- [แนวคิดหลัก](#แนวคิดหลัก)
- [ส่วนประกอบของ LangChain4j](#ส่วนประกอบของ-langchain4j)
- [แนวคิด AI/ML](#แนวคิด-aiml)
- [มาตรการความปลอดภัย](#มาตรการความปลอดภัย)
- [วิศวกรรมการใช้พรอมต์](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [เอเย่นต์และเครื่องมือ](#agents-and-tools---module-04)
- [โมดูล Agentic](#agentic-module---module-05)
- [โปรโตคอลบริบทของโมเดล (MCP)](#model-context-protocol-mcp---module-05)
- [บริการ Azure](#azure-services---module-01)
- [การทดสอบและการพัฒนา](#testing-and-development---testing-guide)

อ้างอิงด่วนสำหรับคำและแนวคิดที่ใช้ตลอดหลักสูตร

## แนวคิดหลัก

**AI Agent** - ระบบที่ใช้ AI เพื่อให้เหตุผลและดำเนินการโดยอัตโนมัติ [Module 04](../04-tools/README.md)

**Chain** - ลำดับของการดำเนินการซึ่งผลลัพธ์เป็นข้อมูลเข้าสู่ขั้นตอนต่อไป

**Chunking** - การแบ่งเอกสารออกเป็นชิ้นเล็ก ๆ โดยทั่วไป: 300-500 โทเคนพร้อมการทับซ้อน [Module 03](../03-rag/README.md)

**Context Window** - จำนวนโทเคนสูงสุดที่โมเดลสามารถประมวลผลได้ GPT-5.2: 400K โทเคน (สูงสุด 272K อินพุต, 128K เอาต์พุต)

**Embeddings** - เวกเตอร์ตัวเลขที่แทนความหมายของข้อความ [Module 03](../03-rag/README.md)

**Function Calling** - โมเดลสร้างคำขอที่มีโครงสร้างเพื่อเรียกใช้ฟังก์ชันภายนอก [Module 04](../04-tools/README.md)

**Hallucination** - เมื่อโมเดลสร้างข้อมูลที่ไม่ถูกต้องแต่มีความน่าเชื่อถือ

**Prompt** - ข้อความป้อนเข้าให้โมเดลภาษา [Module 02](../02-prompt-engineering/README.md)

**Semantic Search** - การค้นหาตามความหมายโดยใช้ embeddings ไม่ใช่คำค้น [Module 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: ไม่มีหน่วยความจำ Stateful: เก็บประวัติการสนทนา [Module 01](../01-introduction/README.md)

**Tokens** - หน่วยข้อความพื้นฐานที่โมเดลประมวลผล ส่งผลต่อค่าใช้จ่ายและข้อจำกัด [Module 01](../01-introduction/README.md)

**Tool Chaining** - การใช้เครื่องมือแบบต่อเนื่อง โดยข้อมูลออกแจ้งการเรียกครั้งถัดไป [Module 04](../04-tools/README.md)

## ส่วนประกอบของ LangChain4j

**AiServices** - สร้างอินเทอร์เฟซบริการ AI ที่ปลอดภัยตามประเภท

**OpenAiOfficialChatModel** - ลูกค้ารวมสำหรับโมเดล OpenAI และ Azure OpenAI

**OpenAiOfficialEmbeddingModel** - สร้าง embeddings โดยใช้ไคลเอนต์ OpenAI Official (รองรับทั้ง OpenAI และ Azure OpenAI)

**ChatModel** - อินเทอร์เฟซหลักสำหรับโมเดลภาษา

**ChatMemory** - เก็บประวัติการสนทนา

**ContentRetriever** - ค้นหาชิ้นเอกสารที่เกี่ยวข้องสำหรับ RAG

**DocumentSplitter** - แบ่งเอกสารเป็นชิ้น

**EmbeddingModel** - แปลงข้อความเป็นเวกเตอร์ตัวเลข

**EmbeddingStore** - เก็บและดึง embeddings

**MessageWindowChatMemory** - เก็บหน้าต่างข้อความเลื่อนสำหรับข้อความล่าสุด

**PromptTemplate** - สร้างพรอมต์ที่ใช้ซ้ำได้ด้วยตัวแปร `{{variable}}`

**TextSegment** - ชิ้นข้อความพร้อมเมตาดาต้า ใช้ใน RAG

**ToolExecutionRequest** - ตัวแทนคำขอการใช้เครื่องมือ

**UserMessage / AiMessage / SystemMessage** - ประเภทข้อความสนทนา

## แนวคิด AI/ML

**Few-Shot Learning** - การให้ตัวอย่างในพรอมต์ [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - โมเดล AI ที่ฝึกด้วยข้อมูลข้อความจำนวนมาก

**Reasoning Effort** - พารามิเตอร์ GPT-5.2 ที่ควบคุมความลึกของการให้เหตุผล [Module 02](../02-prompt-engineering/README.md)

**Temperature** - ควบคุมความสุ่มของผลลัพธ์ ต่ำ=แน่นอน สูง=สร้างสรรค์

**Vector Database** - ฐานข้อมูลเฉพาะสำหรับ embeddings [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - การปฏิบัติงานโดยไม่มีตัวอย่าง [Module 02](../02-prompt-engineering/README.md)

## มาตรการความปลอดภัย

**Defense in Depth** - แนวทางการรักษาความปลอดภัยหลายชั้นรวมมาตรการระดับแอปกับฟิลเตอร์ความปลอดภัยของผู้ให้บริการ

**Hard Block** - ผู้ให้บริการส่งข้อผิดพลาด HTTP 400 เมื่อพบเนื้อหาละเมิดรุนแรง

**InputGuardrail** - อินเทอร์เฟซ LangChain4j สำหรับตรวจสอบข้อมูลป้อนเข้าของผู้ใช้ก่อนเข้าถึง LLM ช่วยประหยัดค่าใช้จ่ายและลดความล่าช้าโดยบล็อกพรอมต์ที่เป็นอันตรายตั้งแต่ต้น

**InputGuardrailResult** - ประเภทค่าที่ส่งกลับการตรวจสอบ guardrail: `success()` หรือ `fatal("reason")`

**OutputGuardrail** - อินเทอร์เฟซสำหรับตรวจสอบคำตอบ AI ก่อนส่งกลับผู้ใช้

**Provider Safety Filters** - ฟิลเตอร์เนื้อหาที่ฝังอยู่จากผู้ให้บริการ AI (เช่น Azure OpenAI) ที่จับการละเมิดในระดับ API

**Soft Refusal** - โมเดลปฏิเสธอย่างสุภาพโดยไม่ส่งข้อผิดพลาด

## วิศวกรรมการใช้พรอมต์ - [Module 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - การให้เหตุผลทีละขั้นตอนเพื่อความแม่นยำยิ่งขึ้น

**Constrained Output** - บังคับใช้รูปแบบหรือโครงสร้างเฉพาะ

**High Eagerness** - รูปแบบ GPT-5.2 สำหรับการให้เหตุผลเชิงลึก

**Low Eagerness** - รูปแบบ GPT-5.2 สำหรับคำตอบรวดเร็ว

**Multi-Turn Conversation** - รักษาบริบทตลอดการสนทนา

**Role-Based Prompting** - กำหนดบุคลิกโมเดลผ่านข้อความระบบ

**Self-Reflection** - โมเดลประเมินและปรับปรุงผลลัพธ์ของตนเอง

**Structured Analysis** - กรอบการประเมินที่กำหนดไว้ล่วงหน้า

**Task Execution Pattern** - วางแผน → ดำเนินการ → สรุป

## RAG (Retrieval-Augmented Generation) - [Module 03](../03-rag/README.md)

**Document Processing Pipeline** - โหลด → แบ่งชิ้น → ฝัง → เก็บ

**In-Memory Embedding Store** - ที่เก็บชั่วคราวสำหรับการทดสอบ

**RAG** - รวมการค้นคืนข้อมูลกับการสร้างข้อความเพื่อให้คำตอบมีฐานข้อมูล

**Similarity Score** - มาตรวัดความเหมือนเชิงความหมาย (0-1)

**Source Reference** - เมตาดาต้าเกี่ยวกับเนื้อหาที่ค้นคืน

## เอเย่นต์และเครื่องมือ - [Module 04](../04-tools/README.md)

**@Tool Annotation** - ใช้ทำเครื่องหมายเมธอด Java ให้เป็นเครื่องมือเรียกใช้โดย AI

**ReAct Pattern** - ให้เหตุผล → ดำเนินการ → สังเกต → ทำซ้ำ

**Session Management** - แยกบริบทสำหรับผู้ใช้แต่ละคน

**Tool** - ฟังก์ชันที่เอเย่นต์ AI สามารถเรียกใช้ได้

**Tool Description** - เอกสารอธิบายวัตถุประสงค์และพารามิเตอร์ของเครื่องมือ

## โมดูล Agentic - [Module 05](../05-mcp/README.md)

**@Agent Annotation** - ใช้ทำเครื่องหมายอินเทอร์เฟซเป็นเอเย่นต์ AI พร้อมนิยามพฤติกรรมแบบประกาศ

**Agent Listener** - ตัวเชื่อมสำหรับติดตามการทำงานของเอเย่นต์ผ่าน `beforeAgentInvocation()` และ `afterAgentInvocation()`

**Agentic Scope** - หน่วยความจำร่วมที่เอเย่นต์เก็บผลลัพธ์โดยใช้ `outputKey` เพื่อให้เอเย่นต์ถัดไปใช้งาน

**AgenticServices** - แฟคทอรี่สร้างเอเย่นต์ผ่าน `agentBuilder()` และ `supervisorBuilder()`

**Conditional Workflow** - เส้นทางทำงานตามเงื่อนไขไปยังเอเย่นต์ผู้เชี่ยวชาญต่าง ๆ

**Human-in-the-Loop** - รูปแบบเวิร์กโฟลว์ที่เพิ่มจุดตรวจสอบจากมนุษย์เพื่ออนุมัติหรือทบทวนเนื้อหา

**langchain4j-agentic** - ขึ้นตอน Maven สำหรับสร้างเอเย่นต์แบบประกาศ (ทดลอง)

**Loop Workflow** - ทำซ้ำการทำงานของเอเย่นต์จนกว่าจะถึงเงื่อนไข (เช่น คะแนนคุณภาพ ≥ 0.8)

**outputKey** - พารามิเตอร์ของ annotation เอเย่นต์ระบุที่เก็บผลลัพธ์ใน Agentic Scope

**Parallel Workflow** - รันเอเย่นต์หลายตัวพร้อมกันสำหรับงานอิสระ

**Response Strategy** - วิธีที่ซูเปอร์ไวเซอร์สรุปคำตอบสุดท้าย: LAST, SUMMARY, หรือ SCORED

**Sequential Workflow** - ดำเนินการเอเย่นต์ตามลำดับโดยผลลัพธ์เป็นข้อมูลเข้าสู่ขั้นตอนถัดไป

**Supervisor Agent Pattern** - รูปแบบเอเย่นต์ขั้นสูงที่ซูเปอร์ไวเซอร์ LLM ตัดสินใจเรียกใช้ซับเอเย่นต์แบบไดนามิก

## โปรโตคอลบริบทของโมเดล (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - ขึ้นตอน Maven สำหรับการรวม MCP ใน LangChain4j

**MCP** - Model Context Protocol: มาตรฐานเชื่อมต่อแอป AI กับเครื่องมือภายนอก สร้างครั้งเดียว ใช้ทุกที่

**MCP Client** - แอปที่เชื่อมต่อกับเซิร์ฟเวอร์ MCP เพื่อค้นหาและใช้เครื่องมือ

**MCP Server** - บริการที่เปิดเผยเครื่องมือผ่าน MCP พร้อมคำอธิบายและสคีมาพารามิเตอร์ชัดเจน

**McpToolProvider** - ส่วนประกอบ LangChain4j ที่ห่อหุ้มเครื่องมือ MCP เพื่อใช้ในบริการ AI และเอเย่นต์

**McpTransport** - อินเทอร์เฟซสำหรับการสื่อสาร MCP การใช้งานรวม Stdio และ HTTP

**Stdio Transport** - การส่งข้อมูลภายในกระบวนการผ่าน stdin/stdout เหมาะสำหรับการเข้าถึงระบบไฟล์หรือเครื่องมือบรรทัดคำสั่ง

**StdioMcpTransport** - การใช้งาน LangChain4j ที่รันเซิร์ฟเวอร์ MCP เป็น subprocess

**Tool Discovery** - ลูกค้าสอบถามเซิร์ฟเวอร์หาเครื่องมือที่มีด้วยคำอธิบายและสคีมา

## บริการ Azure - [Module 01](../01-introduction/README.md)

**Azure AI Search** - บริการค้นหาในระบบคลาวด์พร้อมความสามารถเวกเตอร์ [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - เครื่องมือสำหรับปรับใช้ทรัพยากร Azure

**Azure OpenAI** - บริการ AI สำหรับองค์กรของ Microsoft

**Bicep** - ภาษา infrastructure-as-code สำหรับ Azure [Infrastructure Guide](../01-introduction/infra/README.md)

**Deployment Name** - ชื่อสำหรับการปรับใช้โมเดลใน Azure

**GPT-5.2** - โมเดล OpenAI ล่าสุดที่ควบคุมการให้เหตุผลได้ [Module 02](../02-prompt-engineering/README.md)

## การทดสอบและการพัฒนา - [Testing Guide](TESTING.md)

**Dev Container** - สภาพแวดล้อมพัฒนาซอฟต์แวร์ในคอนเทนเนอร์ [Configuration](../../../.devcontainer/devcontainer.json)

**In-Memory Testing** - การทดสอบด้วยที่เก็บข้อมูลในหน่วยความจำ

**Integration Testing** - การทดสอบกับโครงสร้างพื้นฐานจริง

**Maven** - เครื่องมืออัตโนมัติสำหรับการสร้างแอป Java

**Mockito** - เฟรมเวิร์กสำหรับการจำลองใน Java

**Spring Boot** - เฟรมเวิร์กแอปพลิเคชัน Java [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ปฏิเสธความรับผิดชอบ**:
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) ขณะที่เราพยายามให้ความถูกต้อง โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาต้นทางควรถูกพิจารณาเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ แนะนำให้ใช้การแปลโดยมนุษย์มืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดที่เกิดขึ้นจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->