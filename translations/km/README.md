<img src="../../translated_images/km/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j សម្រាប់អ្នកមិនទាន់មានបទពិសោធន៍

មេរៀនសម្រាប់សង់កម្មវិធី AI ជាមួយ LangChain4j និង Azure OpenAI GPT-5.2, ចាប់ពីការជជែកបឋមដល់ភ្នាក់ងារប្រភេទ AI។

### 🌐 ការគាំទ្រភាសាច្រើន

#### បកប្រែបានរក្សាទុកជាមួយ [Co-op Translator](https://github.com/Azure/co-op-translator)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Khmer](./README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **ចូលចិត្តផ្ទុកក្នុងម៉ាស៊ីនផ្ទាល់ភ្លាមៗ?**
>
> ឃ្លាំងទិន្នន័យនេះរួមបញ្ចូលការបកប្រែភាសា ៥០+ ដែលបង្កើនទំហំឯកសារទៅយ៉ាងខ្លាំង។ ដើម្បីផ្ទុកដោយគ្មានការបកប្រែ សូមប្រើ sparse checkout:
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
> វានឹងផ្តល់អ្វីដែលអ្នកត្រូវការទាំងអស់សម្រាប់បញ្ចប់វគ្គនេះដោយទាញយកបានលឿនជាងមុន។
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## តារាងមាតិកា

1. [ការណែនាំ](01-introduction/README.md) - រៀនដែលមូលដ្ឋាននៃ LangChain4j
2. [វិស្វករដាក់បញ្ចូល](02-prompt-engineering/README.md) - ចេះបង្កើតបញ្ចូលមានប្រសិទ្ធភាព
3. [RAG (ការបង្កើតជំនួយដោយSide Information)](03-rag/README.md) - សង់ប្រព័ន្ធច្បាស់លាស់ផ្អែកលើចំណេះដឹង
4. [ឧបករណ៍](04-tools/README.md) - បញ្ចូលឧបករណ៍ខាងក្រៅ និងជំនួយកំណត់សាមញ្ញ
5. [MCP (Model Context Protocol)](05-mcp/README.md) - ដំណើរការជាមួយ Model Context Protocol (MCP) និងម៉ូឌុល Agentic

### វីដេអូមើលផ្លូវ

ម្ចាស់ផ្នែកនីមួយៗមានវេនផ្ទាល់ខ្លួនដែលយើងនឹងដើរឆ្ពោះតាមយុទ្ធសាស្ត្រ និងកូដជាជំហានជាជំហាន។

