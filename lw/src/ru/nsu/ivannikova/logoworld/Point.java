package ru.nsu.ivannikova.logoworld;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 12.05.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    int x = 0, y = 0;

    public void changePoint(int X, int Y) {
        x = X;
        y = Y;
    }

    public int xPoint() {
        return x;
    }

    public int yPoint() {
        return y;
    }
}
