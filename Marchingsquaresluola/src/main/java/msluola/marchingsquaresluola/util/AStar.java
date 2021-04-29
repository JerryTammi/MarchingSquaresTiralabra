package msluola.marchingsquaresluola.util;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.shape.Line;
import msluola.marchingsquaresluola.luola.Luola;

/**
 * Reitinhaku algoritmi
 */
public class AStar {
    Node alku;
    Node loppu;
    Luola luola;
    ArrayList<Node>cameFrom;
    
    /**
     * 
     * @param alku Lähtöpiste.
     * @param loppu Päätöspiste.
     * @param luola Tarkisteltava luola.
     */    
    public void haku(Node alku, Node loppu, Luola luola) {
        this.alku = alku;
        this.loppu = loppu;
        this.cameFrom = new ArrayList<>();
        this.luola = luola;
        
        boolean[][]visited = new boolean[luola.haeKorkeus()][luola.haeLeveys()];
        
        visited[alku.getY()][alku.getY()] = true;
        alku.setFScore(ennustus(alku));
        alku.setGScore(0);
        
        cameFrom.add(alku);
        
        while(!cameFrom.isEmpty()) {
            Collections.sort(cameFrom);
            Node current = cameFrom.remove(0);
            
            if (current.getY() == loppu.getY() && current.getX() == loppu.getX()) {
                nodeParentPoints(current);
                return;
            }
            int x = current.getX();
            int y = current.getY();
            
            if (x + 1 < luola.haeLeveys()) {
                if (luola.haeTaulukko()[y][x + 1] == 0 && !visited[y][x + 1]) {
                    Node neighbour = new Node(y, x + 1);
                    visited[y][x + 1] = true;
                    int tenativeGScore = current.getGScore() + 1;
                    if (tenativeGScore < neighbour.getGScore()) {
                        neighbour.setParent(current);
                        neighbour.setGScore(tenativeGScore);
                        neighbour.setFScore(neighbour.getGScore() + ennustus(neighbour));
                        cameFrom.add(neighbour);
                    }
                }
            }
            if (x - 1 >= 0) {
                if (luola.haeTaulukko()[y][x - 1] == 0 && !visited[y][x - 1]) {
                    Node neighbour = new Node(y, x - 1);
                    visited[y][x - 1] = true;
                    int tenativeGScore = current.getGScore() + 1;
                    if (tenativeGScore < neighbour.getGScore()) {
                        neighbour.setParent(current);
                        neighbour.setGScore(tenativeGScore);
                        neighbour.setFScore(neighbour.getGScore() + ennustus(neighbour));
                        cameFrom.add(neighbour);
                    }
                }
            }
            if (y + 1 < luola.haeKorkeus()) {
                if (luola.haeTaulukko()[y + 1][x] == 0  && !visited[y + 1][x]) {
                    Node neighbour = new Node(y + 1, x);
                    visited[y + 1][x] = true;
                    int tenativeGScore = current.getGScore() + 1;
                    if (tenativeGScore < neighbour.getGScore()) {
                        neighbour.setParent(current);
                        neighbour.setGScore(tenativeGScore);
                        neighbour.setFScore(neighbour.getGScore() + ennustus(neighbour));
                        cameFrom.add(neighbour);
                    }
                }
            }
            if (y - 1 >= 0) {
                if (luola.haeTaulukko()[y - 1][x] == 0  && !visited[y - 1][x]) {
                    Node neighbour = new Node(y - 1, x);
                    visited[y - 1][x] = true;
                    int tenativeGScore = current.getGScore() + 1;
                    if (tenativeGScore < neighbour.getGScore()) {
                        neighbour.setParent(current);
                        neighbour.setGScore(tenativeGScore);
                        neighbour.setFScore(neighbour.getGScore() + ennustus(neighbour));
                        cameFrom.add(neighbour);
                    }
                }
            }
        }
    }
    
    /**
     * Tarkisteltavan solmun ja loppusolmun etäisyys linnuntietä pitkin.
     * @param n Tarkisteltava solmu.
     * @return Palauttaa ennustuksen arvon.
     */
    public int ennustus(Node n) {
        int luku = 0;
        luku += Math.abs(n.getY() - loppu.getY());
        luku += Math.abs(n.getX() - loppu.getX());
        return luku;
    }
    
    /**
     * Muodostaa reitin viimeisestä solmusta ensimmäiseen, kun a* on löytänyt polun.
     * @param n Tarkisteltava node.
     */
    public void nodeParentPoints(Node n) {
        if (n.getParent() == null) {
            return;
        }
        Line l = new Line(n.getX() * luola.haeVali(), n.getY() * luola.haeVali(), n.getParent().getX() * luola.haeVali(), n.getParent().getY() * luola.haeVali());
        luola.haePane().getChildren().add(l);
        nodeParentPoints(n.getParent());
    }
}
