import java.io.FileOutputStream;
import java.io.IOException;

public class CreateP6 {
    public static void main(String[] args) {
        // Try to create the file
        try (FileOutputStream out = new FileOutputStream("ppm_images/Task2.p6.ppm")) {

            // This byte array contains the entire PPM image (header + pixel data)
            byte[] data = {
                // Header: "P6\n2 2\n255\n" → 11 bytes
                0x50, 0x36, 0x0A,       // P6\n
                0x32, 0x20, 0x32, 0x0A, // 2 2\n
                0x32, 0x35, 0x35, 0x0A, // 255\n

                // Pixel data: 4 pixels × 3 bytes = 12 bytes
                (byte)255, 0, 0,        // Red
                0, (byte)255, 0,        // Green
                0, 0, (byte)255,        // Blue
                (byte)255, (byte)255, 0 // Yellow
            };

            // Write the byte data into the file
            out.write(data);

            // Done!
            System.out.println("P6 file created successfully.");

        } catch (IOException e) {
            // If something goes wrong, print the error
            e.printStackTrace();
        }
    }
}
