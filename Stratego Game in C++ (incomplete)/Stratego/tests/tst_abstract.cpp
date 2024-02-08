#include <catch2/catch.hpp>
#include <Game.h>

TEST_CASE("test class Game, noAbstract") {
/**
    SECTION("no abstract between tow positions"){
        Position from {7,4};
        Position to {6,4};
        Game game = Game();
        game.initialize(true,true);
        game.initialize(true,false);

        bool expected = true;
        REQUIRE(expected == game.isThereAbstract(from, to));
    }

    SECTION("no abstract between tow positions"){
        Position from {7,4};
        Position to {5,4};
        Game game = Game();
        game.initialize(true,true);
        game.initialize(true,false);

        bool expected = true;
        REQUIRE(expected == game.isThereAbstract(from, to));
    }

    SECTION("should work"){
        Position from {6,4};
        Position to {5,4};
        Game game = Game();

        game.initialize(true,true);
        game.initialize(true,false);

        bool expected = false;
        REQUIRE(expected == game.isThereAbstract(from, to));
    }

    SECTION("test red go on blue piece"){
        Position from {4,4};
        Position to {3,4};
        Game game = Game();

        game.initialize(true,true);
        game.initialize(true,false);
        game.getPlayerRed().getPiece(Position(6,4)).setPositionOnBoard(Position(4,4)); //
        bool expected = true;
        REQUIRE(expected == game.isThereAbstract(from, to));
    }

    SECTION("test red go on blue piece"){
        Position from {4,4};
        Position to {3,4};

        Player red = Player(RED);
        red.addPiece(AllPi::Sergent(Position(4,4)));
        Player blue = Player(BLUE);
        Game game = Game(red,blue);
        game.initialize(true,true);
        game.initialize(true,false);
        //game.updateBoard();
        //view.showBoard(game.getBoard());
        bool expected = true;
        REQUIRE(expected == game.isThereAbstract(from, to));
    }

    SECTION("red horizontal"){
        Position from {4,4};
        Position to {4,5};

        Player red = Player(RED);
        Player blue = Player(BLUE);
        red.addPiece(AllPi::Sergent(Position(4,4)));
        Game game = Game(red,blue);
        game.initialize(true,true);
        game.initialize(true,false);
        game.updateBoard();
        bool expected = false;
        bool result = game.isThereAbstract(from, to);
        REQUIRE(expected == result);
    }
    */
}
