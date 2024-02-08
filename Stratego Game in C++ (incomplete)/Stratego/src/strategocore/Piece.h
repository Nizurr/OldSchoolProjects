#ifndef PIECE_H
#define PIECE_H


#include "Position.h"
#include "Power.h"
#include <string>
/**
 * @brief The Piece class is the parent class of all kind of pieces
 */
class Piece {
protected:
    int grade_;
    int nbSteps_ = 1;
    std::string symbol_;
    Position positionOnBoard_;
    bool found_ = false;

public:
    /**
     * @brief getter of piece symbol
     * @return symbole as string
     */
    virtual const std::string &getSymbol() const;

    /**
     * @brief getter of grade piece
     * @return the power of piece
     */
    virtual int getGrade() const;

    /**
     * @brief getter of nomber of steps
     * @return steps possible
     */
    virtual int getNbSteps() const;

    /**
     * @brief getter of position on board
     * @return position
     */
    virtual Position &getPositionOnBoard();

    /**
     * @brief setter for position
     * @param new position
     */
    virtual void setPositionOnBoard(const Position & positionOnBoard);

    /**
     * @brief compare tow pieces according to thier grade
     * @param the other piece
     * @return 0 if the pieces have the grade, +1 if the attacker piece greater than other piece, otherwise -1
     */
    virtual Power compareForceTo(const Piece &piece);

    virtual void setFound(bool hasBeenFound);

    virtual bool getFound();

};



#endif // PIECE_H
