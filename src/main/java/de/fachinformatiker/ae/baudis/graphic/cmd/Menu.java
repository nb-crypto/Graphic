package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

public class Menu {
    private Draw draw = new Draw();
    private MenuState state = new MainMenu();

    public void printMenu(){
        state.printMenu();
    }

    public MenuState processMenu(){
        return state.processMenu(draw);
    }

    private void handleMenu() {
        while (state != null){
            printMenu();
            state = processMenu();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.handleMenu();
    }

}
