#ifndef MODEL_H
#define MODEL_H

#include <array>
#include "Position.h"
#include "Square.h"
#include "GameStatus.h"
#include "Board.h"
#include "Player.h"


/**
 * @brief Interface of the game, contains the mandatory functions to run a game
 *        between to players.
 */
class Model {

    /**
     * @brief Starting the game.
     */
    virtual void start() = 0;

    /**
     * @brief Getting the board of the game.
     * @return board of the game.
     */
    virtual Board getBoard() const = 0;

    /**
     * @brief playerRed
     */
    virtual Player getPlayerRed() const = 0;

    /**
     * @brief playerBlue
     */
    virtual Player getPlayerBlue() const = 0;

    /**
     * @brief To implement the movement for the pieces.
     * @param from The current position of the piece.
     * @param to The destination where the piece will move to.
     */
    virtual void makeAMove(Position from, Position to) = 0;

    /**
     * @brief Represente the status of the game.
     * @return Status the game.
     * @return Status the game.
     */
    virtual GameStatus getStatus() const = 0;

    /**
     * @brief roundPerfomed
     * @return
     */
    virtual int getRoundPerformed() const = 0;


};
#endif // MODEL_H
