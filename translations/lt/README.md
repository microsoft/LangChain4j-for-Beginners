<img src="../../translated_images/lt/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j pradedantiesiems

Kursas apie AI programų kūrimą naudojant LangChain4j ir Azure OpenAI GPT-5.2, nuo paprasto pokalbio iki AI agentų.

### 🌐 Daugiakalbė palaikymas

#### Vertimai palaikomi su [Co-op Translator](https://github.com/Azure/co-op-translator)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[arabų](../ar/README.md) | [bengalų](../bn/README.md) | [bulgarų](../bg/README.md) | [birmiečių (Myanmar)](../my/README.md) | [kinų (supaprastinta)](../zh-CN/README.md) | [kinų (tradicinė, Honkongas)](../zh-HK/README.md) | [kinų (tradicinė, Makao)](../zh-MO/README.md) | [kinų (tradicinė, Taivanas)](../zh-TW/README.md) | [kroatų](../hr/README.md) | [čekų](../cs/README.md) | [danų](../da/README.md) | [olandų](../nl/README.md) | [estų](../et/README.md) | [suomių](../fi/README.md) | [prancūzų](../fr/README.md) | [vokiečių](../de/README.md) | [graikų](../el/README.md) | [hebrajų](../he/README.md) | [hindi](../hi/README.md) | [vengrų](../hu/README.md) | [indoneziečių](../id/README.md) | [italų](../it/README.md) | [japonų](../ja/README.md) | [kanadų](../kn/README.md) | [kmėrų](../km/README.md) | [korėjiečių](../ko/README.md) | [lietuvių](./README.md) | [malajų](../ms/README.md) | [malajalų](../ml/README.md) | [maratių](../mr/README.md) | [nepalų](../ne/README.md) | [nigerijos pidžinų](../pcm/README.md) | [norvegų](../no/README.md) | [persų (farši)](../fa/README.md) | [lenkų](../pl/README.md) | [portugalų (Brazilija)](../pt-BR/README.md) | [portugalų (Portugalija)](../pt-PT/README.md) | [pandžabių (Gurmukhi)](../pa/README.md) | [rumunų](../ro/README.md) | [rusų](../ru/README.md) | [serbų (kirilica)](../sr/README.md) | [slovakų](../sk/README.md) | [slovėnų](../sl/README.md) | [ispanų](../es/README.md) | [svahilų](../sw/README.md) | [švedų](../sv/README.md) | [tagalogų (filipiniečių)](../tl/README.md) | [tamilų](../ta/README.md) | [telugų](../te/README.md) | [tailandietiškų](../th/README.md) | [turkų](../tr/README.md) | [ukrainiečių](../uk/README.md) | [urdu](../ur/README.md) | [vietnamiečių](../vi/README.md)

> **Norite klonuoti vietoje?**
>
> Šiame saugykloje yra daugiau nei 50 kalbų vertimų, kurie ženkliai padidina atsisiuntimo dydį. Norėdami klonuoti be vertimų, naudokite sparčiojo atsisiuntimo pasirinkimą:
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
> Tai suteiks jums viską, ko reikia kursui užbaigti, su žymiai greitesniu atsisiuntimu.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Turinys

1. [Įvadas](01-introduction/README.md) - Susipažinkite su LangChain4j pagrindais
2. [Promptų kūrimas](02-prompt-engineering/README.md) - Įvaldykite efektyvų promptų dizainą
3. [RAG (Retrieval-Augmented Generation)](03-rag/README.md) - Kurkite išmanias žinių pagrindu veikiančias sistemas
4. [Įrankiai](04-tools/README.md) - Integruokite išorinius įrankius ir paprastus asistentus
5. [MCP (Model Context Protocol)](05-mcp/README.md) - Dirbkite su Model Context Protocol (MCP) ir agentiniais moduliais

### Vaizdo įrašų peržiūros

Kiekvienas modulis turi tiesioginę sesiją, kurioje žingsnis po žingsnio aptariame koncepcijas ir kodą.

