package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class SideBar extends JToolBar {

    public SideBar() {

        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
    }

}
