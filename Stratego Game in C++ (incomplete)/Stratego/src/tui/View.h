#ifndef VIEW_H
#define VIEW_H

#include "Board.h"
#include "Player.h"
#include <iostream>
#include <fstream>
#include "LogMessage.h"
#include "PlayerColor.h"

class View {
public:

    /**
     * @brief View simple constructor.
     */
    View();

    /**
     * @brief showBoard showing the board on mode console.
     * @param board
     */
    void showBoard(const Board& board) const;

    /**
     * @brief displayMain
     */
    void displayMain() const;

    /**
     * Ask if the player want to load a template
     * @return true if template need
     */
    LogMessage askMode(const PlayerColor& playerColor);

    /**
     * @brief askSetup
     * @param PlayerColor playerColor
     */
    void askSetup(const PlayerColor& playerColor) const;

    /**
     * @brief askPlayer
     * @return
     */
    bool askPlayer() const;

    /**
     * @brief posXYtoPosA1
     * @param pos
     * @return
     */
    std::string posXYtoPosA1(const Position& pos) const;
    /**
     * @brief askMove
     * @param PlayerColor joueur a qui demander le deplacement
     * @return
     */
    std::pair<Position, Position> askMove(const PlayerColor& playerColor) const;

    /**
     * @brief posA1ToPosXY
     * @param pos
     * @return
     */
    Position posA1ToPosXY(const std::string& pos) const;

    void printLogMessage(const LogMessage& message) const;

    char getChar();
};


#endif // VIEW_H
