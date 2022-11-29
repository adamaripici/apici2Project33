import java.io.Serializable;
import java.util.ArrayList;

public class CFourInfo implements Serializable {
    public static class PlayerData implements Serializable {
        private String p1Plays;
        private String p2Plays;
        private Boolean have2players;
    }
}