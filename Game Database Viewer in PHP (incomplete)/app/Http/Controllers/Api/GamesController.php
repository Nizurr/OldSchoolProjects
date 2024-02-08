<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Developer;
use App\Models\Game;
use App\Models\Company;
use App\Models\Publisher;
use App\Models\Images;

class GamesController extends Controller {

    public function search($name) {
        $game = Game::where('GAME_NAME', 'like', "%$name%")->get();
        return response()->json($game);
    }

    public function getMostPopular() {
        $mostPopular = Game::orderBy('GAME_AGGREGATED_RATING', 'desc')->limit(10)->get();
        return view('homepage', ['mostPopularGames' => $mostPopular]);
    }

    public function getGameView($id) {
        // $game = Game::find($id);

        $game = Game::find($id);
        return view('game/game', ['game' => $game]);

    }

    public function getCompaniesView() {
        $companies = Company::all();
        $developers = Developer::all();
        return view('companies', ['companies' => $companies, 'developers' => $developers]);    }

    public function getCompanyView($id) {
        $company = Company::find($id);
        $gamesDevId = Developer::where('COMPANY_ID', $id)->get();
        $gamesPubId = Publisher::where('COMPANY_ID', $id)->get();
        $gamesDev = [];
        $gamesPub = [];
        foreach ($gamesDevId as $game) {
            $gamesDev[] = Game::find($game->GAME_ID);
        }
        foreach ($gamesPubId as $game) {
            $gamesPub[] = Game::find($game->GAME_ID);
        }
        return view('companies/companies', ['company' => $company, 'gamesDev' => $gamesDev, 'gamesPub' => $gamesPub]);
    }

    public function random() {
        $image = Images::inRandomOrder()->first();
        return response()->json($image);

    }

}
