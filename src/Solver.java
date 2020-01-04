import javafx.scene.control.Label;

class Solver{

    boolean solve(Label[][] labels) {
        int row = 0, col = 0;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (labels[i][j].getText().equals("")) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
                if(!isEmpty) break;
            }
        if (isEmpty) return true;
        for (int i = 1; i <= 9; i++) {
            if (isValid(labels, i, row, col)) {
                labels[row][col].setText(String.valueOf(i));
                if (solve(labels)) return true;
                labels[row][col].setText("");
            }
        }
        return false;
    }

    private boolean isValid(Label[][] labels, int num, int row, int col) {
        for (int i = 0; i < 9; i++)
            if (labels[row][i].getText().equals(String.valueOf(num))) return false;

        for (int i = 0; i < 9; i++)
            if (labels[i][col].getText().equals(String.valueOf(num))) return false;

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++)
            for (int j = boxCol; j < boxCol + 3; j++)
                if (labels[i][j].getText().equals(String.valueOf(num)))
                    return false;
        return true;
    }
}
