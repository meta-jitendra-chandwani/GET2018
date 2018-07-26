package Polynomial;

public interface PolyInterface {
	float evaluate(float value);
	int degree();
	double[] additionPoly(Poly p1, Poly p2);
	double[] multiplicationPoly(Poly p1, Poly p2);
}
