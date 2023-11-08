package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    protected ClassyRepository classyRepository;

    private static ApplicationFramework instance;

    //buduca polja za model celog projekta

    private ApplicationFramework(){

    }

    public void run(){this.gui.start();}
    public void initialize(Gui gui, ClassyRepository classyRepository ){
        this.gui = gui;
        this.classyRepository = classyRepository;
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
