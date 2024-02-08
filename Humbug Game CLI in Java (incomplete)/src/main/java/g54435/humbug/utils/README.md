# TerminalColor

Un simple fichier — contenant une énumiration de couleurs — permettant
d'utiliser des couleurs dans un terminal. 

## Explications

(Initialement posté là: <http://esi.namok.be/faq.html#7>)

Il est possible d'écrire en couleur dans un terminal si le terminal l'autorise
(ce qui est le cas de tous les terminaux Linux que je connais… et
évidemment pas de la console MS-DOS).

Pour ce faire, nous utiliserons les codes d'échappement ANSI du style **ESC
[ 'paramètres' m** où ESC est le caractère ASCII 27 et paramètres sont aucun ou
plusieurs nombres séparés par des point-virgules ";". Pour écrire en couleur
(et/ou souligné et/ou en gras) il suffit d'ajouter ces séquences de caractères
à la chaine de caractères que l'on veut afficher. Ils seront transformés par
le terminal en ce que l'on veut.

De manière tout à fait générale, la formule est `\033[i;j;k;lm` où

* i appartient à [30,37] et détermine la couleur de l'avant-plan ;
* j appartient à [40,47] et détermine la couleur de l'arrière-plan ;
* k = 21 et signale que l'on souligne ;
* l = 1 et signale que l'on écrit en gras.

Quelques exemples pour mieux comprendre

* `\033[41;30m` affiche en noir sur fond rouge
* `\033[31;40;1m` affiche en rouge sur fond noir en gras
* `\033[31;47;21;m` affiche en rouge sur fond noir en souligné
* `\033[31;47;21;1m` affiche en rouge sur fond noir en souligné et gras
* `\033[0;0m` rétablit l'affichage par défaut

[ANSI/VT100 Terminal Control Escape Sequences](http://www.termsys.demon.co.uk/vtansi.htm)

## Utilisation

Pour utiliser cette énumération, il suffit de la copier dans son projet. Inutile de changer de nom de *package* puisqu'elle est copie dans le répertoire qui va bien. 

## Contact

Contact: <pbettens@he2b.be>

![CC-BY-SA](cc-by-sa.png)


