/********************************************************************************
** Form generated from reading UI file 'View.ui'
**
** Created by: Qt User Interface Compiler version 6.3.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_VIEW_H
#define UI_VIEW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QStackedWidget>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QStackedWidget *stackedWidget;
    QWidget *pageConfig;
    QWidget *layoutWidget;
    QHBoxLayout *horizontalLayout;
    QSpacerItem *horizontalSpacer;
    QLabel *labelConfigPageTitle;
    QSpacerItem *horizontalSpacer_2;
    QWidget *layoutWidget1;
    QHBoxLayout *horizontalLayout_7;
    QSpacerItem *horizontalSpacer_13;
    QVBoxLayout *verticalLayout_3;
    QLabel *labelConfigPageQuestionLoadTemplate;
    QGroupBox *groupBox;
    QVBoxLayout *verticalLayout;
    QRadioButton *pageConfigRadioREDYES;
    QRadioButton *pageConfigRadioREDNO;
    QGroupBox *groupBox_2;
    QVBoxLayout *verticalLayout_2;
    QRadioButton *pageConfigRadioBLUEYES;
    QRadioButton *pageConfigRadioBLUENON;
    QPushButton *buttonConfigPageValidate;
    QSpacerItem *horizontalSpacer_14;
    QWidget *pageWelcome;
    QWidget *layoutWidget_2;
    QHBoxLayout *horizontalLayout_6;
    QSpacerItem *horizontalSpacer_11;
    QLabel *labelWelcomePageTitle;
    QSpacerItem *horizontalSpacer_12;
    QPushButton *pushButtonWelcomePage;
    QLabel *label;
    QWidget *pageGame;
    QWidget *layoutWidget2;
    QHBoxLayout *horizontalLayout_5;
    QSpacerItem *horizontalSpacer_9;
    QLabel *labelGamePageTitle;
    QSpacerItem *horizontalSpacer_10;
    QLabel *string_result;
    QWidget *verticalLayoutWidget;
    QVBoxLayout *verticalLayout_7;
    QLabel *info_2;
    QSpacerItem *verticalSpacer_4;
    QVBoxLayout *verticalLayout_8;
    QLabel *label_5;
    QLabel *currentPlayerColor;
    QSpacerItem *verticalSpacer_5;
    QVBoxLayout *verticalLayout_9;
    QLabel *label_7;
    QLabel *label_8;
    QLabel *scoreRed_2;
    QLabel *label_9;
    QLabel *scoreBlue_2;
    QSpacerItem *verticalSpacer_6;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(1000, 635);
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(MainWindow->sizePolicy().hasHeightForWidth());
        MainWindow->setSizePolicy(sizePolicy);
        MainWindow->setMinimumSize(QSize(1000, 635));
        MainWindow->setMaximumSize(QSize(1000, 635));
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        stackedWidget = new QStackedWidget(centralwidget);
        stackedWidget->setObjectName(QString::fromUtf8("stackedWidget"));
        stackedWidget->setGeometry(QRect(0, 0, 811, 611));
        pageConfig = new QWidget();
        pageConfig->setObjectName(QString::fromUtf8("pageConfig"));
        layoutWidget = new QWidget(pageConfig);
        layoutWidget->setObjectName(QString::fromUtf8("layoutWidget"));
        layoutWidget->setGeometry(QRect(7, 10, 791, 22));
        horizontalLayout = new QHBoxLayout(layoutWidget);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        labelConfigPageTitle = new QLabel(layoutWidget);
        labelConfigPageTitle->setObjectName(QString::fromUtf8("labelConfigPageTitle"));

        horizontalLayout->addWidget(labelConfigPageTitle);

        horizontalSpacer_2 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_2);

        layoutWidget1 = new QWidget(pageConfig);
        layoutWidget1->setObjectName(QString::fromUtf8("layoutWidget1"));
        layoutWidget1->setGeometry(QRect(0, 70, 801, 391));
        horizontalLayout_7 = new QHBoxLayout(layoutWidget1);
        horizontalLayout_7->setObjectName(QString::fromUtf8("horizontalLayout_7"));
        horizontalLayout_7->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer_13 = new QSpacerItem(228, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_7->addItem(horizontalSpacer_13);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        labelConfigPageQuestionLoadTemplate = new QLabel(layoutWidget1);
        labelConfigPageQuestionLoadTemplate->setObjectName(QString::fromUtf8("labelConfigPageQuestionLoadTemplate"));
        labelConfigPageQuestionLoadTemplate->setAlignment(Qt::AlignCenter);

        verticalLayout_3->addWidget(labelConfigPageQuestionLoadTemplate);

        groupBox = new QGroupBox(layoutWidget1);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        verticalLayout = new QVBoxLayout(groupBox);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        pageConfigRadioREDYES = new QRadioButton(groupBox);
        pageConfigRadioREDYES->setObjectName(QString::fromUtf8("pageConfigRadioREDYES"));

        verticalLayout->addWidget(pageConfigRadioREDYES);

        pageConfigRadioREDNO = new QRadioButton(groupBox);
        pageConfigRadioREDNO->setObjectName(QString::fromUtf8("pageConfigRadioREDNO"));

        verticalLayout->addWidget(pageConfigRadioREDNO);


        verticalLayout_3->addWidget(groupBox);

        groupBox_2 = new QGroupBox(layoutWidget1);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        verticalLayout_2 = new QVBoxLayout(groupBox_2);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        pageConfigRadioBLUEYES = new QRadioButton(groupBox_2);
        pageConfigRadioBLUEYES->setObjectName(QString::fromUtf8("pageConfigRadioBLUEYES"));

        verticalLayout_2->addWidget(pageConfigRadioBLUEYES);

        pageConfigRadioBLUENON = new QRadioButton(groupBox_2);
        pageConfigRadioBLUENON->setObjectName(QString::fromUtf8("pageConfigRadioBLUENON"));

        verticalLayout_2->addWidget(pageConfigRadioBLUENON);


        verticalLayout_3->addWidget(groupBox_2);

        buttonConfigPageValidate = new QPushButton(layoutWidget1);
        buttonConfigPageValidate->setObjectName(QString::fromUtf8("buttonConfigPageValidate"));

        verticalLayout_3->addWidget(buttonConfigPageValidate);


        horizontalLayout_7->addLayout(verticalLayout_3);

        horizontalSpacer_14 = new QSpacerItem(228, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_7->addItem(horizontalSpacer_14);

        stackedWidget->addWidget(pageConfig);
        pageWelcome = new QWidget();
        pageWelcome->setObjectName(QString::fromUtf8("pageWelcome"));
        layoutWidget_2 = new QWidget(pageWelcome);
        layoutWidget_2->setObjectName(QString::fromUtf8("layoutWidget_2"));
        layoutWidget_2->setGeometry(QRect(0, 0, 791, 22));
        horizontalLayout_6 = new QHBoxLayout(layoutWidget_2);
        horizontalLayout_6->setObjectName(QString::fromUtf8("horizontalLayout_6"));
        horizontalLayout_6->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer_11 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_6->addItem(horizontalSpacer_11);

        labelWelcomePageTitle = new QLabel(layoutWidget_2);
        labelWelcomePageTitle->setObjectName(QString::fromUtf8("labelWelcomePageTitle"));

        horizontalLayout_6->addWidget(labelWelcomePageTitle);

        horizontalSpacer_12 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_6->addItem(horizontalSpacer_12);

        pushButtonWelcomePage = new QPushButton(pageWelcome);
        pushButtonWelcomePage->setObjectName(QString::fromUtf8("pushButtonWelcomePage"));
        pushButtonWelcomePage->setGeometry(QRect(290, 470, 191, 32));
        label = new QLabel(pageWelcome);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(70, 180, 691, 151));
        label->setTextFormat(Qt::PlainText);
        label->setWordWrap(true);
        stackedWidget->addWidget(pageWelcome);
        pageGame = new QWidget();
        pageGame->setObjectName(QString::fromUtf8("pageGame"));
        sizePolicy.setHeightForWidth(pageGame->sizePolicy().hasHeightForWidth());
        pageGame->setSizePolicy(sizePolicy);
        pageGame->setMinimumSize(QSize(900, 1000));
        pageGame->setMaximumSize(QSize(900, 1000));
        pageGame->setBaseSize(QSize(1000, 1000));
        layoutWidget2 = new QWidget(pageGame);
        layoutWidget2->setObjectName(QString::fromUtf8("layoutWidget2"));
        layoutWidget2->setGeometry(QRect(0, 0, 791, 22));
        horizontalLayout_5 = new QHBoxLayout(layoutWidget2);
        horizontalLayout_5->setObjectName(QString::fromUtf8("horizontalLayout_5"));
        horizontalLayout_5->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer_9 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_5->addItem(horizontalSpacer_9);

        labelGamePageTitle = new QLabel(layoutWidget2);
        labelGamePageTitle->setObjectName(QString::fromUtf8("labelGamePageTitle"));

        horizontalLayout_5->addWidget(labelGamePageTitle);

        horizontalSpacer_10 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_5->addItem(horizontalSpacer_10);

        stackedWidget->addWidget(pageGame);
        string_result = new QLabel(centralwidget);
        string_result->setObjectName(QString::fromUtf8("string_result"));
        string_result->setGeometry(QRect(10, 690, 471, 17));
        verticalLayoutWidget = new QWidget(centralwidget);
        verticalLayoutWidget->setObjectName(QString::fromUtf8("verticalLayoutWidget"));
        verticalLayoutWidget->setGeometry(QRect(810, 0, 176, 561));
        verticalLayout_7 = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout_7->setObjectName(QString::fromUtf8("verticalLayout_7"));
        verticalLayout_7->setContentsMargins(0, 0, 0, 0);
        info_2 = new QLabel(verticalLayoutWidget);
        info_2->setObjectName(QString::fromUtf8("info_2"));
        QFont font;
        font.setPointSize(20);
        info_2->setFont(font);
        info_2->setAlignment(Qt::AlignCenter);

        verticalLayout_7->addWidget(info_2);

        verticalSpacer_4 = new QSpacerItem(174, 20, QSizePolicy::Minimum, QSizePolicy::Maximum);

        verticalLayout_7->addItem(verticalSpacer_4);

        verticalLayout_8 = new QVBoxLayout();
        verticalLayout_8->setSpacing(6);
        verticalLayout_8->setObjectName(QString::fromUtf8("verticalLayout_8"));
        verticalLayout_8->setContentsMargins(-1, 10, -1, 10);
        label_5 = new QLabel(verticalLayoutWidget);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        QFont font1;
        font1.setPointSize(14);
        label_5->setFont(font1);
        label_5->setAlignment(Qt::AlignCenter);

        verticalLayout_8->addWidget(label_5);

        currentPlayerColor = new QLabel(verticalLayoutWidget);
        currentPlayerColor->setObjectName(QString::fromUtf8("currentPlayerColor"));
        currentPlayerColor->setFont(font1);
        currentPlayerColor->setAlignment(Qt::AlignCenter);

        verticalLayout_8->addWidget(currentPlayerColor);


        verticalLayout_7->addLayout(verticalLayout_8);

        verticalSpacer_5 = new QSpacerItem(174, 48, QSizePolicy::Minimum, QSizePolicy::Maximum);

        verticalLayout_7->addItem(verticalSpacer_5);

        verticalLayout_9 = new QVBoxLayout();
        verticalLayout_9->setObjectName(QString::fromUtf8("verticalLayout_9"));
        label_7 = new QLabel(verticalLayoutWidget);
        label_7->setObjectName(QString::fromUtf8("label_7"));
        label_7->setFont(font1);
        label_7->setAlignment(Qt::AlignCenter);

        verticalLayout_9->addWidget(label_7);

        label_8 = new QLabel(verticalLayoutWidget);
        label_8->setObjectName(QString::fromUtf8("label_8"));
        label_8->setAlignment(Qt::AlignCenter);

        verticalLayout_9->addWidget(label_8);

        scoreRed_2 = new QLabel(verticalLayoutWidget);
        scoreRed_2->setObjectName(QString::fromUtf8("scoreRed_2"));
        scoreRed_2->setAlignment(Qt::AlignCenter);

        verticalLayout_9->addWidget(scoreRed_2);

        label_9 = new QLabel(verticalLayoutWidget);
        label_9->setObjectName(QString::fromUtf8("label_9"));
        label_9->setAlignment(Qt::AlignCenter);

        verticalLayout_9->addWidget(label_9);

        scoreBlue_2 = new QLabel(verticalLayoutWidget);
        scoreBlue_2->setObjectName(QString::fromUtf8("scoreBlue_2"));
        scoreBlue_2->setAlignment(Qt::AlignCenter);

        verticalLayout_9->addWidget(scoreBlue_2);

        verticalLayout_9->setStretch(0, 10);
        verticalLayout_9->setStretch(1, 10);
        verticalLayout_9->setStretch(2, 10);
        verticalLayout_9->setStretch(3, 10);
        verticalLayout_9->setStretch(4, 10);

        verticalLayout_7->addLayout(verticalLayout_9);

        verticalSpacer_6 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Fixed);

        verticalLayout_7->addItem(verticalSpacer_6);

        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 1000, 22));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        stackedWidget->setCurrentIndex(2);


        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        labelConfigPageTitle->setText(QCoreApplication::translate("MainWindow", "CONFIGURATION", nullptr));
        labelConfigPageQuestionLoadTemplate->setText(QCoreApplication::translate("MainWindow", "Voulez-vous charger une tamplate: ?", nullptr));
        groupBox->setTitle(QCoreApplication::translate("MainWindow", "Joueur rouge", nullptr));
        pageConfigRadioREDYES->setText(QCoreApplication::translate("MainWindow", "Oui", nullptr));
        pageConfigRadioREDNO->setText(QCoreApplication::translate("MainWindow", "Non", nullptr));
        groupBox_2->setTitle(QCoreApplication::translate("MainWindow", "Joueur bleu", nullptr));
        pageConfigRadioBLUEYES->setText(QCoreApplication::translate("MainWindow", "Oui", nullptr));
        pageConfigRadioBLUENON->setText(QCoreApplication::translate("MainWindow", "Non", nullptr));
        buttonConfigPageValidate->setText(QCoreApplication::translate("MainWindow", "Valider", nullptr));
        labelWelcomePageTitle->setText(QCoreApplication::translate("MainWindow", "WELCOME", nullptr));
        pushButtonWelcomePage->setText(QCoreApplication::translate("MainWindow", "ALLER A LA PAGE CONFIG", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "Bienvenue sur le jeu Stratego, Vous devez configurer le jeu avant de pouvoir lancer votre partie ! Apr\303\250s avoir cliqu\303\251 sur le bouton ci-dessous, vous pourrez chosir comment voulez vous placer vos pi\303\250ces, soit au moyen d'un template, soit de fa\303\247on interactive", nullptr));
        labelGamePageTitle->setText(QCoreApplication::translate("MainWindow", "Jeu", nullptr));
        string_result->setText(QCoreApplication::translate("MainWindow", "TextLabel", nullptr));
        info_2->setText(QCoreApplication::translate("MainWindow", "Info", nullptr));
        label_5->setText(QCoreApplication::translate("MainWindow", "Current Player ", nullptr));
        currentPlayerColor->setText(QCoreApplication::translate("MainWindow", "?", nullptr));
        label_7->setText(QCoreApplication::translate("MainWindow", "Players Scores :", nullptr));
        label_8->setText(QCoreApplication::translate("MainWindow", "<html><head/><body><p>Player <span style=\" color:#cc0000;\">RED </span>:</p></body></html>", nullptr));
        scoreRed_2->setText(QCoreApplication::translate("MainWindow", "0", nullptr));
        label_9->setText(QCoreApplication::translate("MainWindow", "<html><head/><body><p>Player <span style=\" color:#3465a4;\">BLUE</span> : </p></body></html>", nullptr));
        scoreBlue_2->setText(QCoreApplication::translate("MainWindow", "0", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_VIEW_H
