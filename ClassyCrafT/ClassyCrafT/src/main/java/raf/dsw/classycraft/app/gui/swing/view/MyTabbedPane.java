package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;

public class MyTabbedPane extends JTabbedPane {

    public MyTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
    }

    @Override
    public JRootPane getRootPane() {
        return super.getRootPane();
    }

}
