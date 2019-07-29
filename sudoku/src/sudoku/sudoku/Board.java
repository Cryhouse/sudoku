package sudoku;

public class Board {
	Integer[] array;
	public Board() {
		this.array = new Integer[81];
	}
	public Board(Integer[] array){
		this.array = array;
	}
	public int get(int index) {
		return array[index];
	}
	public int get(int xpos, int ypos){
		return get(xpos + ypos*9);
	}
	public void put(int index, int value) {
		array[index] = value;
	}
	
	private boolean solve(int index, int startvalue) {
		for (int i = startvalue + 1; i < 10; i++) {
			// Ifall ingen siffra funkar
			if (checkCol(index,i) == false || checkRow(index,i) == false || checkSquare(index,i) == false) {

				if (index == 0) return false;
				else if (xpos == 0) {

					return solve(8,ypos-1,get(8,ypos - 1));
				}
				else return solve(xpos-1,ypos,get(xpos-1,ypos));
			}
		}
		for(int i = startvalue + 1; i < 10; i++){
			if (checkCol(xpos,ypos,i) != -1 && checkRow(xpos,ypos,i) != -1 && checkSquare(xpos,ypos,i) == -1){
				put(xpos,ypos,i);
				return true;
			}

		}

		
	}

	// Returnerar
	private boolean checkCol(int index, int number) {
		int xpos = (index +1) %  9;
		for (int i = 0; i < 9; i++) {
			if (get(index) != number) return false;
		}
		return true;
	}
	// REturnerar false ifall number finns i raden
	private boolean checkRow(int index, int number) {
		for (int i = 0; i < 9; i++) {
			if (get(index) == number) return false;
		}
		return true;
	}
	// returnerar en int som funkar i squaren ifall det inte finns någon som funkar returneras -1.
	private int checkSquare(int index, int number) {
		// 9 if-satser, en för varje område
		int xpos = (index + 1) % 9;
		int ypos = (int) Math.floor((double)(index + 1) / (double)9);
		if (xpos < 3 && ypos < 3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return false;
				}
			}
			return true;
		}
		else if(xpos < 3 && ypos >= 3 && ypos <6) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0;j < 3; j++) {
					if(get(i, j)== number) return false;
				}
			}
			return true;
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
