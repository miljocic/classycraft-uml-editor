package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class MainFrame extends JFrame {

    private static MainFrame instance;

    //buduca polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private ClassyTree classyTree;

    private MainFrame(){

    }


    private void initialize(){

        actionManager = new ActionManager();
        initializeGui();
    }
    private void initializeGui(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");

        menu = new MyMenyBar();
        setJMenuBar(menu);

        toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
    }



    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

}
