# Kamus Istilah LangChain4j

## Jadual Kandungan

- [Konsep Teras](#konsep-teras)
- [Komponen LangChain4j](#komponen-langchain4j)
- [Konsep AI/ML](#konsep-aiml)
- [Penjagaan Keselamatan](#penjagaan-keselamatan)
- [Kejuruteraan Prompt](#prompt-engineering---module-02)
- [RAG (Penjanaan Diperkuatkan Pengambilan)](#rag-retrieval-augmented-generation---module-03)
- [Ejen dan Alat](#agents-and-tools---module-04)
- [Modul Agentic](#agentic-module---module-05)
- [Protokol Konteks Model (MCP)](#model-context-protocol-mcp---module-05)
- [Perkhidmatan Azure](#azure-services---module-01)
- [Ujian dan Pembangunan](#testing-and-development---testing-guide)

Rujukan pantas untuk istilah dan konsep yang digunakan sepanjang kursus.

## Konsep Teras

**Ejen AI** - Sistem yang menggunakan AI untuk berfikir dan bertindak secara autonomi. [Modul 04](../04-tools/README.md)

**Rantaian** - Urutan operasi di mana output menjadi input untuk langkah seterusnya.

**Penggubahan** - Memecahkan dokumen kepada bahagian yang lebih kecil. Biasa: 300-500 token dengan pertindihan. [Modul 03](../03-rag/README.md)

**Tetingkap Konteks** - Maksimum token yang model boleh proses. GPT-5.2: 400K token (sehingga 272K input, 128K output).

**Penyerlahan** - Vektor berangka yang mewakili maksud teks. [Modul 03](../03-rag/README.md)

**Panggilan Fungsi** - Model menghasilkan permintaan berstruktur untuk memanggil fungsi luar. [Modul 04](../04-tools/README.md)

**Halusinasi** - Apabila model menghasilkan maklumat yang salah tetapi nampak munasabah.

**Prompt** - Input teks kepada model bahasa. [Modul 02](../02-prompt-engineering/README.md)

**Carian Semantik** - Carian berdasarkan maksud menggunakan penyerlahan, bukan kata kunci. [Modul 03](../03-rag/README.md)

**Berdepan Status vs Tanpa Status** - Stateless: tiada memori. Stateful: mengekalkan sejarah perbualan. [Modul 01](../01-introduction/README.md)

**Token** - Unit asas teks yang model proses. Mempengaruhi kos dan had. [Modul 01](../01-introduction/README.md)

**Rantaian Alat** - Pelaksanaan alat secara berurutan di mana output memaklumkan panggilan seterusnya. [Modul 04](../04-tools/README.md)

## Komponen LangChain4j

**AiServices** - Mencipta antara muka perkhidmatan AI jenis-selamat.

**OpenAiOfficialChatModel** - Klien bersatu untuk model OpenAI dan Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Mencipta penyerlahan menggunakan klien rasmi OpenAI (menyokong OpenAI dan Azure OpenAI).

**ChatModel** - Antara muka teras untuk model bahasa.

**ChatMemory** - Mengekalkan sejarah perbualan.

**ContentRetriever** - Mencari bahagian dokumen yang berkaitan untuk RAG.

**DocumentSplitter** - Memecahkan dokumen kepada bahagian.

**EmbeddingModel** - Menukar teks kepada vektor berangka.

**EmbeddingStore** - Menyimpan dan mengambil penyerlahan.

**MessageWindowChatMemory** - Mengekalkan tetingkap gelangsar mesej terkini.

**PromptTemplate** - Mencipta prompt boleh guna semula dengan tempat letak `{{variable}}`.

**TextSegment** - Segmen teks dengan metadata. Digunakan dalam RAG.

**ToolExecutionRequest** - Mewakili permintaan pelaksanaan alat.

**UserMessage / AiMessage / SystemMessage** - Jenis mesej perbualan.

## Konsep AI/ML

**Pembelajaran Few-Shot** - Memberikan contoh dalam prompt. [Modul 02](../02-prompt-engineering/README.md)

**Model Bahasa Besar (LLM)** - Model AI yang dilatih menggunakan data teks yang sangat banyak.

**Usaha Penalaran** - Parameter GPT-5.2 yang mengawal kedalaman pemikiran. [Modul 02](../02-prompt-engineering/README.md)

**Suhu** - Mengawal kebarangkalian output. Rendah=deterministik, tinggi=kreatif.

**Pangkalan Data Vektor** - Pangkalan data khusus untuk penyerlahan. [Modul 03](../03-rag/README.md)

**Pembelajaran Zero-Shot** - Melaksanakan tugasan tanpa contoh. [Modul 02](../02-prompt-engineering/README.md)

## Penjagaan Keselamatan

**Pertahanan Berlapis** - Pendekatan keselamatan berbilang lapisan menggabungkan penjagaan di peringkat aplikasi dengan penapis keselamatan penyedia.

**Halangan Keras** - Penyedia mengembalikan ralat HTTP 400 untuk pelanggaran kandungan yang serius.

**InputGuardrail** - Antara muka LangChain4j untuk mengesahkan input pengguna sebelum sampai ke LLM. Menjimatkan kos dan kelewatan dengan menyekat prompt berbahaya awal.

**InputGuardrailResult** - Jenis pulangan untuk pengesahan penjagaan: `success()` atau `fatal("reason")`.

**OutputGuardrail** - Antara muka untuk mengesahkan respons AI sebelum dikembalikan kepada pengguna.

**Penapis Keselamatan Penyedia** - Penapis kandungan terbina dalam dari penyedia AI (contohnya, Azure OpenAI) yang mengesan pelanggaran di peringkat API.

**Penolakan Lembut** - Model dengan sopan enggan menjawab tanpa menghasilkan ralat.

## Kejuruteraan Prompt - [Modul 02](../02-prompt-engineering/README.md)

**Rantaian Pemikiran** - Penalaran langkah demi langkah untuk ketepatan lebih baik.

**Output Terhad** - Menguatkuasakan format atau struktur tertentu.

**Semangat Tinggi** - Corak GPT-5.2 untuk penalaran teliti.

**Semangat Rendah** - Corak GPT-5.2 untuk jawapan pantas.

**Perbualan Berbilang Giliran** - Mengekalkan konteks merentas pertukaran.

**Prompt berdasarkan Peranan** - Menetapkan persona model melalui mesej sistem.

**Refleksi Diri** - Model menilai dan memperbaiki outputnya.

**Analisis Berstruktur** - Rangka kerja penilaian tetap.

**Corak Pelaksanaan Tugasan** - Rancang → Laksanakan → Rumus.

## RAG (Penjanaan Diperkuatkan Pengambilan) - [Modul 03](../03-rag/README.md)

**Saluran Pemprosesan Dokumen** - Muat → pecah → serlah → simpan.

**Kedai Penyerlahan Dalam-Memori** - Penyimpanan tidak kekal untuk ujian.

**RAG** - Menggabungkan pengambilan dengan penjanaan untuk mendasari jawapan.

**Skor Kesamaan** - Ukuran (0-1) kesamaan semantik.

**Rujukan Sumber** - Metadata tentang kandungan yang diperoleh.

## Ejen dan Alat - [Modul 04](../04-tools/README.md)

**@Tool Annotation** - Menandakan kaedah Java sebagai alat boleh panggil AI.

**Corak ReAct** - Berfikir → Bertindak → Perhatikan → Ulang.

**Pengurusan Sesi** - Konteks berasingan untuk pengguna berlainan.

**Alat** - Fungsi yang boleh dipanggil oleh ejen AI.

**Deskripsi Alat** - Dokumentasi tujuan dan parameter alat.

## Modul Agentic - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** - Menandakan antara muka sebagai ejen AI dengan definisi tingkah laku deklaratif.

**Pendengar Ejen** - Hook untuk memantau pelaksanaan ejen melalui `beforeAgentInvocation()` dan `afterAgentInvocation()`.

**Skop Agentic** - Memori bersama di mana ejen menyimpan hasil menggunakan `outputKey` untuk digunakan oleh ejen seterusnya.

**AgenticServices** - Kilang untuk mencipta ejen menggunakan `agentBuilder()` dan `supervisorBuilder()`.

**Aliran Kerja Bersyarat** - Laluan berdasarkan syarat kepada ejen pakar yang berbeza.

**Manusia dalam Gelung** - Corak aliran kerja menambah titik semak manusia untuk kelulusan atau semakan kandungan.

**langchain4j-agentic** - Kebergantungan Maven untuk binaan ejen deklaratif (eksperimen).

**Aliran Kerja Gelung** - Ulang pelaksanaan ejen sehingga syarat dipenuhi (contoh: skor kualiti ≥ 0.8).

**outputKey** - Parameter anotasi ejen yang menentukan tempat penyimpanan hasil dalam Skop Agentic.

**Aliran Kerja Selari** - Jalankan pelbagai ejen serentak untuk tugasan bebas.

**Strategi Respons** - Cara penyelia merumus jawapan akhir: TERAKHIR, RINGKASAN, atau BERI SKOR.

**Aliran Kerja Berurutan** - Laksanakan ejen mengikut turutan di mana output mengalir ke langkah seterusnya.

**Corak Ejen Penyelia** - Corak agentic lanjutan di mana LLM penyelia memutuskan secara dinamik ejen sub mana yang dipanggil.

## Protokol Konteks Model (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Kebergantungan Maven untuk integrasi MCP dalam LangChain4j.

**MCP** - Protokol Konteks Model: piawaian untuk menyambungkan aplikasi AI ke alat luaran. Bina sekali, guna di mana-mana.

**Klien MCP** - Aplikasi yang menyambung ke pelayan MCP untuk mencari dan menggunakan alat.

**Pelayan MCP** - Perkhidmatan yang mendedahkan alat melalui MCP dengan deskripsi jelas dan skema parameter.

**McpToolProvider** - Komponen LangChain4j yang membungkus alat MCP untuk digunakan dalam perkhidmatan AI dan ejen.

**McpTransport** - Antara muka untuk komunikasi MCP. Implementasi termasuk Stdio dan HTTP.

**Pengangkutan Stdio** - Pengangkutan proses tempatan melalui stdin/stdout. Berguna untuk akses sistem fail atau alat baris perintah.

**StdioMcpTransport** - Implementasi LangChain4j yang memulakan pelayan MCP sebagai subproses.

**Penemuan Alat** - Klien membuat pertanyaan kepada pelayan untuk alat yang tersedia dengan deskripsi dan skema.

## Perkhidmatan Azure - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Carian awan dengan keupayaan vektor. [Modul 03](../03-rag/README.md)

**CLI Pembangun Azure (azd)** - Melaksanakan sumber Azure.

**Azure OpenAI** - Perkhidmatan AI perusahaan Microsoft.

**Bicep** - Bahasa infrastruktur sebagai kod Azure. [Panduan Infrastruktur](../01-introduction/infra/README.md)

**Nama Pelaksanaan** - Nama bagi pelaksanaan model dalam Azure.

**GPT-5.2** - Model OpenAI terkini dengan kawalan penalaran. [Modul 02](../02-prompt-engineering/README.md)

## Ujian dan Pembangunan - [Panduan Ujian](TESTING.md)

**Kontena Dev** - Persekitaran pembangunan berkontena. [Konfigurasi](../../../.devcontainer/devcontainer.json)

**Ujian Dalam-Memori** - Ujian dengan penyimpanan dalam memori.

**Ujian Integrasi** - Ujian dengan infrastruktur sebenar.

**Maven** - Alat automasi binaan Java.

**Mockito** - Rangka kerja pemalsuan Java.

**Spring Boot** - Rangka kerja aplikasi Java. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Penafian**:
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk ketepatan, sila ambil maklum bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang sahih. Untuk maklumat penting, terjemahan oleh manusia profesional adalah disyorkan. Kami tidak bertanggungjawab terhadap sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->