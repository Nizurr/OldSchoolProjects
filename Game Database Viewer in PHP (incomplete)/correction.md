# Commentaires
## Projet
* Balise `nav` non utilisée
* Tu as beaucoup de feuilles de style mais elles sont toutes utilisées dans le template ; il serait plus efficace de regrouper en un seul fichier (pour éviter des requêtes à répétition) ou à mieux assigner chaque feuille de style à la page appropriée.
* Séparation des responsabilités : il vaut mieux placer tes scripts dans des fichiers à part plutôt que dans le code HTML de la page.
* Il serait utile d'employer des routes nommées.
* Pourquoi créer un espace de nom `API` qui contient un contrôleur qui gère à la fois les pages Web et les appels via API ?
* Il est préférable d'utiliser `.then` plutôt que `await` afin de s'assurer que l'appel à `fetch` est non-bloquant. Tu meux même utiliser cette syntaxe pour faire ta gestion d'erreurs sans `try catch`.

## Défense écrite
* Sociétés :
    * Pourquoi charger à la fois les sociétés et les `Developers` dans `getCompaniesView` ? `Developers` est une table de pivot.
    * Tu n'exploites pas les relations _many-to-many_.
* L'image chargée ne lie pas vers la page du jeu associé.

## Défense orale
Bonne défense

# Evaluation
| Question    | Sur    | Résultat |
|-------------|--------|----------|
| Vues HTML/CSS     | 15 |     9  |
| Contrôleurs web   | 10 |     8  |
| Modèles éloquents | 10 |    10  |
| Contrôleur API    |  5 |     5  |
| AJAX recherche    | 10 |     8  |
| _Total projet_  | _50_ |  _40_  |
| Défense Q1        | 10 |     5  |
| Défense Q1        | 10 |     8  |
| Défense orale     | 30 |    24  |
| _Total défense_ | _50_ |  _37_  |
| __Total__    | __100__ | __77__ |
| __Total__     | __20__ | __15__ |
