package ru.nsu.ivannikova.logoworld;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.*;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15.04.13
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
public class Factory {

    private static Properties prop = new Properties();
    Map<String, Object> map = new HashMap();
    //FileInputStream ins = new FileInputStream("config.txt");

    public Factory(final String str) throws IOException {

        prop.load(ClassLoader.getSystemClassLoader().getResourceAsStream(str));
        // prop.load(ins);
    }

    public Object create(String commandName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = prop.getProperty(commandName);
        Object command;
        if (!map.containsKey(name)) {
            Class c = Class.forName(name);
            command = c.newInstance();
            map.put(name, command);
        } else {
            command = map.get(name);
        }
        return command;

    }
}
