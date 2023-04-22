class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        if(k % 2 == 0){
            for(int i = 0; i< arr.length; i++){
                arr[i] += k ;
            }
        }else{ // k가 홀수라면, arr 모든 원소에 k곱하기
            for(int i = 0; i< arr.length; i++){
                arr[i] *= k ;
            }
        }
        return arr;
    }
}