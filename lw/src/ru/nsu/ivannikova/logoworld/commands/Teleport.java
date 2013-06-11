package ru.nsu.ivannikova.logoworld.commands;

import ru.nsu.ivannikova.logoworld.*;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15.04.13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class Teleport implements Command {
    public void execute(LW lw, Point point, String parameters) {
        int x = 0, y = 0;
        char c;
        int i = 0;
        c = parameters.charAt(i);
        while (c == ' ') {
            i++;
            c = parameters.charAt(i);
        }
        while (c >= '0' && c <= '9') {
            x = x * 10 + c - 48;
            i++;
            c = parameters.charAt(i);
        }

        while (c == ' ') {
            i++;
            c = parameters.charAt(i);
        }

        while (c >= '0' && c <= '9') {
            y = y * 10 + c - 48;
            i++;
            c = parameters.charAt(i);
        }
        //System.out.println("TELEPORT bef: " + x + ' ' + y);
        x %= lw.getWidth();
        y %= lw.getHeight();
        //System.out.println("TELEPORT aft: " + x + ' ' + y);
        point.changePoint(x, y);
    }
}
