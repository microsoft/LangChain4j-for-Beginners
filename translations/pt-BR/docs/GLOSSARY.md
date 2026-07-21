# Glossário LangChain4j

## Índice

- [Conceitos Básicos](#conceitos-básicos)
- [Componentes do LangChain4j](#componentes-do-langchain4j)
- [Conceitos de IA/ML](#conceitos-de-iaml)
- [Guardrails](#guardrails)
- [Engenharia de Prompt](#prompt-engineering---module-02)
- [RAG (Geração com Recuperação)](#rag-retrieval-augmented-generation---module-03)
- [Agentes e Ferramentas](#agents-and-tools---module-04)
- [Módulo Agentic](#agentic-module---module-05)
- [Protocolo de Contexto de Modelo (MCP)](#model-context-protocol-mcp---module-05)
- [Serviços Azure](#azure-services---module-01)
- [Teste e Desenvolvimento](#testing-and-development---testing-guide)

Referência rápida para termos e conceitos usados ao longo do curso.

## Conceitos Básicos

**Agente de IA** - Sistema que usa IA para raciocinar e agir de forma autônoma. [Módulo 04](../04-tools/README.md)

**Chain** - Sequência de operações onde a saída alimenta a próxima etapa.

**Chunking** - Dividir documentos em pedaços menores. Típico: 300-500 tokens com sobreposição. [Módulo 03](../03-rag/README.md)

**Janela de Contexto** - Máximo de tokens que um modelo pode processar. GPT-5.2: 400K tokens (até 272K entrada, 128K saída).

**Embeddings** - Vetores numéricos representando o significado do texto. [Módulo 03](../03-rag/README.md)

**Chamada de Função** - O modelo gera solicitações estruturadas para chamar funções externas. [Módulo 04](../04-tools/README.md)

**Alucinação** - Quando modelos geram informações incorretas mas plausíveis.

**Prompt** - Texto de entrada para um modelo de linguagem. [Módulo 02](../02-prompt-engineering/README.md)

**Busca Semântica** - Busca por significado usando embeddings, não palavras-chave. [Módulo 03](../03-rag/README.md)

**Com Estado vs Sem Estado** - Sem estado: sem memória. Com estado: mantém histórico de conversação. [Módulo 01](../01-introduction/README.md)

**Tokens** - Unidades básicas de texto que modelos processam. Afeta custos e limites. [Módulo 01](../01-introduction/README.md)

**Encadeamento de Ferramentas** - Execução sequencial de ferramentas onde saída informa a próxima chamada. [Módulo 04](../04-tools/README.md)

## Componentes do LangChain4j

**AiServices** - Cria interfaces de serviços de IA com tipagem segura.

**OpenAiOfficialChatModel** - Cliente unificado para modelos OpenAI e Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Cria embeddings usando cliente oficial OpenAI (suporta OpenAI e Azure OpenAI).

**ChatModel** - Interface principal para modelos de linguagem.

**ChatMemory** - Mantém o histórico de conversação.

**ContentRetriever** - Encontra pedaços relevantes de documentos para RAG.

**DocumentSplitter** - Divide documentos em pedaços.

**EmbeddingModel** - Converte texto em vetores numéricos.

**EmbeddingStore** - Armazena e recupera embeddings.

**MessageWindowChatMemory** - Mantém uma janela deslizante das mensagens recentes.

**PromptTemplate** - Cria prompts reutilizáveis com placeholders `{{variable}}`.

**TextSegment** - Pedaço de texto com metadados. Usado no RAG.

**ToolExecutionRequest** - Representa uma solicitação de execução de ferramenta.

**UserMessage / AiMessage / SystemMessage** - Tipos de mensagens na conversação.

## Conceitos de IA/ML

**Few-Shot Learning** - Fornecer exemplos em prompts. [Módulo 02](../02-prompt-engineering/README.md)

**Modelo de Linguagem Grande (LLM)** - Modelos de IA treinados com grandes volumes de texto.

**Esforço de Raciocínio** - Parâmetro do GPT-5.2 que controla profundidade do raciocínio. [Módulo 02](../02-prompt-engineering/README.md)

**Temperatura** - Controla a aleatoriedade da saída. Baixa=determinístico, alta=criativo.

**Banco de Dados Vetorial** - Banco especializado para embeddings. [Módulo 03](../03-rag/README.md)

**Zero-Shot Learning** - Realizar tarefas sem exemplos. [Módulo 02](../02-prompt-engineering/README.md)

## Guardrails

**Defesa em Profundidade** - Abordagem de segurança em múltiplas camadas combinando guardrails no nível da aplicação com filtros de segurança do provedor.

**Bloqueio Rígido** - Provedor retorna erro HTTP 400 para violações graves de conteúdo.

**InputGuardrail** - Interface LangChain4j para validar entrada do usuário antes de chegar ao LLM. Economiza custo e latência bloqueando prompts prejudiciais antecipadamente.

**InputGuardrailResult** - Tipo de retorno para validação de guardrails: `success()` ou `fatal("reason")`.

**OutputGuardrail** - Interface para validar respostas da IA antes de retorná-las aos usuários.

**Filtros de Segurança do Provedor** - Filtros embutidos de conteúdo dos provedores de IA (ex: Azure OpenAI) que detectam violações na camada da API.

**Recusa Suave** - Modelo recusa educadamente responder sem retornar erro.

## Engenharia de Prompt - [Módulo 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - Raciocínio passo a passo para maior precisão.

**Saída Constrainada** - Imposição de formato ou estrutura específicos.

**Alta Disposição** - Padrão GPT-5.2 para raciocínio aprofundado.

**Baixa Disposição** - Padrão GPT-5.2 para respostas rápidas.

**Conversa Multi-Turn** - Manter contexto entre trocas.

**Prompting Baseado em Papel** - Configurar persona do modelo via mensagens do sistema.

**Autorreflexão** - Modelo avalia e melhora sua própria saída.

**Análise Estruturada** - Framework fixo de avaliação.

**Padrão de Execução de Tarefa** - Planejar → Executar → Resumir.

## RAG (Geração com Recuperação) - [Módulo 03](../03-rag/README.md)

**Pipeline de Processamento de Documento** - Carregar → chunk → embed → armazenar.

**Armazenamento de Embeddings em Memória** - Armazenamento não persistente para testes.

**RAG** - Combina recuperação com geração para fundamentar respostas.

**Score de Similaridade** - Medida (0-1) de similaridade semântica.

**Referência de Fonte** - Metadados sobre conteúdo recuperado.

## Agentes e Ferramentas - [Módulo 04](../04-tools/README.md)

**Anotação @Tool** - Marca métodos Java como ferramentas acessíveis pela IA.

**Padrão ReAct** - Raciocinar → Agir → Observar → Repetir.

**Gerenciamento de Sessão** - Contextos separados para usuários diferentes.

**Tool** - Função que um agente de IA pode chamar.

**Descrição da Ferramenta** - Documentação do propósito e parâmetros da ferramenta.

## Módulo Agentic - [Módulo 05](../05-mcp/README.md)

**Anotação @Agent** - Marca interfaces como agentes de IA com definição declarativa de comportamento.

**Agent Listener** - Gancho para monitorar execução do agente via `beforeAgentInvocation()` e `afterAgentInvocation()`.

**Agentic Scope** - Memória compartilhada onde agentes armazenam saídas usando `outputKey` para consumo por agentes seguintes.

**AgenticServices** - Fábrica para criação de agentes usando `agentBuilder()` e `supervisorBuilder()`.

**Fluxo Condicional** - Roteamento baseado em condições para agentes especialistas diferentes.

**Human-in-the-Loop** - Padrão de workflow adicionando pontos de aprovação humana ou revisão de conteúdo.

**langchain4j-agentic** - Dependência Maven para construção declarativa de agentes (experimental).

**Loop Workflow** - Iterar execução do agente até condição ser atendida (ex: score de qualidade ≥ 0.8).

**outputKey** - Parâmetro da anotação do agente que especifica onde resultados são armazenados no Agentic Scope.

**Parallel Workflow** - Executar vários agentes simultaneamente para tarefas independentes.

**Estratégia de Resposta** - Como o supervisor formula a resposta final: LAST, SUMMARY ou SCORED.

**Sequential Workflow** - Executar agentes em ordem onde saída flui para próximo passo.

**Padrão de Supervisor Agent** - Padrão agentic avançado onde um supervisor LLM decide dinamicamente quais subagentes invocar.

## Protocolo de Contexto de Modelo (MCP) - [Módulo 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependência Maven para integração MCP no LangChain4j.

**MCP** - Protocolo de Contexto de Modelo: padrão para conectar apps de IA a ferramentas externas. Construir uma vez, usar em todo lugar.

**Cliente MCP** - Aplicação que conecta a servidores MCP para descobrir e usar ferramentas.

**Servidor MCP** - Serviço que expõe ferramentas via MCP com descrições claras e esquemas de parâmetros.

**McpToolProvider** - Componente LangChain4j que encapsula ferramentas MCP para uso em serviços e agentes de IA.

**McpTransport** - Interface para comunicação MCP. Implementações incluem Stdio e HTTP.

**Transporte Stdio** - Transporte local via stdin/stdout. Útil para acesso a sistema de arquivos ou ferramentas de linha de comando.

**StdioMcpTransport** - Implementação LangChain4j que inicia servidor MCP como subprocesso.

**Descoberta de Ferramentas** - Cliente consulta servidor para ferramentas disponíveis com descrições e esquemas.

## Serviços Azure - [Módulo 01](../01-introduction/README.md)

**Azure AI Search** - Busca em nuvem com capacidades vetoriais. [Módulo 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Ferramenta para deploy de recursos Azure.

**Azure OpenAI** - Serviço de IA empresarial da Microsoft.

**Bicep** - Linguagem de infraestrutura como código para Azure. [Guia de Infraestrutura](../01-introduction/infra/README.md)

**Nome do Deployment** - Nome para implantação de modelo no Azure.

**GPT-5.2** - Último modelo da OpenAI com controle de raciocínio. [Módulo 02](../02-prompt-engineering/README.md)

## Teste e Desenvolvimento - [Guia de Testes](TESTING.md)

**Dev Container** - Ambiente de desenvolvimento conteinerizado. [Configuração](../../../.devcontainer/devcontainer.json)

**Teste em Memória** - Testes com armazenamento em memória.

**Teste de Integração** - Testes com infraestrutura real.

**Maven** - Ferramenta de automação de build Java.

**Mockito** - Framework de mocks Java.

**Spring Boot** - Framework para aplicações Java. [Módulo 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Aviso Legal**:
Este documento foi traduzido usando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, por favor, esteja ciente de que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte autorizada. Para informações críticas, recomenda-se tradução profissional humana. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->