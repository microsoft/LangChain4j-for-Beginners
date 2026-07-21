# LangChain4j 用語集

## 目次

- [コアコンセプト](#コアコンセプト)
- [LangChain4j コンポーネント](#langchain4j-コンポーネント)
- [AI/ML コンセプト](#aiml-コンセプト)
- [ガードレール](#ガードレール)
- [プロンプトエンジニアリング](#prompt-engineering---module-02)
- [RAG (Retrieval-Augmented Generation)](#rag-retrieval-augmented-generation---module-03)
- [エージェントとツール](#agents-and-tools---module-04)
- [エージェンシックモジュール](#agentic-module---module-05)
- [モデルコンテキストプロトコル (MCP)](#model-context-protocol-mcp---module-05)
- [Azure サービス](#azure-services---module-01)
- [テストおよび開発](#testing-and-development---testing-guide)

コース全体で使用される用語と概念のクイックリファレンス。

## コアコンセプト

**AIエージェント** - AIを使用して自律的に推論し行動するシステム。 [モジュール 04](../04-tools/README.md)

<strong>チェーン</strong> - 出力が次のステップに入力される一連の操作。

<strong>チャンク分割</strong> - ドキュメントをより小さな部分に分割すること。典型的には300〜500トークンで重複あり。 [モジュール 03](../03-rag/README.md)

<strong>コンテキストウィンドウ</strong> - モデルが処理できる最大トークン数。GPT-5.2: 400Kトークン（最大272K入力、128K出力）。

**埋め込み (Embeddings)** - テキストの意味を表す数値ベクトル。 [モジュール 03](../03-rag/README.md)

<strong>関数呼び出し</strong> - モデルが外部関数を呼び出すための構造化リクエストを生成。 [モジュール 04](../04-tools/README.md)

<strong>ハルシネーション</strong> - モデルが誤ったが妥当な情報を生成すること。

<strong>プロンプト</strong> - 言語モデルへのテキスト入力。 [モジュール 02](../02-prompt-engineering/README.md)

<strong>セマンティックサーチ</strong> - キーワードではなく埋め込みを使った意味に基づく検索。 [モジュール 03](../03-rag/README.md)

**ステートフル vs ステートレス** - ステートレス：記憶なし。ステートフル：会話履歴を維持。 [モジュール 01](../01-introduction/README.md)

<strong>トークン</strong> - モデルが処理する基本的なテキスト単位。コストと制限に影響。 [モジュール 01](../01-introduction/README.md)

<strong>ツールチェイニング</strong> - 出力が次の呼び出しに連動する連続的なツール実行。 [モジュール 04](../04-tools/README.md)

## LangChain4j コンポーネント

**AiServices** - 型安全なAIサービスインターフェースを作成。

**OpenAiOfficialChatModel** - OpenAIおよびAzure OpenAIモデルの統合クライアント。

**OpenAiOfficialEmbeddingModel** - OpenAI Officialクライアントを使った埋め込み生成（OpenAIとAzure OpenAIの両方対応）。

**ChatModel** - 言語モデルのコアインターフェース。

**ChatMemory** - 会話履歴を維持。

**ContentRetriever** - RAG用の関連ドキュメントチャンクを検索。

**DocumentSplitter** - ドキュメントをチャンクに分割。

**EmbeddingModel** - テキストを数値ベクトルに変換。

**EmbeddingStore** - 埋め込みの保存と検索。

**MessageWindowChatMemory** - 最近のメッセージのスライディングウィンドウを維持。

**PromptTemplate** - `{{variable}}` プレースホルダーで再利用可能なプロンプトを作成。

**TextSegment** - メタデータ付きテキストチャンク。RAGで使用。

**ToolExecutionRequest** - ツール実行リクエストを表す。

**UserMessage / AiMessage / SystemMessage** - 会話メッセージの種類。

## AI/ML コンセプト

**Few-Shot Learning** - プロンプトに例を提供。 [モジュール 02](../02-prompt-engineering/README.md)

**大規模言語モデル (LLM)** - 大量のテキストデータで訓練されたAIモデル。

**Reasoning Effort** - GPT-5.2で思考の深さを制御するパラメーター。 [モジュール 02](../02-prompt-engineering/README.md)

**Temperature** - 出力のランダム性を制御。低いと決定的、高いと創造的。

<strong>ベクターデータベース</strong> - 埋め込み用の特殊データベース。 [モジュール 03](../03-rag/README.md)

**Zero-Shot Learning** - 例なしでタスクを実行。 [モジュール 02](../02-prompt-engineering/README.md)

## ガードレール

**多層防御 (Defense in Depth)** - アプリケーションレベルのガードレールとプロバイダーのセーフティフィルターを組み合わせた多層セキュリティアプローチ。

<strong>ハードブロック</strong> - 深刻なコンテンツ違反でプロバイダーがHTTP 400エラーを返す。

**InputGuardrail** - LLMに到達する前にユーザー入力を検証するLangChain4jインターフェース。害のあるプロンプトを早期にブロックしコストと遅延を削減。

**InputGuardrailResult** - ガードレール検証の返却型：`success()` または `fatal("reason")`。

**OutputGuardrail** - AIの応答をユーザーに返す前に検証するインターフェース。

<strong>プロバイダーセーフティフィルター</strong> - AIプロバイダー（例：Azure OpenAI）によるAPIレベルのコンテンツフィルター。

<strong>ソフトリファーザル</strong> - モデルがエラーを出さず丁寧に回答を拒否。

## プロンプトエンジニアリング - [モジュール 02](../02-prompt-engineering/README.md)

**Chain-of-Thought** - 精度向上のための段階的推論。

<strong>制約付き出力</strong> - 特定のフォーマットや構造の強制。

**高い熱意 (High Eagerness)** - GPT-5.2の徹底的推論パターン。

**低い熱意 (Low Eagerness)** - GPT-5.2の迅速な回答パターン。

<strong>マルチターン会話</strong> - やり取り間でコンテキストを維持。

<strong>役割に基づくプロンプト</strong> - システムメッセージでモデルの人格を設定。

<strong>自己反省</strong> - モデルが自身の出力を評価・改善。

<strong>構造化分析</strong> - 固定評価フレームワーク。

<strong>タスク実行パターン</strong> - 計画 → 実行 → 要約。

## RAG (Retrieval-Augmented Generation) - [モジュール 03](../03-rag/README.md)

<strong>ドキュメント処理パイプライン</strong> - ロード → チャンク化 → 埋め込み → 保存。

<strong>インメモリ埋め込みストア</strong> - テスト用の非永続的ストレージ。

**RAG** - 検索と生成を組み合わせて応答を根拠づけ。

<strong>類似度スコア</strong> - セマンティック類似度の尺度（0〜1）。

<strong>出典参照</strong> - 取得したコンテンツのメタデータ。

## エージェントとツール - [モジュール 04](../04-tools/README.md)

**@Tool アノテーション** - JavaメソッドをAI呼び出し可能なツールとしてマーク。

**ReAct パターン** - 推論 → 行動 → 観察 → 繰り返し。

<strong>セッション管理</strong> - ユーザーごとに異なるコンテキストを分離。

<strong>ツール</strong> - AIエージェントが呼び出せる関数。

<strong>ツール説明</strong> - ツールの目的とパラメーターのドキュメント。

## エージェンシックモジュール - [モジュール 05](../05-mcp/README.md)

**@Agent アノテーション** - 宣言的な振る舞い定義でインターフェースをAIエージェントにマーク。

<strong>エージェントリスナー</strong> - `beforeAgentInvocation()` と `afterAgentInvocation()` でエージェント実行を監視するフック。

<strong>エージェンシックスコープ</strong> - エージェントが `outputKey` を使い出力を保存し、下流エージェントが利用する共有メモリ。

**AgenticServices** - `agentBuilder()` と `supervisorBuilder()` でエージェント作成のファクトリ。

<strong>条件付きワークフロー</strong> - 条件に基づき異なる専門エージェントへルーティング。

<strong>ヒューマンインザループ</strong> - 承認や内容確認のために人間のチェックポイントを加えるワークフローパターン。

**langchain4j-agentic** - 宣言的エージェント構築のためのMaven依存関係（実験的）。

<strong>ループワークフロー</strong> - 品質スコア ≥ 0.8 などの条件を満たすまでエージェント実行を繰り返し。

**outputKey** - エージェントアノテーションのパラメーターで、結果をエージェンシックスコープに保存する場所を指定。

<strong>並列ワークフロー</strong> - 複数エージェントを同時に実行し独立したタスクを処理。

<strong>応答戦略</strong> - スーパーバイザーが最終回答を形成する方法：LAST、SUMMARY、または SCORED。

<strong>逐次ワークフロー</strong> - エージェントを順番に実行し、出力が次のステップへ流れる。

<strong>スーパーバイザーエージェントパターン</strong> - スーパーバイザーLLMがサブエージェントの呼び出しを動的に決定する高度なエージェンシックパターン。

## モデルコンテキストプロトコル (MCP) - [モジュール 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4jでのMCP統合用Maven依存関係。

**MCP** - Model Context Protocol：AIアプリを外部ツールに接続する標準。一度構築すればどこでも利用可能。

**MCPクライアント** - MCPサーバーに接続してツールを発見・利用するアプリケーション。

**MCPサーバー** - MCPでツールを公開し、明確な説明とパラメータスキーマを提供するサービス。

**McpToolProvider** - MCPツールをラップしてAIサービスやエージェントで使用可能にするLangChain4jコンポーネント。

**McpTransport** - MCP通信のためのインターフェース。StdioやHTTPなどの実装あり。

**Stdio トランスポート** - stdin/stdoutを用いたローカルプロセストランスポート。ファイルシステムアクセスやCLIツールに有用。

**StdioMcpTransport** - MCPサーバーをサブプロセスとして起動するLangChain4jの実装。

<strong>ツール発見</strong> - クライアントがサーバーに利用可能ツールの説明とスキーマを問い合わせる。

## Azure サービス - [モジュール 01](../01-introduction/README.md)

**Azure AI Search** - ベクター機能付きクラウド検索。 [モジュール 03](../03-rag/README.md)

**Azure Developer CLI (azd)** - Azureリソースのデプロイツール。

**Azure OpenAI** - マイクロソフトの企業向けAIサービス。

**Bicep** - Azureのインフラコード言語。 [インフラガイド](../01-introduction/infra/README.md)

<strong>デプロイメント名</strong> - Azureでのモデルデプロイ名。

**GPT-5.2** - 推論制御機能を備えた最新のOpenAIモデル。 [モジュール 02](../02-prompt-engineering/README.md)

## テストおよび開発 - [テストガイド](TESTING.md)

**Devコンテナ** - コンテナ化された開発環境。 [設定](../../../.devcontainer/devcontainer.json)

<strong>インメモリテスト</strong> - インメモリストレージを使ったテスト。

<strong>統合テスト</strong> - 実インフラを用いたテスト。

**Maven** - Javaのビルド自動化ツール。

**Mockito** - Javaのモッキングフレームワーク。

**Spring Boot** - Javaアプリケーションフレームワーク。 [モジュール 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責事項**：
本書類は AI 翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を期していますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知おきください。原文の原語版が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。本翻訳の利用により生じたいかなる誤解や解釈違いについても、当方は責任を負いかねます。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->