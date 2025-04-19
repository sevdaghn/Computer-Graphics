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

---

# Task2: PPM Image Reader and JPEG Exporter

This is a Java program that reads and displays `.ppm` image files in both **P3 (text)** and **P6 (binary)** formats.  
It also supports color scaling, handles both 1-byte and 2-byte per component images, and saves the result as a `.jpg` file.  
The image is shown in a scaled-up window so small images (like 2x2) are easier to see.

## Features

- Read and display **P3** and **P6** PPM files
- Automatically scales color values to 0–255
- Supports both 1-byte and 2-byte pixel components
- Displays the image in a Swing window (scaled for visibility)
- Saves the output as a JPEG file (`output.jpg`)
- Detects and reports errors in broken or incomplete files

## How to Use

1. Make sure the `.ppm` file you want to test is inside the `ppm_images/` folder.
2. Run `CreateP6.java` to generate a 2x2 test image (optional).
3. Run `Task2.java` to read the image and save it as `output.jpg`.

## Project Files

| File            | Description                                 |
|-----------------|---------------------------------------------|
| `Task2.java`    | Main program that reads, displays, and saves the image
| `CreateP6.java` | Generates a sample P6 test file for testing (2x2 image)
| `output.jpg`    | Exported JPEG version of the image
| `ppm_images/`   | Folder containing test PPM files

## Requirements

- Java 8 or higher  
- A terminal or Java IDE (e.g. IntelliJ, VS Code)

---

# Task3: RGB-CMYK Converter & Color Visualization in Java 🎨

This Java project allows you to convert colors between RGB and CMYK color models, and also visualize colors in RGB and HSV color spaces.

## 💡 What It Does

- ✅ Convert RGB to CMYK
- ✅ Convert CMYK to RGB
- ✅ Display the selected color in a popup window
- ✅ Draw the RGB color cube using 2D visualization
- ✅ Render a circular HSV color space (Hue, Saturation, Value)

---

## 🧪 Files Overview

### `Task3.java`
A color converter with a graphical interface:
- You can choose to convert between RGB and CMYK.
- Enter color values in input boxes.
- The result is shown in a message box.
- A color panel displays the final color visually.

### `Task3_RGBCube.java`
This file draws a simplified RGB color cube using small colored squares.  
Each square represents a unique RGB combination.

### `Task3_HSV.java`
This program creates a circular HSV color map.
- Hue is based on angle.
- Saturation is distance from the center.
- Brightness is set to maximum (1.0).
Useful to understand how HSV works visually.



