#include "View.h"

#define CLRRED  "\x1B[31m"
#define CLRBLUE  "\x1B[34m"
#define CLRYELLOW "\x1b[33m"
#define CLRRESET "\x1B[0m"
#define CLRGREEN "\x1B[0;32m"

View::View() {}

void View::showBoard(const Board& board) const {
    std::cout << CLRGREEN << "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n" << CLRRESET;
    for (int i = 0; i < 10; ++i) {
        std::cout << CLRGREEN << i+1 <<"\t" << CLRRESET;
        for (int j = 0; j < 10; ++j) {

            PlayerColor owner = board.getSquares()[i][j].getPieceOwner();
            std::string sym = board.getSquares()[i][j].getPiece();
            if (owner == RED) {
                std::cout << CLRRED << sym << CLRRESET << "\t";
            } else if (owner == BLUE) {
                std::cout << CLRBLUE << sym << CLRRESET << "\t";
            } else {
                if (board.getSquareType(Position(i,j)) == WATER) {
                    std::cout << "X\t";
                }  else {
                    std::cout << "0\t";
                }
            }

        }
        std::cout << CLRGREEN << i+1 <<"\t" << CLRRESET;
        std::cout << std::endl;

    }
    std::cout << CLRGREEN << "\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n" << CLRRESET;

}

void View::displayMain() const {
    printf("  ___  _____  ___    _  _____  ___  ___   ___  \n"
           " / __||_   _|| _ \\  /_\\|_   _|| __|/ __| / _ \\ \n"
           " \\__ \\  | |  |   / / _ \\ | |  | _|| (_ || (_) |\n"
           " |___/  |_|  |_|_\\/_/ \\_\\|_|  |___|\\___| \\___/ \n"
           "Bienvenue sur le jeu Stratego.\n"
           "Tout ce qui est entre crochet [], est une réponse à écrire.\n"
           "Si vous jouez avec une template. mettez la dans le dossier source sous le nom templateRED.txt pour le joueur rouge ou templateBLUE.txt pour le joueur bleu'\n\n\n");

}

LogMessage View::askMode(const PlayerColor& playerColor) {
    if (playerColor == RED) {
        std::cout << CLRRED << "Le joueur ROUGE, voulez vous charger une template ?\n" << CLRRESET;
    } else {
        std::cout << CLRBLUE << "Le joueur BLEU, voulez vous charger une template ?\n" << CLRRESET;
    }

    printf("[O] Oui, je veux charger une template\n");
    printf("[N] Non, je ne veux pas charger de template\n");
    printf(CLRYELLOW "Attention seul le premier caractère est pris en compte" CLRRESET "\n");

    char c = getChar();

    switch (c) {
        case 'N':
        case 'n':
            return DONT_WANT_LOAD_TEMPLATE;
            break;
        case 'O':
        case 'o':
            return WANT_LOAD_TEMPLATE;
            break;
        default:
            printf(CLRYELLOW "Entrée incorrecte, Ecrivez [O] ou [N]\n\n");
            askMode(playerColor);
            break;
    }
}

