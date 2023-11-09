package raf.dsw.classycraft.app.logg.loggers;

import raf.dsw.classycraft.app.logg.messages.Message;
import raf.dsw.classycraft.app.observer.ISubscriber;

public interface Logger extends ISubscriber {

    void log(Message message);

}
