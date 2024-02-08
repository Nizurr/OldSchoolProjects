#ifndef GUICONTROLER_H
#define GUICONTROLER_H

#include "Game.h"
#include "Position.h"

class GUIControler {

private:
    Game game_; //Modele du jeu

public:

    /**
     * @brief GUIControler simpel constructor.
     */
    GUIControler();
    virtual ~GUIControler();

    /**
     * @brief askBoard get the board.
     * @return
     */
    Board askBoard();

    /**
     * @brief SquareMoved when the movement has taken place.
     * @param from position from.
     * @param to position to.
     * @return
     */
    LogMessage SquareMoved(Position from, Position to); // La vue appelera cette méthode quand un mouvement à eu lieu (un drag/drop event);
    //Appelera un popup si erreur, ou GuiBoard->updateBoard();

    /**
     * @brief playerSetup it gets the player information.
     * @param userConfig
     * @param cheminRED
     * @param cheminBLUE
     * @return
     */
    LogMessage playerSetup(std::pair<bool,bool> userConfig, std::string  cheminRED, std::string cheminBLUE);
    // La vue appelera cette méthode quand elle aura obtenu les informations du joueur (want template ? réposne de setupParty)
    // par la suite si on a le temps, on remplace le boolean par le chemin du fichier. (demande de selectionner la template directement dans la gui);

    /**
     * @brief startGame starting the game.
     */
    void startGame();

    /**
     * @brief whoPlay asking how will play next round.
     * @return
     */
    PlayerColor whoPlay();

    /**
     * @brief updateScore updating score.
     * @return the score of the players, "first" respresnt the RED, "second" represent the BLUE.
     */
    std::pair<int,int> updateScore();

    /**
     * @brief winners getting the winners when the game finished.
     * @return the winners.
     */
    std::vector<Player> winners();

};
#endif // GUICONTROLER_H

