# Computer Graphics Projects
# Task 1: DrawingPanel - Java Swing Drawing Application

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

# Task 2: PPM Image Reader and JPEG Exporter

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

# Task 3: RGB-CMYK Converter & Color Visualization in Java 🎨

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

---

# Task 4: Pixel-Based Image Transformations in Java

This project is a simple Java program that performs basic pixel-in-point transformations on an input image. The goal is to understand how individual pixels can be manipulated directly to achieve different visual effects.

## 📌 Transformations Applied

The following operations are applied to `input.jpg`, and each result is saved as a separate `.jpg` file:

1. **Negative Transformation**  
   - Each RGB value is subtracted from 255 to invert the image.

2. **Addition (+50 Brightness)**  
   - Brightness is increased by adding 50 to each RGB value, with a limit of 255.

3. **Subtraction (−50 Brightness)**  
   - Brightness is decreased by subtracting 50 from each RGB value, limited to a minimum of 0.

4. **Multiplication (×2)**  
   - All color values are multiplied by 2 to enhance contrast.

5. **Division (/2)**  
   - All color values are divided by 2 to darken the image proportionally.

6. **Grayscale (Method 1: Linear RGB Weights)**  
   - Formula: `0.2126 * R + 0.7152 * G + 0.0722 * B`

7. **Grayscale (Method 2: Luma Coding)**  
   - Formula: `0.299 * R + 0.587 * G + 0.114 * B`

## 💡 Key Concepts

- Used `BufferedImage`, `Color`, and `ImageIO` from Java’s standard libraries.
- `try-catch` is used to handle potential errors like missing files.
- `for` loops are used to process each pixel in the image.
- Math operations ensure color values stay between 0 and 255.

## 🛠 Requirements

- Java 8 or later
- `input.jpg` placed in the root directory

---
## Task 5: Image Histogram Visualization & Enhancement 

This is a simple Java project that demonstrates how to visualize and enhance the histogram of a grayscale image using contrast stretching and histogram equalization.

## 🖼️ What it does

- Loads an image (`image.png`)
- Converts it to grayscale
- Calculates and displays the original histogram
- Applies contrast stretching and shows the updated histogram
- Applies histogram equalization and shows the updated histogram

## 📊 Techniques Used

1. **Grayscale Conversion**  
   Converts the input image into grayscale for processing.

2. **Histogram Calculation**  
   Counts the number of pixels at each brightness level (0–255).

3. **Contrast Stretching**  
   Spreads pixel values between the minimum and maximum brightness to enhance contrast.

4. **Histogram Equalization**  
   Redistributes brightness levels more evenly across the full range using cumulative histogram (CDF).

## 🧪 Output

The program displays three histogram windows:
- Original
- Stretched
- Equalized

These help visualize the effect of each transformation on pixel distribution.

---

# Task 6: Image Binarization with 6 Thresholding Methods

This Java project performs **binarization** (black-and-white conversion) on a grayscale image using **6 different thresholding algorithms**, including both manual and automatic threshold selection.

## 📌 Features

- Supports the following thresholding methods:
  1. Manual Threshold (user input)
  2. Percent Black Selection (user input ratio)
  3. Mean Iterative Selection
  4. Entropy-based Selection
  5. Minimum Error (Kittler-Illingworth)
  6. Fuzzy Minimum Error

- Outputs a separate image file for each method:
  - `output_method1.jpg` through `output_method6.jpg`


## 📂 Input

Place an image named `input.jpg` in the same directory as the code.

> Note: It is recommended to use grayscale or desaturated images for better results.

---



