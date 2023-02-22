package org;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Счет-машина");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
        int width = 350;
        int height = 350;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
    }
}
