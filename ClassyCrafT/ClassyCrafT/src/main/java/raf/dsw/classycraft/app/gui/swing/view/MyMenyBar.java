package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.AboutUsAction;
import raf.dsw.classycraft.app.gui.swing.controller.NewAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar(){

        //Kreiranje File opcije
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewAction());

        //Kreiranje Edit opcije
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        //Kreiranje AboutUs akcije
        AbstractAction aboutUsAction = new AboutUsAction();
        JMenuItem aboutUsMenuItem = new JMenuItem(aboutUsAction);
        NewAction newAction = new NewAction();
        JMenuItem newProjectMenuItem = new JMenuItem(newAction);
        //Dodavanje AboutUs akcije na Edit menu
        editMenu.add(aboutUsMenuItem);
        editMenu.add(newAction);

        //Dodavanje File i Edit na menu bar
        add(fileMenu);
        add(editMenu);

    }

}