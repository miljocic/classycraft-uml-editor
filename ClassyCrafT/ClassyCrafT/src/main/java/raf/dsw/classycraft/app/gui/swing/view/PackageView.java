package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class PackageView extends JPanel {

    private JTabbedPane jtp;
    private List<DiagramView> tabs ;
    private JLabel projectName;
    private JLabel author;
    private ClassyNodeComposite paket;
    private Project project;

    public PackageView(){

        jtp = new JTabbedPane();
        add(jtp);

        projectName = new JLabel();
        projectName.setVisible(true);
        add(projectName);

        author = new JLabel();
        author.setVisible(true);
        add(author);

        tabs = new ArrayList<>();

        BoxLayout boxL = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxL);

    }

    public void openTabForDiagram(Diagram diagram) {
        if (diagram != null) {
            DiagramView diagramView = new DiagramView(diagram);
            tabs.add(diagramView);
            jtp.add(diagram.getName(), diagramView);
        }
    }

    public void closeTabForDiagram(Diagram diagram) {
        if (diagram != null) {
            int indexToRemove = -1;
            for (int i = 0; i < tabs.size(); i++) {
                if (tabs.get(i).getDiagram().equals(diagram)) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove != -1) {
                tabs.remove(indexToRemove);
                jtp.remove(indexToRemove);
            }
        }
    }

    public void reloadTabs(ClassyNodeComposite selected){


        tabs.clear();
        jtp.removeAll();
        this.paket = selected;
//        project.addSubscriber(this);
        for(ClassyNode child :  paket.getChildren()){
            DiagramView diagramView = new DiagramView((Diagram) child);
            tabs.add(diagramView);

        }



        for(DiagramView tabN : tabs){
            jtp.add(tabN.getDiagram().getName(),tabN);
        }

        Project p = (Project) project;
        this.author.setText(p.getAuthorName());
        this.projectName.setText(project.getName());
        jtp.setVisible(true);

    }





    /*
    umesto project potrebno mzd paket
     */

}
