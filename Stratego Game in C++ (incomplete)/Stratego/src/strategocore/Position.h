#ifndef POSITION_H
#define POSITION_H

#include <string>
#include <ostream>

class Position {
private:
    int row_;
    int column_;

public:

    /**
     * @brief Position simple constructor.
     */
    Position();

    /**
     * @brief Position simple constructor.
     * @param row row .
     * @param column column.
     */
    Position(int row, int column);

    /**
     * @brief getter for the row.
     * @return row
     */
    int getRow() const;

    /**
     * @brief getter for the column.
     * @return column.
     */
    int getColumn() const;


    /**
     * @brief operator << Output streams
     * @param os
     * @param position
     * @return
     */
    friend std::ostream &operator<<(std::ostream &os, const Position &position);

    /**
     * @brief operator == compares whether the values on both sides of the operator are equal.
     * @param rhs other position.
     * @return true if they are equal, otherwise false.
     */
    bool operator==(const Position &rhs) const;

    /**
     * @brief operator !=
     * @param rhs
     * @return returns true if the operands don't have the same value; otherwise, it returns false
     */
    bool operator!=(const Position &rhs) const;

};


#endif // POSITION_H
