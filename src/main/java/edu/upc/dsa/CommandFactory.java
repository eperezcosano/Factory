package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;

public class CommandFactory {

    final static Logger log = Logger.getLogger(CommandFactory.class.getName());
    private static CommandFactory instance;
    private HashMap<String, Command> cache;

    private CommandFactory() {
        this.cache = new HashMap<String, Command>();
    }

    public static CommandFactory getInstance(){
        if (instance == null) instance = new CommandFactory();
        return instance;
    }

    public Command getCommand(String name) {
        Command command = this.cache.get(name);
        if (command == null) {
            log.info("Load " + name);
            command = getCommand2(name);
            this.cache.put(name, command);
        } else {
            log.info("In cache");
        }
        return command;
    }

    public Command getCommand2(String name) {
        Command command = null;
        Class aClass = null;
        try {
            aClass = Class.forName("edu.upc.dsa." + name);
            command = (Command) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return command;
    }
}