void View::askSetup(const PlayerColor& playerColor) const {
    //TODO Optimisation possible (variable dans tableau)
    std::cout << CLRYELLOW;
    std::cout << "____________________________________________" << std::endl;
    std::cout << "Bienvenue dans le monde incroyable et chiant de la création de template\n";
    std::cout << "Vous allez devoir placer votre armée\n";
    std::cout << "Vous aller placer les pieces une par une en indiquant les positions.\n";

    std::cout << "Le principe est très simple\n\n";
    std::cout << "Vous allez, pour chaque position donnée, mettre le symbole de la piece que vous voulez placer.\n";
    std::cout << CLRRESET << std::endl;

    int countB = 6;
    int countD = 1;
    int count1 = 1;
    int count2 = 8;
    int count3 = 5;
    int count4 = 4;
    int count5 = 4;
    int count6 = 4;
    int count7 = 3;
    int count8 = 2;
    int count9 = 1;
    int count10 = 1;

    std::string input;
    std::string tempInput;
    int count =0;

    int rowPos = 0;
    if (playerColor == RED) rowPos = 7;

    int colPos = 0;
    while (input.length() != 81) {
        std::cout << CLRYELLOW;
        std::cout <<"Pièce \t Symbole \t Quantité restante\n"
                    "Maréchal \t 10 \t " << count10 <<  "\n"
                    "Général \t 9\t\t " << count9 << "\n"
                    "Colonel \t 8\t\t " << count8 << "\n"
                    "Major \t\t 7\t\t " << count7 << "\n"
                    "Commandant \t 6\t\t " << count6 << "\n"
                    "Lieutenant \t 5\t\t " << count5 << "\n"
                    "Sergent \t 4\t\t " << count4 << "\n"
                    "Demineur \t 3\t\t " << count3 << "\n"
                    "Eclaireur \t 2\t\t " << count2 << "\n"
                    "Espionne \t 1\t\t " << count1 << "\n"
                    "Drapeau \t D\t\t " << countD << "\n"
                    "Bombe \t\t B\t\t" << countB <<
                    std::endl;

        std::cout << "Que voulez-vous mettre en " << posXYtoPosA1(Position(rowPos,colPos)) << " : ";
        std::cout << CLRRESET << std::endl;
        getline(std::cin, tempInput);

        bool inputOK;
        if (tempInput == "10") {
            if (count10 == 0) inputOK = false;
             else {
                count10--;
                inputOK = true;
            }
        }
        else if (tempInput == "9") {
            if (count9 == 0) inputOK = false;
             else {
                count9--;
                inputOK = true;
            }
        }
        else if (tempInput == "8") {
            if (count8 == 0) inputOK = false;
             else {
                count8--;
                inputOK = true;
            }

        }
        else if (tempInput == "7") {
            if (count7 == 0) inputOK = false;
             else {
                count7--;
                inputOK = true;
            }

        }
        else if (tempInput == "6") {
            if (count6 == 0) inputOK = false;
             else {
                count6--;
                inputOK = true;
            }

        }
        else if (tempInput == "5") {
            if (count5 == 0) inputOK = false;
             else {
                count5--;
                inputOK = true;
            }

        }
        else if (tempInput == "4") {
            if (count4 == 0) inputOK = false;
             else {
                count4--;
                inputOK = true;
            }

        }
        else if (tempInput == "3") {
            if (count3 == 0) inputOK = false;
             else {
                count3--;
                inputOK = true;
            }

        }
        else if (tempInput == "2") {
            if (count2 == 0) inputOK = false;
             else {
                count2--;
                inputOK = true;
            }

        }
        else if (tempInput == "1") {
            if (count1 == 0) inputOK = false;
             else {
                count1--;
                inputOK = true;
            }

        }
        else if (tempInput == "D") {
            if (countD == 0) inputOK = false;
             else {
                countD--;
                inputOK = true;
            }

        }
        else if (tempInput == "B") {
            if (countB == 0) inputOK = false;
             else {
                countB--;
                inputOK = true;
            }

        }

        if (inputOK) {
            input = input + " " + tempInput;
            colPos++;
            if (colPos%10 == 0) {
                rowPos++;
                colPos = 0;
            }
            inputOK = false;
        } else {
            std::cerr << "Entrée incorrecte ! Recommencez" << std::endl;
        }
        std::cout << std::endl;

    }

    if (playerColor == RED) {
        std::ofstream file("templateCreatedByUserForRED.txt");
        file << input;
        file.close();
    } else {
        std::ofstream file("templateCreatedByUserForBLUE.txt");
        file << input;
        file.close();
    }
    std::cout << CLRYELLOW << "Votre template à bien étée sauvegardée ! \n\n" << CLRRESET;


}

bool View::askPlayer() const {
    std::string input;
    printf("Quelle couleur vous voulez jouer ? (les rouges commencent).\n"
           "[R] Je suis ROUGE\n"
           "[B] Je suis BLEU\n");

    getline(std::cin, input);
    if (input.length() != 1) {
        std::cerr << "Entrée incorrecte, Ecrivez [B] ou [R]\n\n";
        askPlayer();
    }

    switch (input[0]) {
        case 'B':
        case 'b':
            return false;
        case 'R':
        case 'r':
            return true;
        default:
            std::cerr << "Entrée incorrecte, Ecrivez [B] ou [R]\n\n";
            askPlayer();
            break;
    }
    return false;
}

