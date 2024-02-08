package g54435.atl.blackjack.model;

/**
 * Enum LevelStatus indicate status of the level.
 * PLAYERSTOP == the player stop hitting cards status
 */
public enum LevelStatus {
    IN_PROGRESS,
    WIN,
    FAIL,
    EQUALITY,
    NONSTARTED,
    PLAYERSTOP;
}
