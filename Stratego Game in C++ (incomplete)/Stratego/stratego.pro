TEMPLATE = subdirs

SUBDIRS += \
    src/gui \
    src/strategocore \
    src/tui \
    tests

src-tui.depends = src/strategocore
src-gui.depends = src/strategocore
tests.depends = src/strategocore

OTHER_FILES += config.pri
