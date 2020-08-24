package World.State;

import BESA.Kernell.Agent.StateBESA;
import Model.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class WorldState extends StateBESA{
    
    private static final Logger log = Logger.getLogger("EjemploBESA");

    private Map map;
    private List<String> botsAlias;
  
    public WorldState(int size, int numOfDust) {
        map = new Map(size, numOfDust);
        botsAlias = new ArrayList<>();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<String> getBotsAlias() {
        return botsAlias;
    }

    public void setBotsAlias(List<String> botsAlias) {
        this.botsAlias = botsAlias;
    }

    public void clean(String alias) {
        map.clean(alias);
    }

    public void move(String alias, int x, int y) {
        map.move(alias,x,y);
        String move = alias + " move to: " + x + ", " + y;
        log.log(Level.INFO, move);
    }
}
