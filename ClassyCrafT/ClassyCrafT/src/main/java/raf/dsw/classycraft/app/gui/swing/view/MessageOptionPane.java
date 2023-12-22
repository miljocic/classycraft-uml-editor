package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.logg.messages.Message;

import javax.swing.*;
import java.awt.*;

public class MessageOptionPane extends JOptionPane {

    public MessageOptionPane(Frame owner, Message message) {
        setBounds(100, 100, 400, 100);
        JOptionPane.showMessageDialog(owner, message.toString());
    }
}
