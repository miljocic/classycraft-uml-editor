package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        add(MainFrame.getInstance().getActionManager().getAuthorAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getExportAction());
        add(MainFrame.getInstance().getActionManager().getExportCodeAction());
        add(MainFrame.getInstance().getActionManager().getSaveTemplateAction());
        add(MainFrame.getInstance().getActionManager().getLoadTemplateAction());

    }
}
