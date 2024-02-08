#include "guicontroler.h"

LogMessage GUIControler::playerSetup(std::pair<bool,bool> userConfig, std::string  cheminRED, std::string cheminBLUE) {
    std::cout << "CONTROLLERGUI.CPP -> PLAYERSETUP() -> userConfig: " << userConfig.first << " " << userConfig.second << std::endl;

    LogMessage playerOk = ERROR;
    LogMessage templateLoading = ERROR;
    if (playerOk != NO_ERROR) {
        if (!userConfig.first) {
            //view_.askSetup(RED); // TODO : setup askSetup in GUI
            templateLoading = game_.initialize(false, true);
        } else {
            templateLoading = game_.initialize(true, true, cheminRED); // Rouge veut charger sa template
        }
        if (templateLoading != NO_ERROR) {
            return templateLoading;
        } else {
            templateLoading = ERROR;
            playerOk = NO_ERROR;
        }
    }

    templateLoading = ERROR;
    playerOk = ERROR;
    if (playerOk != NO_ERROR) {
        if (!userConfig.second) {
            //view_.askSetup(BLUE); TODO : setup askSetup in GUI
            templateLoading = game_.initialize(false, false);
        } else {
            templateLoading = game_.initialize(true, false, cheminBLUE); // bleu veut charger sa template
        }
        if (templateLoading != NO_ERROR) {
            return templateLoading;
        } else {
            templateLoading = ERROR;
            playerOk = NO_ERROR;
        }
    }

    return NO_ERROR;
}




GUIControler::GUIControler() {}

GUIControler::~GUIControler() {}

LogMessage GUIControler::SquareMoved(Position from, Position to) {

   if (game_.getStatus() == IN_PROGRESS) {
       LogMessage moveMessage = game_.makeAMove(from,to);
       if (moveMessage != NO_ERROR) {
           return moveMessage;
       }
   }
   // std::cout << from << to;
    return NO_ERROR;
}


Board GUIControler::askBoard() {
    return game_.getBoard();
}

void GUIControler::startGame() {
    game_.start();
}

PlayerColor GUIControler::whoPlay() {
    if (game_.getRoundPerformed() % 2 == 0) return RED;
    return BLUE;
}

std::pair<int,int> GUIControler::updateScore(){
    std::pair<int,int> scores{};
    scores.first = 40 - game_.getPlayerRed().getPieces().size();
    scores.second = 40 - game_.getPlayerBlue().getPieces().size();
    return scores;
}

std::vector<Player> GUIControler::winners()
{
    if(game_.getStatus() == OVER)
    return game_.winners();
}
