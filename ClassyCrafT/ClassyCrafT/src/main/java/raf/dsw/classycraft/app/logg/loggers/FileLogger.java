package raf.dsw.classycraft.app.logg.loggers;
import raf.dsw.classycraft.app.logg.messages.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {

    public FileLogger() {
    }

    @Override
    public void log(Message message) {
        File file = new File("ClassyCrafT/ClassyCrafT/src/main/resources/log.txt");
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file, true);
            String poruka = "[" + message.getErrorType() + "] " + "[" + message.getTimestamp() + "] - " + "[" + message.getText() + "]\n";
            fileWriter.append(poruka);
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object notification) {
        this.log((Message) notification);
    }
}
