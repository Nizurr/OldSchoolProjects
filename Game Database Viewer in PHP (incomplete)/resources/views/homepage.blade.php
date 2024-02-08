@extends('layouts.app')
@section('content')

    <div class="container">
            <div class="col-12 text-center pt-5">
                <span class="display-one mt-5 homepage-text"></span> <!-- This is the text that will be replaced by css (global.css -->
                <br>
            </div>
        <h2 class="display-one mt-5 font-italic font-weight-bold text-uppercase">Top 10 Games</h2> <!-- This is the text that will be replaced by css (global.css -->

        <div id="gamesContainer">
            @foreach($mostPopularGames as $game)
                    <a href="/game/{{$game->GAME_ID}}" class="game-jacket" id="{{$game->GAME_ID}}">
                        <img src="{{$game->GAME_COVER_URL}}">
                        <div class="game-jacket-title">
                            <span>{{$game->GAME_NAME}}</span>
                        </div>
                    </a>
            @endforeach
        </div>
        <br><br>
        <center><img src="" id="image" style="width: 500px"></center>
        <!-- oui, un center, c'est déprcié, il me reste 7 minutes ok ? -->
    </div>

    <script>
        const img = document.querySelector("#image");

        // Fonction pour mettre à jour l'image
        const updateImage = () => {
            fetch("api/images/random")
                .then(response => response.json())
                .then(data => {
                    img.src = data.IMAGE_URL;
                });
        };

        // Appel initial de la fonction pour mettre à jour l'image
        updateImage();

        // Appel répété de la fonction toutes les 5 secondes
        setInterval(updateImage, 5000);
    </script>
@endsection
