package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class DrawableMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Edit Drawing");
        System.out.println("(1) add a primitive");
        System.out.println("(2) remove a primitive");
        System.out.println("(3) copy a primitive");
        System.out.println("(4) list primitives in drawing");
        System.out.println("(x) back");
    }

    @Override
    public MenuState processMenu(MenuOperation menuOperation) {
        MenuState state = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exit = false;
        while (!exit) {
            switch (input) {
                case "1":
                    state = new AddMenu();
                    exit = true;
                    break;
                case "2":
                    state = new RemoveMenu();
                    exit = true;
                    break;
                case "3":
                    state = new CopyMenu();
                    exit = true;

                    break;
                case "4":
                    showDrawing(menuOperation.getDraw());
                    state = new DrawableMenu();
                    exit = true;
                    break;
                case "x":
                    exit = true;
                    state = new MainMenu();
                    break;
                default:
                    System.err.println("Button does not exist! Please type again!");
                    exit = true;
                    state = new DrawableMenu();
            }
        }
        return state;

    }

    public void showDrawing(Draw draw) {
        if (draw.getSizePrimitives() == 0){
            System.out.println("Drawing is empty!");
        }
        else {
            for (int i = 0; i < draw.getSizePrimitives(); i++) {
                System.out.println("Primitives in Drawing: ");
                System.out.println("\tIndex: " + (i + 1) + "\tPrimitive: " + draw.getPrimitive(i));
            }
        }
        System.out.println();
    }
}