package io.github.monstersunited.monstergame.client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInput extends JFrame{
    JLabel label;
    JTextField tf;
    JButton button;

    public UserInput() {
        setLayout(new FlowLayout());

        label = new JLabel("Please enter yo ip address");
        add(label);

        tf = new JTextField(20);
        add(tf);

        button = new JButton("HELLO HAHAHAHAHA~~~~!!! <3");
        add(button);

        KeyAction e = new KeyAction();
        button.addActionListener(e);

    }

    public class KeyAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {

                String word = tf.getText();
            } catch(Exception e) {
                System.out.println("lol error"+e);
            }
        }
    }

}
