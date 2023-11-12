package raf.dsw.classycraft.app.gui.swing.tree.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ClassyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn =null;
    private JTextField edit=null;
    public ClassyTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }

    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof ClassyTreeItem))
            return;

        ClassyTreeItem clicked = (ClassyTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

        if (!(clickedOn instanceof ClassyTreeItem))
            return;

        //Ime ne moze biti prazno!
        if(edit.getText().equals("")) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NAME_CANNOT_BE_EMPTY);
            return;
        }

        /*
        Node already exists
         */

        clicked.setName(edit.getText());
        stopCellEditing();



    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }


}
