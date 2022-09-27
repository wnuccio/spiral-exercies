import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private final String[][] chars;
    private final int maxRowIndex;
    private final int minColIndex;
    private final int maxColIndex;

    public Matrix(String[][] chars) {
        this.chars = chars;
        maxRowIndex = chars.length - 1;
        minColIndex = 0;
        maxColIndex = chars[0].length -1;
    }

    private String diagonal(int rowIndex, int colIndex) {
        String result = "";
        boolean endOfDiagonal = isEndOfDiagonal(rowIndex, colIndex);
        while (! endOfDiagonal) {
            result += chars[rowIndex][colIndex];
            rowIndex++;
            colIndex--;
            endOfDiagonal = isEndOfDiagonal(rowIndex, colIndex);
        }

        return result;
    }

    private boolean isEndOfDiagonal(int rowIndex, int colIndex) {
        return rowIndex > maxRowIndex || colIndex < minColIndex;
    }

    public List<String> diagonals() {
        List<String> result = new ArrayList<>();

        for (int col=0; col <= maxColIndex; col++) {
            result.add(diagonal(0, col));
        }

        for (int row=1; row <= maxRowIndex; row++) {
            result.add(diagonal(row, chars[0].length-1));
        }

        return result;
    }
}
