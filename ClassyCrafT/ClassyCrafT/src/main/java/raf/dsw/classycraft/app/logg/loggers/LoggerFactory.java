package raf.dsw.classycraft.app.logg.loggers;

public class LoggerFactory {

    public LoggerFactory() {
    }

    public ConsoleLogger createConsoleLogger() {
        return new ConsoleLogger();
    }

    public FileLogger createFileLogger() {
        return new FileLogger();
    }

}
