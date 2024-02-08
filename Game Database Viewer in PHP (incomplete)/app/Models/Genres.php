<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Genres extends Model {
    protected $table = 'genres';
    protected $primaryKey = 'GENRE_ID';
    public $timestamps = false;
}

?>
