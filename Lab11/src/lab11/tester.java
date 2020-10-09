package lab11;

public class tester extends PathFinder{
	
	public static void main(String[] args)
	{
		solveMaze("tinyMaze.txt","AtinyMazeSol3.txt");
		solveMaze("bigMaze.txt","AbigMazeSol3.txt");
		solveMaze("classic.txt","AclassicSol3.txt");
		solveMaze("demoMaze.txt","AdemoMazeSol3.txt");
		solveMaze("mediumMaze.txt","AmediumMazeSol3.txt");
		solveMaze("randomMaze.txt","ArandomMazeSol3.txt");
		solveMaze("straight.txt","AstraightSol3.txt");
		solveMaze("tinyOpen.txt","AtinyOpenSol3.txt");
		solveMaze("turn.txt","AturnSol3.txt");
		solveMaze("tinyMaze.txt","AtinyMazeSol3.txt");
		solveMaze("unsolvable.txt","AunsolvableSol3.txt");
	}

}
