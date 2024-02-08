#ifndef GSTRATEGOBOARD_H
#define GSTRATEGOBOARD_H

#include <QLabel>
#include "Board.h"
#include "boardCell.h"


class QPoint;
class QDragEnterEvent;
class QDropEvent;
class QMouseEvent;

/**
 * @brief The boardStratego class represent a stratego board.
 *
 * The board is clickable and support drag and drop. When a drag and drop
 * is done, component emit a signal.
 */
class BoardStratego : public QLabel
{
Q_OBJECT


public:

    /**
     * @brief N represent the size on board.
     */
    static int N;

    /**
     * @brief BoardStratego simple constructor.
     */
    explicit BoardStratego();
    ~BoardStratego() = default;

    /**
     * @brief set color on cell at position.
     * @param row new row.
     * @param col new column.
     * @param color new symbole.
     */
    void set(int row, int col, SymbolePiece color);

    /**
     * @brief get the symbole at certain position.
     * @param row row.
     * @param col column.
     * @return
     */
    SymbolePiece get(int row, int col);

    /**
     * @brief isInside checking if there is cell inside the board.
     * @param row row.
     * @param col column.
     * @return
     */
    bool isInside(int row, int col);

    /**
     * @brief updateBoard updating the board.
     * @param board
     */
    void updateBoard(Board board);


protected:

    /**
     * @brief dragEnterEvent when the user press the left button.
     * @param event
     */
    void dragEnterEvent(QDragEnterEvent *event) override;

    /**
     * @brief dragLeaveEvent when the user move the mouve while he clicked the mouse.
     * @param event
     */
    void dragLeaveEvent(QDragLeaveEvent *event) override;

    /**
     * @brief dragMoveEvent nothing happend whe the user move the mouse.
     * @param event
     */
    void dragMoveEvent(QDragMoveEvent *event) override;

    /**
     * @brief dropEvent when the user left the button
     * @param event
     */
    void dropEvent(QDropEvent *event) override;

    /**
     * @brief mousePressEvent when the user click on left button.
     * @param event
     */
    void mousePressEvent(QMouseEvent *event) override;

private:
    /**
     * @brief target convert x.y "pixel position" into position on board.
     * row, col position. This is strongly dependant of background picture
     * size and cell side.
     * @param position x,y "pixel position"
     * @return row, col "grid position" in std::pair
     */
    const std::pair<int, int> target(const QPoint & position);

signals:

    /**
     * @brief send_positions sending the position.
     * @param source
     * @param destination
     */
    void send_positions(std::pair<int, int> source,std::pair<int, int> destination);

};

#endif // GSTRATEGOBOARD_H
