class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(lengthCheck(wallet,bill)) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    public static boolean lengthCheck(int[] wallet, int[] bill) {
        int wallet_S = (wallet[0] < wallet[1]) ? wallet[0] : wallet[1];
        int wallet_D = (wallet[0] > wallet[1]) ? wallet[0] : wallet[1];
        
        int bill_S = (bill[0] < bill[1]) ? bill[0] : bill[1];
        int bill_D = (bill[0] > bill[1]) ? bill[0] : bill[1];
        
        if(bill_S > wallet_S || bill_D > wallet_D) {
            return true;
        }
        return false;
    }
}