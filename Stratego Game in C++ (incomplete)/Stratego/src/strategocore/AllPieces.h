#ifndef ALLPIECES_H
#define ALLPIECES_H
#include "Piece.h"

namespace AllPi {
    class Marechal :  public Piece {
    public:
        Marechal(Position at);
    };

    class General :  public Piece {
    public:
        General(Position at);
    };

    class Colonel :  public Piece {
    public:
        Colonel(Position at);
    };

    class Major :  public Piece {
    public:
        Major(Position at);
    };

    class Commandant :  public Piece {
    public:
        Commandant(Position at);
    };

    class Lieutenant :  public Piece {
    public:
        Lieutenant(Position at);
    };

    class Sergent :  public Piece {
    public:
        Sergent(Position at);
    };

    class Demineur :  public Piece {
    public:
        Demineur(Position at);
    };

    class Eclaireur :  public Piece {
    public:
        Eclaireur(Position at);
    };

    class Espionne :  public Piece {
    public:
        Espionne(Position at);
    };

    class Flag : public Piece {
    public:
        Flag(Position at);
    };

    class Bomb :  public Piece {
    public:
        Bomb(Position at);
    };
}


#endif // ALLPIECES_H
