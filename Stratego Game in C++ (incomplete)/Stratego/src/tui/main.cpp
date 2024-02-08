#include <iostream>
#include "Controller.h"
using namespace std;
using namespace AllPi;

int main() {
    Game game = Game();
    View view = View();

    Controller Stratego = Controller(game,view);
    Stratego.startGame();

    return 0;
    //TODO public private protected global project

}
