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
    private final int array1[][];
    private final int array2[][];
    private final int result[][];

    /*
     * Initialize the object
     */
    @Before
    public void initializeObject() {
        sparse = new Sparse(array1.length, array2[0].length);

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
        int result[][] = {{0, 2, 6}, {1, 0, 9}, {1, 3, 12}, {1, 2, 4}, {2, 2, 5}, {3, 0, 36}, {3, 3, 30}};

        return Arrays.asList(new Object[][]{{setArray1, setArray2, result},});
    }

    /*
     * Test Case evaluation
     * Check whether actual value is same as expected value
     */
    @Test
    public void multiplicationTest() {
        assertArrayEquals(sparse.multiplyMatrices(array1, array2), result);
    }
}