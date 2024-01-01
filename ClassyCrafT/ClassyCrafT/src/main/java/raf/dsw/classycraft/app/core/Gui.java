package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.command.CommandManager;
import raf.dsw.classycraft.app.observer.ISubscriber;

public interface Gui extends ISubscriber {
    void start();
    void enableUndo();
    void disableUndo();
    void enableRedo();
    void disableRedo();
}
