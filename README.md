# Computer Graphics Projects
# Task1: DrawingPanel - Java Swing Drawing Application

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

# Task2: PPM Image Reader and JPEG Exporter

This is a Java program that reads and displays `.ppm` image files in **P3 (text)** and **P6 (binary)** formats. It supports both 1-byte and 2-byte color components, scales the image for better visibility, and allows the user to export the result as a `.jpg` file.

---

## ✅ Features

- Supports P3 and P6 PPM formats  
- Handles both 1-byte and 2-byte color values (`maxColor > 255`)  
- Displays the image in a Java Swing window  
- Scales small images (e.g., 2x2) for better viewing  
- Saves the output as a `.jpg` image  
- Detects and reports errors in damaged or incomplete files

---

## 🛠 How to Use

1. Make sure you have a `.ppm` file (e.g., `Task2.p6.ppm`) in the `ppm_images/` folder.
2. Run the program using a terminal or Java IDE.
3. The image will be displayed in a window.
4. A file named `output.jpg` will be saved in the root directory.

---

## 📁 Project Files

| File             | Description                                 |
|------------------|---------------------------------------------|
| `Task2.java`     | Main program to read, display, and export   |
| `CreateP6.java`  | Helper file that generates a sample `.ppm`  |
| `output.jpg`     | Exported JPEG file                          |
| `ppm_images/`    | Folder containing test PPM files            |

---

## 🧪 Testing and Error Handling

To test error handling, a broken PPM file was created (`Task2_broken.p6.ppm`) by truncating pixel data.  
When run, the program correctly threw an error:

```bash
java.io.IOException: Incomplete pixel data.
This confirms the program can detect and handle corrupted or incomplete files safely.

📦 Requirements
Java 8 or higher

Terminal or Java IDE (e.g., VS Code, IntelliJ)

PPM files inside a folder called ppm_images

🚀 Running the Application
1. Compile the programs
bash
Copy
Edit
javac Task2.java
javac CreateP6.java
2. (Optional) Create a test PPM image
bash
Copy
Edit
java CreateP6
3. Run the main application
bash
Copy
Edit
java Task2
This will display the image in a window and save output.jpg in the root directory.

