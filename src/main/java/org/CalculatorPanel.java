package org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CalculatorPanel extends JPanel  {
   private final JButton display;
    private final JPanel panel;
    private String lastCommand;
    private boolean start;
    BigDecimal result = BigDecimal.ZERO;
    public CalculatorPanel() {
        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));


        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        ActionListener com = new CommandActionDel();

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("÷", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("–", command);
        addButton("0", insert);
        addButton("C", com);
        addButton("=", command);
        addButton("+", command);
        add(panel, BorderLayout.CENTER);
    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }
    private  class CommandActionDel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String del;
            del = e.getActionCommand();
            del= "";
            display.setText(del);

        }
        }


private class InsertAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else lastCommand = command;

            } else {
                calculate(new BigDecimal(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }
    public void calculate(BigDecimal x) {
        switch (lastCommand) {
            case "+":
                result = result.add(x);
                break;
            case "-":
                result = result.subtract(x);
                break;
            case "*":
                result = result.multiply(x);
                break;
            case "/":
                //noinspection BigDecimalMethodWithoutRoundingCalled
                result = result.divide(x);
                break;
            case "=":
                result = x;
                break;
        }
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        display.setText(result.toString());
    }

}

