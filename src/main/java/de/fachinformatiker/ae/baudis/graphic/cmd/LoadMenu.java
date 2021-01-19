package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class LoadMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Load Menu");
        System.out.println("(1) load a file");
        System.out.println("(x) cancel");
    }

    @Override
    public MenuState processMenu(Draw draw) {
        MenuState state = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!exit) {
            switch (input) {
                case "1":
                    load();
                    break;

                case "x":
                    exit = true;
                    state = new MainMenu();
            }
        }
        return state;
    }

    private void load() {

    }
}
