class Solution {
    static int N;
    public int solution(int[] number) {
        int answer = 0;
        N = number.length;
        for(int i= 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    int sum = number[i] + number[j] + number[k];
                    if(sum == 0){
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
}