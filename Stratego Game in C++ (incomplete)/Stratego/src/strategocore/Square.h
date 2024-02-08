#ifndef SQUARE_H
#define SQUARE_H

#include "SquareType.h"
#include <string>
#include "PlayerColor.h"

/**
 * @brief Represent The tile of the game.
*/
class Square {

private:
    SquareType type_;
    // FIXME changer std::string par enum / char
    // Obligé utiliser une string vue que c'est destiné à la VUE, ou alors faire un enum pour les pièces et convertir en string dans la vue mais sera pire / double boulot ?
    // ENUM, convertir l'enum dans la vue afficher des char, et seul le 11 sera une string ?
    std::string piece_;
    PlayerColor ownerOfPiece_;

public:

    /**
     * Ce constructeur initialise la case avec un type eau pour en faire une case innacessible
     * (c'est fait pour la faciilité lors de la création du Board on devra écrire Board() et non Board(LAND))
     */
    Square();
    /**
     * @brief Constructor of Square.
     * @param type the given type.
     */

    Square(SquareType type);

    /**
     * @brief Getter of type.
     * @return a square type.
     */
    inline SquareType getType() const;

    /**
     * @brief setter for the piece.
     * @param p piece symbole.
     */
    inline void setPiece(std::string& p);

    /**
     * @brief getter for piece.
     * @return symbol of the piece.
     */
    inline std::string getPiece() const;

    /**
     * @brief getter for player piece
     * @return the color of the owner
     */
    PlayerColor getPieceOwner() const;

    /**
     * @brief changing for owner piece.
     * @param color new color.
     * @return the owner color.
     */
    void setPieceOwner(PlayerColor color);
};

//Getter
inline SquareType Square::getType() const {
    return this->type_;
}

inline void Square::setPiece(std::string& p) {
    piece_ = p;
}

inline std::string Square::getPiece() const {
    return piece_;
}

inline PlayerColor Square::getPieceOwner() const {
    return ownerOfPiece_;
}

inline void Square::setPieceOwner(PlayerColor color)  {
     ownerOfPiece_ =  color;
}

#endif // SQUARE_H
