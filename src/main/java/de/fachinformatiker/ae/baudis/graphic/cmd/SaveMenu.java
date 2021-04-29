package de.fachinformatiker.ae.baudis.graphic.cmd;


import java.util.Scanner;

public class SaveMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Save Menu");
        System.out.println("(1) save as...");
        System.out.println("(x) cancel");
    }

    @Override
    public MenuState processMenu(MenuOperation menuOperation) {
        MenuState state = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!exit) {
            switch (input) {
                case "1":
                    menuOperation.saveDraw();
                    exit = true;
                    state = new MainMenu();
                    break;

                case "x":
                    exit = true;
                    state = new MainMenu();
                    break;

                default:
                    System.err.println("Button does not exist! Please type again!");
                    exit = true;
                    state = new SaveMenu();

            }
        }
        return state;
    }



}
