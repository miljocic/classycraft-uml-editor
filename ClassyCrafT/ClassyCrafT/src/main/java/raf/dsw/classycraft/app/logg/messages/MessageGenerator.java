package raf.dsw.classycraft.app.logg.messages;

import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.List;

public interface MessageGenerator extends IPublisher {

    void generateMessage(ErrorType errorType);

}
