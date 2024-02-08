#ifndef BOARD_H
#define BOARD_H

#include <array>
#include "Square.h"
#include "Position.h"

class Board {
private:
    std::array<std::array<Square, 10>,10> squares_;

public:
    /**
     * @brief Simple Constructor
     */
    inline Board();
    /**
     * @brief Getter
     */
    inline std::array<std::array<Square, 10>, 10> getSquares() const;
    /**
     * @brief isInside
     * @param position on board to check
     * @return boolean true if is inside
     */
    inline bool isInside(const Position& pos) const {
        return pos.getColumn() <= int(this->squares_.size()) && pos.getRow() <= int(this->squares_.at(0).size());
    }
    /**
     * @brief getter of type of the square
     * @param position on board to check
     * @return type of the square
     */
    inline SquareType getSquareType(Position pos) const {
        return this->squares_[pos.getRow()][pos.getColumn()].getType();
    }
    /**
     * @brief Put the symbol on the certain position
     * @param p the position
     * @param s the symbol
     * @param owner color of the player
     */
    inline void setSymbolOnSquare(Position p, std::string s, PlayerColor owner);

};

Board::Board() {
    for (int i = 0; i < 10; ++i) {
        for (int j = 0; j < 10; ++j) {
            if (
                    (i == 4 && j == 2) ||
                    (i == 4 && j == 3) ||
                    (i == 5 && j == 2) ||
                    (i == 5 && j == 3) ||
                    (i == 4 && j == 6) ||
                    (i == 4 && j == 7) ||
                    (i == 5 && j == 6) ||
                    (i == 5 && j == 7)
                    ) {
                this->squares_[i][j] =  Square(WATER);
            } else {
                this->squares_[i][j] =  Square();
            }
        }
    }
}

std::array<std::array<Square, 10>, 10> Board::getSquares() const {
    return this->squares_;
}

void Board::setSymbolOnSquare(Position p, std::string s, PlayerColor owner) {
    squares_[p.getRow()][p.getColumn()].setPiece(s);
    squares_[p.getRow()][p.getColumn()].setPieceOwner(owner);
}


#endif // BOARD_H
