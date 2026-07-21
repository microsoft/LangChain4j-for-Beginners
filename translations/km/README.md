<img src="../../translated_images/km/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j សម្រាប់អ្នកដំបូងរើប

វគ្គសិក្សាសម្រាប់ការសង់កម្មវិធី AI ជាមួយ LangChain4j និង Azure OpenAI GPT-5.2 ពីការជជែកមូលដ្ឋានមកដល់ភ្នាក់ងារ AI។

### 🌐 គាំទ្រភាសាច្រើន

#### គាំទ្រដោយ GitHub Action (ស្វ័យប្រវត្តិ និងតែងតែទាន់សម័យ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Khmer](./README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **ចង់ធ្វើការ Clone នៅក្នុងម៉ាស៊ីនខ្លួនឯង?**
>
> ឃ្លាំងនេះរួមបញ្ចូលការប្រែសម្រួលភាសាជាង ៥០ ដែលបង្កើនទំហំការទាញយកយ៉ាងច្រើន។ ដើម្បី Clone ដោយគ្មានការប្រែសម្រួល ប្រើ sparse checkout:
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
> វានឹងផ្គត់ផ្គង់អ្វីដែលអ្នកត្រូវការ ដើម្បីបញ្ចប់វគ្គសិក្សានេះជាមួយនឹងការទាញយកលឿនជាងមុន។
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## តារាងមាតិកា

1. [ការប្រុងប្រាជ្ញា](01-introduction/README.md) - រៀនពីមូលដ្ឋាននៃ LangChain4j
2. [Prompt Engineering](02-prompt-engineering/README.md) - សម្របសម្រួលការរចនាការបញ្ជា
3. [RAG (Retrieval-Augmented Generation)](03-rag/README.md) - សង់ប្រព័ន្ធនៃចំណេះដឹងដ៏ឆ្លាតវៃ
4. [ឧបករណ៍](04-tools/README.md) - ប្រព័ន្ធបញ្ចូលឧបករណ៍ខាងក្រៅ និងអ្នកជួយសាមញ្ញ
5. [MCP (Model Context Protocol)](05-mcp/README.md) - ធ្វើការជាមួយ Model Context Protocol (MCP) និងម៉ូឌុល Agentic

### វីដេអូចេញដំណើរ

មហាសេដ្ឋីនីមួយៗមានវគ្គសិក្សាផ្ទាល់ខ្លួនដែលយើងបើកចំហរជំហានទៅជំហានពន្យល់ពីគំនិត និងកូដ។

