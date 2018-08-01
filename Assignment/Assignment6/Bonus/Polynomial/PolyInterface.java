package Polynomial;

import java.util.List;

public interface PolyInterface {
	float evaluate(float value,List<Double> coeff);
	int degree();
	double[] additionPoly(Polynomial p1, Polynomial p2);
	double[] multiplicationPoly(Polynomial p1, Polynomial p2);
}
