<img src="../../translated_images/ar/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j للمبتدئين

دورة لبناء تطبيقات الذكاء الاصطناعي باستخدام LangChain4j و Azure OpenAI GPT-5.2، من الدردشة الأساسية إلى الوكلاء الذكاء الاصطناعي.

### 🌐 دعم متعدد اللغات

#### الترجمات صيانتها بواسطة [Co-op Translator](https://github.com/Azure/co-op-translator)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[العربية](./README.md) | [البنغالية](../bn/README.md) | [البلغارية](../bg/README.md) | [البورمية (ميانمار)](../my/README.md) | [الصينية (المبسطة)](../zh-CN/README.md) | [الصينية (التقليدية، هونغ كونغ)](../zh-HK/README.md) | [الصينية (التقليدية، ماكاو)](../zh-MO/README.md) | [الصينية (التقليدية، تايوان)](../zh-TW/README.md) | [الكرواتية](../hr/README.md) | [التشيكية](../cs/README.md) | [الدانماركية](../da/README.md) | [الهولندية](../nl/README.md) | [الإستونية](../et/README.md) | [الفنلندية](../fi/README.md) | [الفرنسية](../fr/README.md) | [الألمانية](../de/README.md) | [اليونانية](../el/README.md) | [العبرية](../he/README.md) | [الهندية](../hi/README.md) | [الهنغارية](../hu/README.md) | [الإندونيسية](../id/README.md) | [الإيطالية](../it/README.md) | [اليابانية](../ja/README.md) | [الكنادا](../kn/README.md) | [الخميرية](../km/README.md) | [الكورية](../ko/README.md) | [اللتوانية](../lt/README.md) | [الماليزية](../ms/README.md) | [الماليالم](../ml/README.md) | [الماراثية](../mr/README.md) | [النيبالية](../ne/README.md) | [نيجيري بيدجين](../pcm/README.md) | [النرويجية](../no/README.md) | [الفارسية (الفارسية)](../fa/README.md) | [البولندية](../pl/README.md) | [البرتغالية (البرازيل)](../pt-BR/README.md) | [البرتغالية (البرتغال)](../pt-PT/README.md) | [البنغالية (غرمخي)](../pa/README.md) | [الرومانية](../ro/README.md) | [الروسية](../ru/README.md) | [الصربية (السيريلية)](../sr/README.md) | [السلوفاكية](../sk/README.md) | [السلوفينية](../sl/README.md) | [الإسبانية](../es/README.md) | [السواحيلية](../sw/README.md) | [السويدية](../sv/README.md) | [التاغالوغ (الفلبينية)](../tl/README.md) | [التاميل](../ta/README.md) | [التيلجو](../te/README.md) | [التايلاندية](../th/README.md) | [التركية](../tr/README.md) | [الأوكرانية](../uk/README.md) | [الأردية](../ur/README.md) | [الفيتنامية](../vi/README.md)

