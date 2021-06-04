package com.company;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /*int       height     = screenSize.height / 3;
    int       width      = screenSize.width / 4;*/
    int       height     = 500;
    int       width      = 500;
    private int firstc = 0;


    Canvas       drawArea;
    ControlPanel control;
    private PlayerAttributes player;


    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == control.startButton) {

                try {
                    drawArea.init(player);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            } else if (e.getSource() == control.exitButton) {
                System.exit(0); // stop program
                dispose(); // close window
                setVisible(false); // hide window
            }
        }
    };


    public MainFrame() {


        super("TIC TAC TOE");

    }

    public void first(PlayerAttributes player) {

        this.player = player;
        rootPane.setPreferredSize(new Dimension(width, height));
        init();


        addComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawArea = new Canvas(); //se apeleaza constructorul
        control = new ControlPanel(this);


        control.startButton.addActionListener(actionListener);
        control.exitButton.addActionListener(actionListener);

    }

    private void addComponents() {

        add(drawArea, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);

    }

    public void addMove(int x, int y, String shape) {

        drawArea.drawShape(x, y, shape);
    }

    public String getRequest() {
        if (this.getFirstc()== 0) {
            this.setFirstc(1);
            return "start";

        } else

            return "false";
    }

    public int getFirstc() {
        return firstc;
    }

    public void setFirstc(int firstc) {
        this.firstc = firstc;
    }
}
