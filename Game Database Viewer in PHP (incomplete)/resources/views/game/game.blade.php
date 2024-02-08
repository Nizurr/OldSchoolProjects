@extends('layouts.app')
@section('content')

        <div class="game-page-container">
            <div class="row-game">
                <div class="big-game-jacket" style="background-image: url({{$game->GAME_COVER_URL}});"></div>
                <div class="infos">
                    <div class="text-center">
                        <span id="game_title">{{$game->GAME_NAME}}</span>
                    </div>
                    <div class="ratings">
                        <div class="rating-container">
                            <span id="game_rating">{{number_format ($game->GAME_AGGREGATED_RATING, 0)}}</span>
                            <div class="esrb_title">Rating</div>
                        </div>
                        <div class="rating-container">
                            <span id="game_esrb">{{$game->ESRB_RATING}}</span>
                            <div class="rating_title">ESRB</div>

                        </div>
                        @if(!is_null($game->PEGI_RATING))
                            <div class="rating-container">
                                @if($game->PEGI_RATING == "Three")
                                    <img class="pegi" src="/assets/images/pegi/PEGI3.png" alt="pegi 12">
                                @endif
                                @if($game->PEGI_RATING == "Seven")
                                    <img class="pegi" src="/assets/images/pegi/PEGI7.png" alt="pegi 12">
                                @endif
                                @if($game->PEGI_RATING == "Twelve")
                                    <img class="pegi" src="/assets/images/pegi/PEGI12.png" alt="pegi 12">
                                @endif
                                @if($game->PEGI_RATING == "Sixteen")
                                    <img class="pegi" src="/assets/images/pegi/PEGI16.png" alt="pegi 16">
                                @endif
                                @if($game->PEGI_RATING == "Eighteen")
                                    <img class="pegi" src="/assets/images/pegi/PEGI18.png" alt="pegi 18">
                                @endif
                                <div class="rating_title">PEGI</div>

                            </div>
                        @endif
                    </div>
                    <br>
                    <div>
                        <span class="text-uppercase font-weight-bold">Developpers : </span>
                        @foreach($game->developer as $developer)
                            <span>{{$developer->COMPANY_NAME}}</span>
                        @endforeach
                    </div>
                    <div>
                        <span class="text-uppercase font-weight-bold">Publishers : </span>
                        @foreach($game->publishers as $pub)
                            <span>{{$pub->COMPANY_NAME}}</span>
                        @endforeach
                    </div>
                    @if($game->franchise != null)

                    <div>
                        <span class="text-uppercase font-weight-bold">Franchise : </span>
                            <span>{{$game->franchise->FRANCHISE_NAME}}</span>
                    </div>
                    @endif
                    <div class="genres">
                        @foreach($game->genres as $genre)
                            <span class="badge badge-pill badge-primary">{{$genre->GENRE_NAME}}</span>
                        @endforeach
                    </div>
                    <div class="description">
                        <h2 class="display-one mt-5 font-weight-bold text-uppercase">Description</h2>
                        <p class="game_page_text">{{$game->GAME_SUMMARY}}</p>
                    </div>
                    <br>
                    @if($game->GAME_STORYLINE != "NULL")
                        <div class="storyline">
                            <h2 class="display-one mt-5 font-weight-bold text-uppercase">STORYLINE</h2>
                            <p class="game_page_text">{{$game->GAME_STORYLINE}}</p>
                        </div>
                    @endif
                </div>
            </div>
            <div class="row-game links-exp-release">
                <div class="websites-links col-sm">
                    <h3 class="text-uppercase">Links</h3>
                    @foreach($game->websites as $website)
                        @if ($website->WEBSITE_CAT == "official")
                            <a href="{{$website->WEBSITE_URL}}">Official Website</a> <br>
                        @elseif ($website->WEBSITE_CAT == "wiki")
                            <a href="{{$website->WEBSITE_URL}}">Wiki</a><br>
                        @elseif ($website->WEBSITE_CAT == "facebook")
                            <a href="{{$website->WEBSITE_URL}}">Facebook</a><br>
                        @elseif ($website->WEBSITE_CAT == "twitter")
                            <a href="{{$website->WEBSITE_URL}}">Twitter</a><br>
                        @elseif ($website->WEBSITE_CAT == "instagram")
                            <a href="{{$website->WEBSITE_URL}}">Instagram</a><br>
                        @elseif ($website->WEBSITE_CAT == "youtube")
                            <a href="{{$website->WEBSITE_URL}}">Youtube</a><br>
                        @elseif ($website->WEBSITE_CAT == "twitch")
                            <a href="{{$website->WEBSITE_URL}}">Twitch</a><br>
                        @elseif ($website->WEBSITE_CAT == "reddit")
                            <a href="{{$website->WEBSITE_URL}}">Reddit</a><br>
                        @elseif ($website->WEBSITE_CAT == "wikipedia")
                            <a href="{{$website->WEBSITE_URL}}">Wikipedia</a><br>
                        @elseif ($website->WEBSITE_CAT == "gog")
                            <a href="{{$website->WEBSITE_URL}}">GOG</a><br>
                        @elseif ($website->WEBSITE_CAT == "steam")
                            <a href="{{$website->WEBSITE_URL}}">Steam</a><br>
                        @elseif ($website->WEBSITE_CAT == "epicgames")
                            <a href="{{$website->WEBSITE_URL}}">Epic Games</a><br>
                        @endif
                    @endforeach
                </div>
                <div class="col-sm">
                    <h3 class="text-uppercase"> Expansions</h3>
                    @if(count($game->expansions) == 0)
                        <p>No expansion</p>
                    @endif
                        @foreach($game->expansions as $expansion)
                            <p>{{$expansion->EXP_NAME}}</p>
                        @endforeach
                </div>
                <div class="col-sm">
                    <h3 class="text-uppercase">Release</h3>
                    @foreach($game->game_release as $release)
                        <span>{{$release->RELEASE_REGION}} :  {{$release->RELEASE_DATE}}</span><br>
                    @endforeach
                </div>
            </div>




    <!-- https://www.w3schools.com/howto/howto_js_slideshow.asp -->
    <div class="slideshow-container">
        <div class="text-center">
            <h2>Pictures</h2>
        </div>
        @foreach($game->images as $image)
            <div class="mySlides fade">
                <div class="text-center">
                    <img src="{{$image->IMAGE_URL}}" style="max-height:400px">
                </div>
            </div>
        @endforeach
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
    </div>


    <div class="text-center">
        <h2>Videos</h2>
    </div>
    <div class="video-container">
        @foreach($game->videos as $video)
            <div class="video">
                <iframe width="300" height="200" src="https://www.youtube.com/embed/{{substr($video->VIDEO_URL, 32)}}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        @endforeach
    </div>
        </div>


    <script>
        let dev = @json($game->franchise);
        console.log(dev);


        let slideIndex = 2;
        showSlides(slideIndex);

        // Next/previous controls
        function plusSlides(n) {
            showSlides(slideIndex += n);
        }
        // Thumbnail image controls
        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            let i;
            let slides = document.getElementsByClassName("mySlides");

            if (n > slides.length) {slideIndex = 1} // en boucle (s'arrete pas à la fin)
            if (n < 1) {slideIndex = slides.length} // en boucle
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slides[slideIndex-1].style.display = "block";
        }
    </script>
@endsection

