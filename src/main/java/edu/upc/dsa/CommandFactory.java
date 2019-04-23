package edu.upc.dsa;

import java.util.HashMap;

public class CommandFactory {

    private static CommandFactory instance;
    private HashMap<String, Command> commands;

    private CommandFactory() {
        this.commands = new HashMap<String, Command>();
    }

    public static CommandFactory getInstance(){
        if (instance == null) instance = new CommandFactory();
        return instance;
    }

    public static Command getCommand(String name) {
        Command command = null;
        if (name.equals("C1")) command = new C1();
        else command new C2();
        return command;
    }

    public static Command getCommand2(String name) {
        Command command = null;
        Class c = null;
        try {
            c = Class.forName("edu.upc.dsa" + name);
            command = (Command) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return command;
    }
}
