/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import sparsematrix.Sparse;

@RunWith(Parameterized.class)
public class MultiplicationTest {

    Sparse sparse;
    private int array1[][];
    private int array2[][];
    private int result[][];

    /*
	 * Initialize the object
     */
    @Before
    public void initializeObject() {
        sparse = new Sparse(array1.length, array1[0].length);
    }

    /*
	 * Parameterized Constructor - initialize the variable
	 * @param array - sparse matrix
	 * @param transpose - transpose of sparse matrix
     */
    public MultiplicationTest(int array1[][], int array2[][], int result[][]) {
        this.array1 = array1;
        this.array2 = array2;
        this.result = result;
    }

    /*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
     */
    @Parameters
    public static Collection<Object[]> multiplicationTesttCases() {
        int setArray1[][] = {{0, 1, 1}, {0, 3, 2}, {1, 0, 3}, {1, 3, 4}, {2, 3, 5}, {3, 2, 6}};
        int setArray2[][] = {{0, 0, 3}, {0, 3, 4}, {1, 2, 4}, {2, 0, 6}, {2, 3, 5}, {3, 2, 1}};
        int result[][] = {{0, 0, 6, 0}, {9, 0, 4, 12}, {0, 0, 5, 0}, {36, 0, 0, 30}};

        return Arrays.asList(new Object[][]{{setArray1, setArray2, result},});
    }

    /*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
     */
    @Test
    public void multiplicationTest() {
        assertArrayEquals(sparse.multiplyMatrices(array1,array2), result);
    }
}
