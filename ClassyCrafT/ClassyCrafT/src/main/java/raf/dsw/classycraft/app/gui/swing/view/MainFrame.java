package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.ActionManager;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.worskspace.WorkSpaceImplementation;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.logg.messages.Message;
import raf.dsw.classycraft.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {


    private static MainFrame instance = null;
    //buduca polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private ClassyTree tree;
    private JTree projectExplorer;
    private JSplitPane splitPane;
    private List<PackageView> packageViews;
    private WorkSpaceImplementation workspace;


    private void initialize() {

        actionManager = new ActionManager();
        tree = new ClassyTreeImplementation();
        packageViews = new ArrayList<PackageView>();
        setIconImage(new ImageIcon(getClass().getResource("/images/applogo.png")).getImage());
        initializeGui();
    }

    private void initializeGui() {

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

        SideBar sideBar = new SideBar();
        add(sideBar, BorderLayout.EAST);

        //Dodavanje sidebara za JTree:
        JTree projectExplorer = tree.generateTree(ApplicationFramework.getInstance().getClassyRepository().getProjectExplorer());
        projectExplorer.addMouseListener(actionManager.getMyMouseListener());
        JPanel desktop = new JPanel();

        workspace = new WorkSpaceImplementation();

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);


    }

    private MainFrame() {

    }

    public static MainFrame getInstance() {
        if (instance == null) {
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
        else if (((Message) notification).getErrorType().equals(ErrorType.NODE_NOT_SELECTED))
            update = JOptionPane.INFORMATION_MESSAGE;
        else
            update = JOptionPane.WARNING_MESSAGE;
        this.add(new JOptionPane(JOptionPane.showOptionDialog(this, ((Message) notification).getText(), "Greska", JOptionPane.YES_NO_CANCEL_OPTION, update, null, dugme, dugme[0])), BorderLayout.CENTER);
    }

}
