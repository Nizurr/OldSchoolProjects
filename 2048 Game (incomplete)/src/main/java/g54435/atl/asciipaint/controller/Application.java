package g54435.atl.asciipaint.controller;
import g54435.atl.asciipaint.model.AsciiPaint;
import g54435.atl.asciipaint.view.View;

import java.util.Scanner;

/**
 * Class Application;
 */
public class Application {

    public Application() {
    }

    /**
     * Start the app; initialise the view and create a new AsciiPaint Object
     */
    public void start() {
        AsciiPaint paint = new AsciiPaint();
        View view = new View();
        Scanner cl = new Scanner(System.in);
        String[] cmd = {""};

        while (!cmd[0].equals("show")) {
            String str = cl.nextLine();
            cmd = str.split(" ");
            try {
                if (cmd[0].equals("add")) {
                    if (!(cmd[1].equals("circle") || cmd[1].equals("rectangle") || cmd[1].equals("square"))) {
                        throw new IllegalArgumentException("Commande invalide, tapez !help pour voir la liste des commandes");
                    }
                    if (cmd[1].equals("rectangle") && cmd.length != 7) {
                        throw new IllegalArgumentException("Commande invalide, tapez !help pour voir la liste des commandes");
                    } else if (!cmd[1].equals("rectangle") && cmd.length != 6) {
                        throw new IllegalArgumentException("Commande invalide, tapez !help pour voir la liste des commandes");
                    }


                    if (cmd[1].equals("circle")) {
                        paint.newCircle(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                                Integer.parseInt(cmd[4]), cmd[5].charAt(0));
                        view.showSuccess();
                    } else if (cmd[1].equals("rectangle")) {
                        paint.newRectangle(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                                Integer.parseInt(cmd[4]), Integer.parseInt(cmd[5]), cmd[6].charAt(0));
                        view.showSuccess();

                    } else {
                        paint.newSquare(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                                Integer.parseInt(cmd[4]), cmd[5].charAt(0));
                        view.showSuccess();
                    }
                }
                if (cmd[0].equals("!help")) {
                    view.showHelp();
                }
            } catch (IllegalArgumentException e) {
                view.showError();
            }

        }
        view.showDraw(paint.asAscii());


    }


}