| មហាសេដ្ឋី | វីដេអូ |
|--------|-------|
| 01 - ការប្រុងប្រាជ្ញា | [ការចាប់ផ្តើមជាមួយ LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - Prompt Engineering | [រចនាបណ្ដាំដំណើរការជាមួយ LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG ជាមួយ LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - ឧបករណ៍ និង 05 - MCP | [ភ្នាក់ងារ AI ជាមួយឧបករណ៍ និង MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## ផ្លូវរៀន

**ថ្មីចំពោះ LangChain4j?** សូមពិនិត្យមើល [ពាក្យកំណត់](docs/GLOSSARY.md) សម្រាប់និយមន័យនៃពាក្យសំខាន់ៗ និងយោបល់។

> **ចាប់ផ្តើមយ៉ាងរហ័ស**

1. Fork ឃ្លាំងនេះទៅកាន់គណនី GitHub របស់អ្នក
2. ចុច **Code** → **Codespaces** ប៊ិច → **...** → **New with options...**
3. ប្រើលំនាំដើម – វានឹងជ្រើសបំពង់អភិវឌ្ឍន៍ដែលបានបង្កើតសម្រាប់វគ្គនេះ
4. ចុច **Create codespace**
5. រង់ចាំ 5-10 នាទីសម្រាប់បរិយាកាសរួចរាល់
6. រំកិលទៅ [ការប្រុងប្រាជ្ញា](./01-introduction/README.md) ដើម្បីចាប់ផ្តើម!

បន្ទាប់ពីបញ្ចប់មហាសេដ្ឋី សូមស្វែងយល់ពី [មគ្គុទេសក៍សាកល្បង](docs/TESTING.md) ដើម្បីមើលគំនិតលើការតេស្ត LangChain4j ក្នុងសកម្មភាព។

> **ចំណាំ៖** ការបណ្តុះបណ្តាលនេះប្រើ Azure OpenAI។ ចាប់ផ្តើមជាមួយ [គណនី Azure មិនគិតថ្លៃ](https://aka.ms/azure-free-account) ប្រសិនបើអ្នកមិនមានទេ។

## រៀនជាមួយ GitHub Copilot

ដើម្បីចាប់ផ្តើមគូរយូធូបឆាប់រហ័ស បើកគម្រោងនេះនៅក្នុង GitHub Codespace ឬ IDE ផ្ទាល់ខ្លួនជាមួយ devcontainer ដែលបានផ្តល់ជូន។ devcontainer ដែលប្រើនៅវគ្គនេះមានការតំឡើងរួចហើយនឹង GitHub Copilot សម្រាប់កម្មវិធីសរសេរកូដជាគូ AI។

គំរូកូដនីមួយៗមានសំណួរផ្តល់អនុសាសន៍ដែលអ្នកអាចសួរបាន GitHub Copilot ដើម្បីជ្រាបច្បាស់ជាងមុន។ ស្វែងរកសញ្ញា 💡/🤖 នៅក្នុង៖

- **មុខកថា Java** - សំណួរពិសេសសម្រាប់គំរូនីមួយៗ
- **README មហាសេដ្ឋី** - សំណួរជ្រាបច្បាស់បូកបន្ថែមបន្ទាប់ពីគំរូកូដ

**របៀបប្រើ៖** បើកឯកសារកូដណាមួយ ហើយសួរអ្នកជំនួយ Copilot ពីសំណួរផ្តល់អនុសាសន៍។ វាមានបទបង្ហាញពេញលេញនៃកូដ ហើយអាចពន្យល់ ពង្រីក និងផ្តល់ជម្រើសជំនួស។

ចង់រៀនបន្ថែមទៀត? សូមពិនិត្យមើល [Copilot សម្រាប់កម្មវិធីសរសេរកូដជាគូ AI](https://aka.ms/GitHubCopilotAI)។

## ធនធានបន្ថែម

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ភ្នាក់ងារ AI សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ស៊េរី Generative AI
[![Generative AI សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ការសិក្សាក្តៅ
[![ML សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![វិទ្យាសាស្រ្តទិន្នន័យសម្រាប់អ្នកដំបូង](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI សម្រាប់អ្នកដំបូង](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![សុវត្ថិភាពវេបសាយសម្រាប់អ្នកដំបូង](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ស៊េរី Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ទទួលបានជំនួយ

បើអ្នកមានបញ្ហា ឬមានសំនួរអំពីការបង្កើតកម្មវិធី AI សូមចូលរួម:

[![Microsoft Foundry Discord](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

បើអ្នកមានមតិប្រកាសផលិតផល ឬកំហុសពេលបង្កើត សូមចូលរកបាននៅ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## អាជ្ញាប័ណ្ណ

អាជ្ញាប័ណ្ណ MIT - មើលឯកសារ [LICENSE](../../LICENSE) សម្រាប់ព័ត៌មានលម្អិត។

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:
ឯកសារនេះត្រូវបានបម្លែងភាសា ដោយប្រើសេវាបម្លែងភាសា AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ទោះយើងខ្ញុំមានក្តីប្រាថ្នាឱ្យបានច្បាស់លាស់ តែសូមយល់ដឹងថាការបម្លែងដោយស្វ័យប្រវត្តិក៏អាចមានកំហុសឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមជាភាសាទីតាំងគួរត្រូវបានគេប្រើជាប្រភពច្បាស់លាស់។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមណែនាំឱ្យប្រើប្រាស់ការប្រែដោយមនុស្សជំនាញ។ យើងខ្ញុំមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការបកស្រាយខុសបន្ទាប់ពីការប្រើប្រាស់ការបម្លែងនេះនោះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->