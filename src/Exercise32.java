import java.awt.*;
import javax.swing.*;

public class Exercise32 extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Exercise32() {
        setTitle("Structural Line Algorithm");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int x = x1;
        int y = y1;

        // Draw the first pixel
        g.drawLine(x, y, x, y);

        // Repeated pattern: DHDHD
        for (int i = 0; i < Math.min(Math.abs(dx), Math.abs(dy)); i++) {
            x++; // Diagonal step
            y++;
            g.drawLine(x, y, x, y);

            x++; // Horizontal step
            g.drawLine(x, y, x, y);

            x++; // Diagonal step
            y--;
            g.drawLine(x, y, x, y);

            x++; // Horizontal step
            g.drawLine(x, y, x, y);

            x++; // Diagonal step
            y++;
            g.drawLine(x, y, x, y);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Example usage: draw a line using the structural algorithm
        drawLine(g, 100, 100, 500, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Exercise32 app = new Exercise32();
            app.setVisible(true);
        });
    }
}
