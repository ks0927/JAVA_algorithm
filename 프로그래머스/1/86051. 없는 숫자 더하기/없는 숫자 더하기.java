class Solution {
    public int solution(int[] numbers) {
        int[] check = new int[10];
        
        for(int i=0; i < numbers.length; i++) {
            check[numbers[i]] = 1;
        }
        
        int sum = 0;
        
        for(int i=0; i < check.length; i++) {
            if(check[i] == 0) sum += i;
        }
        
        return sum;
    }
}