package ru.nsu.ivannikova.logoworld;

import ru.nsu.ivannikova.logoworld.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LW {
    boolean mode = false;
    int width = 10, height = 10;
    boolean Field[][] = new boolean[width][height];

    public void print(Point point) {
        System.out.print("X  ");
        for (int i = 0; i < width; i++)
            System.out.print(i + "  ");
        System.out.println();
        for (int j = 0; j < height; j++) {
            System.out.print(j + "  ");
            for (int i = 0; i < width; i++) {
                if (i == point.xPoint() && j == point.yPoint()) {
                    System.out.print("o  ");
                    continue;
                }
                if (Field[i][j]) System.out.print("*  ");
                else System.out.print(".  ");
            }
            System.out.println();
        }


    }

    public void changeSize(int Width, int Height) {
        width = Width;
        height = Height;
    }

    public void changeMode() {
        if (mode) mode = false;
        else mode = true;
    }

    public boolean isMode() {
        return mode;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void changeField(int x, int y) {
        Field[x][y] = true;
    }


    public static void main(String[] args) throws IOException {

        try {
            LW lw = new LW();
            Point point = new Point();
            Factory factory = new Factory("ru/nsu/ivannikova/logoworld/config.txt");
            System.out.println("Hello! Your default field is " + lw.getWidth() + "x" + lw.getHeight() + " and point is [0;0]. Enter 'EXIT' for exit.\nUse commands:\nINIT\nMOVE\nDRAW\nWARD\nTELE\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String command = null;
            char commandName[];
            char name[] = new char[4];
            char parameters[] = new char[20];
            Command c;
            lw.print(point);


            while (!(command = br.readLine()).equals("EXIT")) {

                commandName = command.toCharArray();
                for (int i = 0; i < parameters.length; i++)
                    parameters[i] = '\0';
                for (int i = 0; i < commandName.length; i++) {
                    if (i < 4) name[i] = commandName[i];
                    else parameters[i - 4] = commandName[i];
                }


                String Name = new String(name);
                final String Parameters = new String(parameters);

                if (Name.equals("INIT")) c = (Command) factory.create("INIT");
                else if (Name.equals("DRAW")) c = (Command) factory.create("DRAW");
                else if (Name.equals("MOVE")) c = (Command) factory.create("MOVE");
                else if (Name.equals("TELE")) c = (Command) factory.create("TELE");
                else if (Name.equals("WARD")) c = (Command) factory.create("WARD");
                else {
                    System.out.println("Wrong commands");
                    continue;
                }

                c.execute(lw, point, Parameters);

                lw.print(point);
                System.out.println("Your point is: (" + point.xPoint() + ";" + point.yPoint() + ")");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
