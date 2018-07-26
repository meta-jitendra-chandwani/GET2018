package Polynomial;

import java.util.Scanner;

/*
 * Class Poly - Operation on polynomial
 * evaluate value of polynomial
 * Degree of polynomial
 * Addition of two polynomials
 * Multiplication of two polynomials 
 */
public final class Poly implements PolyInterface {
	int order;
	static Scanner input = new Scanner(System.in);
	double[] coeff;

	/*
	 * Parameterized constructor -  which assign value to coefficient and order.
	 * @param coefficient array of polynomial
	 */
	Poly(double coeff[]) {
		this.coeff = coeff;
		this.order = coeff.length-1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Polynomial.PolyInterface#evaluate(float)
	 * evaluate the value of polynomial
	 * @param value of variable
	 * @return total sum of polynomial
	 */
	@Override
	public float evaluate(float value) {
		float sum = 0;
		for (int i = 0; i <= order; i++) {
			sum += coeff[i] * Math.pow(value, order - i);
		}
		return sum;
	}

	/*
	 * (non-Javadoc)
	 * @see Polynomial.PolyInterface#degree()
	 * Evaluate the degree of polynomial
	 * @return Degree or Order or polynomial
	 */
	@Override
	public int degree() {
		return (order);
	}

	/*
	 * (non-Javadoc)
	 * @see Polynomial.PolyInterface#additionPoly(Polynomial.Poly, Polynomial.Poly)
	 * Addition of two polynomials
	 * @param polynomial 1
	 * @param polynomial 2
	 * @return sum of two polynomial
	 */
	@Override
	public double[] additionPoly(Poly p1, Poly p2) {
		int length;
		if (p1.coeff.length > p2.coeff.length) {
			length = p1.coeff.length;
		} else {
			length = p2.coeff.length;
		}
		double result[] = new double[length];
		for (int i = 0; i < p1.coeff.length; i++) {
			result[i] = p1.coeff[i] + p2.coeff[i];
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see Polynomial.PolyInterface#multiplicationPoly(Polynomial.Poly, Polynomial.Poly)
	 * Multiplication of two polynomials
	 * @param polynomial 1
	 * @param polynomial 2
	 * @return multiplication of two polynomial	 */
	@Override
	public double[] multiplicationPoly(Poly p1, Poly p2) {
		int totalLength = p1.coeff.length + p2.coeff.length - 1;
		double[] result = new double[totalLength];
		for (int i = 0; i < p1.coeff.length; i++)
			for (int j = 0; j < p2.coeff.length; j++) {
				result[i + j] += p1.coeff[i] * p2.coeff[j];
			}
		return result;
	}
}