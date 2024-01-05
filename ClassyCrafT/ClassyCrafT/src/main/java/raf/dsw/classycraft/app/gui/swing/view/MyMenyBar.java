package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.gui.swing.controller.AboutUsAction;
import raf.dsw.classycraft.app.gui.swing.controller.AuthorAction;
import raf.dsw.classycraft.app.gui.swing.controller.DeleteAction;
import raf.dsw.classycraft.app.gui.swing.controller.NewAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar() {

        //Kreiranje File opcije
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getOpenAction());

        //Kreiranje Edit opcije
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);


        //Kreiranje AboutUs akcije
        AboutUsAction aboutUsAction = new AboutUsAction();
        JMenuItem aboutUsMenuItem = new JMenuItem(aboutUsAction);
        NewAction newAction = new NewAction();
        JMenuItem newProjectMenuItem = new JMenuItem(newAction);
        DeleteAction deleteAction = new DeleteAction();
        AuthorAction authorAction = new AuthorAction();


        //Dodavanje AboutUs akcije na Edit menu
        editMenu.add(aboutUsMenuItem);
        editMenu.add(newAction);
        editMenu.add(deleteAction);
        editMenu.add(authorAction);


        //Dodavanje File i Edit na menu bar
        add(fileMenu);
        add(editMenu);

    }

}