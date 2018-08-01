/*
 * Class LcfHcf consist two function
 */
public class LcmHcf {
	 
	/*
	  * To evaluate hcf of two number
	  * @param number 1
	  * @param number 2
	  * return hcf of number 1 and number 2
	  */
	int hcf(int n1, int n2)
	    {
	        if (n2 != 0)
	            return hcf(n2, n1 % n2);//temp=b,b=a%b,a=b
	        else
	            return n1;
	    }
	
	 /*
	  * To evaluate lcm of two number
	  * @param number 1
	  * @param number 2
	  * return lcm of number 1 and number 2
	  */
	int lcm(int x,int y){		
		return (x*y)/hcf(x,y);
	}
}