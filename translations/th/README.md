<img src="../../translated_images/th/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j สำหรับผู้เริ่มต้น

หลักสูตรสำหรับการสร้างแอปพลิเคชัน AI ด้วย LangChain4j และ Azure OpenAI GPT-5.2 ตั้งแต่การแชทพื้นฐานจนถึงเอเย่นต์ AI

### 🌐 รองรับหลายภาษา

#### การแปลรักษาข้อมูลด้วย [Co-op Translator](https://github.com/Azure/co-op-translator)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[อาหรับ](../ar/README.md) | [เบงกาลี](../bn/README.md) | [บัลแกเรีย](../bg/README.md) | [พม่า (เมียนมา)](../my/README.md) | [จีน (ตัวย่อ)](../zh-CN/README.md) | [จีน (ตัวเต็ม ฮ่องกง)](../zh-HK/README.md) | [จีน (ตัวเต็ม มาเก๊า)](../zh-MO/README.md) | [จีน (ตัวเต็ม ไต้หวัน)](../zh-TW/README.md) | [โครเอเชีย](../hr/README.md) | [เช็ก](../cs/README.md) | [เดนมาร์ก](../da/README.md) | [ดัตช์](../nl/README.md) | [เอสโตเนีย](../et/README.md) | [ฟินแลนด์](../fi/README.md) | [ฝรั่งเศส](../fr/README.md) | [เยอรมัน](../de/README.md) | [กรีก](../el/README.md) | [ฮีบรู](../he/README.md) | [ฮินดี](../hi/README.md) | [ฮังการี](../hu/README.md) | [อินโดนีเซีย](../id/README.md) | [อิตาเลียน](../it/README.md) | [ญี่ปุ่น](../ja/README.md) | [กันนาดา](../kn/README.md) | [เขมร](../km/README.md) | [เกาหลี](../ko/README.md) | [ลิทัวเนีย](../lt/README.md) | [มาเลย์](../ms/README.md) | [มาลายาลัม](../ml/README.md) | [มาราธี](../mr/README.md) | [เนปาล](../ne/README.md) | [นิเจเรียน พิดจิน](../pcm/README.md) | [นอร์เวย์](../no/README.md) | [เปอร์เซีย (ฟาร์ซี)](../fa/README.md) | [โปแลนด์](../pl/README.md) | [โปรตุเกส (บราซิล)](../pt-BR/README.md) | [โปรตุเกส (โปรตุเกส)](../pt-PT/README.md) | [ปัญจาบี (กุรมุขี)](../pa/README.md) | [โรมาเนีย](../ro/README.md) | [รัสเซีย](../ru/README.md) | [เซอร์เบียน (ซีริลลิก)](../sr/README.md) | [สโลวัก](../sk/README.md) | [สโลวีเนีย](../sl/README.md) | [สเปน](../es/README.md) | [สวาฮิลี](../sw/README.md) | [สวีเดน](../sv/README.md) | [ตากาล็อก (ฟิลิปปินส์)](../tl/README.md) | [ทมิฬ](../ta/README.md) | [เทลูกู](../te/README.md) | [ไทย](./README.md) | [เติร์ก](../tr/README.md) | [ยูเครน](../uk/README.md) | [อูรดู](../ur/README.md) | [เวียดนาม](../vi/README.md)

