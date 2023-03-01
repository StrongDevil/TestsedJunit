package org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public   class CommandActionDel extends CalculatorPanel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String del;
        del = e.getActionCommand();
        del= "";
        display.setText(del);

    }
}