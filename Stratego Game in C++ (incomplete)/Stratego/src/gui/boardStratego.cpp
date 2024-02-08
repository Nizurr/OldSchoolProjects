#include "boardStratego.h"
#include "boardCell.h"

#include <QObject>
#include <QGridLayout>
#include <QDrag>
#include <QDragEnterEvent>
#include <QMimeData>
#include <algorithm>
#include <QDebug>
#include <iostream>

int BoardStratego::N = 10;
QString TYPE = QString("My mime type");

BoardStratego::BoardStratego() : QLabel() {

    this->resize(600, 600);
    /* setStyleSheet don't work so good;
     * - repeat background
     * - not resize component
    this->setStyleSheet(
                "background-image: url(./stratego-board.png) no-repeat");
    */
    this->setPixmap(QPixmap(":/global/resources/stratego-board.png")); //Image de fond de la board

    auto * layout = new QGridLayout();
    layout->setAlignment({Qt::AlignTop,Qt::AlignLeft});
    layout->setSpacing(0);
    for (auto row = 0; row < 10 ; ++row ) {
        for (auto col = 0; col < 10; ++col) {
            auto color = SymbolePiece::NONE;

            if ( row <= 3 ) color = SymbolePiece::NONE;
            if ( row >= 6 ) color = SymbolePiece::NONE;
            auto * cell = new BoardCell(color);
            layout->addWidget(cell, row, col);
        }
    }
    this->setLayout(layout);
    this->setAcceptDrops(true);
}

void BoardStratego::set(int row, int col, SymbolePiece color){
    if (!isInside(row, col)) throw std::invalid_argument("Incorrect position");
    QGridLayout * layout = dynamic_cast<QGridLayout *>(this->layout());
    BoardCell * cell = dynamic_cast<BoardCell *>(layout->itemAtPosition(row, col)->widget());
    cell->color(color);
}

SymbolePiece BoardStratego::get(int row, int col)
{
    if (!isInside(row, col)){
        throw std::invalid_argument("Incorrect position");
    }
    QGridLayout * layout = dynamic_cast<QGridLayout *>(this->layout());
    BoardCell * cell = dynamic_cast<BoardCell *>(
            layout->itemAtPosition(row, col)->widget());
    return cell->color();
}

bool BoardStratego::isInside(int row, int col)
{
    return row >= 0 && row < BoardStratego::N && col >= 0 && col < BoardStratego::N;
}

/*
 * The click on element (here a cell) initiate the drag and drop.
 * When initiate drag and drop, the "drag" memorise information. Here I
 * memorize position of the cell source of drag and drop.
 */
void BoardStratego::mousePressEvent(QMouseEvent * event)
{
    qDebug() << "Initiate the drag and drop ";
    if (event->button() == Qt::LeftButton) {
        auto position { target(event->pos()) };
        if (position.first >= 0 && position.first < N
            && position.second >= 0 && position.second < N) {
            QByteArray itemData;
            QDataStream dataStream(&itemData, QIODevice::WriteOnly);
            dataStream << position.first << position.second ;
            QMimeData * mimeData = new QMimeData();
            mimeData->setData(TYPE, itemData);
            QDrag * drag = new QDrag(this);
            drag->setMimeData(mimeData);
            drag->exec();
        }
    }
}


void BoardStratego::dragEnterEvent(QDragEnterEvent * event)
{
    /*
     * Mouse pressed initiate drag and drop. I accept the drag and drop
     * if it'is a drag and drop with good type.
     */
    if (event->mimeData()->hasFormat(TYPE)) {
        event->acceptProposedAction();
    } else {
        event->ignore();
    }
}

void BoardStratego::dragLeaveEvent([[maybe_unused]] QDragLeaveEvent *event) {
    // just accept when leave during draging
    event->accept();
}

void BoardStratego::dragMoveEvent([[maybe_unused]] QDragMoveEvent * event) {
    // nothing to do durring move

}

