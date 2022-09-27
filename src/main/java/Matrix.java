import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private final String[][] chars;
    private final int maxRowIndex;
    private final int minColIndex;

    public Matrix(String[][] chars) {
        this.chars = chars;
        maxRowIndex = chars.length - 1;
        minColIndex = 0;
    }

    // rowIndex [0, char[0].length()-1
    private String diagonal(int rowIndex, int colIndex) {
        String result = "";
        boolean endOfDiagonal = rowIndex > maxRowIndex || colIndex < minColIndex;
        while (! endOfDiagonal) {
            result += chars[rowIndex][colIndex];
            rowIndex++;
            colIndex--;
            endOfDiagonal = rowIndex > maxRowIndex || colIndex < minColIndex;
        }

        return result;
    }

    public List<String> diagonals() {
        List<String> result = new ArrayList<>();

        for (int col=0; col<chars[0].length; col++) {
            result.add(diagonal(0, col ));
        }

        for (int row=1; row < chars.length; row++) {
            result.add(diagonal(row, chars[0].length-1));
        }

        return result;
    }
}
