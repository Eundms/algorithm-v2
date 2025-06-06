class Solution {
    static int N, M;
    public boolean solution(int[][] key, int[][] lock) { // 크기 M x M, 크기 N x N
        N = lock.length;
        M = key.length;
        // (M-1) + N + (M-1)
        // 0 ~ M-2 + 
        int[][] map = new int[(M-1) * 2  + N][(M-1) * 2  + N];
        for(int i = M - 1; i < M - 1 + N; i++){
            for(int j = M - 1; j < M - 1 + N; j++){
                map[i][j] = lock[i - (M-1)][j - (M-1)];
            }
        }
        for(int w = 0; w < 4; w++) {
            key = rotate(key);
            for (int i = 0; i <= 2 * (M-1) + N - M; i++) {
                for (int j = 0; j <= 2 * (M-1) + N - M; j++) {

                    for(int r = 0; r < M; r++) {
                        for(int c = 0; c < M; c++) {
                            map[i + r][j + c] += key[r][ c];
                        }
                    } 

                    if(isOpen(map)) {
                        return true;
                    }

                    for(int r = 0; r < M; r++) {
                        for(int c = 0; c < M; c++) {
                            map[i + r][j + c] -= key[r][c];
                        }
                    } 
                }
            }
        }
        return false;
    }
    
    static int[][] rotate(int[][] matrix) {
        int M = matrix.length;
        int[][] rotated = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    static boolean isOpen(int[][] map){
        for(int i = M - 1; i < M - 1 + N; i++){
            for(int j = M - 1; j < M - 1 + N; j++){
                if(map[i][j] == 0 || map[i][j] == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}