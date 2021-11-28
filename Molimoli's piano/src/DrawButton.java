
import play.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawButton {

        public void draw() {
            // 画白键
            int x = 0;
            for (int i = 0; i < 14; i++) {
                JButton button=new JButton();
                button.setBackground(Color.white);
                button.setBounds(x,0,100,500);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        PlaySound.F2 thread = new PlaySound.F2();
                        thread.start();
                    }
                });
                x += 102;
            }
            // 画黑键
            x = 70;
            for (int i = 1; i < 14; i++) {
                if (!(i == 4 || i == 7 || i == 11)){
                    JButton button=new JButton();
                    button.setBackground(Color.black);
                    button.setBounds(x,0,62,300);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            PlaySound.F2 thread = new PlaySound.F2();
                            thread.start();
                        }
                    });
                    x += 102;}
                x += 102;
            }




            }
        }



