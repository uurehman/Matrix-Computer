package Matrix;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MatrixAdditionTest.class, matrixInverseTest.class, MatrixMultiplicationTest.class,
		matrixSubtractionTest.class, matrixTransposeTest.class })
public class AllTests {

}
