#ifndef PLAYER_H
#define PLAYER_H


#include "PlayerColor.h"
#include <vector>
#include "AllPieces.h"

class Player {

private:
    PlayerColor color_;
    std::vector<Piece> pieces_;

public:
    Player();

    /**
     * @brief Constructor of PLayer.
     * @param color The color of the player.
     * @param pieces The pieces owned by the player.
     */
    Player(PlayerColor color);

    /**
     * @brief Getter of color.
     * @return color of the player.
     */
    PlayerColor getColor() const;

    /**
     * @brief addPiece adding pieces to player list.
     * @param p new piece.
     */
    void addPiece(Piece p);

    /**
     * @brief getter for pieces
     * @return list of the pieces
     */
    std::vector<Piece> & getPieces();

    /**
     * @brief moving from position 'from' to new position 'to'
     * @param from old position
     * @param at new position
     */
    void setPieceAtPosition(Position from, Position at);

    /**
     * @brief get piece at certain position.
     * @param po position.
     * @return piece.
     */
    Piece& getPiece(Position po);

    /**
     * @brief removePiece piece from certain position.
     * @param pos position where we remove the piece.
     */
    void removePiece(const Position & pos);

    /**
     * @brief hasPieceAt checking if there is piece at certain position.
     * @param po position where we checking at.
     * @return true if we found piece, otherwise false.
     */
    bool hasPieceAt(Position po);


    void setPieceAtPosFound(Position pos, bool found);

};

#endif // PLAYER_H
