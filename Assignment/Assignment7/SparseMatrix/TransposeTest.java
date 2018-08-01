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
public class TransposeTest {

    Sparse sparse;
    private final int array[][];
    private final int transpose[][];

    /*
     * Initialize the object
     */
    @Before
    public void initializeObject() {
        sparse = new Sparse(array.length, array[0].length);
    }

    /*
     * Parameterized Constructor - initialize the variable
     * @param array - sparse matrix
     * @param transpose - transpose of sparse matrix
     */
    public TransposeTest(int array[][], int transpose[][]) {
        this.array = array;
        this.transpose = transpose;
    }

    /*
     * Collection of Object -  contained the parameterized test case
     * @return Collection Object
     */
    @Parameters
    public static Collection<Object[]> transposeTestCases() {
        int setArray1[][] = {{0, 1, 1}, {0, 3, 2}, {1, 0, 3}, {1, 3, 4}, {2, 3, 5}, {3, 1, 6}};
        int transposeArray1[][] = {{1, 0, 1}, {3, 0, 2}, {0, 1, 3}, {3, 1, 4}, {3, 2, 5}, {1, 3, 6}};

        return Arrays.asList(new Object[][]{{setArray1, transposeArray1},});
    }

    /*
     * Test Case evaluation
     * Check whether actual value is same as expected value
     */
    @Test
    public void transposeTest() {
        assertArrayEquals(sparse.transposeMatrix(array), transpose);
    }
}