import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {// 스도쿠

    public static void main(String[] args) throws IOException {
        int[][] board = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        back(0, board);
        printBoard(board);
    }

    private static boolean back(int depth, int[][] board) {// 변화하는 상태를 담음
        // 내가 선택할 수 있는 것  1 - 9
        // 해당 선택에 따라 체크해야 할 조건
        // 행, 열, 3x3 에 각각 1-9 수가 하나만 들어가는지 여부
        if (depth == 81) {
            //printBoard(board);
            return true;
        }
        int r = depth / 9;
        int c = depth % 9;
        if (board[r][c] == 0) { // 숫자를 채워야한다면
            for (int v = 1; v <= 9; v++) { // 1-9사이의 숫자를 선택했을 때 괜찮은지 확인하기
                board[r][c] = v;
                if (isValid(board, r, c)) {
                    //System.out.println("(" + r + " , " + c + ")" + " " + v);
                    if(back(depth + 1, board)){
                        return true;
                    }
                }
                board[r][c] = 0;
            }
        } else { // 숫자를 채울 필요없다면,
            return back(depth + 1, board);
        }
        return false;
    }

    static void printBoard(int[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] board, int row, int column) {
        if (checkBox(board, row, column) && checkRow(board, row) && checkColumn(board, column)) {
            return true;
        }
        return false;
    }

    private static boolean checkRow(int[][] board, int row) {
        boolean[] numbers;
        numbers = new boolean[10];//1-9
        for (int j = 0; j < 9; j++) {
            if(board[row][j]==0){continue;}
            if (numbers[board[row][j]]) {
                return false;
            }
            numbers[board[row][j]] = true;
        }
        return true;
    }

    private static boolean checkColumn(int[][] board, int column) {
        boolean[] numbers;
        numbers = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if(board[i][column]==0){continue;}
            if (numbers[board[i][column]]) {
                return false;
            }
            numbers[board[i][column]] = true;
        }
        return true;
    }

    private static boolean checkBox(int[][] board, int row, int column) {
        boolean[] numbers;
        int sX = row / 3 * 3;
        int sY = column / 3 * 3;
        numbers = new boolean[10];
        for (int i = sX; i < sX + 3; i++) {
            for (int j = sY; j < sY + 3; j++) {
                if(board[i][j]==0){continue;}
                if (numbers[board[i][j]]) {
                    return false;
                }
                numbers[board[i][j]] = true;
            }
        }
        return true;
    }
}
