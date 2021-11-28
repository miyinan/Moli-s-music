


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGui extends Frame {
    private final int WIDTH = 1426; // 宽
    private final int HEIGHT = 500; // 高
    private DrawKey drawKey = new DrawKey();
    private DrawPoint drawPoint = new DrawPoint();
    private DrawButton drawButton= new DrawButton();
    private play.PlaySound playSound = new play.PlaySound();
    private Image ScreenImage = null;

    public MainGui() {
        init();
    }

    @Override
    public void paint(Graphics g) {
        drawKey.draw(g); // 画琴键
        drawPoint.draw(g); // 画圆
        drawButton.draw();
    }
    public void add(){
        this.add();
    }




    private void init() {
        this.setTitle("Molimoli's Piano"); // 设置标题
        this.setSize(WIDTH, HEIGHT); // 设置大小
        this.setBackground(Color.black); // 设置背景颜色为黑色
        this.setResizable(false); // 设置为不可编辑
        this.setVisible(true); // 设置为可见
        // 关闭窗口并且退出程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                playSound.keyPressed(e);
                drawPoint.keyPressed(e);
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                drawPoint.keyReleased();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                repaint();
            }
        });
    }
    public static void main(String[] args){
        new MainGui();
    }
}
