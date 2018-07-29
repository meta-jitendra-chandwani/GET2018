package Polynomial;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Poly - Operation on polynomial
 * evaluate value of polynomial
 * Degree of polynomial
 * Addition of two polynomials
 * Multiplication of two polynomials 
 */
public class Polynomial implements PolyInterface {

    private final int order;
    private List<Double> coeff=new ArrayList<>();

    /*
     * Parameterized constructor -  which assign value to coefficient and order.
     * @param coefficient array of polynomial
     */
    Polynomial(List<Double> coeff) {
        this.coeff = coeff;
        this.order = coeff.size() - 1;
    }

    /*
     * Add member in polynomial
     * @param coeff - List of Coefficient
     * @param position - Position at which member will added
     * @param value - value of member
     */
    void addPolynomial(List<Double> coeff, int position, double value) {
        coeff.add(position, value);
    }

    /*
     * Remove member in polynomial
     * @param coeff - List of Coefficient
     * @param position - Position at which member will removed
     */
    void removePolynomial(List<Double> coeff, int position, double value) {
        coeff.remove(position);
    }

    /*
     * (non-Javadoc)
     * @see Polynomial.PolyInterface#evaluate(float)
     * evaluate the value of polynomial
     * @param value of variable
     * @return total sum of polynomial
     */
    @Override
    public float evaluate(float value,List<Double> coeff) {
        float sum = 0;
        int order=coeff.size() - 1;
        System.out.println("Order : "+ order);
        for (int i = 0; i <= order; i++) {
            sum += coeff.get(i) * Math.pow(value, order - i);
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
    public double[] additionPoly(Polynomial p1, Polynomial p2) {
        int length;
        if (p1.coeff.size() > p2.coeff.size()) {
            length = p1.coeff.size();
        } else {
            length = p2.coeff.size();
        }
        double result[] = new double[length];
        for (int i = 0; i < p1.coeff.size(); i++) {
            result[i] = p1.coeff.get(i) + p2.coeff.get(i);
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * @see Polynomial.PolyInterface#multiplicationPoly(Polynomial.Poly, Polynomial.Poly)
     * Multiplication of two polynomials
     * @param polynomial 1
     * @param polynomial 2
     * @return multiplication of two polynomial	 
     */
    @Override
    public double[] multiplicationPoly(Polynomial p1, Polynomial p2) {
        int totalLength = p1.coeff.size() + p2.coeff.size() - 1;
        double[] result = new double[totalLength];
        for (int i = 0; i < p1.coeff.size(); i++) {
            for (int j = 0; j < p2.coeff.size(); j++) {
                result[i + j] += p1.coeff.get(i) * p2.coeff.get(j);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        System.out.println("Jitendra");
//        List<Double> coeff = new ArrayList<>();
//        coeff.add(3.0);
//        coeff.add(1.0);
//        coeff.add(2.0);
//        coeff.add(4.0);
//        Polynomial polynomial = new Polynomial(coeff);
//        Polynomial polynomial1 = new Polynomial(coeff);
//        double[] result = polynomial.additionPoly(polynomial, polynomial1);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print("Value : " + result[i] + "\t");
//        }
//        polynomial.addPolynomial(coeff, 1, 2);
//        for (int i = 0; i < coeff.size(); i++) {
//            System.out.print("\n" + coeff.get(i) + "\t");
//        }
//        System.out.println(polynomial.evaluate(4, coeff));
//    }
}