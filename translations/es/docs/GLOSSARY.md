# Glosario LangChain4j

## Tabla de Contenidos

- [Conceptos Fundamentales](#conceptos-fundamentales)
- [Componentes de LangChain4j](#componentes-de-langchain4j)
- [Conceptos de IA/ML](#conceptos-de-iaml)
- [Guardarraíles](#guardarraíles)
- [Ingeniería de Prompts](#prompt-engineering---module-02)
- [RAG (Generación Aumentada por Recuperación)](#rag-retrieval-augmented-generation---module-03)
- [Agentes y Herramientas](#agents-and-tools---module-04)
- [Módulo Agéntico](#agentic-module---module-05)
- [Protocolo de Contexto de Modelo (MCP)](#model-context-protocol-mcp---module-05)
- [Servicios de Azure](#azure-services---module-01)
- [Pruebas y Desarrollo](#testing-and-development---testing-guide)

Referencia rápida para términos y conceptos usados a lo largo del curso.

## Conceptos Fundamentales

**Agente de IA** - Sistema que usa IA para razonar y actuar de forma autónoma. [Módulo 04](../04-tools/README.md)

**Cadena** - Secuencia de operaciones donde la salida alimenta el siguiente paso.

**Segmentación** - Dividir documentos en partes más pequeñas. Típico: 300-500 tokens con superposición. [Módulo 03](../03-rag/README.md)

**Ventana de Contexto** - Máximo de tokens que un modelo puede procesar. GPT-5.2: 400K tokens (hasta 272K de entrada, 128K de salida).

**Embeddings** - Vectores numéricos que representan el significado del texto. [Módulo 03](../03-rag/README.md)

**Llamada a Función** - El modelo genera solicitudes estructuradas para llamar funciones externas. [Módulo 04](../04-tools/README.md)

**Alucinación** - Cuando los modelos generan información incorrecta pero plausible.

**Prompt** - Texto de entrada para un modelo de lenguaje. [Módulo 02](../02-prompt-engineering/README.md)

**Búsqueda Semántica** - Búsqueda por significado usando embeddings, no palabras clave. [Módulo 03](../03-rag/README.md)

**Con Estado vs Sin Estado** - Sin estado: sin memoria. Con estado: mantiene historial de conversación. [Módulo 01](../01-introduction/README.md)

**Tokens** - Unidades básicas de texto que procesan los modelos. Afecta costos y límites. [Módulo 01](../01-introduction/README.md)

**Encadenamiento de Herramientas** - Ejecución secuencial de herramientas donde la salida informa la siguiente llamada. [Módulo 04](../04-tools/README.md)

## Componentes de LangChain4j

**AiServices** - Crea interfaces de servicio AI con tipado seguro.

**OpenAiOfficialChatModel** - Cliente unificado para modelos OpenAI y Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Crea embeddings usando el cliente Oficial OpenAI (compatible con OpenAI y Azure OpenAI).

**ChatModel** - Interfaz principal para modelos de lenguaje.

**ChatMemory** - Mantiene historial de conversación.

**ContentRetriever** - Encuentra fragmentos de documentos relevantes para RAG.

**DocumentSplitter** - Divide documentos en fragmentos.

**EmbeddingModel** - Convierte texto en vectores numéricos.

**EmbeddingStore** - Almacena y recupera embeddings.

**MessageWindowChatMemory** - Mantiene ventana móvil de mensajes recientes.

**PromptTemplate** - Crea prompts reutilizables con marcadores de posición `{{variable}}`.

**TextSegment** - Fragmento de texto con metadatos. Usado en RAG.

**ToolExecutionRequest** - Representa solicitud de ejecución de herramienta.

**UserMessage / AiMessage / SystemMessage** - Tipos de mensajes de conversación.

## Conceptos de IA/ML

**Aprendizaje con Pocos Ejemplos** - Proveer ejemplos en los prompts. [Módulo 02](../02-prompt-engineering/README.md)

**Modelo de Lenguaje Grande (LLM)** - Modelos IA entrenados con grandes conjuntos de texto.

**Esfuerzo de Razonamiento** - Parámetro GPT-5.2 que controla la profundidad del pensamiento. [Módulo 02](../02-prompt-engineering/README.md)

**Temperatura** - Controla la aleatoriedad de la salida. Bajo=determinista, alto=creativo.

**Base de Datos Vectorial** - Base de datos especializada para embeddings. [Módulo 03](../03-rag/README.md)

**Aprendizaje Zero-Shot** - Ejecutar tareas sin ejemplos. [Módulo 02](../02-prompt-engineering/README.md)

## Guardarraíles

**Defensa en Profundidad** - Enfoque de seguridad por capas que combina guardarraíles a nivel de aplicación con filtros de seguridad del proveedor.

**Bloqueo Estricto** - El proveedor lanza error HTTP 400 para violaciones severas de contenido.

**InputGuardrail** - Interfaz LangChain4j para validar entrada del usuario antes de llegar al LLM. Ahorra costo y latencia bloqueando prompts dañinos temprano.

**InputGuardrailResult** - Tipo de retorno para validación de guardarraíl: `success()` o `fatal("razón")`.

**OutputGuardrail** - Interfaz para validar respuestas de IA antes de devolverlas a usuarios.

**Filtros de Seguridad del Proveedor** - Filtros integrados de contenido de proveedores IA (ej. Azure OpenAI) que detectan violaciones en el nivel API.

**Rechazo Suave** - El modelo se niega cortésmente a responder sin generar error.

## Ingeniería de Prompts - [Módulo 02](../02-prompt-engineering/README.md)

**Cadena de Pensamiento** - Razonamiento paso a paso para mayor precisión.

**Salida Restringida** - Imponer formato o estructura específica.

**Alta Motivación** - Patrón GPT-5.2 para razonamiento profundo.

**Baja Motivación** - Patrón GPT-5.2 para respuestas rápidas.

**Conversación Multi-Turno** - Mantener contexto en intercambios sucesivos.

**Prompt basado en Roles** - Configurar la persona del modelo via mensajes del sistema.

**Autorreflexión** - El modelo evalúa y mejora su salida.

**Análisis Estructurado** - Marco fijo de evaluación.

**Patrón de Ejecución de Tarea** - Planificar → Ejecutar → Resumir.

## RAG (Generación Aumentada por Recuperación) - [Módulo 03](../03-rag/README.md)

**Pipeline de Procesamiento de Documentos** - Cargar → fragmentar → embeber → almacenar.

**Almacenamiento de Embeddings en Memoria** - Almacenamiento no persistente para pruebas.

**RAG** - Combina recuperación con generación para fundamentar respuestas.

**Puntaje de Similaridad** - Medida (0-1) de similitud semántica.

**Referencia de Fuente** - Metadatos sobre contenido recuperado.

## Agentes y Herramientas - [Módulo 04](../04-tools/README.md)

**Anotación @Tool** - Marca métodos Java como herramientas invocables por IA.

**Patrón ReAct** - Razonar → Actuar → Observar → Repetir.

**Gestión de Sesiones** - Contextos separados para diferentes usuarios.

**Herramienta** - Función que un agente IA puede invocar.

**Descripción de Herramienta** - Documentación del propósito y parámetros de herramienta.

## Módulo Agéntico - [Módulo 05](../05-mcp/README.md)

**Anotación @Agent** - Marca interfaces como agentes IA con definición declarativa de comportamiento.

**Agent Listener** - Gancho para monitorear ejecución de agente vía `beforeAgentInvocation()` y `afterAgentInvocation()`.

**Alcance Agéntico** - Memoria compartida donde agentes almacenan salidas usando `outputKey` para que agentes posteriores consuman.

**AgenticServices** - Fábrica para crear agentes usando `agentBuilder()` y `supervisorBuilder()`.

**Flujo Condicional** - Ruta basada en condiciones hacia distintos agentes especialistas.

**Humano en el Bucle** - Patrón de flujo añadiendo puntos de control humanos para aprobación o revisión de contenido.

**langchain4j-agentic** - Dependencia Maven para construcción declarativa de agentes (experimental).

**Flujo en Bucle** - Iterar ejecución de agente hasta que se cumpla condición (ej. puntaje de calidad ≥ 0.8).

**outputKey** - Parámetro de anotación de agente que especifica dónde se almacenan resultados en Alcance Agéntico.

**Flujo Paralelo** - Ejecutar múltiples agentes simultáneamente para tareas independientes.

**Estrategia de Respuesta** - Cómo el supervisor formula la respuesta final: ÚLTIMA, RESUMEN, o CON PUNTAJE.

**Flujo Secuencial** - Ejecutar agentes en orden donde la salida fluye al siguiente paso.

**Patrón Agente Supervisor** - Patrón agéntico avanzado donde un supervisor LLM decide dinámicamente qué subagentes invocar.

## Protocolo de Contexto de Modelo (MCP) - [Módulo 05](../05-mcp/README.md)

**langchain4j-mcp** - Dependencia Maven para integración MCP en LangChain4j.

**MCP** - Protocolo de Contexto de Modelo: estándar para conectar apps IA a herramientas externas. Crear una vez, usar en todas partes.

**Cliente MCP** - Aplicación que se conecta a servidores MCP para descubrir y usar herramientas.

**Servidor MCP** - Servicio que expone herramientas vía MCP con descripciones claras y esquemas de parámetros.

**McpToolProvider** - Componente LangChain4j que envuelve herramientas MCP para usar en servicios AI y agentes.

**McpTransport** - Interfaz para comunicación MCP. Implementaciones incluyen Stdio y HTTP.

**Transporte Stdio** - Transporte por proceso local vía stdin/stdout. Útil para acceso a sistema de archivos o herramientas de línea de comandos.

**StdioMcpTransport** - Implementación LangChain4j que lanza servidor MCP como subproceso.

**Descubrimiento de Herramientas** - Cliente consulta al servidor por herramientas disponibles con descripciones y esquemas.

## Servicios de Azure - [Módulo 01](../01-introduction/README.md)

**Azure AI Search** - Búsqueda en la nube con capacidades vectoriales. [Módulo 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Despliega recursos Azure.

**Azure OpenAI** - Servicio de IA empresarial de Microsoft.

**Bicep** - Lenguaje de infraestructura como código para Azure. [Guía de Infraestructura](../01-introduction/infra/README.md)

**Nombre de Despliegue** - Nombre para el despliegue del modelo en Azure.

**GPT-5.2** - Último modelo OpenAI con control de razonamiento. [Módulo 02](../02-prompt-engineering/README.md)

## Pruebas y Desarrollo - [Guía de Pruebas](TESTING.md)

**Contenedor Dev** - Entorno de desarrollo en contenedor. [Configuración](../../../.devcontainer/devcontainer.json)

**Pruebas en Memoria** - Pruebas con almacenamiento en memoria.

**Pruebas de Integración** - Pruebas con infraestructura real.

**Maven** - Herramienta de automatización de compilación para Java.

**Mockito** - Framework de simulación para Java.

**Spring Boot** - Framework de aplicaciones Java. [Módulo 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Descargo de responsabilidad**:
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o inexactitudes. El documento original en su idioma nativo debe considerarse la fuente autorizada. Para información crítica, se recomienda una traducción profesional humana. No somos responsables de cualquier malentendido o interpretación errónea que surja del uso de esta traducción.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->