| Modulis | Vaizdo įrašas |
|--------|--------------|
| 01 - Įvadas | [Pradžia su LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - Promptų kūrimas | [Promptų kūrimas su LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG su LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - Įrankiai ir 05 - MCP | [AI agentai su įrankiais ir MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## Mokymosi kelias

**Naujas LangChain4j?** Peržiūrėkite [Žodynėlį](docs/GLOSSARY.md), kuriame pateikiami svarbiausių terminų ir sąvokų apibrėžimai.

> **Greitas startas**

1. Padarykite šio saugyklos atšaką į savo GitHub paskyrą
2. Spustelėkite **Code** → **Codespaces** skirtuką → **...** → **New with options...**
3. Naudokite numatytuosius nustatymus – bus pasirinktas šiam kursui sukurtas kontaktinis konteineris
4. Spustelėkite **Create codespace**
5. Palaukite 5-10 minučių, kol aplinka bus paruošta
6. Tiesiogiai pereikite prie [Įvado](./01-introduction/README.md) ir pradėkite!

Baigę modulius, peržiūrėkite [Testavimo vadovą](docs/TESTING.md), kad pamatytumėte LangChain4j testavimo koncepcijas veikiant.

> **Pastaba:** Šis mokymas naudoja Azure OpenAI. Jei neturite, pradėkite su [NEMOKAMA Azure paskyra](https://aka.ms/azure-free-account).


## Mokymasis su GitHub Copilot

Norėdami greitai pradėti koduoti, atidarykite šį projektą GitHub Codespace arba savo vietiniame IDE su pateiktu devcontainer. Šiame kurse naudojamas devcontainer yra iš anksto sukonfigūruotas su GitHub Copilot AI partnerio programavimui.

Kiekviename kodo pavyzdyje yra pasiūlymų klausimų, kuriuos galite užduoti GitHub Copilot, kad gilintumėte supratimą. Ieškokite 💡/🤖 užrašų:

- **Java failų antraštės** - klausimai, skirti kiekvienam pavyzdžiui
- **Modulio README failai** - nagrinėjimo užuominos po kodo pavyzdžiais

**Kaip naudoti:** Atidarykite bet kurį kodo failą ir užduokite Copilot siūlomus klausimus. Jis turi pilną kodo bazės kontekstą ir gali paaiškinti, papildyti bei pasiūlyti alternatyvas.

Norite sužinoti daugiau? Peržiūrėkite [Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI).


## Papildomi ištekliai

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j pradedantiesiems](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js pradedantiesiems](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain pradedantiesiems](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agentai
[![AZD pradedantiesiems](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI pradedantiesiems](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pradedantiesiems](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI agentai pradedantiesiems](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generatyvinio AI serija
[![Generatyvinis AI pradedantiesiems](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generatyvinis AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generatyvinis AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generatyvinis AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Pagrindinis mokymasis
[![ML pradedantiesiems](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Duomenų mokslo pradedantiesiems](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI pradedantiesiems](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Kibernetinio saugumo pradedantiesiems](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Tinklalapių kūrimo pradedantiesiems](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT pradedantiesiems](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR kūrimo pradedantiesiems](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot serija
[![Copilot AI partnerystės programavimui](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot nuotykis](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Pagalba

Jei užstrigote arba turite klausimų apie AI programėlių kūrimą, prisijunkite prie:

[![Microsoft Foundry Discord](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Jei turite atsiliepimų apie produktą ar klaidų kuriant, apsilankykite:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## Licencija

MIT Licencija - Daugiau informacijos žr. [LICENSE](../../LICENSE) faile.

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:
Šis dokumentas buvo išverstas naudojant dirbtinio intelekto vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba laikomas autoritetingu šaltiniu. Svarbiai informacijai rekomenduojama naudoti profesionalų žmogiškąjį vertimą. Mes neatsakome už jokius nesusipratimus ar neteisingą interpretaciją, kilusią naudojantis šiuo vertimu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->