package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class RemoveMenu implements MenuState{
    @Override
    public void printMenu() {
        System.out.println("Type index or (x) to go back: ");
    }

    @Override
    public MenuState processMenu(Draw draw) {
        MenuState state;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.equals("x")){
            if (Integer.parseInt(input) < draw.getSizePrimitives() && Integer.parseInt(input) >= 0){
                draw.remove(Integer.parseInt(input));
                state = new DrawableMenu();
            }
            else state = new RemoveMenu();
        }
        else state = new DrawableMenu();

        return state;
    }
}
