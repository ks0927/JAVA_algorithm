import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< T ; i++) {
            Deque<Character> stack = new LinkedList<>();
            
            String str = br.readLine();
            
            stack.push(str.charAt(0));
            
            for(int j=1; j < str.length() ;j++) {
                
                Character cur = str.charAt(j);
                
                if(stack.peek() == null) {
                    stack.add(cur);
                }else if(stack.peek()== '(') {
                    if(cur==')'){
                        stack.poll();
                    }
                    else{
                        stack.push(cur);
                    }
                }else{
                    stack.push(cur);
                }
            }

            
            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}