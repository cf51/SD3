public class Hanoi {
	/*
	 * Part4: Tower of Hanoi
	 */

	private Stack moves;
	private Stack[] towers = new Stack[3];
	private int numRings;
	
	public Hanoi(int numDisks) {
		moves = new Stack();
		for (int i = 0; i < 3; i++) {
			towers[i] = new Stack(numDisks);
		}
		this.numRings= numDisks;
		for (int i = 0; i < numRings; i++) {
			towers[0].push(new Disk());
		}
	}
		
	/*
	 * Part 2A: update 'towers' and add (push) a move to 'moves'
	 */
	
	public void moveOneRing(int from, int to){
		
		
		//Moving one ring by pushing to Tower C, by popping from tower A 
		towers[to].push(towers[from].pop());
	
				//Recording the movement by creating a new instance of move to record it, (FROM tower A TO tower C)
				moves.push(new Move(from, to)); 
		}
		
		
		
	
	
	/*
	 * Part 2B: recursive calls to play the Hanoi game
	 * 
	 * Hint: use recursive calls to both 'movePile' and also to 'moveOneRing'
	 */
	
	public void movePile(int n,int from,int to,int via){
		
		//Using recursion to move the rings until the game has finished 
		
		// If there is only 1 left in the stack then it moves that ring, From A to C 
		if (n == 1) {
			moveOneRing(from, to);
		}
		
		//If there is more than ring left then it moves to this else statement which uses recursion 
		else {
		
		//moving from stack Tower A to C, via tower B 
		movePile(n-1, from , via, to); 
		
		//Moves one ring from tower C, so there there is no over lap and the largest ring can be taken from tower A
		//As you cant have a larger ring landing on top of a smaller ring 
		
		moveOneRing(from, to);
		
		//Then finish by moving B to C then moving the smallest one from A 
		movePile(n-1, via , to , from); 
		}
		
		
	}
	
	public Stack getMoves() {
		return replayMoves();
	}
	
	public Stack[] getTowers() {
		return towers;
	}

	public void playHanoiMoves() {
		movePile(numRings,0,1,2);
	}
	
	private Stack replayMoves() {
		Stack copy = (Stack) moves.clone();
		Stack newStack = new Stack(copy.size());
		while (!copy.isEmpty()) {
			newStack.push(copy.pop());
		}
		return newStack;
	}
}

class Move {
	private int from;
	private int to;
	public Move(int from, int to) {
		this.from=from;
		this.to=to;
	}
	public int getFrom() {
		return from;
	}
	public int getTo() {
		return to;
	}
}

class Disk {
	public Disk() {}
}
