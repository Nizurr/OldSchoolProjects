<?php

use App\Http\Controllers\Api\GamesController;
use Illuminate\Support\Facades\Route;

Route::get('/games/{name}', [GamesController::class, 'search']);
Route::get('/images/random', [GamesController::class, 'random']);
