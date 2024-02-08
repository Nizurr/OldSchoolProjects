#include "Player.h"
#include <algorithm>
#include <iostream>
//FIXME Possibilité de directement définir la liste ?
Player::Player() {

}

Player::Player(PlayerColor color) :
        color_{color}
{}

PlayerColor Player::getColor() const {
    return color_;
}

//FIXME Ajout de cette fonction pour plus de facilité, a voir au niveau de la sécurité
void Player::addPiece(Piece p) {
    pieces_.push_back(p);
}

std::vector<Piece>& Player::getPieces() {
    return pieces_;
}

void Player::setPieceAtPosition(Position from, Position at){
    for(Piece &p : this->pieces_){
        if(p.getPositionOnBoard() == from){
            p.setPositionOnBoard(at);
        }
    }
}

Piece& Player::getPiece(Position po) {
    for(Piece& p : this->pieces_){
        if (p.getPositionOnBoard() == po){
            return p;
        }
    }
    throw std::runtime_error("Piece not found");
}

bool Player::hasPieceAt(Position po) {
    for(Piece &p : this->pieces_){
        if (p.getPositionOnBoard() == po){
            return true;
        }
    }
    return false;
}

void Player::removePiece(const Position &pos) {
    auto found = [pos](Piece &p){
        return p.getPositionOnBoard() == pos;
    };
    auto new_end = std::remove_if(this->pieces_.begin(), this->pieces_.end(), found);
    this->pieces_.erase(new_end, this->pieces_.end()); // 'remove_if' ne supprime pas d'éléments, il les décale à la fin de vector, il faut utiliser aussi 'erase'.
}


void Player::setPieceAtPosFound(Position pos, bool found) {
    getPiece(pos).setFound(found);
}
