package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class SideBar extends JToolBar {

    public SideBar() {

        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getEditStateAction());
        add(MainFrame.getInstance().getActionManager().getConnectStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveDiagramStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomIn());
        add(MainFrame.getInstance().getActionManager().getZoomOut());


    }

}
