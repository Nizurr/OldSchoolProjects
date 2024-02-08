#include "Game.h"

Game::Game() :
        gameBoard_{Board()},
        playerRed_{Player(RED)},
        playerBlue_{Player(BLUE)},
        status_{NOT_STARTED},
        roundPerformed_{0} {}

Game::Game(const Player &playerRed, const Player &playerBlue) : playerRed_(playerRed), playerBlue_(playerBlue) {
    gameBoard_ = Board();
    status_ = NOT_STARTED;
    roundPerformed_ = 0;
}


/**
 * Setup of the party, placing the pieces on the board, template check if needed
 */
LogMessage Game::initialize(bool loadTemplateImported, bool isRedAsking, std::string chemin) {
    std::string symbol;
    int row = 0;
    if (isRedAsking) row = 9;
    int col = 0;
    int cpt = 0;
    std::pair<LogMessage, std::string> templateChecked;
    Player &currentPl = currentPlayerRef();

    if (loadTemplateImported && isRedAsking) {
        if (chemin.find(".txt") != std::string::npos) templateChecked = checkTemplate(chemin);
        else {
            templateChecked = checkTemplate("./templateRED.txt");
        }
    } else if (!loadTemplateImported && isRedAsking) {
        templateChecked = checkTemplate("./templateCreatedByUserForRED.txt");
    }
    if (loadTemplateImported && !isRedAsking) {
        if (chemin.find(".txt") != std::string::npos) templateChecked = checkTemplate(chemin);
        else {
            templateChecked = checkTemplate("./templateBLUE.txt");
        }
    } else if (!loadTemplateImported && !isRedAsking) {
            templateChecked = checkTemplate("./templateCreatedByUserForBLUE.txt");
    }

    if (templateChecked.first != NO_ERROR) return templateChecked.first;

    for (int i = 0; i < int(templateChecked.second.length()); ++i) {
        if (templateChecked.second[i] != ' ') {
            symbol = symbol + templateChecked.second[i];
        } else {
            if (symbol == "2") currentPl.addPiece(AllPi::Eclaireur(Position(row, col)));
            else if (symbol == "B") currentPl.addPiece(AllPi::Bomb(Position(row, col)));
            else if (symbol == "3") currentPl.addPiece(AllPi::Demineur(Position(row, col)));
            else if (symbol == "4") currentPl.addPiece(AllPi::Sergent(Position(row, col)));
            else if (symbol == "5") currentPl.addPiece(AllPi::Lieutenant(Position(row, col)));
            else if (symbol == "6") currentPl.addPiece(AllPi::Commandant(Position(row, col)));
            else if (symbol == "7") currentPl.addPiece(AllPi::Major(Position(row, col)));
            else if (symbol == "8") currentPl.addPiece(AllPi::Colonel(Position(row, col)));
            else if (symbol == "10") {
                Position pos = Position(row, col);
                AllPi::Marechal m = AllPi::Marechal(pos);
                currentPl.addPiece(m);
            }
            else if (symbol == "9") currentPl.addPiece(AllPi::General(Position(row, col)));
            else if (symbol == "1") currentPl.addPiece(AllPi::Espionne(Position(row, col)));
            else if (symbol == "D") currentPl.addPiece(AllPi::Flag(Position(row, col)));
            col++;
            symbol = "";
            cpt++;
        }
        if (cpt == 10) {
            if (isRedAsking) {
                row--;
            } else {
                row++;
            }
            col = 0;
            cpt = 0;
        }
    }

    if (currentPl.getColor() == RED && roundPerformed_ == 0) {
        status_ = RED_SETUP_OK;
    } else if (currentPl.getColor() == BLUE && roundPerformed_ == 0) {
        status_ = BLUE_SETUP_OK;
    }

    updateBoard();
    return NO_ERROR;
}


/**
 * @brief Game::checkTemplate Checking template, give an error if error in.
 * @return std::pair le return.first est un boolean : si le template peut etre utilsié ou pas
 * si le template peut etre utilisé, la string est dans return.second
 */