void BoardStratego::dropEvent(QDropEvent * event) {
    qDebug() << "Drop ";
    std::pair<int, int> destination { target(event->pos()) };
    std::pair<int, int> source {};

    QByteArray datas = event->mimeData()->data(TYPE);
    QDataStream dataStream(&datas, QIODevice::ReadOnly);
    dataStream >> source.first >> source.second;
    qDebug() << "Drag and drop: "
             << "source " << source
             << "destination " << destination;
    event->acceptProposedAction();
    // Send signal if positions are on board (source is already verified)
    if (destination.first >= 0 && destination.first < N
        && destination.second >= 0 && destination.second < N) {
        emit send_positions(source, destination);
    }
}

const std::pair<int, int> BoardStratego::target(const QPoint & position) {
    int row = ((position.y()-5) / BoardCell::SIDE);
    int col = ((position.x()-5) / BoardCell::SIDE);
    return { row, col };
}

void BoardStratego::updateBoard(Board board) {
    for (auto row = 0; row < 10 ; ++row ) {
        for (auto col = 0; col < 10; ++col) {
            PlayerColor owner = board.getSquares()[row][col].getPieceOwner();
            std::string symbol = board.getSquares()[row][col].getPiece();

            if (owner == RED) {
                if (symbol == "X") {
                    set(row,col,SymbolePiece::RX);
                }
                else if (symbol == "2") {
                   set(row,col,SymbolePiece::R2);
                }
                else if (symbol == "B") {
                   set(row,col,SymbolePiece::RB);
                }
                else if (symbol == "3") {
                   set(row,col,SymbolePiece::R3);
                }
                else if (symbol == "4") {
                   set(row,col,SymbolePiece::R4);
                }
                else if (symbol == "5") {
                   set(row,col,SymbolePiece::R5);
                }
                else if (symbol == "6") {
                   set(row,col,SymbolePiece::R6);
                }
                else if (symbol == "7") {
                   set(row,col,SymbolePiece::R7);
                }
                else if (symbol == "8") {
                   set(row,col,SymbolePiece::R8);
                }
                else if (symbol == "10") {
                   set(row,col,SymbolePiece::R10);
                }
                else if (symbol == "9") {
                   set(row,col,SymbolePiece::R9);
                }
                else if (symbol == "1") {
                   set(row,col,SymbolePiece::R1);
                }
                else if (symbol == "D") {
                   set(row,col,SymbolePiece::RD);
                }

            } else if (owner == BLUE) {
                if (symbol == "X") {
                   set(row,col,SymbolePiece::BX);
                }
                else if (symbol == "2") {
                   set(row,col,SymbolePiece::B2);
                }
                else if (symbol == "B") {
                   set(row,col,SymbolePiece::BB);
                }
                else if (symbol == "3") {
                   set(row,col,SymbolePiece::B3);
                }
                else if (symbol == "4") {
                   set(row,col,SymbolePiece::B4);
                }
                else if (symbol == "5") {
                   set(row,col,SymbolePiece::B5);
                }
                else if (symbol == "6") {
                   set(row,col,SymbolePiece::B6);
                }
                else if (symbol == "7") {
                   set(row,col,SymbolePiece::B7);
                }
                else if (symbol == "8") {
                   set(row,col,SymbolePiece::B8);
                }
                else if (symbol == "10") {
                   set(row,col,SymbolePiece::B10);
                }
                else if (symbol == "9") {
                   set(row,col,SymbolePiece::B9);
                }
                else if (symbol == "1") {
                   set(row,col,SymbolePiece::B1);
                }
                else if (symbol == "D") {
                   set(row,col,SymbolePiece::BD);
                }

            } else {
                set(row,col,SymbolePiece::NONE);


            }
        }
    }

/*
    std::cout << "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n";
    for (int i = 0; i < 10; ++i) {
        std::cout << i+1 <<"\t";
        for (int j = 0; j < 10; ++j) {

            PlayerColor owner = board.getSquares()[i][j].getPieceOwner();
            std::string sym = board.getSquares()[i][j].getPiece();
            if (owner == RED) {
                std::cout << sym << "\t";
            } else if (owner == BLUE) {
                std::cout << sym << "\t";
            } else {
                if (board.getSquareType(Position(i,j)) == WATER) {
                    std::cout << "X\t";
                }  else {
                    std::cout << "0\t";
                }
            }
        }
        std::cout << i+1 <<"\t";
        std::cout << std::endl;

    }
    std::cout << "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n";
*/

}










