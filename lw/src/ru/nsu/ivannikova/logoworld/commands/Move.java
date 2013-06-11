package ru.nsu.ivannikova.logoworld.commands;

import ru.nsu.ivannikova.logoworld.*;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15.04.13
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
public class Move implements Command {
    public void execute(LW lw, Point point, String parameters) {
        //System.out.println(parameters);
        char direction = 'E';
        int steps = 0;
        char c;
        //System.out.println(parameters.length());
        c = parameters.charAt(0);
        for (int i = 0; i < parameters.length(); i++) {
            if (c == 'U' || c == 'D' || c == 'R' || c == 'L')
                direction = c;
            while (c >= '0' && c <= '9') {
                steps = steps * 10 + c - 48;
                c = parameters.charAt(i);
                //   System.out.println(i + " " + c);
                i++;

            }
            c = parameters.charAt(i);
            //System.out.println(i + " " + c);
            //System.out.println(direction);
            // System.out.println(steps);
        }

        if (direction == 'E') {
            System.out.println("Error! Wrong direction");
            return;
        }


        int i, j;
        switch (direction) {
            case 'R': {
                // System.out.println("bef" + steps);
                if (lw.isMode() && steps / lw.getWidth() >= 1)
                    for (i = 0; i < lw.getWidth(); i++)
                        lw.changeField(i, point.yPoint());

                steps %= lw.getWidth();
                // System.out.println("aft" + steps);

                for (i = point.xPoint(); i < lw.getWidth() && steps != -1; i++, steps--) {
                    if (lw.isMode())
                        lw.changeField(i, point.yPoint());
                    point.changePoint(i, point.yPoint());
                    //      System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    //        System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }
                //    System.out.println("Your point is: (" + point.xPoint() + ";" + point.yPoint() + ")");


                for (i = 0; steps != -1 && i < lw.getWidth(); i++, steps--) {
                    if (lw.isMode())
                        lw.changeField(i, point.yPoint());
                    point.changePoint(i, point.yPoint());
                }
                //    System.out.println("Your point is: (" + point.xPoint() + ";" + point.yPoint() + ")");

            }


            case 'L': {
                if (lw.isMode() && steps / lw.getWidth() >= 1)
                    for (i = 0; i < lw.getWidth(); i++)
                        lw.changeField(i, point.yPoint());

                steps %= lw.getWidth();

                for (i = point.xPoint(); i > 0 && steps != -1; i--, steps--) {
                    if (lw.isMode())
                        lw.changeField(i, point.yPoint());
                    point.changePoint(i, point.yPoint());
                    //    System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    //        System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }

                for (i = lw.getWidth() - 1; steps > 0 && i >= 0; i--, steps--) {
                    if (lw.isMode())
                        lw.changeField(i, point.yPoint());
                    point.changePoint(i, point.yPoint());
                    // System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    // System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }
            }
            case 'D': {
                // System.out.println("bef" + steps);
                if (lw.isMode() && steps / lw.getHeight() >= 1)
                    for (i = 0; i < lw.getHeight(); i++)
                        lw.changeField(point.xPoint(), i);

                steps %= lw.getHeight();
                // System.out.println("aft" + steps);

                for (i = point.yPoint(); i < lw.getHeight() && steps != -1; i++, steps--) {
                    if (lw.isMode())
                        lw.changeField(point.xPoint(), i);
                    point.changePoint(point.xPoint(), i);
                    //      System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    //        System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }
                //    System.out.println("Your point is: (" + point.xPoint() + ";" + point.yPoint() + ")");


                for (i = 0; steps != -1 && i < lw.getHeight(); i++, steps--) {
                    if (lw.isMode())
                        lw.changeField(point.xPoint(), i);
                    point.changePoint(point.xPoint(), i);
                }
                //    System.out.println("Your point is: (" + point.xPoint() + ";" + point.yPoint() + ")");

            }


            case 'U': {
                if (lw.isMode() && steps / lw.getHeight() >= 1)
                    for (i = 0; i < lw.getHeight(); i++)
                        lw.changeField(point.xPoint(), i);

                steps %= lw.getHeight();

                for (i = point.yPoint(); i > 0 && steps != -1; i--, steps--) {
                    if (lw.isMode())
                        lw.changeField(point.xPoint(), i);
                    point.changePoint(point.xPoint(), i);
                    //       System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    //       System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }

                for (i = lw.getHeight() - 1; steps > 0 && i >= 0; i--, steps--) {
                    if (lw.isMode())
                        lw.changeField(point.xPoint(), i);
                    point.changePoint(point.xPoint(), i);
                    //        System.out.print("St: " + steps + " ;\n" + "i: " + i + ";\n");
                    //        System.out.println("(" + point.xPoint() + ";" + point.yPoint() + ")");
                }
            }

        }

    }
}
