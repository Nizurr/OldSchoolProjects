#ifndef CONTROLLER_H
#define CONTROLLER_H

#include "Game.h"
#include "View.h"

class Controller {
private:
    Game game_;
    View view_;
public:

    /**
     * @brief Controller simple constructor.
     * @param game the game.
     * @param view the view.
     */
    Controller(Game& game, View& view);

    /**
     * @brief startGame starts the game.
     */
    void startGame();
};
#endif // CONTROLLER_H
