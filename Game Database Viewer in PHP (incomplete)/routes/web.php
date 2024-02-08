<?php

use App\Http\Controllers\Api\GamesController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', [GamesController::class, ('getMostPopular')]);

Route::get('/search', function () {
    return view('search');
});


Route::get('/game/{slug}', [GamesController::class, 'getGameView']);

Route::get('/companies', [GamesController::class, 'getCompaniesView']);
Route::get('/companies/{id}', [GamesController::class, 'getCompanyView']);