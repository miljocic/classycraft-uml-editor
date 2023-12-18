package raf.dsw.classycraft.app;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.core.Serializer;
import raf.dsw.classycraft.app.gui.swing.SwingGui;
import raf.dsw.classycraft.app.logg.loggers.FileLogger;
import raf.dsw.classycraft.app.logg.loggers.Logger;
import raf.dsw.classycraft.app.logg.messages.MessageGenerator;
import raf.dsw.classycraft.app.logg.messages.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.repository.ClassyRepositoryImpl;
import raf.dsw.classycraft.app.serializer.GsonSerializer;


public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        ClassyRepository classyRepository = new ClassyRepositoryImpl();
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        Logger logger = new FileLogger();
        Serializer serializer = new GsonSerializer();
        appCore.initialize(gui, classyRepository, messageGenerator, serializer, logger);
        appCore.run();
    }
}