#ifndef GAME_H
#define GAME_H

//#include "Model.h"
#include "Board.h"
#include "Player.h"
#include "GameStatus.h"
#include <fstream>
#include <iostream>
#include <sstream>
#include <regex>
#include <stdlib.h>
#include "LogMessage.h"

class Game {
private:
    Board gameBoard_;
    Player playerRed_;
    Player playerBlue_;
    GameStatus status_;
    int roundPerformed_;

    /**
     * @brief opposingPlayer having the opposing player.
     * @param player the current player which we want his opposing.
     * @return player.
     */
    Player & opposingPlayer(Player & player);

    /**
     * @brief isThereAbstract checking if there are abstract between two positions.
     * @param from position
     * @param to position
     * @return true if there is abstract, false otherwise.
     */
    bool isThereAbstract(Position from, Position to);

    /**
     * @brief countMovement counting how many movements between two positions.
     * @param from position.
     * @param to position.
     * @return nomber of movement.
     */
    int countMovement(Position from, Position to);

    /**
     * @brief currentPlayerRef
     * @return
     */
    Player &currentPlayerRef();

public:
    /**
     * CONSTRUCTEUR POUR TESTS (pour attribution des pieces sans template,...)
     * @param playerRed redPlayer
     * @param playerBlue BluePlayer
     */
    Game(const Player &playerRed,const Player &playerBlue);

    /**
     * @brief Game simple constructor.
     */
    Game();

    /**
     * @brief start start the game.
     */
    void start();

    /**
     * @brief getter for status.
     * @return status.
     */
    GameStatus getStatus() const;

    /**
     * @brief getter for the player Blue.
     * @return player.
     */
    Player getPlayerBlue() const;

    /**
     * @brief getter for the player Red.
     * @return player.
     */
    Player getPlayerRed() const;

    /**
     * @brief getter for board.
     * @return board.
     */
    Board getBoard() const;

    /**
     * @brief getter for roundPerfomed.
     * @return
     */
    int getRoundPerformed() const;

    /**
     * @brief her the hart of the game wher the two player can move thier pieces to th preferrd position.
     * somtimes player defeat other pieces's player and somtimes both of them lose thier pieces.
     * @param from position.
     * @param to position.
     */
    LogMessage makeAMove(Position from, Position to);

    /**
     * @brief updateBoard make update the board after movements.
     */
    void updateBoard();

    /**
     * @brief initialize initialize the game and players.
     * @param loadTemplate asking if you want to load board
     * @param isRedAsking asking if the player Red start
     */
    LogMessage initialize(bool loadTemplate, bool isRedAsking, std::string chemin = 0);

    /**
     * @brief checkTemplate
     * @param templatename
     * @return
     */
    std::pair<LogMessage,std::string> checkTemplate(std::string templatename);

    /**
     * @brief updateStatus
     */
    void updateStatus();

    /**
     * @brief winners somtimes both of the players wins and somtimes one is the victor in game.
     * @return the victores.
     */
    std::vector<Player> winners();
};



#endif // GAME_H
