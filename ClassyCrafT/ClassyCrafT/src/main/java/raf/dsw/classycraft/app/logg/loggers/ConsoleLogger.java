package raf.dsw.classycraft.app.logg.loggers;

import raf.dsw.classycraft.app.logg.messages.Message;

public class ConsoleLogger implements Logger {

    public ConsoleLogger() {
    }


    @Override
    public void log(Message message) {
        System.out.println("[" + message.getErrorType() + "]" + "[" + message.getTimestamp()
                + "[" + message.getText() + "]");
    }

    @Override
    public void update(Object notification) {
        this.log((Message) notification);
    }
}