> **تفضل الاستنساخ محليًا؟**
>
> يحتوي هذا المستودع على أكثر من 50 ترجمة لغة مما يزيد بشكل كبير من حجم التنزيل. للاستنساخ بدون الترجمات، استخدم السحب الانتقائي:
>
> **باش / macOS / لينكس:**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/LangChain4j-for-Beginners.git
> cd LangChain4j-for-Beginners
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **CMD (ويندوز):**
> ```cmd
> git clone --filter=blob:none --sparse https://github.com/microsoft/LangChain4j-for-Beginners.git
> cd LangChain4j-for-Beginners
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
>
> هذا يمنحك كل ما تحتاجه لإكمال الدورة بسرعة تحميل أكبر.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## جدول المحتويات

1. [مقدمة](01-introduction/README.md) - تعلم أساسيات LangChain4j
2. [هندسة البرمجة](02-prompt-engineering/README.md) - اتقان تصميم المطالبات الفعالة
3. [RAG (التوليد المدعوم بالاسترجاع)](03-rag/README.md) - بناء أنظمة معرفية ذكية
4. [الأدوات](04-tools/README.md) - دمج الأدوات الخارجية والمساعدين البسيطين
5. [MCP (بروتوكول سياق النموذج)](05-mcp/README.md) - العمل مع بروتوكول سياق النموذج (MCP) والوحدات الوكيلة

### جولات فيديو إرشادية

لكل وحدة جلسة حية مرافقة نمر فيها على المفاهيم والكود خطوة بخطوة.

| الوحدة | الفيديو |
|--------|-------|
| 01 - المقدمة | [البدء مع LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - هندسة البرمجة | [هندسة البرمجة مع LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG مع LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - الأدوات و 05 - MCP | [وكلاء الذكاء الاصطناعي مع الأدوات و MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## مسار التعلم

**جديد على LangChain4j؟** تحقق من [مسرد المصطلحات](docs/GLOSSARY.md) لتعريفات المصطلحات والمفاهيم الأساسية.

> **البدء السريع**

1. قم بتفرع هذا المستودع لحسابك على GitHub
2. انقر على **Code** → تبويب **Codespaces** → **...** → **جديد مع خيارات...**
3. استخدم الإعدادات الافتراضية – سيختار هذا حاوية التطوير المُنشأة لهذه الدورة
4. انقر على **إنشاء كود سبيس**
5. انتظر من 5 إلى 10 دقائق ليكون البيئة جاهزة
6. توجه مباشرة إلى [المقدمة](./01-introduction/README.md) للبدء!

بعد إكمال الوحدات، استكشف [دليل الاختبار](docs/TESTING.md) لرؤية مفاهيم اختبار LangChain4j في التطبيق.

> **ملاحظة:** يستخدم هذا التدريب Azure OpenAI. ابدأ مع [حساب Azure مجاني](https://aka.ms/azure-free-account) إذا لم يكن لديك حساب.


## التعلم مع GitHub Copilot

للبدء السريع في البرمجة، افتح هذا المشروع في GitHub Codespace أو بيئة التطوير المحلية لديك مع حاوية التطوير المزودة. حاوية التطوير المستخدمة في هذه الدورة مُهيأة مسبقًا مع GitHub Copilot للبرمجة الزوجية بالذكاء الاصطناعي.

يتضمن كل مثال رمزي أسئلة مقترحة يمكنك طرحها على GitHub Copilot لتعميق فهمك. ابحث عن الرموز 💡/🤖 في:

- **رؤوس ملفات جافا** - أسئلة خاصة بكل مثال
- **ملفات README للوحدات** - مطالبات استكشافية بعد أمثلة الكود

**كيفية الاستخدام:** افتح أي ملف كود واسأل كوبايلوت الأسئلة المقترحة. لديه سياق كامل للكود ويمكنه الشرح، والتوسيع، واقتراح البدائل.

هل تريد معرفة المزيد؟ تحقق من [Copilot للبرمجة الزوجية بالذكاء الاصطناعي](https://aka.ms/GitHubCopilotAI).


## موارد إضافية

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j للمبتدئين](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js للمبتدئين](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain للمبتدئين](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / وكلاء
[![AZD للمبتدئين](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI للمبتدئين](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP للمبتدئين](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![وكلاء الذكاء الاصطناعي للمبتدئين](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### سلسلة الذكاء الاصطناعي التوليدي
[![الذكاء الاصطناعي التوليدي للمبتدئين](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![الذكاء الاصطناعي التوليدي (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![الذكاء الاصطناعي التوليدي (جافا)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![الذكاء الاصطناعي التوليدي (جافا سكريبت)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### التعلم الأساسي
[![تعلم الآلة للمبتدئين](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![علوم البيانات للمبتدئين](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![الذكاء الاصطناعي للمبتدئين](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![الأمن السيبراني للمبتدئين](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![تطوير الويب للمبتدئين](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![إنترنت الأشياء للمبتدئين](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![تطوير XR للمبتدئين](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### سلسلة Copilot
[![Copilot للبرمجة الزوجية بالذكاء الاصطناعي](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot لـ C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![مغامرة Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## الحصول على المساعدة

إذا علقت أو كان لديك أي أسئلة حول بناء تطبيقات الذكاء الاصطناعي، انضم إلى:

[![خادم Discord الخاص بـ Microsoft Foundry](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

إذا كان لديك ملاحظات على المنتج أو أخطاء أثناء البناء، قم بزيارة:

[![منتدى مطوري Microsoft Foundry](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## الرخصة

رخصة MIT - راجع ملف [LICENSE](../../LICENSE) للتفاصيل.

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**تنويه**:
تمت ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى للدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو عدم دقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي والمعتمد. للمعلومات الهامة، يُنصح بالاستعانة بترجمة بشرية محترفة. نحن غير مسؤولين عن أي سوء فهم أو تفسير ناتج عن استخدام هذه الترجمة.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->