| ផ្នែក | វីដេអូ |
|--------|-------|
| 01 - ការណែនាំ | [ការចាប់ផ្តើមជាមួយ LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - វិស្វករដាក់បញ្ចូល | [វិស្វករដាក់បញ្ចូលជាមួយ LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG ជាមួយ LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - ឧបករណ៍ និង 05 - MCP | [ភ្នាក់ងារ AI ជាមួយឧបករណ៍ និង MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## ផ្លូវរៀន

**ថ្មីចំពោះ LangChain4j?** ពិនិត្យមើល [ពាក្យសេចក្តីព្រៀង](docs/GLOSSARY.md) សម្រាប់និយមន័យពាក្យសំខាន់ និងគំនិត។

> **ចាប់ផ្តើមរហ័ស**

1. Fork ឃ្លាំងទិន្នន័យនេះទៅគណនី GitHub របស់អ្នក
2. ចុច **Code** → ក្រឡាចត្រង្គ **Codespaces** → **...** → **New with options...**
3. ប្រើតម្លៃដើម – វានឹងជ្រើសរើស Development container ដែលបានបង្កើតសម្រាប់វគ្គនេះ
4. ចុច **Create codespace**
5. រង់ចាំ 5-10 នាទីសម្រាប់បរិយាកាសត្រៀមរួច
6. ឆ្លងទៅ [ការណែនាំ](./01-introduction/README.md) ដើម្បីចាប់ផ្តើម!

បន្ទាប់ពីបញ្ចប់ផ្នែកទាំងអស់ សូមអនុវត្តការសាកល្បងតាម [Testing Guide](docs/TESTING.md) ដើម្បីមើលគំនិតសាកល្បង LangChain4j នៅក្នុងសកម្មភាព។

> **កំណត់សម្គាល់:** ការបណ្តុះបណ្តាលនេះប្រើ Azure OpenAI។ ចាប់ផ្តើមជាមួយគណនី [Azure សេវាឥតគិតថ្លៃ](https://aka.ms/azure-free-account) ប្រសិនបើអ្នកមិនមាន។


## រៀនជាមួយ GitHub Copilot

ដើម្បីចាប់ផ្តើមកូដបានយ៉ាងរហ័ស បើកគម្រោងនេះក្នុង GitHub Codespace ឬ IDE របស់អ្នកនៅក្នុងម៉ាស៊ីនផ្ទាល់ដោយប្រើ devcontainer ដែលបានផ្ដល់។ devcontainer ដែលប្រើនៅវគ្គនេះត្រូវបានកំណត់រួចជាមួយ GitHub Copilot សម្រាប់កម្មកម្មគូ AI។

រាល់ឧទាហរណ៍កូដមានសំណួរដែលអ្នកអាចសួរជាមួយ GitHub Copilot ដើម្បីជ្រាបជ្រៅការយល់ដឹង។ សូមស្វែងរកម៉ាក 💡/🤖 នៅក្នុង៖

- **ក្បាលឯកសារ Java** - សំណួរពិសេសសម្រាប់ឧទាហរណ៍នីមួយៗ
- **README របស់ផ្នែក** - សំណួរសម្រាប់ស្រាវជ្រាវបន្ទាប់ពីឧទាហរណ៍កូដ

**វិធីប្រើ:** បើកឯកសារកូដណាមួយ ហើយសួរនូវសំណួរដែលបានណែនាំពី Copilot។ វាអាចយល់ទាំងមូលអំពីប្រព័ន្ធកូដ និងអាចពន្យារពន្យាពាក្យ បន្ថែមនិងផ្តល់ជម្រើសផ្សេងៗ។

ចង់រៀនបន្ថែមទៀត? សូមពិនិត្យ [Copilot សម្រាប់កម្មកម្មគូ AI](https://aka.ms/GitHubCopilotAI)។


## ឯកសារបន្ថែម

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
 
### ផ្នែក Generative AI
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ការរួមបញ្ចូលមូលដ្ឋាន
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ផ្នែក Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## សូមទទួលបានជំនួយ

ប្រសិនបើអ្នកមានបញ្ហាឬសំណួរណាមួយអំពីការសង់កម្មវិធី AI សូមចូលរួម៖

[![Microsoft Foundry Discord](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

ប្រសិនបើអ្នកមានមតិយោបល់ផលិតផល ឬកំហុសក្នុងការសាងសង់ សូមទៅកាន់៖

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## បទបញ្ជា

អាជ្ញាប័ណ្ណ MIT - ទស្សនា​ឯកសារ [LICENSE](../../LICENSE) សម្រាប់ព័ត៌មានលម្អិត។

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:
ឯកសារនេះត្រូវបានបម្លែងភាសា ដោយប្រើសេវាបម្លែងភាសា AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ទោះយើងខ្ញុំមានក្តីប្រាថ្នាឱ្យបានច្បាស់លាស់ តែសូមយល់ដឹងថាការបម្លែងដោយស្វ័យប្រវត្តិក៏អាចមានកំហុសឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមជាភាសាទីតាំងគួរត្រូវបានគេប្រើជាប្រភពច្បាស់លាស់។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមណែនាំឱ្យប្រើប្រាស់ការប្រែដោយមនុស្សជំនាញ។ យើងខ្ញុំមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការបកស្រាយខុសបន្ទាប់ពីការប្រើប្រាស់ការបម្លែងនេះនោះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->