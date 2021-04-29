package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class RemoveMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Remove Menu");
        System.out.println("(1) remove (by index)");
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
                    remove(menuOperation.getDraw());
                    state = new DrawableMenu();
                    exit = true;
                    break;

                case "x":
                    exit = true;
                    state = new DrawableMenu();
                    break;

                default:
                    System.err.println("Button does not exist! Please type again!");
                    exit = true;
                    state = new RemoveMenu();

            }


        }
        return state;
    }

    private void remove(Draw draw) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type index: ");
        int input = scanner.nextInt();
        if (input <= draw.getSizePrimitives() && input > 0) {
            draw.remove(draw.getPrimitive(input - 1));
        } else {
            System.out.println("Error! No Index " + input);
        }
        System.out.println();
    }
}
