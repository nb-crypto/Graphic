package de.fachinformatiker.ae.baudis.graphic.cmd;

import de.fachinformatiker.ae.baudis.graphic.Draw;

import java.io.*;
import java.util.Scanner;

public class Menu implements MenuOperation{
    private Draw draw = new Draw();
    private MenuState state = new MainMenu();

    private void printMenu() {
        state.printMenu();
    }

    private MenuState processMenu() {
        return state.processMenu(this);
    }

    private void handleMenu() {
        while (state != null) {
            printMenu();
            state = processMenu();
        }
    }

    @Override
    public Draw getDraw() {
        return draw;
    }

    @Override
    public void saveDraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Save\nType the filename: ");
        String name = scanner.nextLine();
        String filename = name + ".ser";

        //OutputStream fos = null;
        try(OutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(fos);) {
            //fos = new FileOutputStream(filename);
            //ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(draw);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        /*finally {
            if (fos != null) {
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    @Override
    public void loadDraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Load\nType the filename: ");
        String name = scanner.nextLine();
        String filename = name + ".ser";

        //InputStream fis = null;
        try (InputStream fis = new FileInputStream(filename);
             ObjectInputStream o = new ObjectInputStream(fis);){
            //fis = new FileInputStream(filename);
            //ObjectInputStream o = new ObjectInputStream(fis);
            draw = (Draw) o.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } /*finally {
             if (fis != null) {
                 try {
                     fis.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }*/
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.handleMenu();
    }

}
