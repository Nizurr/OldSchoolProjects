@extends('layouts.app')
@section('content')

    <script>
        let data;
        $(document).ready(function () {
            $('#gameName').on('input', async function (e) {
                e.preventDefault(); // Prevents the page from refreshing
                if ($('#gameName').val().length < 3) {
                    $('#gamesContainer').empty(); // remove results if the input is less than 3 characters
                    // (supprimes les résultats précédants si il fait une nouvelle recherche)
                    return;
                }
                try {
                    const call = await fetch('/api/games/' + $('#gameName').val())
                    data = await call.json();
                    console.log(data);
                    $('#gamesContainer').empty();
                    await data.forEach(game => {
                        console.log(game)
                        $('#gamesContainer').append(`
                            <a href="/game/${game.GAME_ID}" class="game-jacket" id="${game.GAME_ID}">
                                <img src="${game.GAME_COVER_URL}">
                                <div class="game-jacket-title">
                                    <span>${game.GAME_NAME}</span>
                                </div>
                            </a>
                        `);
                    });

                } catch (error) {
                    console.log(error);
                }
            });
        });
    </script>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center pt-5">
                <div class="search">
                    <div class="search-2">
                        <input type="text" placeholder="Recherche..." id="gameName">
                    </div>
                </div>
                <div id="gamesContainer"></div>
            </div>
        </div>
    </div>
@endsection
