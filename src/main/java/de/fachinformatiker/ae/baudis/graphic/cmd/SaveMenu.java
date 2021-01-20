package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class SaveMenu implements MenuState {
    @Override
    public void printMenu() {
        System.out.println("Save Menu");
        System.out.println("(1) save as...");
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
                    save(draw);
                    exit = true;
                    state = new MainMenu();
                    break;

                case "x":
                    exit = true;
                    state = new MainMenu();
            }
        }
        return state;
    }

    private void save(Draw draw) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name: ");
        String name = scanner.nextLine();
        String filename = name + ".ser";
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(draw);
            /*o.writeInt(draw.getSizePrimitives());
            for (int i = 0; i< draw.getSizePrimitives(); i++) {
                o.writeObject(draw.getPrimitive(i));
            }*/
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
