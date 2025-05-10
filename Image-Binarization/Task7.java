import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Task7AllMethods {
    public static void main(String[] a) {
        try {
            Scanner input = new Scanner(System.in);
            BufferedImage img = ImageIO.read(new File("input.jpg"));
            int w = img.getWidth(), h = img.getHeight(), N = w * h;
            int[] hist = new int[256];
            for (int y = 0; y < h; y++)
                for (int x = 0; x < w; x++) {
                    int p = img.getRGB(x, y);
                    int g = ((p >> 16) & 255 + (p >> 8) & 255 + p & 255) / 3;
                    hist[g]++;
                }

            for (int ch = 1; ch <= 6; ch++) {
                int t = 128;

                if (ch == 1) {
                    System.out.print("Method 1 - Manual: Enter threshold (0-255): ");
                    t = input.nextInt();
                }

                if (ch == 2) {
                    System.out.print("Method 2 - Percent Black: Enter black ratio (0.0 - 1.0): ");
                    double r = input.nextDouble(); int s = 0;
                    for (int i = 0; i < 256; i++) {
                        s += hist[i];
                        if (s >= N * r) { t = i; break; }
                    }
                }

                if (ch == 3) {
                    int t0 = 127;
                    while (true) {
                        int sa = 0, sb = 0, na = 0, nb = 0;
                        for (int i = 0; i < 256; i++) {
                            if (i <= t0) { sa += i * hist[i]; na += hist[i]; }
                            else { sb += i * hist[i]; nb += hist[i]; }
                        }
                        int m1 = na == 0 ? 0 : sa / na;
                        int m2 = nb == 0 ? 0 : sb / nb;
                        int nt = (m1 + m2) / 2;
                        if (nt == t0) break;
                        t0 = nt;
                    }
                    t = t0;
                }

                if (ch == 4) {
                    double maxE = -1;
                    for (int k = 1; k < 255; k++) {
                        int sum1 = 0, sum2 = 0;
                        for (int i = 0; i <= k; i++) sum1 += hist[i];
                        for (int i = k + 1; i < 256; i++) sum2 += hist[i];
                        if (sum1 == 0 || sum2 == 0) continue;
                        double H1 = 0, H2 = 0;
                        for (int i = 0; i <= k; i++) {
                            if (hist[i] == 0) continue;
                            double p = (double) hist[i] / sum1;
                            H1 -= p * Math.log(p);
                        }
                        for (int i = k + 1; i < 256; i++) {
                            if (hist[i] == 0) continue;
                            double p = (double) hist[i] / sum2;
                            H2 -= p * Math.log(p);
                        }
                        double H = H1 + H2;
                        if (H > maxE) { maxE = H; t = k; }
                    }
                }

                if (ch == 5) {
                    double minJ = Double.MAX_VALUE;
                    double[] p = new double[256];
                    for (int i = 0; i < 256; i++) p[i] = (double) hist[i] / N;
                
                    for (int k = 1; k < 255; k++) {
                        double w0 = 0, w1 = 0, u0 = 0, u1 = 0;
                        for (int i = 0; i <= k; i++) { w0 += p[i]; u0 += i * p[i]; }
                        for (int i = k + 1; i < 256; i++) { w1 += p[i]; u1 += i * p[i]; }
                        if (w0 == 0 || w1 == 0) continue;
                        u0 /= w0; u1 /= w1;
                
                        double s0 = 0, s1 = 0;
                        for (int i = 0; i <= k; i++) s0 += p[i] * (i - u0) * (i - u0);
                        for (int i = k + 1; i < 256; i++) s1 += p[i] * (i - u1) * (i - u1);
                        s0 = s0 / w0;
                        s1 = s1 / w1;
                
                        if (s0 <= 0 || s1 <= 0) continue;
                
                        double J = 1 + 2 * (w0 * Math.log(s0) + w1 * Math.log(s1)) - 2 * (w0 * Math.log(w0) + w1 * Math.log(w1));
                
                        if (J < minJ) {
                            minJ = J;
                            t = k;
                        }
                    }
                
                    if (t < 70) t = 70;
                }
                

                if (ch == 6) {
                    double[] p = new double[256];
                    for (int i = 0; i < 256; i++) p[i] = (double) hist[i] / N;
                    double best = Double.MAX_VALUE;
                    for (int k = 1; k < 255; k++) {
                        double w1 = 0, u1 = 0, w2 = 0, u2 = 0;
                        for (int i = 0; i <= k; i++) { w1 += p[i]; u1 += i * p[i]; }
                        for (int i = k + 1; i < 256; i++) { w2 += p[i]; u2 += i * p[i]; }
                        if (w1 == 0 || w2 == 0) continue;
                        u1 /= w1; u2 /= w2;
                        double fuzziness = 0;
                        for (int i = 0; i <= k; i++) fuzziness += p[i] * (i - u1) * (i - u1);
                        for (int i = k + 1; i < 256; i++) fuzziness += p[i] * (i - u2) * (i - u2);
                        if (fuzziness < best) { best = fuzziness; t = k; }
                    }
                }

                BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
                for (int y = 0; y < h; y++)
                    for (int x = 0; x < w; x++) {
                        int p = img.getRGB(x, y);
                        int g = ((p >> 16) & 255 + (p >> 8) & 255 + p & 255) / 3;
                        out.setRGB(x, y, g < t ? 0x000000 : 0xFFFFFF);
                    }

                String name = "output_method" + ch + ".jpg";
                ImageIO.write(out, "jpg", new File(name));
                System.out.println("Saved: " + name + " (threshold: " + t + ")");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
