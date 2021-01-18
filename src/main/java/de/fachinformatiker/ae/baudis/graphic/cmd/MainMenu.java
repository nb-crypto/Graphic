package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.util.Scanner;

public class MainMenu implements MenuState{


    public void printMenu(){
        System.out.println("(1) new drawing");
        System.out.println("(2) load drawing");
        System.out.println("(x) exit");
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
                state = new DrawableMenu();
                exit = true;
                break;
            case "2":
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
