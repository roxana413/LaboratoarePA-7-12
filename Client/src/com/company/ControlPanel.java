package com.company;


import javax.swing.*;
import java.util.Objects;

public class ControlPanel extends JPanel {
    private final MainFrame frame;


    JButton startButton = new JButton("Start");
    JButton exitButton = new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        add(startButton);
        add(exitButton);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ControlPanel)) return false;
        ControlPanel that = (ControlPanel) o;
        return Objects.equals(frame, that.frame) && Objects.equals(startButton, that.startButton) && Objects.equals(exitButton, that.exitButton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frame, startButton, exitButton);
    }
}