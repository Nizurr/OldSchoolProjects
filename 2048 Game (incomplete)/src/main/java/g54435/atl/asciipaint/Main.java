package g54435.atl.asciipaint;

import g54435.atl.asciipaint.controller.Application;

/**
 * Main Class
 */
public class Main {
    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("Bienvenue sur AsciiPaint, Inserez votre commande ou tapez !help " +
                "pour connaitre les commandes disponibles");
        Application app = new Application();
        app.start();

    }
}
