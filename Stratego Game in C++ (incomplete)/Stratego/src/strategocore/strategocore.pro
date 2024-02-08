#QT -= gui

TEMPLATE = lib
CONFIG += staticlib

include(../../config.pri)

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
    AllPieces.cpp \
    Game.cpp \
    Piece.cpp \
    Player.cpp \
    Position.cpp \
    Square.cpp

HEADERS += \
    AllPieces.h \
    Board.h \
    Game.h \
    Piece.h \
    Player.h \
    Position.h \
    Power.h \
    PlayerColor.h \
    GameStatus.h \
    Square.h \
    SquareType.h \
    LogMessage.h

#    Model.h \
# Default rules for deployment.
unix {
    target.path = $$[QT_INSTALL_PLUGINS]/generic
}
!isEmpty(target.path): INSTALLS += target

DISTFILES += \
    strategocore.pri


