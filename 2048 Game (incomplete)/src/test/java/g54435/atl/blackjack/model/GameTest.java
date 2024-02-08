package g54435.atl.blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    public LevelStatus checkScore(LevelStatus lvlStatusActual, Player p1, Player p2) {
        if (p1.getScore() > 21) {//Le joueur à + de 21.=> Fin du jeu
            return LevelStatus.FAIL;
        } else if (p2.getScore() > 21) {
            return LevelStatus.WIN;
        } else if (p1.getScore() == 21 && p2.getScore() < 21 && lvlStatusActual == LevelStatus.PLAYERSTOP) { //Si le joueur à 21 et que la banque à moins de 21 ET que le jeu est en cours (que la banque à joué)
            return LevelStatus.WIN;
        } else if (p1.getScore() == p2.getScore() && lvlStatusActual == LevelStatus.PLAYERSTOP) { //Si le joueur à autant que la banque et la banque à fini de jouer.
            return LevelStatus.EQUALITY;
        } else if (p1.getScore() <= 21 && p1.getScore() > p2.getScore() && lvlStatusActual == LevelStatus.PLAYERSTOP) {//Si le joueur à un score supérieur à la banque et que la banque à fini de joué
            return LevelStatus.WIN;
        } else if (p1.getScore() < p2.getScore() && p2.getScore() <= 21 && lvlStatusActual == LevelStatus.PLAYERSTOP) {
            return LevelStatus.FAIL;
        } else {
            return LevelStatus.IN_PROGRESS;
        }
    }


    @Test
    public void testLevelStatus_Simple() {
        System.out.println("Test : Check Score Simple");
        LevelStatus levelStatus = LevelStatus.IN_PROGRESS;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        p1.addCardToHand(c1);
        p1.addCardToHand(c2);


        Player p2 = new Player();
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.IN_PROGRESS;
        assertEquals(expected, result);
    }



    @Test
    public void testLevelStatus_BankWinWithPlayerStop() {
        System.out.println("Test : Bank win with play with playerSTOP");
        LevelStatus levelStatus = LevelStatus.PLAYERSTOP;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.TEN);
        Card c3 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.addCardToHand(c1);


        p2.addCardToHand(c3);
        p2.addCardToHand(c1);
        System.out.println("Score : p1: " + p1.getScore() + "   Score : p2: " + p2.getScore());
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.FAIL;
        assertEquals(expected, result);
    }

    @Test
    public void testLevelStatus_EqualityWithPlayerSTOP() {
        System.out.println("Test : equality with playerSTOP");
        LevelStatus levelStatus = LevelStatus.PLAYERSTOP;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.TEN);
        Card c3 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.addCardToHand(c3);
        p1.addCardToHand(c1);

        p2.addCardToHand(c3);
        p2.addCardToHand(c1);
        System.out.println("Score : p1: " + p1.getScore() + "   Score : p2: " + p2.getScore());
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.EQUALITY;
        assertEquals(expected, result);
    }

    @Test
    public void testLevelStatus_EqualityWithPlayerSTOPWith2121() {
        System.out.println("Test : equality with Player score 21 and bank 21 with playerSTOP");
        LevelStatus levelStatus = LevelStatus.PLAYERSTOP;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.TEN);
        Card c3 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.addCardToHand(c2);
        p1.addCardToHand(c1);

        p2.addCardToHand(c2);
        p2.addCardToHand(c1);
        System.out.println("Score : p1: " + p1.getScore() + "   Score : p2: " + p2.getScore());
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.EQUALITY;
        assertEquals(expected, result);
    }

    @Test
    public void testLevelStatus_PlayerHave21AndProgress() {
        System.out.println("Test : testLevelStatus_PlayerHave21AndProgress");
        LevelStatus levelStatus = LevelStatus.IN_PROGRESS;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.TEN);
        Card c3 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.addCardToHand(c2);
        p1.addCardToHand(c1);

        //p2.addCardToHand(c2);
        //p2.addCardToHand(c1);
        System.out.println("Score : p1: " + p1.getScore() + "   Score : p2: " + p2.getScore());
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.IN_PROGRESS;
        assertEquals(expected, result);
    }

        @Test
    public void testLevelStatus_PlayerHave21WithHit() {
        System.out.println("Test : testLevelStatus_PlayerHave21AndAutoStop");
        LevelStatus levelStatus = LevelStatus.IN_PROGRESS;
        Card c1 = new Card(Color.CLUB, Value.ACE);
        Card c2 = new Card(Color.DIAMOND, Value.TEN);
        Card c3 = new Card(Color.DIAMOND, Value.EIGHT);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.addCardToHand(c2);
        p1.addCardToHand(c1);

        //p2.addCardToHand(c2);
        //p2.addCardToHand(c1);
        System.out.println("Score : p1: " + p1.getScore() + "   Score : p2: " + p2.getScore());
        LevelStatus result = checkScore(levelStatus, p1, p2);
        LevelStatus expected = LevelStatus.IN_PROGRESS;
        assertEquals(expected, result);
    }
}