std::pair<LogMessage, std::string> Game::checkTemplate(std::string templatename) {
    //Le fichier template.txt est a mettre avec l'executable
    std::pair<LogMessage, std::string> templateToGive;
    std::ifstream file(templatename);
    if (file.fail()) {
        if (templatename == "./templateRED.txt") templateToGive.first = TEMPLATE_RED_NOT_FOUND;
        else if (templatename == "./templateBLUE.txt") templateToGive.first = TEMPLATE_BLUE_NOT_FOUND;
        else if (templatename == "./templateCreatedByUserForRED.txt")
            templateToGive.first = TEMPLATE_MANUAL_RED_NOT_FOUND;
        else if (templatename == "./templateCreatedByUserForBLUE.txt")
            templateToGive.first = TEMPLATE_MANUAL_BLUE_NOT_FOUND;
    }
    std::stringstream buffer;
    buffer << file.rdbuf();
    file.close();
    std::string templateString = buffer.str();
    std::replace(templateString.begin(), templateString.end(), '\n', ' '); //remplace tout les \n par des espaces
    if (templateString[0] == ' ') {
        templateString.erase(0, 1);
        templateString.push_back(' ');
    }

    int countB = 0;
    int countD = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;
    int count0 = 0;

    for (int i = 0; i < templateString.size(); i++) {
        if (templateString[i] == 'B') countB++;
        else if (templateString[i] == 'D') countD++;
        else if (templateString[i] == '1') count1++;
        else if (templateString[i] == '2') count2++;
        else if (templateString[i] == '3') count3++;
        else if (templateString[i] == '4') count4++;
        else if (templateString[i] == '5') count5++;
        else if (templateString[i] == '6') count6++;
        else if (templateString[i] == '7') count7++;
        else if (templateString[i] == '8') count8++;
        else if (templateString[i] == '9') count9++;
        else if (templateString[i] == '0') count0++;
    }
    if (
            (count0 != 1) ||
            (count1 != 2) ||
            (count2 != 8) ||
            (count3 != 5) ||
            (count4 != 4) ||
            (count5 != 4) ||
            (count6 != 4) ||
            (count7 != 3) ||
            (count8 != 2) ||
            (count9 != 1) ||
            (countD != 1) ||
            (countB != 6)
            ) {
        templateToGive.first = ERROR_IN_TEMPLATE;
        templateToGive.second = "";
        return templateToGive;
    }
    templateToGive.second = templateString;
    return templateToGive;
}

void Game::start() {
    status_ = IN_PROGRESS;
}

/**
 * Update the status of the game
 */
void Game::updateStatus() {
    //FIXME Doit compter le score de chacun, voir si quelqu'un à gagné/perdu
    bool bluehaveD = false;
    bool redhaveD = false;
    for (Piece &p: playerBlue_.getPieces()) {
        if (p.getSymbol() == "D") {
            bluehaveD = true;
        }
    }
    for (Piece &p: playerRed_.getPieces()) {
        if (p.getSymbol() == "D") {
            redhaveD = true;
        }
    }
    if (bluehaveD || redhaveD) return;
    if (!bluehaveD) {
        this->status_ = OVER;
        //winners_.push_back(playerRed_);
        return;
    } else {
        this->status_ = OVER;
        //winners_.push_back(playerBlue_);
    }
}

