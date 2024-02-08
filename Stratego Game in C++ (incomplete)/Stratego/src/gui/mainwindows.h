#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QEvent>
#include <QLabel>
#include <QMainWindow>
#include "LogMessage.h"
#include "guicontroler.h"
#include "boardStratego.h"
#include "Position.h"
QT_BEGIN_NAMESPACE
namespace Ui {
    class MainWindow;
}
QT_END_NAMESPACE

class MainWindows : public QMainWindow {

    Q_OBJECT

private:
    Ui::MainWindow *ui;
    GUIControler controler;
    BoardStratego *board;
    std::string cheminTemplateRED;
    std::string cheminTemplateBLUE;


public:

    /**
     * @brief MainWindows simple constructor.
     * @param parent
     */
    MainWindows(QWidget *parent = nullptr);
    ~MainWindows();

    /**
     * @brief popupMessage show message like notification.
     * @param message
     */
    void popupMessage(LogMessage message);

    /**
     * @brief getConfig
     * @return
     */
    std::pair<bool,bool> getConfig();

    /**
     * @brief dragDropEvent
     * @param pos
     */
    void dragDropEvent(Position pos);

    /**
     * @brief updateBoard updating the board.
     * @param board
     */
    void updateBoard(Board board);

    /**
     * @brief showInfos
     * @param hide
     */
    void showInfos(bool hide);


private slots:

    void on_pushButtonWelcomePage_clicked();
    void on_buttonConfigPageValidate_clicked();
    void on_pageConfigRadioBLUEYES_clicked();
    void on_pageConfigRadioREDYES_clicked();
    /**
     * @brief on_board_signal is the slot for signal receive from board
     * when a drag and drop is done.
     */
    void on_board_signal(std::pair<int, int>, std::pair<int, int>);
};

#endif // MAINWINDOW_H
