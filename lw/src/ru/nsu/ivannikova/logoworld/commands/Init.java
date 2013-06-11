package ru.nsu.ivannikova.logoworld.commands;


import ru.nsu.ivannikova.logoworld.*;


/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15.04.13
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class Init implements Command {

    public void execute(LW lw, Point point, String parameters) {
        int width = 0, height = 0, x = 0, y = 0;
        char c;
        int state = 0;
        int i = 0;
        c = parameters.charAt(i);
        while (c == ' ') {
            i++;
            c = parameters.charAt(i);
        }
        while (c >= '0' && c <= '9') {
            width = width * 10 + c - 48;
            i++;
            c = parameters.charAt(i);
        }

        while (c == ' ') {
            i++;
            c = parameters.charAt(i);
        }

        while (c >= '0' && c <= '9') {
            height = height * 10 + c - 48;
            i++;
            c = parameters.charAt(i);
        }
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
        x %= width;
        y %= height;
        //System.out.println(x);
        //System.out.println(y);
        //System.out.println(width);
        //System.out.println(height);

        lw.changeSize(width, height);
        point.changePoint(x, y);
    }


}
