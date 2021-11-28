
import java.awt.*;
import java.awt.event.KeyEvent;


public class DrawPoint {
    private boolean flagw = false; // 按下时为true，松开为false
    private boolean flagb = false;
    private int x = 40; // x坐标


    public void draw(Graphics g) {
        g.setColor(Color.pink);// 按下时在琴键上显示圆，松开时圆消失
        if (flagw)
            g.fillOval(x, 400, 40, 40);
        if (flagb)
            g.fillOval(x, 200, 40, 40);
    }




    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k) {
            case 90:
                x = 40;
                flagw = true;
                break;
            case 67:
                x = 142;
                flagw = true;
                break;
            case 66:
                x = 244;
                flagw = true;
                break;
            case 77:
                x = 346;
                flagw = true;
                break;
            case 65:
                x = 448;
                flagw = true;
                break;
            case 83:
                x = 550;
                flagw = true;
                break;
            case 68:
                x = 652;
                flagw = true;
                break;
            case 70:
                x = 754;
                flagw = true;
                break;
            case 71:
                x = 856;
                flagw = true;
                break;
            case 72:
                x = 958;
                flagw = true;
                break;
            case 74:
                x = 1060;
                flagw = true;
                break;
            case 75:
                x = 1162;
                flagw = true;
                break;
            case 76:
                x = 1264;
                flagw = true;
                break;
            case 80:
                x = 1366;
                flagw = true;
                break;
            case 88:
                x = 80;
                flagb = true;
                break;
            case 86:
                x = 212-30;
                flagb = true;
                break;
            case 78:
                x = 314-30;
                flagb = true;
                break;
            case 87:
                x = 518-30;
                flagb = true;
                break;
            case 69:
                x = 620-30;
                flagb = true;
                break;
            case 84:
                x = 824-30;
                flagb = true;
                break;
            case 89:
                x = 926-30;
                flagb = true;
                break;
            case 85:
                x = 1028-30;
                flagb = true;
                break;
            case 73:
                x = 1232-30;
                flagb = true;
                break;
            case 79:
                x = 1334-30;
                flagb = true;
                break;

        }
    }
    public void keyReleased() {
        flagw = false;
        flagb = false;
    }
}
