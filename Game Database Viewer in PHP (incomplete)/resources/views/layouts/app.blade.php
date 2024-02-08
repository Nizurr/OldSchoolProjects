<html>
    <head>
        <title>The Game Database</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Merriweather">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <link rel="stylesheet" href="<?php echo asset('assets/css/header.css')?>" type="text/css">
        <link rel="stylesheet" href="<?php echo asset('assets/css/game_jacket.css')?>" type="text/css">
        <link rel="stylesheet" href="<?php echo asset('assets/css/global.css')?>" type="text/css">
        <link rel="stylesheet" href="<?php echo asset('assets/css/game_page.css')?>" type="text/css">
        <link rel="stylesheet" href="<?php echo asset('assets/css/search_page.css')?>" type="text/css">
        <link rel="stylesheet" href="<?php echo asset('assets/css/company.css')?>" type="text/css">
    </head>
    <body>
    <header>
      <div class="header">
          <a href="/" class="logo">TGDB</a>
          <div class="header-right">
              <a class="active" href="/">Accueil</a>
              <a href="/companies">Companies</a>
              <a href="/search">Recherche</a>
          </div>
      </div>
    </header>

            @yield('content')

    <footer class="text-center">
            <div class="row">
                <div class="col-4">
                    <span>Adnane AZAOUM</span>
                </div>

                <div class="col-4">
                    <span>2022-2023</span>

                </div>

                <div class="col-4">
                    <span>WEBR3</span>

                </div>
            </div>

    </footer>
    </body>
</html>
