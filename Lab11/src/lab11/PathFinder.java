package lab11;

import java.io.*;
import java.util.*;


public class PathFinder {
	public static Scanner input;
	public static Node[][] nodes;
	public static int R;
	public static int C;
	public static String output;
	

	public static void Adjacent() 
	{
		for(int i = 0; i < nodes.length; i++) 
		{
			for(int j = 0; j < nodes[i].length; j++) 
			{
				

				if(i == 0 && j == 0) 
				{
					nodes[i][j].adjacent.add(nodes[i+1][j]); // top left
					nodes[i][j].adjacent.add(nodes[i][j+1]);
				} 
				else if(i == 0 && j == nodes[i].length - 1) 
				{ // bottom left
					nodes[i][j].adjacent.add(nodes[i][j-1]);
					nodes[i][j].adjacent.add(nodes[i+1][j]);
				} 
				else if(i == nodes.length - 1 && j == 0) 
				{ // top right
					nodes[i][j].adjacent.add(nodes[i-1][j]);
					nodes[i][j].adjacent.add(nodes[i][j+1]);
				} 
				else if(i == nodes.length - 1 && j == nodes[i].length - 1) 
				{ // bottom right
					nodes[i][j].adjacent.add(nodes[i-1][j]);
					nodes[i][j].adjacent.add(nodes[i][j-1]);
				} 
				else if(i == 0) 
				{
					nodes[i][j].adjacent.add(nodes[i+1][j]);
					nodes[i][j].adjacent.add(nodes[i][j-1]);
					nodes[i][j].adjacent.add(nodes[i][j+1]);
				} 
				else if(j == 0) 
				{
					nodes[i][j].adjacent.add(nodes[i-1][j]);
					nodes[i][j].adjacent.add(nodes[i+1][j]);
					nodes[i][j].adjacent.add(nodes[i][j+1]);
				} 
				else if(j == nodes[i].length - 1) 
				{
					nodes[i][j].adjacent.add(nodes[i-1][j]);
					nodes[i][j].adjacent.add(nodes[i+1][j]);
					nodes[i][j].adjacent.add(nodes[i][j-1]);
				} 
				else if(i == nodes.length - 1) 
				{
					nodes[i][j].adjacent.add(nodes[i-1][j]);
					nodes[i][j].adjacent.add(nodes[i][j-1]);
					nodes[i][j].adjacent.add(nodes[i][j+1]);
				} 
				else 
				{
					nodes[i][j].adjacent.add(nodes[i-1][j]); // left
					nodes[i][j].adjacent.add(nodes[i+1][j]); // right
					nodes[i][j].adjacent.add(nodes[i][j-1]); // top 
					nodes[i][j].adjacent.add(nodes[i][j+1]); // bottom
				}
			}
		}
	}
	
	
	public static void solveMaze(String inputFile, String outputFile) 
	{
		fileReader(inputFile);
		printFile();
		Adjacent();
		renameL();
		printFile();
		try {
			fileMaker(outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static void fileReader(String inputFile) 
	{
		BufferedReader input = null;

		try 
		{
			input = new BufferedReader(new FileReader(inputFile));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] dimensions = null;
		try 
		{
			dimensions = input.readLine().split(" ");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);
		

		nodes = new Node[height][width];
		String currentLine;
		R = -1;
		C = -1; 
		int row = 0;
		try {
			while ((currentLine = input.readLine()) != null) 
			{
				for (int col = 0; col < width; col++)
				{
					char currentChar = currentLine.charAt(col);
					nodes[row][col] = new Node(row, col, currentChar);
					if (currentChar == 'S')
					{
						R = row;
						C = col;
					}
				}
				row++;
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printFile() 
	{
		for(int i = 0; i < nodes.length; i++) 
		{
			for(int j = 0; j < nodes[i].length; j++) 
			{
				System.out.print(nodes[i][j].mazeChar);
			}
			System.out.println();
		}
	}
	

	public static void renameL () 
	{
		Queue<Node> Q = new LinkedList<Node>();
		Node start = nodes[R][C];
		Node current = null;
		Q.add(start);
		start.beenVisited = true;
		

		while(!(Q.isEmpty())) 
		{
			 current = Q.remove();
					if(current.mazeChar == 'G') 
					{
						break;
					}
			for(Node next : current.adjacent)
				if(!next.beenVisited)
				{
					if(!next.isWall) 
					{
						next.beenVisited = true;
						next.parent = current;
						Q.add(next);
				}
			}
		}
		if(current.mazeChar == 'G') {
			current = current.parent;
			while(current.mazeChar != 'S') {
				current.mazeChar = '.';
				current = current.parent;
			}
		}
	}
	

	public static void fileMaker (String outputFile) throws IOException {
		String solution = (nodes.length ) + " " + (nodes[0].length ) + '\n';
		

		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[i].length; j++) {
				solution += nodes[i][j].mazeChar;
			}
			solution += '\n';
		}
		FileWriter tW = new FileWriter(outputFile);
		PrintWriter canon = new PrintWriter(tW);
		canon.print(solution);
		canon.close();
	}
}