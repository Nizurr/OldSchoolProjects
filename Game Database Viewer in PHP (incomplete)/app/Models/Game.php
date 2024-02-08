<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use Illuminate\Database\Eloquent\Relations\HasMany;
use Illuminate\Database\Eloquent\Relations\HasOne;

class Game extends Model {
    protected $table = 'games';
    protected $primaryKey = 'GAME_ID';
    public $timestamps = false;

    public function genres(): BelongsToMany {
        return $this->belongsToMany(Genres::class,'GAME_GENRE', 'GAME_ID', 'GENRE_ID');
    }

    public function franchise(): HasOne {
        return $this->hasOne(Franchises::class, 'FRANCHISE_ID', 'FRANCHISE_ID');
    }

    public function engine(): HasOne {
        return $this->hasOne(Engines::class, 'ENGINE_ID', 'ENGINE_ID');
    }

    public function company(): HasOne {
        return $this->hasOne(Company::class, 'COMPANY_ID', 'COMPANY_ID');
    }

    public function platforms(): BelongsToMany {
        return $this->belongsToMany(Company::class, 'PLATFORM','COMPANY_ID',  'PLATFORM_ID');
    }

    public function developer(): BelongsToMany {
        return $this->belongsToMany(Company::class, 'DEVELOPER','GAME_ID',  'COMPANY_ID');
    }


    public function publishers(): BelongsToMany {
        return $this->belongsToMany(Company::class, 'PUBLISHER','GAME_ID',  'COMPANY_ID');
    }


    public function videos(): HasMany {
        return $this->hasMany(Videos::class, 'GAME_ID', 'GAME_ID' );
    }

    public function expansions(): HasMany {
        return $this->hasMany(Expansions::class, 'GAME_ID', 'GAME_ID' );
    }

    public function game_mode(): HasMany {
        return $this->hasMany(Game_mode::class, 'GAME_ID', 'GAME_ID' );
    }

    public function images(): HasMany {
        return $this->hasMany(Images::class, 'GAME_ID', 'GAME_ID' );
    }

    public function websites(): HasMany {
        return $this->hasMany(Website::class, 'GAME_ID', 'GAME_ID' );
    }

    public function game_release(): HasMany {
        return $this->hasMany(Game_release::class, 'GAME_ID', 'GAME_ID' );
    }
}

?>
