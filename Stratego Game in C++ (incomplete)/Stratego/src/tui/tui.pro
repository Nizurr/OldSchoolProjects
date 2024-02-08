TEMPLATE = app
CONFIG += console
CONFIG -= app_bundle
CONFIG -= qt

include(../../config.pri)

SOURCES += \
        Controller.cpp \
        View.cpp \
        main.cpp \

HEADERS += \
    Controller.h \
    View.h
