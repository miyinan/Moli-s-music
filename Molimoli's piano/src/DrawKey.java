import java.awt.*;

public class DrawKey {
    public void draw(Graphics g) {
        // 画白键
        int x = 0;
        g.setColor(Color.white);
        for (int i = 0; i < 14; i++) {
            g.fillRect(x, 0, 100, 500);
            x += 102;
        }
        // 画黑键
        x = 70;
        g.setColor(Color.black);
        for (int i = 1; i < 14; i++) {
            if (!(i == 4 || i == 7 || i == 11))
                g.fillRect(x, 0, 62, 300);
            x += 102;
        }
    }
}
