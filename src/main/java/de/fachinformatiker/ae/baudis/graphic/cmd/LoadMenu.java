package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;


import java.io.*;


import java.util.Scanner;

public class LoadMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Load Menu");
        System.out.println("(1) load a file");
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
                    menuOperation.loadDraw();
                    exit = true;
                    state = new DrawableMenu();
                    break;

                case "x":
                    exit = true;
                    state = new MainMenu();
                    break;

                default:
                    System.err.println("Button does not exist! Please type again!");
                    exit = true;
                    state = new LoadMenu();

            }
        }
        return state;
    }


   }
