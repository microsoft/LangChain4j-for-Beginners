<img src="../../translated_images/el/LangChain4j.90e1d693fcc71b50.webp" alt="LangChain4j" width="800"/>

# LangChain4j για Αρχάριους

Ένα μάθημα για τη δημιουργία εφαρμογών ΤΝ με LangChain4j και Azure OpenAI GPT-5.2, από βασική συνομιλία έως πράκτορες ΤΝ.

### 🌐 Υποστήριξη Πολλών Γλωσσών

#### Μεταφράσεις διατηρούνται με το [Co-op Translator](https://github.com/Azure/co-op-translator)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](./README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Khmer](../km/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **Προτιμάτε να κάνετε Clone τοπικά;**
>
> Αυτό το αποθετήριο περιλαμβάνει πάνω από 50 μεταφράσεις γλωσσών που αυξάνουν σημαντικά το μέγεθος λήψης. Για να κάνετε clone χωρίς μεταφράσεις, χρησιμοποιήστε sparse checkout:
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
> Αυτό σας δίνει όλα όσα χρειάζεστε για να ολοκληρώσετε το μάθημα με πολύ πιο γρήγορη λήψη.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Περιεχόμενα

1. [Εισαγωγή](01-introduction/README.md) - Μάθετε τα βασικά του LangChain4j
2. [Δημιουργία Prompt](02-prompt-engineering/README.md) - Κατακτήστε το αποτελεσματικό σχεδιασμό prompt
3. [RAG (Ανάκτηση-Ενισχυμένης Γένεσης)](03-rag/README.md) - Δημιουργήστε έξυπνα συστήματα βάσει γνώσης
4. [Εργαλεία](04-tools/README.md) - Ενσωματώστε εξωτερικά εργαλεία και απλούς βοηθούς
5. [MCP (Πρωτόκολλο Πλαισίου Μοντέλου)](05-mcp/README.md) - Εργαστείτε με το Model Context Protocol (MCP) και τα Agentic modules

### Οδηγίες Βίντεο

Κάθε ενότητα έχει ζωντανή συνεδρία συνοδείας όπου περνάμε βήμα-βήμα από τις έννοιες και τον κώδικα.

| Ενότητα | Βίντεο |
|--------|-------|
| 01 - Εισαγωγή | [Ξεκινώντας με LangChain4j](https://www.youtube.com/live/nl_troDm8rQ) |
| 02 - Δημιουργία Prompt | [Δημιουργία Prompt με LangChain4j](https://www.youtube.com/live/PJ6aBaE6bog) |
| 03 - RAG | [RAG με LangChain4j](https://www.youtube.com/watch?v=_olq75ZH_eY) |
| 04 - Εργαλεία & 05 - MCP | [Πράκτορες ΤΝ με Εργαλεία και MCP](https://www.youtube.com/watch?v=O_J30kZc0rw) |

---

## Μονοπάτι Μάθησης

**Νέοι στο LangChain4j;** Ρίξτε μια ματιά στο [Γλωσσάρι](docs/GLOSSARY.md) για ορισμούς βασικών όρων και εννοιών.

> **Γρήγορη Εκκίνηση**

1. Κάντε fork αυτό το αποθετήριο στον λογαριασμό σας στο GitHub
2. Κάντε κλικ στο **Code** → καρτέλα **Codespaces** → **...** → **Νέο με επιλογές...**
3. Χρησιμοποιήστε τις προεπιλογές – αυτό θα επιλέξει το Development container που δημιουργήθηκε για αυτό το μάθημα
4. Κάντε κλικ στο **Create codespace**
5. Περιμένετε 5-10 λεπτά για να είναι έτοιμο το περιβάλλον
6. Πηγαίνετε απευθείας στην [Εισαγωγή](./01-introduction/README.md) για να ξεκινήσετε!

Αφού ολοκληρώσετε τις ενότητες, εξερευνήστε τον [Οδηγό Δοκιμών](docs/TESTING.md) για να δείτε τις έννοιες δοκιμών του LangChain4j σε δράση.

> **Σημείωση:** Αυτή η εκπαίδευση χρησιμοποιεί το Azure OpenAI. Ξεκινήστε με έναν [ΔΩΡΕΑΝ λογαριασμό Azure](https://aka.ms/azure-free-account) αν δεν έχετε.


## Εκμάθηση με το GitHub Copilot

Για να ξεκινήσετε γρήγορα την κωδικοποίηση, ανοίξτε αυτό το έργο σε GitHub Codespace ή στον τοπικό σας IDE με το παρεχόμενο devcontainer. Το devcontainer που χρησιμοποιείται σε αυτό το μάθημα είναι προδιαμορφωμένο με GitHub Copilot για προγραμματισμό σε ζευγάρια με ΤΝ.

Κάθε παράδειγμα κώδικα περιλαμβάνει προτεινόμενες ερωτήσεις που μπορείτε να κάνετε στο GitHub Copilot για να εμβαθύνετε την κατανόησή σας. Ψάξτε για τις ενδείξεις 💡/🤖 στα:

- **Κεφαλίδες αρχείων Java** - Ερωτήσεις ειδικές για κάθε παράδειγμα
- **README ενότητας** - Προτροπές εξερεύνησης μετά τα παραδείγματα κώδικα

**Πώς να χρησιμοποιήσετε:** Ανοίξτε οποιοδήποτε αρχείο κώδικα και κάντε τις προτεινόμενες ερωτήσεις στον Copilot. Έχει πλήρες πλαίσιο του κώδικα και μπορεί να εξηγήσει, να επεκτείνει και να προτείνει εναλλακτικές.

Θέλετε να μάθετε περισσότερα; Ρίξτε μια ματιά στο [Copilot για Προγραμματισμό σε Ζευγάρια με ΤΝ](https://aka.ms/GitHubCopilotAI).


## Πρόσθετοι Πόροι

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j για Αρχάριους](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js για Αρχάριους](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain για Αρχάριους](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Πράκτορες
[![AZD για Αρχάριους](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI για Αρχάριους](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP για Αρχάριους](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Πράκτορες ΤΝ για Αρχάριους](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Σειρά Γεννητικής ΤΝ
[![Γεννητική ΤΝ για Αρχάριους](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Γεννητική ΤΝ (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Γεννητική ΤΝ (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Γεννητική ΤΝ (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Βασική Εκμάθηση
[![Μάθηση Μηχανών για Αρχάριους](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Επιστήμη Δεδομένων για Αρχάριους](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![Τεχνητή Νοημοσύνη για Αρχάριους](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Κυβερνοασφάλεια για Αρχάριους](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Ανάπτυξη Ιστού για Αρχάριους](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT για Αρχάριους](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Ανάπτυξη XR για Αρχάριους](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Σειρά Copilot
[![Copilot για Προγραμματισμό σε Ζευγάρια με ΤΝ](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot για C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Περιπέτεια Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Λήψη Βοήθειας

Αν κολλήσετε ή έχετε ερωτήσεις σχετικά με τη δημιουργία εφαρμογών ΤΝ, συμμετέχετε:

[![Microsoft Foundry Discord](https://img.shields.io/badge/Discord-Microsoft_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Αν έχετε σχόλια για προϊόν ή σφάλματα κατά την κατασκευή, επισκεφθείτε:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

## Άδεια Χρήσης

Άδεια MIT - Δείτε το αρχείο [LICENSE](../../LICENSE) για λεπτομέρειες.

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Αποποίηση ευθυνών**:
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία μετάφρασης με τεχνητή νοημοσύνη [Co-op Translator](https://github.com/Azure/co-op-translator). Ενώ επιδιώκουμε την ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή λανθασμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->