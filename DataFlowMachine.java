import java.util.*;


import java.io.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * This class evaluates given expressions in reverse polish notation.
 * The expressions must be written in a text file.
 * 
 * 
 * @author mariol96
 *
 */
public class DataFlowMachine { 
	
	StringTokenizer tokenizedString = null;
	LinkedList<Tree> computableTrees = new LinkedList<Tree>();
	Tree equationTree = null;
	long startTime;
	
	public DataFlowMachine (String fileName) {
		startTime = System.currentTimeMillis();
		if (fileName == null)
			throw new NullPointerException ("Input error: type a valid file name");
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String fileToString = "";
			fileToString = br.readLine();
			br.close();
			fr.close();
			tokenizedString = new StringTokenizer(fileToString);
		}
		catch (FileNotFoundException e){
			System.err.println("File " + fileName + " not found");
		}
		catch (IOException e){
			System.err.println("The file " + fileName + " can't be used right now");
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void solverTest () {
		equationTree = new Tree (null, tokenizedString.nextToken());
		ForkJoinPool.commonPool().invoke(new Task());
		
		System.out.println("The result is: " + equationTree.operand);
	}
	
	/**
	 * This class implements a Binary Tree, the most efficient data structure for evaluating reverse polish notation expressions.
	 * 
	 * 
	 * @author Mario
	 *
	 */
	private class Tree{
		
		private Tree father = null;
		private Tree leftSon = null;
		private Tree rightSon = null;
		private double operand = 0.0d;
		private String operator = "";
		
		public Tree (double value) {
			this.operand = value;
		}
		
		public Tree () {
		}
		
		public Tree (Tree subTreeFather, String operator) {
			this.operand = Double.NaN;
			this.father = subTreeFather;
			this.operator = operator;
			String token = "";
			try {
				token = tokenizedString.nextToken();
				this.leftSon = new Tree (Double.parseDouble(token));
			} catch(NumberFormatException e) {
				this.leftSon = new Tree (this, token);
			}
			try {
				token = tokenizedString.nextToken();
				this.rightSon = new Tree (Double.parseDouble(token));
				if (this.leftSon.operand != Double.NaN) {
					computableTrees.addFirst(this);
					
				}
			} catch(NumberFormatException e) {
				this.rightSon = new Tree (this, token);
			} catch (NoSuchElementException e) {
				System.err.println("Input error: type a valid input");
			}
		}		
	}
	
	private class Task extends RecursiveAction {
		private Tree subTree;

		public Task(Tree subTree) {
			this.subTree = subTree;
		}
		
		public Task() {	
		}
		
		public void expressionSolver(Tree tree) {
			switch(tree.operator) {
				case "+": tree.operand = tree.leftSon.operand + tree.rightSon.operand;
				break;
				case "-": tree.operand = tree.leftSon.operand - tree.rightSon.operand;
				break;
				case "*": tree.operand = tree.leftSon.operand * tree.rightSon.operand;
				break;
				case "/": tree.operand = tree.leftSon.operand / tree.rightSon.operand;
				break;
				default: throw new IllegalArgumentException ("Input error: the current operator is not valid");	
			}
			
			if (tree.father != null && tree.father.leftSon.operand != Double.NaN && tree.father.rightSon.operand != Double.NaN) {
				expressionSolver(tree.father);
			}
		}
		
		@Override
		protected void compute() {
			for (Tree t: computableTrees){
				Task task = new Task(t);
				task.expressionSolver(task.subTree);
				task.fork();
			}
			
			
			
		}
		
			
		}
	
	
	
	public static void main (String [] args) {
		long start = System.currentTimeMillis();
		System.out.println("Using " + ForkJoinPool.getCommonPoolParallelism() + " threads");
		DataFlowMachine df = new DataFlowMachine("expression.txt");
		df.solverTest();
		System.out.println("Evaluating the expression took " + (System.currentTimeMillis() - start) + " ms");
	}
}