#include "boardCell.h"

#include <QDebug>

int BoardCell::SIDE = 60;
BoardCell::BoardCell(SymbolePiece color, QLabel *parent) : QLabel(parent),
          symbolePiece_ { color }
{
    this->setMinimumSize(QSize(SIDE, SIDE));
    this->setMaximumSize(QSize(SIDE, SIDE));
}


void BoardCell::paintEvent([[maybe_unused]] QPaintEvent * event) {
    auto style { QString("background-color: none;""border: 1px solid black;")};
    switch (symbolePiece_) {

        case SymbolePiece::NONE:
            break;
        case SymbolePiece::RX:
            style = QString("background-image: url(:/new/red/resources/Red/x.png);""border: 1px solid black;");
            break;
        case SymbolePiece::RD:
            style = QString("background-image: url(:/new/red/resources/Red/d.png);""border: 1px solid black;");
            break;
        case SymbolePiece::RB:
            style = QString("background-image: url(:/new/red/resources/Red/b.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R1:
            style = QString("background-image: url(:/new/red/resources/Red/1.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R2:
            style = QString("background-image: url(:/new/red/resources/Red/2.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R3:
            style = QString("background-image: url(:/new/red/resources/Red/3.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R4:
            style = QString("background-image: url(:/new/red/resources/Red/4.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R5:
            style = QString("background-image: url(:/new/red/resources/Red/5.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R6:
            style = QString("background-image: url(:/new/red/resources/Red/6.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R7:
            style = QString("background-image: url(:/new/red/resources/Red/7.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R8:
            style = QString("background-image: url(:/new/red/resources/Red/8.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R9:
            style = QString("background-image: url(:/new/red/resources/Red/9.png);""border: 1px solid black;");
            break;
        case SymbolePiece::R10:
            style = QString("background-image: url(:/new/red/resources/Red/10.png);""border: 1px solid black;");
            break;
        case SymbolePiece::BX:
            style = QString("background-image: url(:/new/blue/resources/Blue/x.png);""border: 1px solid black;");
            break;
        case SymbolePiece::BD:
            style = QString("background-image: url(:/new/blue/resources/Blue/d.png);""border: 1px solid black;");
            break;
        case SymbolePiece::BB:
            style = QString("background-image: url(:/new/blue/resources/Blue/b.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B1:
            style = QString("background-image: url(:/new/blue/resources/Blue/1.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B2:
            style = QString("background-image: url(:/new/blue/resources/Blue/2.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B3:
            style = QString("background-image: url(:/new/blue/resources/Blue/3.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B4:
            style = QString("background-image: url(:/new/blue/resources/Blue/4.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B5:
            style = QString("background-image: url(:/new/blue/resources/Blue/5.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B6:
            style = QString("background-image: url(:/new/blue/resources/Blue/6.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B7:
            style = QString("background-image: url(:/new/blue/resources/Blue/7.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B8:
            style = QString("background-image: url(:/new/blue/resources/Blue/8.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B9:
            style = QString("background-image: url(:/new/blue/resources/Blue/9.png);""border: 1px solid black;");
            break;
        case SymbolePiece::B10:
            style = QString("background-image: url(:/new/blue/resources/Blue/10.png);""border: 1px solid black;");
            break;
    }
    this->setStyleSheet(style);
}
