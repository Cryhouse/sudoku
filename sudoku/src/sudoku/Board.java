package sudoku;

public class Board {
	Integer[][] array;
	public Board() {
		this.array = new Integer[9][9];
	}
	public Board(Integer[][] array){
		this.array = array;
	}
	public int get(int posx, int posy) {
		return array[posx][posy];
	}
	public void put(int posx, int posy, int value) {
		array[posx][posy] = value;
	}
	
	private boolean solve(int xpos, int ypos) {
		for (int i = 1; i < 10; i++) {
			if (checkCol(xpos,ypos,i) == -1 || checkRow(xpos,ypos,i) == -1 || checkSquare(xpos,ypos,i) == -1) {
				if (xpos == 0 && ypos == 0) return false;
				else if (xpos == 0) return solve(8,ypos-1);
				else if
				
			}
		}
		return true;
		
	}
	
	

	// Returnerar false ifall number finns i kolonnen
	private int checkCol(int xpos,int ypos, int number) {
		
		for (int i = 0; i < 9; i++) {
			if (get(xpos, i) != number) return -1;
		}
		board.put(xpos, ypos, number);
		return number;
	}
	// REturnerar false ifall number finns i raden
	private int checkRow(int xpos, int ypos, int number) {
		for (int i = 0; i < 9; i++) {
			if (get(i, ypos) == number) return -1;
		}
		board.put(xpos, ypos, number);
		return number;
	}
	// returnerar en int som funkar i squaren ifall det inte finns någon som funkar returneras -1.
	private int checkSquare(int xpos, int ypos, int number) {
		// 9 if-satser, en för varje område
		if (xpos < 3 && ypos < 3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos < 3 && ypos >= 3 && ypos <6) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos < 3 && ypos >= 6 && ypos <9) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos >= 3 && xpos < 6 && ypos <3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos >= 3 && xpos < 6 && ypos >= 3 && ypos < 6) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos >= 3 && xpos < 6 && ypos >= 6) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos >= 6 && ypos < 3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else if(xpos >= 6 && ypos >= 3 && ypos < 6 ) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return -1;
				}
			}
			return number;
		}
		
	}
}
