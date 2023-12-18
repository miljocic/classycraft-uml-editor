package raf.dsw.classycraft.app.core;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.loggers.ConsoleLogger;
import raf.dsw.classycraft.app.logg.loggers.FileLogger;
import raf.dsw.classycraft.app.logg.loggers.Logger;
import raf.dsw.classycraft.app.logg.loggers.LoggerFactory;
import raf.dsw.classycraft.app.logg.messages.MessageGenerator;
import raf.dsw.classycraft.app.logg.messages.MessageGeneratorImplementation;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    protected ClassyRepository classyRepository;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;

    private static ApplicationFramework instance;
    private Serializer serializer;

    //buduca polja za model celog projekta

    private ApplicationFramework(){

    }

    public void run(){this.gui.start();}

    public void initialize(Gui gui, ClassyRepository classyRepository,
                           MessageGenerator messageGenerator,
                           Serializer serializer, Logger logger){
        this.gui = gui;
        this.classyRepository = classyRepository;
        this.messageGenerator = new MessageGeneratorImplementation();
        this.consoleLogger =  new LoggerFactory().createConsoleLogger();
        this.fileLogger = new LoggerFactory().createFileLogger();
        this.serializer = serializer;
        this.messageGenerator.addSubscriber(consoleLogger);
        this.messageGenerator.addSubscriber(fileLogger);
        this.messageGenerator.addSubscriber(MainFrame.getInstance());
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
