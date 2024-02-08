CONFIG += c++17

CONFIG -= debug_and_release debug_and_release_target

include($${PWD}/src/strategocore/strategocore.pri)

QMAKE_CXXFLAGS += -Wall -pedantic-errors -Wuninitialized

##DISTFILES += \
##    $$PWD/strategocore.pri

