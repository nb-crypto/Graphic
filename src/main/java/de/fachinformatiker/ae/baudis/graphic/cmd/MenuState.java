package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

public interface MenuState {
    void printMenu();

    MenuState processMenu(Draw draw);
}
