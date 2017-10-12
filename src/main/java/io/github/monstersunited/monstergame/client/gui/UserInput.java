package io.github.monstersunited.monstergame.client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.github.monstersunited.monstergame.client.MonsterGame;
import io.github.monstersunited.monstergame.client.State;

public class UserInput extends JFrame{
    JLabel label;
    JTextField tf;
    JButton button;
    String word = "";

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
                word = tf.getText();
                State state = new State();
                MonsterGame address = new MonsterGame();
                state.enterServerAddress(word);
                address.HostAddress(word);

            } catch(Exception e) {
                System.out.println("lol error"+e);
            }


        }
    }

}
