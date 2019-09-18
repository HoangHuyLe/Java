package com.nhn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton btnSTack;
    private JButton btnQueue;
    private JPanel rootPanel;

    MainForm(){
        add(rootPanel);
        setTitle("Stack and Queue");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Show stack form when click
        btnSTack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StackForm sForm = new StackForm();
                sForm.setVisible(true);
            }
        });

        // Show queue form when click
        // Terminate process if close the main widow
        btnQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                QueueForm qForm = new QueueForm();
                qForm.setVisible(true);
            }
        });


    }



}
