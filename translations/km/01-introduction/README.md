# Module 01: ការចាប់ផ្តើមជាមួយ LangChain4j

## តារាងមាតិកា

- [ការបង្ហាញវីដេអូ](#ការបង្ហាញវីដេអូ)
- [អ្វីដែលអ្នកនឹងរៀន](#អ្វីដែលអ្នកនឹងរៀន)
- [លក្ខណៈបូករួមដែលត្រូវការ](#លក្ខណៈបូករួមដែលត្រូវការ)
- [ការយល់ដឹងពីបញ្ហាចម្បង](#ការយល់ដឹងពីបញ្ហាចម្បង)
- [ការយល់ដឹងអំពី Tokens](#ការយល់ដឹងអំពី-tokens)
- [របៀបដែលមេម៉ូរីដំណើរការ](#របៀបដែលមេម៉ូរីដំណើរការ)
- [របៀបប្រើ LangChain4j នេះ](#របៀបប្រើ-langchain4j-នេះ)
- [ដាក់ឲ្យដំណើរការ Facebook OpenAI](#ដាក់ឲ្យដំណើរការ-azure-openai-infrastructure)
- [រត់កម្មវិធីនៅក្នុងម៉ាស៊ីន](#រត់កម្មវិធីនៅក្នុងម៉ាស៊ីន)
- [ការប្រើកម្មវិធី](#ការប្រើកម្មវិធី)
  - [chat Stateless (ផ្នែកឆ្វេង)](#stateless-chat-ផ្នែកឆ្វេង)
  - [chat Stateful (ផ្នែកស្តាំ)](#stateful-chat-ផ្នែកស្តាំ)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)

## ការបង្ហាញវីដេអូ

មើលវីដេអូផ្ទាល់នេះដែលពន្យល់ពីរបៀបចាប់ផ្តើមជាមួយមូឌុលនេះ៖

<a href="https://www.youtube.com/live/nl_troDm8rQ?si=6b85S8xGjWnT2fX9"><img src="https://img.youtube.com/vi/nl_troDm8rQ/maxresdefault.jpg" alt="ការចាប់ផ្តើមជាមួយ LangChain4j - សម័យផ្ទាល់" width="800"/></a>

## អ្វីដែលអ្នកនឹងរៀន

នេះជាចំណុចចាប់ផ្តើមរបស់អ្នកជាមួយ LangChain4j និង Azure OpenAI។ យើងចាប់ផ្តើមពីមូលដ្ឋានហើយចាប់ផ្តើមកសាងកម្មវិធីបែបផលិតកម្ម។ មូឌុលនេះផ្តោតលើ AI សន្ទនា ដែលចងចាំcontext និងរក្សាស្ថានភាព — គោលនយោបាយមូលដ្ឋានដែលមូឌុលបន្ទាប់ទាំងអស់បានបើកចំហ។

យើងនឹងប្រើ GPT-5.2 របស់ Azure OpenAI ទូទាំងមេរៀននេះ ព្រោះសមត្ថភាពហេតុផលខ្ពស់របស់វាធ្វើឲ្យការបង្ហាញទម្រង់នានាផ្សេងៗកាន់តែច្បាស់លាស់។ នៅពេលអ្នកបន្ថែមមេម៉ូរី អ្នកនឹងឃើញភាពខុសគ្នាដោយច្បាស់។ វាធ្វើឲ្យងាយស្រួលក្នុងការយល់ថាផ្នែកណាផ្តល់អ្វីទៅកម្មវិធីរបស់អ្នក។

អ្នកនឹងបង្កើតកម្មវិធីមួយ ដែលបង្ហាញទាំងពីរទម្រង់នេះ៖

**Stateless Chat** - រាល់សំណើគឺឯករាជ្យ។ ម៉ូឌែលមិនមានការចងចាំសារមុន។ នេះជាចំណុចចាប់ផ្តើមសាមញ្ញបំផុត។

**Stateful Conversation** - រាល់សំណើរមានប្រវត្តិការសន្ទនា។ ម៉ូឌែលរក្សា context ជាយូរជាងនេះ។ នេះជាវត្ថុដែលកម្មវិធីផលិតកម្មត្រូវការ។

## លក្ខណៈបូករួមដែលត្រូវការ

- ចុះឈ្មោះ Azure ជាមួយការចូលប្រើ Azure OpenAI
- Java 21, Maven 3.9+
- Azure CLI (https://learn.microsoft.com/en-us/cli/azure/install-azure-cli)
- Azure Developer CLI (azd) (https://learn.microsoft.com/en-us/azure/developer/azure-developer-cli/install-azd)

> **កំណត់ចំណាំ:** Java, Maven, Azure CLI និង Azure Developer CLI (azd) ត្រូវបានដំឡើងរួចនៅក្នុង devcontainer ដែលផ្តល់ជូន។

> **កំណត់ចំណាំ:** មូឌុលនេះប្រើ GPT-5.2 នៅលើ Azure OpenAI។ ការដំឡើងត្រូវបានកំណត់ដោយស្វ័យប្រវត្តិតាម `azd up` - មិនត្រូវកែប្រែឈ្មោះម៉ូឌែលក្នុងកូដឡើយ។

## ការយល់ដឹងពីបញ្ហាចម្បង

ម៉ូឌែលភាសាគឺស្ថានភាពឯករាជ្យ។ រាល់ការហៅ API គឺឯករាជ្យ។ ប្រសិនបើអ្នកផ្ញើ "ខ្ញុំឈ្មោះ John" ហើយបន្ទាប់មកសួរ "ឈ្មោះខ្ញុំជាអ្វី?" ម៉ូឌែលមិនដឹងថាអ្នកបានណែនាំខ្លួនហើយ។ វាត្រូវគ្រប់សំណើដូចជាលើកដំបូងដែលអ្នកបានចាប់ផ្តើមសន្ទនា។

នេះល្អសម្រាប់សំណួរនិងចម្លើយសាមញ្ញ ប៉ុន្តែមិនមានប្រយោជន៍សម្រាប់កម្មវិធីពិតប្រាកដទេ។ បុត្យសេវាកម្មអតិថិជនត្រូវការចងចាំអ្វីដែលអ្នកបានប្រាប់។ ជំនួយការផ្ទាល់ខ្លួនត្រូវការប្រភេទContext។ ការសន្ទនាច្រើនជំហានត្រូវការមេម៉ូរី។

គំនូសតាងខាងក្រោមបង្ហាញការប្រៀបធៀបរវាងវិធីសាស្រ្តពីរនេះ — ផ្នែកឆ្វេង ជាការហៅឯករាជ្យដែលភ្លេចឈ្មោះអ្នក; ផ្នែកស្តាំ ជាការហៅមានស្ថានភាព ដែលគាំទ្រ ChatMemory ដែលចងចាំវា។

<img src="../../../translated_images/km/stateless-vs-stateful.cc4a4765e649c41a.webp" alt="Stateless vs Stateful Conversations" width="800"/>

*ភាពខុសគ្នារវាង សន្ទនាឯករាជ្យ និងសន្ទនាដែលមាន context*

## ការយល់ដឹងអំពី Tokens

មុនពេលចូលទៅក្នុងការសន្ទនា គួរយល់ដឹងអំពី tokens - អង្គធាតុមូលដ្ឋាននៃអត្ថបទដែលម៉ូឌែលភាសាដំណើរការ៖

<img src="../../../translated_images/km/token-explanation.c39760d8ec650181.webp" alt="Token Explanation" width="800"/>

*ឧទាហរណ៍ពីរបៀបអត្ថបទបំបែកជាទុកខន្លះៗ - "I love AI!" ក្លាយទៅជាឯកតាប្រតិបត្តិការពីរ ៤*

Tokens ជារបៀបដែលម៉ូឌែល AI វាស់វែង និងដំណើរការ អត្ថបទ។ ពាក្យ សញ្ញាវិនិច្ឆ័យ និងកន្លែងទទេ ទាំងអស់អាចជាទុកខន្លះបាន។ ម៉ូឌែលរបស់អ្នកមានកំណត់មាត្រជាចំនួន token វាអាចដំណើរការបាននៅមួយ ពេល (៤០០,០០០ សម្រាប់ GPT-5.2, រួមមានបញ្ចូលតុកខាន់ ២៧២,០០០ និងចេញតុកខាន់ ១២៨,០០០)។ ការយល់ពី token ជួយអ្នកគ្រប់គ្រងរយៈពេលសន្ទនា និងថ្លៃដើម។

## របៀបដែលមេម៉ូរីដំណើរការ

Chat memory ធ្វើការដោះស្រាយបញ្ហាស្ថានភាពឯករាជ្យ ដោយរក្សាប្រវត្តិសន្ទនា។ មុនផ្ញើសំណើទៅម៉ូឌែល វាដាក់សារ relevants មុននៗជាមុន។ នៅពេលអ្នកសួរ "ឈ្មោះខ្ញុំជាអ្វី?" ប្រព័ន្ធផ្ញើប្រវត្តិសន្ទនាដល់ម៉ូឌែល ដូច្នេះវាឃើញថាអ្នកបាននិយាយថា "ខ្ញុំឈ្មោះ John" មុនហើយ។

LangChain4j ផ្តល់ជូននូវការអនុវត្តមេម៉ូរី ដែលដំណើរការដោយស្វ័យប្រវត្តិ។ អ្នកជ្រើសរើសចំនួនសារដែលអាចរក្សាទុក ហើយ framework គ្រប់គ្រងប្រអប់ context ជូនអ្នក។ គំនូសតាងខាងក្រោមបង្ហាញពីរបៀបដែល MessageWindowChatMemory រក្សាប្រអប់ចលករជាសារថ្មីៗ។

<img src="../../../translated_images/km/memory-window.bbe67f597eadabb3.webp" alt="Memory Window Concept" width="800"/>

*MessageWindowChatMemory រក្សាប្រអប់ចលនា ស៊ីធីរបស់សារថ្មីៗ ដោយជាប្រព័ន្ធចេញសារចាស់ៗដោយស្វ័យប្រវត្តិ*

## របៀបប្រើ LangChain4j នេះ

មូឌុលនេះបញ្ចូល Spring Boot ហើយបន្ថែមមេម៉ូរីសន្ទនា។ របៀបភ្ជាប់គ្នារបស់វា៖

**Dependencies** - បន្ថែមបណ្ណាល័យ LangChain4j ពីរ៖

```xml
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j</artifactId> <!-- Inherited from BOM in root pom.xml -->
</dependency>
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-open-ai-official</artifactId> <!-- Inherited from BOM in root pom.xml -->
</dependency>
```

**Chat Model** - កំណត់ Azure OpenAI ជា Spring bean ([LangChainConfig.java](../../../01-introduction/src/main/java/com/example/langchain4j/config/LangChainConfig.java))៖

```java
@Bean
public OpenAiOfficialChatModel openAiOfficialChatModel() {
    return OpenAiOfficialChatModel.builder()
            .baseUrl(azureEndpoint)
            .apiKey(azureApiKey)
            .modelName(deploymentName)
            .timeout(Duration.ofMinutes(5))
            .maxRetries(3)
            .build();
}
```

Builder អានអត្តសញ្ញាណពីបរិយាកាសដែលបានកំណត់ដោយ `azd up`។ ការកំណត់ `baseUrl` ទៅចំណុចចេញ Azure របស់អ្នក ធ្វើឲ្យ client OpenAI ធ្វើការជាមួយ Azure OpenAI បាន។

**Conversation Memory** - តាមដានប្រវត្តិការសន្ទនាជាមួយ MessageWindowChatMemory ([ConversationService.java](../../../01-introduction/src/main/java/com/example/langchain4j/service/ConversationService.java))៖

```java
ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);

memory.add(UserMessage.from("My name is John"));
memory.add(AiMessage.from("Nice to meet you, John!"));

memory.add(UserMessage.from("What's my name?"));
AiMessage aiMessage = chatModel.chat(memory.messages()).aiMessage();
memory.add(aiMessage);
```

បង្កើតមេម៉ូរីជាមួយ `withMaxMessages(10)` ដើម្បីរក្សាសារចុងក្រោយ១០សារ។ បន្ថែមសារអ្នកប្រើ និង AI ជាមួយ Typed wrappers: `UserMessage.from(text)` និង `AiMessage.from(text)`។ ទាញយកប្រវត្តិយ៉ាង `memory.messages()` ហើយផ្ញើទៅម៉ូឌែល។ សេវាកម្មរក្សារម៉េម៉ូរីអក្សរផ្សេងៗទុករៀងរាល់ conversation ID អនុញ្ញាតឲ្យអ្នកប្រើជាច្រើនបានសន្ទនាតាមពីរដល់ព្រម។

> **🤖 សាកល្បងជាមួយ [GitHub Copilot](https://github.com/features/copilot) Chat:** បើក [`ConversationService.java`](../../../01-introduction/src/main/java/com/example/langchain4j/service/ConversationService.java) ហើយសួរ៖  
> - "MessageWindowChatMemory ធ្វើដូចម្តេចក្នុងការសម្រេចចិត្តចេញសារណាដែលទៅពេលប៉ុន្មានពេញប្រអប់?"  
> - "តើខ្ញុំអាចអនុវត្តផ្ទុកមេម៉ូរីផ្ទាល់ខ្លួនដោយប្រើទិន្នន័យបញ្ជីទិន្នន័យជំនួសមេម៉ូរីក្នុងម៉ោនទេ?"  
> - "តើខ្ញុំនឹងបន្ថែមការសង្ខេបដើម្បីចុះកម្រិតប្រវត្តិការសន្ទនា​ចាស់ៗបានដូចម្តេច?"

Chat Stateless មាន endpoint មិនប្រើមេម៉ូរីទាំងអស់ - គឺ `chatModel.chat(prompt)` ដូចជាការចាប់ផ្តើមលឿន។ Chat Stateful បន្ថែមសារចូលទៅមេម៉ូរី ទាញយកប្រវត្តិ ហើយរួមបញ្ចូល context តាមកំណត់សំណើរ។ ការកំណត់ម៉ូឌែលដូចគ្នា តែបែបបទខុសគ្នា។

## ដាក់ឲ្យដំណើរការ Azure OpenAI Infrastructure

**Bash:**
```bash
cd 01-introduction
azd up  # ជ្រើសរើសការប្រព្រឹត្តិការណ៍ និងទីតាំង (eastus2 គឺត្រូវបានផ្តល់អនុសាសន៍)
```

**PowerShell:**
```powershell
cd 01-introduction
azd up  # ជ្រើសរើសការជាវ និងទីតាំង (មែនទែនថា eastus2)
```

> **កំណត់ចំណាំ:** ប្រសិនបើអ្នកជួបបញ្ហាចុងបញ្ចប់ពេលស្នើសុំ (`RequestConflict: Cannot modify resource ... provisioning state is not terminal`), ចូររត់ `azd up` ម្តងទៀត។ អង្គភាព Azure អាចនៅក្រោមដំណើរការនៅខាងក្រោយ ហើយការសាកល្បងឡើងវិញធ្វើឲ្យការដាក់ឲ្យដំណើរការសម្រេចបានពេលអង្គភាពចប់នៅស្ថានភាពចុងក្រោយ។

វានឹង៖  
1. ដាក់ឲ្យដំណើរការ Azure OpenAI ជាមួយម៉ូឌែល GPT-5.2 និង text-embedding-3-small  
2. បង្កើតឯកសារ `.env` ឯកសារដើមក្នុងគម្រោងជាស្វ័យប្រវត្តិ ជាមួយអត្តសញ្ញាណ  
3. កំណត់អថេរបរិយាកាសទាំងអស់ដែលត្រូវការ

**ប្រឈមបញ្ហាក្នុងការដាក់ឲ្យដំណើរការ?** មើល [Infrastructure README](infra/README.md) សម្រាប់ការដោះស្រាយលម្អិត រួមមានបញ្ហាឈ្មោះ subdomain, ជំហានដាក់មិនឲ្យប្រើ Azure Portal ដោយដៃ និងការណែនាំកំណត់ម៉ូឌែល។

**បញ្ជាក់ថាការដាក់បានជោគជ័យ៖**

**Bash:**
```bash
cat ../.env  # គួរតែបង្ហាញ AZURE_OPENAI_ENDPOINT, API_KEY, ល។
```

**PowerShell:**
```powershell
Get-Content ..\.env  # គួរតែបង្ហាញ AZURE_OPENAI_ENDPOINT, API_KEY, ល។
```

> **កំណត់ចំណាំ:** ពាក្យបញ្ជា `azd up` បង្កើតឯកសារ `.env` ដោយស្វ័យប្រវត្តិ។ ប្រសិនបើអ្នកចង់បន្ទាន់សម័យនៅពេលក្រោយ អ្នកអាចកែប្រែឯកសារ `.env` ដោយដៃ ឬបង្កើតឡើងវិញដោយរត់ ៖
>
> **Bash:**
> ```bash
> cd ..
> bash .azd-env.sh
> ```
>
> **PowerShell:**
> ```powershell
> cd ..
> .\.azd-env.ps1
> ```


## រត់កម្មវិធីនៅក្នុងម៉ាស៊ីន

**បញ្ជាក់ការដាក់បាន៖**

ធ្វើឲ្យប្រាកដថា ឯកសារ `.env` មាននៅក្នុងថតdir root ដោយមានអត្តសញ្ញាណ Azure។ រត់ពីថតមូឌុល (`01-introduction/`)៖

**Bash:**
```bash
cat ../.env  # គួរតែបង្ហាញ AZURE_OPENAI_ENDPOINT, API_KEY, DEPLOYMENT
```

**PowerShell:**
```powershell
Get-Content ..\.env  # គួរតែបង្ហាញ AZURE_OPENAI_ENDPOINT, API_KEY, DEPLOYMENT
```

**ចាប់ផ្តើមកម្មវិធី៖**

**ជម្រើស ១៖ ប្រើ Spring Boot Dashboard (ផ្នែកណែនាំសម្រាប់អ្នកប្រើ VS Code)**

Dev container រួមបញ្ចូលផ្នែកបន្ថែម Spring Boot Dashboard ដែលផ្តល់អន្តរកម្មមើលគ្រប់គ្រងកម្មវិធី Spring Boot ទាំងអស់។ អ្នកអាចស្វែងរកវានៅ Activity Bar ផ្នែកខាងឆ្វេងនៃ VS Code (មើលរូបតំណាង Spring Boot)។

ពី Spring Boot Dashboard អ្នកអាច៖  
- មើលកម្មវិធី Spring Boot ទាំងអស់ក្នុង workspace  
- ចាប់ផ្តើម/បញ្ឈប់កម្មវិធីដោយចុចប៊ូតុងតែមួយ  
- មើលកំណត់ហេតុកម្មវិធីពេលវេលាពិត  
- ត្រួតពិនិត្យស្ថានភាពកម្មវិធី

គ្រាន់តែក្លិចប៊ូតុង play នៅជាប់នឹង "introduction" ដើម្បីចាប់ផ្តើមមូឌុលនេះ ឬចាប់ផ្តើមមូឌុលទាំងអស់ម្តង។

<img src="../../../translated_images/km/dashboard.69c7479aef09ff6b.webp" alt="Spring Boot Dashboard" width="400"/>

*Spring Boot Dashboard ក្នុង VS Code — ចាប់ផ្តើម បញ្ឈប់ និងត្រួតពិនិត្យមូឌុលទាំងអស់ពីកន្លែងតែមួយ*

**ជម្រើស ២៖ ប្រើ shell scripts**

ចាប់ផ្តើមកម្មវិធីវេបទាំងអស់ (មូឌុល 01-04):

**Bash:**
```bash
cd ..  # ពីថតគ្រប់គ្រាន់
./start-all.sh
```

**PowerShell:**
```powershell
cd ..  # ពីថតដើម
.\start-all.ps1
```

ឬចាប់ផ្តើមតែម្ដងមូឌុលនេះ៖

**Bash:**
```bash
cd 01-introduction
./start.sh
```

**PowerShell:**
```powershell
cd 01-introduction
.\start.ps1
```

Script ទាំងពីរនឹងផ្ទុកអថេរបរិយាកាសពីឯកសារ `.env` នៅថតដើម និងនឹងសង់ JAR ប្រសិនមិនមានមានរួច។

> **កំណត់ចំណាំ:** ប្រសិនអ្នកចង់សាងសង់មូឌុលទាំងអស់ដោយដៃមុនចាប់ផ្តើម៖  
>
> **Bash:**
> ```bash
> cd ..  # Go to root directory
> mvn clean package -DskipTests
> ```
>
> **PowerShell:**
> ```powershell
> cd ..  # Go to root directory
> mvn clean package -DskipTests
> ```

បើក http://localhost:8080 នៅក្នុងកម្មវិធីរុករករបស់អ្នក។

**ដើម្បីបញ្ឈប់៖**

**Bash:**
```bash
./stop.sh  # ម៉ូឌុលនេះតែប៉ុណ្ណោះ
# ឬ
cd .. && ./stop-all.sh  # ម៉ូឌុលទាំងអស់
```

**PowerShell:**
```powershell
.\stop.ps1  # ម៉ូឌុលនេះតែប៉ុណ្ណោះ
# ឬ
cd ..; .\stop-all.ps1  # ម៉ូឌុលទាំងអស់
```


## ការប្រើកម្មវិធី

កម្មវិធីផ្តល់អ៊ីនធរណេតមុខមាត់ជាមួយការអនុវត្តសន្ទនាពីរជាប់ផ្សេងគ្នា។

<img src="../../../translated_images/km/home-screen.121a03206ab910c0.webp" alt="Application Home Screen" width="800"/>

*ផ្ទាំង Dashboard បង្ហាញទាំង Simple Chat (stateless) និង Conversational Chat (stateful)*

### Stateless Chat (ផ្នែកឆ្វេង)

សាកល្បងនេះជាមុន។ សួរ "ខ្ញុំឈ្មោះ John" ហើយភ្លាមៗសួរ "ឈ្មោះខ្ញុំជាអ្វី?" ម៉ូឌែលមិនចងចាំព្រោះរាល់សារ គឺឯករាជ្យ។ នេះបង្ហាញបញ្ហាចម្បងនៃការចងក្រងម៉ូឌែលភាសាមិនមាន context។

<img src="../../../translated_images/km/simple-chat-stateless-demo.13aeb3978eab3234.webp" alt="Stateless Chat Demo" width="800"/>

*AI មិនចងចាំឈ្មោះអ្នកពីសារមុនទេ*

### Stateful Chat (ផ្នែកស្តាំ)

ឥឡូវនេះសាកល្បងជាដើមដូចគ្នានៅទីនេះ។ សួរ "ខ្ញុំឈ្មោះ John" ហើយបន្ទាប់មក "ឈ្មោះខ្ញុំជាអ្វី?" ពេលនេះវាចងចាំបាន។ ភាពខុសគ្នាគឺ MessageWindowChatMemory - វាត្រូវបានរក្សាប្រវត្តិការសន្ទនា និងរួមបញ្ចូលជាមួយរាល់សំណើ។ នេះជារបៀបដែល AI សន្ទនាកម្មវិធីផលិតកម្មដំណើរការ។

<img src="../../../translated_images/km/conversational-chat-stateful-demo.e5be9822eb23ff59.webp" alt="Stateful Chat Demo" width="800"/>

*AI ចងចាំឈ្មោះអ្នកពីការសន្ទនាមុន*

ផ្ទាំងទាំងពីរប្រើម៉ូឌែលតែមួយ GPT-5.2។ ភាពខុសគ្នាគឺមេម៉ូរី។ នេះធ្វើឲ្យច្បាស់ថាមេម៉ូរីផ្តល់អ្វីដល់កម្មវិធីរបស់អ្នក និងម៉េចវាសំខាន់សម្រាប់ករណីប្រើប្រាស់ពិតប្រាកដ។

## ជំហានបន្ទាប់

**មូឌុលបន្ទាប់៖** [02-prompt-engineering - ការបង្កើត Prompt ជាមួយ GPT-5.2](../02-prompt-engineering/README.md)

---

**ចុះទៅក្រោយ៖** [← ត្រឡប់ទៅទំព័រចម្បង](../README.md) | [បន្ទាប់៖ មូឌុល 02 - ការបង្កើត Prompt →](../02-prompt-engineering/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:
ឯកសារនេះត្រូវបានបម្លែងភាសា ដោយប្រើសេវាបម្លែងភាសា AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ទោះយើងខ្ញុំមានក្តីប្រាថ្នាឱ្យបានច្បាស់លាស់ តែសូមយល់ដឹងថាការបម្លែងដោយស្វ័យប្រវត្តិក៏អាចមានកំហុសឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមជាភាសាទីតាំងគួរត្រូវបានគេប្រើជាប្រភពច្បាស់លាស់។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមណែនាំឱ្យប្រើប្រាស់ការប្រែដោយមនុស្សជំនាញ។ យើងខ្ញុំមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការបកស្រាយខុសបន្ទាប់ពីការប្រើប្រាស់ការបម្លែងនេះនោះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->