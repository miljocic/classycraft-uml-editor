package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());

//        ExitAction ea = new ExitAction();
//        add(ea);

        add(MainFrame.getInstance().getActionManager().getNewAction());

        add(MainFrame.getInstance().getActionManager().getDeleteAction());

        add(MainFrame.getInstance().getActionManager().getAboutUsAction());

        add(MainFrame.getInstance().getActionManager().getAuthorAction());

        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getExportAction());



//        AboutUsAction aboutUsAction = new AboutUsAction();
//        add(aboutUsAction);
    }
}
