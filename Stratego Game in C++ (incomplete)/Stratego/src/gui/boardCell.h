#ifndef GIMAGECELL_H
#define GIMAGECELL_H

#include <QLabel>

enum class SymbolePiece { NONE, RX,RD,RB,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10, BX,BD,BB,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10};

/**
 * @brief The GImageCell class represent a cell.
 *
 * A cell have a color or none.
 * For this example no need to have more information. The color would be
 * objet with more fiels like rank…
 * The cell have a color but would have a picture on it…
 */
class BoardCell : public QLabel
{

Q_OBJECT

public:
    static int SIDE;

    explicit BoardCell(SymbolePiece color = SymbolePiece::NONE,QLabel *parent = nullptr);
    // getters and setters (with update)
    inline SymbolePiece color() const { return symbolePiece_; };
    inline void color(SymbolePiece color) { symbolePiece_ = color; update(); };

private:
    SymbolePiece symbolePiece_;

    /*
     * Member function draw the component
     */
    void paintEvent(QPaintEvent *);

};

#endif // GIMAGECELL_H
