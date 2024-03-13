import java.awt.*;
import javax.swing.*;

class MidpointLineAlgorithm extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public MidpointLineAlgorithm() {
        setTitle("Midpoint Line Algorithm");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int x = x1;
        int y = y1;

        int p = 2 * dy - dx;

        for (int i = x1; i <= x2; i++) {
            // Plot the pixel at (x, y)
            g.drawLine(x, y, x, y);

            // Update coordinates based on the decision parameter
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                p = p + 2 * dy - 2 * dx;
                y++;
            }
            x++;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Example usage: draw a line from (100, 100) to (500, 300)
        drawLine(g, 100, 100, 500, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MidpointLineAlgorithm app = new MidpointLineAlgorithm();
            app.setVisible(true);
        });
    }
}