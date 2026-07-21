# LangChain4j 용어집

## 목차

- [핵심 개념](#핵심-개념)
- [LangChain4j 구성 요소](#langchain4j-구성-요소)
- [AI/ML 개념](#aiml-개념)
- [가드레일](#가드레일)
- [프롬프트 엔지니어링](#prompt-engineering---module-02)
- [RAG (검색 증강 생성)](#rag-retrieval-augmented-generation---module-03)
- [에이전트 및 도구](#agents-and-tools---module-04)
- [에이전틱 모듈](#agentic-module---module-05)
- [모델 컨텍스트 프로토콜 (MCP)](#model-context-protocol-mcp---module-05)
- [Azure 서비스](#azure-services---module-01)
- [테스트 및 개발](#testing-and-development---testing-guide)

과정 전반에서 사용되는 용어 및 개념에 대한 빠른 참고.

## 핵심 개념

**AI 에이전트** - AI를 사용해 자율적으로 추론하고 행동하는 시스템. [모듈 04](../04-tools/README.md)  

<strong>체인</strong> - 출력이 다음 단계로 연결되는 일련의 작업.  

**청킹(Chunking)** - 문서를 작은 조각으로 나누기. 일반적으로 300-500 토큰, 중첩 포함. [모듈 03](../03-rag/README.md)  

**컨텍스트 윈도우** - 모델이 처리할 수 있는 최대 토큰 수. GPT-5.2: 400K 토큰 (입력 최대 272K, 출력 128K).  

**임베딩(Embeddings)** - 텍스트 의미를 수치 벡터로 표현. [모듈 03](../03-rag/README.md)  

**함수 호출(Function Calling)** - 모델이 외부 함수를 호출하기 위한 구조화된 요청 생성. [모듈 04](../04-tools/README.md)  

**환각(Hallucination)** - 모델이 그럴듯하지만 잘못된 정보를 생성하는 현상.  

**프롬프트(Prompt)** - 언어 모델에 입력하는 텍스트. [모듈 02](../02-prompt-engineering/README.md)  

**의미 검색(Semantic Search)** - 키워드 대신 임베딩을 사용하여 의미로 검색. [모듈 03](../03-rag/README.md)  

**상태 유지 vs 상태 비유지(Stateful vs Stateless)** - 상태 비유지: 메모리 없음. 상태 유지: 대화 기록 유지. [모듈 01](../01-introduction/README.md)  

**토큰(Tokens)** - 모델이 처리하는 기본 텍스트 단위. 비용과 한도에 영향. [모듈 01](../01-introduction/README.md)  

**도구 연결(Tool Chaining)** - 출력이 다음 호출에 영향을 주는 도구의 순차 실행. [모듈 04](../04-tools/README.md)  

## LangChain4j 구성 요소

**AiServices** - 타입 안전 AI 서비스 인터페이스 생성.  

**OpenAiOfficialChatModel** - OpenAI와 Azure OpenAI 모델을 위한 통합 클라이언트.  

**OpenAiOfficialEmbeddingModel** - OpenAI 공식 클라이언트를 사용해 임베딩 생성 (OpenAI 및 Azure OpenAI 지원).  

**ChatModel** - 언어 모델의 핵심 인터페이스.  

**ChatMemory** - 대화 기록 유지.  

**ContentRetriever** - RAG용 관련 문서 조각 검색.  

**DocumentSplitter** - 문서를 청크로 분할.  

**EmbeddingModel** - 텍스트를 수치 벡터로 변환.  

**EmbeddingStore** - 임베딩 저장 및 조회.  

**MessageWindowChatMemory** - 최근 메시지에 대한 슬라이딩 윈도우 유지.  

**PromptTemplate** - `{{variable}}` 자리표시자가 있는 재사용 가능한 프롬프트 생성.  

**TextSegment** - 메타데이터가 포함된 텍스트 청크. RAG에서 사용.  

**ToolExecutionRequest** - 도구 실행 요청을 나타냄.  

**UserMessage / AiMessage / SystemMessage** - 대화 메시지 유형.  

## AI/ML 개념

**Few-Shot Learning** - 프롬프트에 예제를 제공하는 학습법. [모듈 02](../02-prompt-engineering/README.md)  

**대형 언어 모델 (LLM)** - 방대한 텍스트 데이터로 훈련된 AI 모델.  

**추론 노력(Reasoning Effort)** - GPT-5.2의 사고 심도 조절 파라미터. [모듈 02](../02-prompt-engineering/README.md)  

**온도(Temperature)** - 출력의 무작위성 조절. 낮음=결정적, 높음=창의적.  

**벡터 데이터베이스(Vector Database)** - 임베딩을 위한 특화 데이터베이스. [모듈 03](../03-rag/README.md)  

**제로샷 학습(Zero-Shot Learning)** - 예제 없이 작업 수행. [모듈 02](../02-prompt-engineering/README.md)  

## 가드레일

**Deep Defense(Defense in Depth)** - 애플리케이션 수준 가드레일과 공급자 안전 필터를 결합한 다중 보안 계층.  

**하드 블록(Hard Block)** - 심각한 콘텐츠 위반 시 공급자가 HTTP 400 오류를 반환.  

**InputGuardrail** - LLM에 도달하기 전에 사용자 입력을 검증하는 LangChain4j 인터페이스. 해로운 프롬프트를 조기에 차단해 비용과 지연 감소.  

**InputGuardrailResult** - 가드레일 검증 반환 타입: `success()` 또는 `fatal("reason")`.  

**OutputGuardrail** - 사용자에게 전달하기 전 AI 응답을 검증하는 인터페이스.  

**공급자 안전 필터(Provider Safety Filters)** - AI 공급자(예: Azure OpenAI)의 API 수준 내장 콘텐츠 필터.  

**소프트 거부(Soft Refusal)** - 모델이 오류 없이 정중하게 응답을 거절함.  

## 프롬프트 엔지니어링 - [모듈 02](../02-prompt-engineering/README.md)

**생각의 연쇄(Chain-of-Thought)** - 더 나은 정확도를 위한 단계별 추론.  

**제약된 출력(Constrained Output)** - 특정 형식 또는 구조 강제 적용.  

**높은 열의(High Eagerness)** - 철저한 추론용 GPT-5.2 패턴.  

**낮은 열의(Low Eagerness)** - 빠른 답변용 GPT-5.2 패턴.  

**다중 대화(Multi-Turn Conversation)** - 교환 간 컨텍스트 유지.  

**역할 기반 프롬프트(Role-Based Prompting)** - 시스템 메시지를 통한 모델 페르소나 설정.  

**자기 성찰(Self-Reflection)** - 모델이 출력 평가 및 개선.  

**구조화 분석(Structured Analysis)** - 고정 평가 프레임워크.  

**작업 실행 패턴(Task Execution Pattern)** - 계획 → 실행 → 요약.  

## RAG (검색 증강 생성) - [모듈 03](../03-rag/README.md)

**문서 처리 파이프라인** - 로드 → 청크 분할 → 임베딩 → 저장.  

**인메모리 임베딩 저장소** - 테스트용 비영속 저장소.  

**RAG** - 검색과 생성을 결합하여 응답에 근거 제공.  

**유사도 점수(Similarity Score)** - 의미적 유사성의 0-1 척도.  

**출처 참조(Source Reference)** - 검색된 콘텐츠에 대한 메타데이터.  

## 에이전트 및 도구 - [모듈 04](../04-tools/README.md)

**@Tool 애노테이션** - Java 메서드를 AI 호출 도구로 표시.  

**ReAct 패턴** - 추론 → 행동 → 관찰 → 반복.  

**세션 관리(Session Management)** - 사용자 별 별도 컨텍스트 유지.  

**도구(Tool)** - AI 에이전트가 호출할 수 있는 함수.  

**도구 설명(Tool Description)** - 도구 목적 및 매개변수 문서화.  

## 에이전틱 모듈 - [모듈 05](../05-mcp/README.md)

**@Agent 애노테이션** - 선언적 행위 정의가 가능한 AI 에이전트 인터페이스 표시.  

**에이전트 리스너(Agent Listener)** - `beforeAgentInvocation()`, `afterAgentInvocation()`을 통한 에이전트 실행 모니터링 훅.  

**에이전틱 스코프(Agentic Scope)** - 에이전트가 결과를 저장하는 공유 메모리, 하류 에이전트가 소비.  

**AgenticServices** - `agentBuilder()`, `supervisorBuilder()`를 통한 에이전트 생성용 팩토리.  

**조건 워크플로우(Conditional Workflow)** - 조건에 따라 다른 전문 에이전트로 분기.  

**휴먼-인-더-루프(Human-in-the-Loop)** - 승인 또는 콘텐츠 검토를 위한 인간 관문이 포함된 워크플로우 패턴.  

**langchain4j-agentic** - 선언적 에이전트 빌딩용 Maven 의존성(실험적).  

**루프 워크플로우(Loop Workflow)** - 품질 점수 ≥ 0.8 등 조건 만족 시까지 에이전트 실행 반복.  

**outputKey** - 에이전트 애노테이션 매개변수로 결과가 저장되는 에이전틱 스코프 위치 지정.  

**병렬 워크플로우(Parallel Workflow)** - 독립 작업을 위한 다중 에이전트 동시 실행.  

**응답 전략(Response Strategy)** - 관리자가 최종 답변을 구성하는 방식: LAST, SUMMARY, SCORED.  

**순차 워크플로우(Sequential Workflow)** - 출력이 다음 단계로 흐르는 순차적 에이전트 실행.  

**관리자 에이전트 패턴(Supervisor Agent Pattern)** - 감독 LLM이 하위 에이전트를 동적으로 호출하는 고급 에이전틱 패턴.  

## 모델 컨텍스트 프로토콜 (MCP) - [모듈 05](../05-mcp/README.md)

**langchain4j-mcp** - LangChain4j의 MCP 통합용 Maven 의존성.  

**MCP** - 모델 컨텍스트 프로토콜: AI 앱과 외부 도구 연결을 위한 표준. 한 번 구축하면 어디서나 사용 가능.  

**MCP 클라이언트(Client)** - MCP 서버에 연결해 도구를 발견하고 사용하는 애플리케이션.  

**MCP 서버(Server)** - 명확한 설명과 매개변수 스키마를 갖춘 MCP 도구를 노출하는 서비스.  

**McpToolProvider** - AI 서비스 및 에이전트용 MCP 도구를 래핑하는 LangChain4j 구성 요소.  

**McpTransport** - MCP 통신 인터페이스. 구현체는 Stdio 및 HTTP 포함.  

**Stdio Transport** - stdin/stdout을 사용하는 로컬 프로세스 통신. 파일시스템 접근이나 명령행 도구용.  

**StdioMcpTransport** - MCP 서버를 하위 프로세스로 실행하는 LangChain4j 구현체.  

**도구 검색(Tool Discovery)** - 클라이언트가 설명 및 스키마가 포함된 사용 가능한 도구를 서버에 질의.  

## Azure 서비스 - [모듈 01](../01-introduction/README.md)

**Azure AI Search** - 벡터 기능을 갖춘 클라우드 검색. [모듈 03](../03-rag/README.md)  

**Azure Developer CLI (azd)** - Azure 리소스 배포 도구.  

**Azure OpenAI** - 마이크로소프트의 엔터프라이즈 AI 서비스.  

**Bicep** - Azure 인프라 코드 언어. [인프라 가이드](../01-introduction/infra/README.md)  

**배포 이름(Deployment Name)** - Azure에서 모델 배포 이름.  

**GPT-5.2** - 추론 제어 기능을 갖춘 최신 OpenAI 모델. [모듈 02](../02-prompt-engineering/README.md)  

## 테스트 및 개발 - [테스트 가이드](TESTING.md)

**개발 컨테이너(Dev Container)** - 컨테이너화된 개발 환경. [구성](../../../.devcontainer/devcontainer.json)  

**인메모리 테스트(In-Memory Testing)** - 인메모리 저장소를 이용한 테스트.  

**통합 테스트(Integration Testing)** - 실제 인프라 환경에서의 테스트.  

**Maven** - Java 빌드 자동화 도구.  

**Mockito** - Java 모킹 프레임워크.  

**Spring Boot** - Java 애플리케이션 프레임워크. [모듈 01](../01-introduction/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**면책 조항**:
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 기하기 위해 노력하고 있으나, 자동 번역은 오류나 부정확한 부분이 있을 수 있음을 유의하시기 바랍니다. 원본 문서의 원어본이 권위 있는 자료로 간주되어야 합니다. 중요한 정보의 경우, 전문가의 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 당사는 책임을 지지 않습니다.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->