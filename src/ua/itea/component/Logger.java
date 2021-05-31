package ua.itea.component;

public class Logger {

    private final String name;

    private Logger(String name){
        this.name = name;
    }

    public static Logger getLogger(String name){
        return new Logger(name);
    }

    public void info(String message){
        System.out.println(name + " - " + message);
    }
}