> **ต้องการโคลนในเครื่องแทนไหม?**
>
> ที่เก็บนี้มีการแปลกว่า 50 ภาษา ซึ่งทำให้ขนาดการดาวน์โหลดเพิ่มขึ้นมาก หากต้องการโคลนโดยไม่มีการแปล ให้ใช้การเช็คเอาท์แบบสเปรส:
>
> **Bash / macOS / Linux:**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/LangChain4j-for-Beginners.git
> cd LangChain4j-for-Beginners
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **CMD (Windows):**
> ```cmd
> git clone --filter=blob:none --sparse https://github.com/microsoft/LangChain4j-for-Beginners.git
> cd LangChain4j-for-Beginners
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
>
> วิธีนี้จะให้ทุกอย่างที่คุณต้องการเพื่อทำหลักสูตรให้เสร็จด้วยการดาวน์โหลดที่เร็วขึ้นมาก
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## สารบัญ

1. [บทนำ](01-introduction/README.md) - เรียนรู้พื้นฐานของ LangChain4j
2. [การออกแบบคำสั่ง](02-prompt-engineering/README.md) - ฝึกออกแบบคำสั่งอย่างมีประสิทธิภาพ
3. [RAG (การสร้างข้อมูลเสริมด้วยการดึงข้อมูล)](03-rag/README.md) - สร้างระบบข้อมูลความรู้ที่ชาญฉลาด
4. [เครื่องมือ](04-tools/README.md) - การรวมเครื่องมือภายนอกและผู้ช่วยง่ายๆ
5. [MCP (โพรโตคอลบริบทของโมเดล)](05-mcp/README.md) - ทำงานกับโพรโตคอลบริบทของโมเดล (MCP) และโมดูล Agentic

### วิดีโอนำทาง

แต่ละโมดูลมีเซสชันสดควบคู่ที่เราจะอธิบายแนวคิดและโค้ดทีละขั้นตอน

| โมดูล | วิดีโอ |
|--------|-------|
| 01 - บทนำ | [เริ่มต้นกับ LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - การออกแบบคำสั่ง | [การออกแบบคำสั่งด้วย LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG กับ LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - เครื่องมือ & 05 - MCP | [เอเย่นต์ AI กับเครื่องมือและ MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## เส้นทางการเรียนรู้

**ใหม่กับ LangChain4j?** ดู [ศัพท์เฉพาะ](docs/GLOSSARY.md) สำหรับคำจำกัดความของคำสำคัญและแนวคิดต่างๆ

> **เริ่มต้นอย่างรวดเร็ว**

1. Fork ที่เก็บนี้ไปยังบัญชี GitHub ของคุณ
2. คลิก **Code** → แท็บ **Codespaces** → **...** → **New with options...**
3. ใช้ค่าตั้งต้น – ซึ่งจะเลือก Development container ที่สร้างขึ้นสำหรับหลักสูตรนี้
4. คลิก **Create codespace**
5. รอ 5-10 นาทีเพื่อเตรียมสภาพแวดล้อมให้พร้อม
6. ไปที่ [บทนำ](./01-introduction/README.md) เพื่อเริ่มต้น!

หลังจากทำโมดูลเสร็จแล้ว สำรวจ [คู่มือการทดสอบ](docs/TESTING.md) เพื่อดูแนวคิดการทดสอบ LangChain4j ในการใช้งานจริง

> **หมายเหตุ:** การฝึกอบรมนี้ใช้ Azure OpenAI เริ่มต้นด้วย [บัญชี Azure ฟรี](https://aka.ms/azure-free-account) หากคุณยังไม่มี


## เรียนรู้ด้วย GitHub Copilot

เพื่อเริ่มเขียนโค้ดอย่างรวดเร็ว เปิดโปรเจกต์นี้ใน GitHub Codespace หรือ IDE ท้องถิ่นของคุณด้วย devcontainer ที่จัดเตรียมไว้ Devcontainer ที่ใช้ในหลักสูตรนี้ตั้งค่าไว้ล่วงหน้าพร้อมกับ GitHub Copilot สำหรับการเขียนโปรแกรมคู่ AI

ตัวอย่างโค้ดแต่ละชิ้นมีคำถามแนะนำที่คุณสามารถถาม GitHub Copilot เพื่อเพิ่มพูนความเข้าใจ มองหาสัญลักษณ์ 💡/🤖 ใน:

- **ส่วนหัวไฟล์ Java** - คำถามเฉพาะสำหรับแต่ละตัวอย่าง
- **ไฟล์ README ของโมดูล** - คำกระตุ้นการสำรวจหลังตัวอย่างโค้ด

**วิธีใช้:** เปิดไฟล์โค้ดใด ๆ และถาม Copilot ด้วยคำถามที่แนะนำ มันมีบริบทเต็มของฐานโค้ดและสามารถอธิบาย ขยาย และเสนอทางเลือกได้

ต้องการเรียนรู้เพิ่มเติมไหม? ลองดูที่ [Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI).


## แหล่งข้อมูลเพิ่มเติม

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ชุดเรียน Generative AI
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### การเรียนรู้หลัก
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ชุดเรียน Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## การขอความช่วยเหลือ

หากคุณติดขัดหรือต้องการคำถามเกี่ยวกับการสร้างแอป AI เข้าร่วมได้ที่:

[![Microsoft Foundry Discord](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

หากคุณมีความคิดเห็นเกี่ยวกับผลิตภัณฑ์หรือพบข้อผิดพลาดขณะสร้าง โปรดเยี่ยมชม:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## ใบอนุญาต

ใบอนุญาต MIT - ดูไฟล์ [LICENSE](../../LICENSE) สำหรับรายละเอียดเพิ่มเติม

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ปฏิเสธความรับผิดชอบ**:
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) ขณะที่เราพยายามให้ความถูกต้อง โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาต้นทางควรถูกพิจารณาเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ แนะนำให้ใช้การแปลโดยมนุษย์มืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดที่เกิดขึ้นจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->