#include <QMessageBox>
#include "mainwindows.h"
#include "ui_View.h"

#include <QObject>
#include <QGridLayout>
#include <QDrag>
#include <QDragEnterEvent>
#include <QMimeData>
#include <algorithm>
#include <QDebug>
#include <QMouseEvent>
#include <QEvent>
#include <QFileDialog>

// POUR CHANGER DE PAGE =>     ui->stackedWidget->setCurrentIndex(1);
// INDEX 0 = pageCONFIGURATION, INDEX 1 = pageWELCOME, INDEX 2 = pageJEU

MainWindows::MainWindows(QWidget *parent): QMainWindow(parent), ui(new Ui::MainWindow) {

    setGeometry(0, 0, 620, 670);
    ui->setupUi(this);
    ui->stackedWidget->setCurrentIndex(1);
    board = new BoardStratego();
    ui->stackedWidget->insertWidget(2,board);
    showInfos(false);
    connect(board,SIGNAL(send_positions(std::pair<int, int>, std::pair<int, int>)),this,SLOT(on_board_signal(std::pair<int, int>, std::pair<int, int>)));
}


MainWindows::~MainWindows() {
    delete ui;
}

void MainWindows::on_board_signal(std::pair<int, int> source, std::pair<int, int> destination) {
    //qDebug() << source.first << source.second;
    Position from = Position(source.first,source.second);
    Position to = Position(destination.first,destination.second);
    LogMessage m = controler.SquareMoved(from,to);
    if (m != NO_ERROR) {
        popupMessage(m);
    } else {
        updateBoard(this->controler.askBoard());
        // DEPLACEMENT REUSSI
    }
}

void MainWindows::updateBoard(Board board) {
    this->board->updateBoard(board);
    QString color{"RED"};
    if(controler.whoPlay() == BLUE){
        color = "BLUE";
    }
    ui->currentPlayerColor->setText(color);
    QString scB{QString::number(controler.updateScore().second)};
    QString scR{QString::number(controler.updateScore().first)};
    ui->scoreBlue_2->setText(scB);
    ui->scoreRed_2->setText(scR);
    std::cout << "updateBoard" << std::endl;
}




void MainWindows::on_pushButtonWelcomePage_clicked() {
    ui->stackedWidget->setCurrentIndex(0);
}

void MainWindows::on_buttonConfigPageValidate_clicked() {
    //Devrait etre check dans le controleur ?
    if(!ui->pageConfigRadioREDYES->isChecked() && !ui->pageConfigRadioREDNO->isChecked()) {
        popupMessage(DIDNT_MADE_A_CHOICE);
    } else if (!ui->pageConfigRadioBLUENON->isChecked() && !ui->pageConfigRadioBLUEYES->isChecked()) {
        popupMessage(DIDNT_MADE_A_CHOICE);
    } else {
        std::pair<bool, bool> config;
        config.first = ui->pageConfigRadioREDYES->isChecked();
        config.second =  ui->pageConfigRadioBLUEYES->isChecked();
        LogMessage checkedtemplate = controler.playerSetup(config, this->cheminTemplateRED, this->cheminTemplateBLUE);

        if(checkedtemplate != NO_ERROR) {
            popupMessage(checkedtemplate);
        } else {
            ui->stackedWidget->setCurrentIndex(2);
            showInfos(true);
            updateBoard(this->controler.askBoard());
            this->controler.startGame();
        }
    }
}

