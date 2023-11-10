package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.logg.messages.Message;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {



    //buduca polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private ClassyTree tree;
    private JTree projectExplorer;

    private void initialize(){

        actionManager = new ActionManager();
        tree = new ClassyTreeImplementation();
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

        //Dodavanje sidebara za JTree:
        JTree projectExplorer = tree.generateTree(ApplicationFramework.getInstance().getClassyRepository().getProjectExplorer());
        JPanel desktop = new JPanel();

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    private static MainFrame instance;

    private MainFrame(){

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

    @Override
    public void update(Object notification) {
        int update;
        String[] dugme = {"U redu"};
        if (((Message) notification).getErrorType().equals(ErrorType.ERROR))
            update = JOptionPane.ERROR_MESSAGE;
        else if(((Message) notification).getErrorType().equals(ErrorType.NODE_NOT_SELECTED))
            update = JOptionPane.INFORMATION_MESSAGE;
        else
            update = JOptionPane.WARNING_MESSAGE;
        this.add(new JOptionPane(JOptionPane.showOptionDialog(this, ((Message)notification).getText(), "Greska", JOptionPane.YES_NO_CANCEL_OPTION, update, null, dugme, dugme[0])), BorderLayout.CENTER);
    }

}
