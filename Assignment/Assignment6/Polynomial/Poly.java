package Polynomial;

import java.util.Scanner;

public class Poly {
	 static int Polynomial[]=new int[4];
	 static int revPoly[]=new int[4];
	 static Scanner input=new Scanner(System.in);
	float evaluate(float value) {
		float sum=0;
		for(int i=0;i<Polynomial.length;i++){
			sum+=revPoly[i]*Math.pow(value, i);
		}
			return sum;
		
	}
	
	public static void main(String args[]){
		Poly poly=new Poly();
		System.out.println("Enter Poly length : ");
		int l=input.nextInt();
		System.out.println("Enter value : ");
		for(int i=0;i<l;i++){
			Polynomial[i]=input.nextInt();
		}
		
		for(int j=l-1;j>=0;j--){
			revPoly[j]=Polynomial[j];
		}
		System.out.println("Enter X value : ");
		System.out.println(poly.evaluate(input.nextFloat()));
	}
}
