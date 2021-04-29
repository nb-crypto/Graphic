package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Primitive;
import de.fachinformatiker.ae.baudis.graphic.primitive.Line;
import de.fachinformatiker.ae.baudis.graphic.primitive.Oval;
import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangle;

import java.util.Scanner;

public class CopyMenu implements MenuState {

    @Override
    public void printMenu() {
        System.out.println("Copy Menu");
        System.out.println("(1) copy");
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
                    copy(menuOperation);
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
                    state = new CopyMenu();

            }


        }
        return state;
    }

    private void copy(MenuOperation menuOperation) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type index: ");
        int input = scanner.nextInt();
        if (input <= menuOperation.getDraw().getSizePrimitives() && input > 0) {
            Primitive toCopy = menuOperation.getDraw().getPrimitive(input - 1);
            Point point = new Point();
            Line line = new Line();
            Oval oval = new Oval();
            Rectangle rectangle = new Rectangle();
            if (toCopy.getClass() == point.getClass()) {
                menuOperation.getDraw().add(new Point((Point) toCopy));
            } else if (toCopy.getClass() == line.getClass()) {
                menuOperation.getDraw().add(new Line((Line) toCopy));
            } else if (toCopy.getClass() == oval.getClass()) {
                menuOperation.getDraw().add(new Oval((Oval) toCopy));
            } else if (toCopy.getClass() == rectangle.getClass()) {
                menuOperation.getDraw().add(new Rectangle((Rectangle) toCopy));
            }
        } else {
            System.out.println("Error! No Index " + input);
        }
        System.out.println();
    }
}
