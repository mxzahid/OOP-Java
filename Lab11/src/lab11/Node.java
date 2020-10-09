package lab11;

import java.util.LinkedList;

public class Node 
{
	    

	    public int column;
	    public int rows;
	    public char mazeChar;
	    public boolean beenVisited;
	    public boolean isWall;
	    public Node parent;
		public LinkedList<Node> adjacent = new LinkedList<Node>();
		

	    

	    public Node(int rows, int column, char mazeChar) {
	        this.rows = rows;
	        this.column = column;
	        this.mazeChar = mazeChar;
	        if(mazeChar == 'X') {
	        	isWall = true;
	        } else {
	        	isWall = false;
	        }     
	        beenVisited = false;
	        parent = null;
	    }
	

}