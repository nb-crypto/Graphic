package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

public interface MenuOperation {

    Draw getDraw();
    void saveDraw();
    void loadDraw();
}
