import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {

        int[][] hubo = getHubo(brown + yellow);
        
        for(int i = 0; i < hubo.length; i++){
            int row = hubo[i][0];
            int col = hubo[i][1];
            int x = getTaduri(row, col);
            if(x == brown){
                return new int[]{row, col};
            }
        }
        
        return new int[2];
    }
    static int[][] getHubo(int x){
        List<int[]> yaksu = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(x)+1; i++){
            if(x%i==0){
                yaksu.add(new int[]{x/i, i});            
            }
        }
        int[][] res = new int[yaksu.size()][2];
        for(int i = 0; i < yaksu.size(); i++){
            res[i][0] = yaksu.get(i)[0];
            res[i][1] = yaksu.get(i)[1];
        }
        return res;
    }
    static int getTaduri(int row, int col) {
        return row * 2 + (col-2) * 2;
    }
}