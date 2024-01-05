package raf.dsw.classycraft.app.gui.swing.worskspace;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;


@Getter
@Setter
public class WorkSpaceImplementation implements Workspace {

    PackageView packageView;

    @Override
    public PackageView generateWorkspace() {
        packageView = new PackageView();
        return packageView;
    }

}
