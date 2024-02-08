#include "Square.h"

Square::Square():
    type_{LAND}
{}

Square::Square(SquareType type):
    type_{type}
{}
