/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msluola.marchingsquaresluola.util;


public class Node implements Comparable<Node> {
    int x;
    int y;
    int fScore;
    int gScore;
    Node parent;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
        fScore = 100000;
        gScore = 100000;
    }
    
   public int getX() {
       return x;
   }
   
   public int getY() {
       return y;
   }
    
    public Node getParent() {
        if (parent == null) {
            return null;
        }
        return parent;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public int getGScore() {
        return gScore;
    }
     
    public void setGScore(int gScore) {
        this.gScore = gScore;
    }
    
    public int getFScore() {
        return fScore;
    }
     
    public void setFScore(int fScore) {
        this.fScore = gScore;
    }
    
    @Override
    public int compareTo(Node node) {
        if (this.fScore == node.fScore) {
            return 0;
        }
        else if (this.fScore > node.fScore) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