/* algo:
 * 1) pièce est trouvé ?? à la position 'from' appartient au joueur courant? //C'est le rôle de Controller
 *
 *  Ok 2) déplacement possible
 *  Ok    1) le pièce n'est pas immouvable (Bomb, Flag) ?
 *  Ok    2) le nombre de déplacement égal aux nombres entre 'from' et 'to' ?
 *  OK    3) le déplacement n'est pas en diagonale ou zigzag
 *  OK    4) la case correspondent à la position 'to' n'est pas WATER
 *
 *  Ok 3) aucune pièce entre 'from' et 'to' ?
*/
LogMessage Game::makeAMove(Position from, Position to) {
    //Savoir qui joue peut etre connu avec roundPerfomed
    if (from == to) return PIECE_WANT_MOVE_AT_FROM_POS;

    Player &currentPl = currentPlayerRef();
    Player &opposingPl = opposingPlayer(currentPl);
    Piece actualPiece;
    // récupere la piece à la position 'from'
    try {
        actualPiece = currentPl.getPiece(from);
    } catch (const std::runtime_error &e) {
        return PIECE_NOT_FOUND_AT_FROM_POS;
    }

    bool caseExist = gameBoard_.isInside(from);
    bool caseIsLand = gameBoard_.getSquareType(from) == LAND;
    bool caseToIsLand = gameBoard_.getSquareType(to) == LAND;
    bool isHorizontalOrVertical = from.getColumn() == to.getColumn() || from.getRow() == to.getRow();
    bool canMoveToPosWanted = countMovement(from, to) <= actualPiece.getNbSteps();
    bool pieceCanMove = currentPl.getPiece(from).getNbSteps() != 0;
    bool pasDObastacleEntreFromEtTo = !isThereAbstract(from, to);

    if (caseExist && caseIsLand && caseToIsLand && isHorizontalOrVertical && canMoveToPosWanted && pieceCanMove) {
        if (pasDObastacleEntreFromEtTo) {
            currentPl.setPieceAtPosition(from, to);
        }
        else {
            // SI OBSTACLE SPECIFIQUE :

            if (currentPl.hasPieceAt(to)) {
                return PIECE_ATTACK_ALLY;
            }

            Piece opposingPiece = opposingPl.getPiece(to);
            bool demiAttaqueBomb = actualPiece.getSymbol() == "3" && opposingPiece.getSymbol() == "B";
            bool espiAttaqueMarchall = actualPiece.getGrade() == 1 && opposingPiece.getGrade() == 10;
            if (demiAttaqueBomb || espiAttaqueMarchall) {
                currentPl.setPieceAtPosition(from, to); //on deplace la piece sur la case demandée
                opposingPl.removePiece(to);
            } else {
                // SI OBSTACLE PAS SPECIFIQUE
                switch (actualPiece.compareForceTo(opposingPiece)) {
                    case 0:
                        currentPl.removePiece(from);
                        opposingPl.removePiece(to);
                        break;
                    case 1:
                        opposingPl.removePiece(to);
                        currentPl.setPieceAtPosFound(from, true);
                        currentPl.setPieceAtPosition(from, to); //on deplace la piece sur la case demandée
                        break;
                    case -1 :
                        currentPl.removePiece(from);
                        opposingPl.setPieceAtPosFound(to, true);
                        break;
                }
            }
        }
    } else {
        return PIECE_CANT_MOVE;
    };
    roundPerformed_++;
    updateBoard();
    updateStatus();
    return NO_ERROR;

}

std::vector<Player> Game::winners() {
        std::vector<Player> vicotres{};
        std::vector<Piece> piecesB = this->playerBlue_.getPieces();
        std::vector<Piece> piecesR = this->playerRed_.getPieces();

        bool isFlagB = false;
        bool isFlagR = false;
        bool isPieceMouvableB = false;
        bool isPieceMouvableR = false;

        std::for_each(piecesB.begin(), piecesB.end(),[&isFlagB,&isPieceMouvableB](const Piece &pi){
            if(pi.getSymbol()=="D"){
                isFlagB = true;
            }
            if((pi.getSymbol() != "D") && (pi.getSymbol() != "B")){
                isPieceMouvableB =true;
            }
        });
        std::for_each(piecesR.begin(), piecesR.end(),[&isFlagR,&isPieceMouvableR](const Piece &pi){
            if(pi.getSymbol()=="D"){
                isFlagR = true;
            }
            if((pi.getSymbol() != "D") && (pi.getSymbol() != "B")){
                isPieceMouvableR =true;
            }

        });
        if(!isFlagB){
           vicotres.push_back(this->playerRed_);
           status_ = OVER;
        }else if(!isFlagR){
            vicotres.push_back(this->playerBlue_);
            status_ = OVER;
        }else if(!isPieceMouvableB && !isPieceMouvableR){
            if(isFlagB && isFlagR){
                vicotres.push_back(this->playerBlue_);
                vicotres.push_back(this->playerRed_);
                status_ = OVER;
            }
        }
        return vicotres;

}

