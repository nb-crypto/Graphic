package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class DrawableMenu implements  MenuState{
    @Override
    public void printMenu() {
        System.out.println("(1) add");
        System.out.println("(2) remove");
        System.out.println("(3) copy");
        System.out.println("(4) list");
        System.out.println("(5) save");
        System.out.println("(x) back");
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
                    state = new AddMenu();
                    exit = true;
                    break;
                case "2":
                    state = new RemoveMenu();
                    exit = true;
                    break;
               case "3":
                   System.out.println("Which index?");
                   input = scanner.nextLine();

                    break;
               case "4":
                   showDrawing(draw);
                   state = new DrawableMenu();
                   exit = true;
                   break;
               case "5":
                   break;
               case "x":
                   exit = true;
                   state = new MainMenu();
                   break;

            }
        }
        return state;

    }

    public void showDrawing(Draw draw){
        for (int i = 0; i < draw.getSizePrimitives(); i++){
            System.out.println("Index: " + (i + 1) + "\tPrimitive: " + draw.getPrimitive(i));
        }
    }
}
