# ComputerGraphicsProjects
# Task1
# DrawingPanel - Java Swing Drawing Application

This is a simple Java Swing GUI application that allows users to draw basic shapes (`line`, `rect`, and `circle`) on a canvas by typing commands into a text field or by clicking on the canvas.

## Features

- Update shape position interactively by clicking on the canvas:
- For rectangles and circles: the shape's top-left corner moves to the clicked point.
- For lines: the entire line moves, maintaining its length and direction.

## How to Use

1. Run the application.
2. In the text field at the bottom, enter a drawing command and click **OK**.
3. The shape will be drawn on the canvas.
4. Click anywhere on the canvas to move the shape:
 - Rectangles and circles will update their position to start from the clicked point.
 - Lines will shift so that the starting point moves to where you clicked.

## Example Commands

| Shape   | Command Example                |
|---------|--------------------------------|
| Line    | `line 50 50 200 200`           |
| Rect    | `rect 100 100 150 150`         |
| Circle  | `circle 120 120 60`            |

> ⚠️ For circles, the third number is interpreted as the diameter (used as both width and height).

## Requirements

- Java 8 or higher
- A Java IDE or terminal to compile and run the code

## Running the Application

Compile and run the program:

```bash
javac Task1.java
java Task1