Board Game::getBoard() const {
    return gameBoard_;
}

GameStatus Game::getStatus() const {
    return status_;
}

Player Game::getPlayerBlue() const {
    return playerBlue_;
}

Player Game::getPlayerRed() const {
    return playerRed_;
}

int Game::getRoundPerformed() const {
    return roundPerformed_;
}

Player& Game::opposingPlayer(Player& player) {
    if (player.getColor() == this->playerBlue_.getColor()) {
        return this->playerRed_;
    }
    return this->playerBlue_;
}

bool Game::isThereAbstract(Position from, Position to) {
    bool abstract = true;
    int x, y;
    x = from.getRow();
    y = from.getColumn();
    Piece pie;
    int val = 1;
    if (from.getColumn() == to.getColumn() ) {
        if (from.getRow() > to.getRow()) {
            val = -1;
        }
        while ((x != to.getRow()) && abstract) {
            x += val;
            Position pos{x, y};
            bool bluePiece = !this->playerBlue_.hasPieceAt(pos);
            bool redPiece = !this->playerRed_.hasPieceAt(pos);
            abstract = gameBoard_.getSquareType(pos) == LAND && !this->playerBlue_.hasPieceAt(pos) && !this->playerRed_.hasPieceAt(pos);
        }
    } else if (from.getRow() == to.getRow() ) {
        if (from.getColumn() > to.getColumn()) {
            val = -1;
        }
        while ((y != to.getColumn()) && abstract) {
            y += val;
            Position pos{x, y};
            bool bluePiece = !this->playerBlue_.hasPieceAt(pos);
            bool redPiece = !this->playerRed_.hasPieceAt(pos);
            abstract = gameBoard_.getSquareType(pos) == LAND && !this->playerBlue_.hasPieceAt(pos) && !this->playerRed_.hasPieceAt(pos);
        }
    }
    return !abstract;

}

// Étant donné que les deux points 'from' et 'to' soient en verticale ou en horizontale.
int Game::countMovement(Position from, Position to) {
    int abs1 = abs(from.getRow() - to.getRow());
    int abs2 = abs(from.getColumn() - to.getColumn());
    int total = abs(from.getRow() - to.getRow()) + abs(from.getColumn() - to.getColumn());
    return abs(from.getRow() - to.getRow()) + abs(from.getColumn() - to.getColumn());
}

void Game::updateBoard() {
    for (int i = 0; i < 10; ++i) { //reset des symboles du board.
        for (int j = 0; j < 10; ++j) {
            gameBoard_.setSymbolOnSquare(Position(i, j), "", NONE);
        }
    }
    if (roundPerformed_ % 2 == 0) {
        for (Piece &p: playerBlue_.getPieces()) {
            if (p.getFound()) {
                this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), p.getSymbol(), BLUE);
            } else {
                this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), "X", BLUE);
            }
        }
        for (Piece &p: playerRed_.getPieces()) {
            this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), p.getSymbol(), RED);
        }
    } else {
        for (Piece &p: playerBlue_.getPieces()) {
            this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), p.getSymbol(), BLUE);
        }
        for (Piece &p: playerRed_.getPieces()) {
            if (p.getFound()) {
                this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), p.getSymbol(), RED);
            } else {
                this->gameBoard_.setSymbolOnSquare(p.getPositionOnBoard(), "X", RED);
            }
        }
    }

}

Player& Game::currentPlayerRef() {
    if (roundPerformed_ % 2 == 0 && status_ == IN_PROGRESS) return this->playerRed_;
    else if (roundPerformed_ % 2 != 0 && status_ == IN_PROGRESS) return this->playerBlue_;
    else if (status_ != RED_SETUP_OK) return this->playerRed_;
    else if (status_ != BLUE_SETUP_OK) return this->playerBlue_;
}
