import java.util.Scanner;

public class StringCompare {
//	String string_one, string_two;
	private static Scanner sc=new Scanner(System.in);
	
	int compare(String string_one,String string_two){
		if(string_one.length()!=string_two.length()){
			System.out.println("Strings are not same, lengths are different!!!");
			return 0;
		}
		
		boolean flg=true;
		for(int i=0; i<string_one.length();i++){
			if(string_one.charAt(i)!=string_two.charAt(i)){
				flg=false;
				break;
			}
		}
		
		if(flg){
			return 1;
		}
		else{
			return 0;
		}
	
	}
	
	String changeCase(String string){
		String updated_String=null;
		for (int i = 0; i< string.length(); i++)
        {
            char aChar = string.charAt(i);
            if (65 <= aChar && aChar<=90)
            {
            	updated_String+= (char)( (aChar + 32) ); 
            }
            else if (97 <= aChar && aChar<=122)
            {
            	updated_String+= (char)( (aChar - 32) ); 
            }
         }
     
		return updated_String;
	}
	
	String reverse(String string){
		String reverse_string=null;
		int j=0;
		for(int i=string.length()-1;i<=0;i--){
			reverse_string=reverse_string+string.charAt(i);
			j++;
		}
		
		return reverse_string;
	}
	
	String longestWord(String string){
		String longest_word=null;
		String array_string[]=string.split(" ");
		System.out.print(array_string[0]);
		return longest_word;
	}
	public static void main(String arg[]) {
		String string_one=sc.next();
//		String string_two=sc.next();
		StringCompare string=new StringCompare();
//		int result=string.compare(string_one,string_two);
//		String reverse_string=string.reverse(string_one);
		string.longestWord(string_one);
		
	}
}
