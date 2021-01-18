package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;
import de.fachinformatiker.ae.baudis.graphic.primitive.Line;
import de.fachinformatiker.ae.baudis.graphic.primitive.Oval;
import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangle;

import java.util.Scanner;

public class AddMenu implements MenuState {

    @Override
    public void printMenu() {
        System.out.println("Which primitive?");
        System.out.println("(1) Point");
        System.out.println("(2) Line");
        System.out.println("(3) Ellipse");
        System.out.println("(4) Rectangle");
        System.out.println("(x) Back");
    }

    @Override
    public MenuState processMenu(Draw draw) {
        MenuState state = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exit = false;
        while(!exit){
            switch (input) {
                case "1":
                    Point point = setParametersPoint();
                    draw.add(point);
                    exit = true;
                    state = new DrawableMenu();
                    break;
                case "2":
                    Line line = setParametersLine();
                    draw.add(line);
                    exit = true;
                    state = new DrawableMenu();
                    break;
                case "3":
                    Oval oval = setParametersOval();
                    draw.add(oval);
                    exit = true;
                    state = new DrawableMenu();
                    break;
                case "4":
                    Rectangle rectangle = new Rectangle();
                    draw.add(rectangle);
                    exit = true;
                    state = new DrawableMenu();
                    break;

                case "x":
                    exit = true;
                    state = new DrawableMenu();
                    break;

            }
        }
        return state;
    }

    private Oval setParametersOval() {
        Scanner scanner = new Scanner(System.in);
        Point middlePoint = setParametersPoint();
        System.out.println("Type width");
        double width = scanner.nextDouble();
        System.out.println("Type height");
        double height = scanner.nextDouble();
        return new Oval(middlePoint, width, height);
    }

    private Point setParametersPoint() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type x-coordinate: ");
        double x = scanner.nextDouble();
        System.out.println("Type y-coordinate: ");
        double y = scanner.nextDouble();
        return new Point(x, y);
    }

    private Line setParametersLine(){
        System.out.println("Start Point");
        Point startPoint = setParametersPoint();
        System.out.println("End Point");
        Point endPoint = setParametersPoint();
        return new Line(startPoint, endPoint);
    }
}