void MainWindows::popupMessage(LogMessage message) {
    QString str;
    switch (message) {
        case ERROR:
            str = "Attention, l'erreur suivante est survenue :\nInconnue";
            break;
        case PIECE_NOT_FOUND:
            str = "Attention, l'erreur suivante est survenue :\nPièce non trouvée";
            break;
        case TEMPLATE_RED_NOT_FOUND:
            str = "Attention, l'erreur suivante est survenue :\nTemplate du joueur rouge non trouvée";
            break;
        case TEMPLATE_MANUAL_RED_NOT_FOUND:
            str = "Attention, l'erreur suivante est survenue :\nTemplate créer par l'utilisateur non trouvée (problème involontaire)";
            break;
        case TEMPLATE_BLUE_NOT_FOUND:
            str = "Attention, l'erreur suivante est survenue :\nTemplate du joueur rouge non trouvée ";
            break;
        case TEMPLATE_MANUAL_BLUE_NOT_FOUND:
            str = "Attention, l'erreur suivante est survenue :\nTemplate créer par l'utilisateur non trouvée (problème involontaire) ";
            break;
        case ERROR_IN_TEMPLATE:
            str = "Attention, l'erreur suivante est survenue :\nTemplate du joueur incorrecte, vérifiez votre template ";
            break;
        case PIECE_CANT_MOVE:
            str = "Attention, l'erreur suivante est survenue :\nLa piece ne peut pas bouger.";
            break;
        case PIECE_ATTACK_ALLY:
            str = "Attention, l'erreur suivante est survenue :\nLa piece ne peut pas attaquer une pièce alliée.";
            break;
        case PIECE_WANT_MOVE_AT_FROM_POS:
            str = "Attention, l'erreur suivante est survenue :\nLa piece ne peut pas se déplacer sur la position d'origine.";
            break;
        case PIECE_NOT_FOUND_AT_FROM_POS:
            str = "Attention, l'erreur suivante est survenue :\nLa pièce selectionnée n'a pas été trouvée à la position d'origine.";
            break;
        case DIDNT_MADE_A_CHOICE:
            str = "Attention, l'erreur suivante est survenue :\nVeuillez faire un choix.";
            break;
        default:
            str = "Attention, l'erreur suivante est survenue :\nInconnue";
            break;
    }
    QMessageBox::warning(this, tr("Attention"), str);

}

std::pair<bool, bool> MainWindows::getConfig() {
    return std::pair<bool, bool>();
}

void MainWindows::dragDropEvent(Position pos) {

}


void MainWindows::on_pageConfigRadioREDYES_clicked() {
    //Open QTFile

    QString filename = QFileDialog::getOpenFileName(
            this,
            tr("Open File"),
            "",
            "Fichier template ( *.txt )"
            );
    if (filename != "") {
        ui->pageConfigRadioREDYES->setText("Oui : " + filename);
        QByteArray filetoSt =  filename.toLatin1();
        this->cheminTemplateRED = filetoSt.data();    }
    //QMessageBox::information(this,tr("File Name"),filename);

}


void MainWindows::on_pageConfigRadioBLUEYES_clicked()
{
    QString filename = QFileDialog::getOpenFileName(
            this,
            tr("Open File"),
            "",
            "Fichier template ( *.txt )"
    );
    if (filename != "")  {
        ui->pageConfigRadioBLUEYES->setText("Oui : " + filename);
        QByteArray filetoSt =  filename.toLatin1();
        this->cheminTemplateBLUE = filetoSt.data();
    }

}

/**
 * Fonctione faite par manque de temps pour cacher les elements (on devrait normalement les associer à la page en question
 * mais on a d'autre priorité ( comme commencer la mise en place du game interactive, il est 14h45)
 * @param hide
 */
void MainWindows::showInfos(bool hide) {
    if (!hide) {
        ui->info_2->hide();
        ui->currentPlayerColor->hide();
        ui->label_5->hide();
        ui->label_7->hide();
        ui->label_8->hide();
        ui->label_9->hide();
        ui->scoreBlue_2->hide();
        ui->scoreRed_2->hide();
    } else {
        ui->info_2->show();
        ui->currentPlayerColor->show();
        ui->label_5->show();
        ui->label_7->show();
        ui->label_8->show();
        ui->label_9->show();
        ui->scoreBlue_2->show();
        ui->scoreRed_2->show();
    }

}

































