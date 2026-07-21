# Glossaire LangChain4j

## Table des matières

- [Concepts de base](#concepts-de-base)
- [Composants LangChain4j](#composants-langchain4j)
- [Concepts IA/ML](#concepts-iaml)
- [Garde-fous](#garde-fous)
- [Ingénierie des prompts](#prompt-engineering---module-02)
- [RAG (Génération augmentée par récupération)](#rag-retrieval-augmented-generation---module-03)
- [Agents et Outils](#agents-and-tools---module-04)
- [Module Agentique](#agentic-module---module-05)
- [Protocole de Contexte de Modèle (MCP)](#model-context-protocol-mcp---module-05)
- [Services Azure](#azure-services---module-01)
- [Tests et Développement](#testing-and-development---testing-guide)

Référence rapide des termes et concepts utilisés tout au long du cours.

## Concepts de base

**Agent IA** - Système qui utilise l'IA pour raisonner et agir de manière autonome. [Module 04](../04-tools/README.md)

**Chaîne** - Séquence d'opérations où la sortie alimente l'étape suivante.

**Chunking** - Découpage des documents en morceaux plus petits. Typique : 300-500 tokens avec chevauchement. [Module 03](../03-rag/README.md)

**Fenêtre de contexte** - Nombre maximal de tokens qu'un modèle peut traiter. GPT-5.2 : 400K tokens (jusqu'à 272K en entrée, 128K en sortie).

**Embeddings** - Vecteurs numériques représentant le sens du texte. [Module 03](../03-rag/README.md)

**Appel de fonction** - Le modèle génère des requêtes structurées pour appeler des fonctions externes. [Module 04](../04-tools/README.md)

**Hallucination** - Lorsque les modèles génèrent des informations incorrectes mais plausibles.

**Prompt** - Texte d'entrée pour un modèle de langage. [Module 02](../02-prompt-engineering/README.md)

**Recherche sémantique** - Recherche par sens utilisant des embeddings, pas des mots-clés. [Module 03](../03-rag/README.md)

**Sans état vs avec état** - Sans état : pas de mémoire. Avec état : conserve l'historique de la conversation. [Module 01](../01-introduction/README.md)

**Tokens** - Unités de texte de base que les modèles traitent. Impacte coûts et limites. [Module 01](../01-introduction/README.md)

**Chaînage d'outils** - Exécution séquentielle d'outils où la sortie informe l'appel suivant. [Module 04](../04-tools/README.md)

## Composants LangChain4j

**AiServices** - Crée des interfaces de service IA typées.

**OpenAiOfficialChatModel** - Client unifié pour modèles OpenAI et Azure OpenAI.

**OpenAiOfficialEmbeddingModel** - Crée des embeddings via le client officiel OpenAI (supporte OpenAI et Azure OpenAI).

**ChatModel** - Interface principale pour les modèles de langage.

**ChatMemory** - Conserve l'historique de la conversation.

**ContentRetriever** - Trouve des morceaux de documents pertinents pour RAG.

**DocumentSplitter** - Découpe les documents en chunks.

**EmbeddingModel** - Convertit le texte en vecteurs numériques.

**EmbeddingStore** - Stocke et récupère les embeddings.

**MessageWindowChatMemory** - Maintient une fenêtre glissante des messages récents.

**PromptTemplate** - Crée des prompts réutilisables avec des espaces réservés `{{variable}}`.

**TextSegment** - Morceau de texte avec métadonnées. Utilisé dans RAG.

**ToolExecutionRequest** - Représente une requête d’exécution d’outil.

**UserMessage / AiMessage / SystemMessage** - Types de messages de conversation.

## Concepts IA/ML

**Few-Shot Learning** - Fournir des exemples dans les prompts. [Module 02](../02-prompt-engineering/README.md)

**Large Language Model (LLM)** - Modèles IA entraînés sur de vastes données textuelles.

**Effort de raisonnement** - Paramètre GPT-5.2 contrôlant la profondeur de réflexion. [Module 02](../02-prompt-engineering/README.md)

**Température** - Contrôle l’aléatoire des sorties. Faible = déterministe, élevé = créatif.

**Base de données vectorielle** - Base de données spécialisée pour les embeddings. [Module 03](../03-rag/README.md)

**Zero-Shot Learning** - Réaliser des tâches sans exemples. [Module 02](../02-prompt-engineering/README.md)

## Garde-fous

**Défense en profondeur** - Approche de sécurité multi-couches combinant garde-fous applicatifs et filtres de sécurité du fournisseur.

**Blocage dur** - Le fournisseur renvoie une erreur HTTP 400 pour des violations sévères de contenu.

**InputGuardrail** - Interface LangChain4j pour valider les entrées utilisateurs avant qu'elles n’atteignent le LLM. Économise coûts et latence en bloquant tôt les prompts nuisibles.

**InputGuardrailResult** - Type de retour pour validation des garde-fous : `success()` ou `fatal("raison")`.

**OutputGuardrail** - Interface pour valider les réponses IA avant de les renvoyer aux utilisateurs.

**Filtres de sécurité du fournisseur** - Filtres de contenu intégrés des fournisseurs d’IA (ex : Azure OpenAI) qui interceptent les violations au niveau de l’API.

**Refus doux** - Le modèle décline poliment de répondre sans générer d’erreur.

## Ingénierie des prompts - [Module 02](../02-prompt-engineering/README.md)

**Chaîne de pensée (Chain-of-Thought)** - Raisonnement étape par étape pour plus de précision.

**Sortie contrainte** - Application d’un format ou structure spécifiques.

**Forte motivation** - Modèle GPT-5.2 pour un raisonnement approfondi.

**Faible motivation** - Modèle GPT-5.2 pour des réponses rapides.

**Conversation multi-tours** - Maintien du contexte à travers les échanges.

**Prompting basé sur les rôles** - Définir la persona du modèle via des messages système.

**Auto-réflexion** - Le modèle évalue et améliore sa sortie.

**Analyse structurée** - Cadre d’évaluation fixe.

**Modèle d’exécution de tâche** - Planifier → Exécuter → Résumer.

## RAG (Génération augmentée par récupération) - [Module 03](../03-rag/README.md)

**Pipeline de traitement documentaire** - Charger → découper → créer embeddings → stocker.

**Stockage d’embeddings en mémoire** - Stockage non persistant pour tests.

**RAG** - Combine récupération et génération pour ancrer les réponses.

**Score de similarité** - Mesure (0-1) de similitude sémantique.

**Référence source** - Métadonnées sur le contenu récupéré.

## Agents et Outils - [Module 04](../04-tools/README.md)

**Annotation @Tool** - Marque les méthodes Java comme outils appelables par l’IA.

**Modèle ReAct** - Raisonner → Agir → Observer → Répéter.

**Gestion de session** - Contextes séparés pour différents utilisateurs.

**Outil** - Fonction qu’un agent IA peut appeler.

**Description d’outil** - Documentation sur la finalité et les paramètres de l’outil.

## Module Agentique - [Module 05](../05-mcp/README.md)

**Annotation @Agent** - Marque les interfaces comme agents IA avec définition déclarative du comportement.

**Agent Listener** - Hook pour surveiller l’exécution d’un agent via `beforeAgentInvocation()` et `afterAgentInvocation()`.

**Portée agentique** - Mémoire partagée où les agents stockent des sorties avec `outputKey` pour consommation par d’autres agents.

**AgenticServices** - Usine pour créer des agents avec `agentBuilder()` et `supervisorBuilder()`.

**Workflow conditionnel** - Routage basé sur conditions vers différents agents spécialistes.

**Humain dans la boucle** - Pattern avec étapes humaines pour approbation ou revue de contenu.

**langchain4j-agentic** - Dépendance Maven pour construction déclarative d’agents (expérimental).

**Workflow en boucle** - Itérer l’exécution d’un agent jusqu’à ce qu’une condition soit satisfaite (ex : score qualité ≥ 0.8).

**outputKey** - Paramètre d’annotation agent indiquant où stocker les résultats dans la portée agentique.

**Workflow parallèle** - Exécuter plusieurs agents simultanément pour tâches indépendantes.

**Stratégie de réponse** - Manière dont le superviseur formule la réponse finale : LAST, SUMMARY, ou SCORED.

**Workflow séquentiel** - Exécuter les agents dans l’ordre où la sortie alimente l’étape suivante.

**Modèle d’agent superviseur** - Pattern agentique avancé où un superviseur LLM décide dynamiquement quels sous-agents invoquer.

## Protocole de Contexte de Modèle (MCP) - [Module 05](../05-mcp/README.md)

**langchain4j-mcp** - Dépendance Maven pour l’intégration MCP dans LangChain4j.

**MCP** - Protocole de Contexte de Modèle : standard pour connecter les applications IA à des outils externes. Construire une fois, utiliser partout.

**Client MCP** - Application qui se connecte aux serveurs MCP pour découvrir et utiliser des outils.

**Serveur MCP** - Service exposant des outils via MCP avec descriptions claires et schémas de paramètres.

**McpToolProvider** - Composant LangChain4j qui encapsule les outils MCP pour usage dans services IA et agents.

**McpTransport** - Interface pour communication MCP. Implémentations incluent Stdio et HTTP.

**Transport Stdio** - Transport de processus local via stdin/stdout. Utile pour accès système de fichiers ou outils en ligne de commande.

**StdioMcpTransport** - Implémentation LangChain4j lançant le serveur MCP en sous-processus.

**Découverte d’outils** - Le client interroge le serveur pour les outils disponibles avec descriptions et schémas.

## Services Azure - [Module 01](../01-introduction/README.md)

**Azure AI Search** - Recherche cloud avec capacités vectorielles. [Module 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Déploie les ressources Azure.

**Azure OpenAI** - Service IA d’entreprise de Microsoft.

**Bicep** - Langage infrastructure-as-code Azure. [Guide Infrastructure](../01-introduction/infra/README.md)

**Nom de déploiement** - Nom pour le déploiement du modèle dans Azure.

**GPT-5.2** - Dernier modèle OpenAI avec contrôle du raisonnement. [Module 02](../02-prompt-engineering/README.md)

## Tests et Développement - [Guide de tests](TESTING.md)

**Dev Container** - Environnement de développement conteneurisé. [Configuration](../../../.devcontainer/devcontainer.json)

**Tests en mémoire** - Tests avec stockage en mémoire.

**Tests d’intégration** - Tests avec infrastructure réelle.

**Maven** - Outil d’automatisation de build Java.

**Mockito** - Framework de moquage Java.

**Spring Boot** - Framework d’application Java. [Module 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Avertissement** :
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforçions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue native doit être considéré comme la source faisant autorité. Pour les informations critiques, il est recommandé de recourir à une traduction professionnelle réalisée par un humain. Nous ne saurions être tenus responsables des malentendus ou erreurs d'interprétation découlant de l'utilisation de cette traduction.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->