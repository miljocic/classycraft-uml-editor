package raf.dsw.classycraft.app.logg.messages;

import raf.dsw.classycraft.app.observer.IPublisher;

public interface MessageGenerator extends IPublisher {

    void generateMessage(ErrorType errorType);

}