std::string View::posXYtoPosA1(const Position& pos) const {
    std::string result;
    switch (pos.getColumn()) {
        case 0:
            result.push_back('A');
            break;
        case 1:
            result.push_back('B');
            break;
        case 2:
            result.push_back('C');
            break;
        case 3:
            result.push_back('D');
            break;
        case 4:
            result.push_back('E');
            break;
        case 5:
            result.push_back('F');
            break;
        case 6:
            result.push_back('G');
            break;
        case 7:
            result.push_back('H');
            break;
        case 8:
            result.push_back('I');
            break;
        case 9:
            result.push_back('J');
            break;
        default:
            result.push_back('E');
            result.push_back('R');
            result.push_back('R');
            break;
    }
    int newRow = pos.getRow();
    if (newRow != 10) {
        newRow = newRow+48;
        result.push_back(newRow);
    } else {
        result.push_back('1');
        result.push_back('0');
    }

    return result;
}

Position View::posA1ToPosXY(const std::string& pos) const {
    toupper(pos[0]);
    int x,y;
    switch (pos[0]) {
        case 'A':
            x = 0;
            break;
        case 'B':
            x = 1;
            break;
        case 'C':
            x = 2;
            break;
        case 'D':
            x = 3;
            break;
        case 'E':
            x = 4;
            break;
        case 'F':
            x = 5;
            break;
        case 'G':
            x = 6;
            break;
        case 'H':
            x = 7;
            break;
        case 'I':
            x = 8;
            break;
        case 'J':
            x = 9;
            break;

    }
    y = pos[1] - '0'-1;
    return Position(y,x);

}

std::pair<Position, Position> View::askMove(const PlayerColor& playerColor) const {
    std::string input;
    Position from;
    Position to;
    std::pair<Position,Position> returnvalue;
    if (playerColor == RED) std::cout << CLRRED << "ROUGE, ENTREZ POS DE LA PIECE QUE VOUS VOULEZ PRENDRE : " << CLRRESET;
    else std::cout << CLRBLUE << "BLEU, ENTREZ POS DE LA PIECE QUE VOUS VOULEZ PRENDRE : " << CLRRESET;


    getline(std::cin, input);
    from = posA1ToPosXY(input);
    returnvalue.first = from;

    if (playerColor == RED) std::cout << CLRRED << "ROUGE, ENTREZ LA POSITION DE OU VOUS VOULEZ ALLER : " << CLRRESET;
    else std::cout << CLRBLUE << "BLEU, ENTREZ LA POSITION DE OU VOUS VOULEZ ALLER : " << CLRRESET;

    input = "";
    getline(std::cin, input);
    to = posA1ToPosXY(input);
    returnvalue.second = to;
    return returnvalue;




}

void View::printLogMessage(const LogMessage& message) const {
    std::cout << CLRYELLOW << "Erreur n° : ";
    switch (message) {
        case ERROR:
            std::cout << message << " Inconnue";
            break;
        case PIECE_NOT_FOUND:
            std::cout << message << " Pièce non trouvée";
            break;
        case TEMPLATE_RED_NOT_FOUND:
            std::cout << message << " Template du joueur rouge non trouvée";
            break;
        case TEMPLATE_MANUAL_RED_NOT_FOUND:
            std::cout << message << " Template créer par l'utilisateur non trouvée (problème involontaire)";
            break;
        case TEMPLATE_BLUE_NOT_FOUND:
            std::cout << message << " Template du joueur rouge non trouvée ";
            break;
        case TEMPLATE_MANUAL_BLUE_NOT_FOUND:
            std::cout << message << " Template créer par l'utilisateur non trouvée (problème involontaire) ";
            break;
        case ERROR_IN_TEMPLATE:
            std::cout << message << " Template du joueur incorrecte, vérifiez votre template ";
            break;
        case PIECE_CANT_MOVE:
            std::cout << message << " La piece ne peut pas bouger.";
            break;
        case PIECE_ATTACK_ALLY:
            std::cout << message << " La piece ne peut pas attaquer une pièce alliée.";
            break;
        case PIECE_WANT_MOVE_AT_FROM_POS:
            std::cout << message << " La piece ne peut pas se déplacer sur la position d'origine.";
            break;
        case PIECE_NOT_FOUND_AT_FROM_POS:
            std::cout << message << " La pièce selectionnée n'a pas été trouvée à la position d'origine.";
            break;
    }
    std::cout << CLRRESET << std::endl;
}

char View::getChar() {
    char c;
    std::cin >> c;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    return c;
}