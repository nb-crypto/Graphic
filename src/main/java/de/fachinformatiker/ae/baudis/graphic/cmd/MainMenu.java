package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class MainMenu implements MenuState {


    public void printMenu() {
        System.out.println("Main Menu");
        System.out.println("(1) current drawing");
        System.out.println("(2) new drawing");
        System.out.println("(3) save drawing");
        System.out.println("(4) load drawing");
        System.out.println("(x) exit");
    }

    @Override
    public MenuState processMenu(Draw draw) {
        MenuState state = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exit = false;
        while (!exit) {
            switch (input) {
                case "1":

                    state = new DrawableMenu();
                    exit = true;
                    break;
                case "4":
                    state = new LoadMenu();
                    exit = true;
                    break;
                case "3":
                    state = new SaveMenu();
                    exit = true;
                    break;

                case "2":
                    draw.clear();
                    state = new DrawableMenu();
                    exit = true;
                    break;
                case "x":
                    exit = true;
                    state = null;
                    break;

            }
        }
        return state;
    }
}
