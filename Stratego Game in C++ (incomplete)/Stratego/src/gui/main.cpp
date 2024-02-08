#include <QApplication>
#include "guicontroler.h"
#include <mainwindows.h>
int main(int argc, char *argv[]) {

    QApplication a(argc, argv);
    GUIControler controler;
    MainWindows gui;
    gui.show();
    return a.exec();

}
