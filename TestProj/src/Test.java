public class Test {
	public static void main(String[] args) {
		isDigitSumPalindrome(56);
		
	}
	    static int isDigitSumPalindrome(int N) {
	        
	        
	        int sum=0;
	        int temp=N;
	        while(temp>0){
	            int d=temp%10;
	            sum+=d;
	            temp=temp/10;
	        }
	        
	        //palindrome
	        int newnum=0;
	        int t=sum;
	        while(t>0){
	            int d=t%10;
	            newnum=10*d+newnum;
	            t=t/10;
	        }
	        if(newnum==sum){
	            return 1;
	        }
	        else 
	        return 0;
	    }
	
}
