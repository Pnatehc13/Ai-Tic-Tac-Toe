# AI Tic Tac Toe (Java Swing GUI)

A simple yet intelligent Tic Tac Toe game built in Java using Swing for GUI and Minimax algorithm for unbeatable AI. This is my first full personal project!

## 🎮 Features

- Interactive 3x3 Tic Tac Toe board (GUI)
- Player vs AI mode
- AI uses Minimax algorithm (never loses!)
- Win/Draw detection and scoreboard
- Clean reset and replay functionality

## 🧠 Tech Used

- Java
- Java Swing (for GUI)
- Minimax Algorithm (custom implementation)
- IntelliJ IDEA (for development)

## 🧠 How the AI Works
The AI uses the classic Minimax algorithm — it simulates all possible future game states and recursively evaluates outcomes, choosing the move that guarantees a win or a draw.

Full tree search — no pruning, no shortcuts

Always optimal — you can't beat it unless you go first and play perfectly

## 🛠 Tech Stack
Java

Java Swing

Custom Minimax implementation

Launch4j (for Windows executable)

## Structure
├── Board.java       # Core logic: move validation, win checking, minimax
├── GameGUI.java     # Main GUI file with buttons, display, game loop
├── Player.java      # Simple class to track current player
├── Score.java       # Keeps track of player scores and draws
└── AITicTacToe.exe  # Optional Windows executable (Launch4j) 

## 📜 License
MIT — use it, learn from it, remix it.



## 🚀 Running the Game

### 🧾 Requirements

- Java 17+ installed (works best with JDK 21)

### 🖥️ Option 1: Run `.jar` file

If you have the JAR file:
```bash
java -jar AITicTacToe.jar
