# Glosarium LangChain4j

## Daftar Isi

- [Konsep Inti](#konsep-inti)
- [Komponen LangChain4j](#komponen-langchain4j)
- [Konsep AI/ML](#konsep-aiml)
- [Guardrails](#guardrails)
- [Rekayasa Prompt](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [Agen dan Alat](#agents-and-tools---module-04)
- [Modul Agentic](#agentic-module---module-05)
- [Protokol Konteks Model (MCP)](#model-context-protocol-mcp---module-05)
- [Layanan Azure](#azure-services---module-01)
- [Pengujian dan Pengembangan](#testing-and-development---testing-guide)

Referensi cepat untuk istilah dan konsep yang digunakan sepanjang kursus.

## Konsep Inti

**Agen AI** - Sistem yang menggunakan AI untuk bernalar dan bertindak secara otonom. [Modul 04](../04-tools/README.md)

**Rantai** - Urutan operasi di mana keluaran menjadi masukan langkah berikutnya.

**Pengchunkan** - Memecah dokumen menjadi potongan-potongan lebih kecil. Umum: 300-500 token dengan tumpang tindih. [Modul 03](../03-rag/README.md)

**Jendela Konteks** - Jumlah token maksimum yang dapat diproses model. GPT-5.2: 400K token (hingga 272K masukan, 128K keluaran).

**Embedding** - Vektor numerik yang merepresentasikan makna teks. [Modul 03](../03-rag/README.md)

**Pemanggilan Fungsi** - Model menghasilkan permintaan terstruktur untuk memanggil fungsi eksternal. [Modul 04](../04-tools/README.md)

**Halusinasi** - Ketika model menghasilkan informasi yang salah namun masuk akal.

**Prompt** - Input teks untuk model bahasa. [Modul 02](../02-prompt-engineering/README.md)

**Pencarian Semantik** - Pencarian berdasarkan makna menggunakan embedding, bukan kata kunci. [Modul 03](../03-rag/README.md)

**Stateful vs Stateless** - Stateless: tanpa memori. Stateful: mempertahankan riwayat percakapan. [Modul 01](../01-introduction/README.md)

**Token** - Unit dasar teks yang diproses model. Mempengaruhi biaya dan batasan. [Modul 01](../01-introduction/README.md)

**Rantai Alat** - Eksekusi alat secara berurutan di mana keluaran menjadi masukan berikutnya. [Modul 04](../04-tools/README.md)

## Komponen LangChain4j

**AiServices** - Membuat antarmuka layanan AI yang tipe-aman.

**OpenAiOfficialChatModel** - Klien terpadu untuk model OpenAI dan Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Membuat embedding menggunakan klien OpenAI Official (mendukung OpenAI dan Azure OpenAI).

**ChatModel** - Antarmuka inti untuk model bahasa.

**ChatMemory** - Mempertahankan riwayat percakapan.

**ContentRetriever** - Menemukan potongan dokumen relevan untuk RAG.

**DocumentSplitter** - Memecah dokumen menjadi potongan.

**EmbeddingModel** - Mengubah teks menjadi vektor numerik.

**EmbeddingStore** - Menyimpan dan mengambil embedding.

**MessageWindowChatMemory** - Menjaga jendela geser pesan terbaru.

**PromptTemplate** - Membuat prompt yang dapat digunakan ulang dengan placeholder `{{variable}}`.

**TextSegment** - Potongan teks dengan metadata. Digunakan dalam RAG.

**ToolExecutionRequest** - Mewakili permintaan eksekusi alat.

**UserMessage / AiMessage / SystemMessage** - Jenis pesan percakapan.

## Konsep AI/ML

**Few-Shot Learning** - Memberikan contoh di dalam prompt. [Modul 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Model AI yang dilatih pada data teks besar.

**Effort Penalaran** - Parameter GPT-5.2 yang mengatur kedalaman pemikiran. [Modul 02](../02-prompt-engineering/README.md)

**Temperature** - Mengatur tingkat randomness keluaran. Rendah=deterministik, tinggi=kreatif.

**Database Vektor** - Database khusus untuk embedding. [Modul 03](../03-rag/README.md)

**Zero-Shot Learning** - Melakukan tugas tanpa contoh. [Modul 02](../02-prompt-engineering/README.md)

## Guardrails

**Pertahanan Berlapis** - Pendekatan keamanan berlapis yang menggabungkan guardrails di tingkat aplikasi dengan filter keamanan penyedia.

**Blok Keras** - Penyedia mengeluarkan error HTTP 400 untuk pelanggaran konten berat.

**InputGuardrail** - Antarmuka LangChain4j untuk memvalidasi input pengguna sebelum mencapai LLM. Menghemat biaya dan latensi dengan memblokir prompt berbahaya sejak awal.

**InputGuardrailResult** - Tipe kembalian untuk validasi guardrail: `success()` atau `fatal("reason")`.

**OutputGuardrail** - Antarmuka untuk memvalidasi respons AI sebelum dikembalikan ke pengguna.

**Filter Keamanan Penyedia** - Filter konten bawaan dari penyedia AI (misal: Azure OpenAI) yang menangkap pelanggaran di tingkat API.

**Penolakan Lembut** - Model dengan sopan menolak menjawab tanpa menghasilkan error.

## Rekayasa Prompt - [Modul 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Penalaran langkah demi langkah untuk akurasi lebih baik.

**Keluaran Terbatas** - Menerapkan format atau struktur tertentu.

**Semangat Tinggi** - Pola GPT-5.2 untuk pemikiran mendalam.

**Semangat Rendah** - Pola GPT-5.2 untuk jawaban cepat.

**Percakapan Multi-Turn** - Mempertahankan konteks antar pertukaran.

**Prompt Berdasarkan Peran** - Menetapkan persona model via pesan sistem.

**Refleksi Diri** - Model mengevaluasi dan memperbaiki keluarannya.

**Analisis Terstruktur** - Kerangka evaluasi tetap.

**Pola Eksekusi Tugas** - Rencana → Jalankan → Ringkas.

## RAG (Retrieval-Augmented Generation) - [Modul 03](../03-rag/README.md)

**Pipeline Pemrosesan Dokumen** - Muat → potong → embedding → simpan.

**Penyimpanan Embedding In-Memory** - Penyimpanan non-persisten untuk pengujian.

**RAG** - Menggabungkan pengambilan dengan generasi untuk menguatkan respons.

**Skor Kemiripan** - Ukuran (0-1) kemiripan semantik.

**Referensi Sumber** - Metadata tentang konten yang diambil.

## Agen dan Alat - [Modul 04](../04-tools/README.md)

**@Tool Annotation** - Menandai metode Java sebagai alat yang dapat dipanggil AI.

**Pola ReAct** - Bernalar → Bertindak → Mengamati → Ulang.

**Manajemen Sesi** - Konteks terpisah untuk pengguna berbeda.

**Alat** - Fungsi yang dapat dipanggil agen AI.

**Deskripsi Alat** - Dokumentasi tujuan dan parameter alat.

## Modul Agentic - [Modul 05](../05-mcp/README.md)

**@Agent Annotation** - Menandai antarmuka sebagai agen AI dengan definisi perilaku deklaratif.

**Agent Listener** - Hook untuk memantau eksekusi agen melalui `beforeAgentInvocation()` dan `afterAgentInvocation()`.

**Agentic Scope** - Memori bersama tempat agen menyimpan keluaran menggunakan `outputKey` untuk dikonsumsi agen lain.

**AgenticServices** - Pabrik pembuatan agen menggunakan `agentBuilder()` dan `supervisorBuilder()`.

**Alur Kerja Bersyarat** - Pengarahan berdasarkan kondisi ke agen spesialis berbeda.

**Manusia dalam Loop** - Pola alur kerja menambahkan titik pemeriksaan manusia untuk persetujuan atau peninjauan konten.

**langchain4j-agentic** - Dependensi Maven untuk pembangunan agen deklaratif (eksperimental).

**Alur Kerja Loop** - Iterasi eksekusi agen sampai kondisi terpenuhi (misal: skor kualitas ≥ 0.8).

**outputKey** - Parameter anotasi agen yang menentukan tempat penyimpanan hasil di Agentic Scope.

**Alur Kerja Paralel** - Menjalankan beberapa agen secara bersamaan untuk tugas independen.

**Strategi Respons** - Cara supervisor merumuskan jawaban akhir: LAST, SUMMARY, atau SCORED.

**Alur Kerja Berurutan** - Menjalankan agen secara urut di mana keluaran mengalir ke langkah berikutnya.

**Pola Agen Supervisor** - Pola agentic lanjutan di mana LLM supervisor secara dinamis memutuskan sub-agen mana yang dipanggil.

## Protokol Konteks Model (MCP) - [Modul 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependensi Maven untuk integrasi MCP dalam LangChain4j.

**MCP** - Model Context Protocol: standar untuk menghubungkan aplikasi AI ke alat eksternal. Bangun sekali, gunakan di mana-mana.

**Klien MCP** - Aplikasi yang terhubung ke server MCP untuk menemukan dan menggunakan alat.

**Server MCP** - Layanan yang mengekspos alat lewat MCP dengan deskripsi jelas dan skema parameter.

**McpToolProvider** - Komponen LangChain4j yang membungkus alat MCP untuk dipakai dalam layanan dan agen AI.

**McpTransport** - Antarmuka untuk komunikasi MCP. Implementasi meliputi Stdio dan HTTP.

**Transport Stdio** - Transport proses lokal lewat stdin/stdout. Berguna untuk akses sistem berkas atau alat baris perintah.

**StdioMcpTransport** - Implementasi LangChain4j yang menjalankan server MCP sebagai subprocess.

**Penemuan Alat** - Klien menanyakan server tentang alat tersedia berikut deskripsi dan skema.

## Layanan Azure - [Modul 01](../01-introduction/README.md)

**Azure AI Search** - Pencarian awan dengan kapabilitas vektor. [Modul 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Mendeploy sumber daya Azure.

**Azure OpenAI** - Layanan AI perusahaan Microsoft.

**Bicep** - Bahasa infrastruktur sebagai kode Azure. [Panduan Infrastruktur](../01-introduction/infra/README.md)

**Nama Deployment** - Nama untuk deployment model di Azure.

**GPT-5.2** - Model OpenAI terbaru dengan kontrol penalaran. [Modul 02](../02-prompt-engineering/README.md)

## Pengujian dan Pengembangan - [Panduan Pengujian](TESTING.md)

**Dev Container** - Lingkungan pengembangan containerized. [Konfigurasi](../../../.devcontainer/devcontainer.json)

**Pengujian In-Memory** - Pengujian dengan penyimpanan in-memory.

**Pengujian Integrasi** - Pengujian dengan infrastruktur nyata.

**Maven** - Alat otomatisasi build Java.

**Mockito** - Framework mocking Java.

**Spring Boot** - Framework aplikasi Java. [Modul 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Penafian**:
Dokumen ini telah diterjemahkan menggunakan layanan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berupaya untuk mencapai akurasi, harap diketahui bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang sah. Untuk informasi penting, disarankan menggunakan terjemahan profesional oleh manusia. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang keliru yang timbul dari penggunaan terjemahan ini.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->