# Glossário LangChain4j

## Índice

- [Conceitos Principais](#conceitos-principais)
- [Componentes LangChain4j](#componentes-langchain4j)
- [Conceitos AI/ML](#conceitos-aiml)
- [Guardrails](#guardrails)
- [Engenharia de Prompt](#prompt-engineering---module-02)
- [RAG (Geração Aumentada por Recuperação)](#rag-retrieval-augmented-generation---module-03)
- [Agentes e Ferramentas](#agents-and-tools---module-04)
- [Módulo Agente](#agentic-module---module-05)
- [Protocolo de Contexto do Modelo (MCP)](#model-context-protocol-mcp---module-05)
- [Serviços Azure](#azure-services---module-01)
- [Testes e Desenvolvimento](#testing-and-development---testing-guide)

Referência rápida para termos e conceitos usados ao longo do curso.

## Conceitos Principais

**Agente AI** - Sistema que usa AI para raciocinar e agir autonomamente. [Módulo 04](../04-tools/README.md)

**Cadeia** - Sequência de operações onde a saída alimenta o passo seguinte.

**Fragmentação** - Dividir documentos em pedaços menores. Típico: 300-500 tokens com sobreposição. [Módulo 03](../03-rag/README.md)

**Janela de Contexto** - Máximo de tokens que um modelo pode processar. GPT-5.2: 400K tokens (até 272K entrada, 128K saída).

**Embedding** - Vetores numéricos que representam o significado do texto. [Módulo 03](../03-rag/README.md)

**Chamada de Função** - Modelo gera pedidos estruturados para chamar funções externas. [Módulo 04](../04-tools/README.md)

**Alucinação** - Quando modelos geram informação incorreta mas plausível.

**Prompt** - Texto de entrada para um modelo de linguagem. [Módulo 02](../02-prompt-engineering/README.md)

**Pesquisa Semântica** - Pesquisa por significado usando embeddings, não por palavras-chave. [Módulo 03](../03-rag/README.md)

**Com Estado vs Sem Estado** - Sem Estado: sem memória. Com Estado: mantém histórico da conversa. [Módulo 01](../01-introduction/README.md)

**Tokens** - Unidades básicas de texto que os modelos processam. Afetam custos e limites. [Módulo 01](../01-introduction/README.md)

**Encadeamento de Ferramentas** - Execução sequencial de ferramentas onde a saída informa a chamada seguinte. [Módulo 04](../04-tools/README.md)

## Componentes LangChain4j

**AiServices** - Cria interfaces de serviço AI com tipagem segura.

**OpenAiOfficialChatModel** - Cliente unificado para modelos OpenAI e Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Cria embeddings usando cliente oficial OpenAI (suporta OpenAI e Azure OpenAI).

**ChatModel** - Interface principal para modelos de linguagem.

**ChatMemory** - Mantém histórico de conversas.

**ContentRetriever** - Encontra fragmentos de documentos relevantes para RAG.

**DocumentSplitter** - Divide documentos em fragmentos.

**EmbeddingModel** - Converte texto em vetores numéricos.

**EmbeddingStore** - Armazena e recupera embeddings.

**MessageWindowChatMemory** - Mantém janela deslizante das mensagens recentes.

**PromptTemplate** - Cria prompts reutilizáveis com espaços reservados `{{variable}}`.

**TextSegment** - Fragmento de texto com metadados. Usado em RAG.

**ToolExecutionRequest** - Representa pedido de execução de ferramenta.

**UserMessage / AiMessage / SystemMessage** - Tipos de mensagens de conversa.

## Conceitos AI/ML

**Few-Shot Learning** - Fornecer exemplos nos prompts. [Módulo 02](../02-prompt-engineering/README.md)

**Modelo de Linguagem Grande (LLM)** - Modelos AI treinados com muitos dados textuais.

**Esforço de Raciocínio** - Parâmetro do GPT-5.2 que controla a profundidade do pensamento. [Módulo 02](../02-prompt-engineering/README.md)

**Temperatura** - Controla a aleatoriedade da saída. Baixa=determinística, alta=criativa.

**Base de Dados Vetorial** - Base de dados especializada para embeddings. [Módulo 03](../03-rag/README.md)

**Zero-Shot Learning** - Realizar tarefas sem exemplos. [Módulo 02](../02-prompt-engineering/README.md)

## Guardrails

**Defense in Depth** - Abordagem de segurança em múltiplas camadas combinando guardrails a nível de aplicação com filtros de segurança do fornecedor.

**Bloqueio Rígido** - Fornecedor emite erro HTTP 400 para violações graves de conteúdo.

**InputGuardrail** - Interface LangChain4j para validar entrada do utilizador antes de chegar ao LLM. Poupa custo e latência bloqueando prompts potencialmente prejudiciais antecipadamente.

**InputGuardrailResult** - Tipo de retorno para validação guardrail: `success()` ou `fatal("razão")`.

**OutputGuardrail** - Interface para validar respostas AI antes de serem enviadas aos utilizadores.

**Filtros de Segurança do Fornecedor** - Filtros integrados de conteúdo dos fornecedores AI (ex. Azure OpenAI) que capturam violações a nível da API.

**Recusa Suave** - Modelo recusa educadamente responder sem gerar erro.

## Engenharia de Prompt - [Módulo 02](../02-prompt-engineering/README.md)

**Cadeia de Pensamento** - Raciocínio passo-a-passo para maior precisão.

**Saída Constrainida** - Aplicar formato ou estrutura específica.

**Alto Entusiasmo** - Padrão GPT-5.2 para raciocínio rigoroso.

**Baixo Entusiasmo** - Padrão GPT-5.2 para respostas rápidas.

**Conversação Multi-Turno** - Manter contexto ao longo das trocas.

**Prompting Baseado em Papel** - Definir persona do modelo via mensagens do sistema.

**Autorreflexão** - Modelo avalia e melhora a sua saída.

**Análise Estruturada** - Estrutura fixa de avaliação.

**Padrão de Execução de Tarefas** - Planear → Executar → Resumir.

## RAG (Geração Aumentada por Recuperação) - [Módulo 03](../03-rag/README.md)

**Pipeline de Processamento de Documentos** - Carregar → fragmentar → inserir embeddings → armazenar.

**Armazenamento de Embeddings em Memória** - Armazenamento não persistente para testes.

**RAG** - Combina recuperação com geração para fundamentar respostas.

**Pontuação de Similaridade** - Medida (0-1) de similaridade semântica.

**Referência de Fonte** - Metadados sobre conteúdo recuperado.

## Agentes e Ferramentas - [Módulo 04](../04-tools/README.md)

**@Tool Annotation** - Marca métodos Java como ferramentas chamáveis por AI.

**Padrão ReAct** - Raciocinar → Agir → Observar → Repetir.

**Gestão de Sessão** - Contextos separados para diferentes utilizadores.

**Ferramenta** - Função que um agente AI pode chamar.

**Descrição da Ferramenta** - Documentação do propósito e parâmetros da ferramenta.

## Módulo Agente - [Módulo 05](../05-mcp/README.md)

**@Agent Annotation** - Marca interfaces como agentes AI com definição declarativa de comportamento.

**Agent Listener** - Hook para monitorar execução do agente via `beforeAgentInvocation()` e `afterAgentInvocation()`.

**Agentic Scope** - Memória partilhada onde agentes armazenam saídas usando `outputKey` para consumo por agentes a jusante.

**AgenticServices** - Fábrica para criar agentes usando `agentBuilder()` e `supervisorBuilder()`.

**Fluxo Condicional** - Roteamento baseado em condições para diferentes agentes especialistas.

**Humano no Loop** - Padrão de fluxo adicionando pontos de aprovação ou revisão humana.

**langchain4j-agentic** - Dependência Maven para construção declarativa de agentes (experimental).

**Fluxo em Ciclo** - Iterar execução do agente até uma condição ser satisfeita (ex: pontuação de qualidade ≥ 0.8).

**outputKey** - Parâmetro da anotação de agente que especifica onde guardar resultados no Agentic Scope.

**Fluxo Paralelo** - Executar múltiplos agentes simultaneamente para tarefas independentes.

**Estratégia de Resposta** - Como o supervisor formula resposta final: LAST, SUMMARY, ou SCORED.

**Fluxo Sequencial** - Executar agentes em ordem onde saída flui para o passo seguinte.

**Padrão Agente Supervisor** - Padrão agente avançado onde um LLM supervisor decide dinamicamente quais sub-agentes invocar.

## Protocolo de Contexto do Modelo (MCP) - [Módulo 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependência Maven para integração MCP em LangChain4j.

**MCP** - Modelo Context Protocol: padrão para conectar apps AI a ferramentas externas. Construa uma vez, use em todo lado.

**Cliente MCP** - Aplicação que conecta a servidores MCP para descobrir e usar ferramentas.

**Servidor MCP** - Serviço que expõe ferramentas via MCP com descrições claras e esquemas de parâmetros.

**McpToolProvider** - Componente LangChain4j que envolve ferramentas MCP para uso em serviços AI e agentes.

**McpTransport** - Interface para comunicação MCP. Implementações incluem Stdio e HTTP.

**Transporte Stdio** - Transporte de processo local via stdin/stdout. Útil para acesso a sistema de ficheiros ou ferramentas command-line.

**StdioMcpTransport** - Implementação LangChain4j que lança servidor MCP como subprocesso.

**Descoberta de Ferramentas** - Cliente pergunta servidor por ferramentas disponíveis com descrições e esquemas.

## Serviços Azure - [Módulo 01](../01-introduction/README.md)

**Azure AI Search** - Pesquisa cloud com capacidades vetoriais. [Módulo 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Implanta recursos Azure.

**Azure OpenAI** - Serviço AI empresarial da Microsoft.

**Bicep** - Linguagem de infraestrutura como código Azure. [Guia Infraestrutura](../01-introduction/infra/README.md)

**Nome da Implantação** - Nome para implantação de modelo no Azure.

**GPT-5.2** - Último modelo OpenAI com controlo de raciocínio. [Módulo 02](../02-prompt-engineering/README.md)

## Testes e Desenvolvimento - [Guia de Testes](TESTING.md)

**Dev Container** - Ambiente de desenvolvimento conteinerizado. [Configuração](../../../.devcontainer/devcontainer.json)

**Testes em Memória** - Testes com armazenamento em memória.

**Testes de Integração** - Testes com infraestrutura real.

**Maven** - Ferramenta de automação de build para Java.

**Mockito** - Framework de mocking para Java.

**Spring Boot** - Framework para aplicações Java. [Módulo 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Aviso Legal**:
Este documento foi traduzido utilizando o serviço de tradução automática [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autorizada. Para informações críticas, recomenda-se tradução profissional humana. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas resultantes da utilização desta tradução.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->