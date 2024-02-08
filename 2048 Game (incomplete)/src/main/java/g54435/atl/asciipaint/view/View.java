package g54435.atl.asciipaint.view;

/**
 * Class view
 */
public class View {

    /**
     * Show Help text
     */
    public void showHelp() {
        System.out.println("Bienvenue sur la page d'aide de l'application AsciiPaint\n" +
                "L'application AsciiPaint vous permet de dessiner quelques formes de base via un caractère " +
                "définit, des tailles et des positions sur le terminal.\n" +
                "Voici la liste des commandes disponibles : \n" +
                "add circle [X] [Y] [RADIUS] [COLOR]\n" +
                "add rectangle [X] [Y] [WIDTH] [HEIGHT] [COLOR]\n" +
                "add square [X] [Y] [SIDE] [COLOR]\n" +
                "show");
        System.out.println("Veuillez entrer votre commande : ");
    }

    /**
     * Show the draw, if not one shape is added, show a blank page
     * @param draw
     */
    public void showDraw(String draw) {
        System.out.println(draw);
    }

    /**
     * Show an error
     */
    public void showError() {
        System.out.println("Commande invalide, tapez !help pour voir la liste des commandes");
    }

    /**
     * When a shape is added, this message is showed
     */
    public void showSuccess() {
        System.out.println("Forme ajoutée !");
    }
}
