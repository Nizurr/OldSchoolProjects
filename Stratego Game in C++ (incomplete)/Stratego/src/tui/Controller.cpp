#include "Controller.h"

Controller::Controller(Game& game, View& view) : game_(game), view_(view) {}

//TODO ajouter une méthode pour faire swap entre les joueures
void Controller::startGame() {
    view_.displayMain();



    // INITIALISATION DES TEMPLATES

    // JOUEUR ROUGE
    // FIXME printLogMessage(error 7)

    LogMessage templateLoading = ERROR;
    LogMessage playerOk = ERROR;

    //SETUP DES TEMPLATES
    while (playerOk != NO_ERROR) {
        if (view_.askMode(RED) == DONT_WANT_LOAD_TEMPLATE) {
            view_.askSetup(RED);
            templateLoading = game_.initialize(false, true);
        } else {
            templateLoading = game_.initialize(true, true); // Rouge veut charger sa template
        }
        if (templateLoading != NO_ERROR) {
            view_.printLogMessage(templateLoading);
        } else {
            templateLoading = ERROR;
            playerOk = NO_ERROR;
        }
    }
    templateLoading = ERROR;
    playerOk = ERROR;
    while (playerOk != NO_ERROR) {
        if (view_.askMode(BLUE) == DONT_WANT_LOAD_TEMPLATE) {
            view_.askSetup(BLUE);
            templateLoading = game_.initialize(false, false);
        } else {
            templateLoading = game_.initialize(true, false); // Rouge veut charger sa template
        }
        if (templateLoading != NO_ERROR) {
            view_.printLogMessage(templateLoading);
        } else {
            templateLoading = ERROR;
            playerOk = NO_ERROR;
        }
    }

    view_.showBoard(game_.getBoard());
    game_.start();
    while (game_.getStatus() == IN_PROGRESS) {
        std::pair<Position, Position> p;
        if (game_.getRoundPerformed() % 2 == 0) {
            p = view_.askMove(RED);
        } else {
            p = view_.askMove(BLUE);
        }
        LogMessage moveMessage = game_.makeAMove(p.first, p.second);
        if (moveMessage != NO_ERROR) {
            view_.printLogMessage(moveMessage);
        }
        view_.showBoard(game_.getBoard());
    }

    // TODO afficher le gagnant


}
