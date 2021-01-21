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
    public MenuState processMenu(Draw draw) {
        MenuState state = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!exit) {
            switch (input) {
                case "1":
                    draw.drawLoad(load());
                    //load1(draw);
                    exit = true;
                    state = new DrawableMenu();
                    break;

                case "x":
                    exit = true;
                    state = new MainMenu();
            }
        }
        return state;
    }

    private Draw load() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of the File to load: ");
        String name = scanner.nextLine();
        String filename = name + ".ser";
        InputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            ObjectInputStream o = new ObjectInputStream(fis);
            return  (Draw) o.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void load1(Draw draw) {
        Draw drawLoad = new Draw();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of the File to load: ");
        String name = scanner.nextLine();
        String filename = name + ".ser";
        InputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            ObjectInputStream o = new ObjectInputStream(fis);
            drawLoad = (Draw) o.readObject();
            draw.clear();
            draw.clearGraphicObservers();
            if (drawLoad.getSizePrimitives() > 0) {
                for (int i = 0; i < drawLoad.getSizePrimitives(); i++) {
                    draw.add(drawLoad.getPrimitive(i));
                }
            }
            if (drawLoad.getSizeGraphicObservers() > 0) {
                for (int i = 0; i < drawLoad.getSizeGraphicObservers(); i++) {
                    draw.addObserver(drawLoad.getGraphicObserver(i));
                }
            }


            /*int length = draw.getSizePrimitives();
            for (int i = 0; i < length; i++) {
                draw.add(draw.getPrimitive(i));
            }*/


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
