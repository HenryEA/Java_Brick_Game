# Java Brick Game 
This repository contains the code for a brick-breaker game developed in Java using the Eclipse IDE. This project demonstrates core object-oriented programming (OOP) concepts and delivers an interactive graphical user interface (GUI).

## Project Overview
The primary goal of this application was to  recreate the classic brick-breaker arcade experience in a desktop Java environment and master the intricacies of Object-oriented programming in Java. The game features a movable paddle, bouncing ball, and layers of bricks that the player must clear. The GUI (which was developed with Java Swing/AWT) was designed to respond smoothly to player inputs and display score and lives. The Java code for the functionality is structured using OOP principles to encapsulate game logic, collisions, and user controls.

## Key Features

* **Object-Oriented Design & Programming** – OOP was very instrumental in the development of this application, as many of the app's features were built upon its principles. The application uses Java classes, inheritance, encapsulation, and polymorphism to model game entities such as the Ball, Paddle, Brick, GameBoard, and GameController.
* **Player Controls** – User input (via the keyboard) allows movement of the paddle and real-time reaction to the ball’s trajectory.
* **Interactive Gameplay** – The game handles ball-brick collisions, paddle bounces, score updates, lives tracking, and game-over conditions which creates an immersive experience for the game player.
* **Graphical Components** – The UI uses graphical components (e.g., `JFrame`, `JPanel`, `Graphics2D`) to render the game board, animate bricks breaking, and display a dynamic score/lives interface.
* **Responsive Game Loop** – A game loop updates positions, handles rendering, and enforces consistent frame rates for smooth motion and user interaction.

## Technology Stack

### GUI:
* Java (JDK 8)
* Eclipse IDE
* Java Swing / AWT for GUI components
* Game loop

### OOP & Architecture:
* Java classes with methods to abstract behavior
* Encapsulation of game logic, rendering, and user input
* Modular design to allow easy extension of game functionality

## Why I Chose These Technologies

* **Java** – Provides strong object-oriented features, platform independence, and mature GUI libraries, making it ideal for building desktop games and mastering OOP principles.
* **Java Swing / AWT** – Enables low-level access to drawing and event handling, which is essential for implementing custom animation, collision detection, and game logic.


## Future Improvements

Future versions of the game could include:
* **Power-ups & special bricks** – Introducing bricks that drop bonuses, paddle extensions, or ball multipliers.
* **Multiple levels & themes** – Adding level progression with varying brick layouts, speed, and visuals.
* **High-score leaderboard** – Persisting player scores to a database that displays a ranking.
* **Mobile or web port** – Rebuilding the game in a mobile or browser environment for broader accessibility.
* **Sound and animation upgrades** – Enhancing the experience through audio effects, transitions, and dynamic animations.

## Getting Started

To run this project locally:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/HenryEA/Java_Brick_Game.git  
   ```
2. **Open in Eclipse:**

   * In Eclipse: *File → Import → Existing Projects into Workspace*
   * Select the project folder.
3. **Compile and run:**

   * Ensure you have a compatible JDK installed (Java 8+).
   * In Eclipse: Right-click the `GameBoard` (or main class) → *Run As → Java Application*.
4. **Play the game:**

   * Use the paddle controls (arrow keys or mouse) to bounce the ball, clear bricks, track your score, and keep your lives.
