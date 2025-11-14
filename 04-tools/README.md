# Module 04: AI Agents with Tools

## Table of Contents

- [What You'll Learn](#what-youll-learn)
- [Prerequisites](#prerequisites)
- [Understanding AI Agents with Tools](#understanding-ai-agents-with-tools)
- [How Tool Calling Works](#how-tool-calling-works)
  - [Tool Definitions](#tool-definitions)
  - [Decision Making](#decision-making)
  - [Execution](#execution)
  - [Response Generation](#response-generation)
- [Tool Chaining](#tool-chaining)
- [Run the Application](#run-the-application)
- [Using the Application](#using-the-application)
  - [Try Simple Tool Usage](#try-simple-tool-usage)
  - [Test Tool Chaining](#test-tool-chaining)
  - [See Conversation Flow](#see-conversation-flow)
  - [Observe the Reasoning](#observe-the-reasoning)
  - [Experiment with Different Requests](#experiment-with-different-requests)
- [Key Concepts](#key-concepts)
  - [ReAct Pattern (Reasoning and Acting)](#react-pattern-reasoning-and-acting)
  - [Tool Descriptions Matter](#tool-descriptions-matter)
  - [Session Management](#session-management)
  - [Error Handling](#error-handling)
- [Available Tools](#available-tools)
- [When to Use Tool-Based Agents](#when-to-use-tool-based-agents)
- [Next Steps](#next-steps)

## What You'll Learn

So far, you've learned how to have conversations with AI, structure prompts effectively, and ground responses in your documents. But there's still a fundamental limitation: language models can only generate text. They can't check the weather, perform calculations, query databases, or interact with external systems.

Tools change this. By giving the model access to functions it can call, you transform it from a text generator into an agent that can take actions. The model decides when it needs a tool, which tool to use, and what parameters to pass. Your code executes the function and returns the result. The model incorporates that result into its response.

## Prerequisites

- Completed Module 01 (Azure OpenAI resources deployed)
- `.env` file in root directory with Azure credentials (created by `azd up` in Module 01)

> **Note:** If you haven't completed Module 01, follow the deployment instructions there first.

## Understanding AI Agents with Tools

An AI agent with tools follows a reasoning and acting pattern (ReAct):

1. User asks a question
2. Agent reasons about what it needs to know
3. Agent decides if it needs a tool to answer
4. If yes, agent calls the appropriate tool with the right parameters
5. Tool executes and returns data
6. Agent incorporates the result and provides the final answer

<img src="images/react-pattern.png" alt="ReAct Pattern" width="800"/>

*The ReAct pattern - how AI agents alternate between reasoning and acting to solve problems*

This happens automatically. You define the tools and their descriptions. The model handles the decision-making about when and how to use them.

## How Tool Calling Works

**Tool Definitions** - [WeatherTool.java](src/main/java/com/example/langchain4j/agents/tools/WeatherTool.java) | [TemperatureTool.java](src/main/java/com/example/langchain4j/agents/tools/TemperatureTool.java)

You define functions with clear descriptions and parameter specifications. The model sees these descriptions in its system prompt and understands what each tool does.

```java
public class WeatherTool {
    
    @Tool("Get the current weather for a location")
    public String getCurrentWeather(@P("Location name") String location) {
        // Your weather lookup logic
        return "Weather in " + location + ": 22°C, cloudy";
    }
}

interface Assistant {
    String chat(String userMessage);
}

Assistant assistant = AiServices.builder(Assistant.class)
    .chatModel(model)
    .tools(new WeatherTool())
    .build();
```

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`WeatherTool.java`](src/main/java/com/example/langchain4j/agents/tools/WeatherTool.java) and ask:
> - "How would I integrate a real weather API like OpenWeatherMap instead of mock data?"
> - "What makes a good tool description that helps the AI use it correctly?"
> - "How do I handle API errors and rate limits in tool implementations?"

**Decision Making**

When a user asks "What's the weather in Seattle?", the model recognizes it needs the weather tool. It generates a function call with the location parameter set to "Seattle".

**Execution** - [AgentService.java](src/main/java/com/example/langchain4j/agents/service/AgentService.java)

LangChain4j intercepts the function call, executes the Java method directly, and returns the result to the model automatically.

> **🤖 Try with [GitHub Copilot](https://github.com/features/copilot) Chat:** Open [`AgentService.java`](src/main/java/com/example/langchain4j/agents/service/AgentService.java) and ask:
> - "How does the ReAct pattern work and why is it effective for AI agents?"
> - "How does the agent decide which tool to use and in what order?"
> - "What happens if a tool execution fails - how should I handle errors robustly?"

**Response Generation**

The model receives the weather data and formats it into a natural language response for the user.

### Why Use AiServices with Tools?

LangChain4j's `AiServices` framework handles all the complexity of tool calling:

- **Automatic schema generation** - Tool descriptions are converted to function schemas
- **Type-safe execution** - Java methods called directly with type conversion
- **Multi-turn orchestration** - Handles tool chaining automatically
- **Error handling** - Propagates exceptions cleanly
- **Zero boilerplate** - No manual parsing, HTTP calls, or result formatting

The alternative (manual implementation) requires:
- Writing tool schemas as strings
- Parsing LLM responses with regex
- Manual parameter extraction and type conversion
- Implementing ReAct loop with iteration limits
- Error handling at each step

With `AiServices.builder().tools()`, all of this is automatic.

## Tool Chaining

**Tool Chaining** - The AI might call multiple tools in sequence. Ask "What's the weather in Seattle and should I bring an umbrella?" and watch it chain `getCurrentWeather` with reasoning about rain gear.

<a href="images/tool-chaining.png"><img src="images/tool-chaining.png" alt="Tool Chaining" width="800" style="border: 1px solid #ddd; box-shadow: 0 2px 8px rgba(0,0,0,0.1);"/></a>

*Sequential tool calls - one tool's output feeds into the next decision*

**Graceful Failures** - Ask for weather in a city that's not in the mock data. The tool returns an error message, and the AI explains it can't help. Tools fail safely.

This happens in a single conversation turn. The agent orchestrates multiple tool calls autonomously.

## Run the Application

**Verify deployment:**

Ensure the `.env` file exists in root directory with Azure credentials (created during Module 01):
```bash
cat ../.env  # Should show AZURE_OPENAI_ENDPOINT, API_KEY, DEPLOYMENT
```

**Start the application:**

> **Note:** If you already started all applications using `./start-all.sh` from Module 01, this module is already running on port 8084. You can skip the start commands below and go directly to http://localhost:8084.

**Option 1: Using Spring Boot Dashboard (Recommended for VS Code users)**

The dev container includes the Spring Boot Dashboard extension, which provides a visual interface to manage all Spring Boot applications. You can find it in the Activity Bar on the left side of VS Code (look for the Spring Boot icon).

From the Spring Boot Dashboard, you can:
- See all available Spring Boot applications in the workspace
- Start/stop applications with a single click
- View application logs in real-time
- Monitor application status

Simply click the play button next to "tools" to start this module, or start all modules at once.

<img src="images/dashboard.png" alt="Spring Boot Dashboard" width="400"/>

**Option 2: Using shell scripts**

Start all web applications (modules 01-04):
```bash
cd ..  # From root directory
./start-all.sh
```

Or start just this module:
```bash
cd 04-tools
./start.sh
```

Both scripts automatically load environment variables from the root `.env` file and will build the JARs if they don't exist.

> **Note:** If you prefer to build all modules manually before starting:
> ```bash
> cd ..  # Go to root directory
> mvn clean package -DskipTests
> ```

Open http://localhost:8084 in your browser.

**To stop:** Run `./stop.sh` (this module only) or `cd .. && ./stop-all.sh` (all modules)

## Using the Application

The application provides a web interface where you can interact with an AI agent that has access to weather and temperature conversion tools.

<a href="images/tools-homepage.png"><img src="images/tools-homepage.png" alt="AI Agent Tools Interface" width="800" style="border: 1px solid #ddd; box-shadow: 0 2px 8px rgba(0,0,0,0.1);"/></a>

*The AI Agent Tools interface - quick examples and chat interface for interacting with tools*

**Try Simple Tool Usage**

Start with a straightforward request: "Convert 100 degrees Fahrenheit to Celsius". The agent recognizes it needs the temperature conversion tool, calls it with the right parameters, and returns the result. Notice how natural this feels - you didn't specify which tool to use or how to call it.

**Test Tool Chaining**

Now try something more complex: "What's the weather in Seattle and convert it to Fahrenheit?" Watch the agent work through this in steps. It first gets the weather (which returns Celsius), recognizes it needs to convert to Fahrenheit, calls the conversion tool, and combines both results into one response.

**See Conversation Flow**

The chat interface maintains conversation history, allowing you to have multi-turn interactions. You can see all previous queries and responses, making it easy to track the conversation and understand how the agent builds context over multiple exchanges.

<a href="images/tools-conversation-demo.png"><img src="images/tools-conversation-demo.png" alt="Conversation with Multiple Tool Calls" width="800" style="border: 1px solid #ddd; box-shadow: 0 2px 8px rgba(0,0,0,0.1);"/></a>

*Multi-turn conversation showing simple conversions, weather lookups, and tool chaining*

**Experiment with Different Requests**

Try various combinations:
- Weather lookups: "What's the weather in Tokyo?"
- Temperature conversions: "What is 25°C in Kelvin?"
- Combined queries: "Check the weather in Paris and tell me if it's above 20°C"

Notice how the agent interprets natural language and maps it to appropriate tool calls.

## Key Concepts

**ReAct Pattern (Reasoning and Acting)**

The agent alternates between reasoning (deciding what to do) and acting (using tools). This pattern enables autonomous problem-solving rather than just responding to instructions.

**Tool Descriptions Matter**

The quality of your tool descriptions directly affects how well the agent uses them. Clear, specific descriptions help the model understand when and how to call each tool.

**Session Management**

Like the conversation memory in Module 01, tool-based agents maintain session context. The agent remembers previous tool calls and results within a session, enabling multi-turn interactions.

**Error Handling**

Tools can fail - APIs timeout, parameters might be invalid, external services go down. Production agents need error handling so the model can explain problems or try alternatives.

## Available Tools

**Weather Tools** (mock data for demonstration):
- Get current weather for a location
- Get multi-day forecast

**Temperature Conversion Tools**:
- Celsius to Fahrenheit
- Fahrenheit to Celsius
- Celsius to Kelvin
- Kelvin to Celsius
- Fahrenheit to Kelvin
- Kelvin to Fahrenheit

These are simple examples, but the pattern extends to any function: database queries, API calls, calculations, file operations, or system commands.

## When to Use Tool-Based Agents

**Use tools when:**
- Answering requires real-time data (weather, stock prices, inventory)
- You need to perform calculations beyond simple math
- Accessing databases or APIs
- Taking actions (sending emails, creating tickets, updating records)
- Combining multiple data sources

**Don't use tools when:**
- Questions can be answered from general knowledge
- Response is purely conversational
- Tool latency would make the experience too slow

## Next Steps

**Next Module:** [05-mcp - Model Context Protocol (MCP)](../05-mcp/README.md)

---

**Navigation:** [← Previous: Module 03 - RAG](../03-rag/README.md) | [Back to Main](../README.md) | [Next: Module 05 - MCP →](../05-mcp/README.md)