//
// Created by Adnane Azaoum on 10/03/2022.
//

#include "AllPieces.h"
using namespace AllPi;

Marechal::Marechal(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 10;
    this->symbol_ = "10";
}

General::General(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 9;
    this->symbol_ = "9";
}

Colonel::Colonel(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 8;
    this->symbol_ = "8";
}

Major::Major(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 7;
    this->symbol_ = "7";
}

Commandant::Commandant(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 6;
    this->symbol_ = "6";
}

Lieutenant::Lieutenant(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 5;
    this->symbol_ = "5";
}

Sergent::Sergent(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 4;
    this->symbol_ = "4";
}

Demineur::Demineur(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 3;
    this->symbol_ = "3";
}

Eclaireur::Eclaireur(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 2;
    this->nbSteps_ = 10;
    this->symbol_ = "2";
}

Espionne::Espionne(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 1;
    this->symbol_ = "1";
}

Bomb::Bomb(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 11;
    this->nbSteps_ =  0;
    this->symbol_ = "B";
}

Flag::Flag(Position at) {
    this->positionOnBoard_ = at;
    this->grade_ = 0;
    this->nbSteps_= 0;
    this->symbol_ = "D";
}

