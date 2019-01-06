
import java.util.Random;

public class MinesweeperBL {

    private FieldValue[][] field;

    public MinesweeperBL(int rowColSize, int amountBombs) {
        field = new FieldValue[rowColSize][rowColSize];
        initField(amountBombs);
    }

    private void initField(int amountBombs) {
        Random random = new Random();
        for (int i = 0; i < field.length; i++) {
            for (int x = 0; x < field.length; x++) {
                field[i][x] = FieldValue.EMPTY;
            }
        }
        for (int i = 0; i < amountBombs; i++) {
            int row = random.nextInt(field.length - 1 - 0 + 1) + 0;
            int col = random.nextInt(field.length - 1 - 0 + 1) + 0;
            if (field[row][col] != FieldValue.BOMB) {
                field[row][col] = FieldValue.BOMB;
            }
        }
    }

    public int setField(int row, int col) {
        if (field[row][col] == FieldValue.EMPTY) {
            field[row][col] = FieldValue.OPEN;
            return bombsInVicinity(row, col);
        } else if (field[row][col] == FieldValue.BOMB) {
            return -1;
        }
        else if (field[row][col] == FieldValue.OPEN){
            return bombsInVicinity(row, col);
        }
        return -2;
    }
    
    public FieldValue getStatus(int row, int col){
        return field[row][col];
    }
    
    public boolean flag(int row, int col){
        if(field[row][col] != FieldValue.OPEN){
            return true;
        }
        return false;
    }

    private int bombsInVicinity(int row, int col) {
        int bombs = 0;
        try {
            if (field[row - 1][col] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception ex) {
        }
        try {
            if (field[row - 1][col - 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row - 1][col + 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row][col - 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row][col + 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row + 1][col] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row + 1][col - 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        try {
            if (field[row + 1][col + 1] == FieldValue.BOMB) {
                bombs++;
            }
        } catch (Exception e) {
        }
        return bombs;
    }

}
