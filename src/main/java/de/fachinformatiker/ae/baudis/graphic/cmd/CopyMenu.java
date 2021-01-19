package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;
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
    public MenuState processMenu(Draw draw) {
        MenuState state = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!exit) {
            switch (input) {
                case "1":
                    copy(draw);
                    state = new DrawableMenu();
                    exit = true;
                    break;

                case "x":
                    exit = true;
                    state = new DrawableMenu();
            }


        }
        return state;
    }

    private void copy(Draw draw) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type index: ");
        int input = scanner.nextInt();
        if (input <= draw.getSizePrimitives() && input > 0) {
            Primitive toCopy = draw.getPrimitive(input - 1);
            Point point = new Point();
            Line line = new Line();
            Oval oval = new Oval();
            Rectangle rectangle = new Rectangle();
            if (toCopy.getClass() == point.getClass()) {
                draw.add(new Point((Point) toCopy));
            } else if (toCopy.getClass() == line.getClass()) {
                draw.add(new Line((Line) toCopy));
            } else if (toCopy.getClass() == oval.getClass()) {
                draw.add(new Oval((Oval) toCopy));
            } else if (toCopy.getClass() == rectangle.getClass()) {
                draw.add(new Rectangle((Rectangle) toCopy));
            }
        } else {
            System.out.println("Error! No Index " + input);
        }

    }
}
