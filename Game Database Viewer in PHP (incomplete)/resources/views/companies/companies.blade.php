@extends('layouts.app')
@section('content')

    <div class="container">
        <div class="col-12 text-center pt-5">
            <br>
        </div>
        <center>        <h2 class="display-one mt-5 font-italic font-weight-bold text-uppercase" style="margin-bottom: 60px">Companies</h2> <!-- This is the text that will be replaced by css (global.css -->
        </center> <!-- center deprecié oui je sais, bref -->

        <!-- show infos about the unique $company -->
        <h1>SOCIETE : {{$company->COMPANY_NAME}}</h1>

        <!-- show the list of games -->
        <h1>Jeux Produits</h1><br>
        <div id="gamesContainer">
            @foreach($gamesPub as $game)
                <a href="/game/{{$game->GAME_ID}}" class="game-jacket" id="{{$game->GAME_ID}}">
                    <img src="{{$game->GAME_COVER_URL}}">
                    <div class="game-jacket-title">
                        <span>{{$game->GAME_NAME}}</span>
                    </div>
                </a>
            @endforeach

        </div>
        <br><br>
        <h1>Jeux Devloppés</h1><br>
        <div id="gamesContainer">
            @foreach($gamesDev as $game)
                <a href="/game/{{$game->GAME_ID}}" class="game-jacket" id="{{$game->GAME_ID}}">
                    <img src="{{$game->GAME_COVER_URL}}">
                    <div class="game-jacket-title">
                        <span>{{$game->GAME_NAME}}</span>
                    </div>
                </a>
            @endforeach

        </div>

    </div>
@endsection
