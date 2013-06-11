package ru.nsu.ivannikova.logoworld.commands;

import ru.nsu.ivannikova.logoworld.*;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 15.04.13
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    public void execute(LW lw, Point point, String parameters);
}
