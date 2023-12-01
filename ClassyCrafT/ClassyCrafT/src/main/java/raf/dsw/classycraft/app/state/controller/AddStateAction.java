package raf.dsw.classycraft.app.state.controller;


import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;



import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddStateAction extends AbstractClassyAction {

    public AddStateAction() {

        putValue(NAME, "Add element");
        putValue(SMALL_ICON, loadIcon("/images/addstate.png"));
        putValue(SHORT_DESCRIPTION, "Add Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
            String[] options = {"Class", "Enum", "Interface"};
            String selectedOption = (String) JOptionPane.showInputDialog(
                    MainFrame.getInstance(),
                    "Choose the type of element to add:",
                    "Element Type",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (selectedOption != null) {
                PackageView packageView = (PackageView) MainFrame.getInstance().getSplitPane().getRightComponent();
                packageView.getAddStateInstance().setElementType(selectedOption);
                MainFrame.getInstance().getWorkspace().getPackageView().startAddState(selectedOption);
            }

        } else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_DIAGRAM_VIEW_SELECTED);
        }

    }
//        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
//            MainFrame.getInstance().getWorkspace().getPackageView().startAddState();
//        }else {
//            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_DIAGRAM_VIEW_SELECTED);
//        }
//
//    }

}
