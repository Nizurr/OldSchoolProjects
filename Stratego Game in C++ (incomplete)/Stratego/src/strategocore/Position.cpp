#include "Position.h"

Position::Position() :
        row_{0},
        column_{0}
{}

Position::Position(int row, int col): row_{row}, column_{col} {
    if (row > 10 || col > 10 || row < 0 || col < 0) {
        throw "Position interdite (Bigger or lower than board size";
    }
}


int Position::getRow() const {
    return this->row_;
}

int Position::getColumn() const {
    return this->column_;
}

bool Position::operator==(const Position &rhs) const {
    return row_ == rhs.row_ && column_ == rhs.column_;
}

bool Position::operator!=(const Position &rhs) const {
    return !(rhs == *this);
}

std::ostream &operator<<(std::ostream &os, const Position &position) {
    os << "Position : " <<"row : " << position.row_ << " column : " << position.column_;
    return os;
}
