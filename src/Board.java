public class Board {
    // Array är en vektor som vi hela tiden manipulerar för att till slut hitta en lösning
    private Integer[] array;
    // Starting array är en vektor som förblir den samma hela tiden så vi kan hålla koll på vilka värden som inte får rubbas.
    private Integer[] starting_array;

    public Board() {
        this.array = new Integer[81];
        System.arraycopy(starting_array, 0, array, 0, 81);
    }

    public Board(Integer[] array) {
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }

    public int get(int xpos, int ypos) {
        return get(xpos + ypos * 9);
    }

    public void put(int index, int value) {
        array[index] = value;
    }

    public boolean solve(int index, int startvalue) {
        // Ifall siffran redan är ifylld
        if (starting_array[index] != 0){
            return solve(index -1,array[index-1]);
        }
        // Ifall ingen siffra funkar
        for (int i = startvalue + 1; i < 10; i++) {

            if (!checkCol(index, i)  || !checkRow(index, i) || !checkSquare(index, i)) {
                if (index == 0) return false;
                else return solve(index - 1, array[index - 1] + 1);
            }
        }
        // Ifall det finns en siffra som funkar
        for (int i = startvalue + 1; i < 10; i++) {
            if (checkCol(index, i) && checkRow(index, i) && checkSquare(index, i)) {
                put(index, i);
                if (index == 80) return true;
                return solve(index + 1, 0);
            }

        }
    return true;

    }

    // Returnerar false ifall inget nummer funkar
    private boolean checkCol(int index, int number) {
        int xpos = index % 8;
        int ypos = (int) Math.floor((index + 1) / 9);
        for (int i = 0; i < 9; i++) {
            if (get(xpos, i) != number) return false;
        }
        return true;
    }

    // Returnerar false ifall number finns i raden
    private boolean checkRow(int index, int number) {
        int xpos = index % 8;
        int ypos = (int) Math.floor((index + 1) / 9);
        for (int i = 0; i < 9; i++) {
            if (get(i, ypos) == number) return false;
        }
        return true;
    }

    // True ifall siffran är ok i 3*3 - rutan
    private boolean checkSquare(int index, int number) {
        // 9 if-satser, en för varje område
        int xpos = index % 8;
        int ypos = (int) Math.floor((index + 1) / 9);
        if (xpos < 3 && ypos < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos < 3 &&  ypos < 6) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos < 3 && ypos < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos >= 3 && xpos < 6 && ypos < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos >= 3 && xpos < 6 && ypos < 6) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos >= 3 && xpos < 6 && ypos < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos >= 6 && ypos < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else if (xpos >= 6 && ypos < 6) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (get(i, j) == number) return false;
                }
            }
            return true;
        }

    }
}

