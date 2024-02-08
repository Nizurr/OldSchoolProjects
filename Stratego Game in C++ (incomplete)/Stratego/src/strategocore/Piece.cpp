#include "Piece.h"

int Piece::getGrade() const {
    return grade_;
}

int Piece::getNbSteps() const {
    return nbSteps_;
}

Position & Piece::getPositionOnBoard() {
    return positionOnBoard_;
}

void Piece::setPositionOnBoard(const Position &positionOnBoard) {
    this->positionOnBoard_  = positionOnBoard;
}

Power Piece::compareForceTo(const Piece &piece) {
    if (this->grade_ == piece.getGrade()) return Power::EQUAL;
    else if (this->grade_ > piece.getGrade()) return Power::STRONGER;
    return Power::WEAKER;
}

const std::string &Piece::getSymbol() const {
    return symbol_;
}

void Piece::setFound(bool hasBeenFound) {
    found_ = hasBeenFound;
}

bool Piece::getFound() {
    return found_;
}
