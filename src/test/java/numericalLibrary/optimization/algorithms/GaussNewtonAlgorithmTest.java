package numericalLibrary.optimization.algorithms;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import numericalLibrary.optimization.lossFunctions.LocallyQuadraticLoss;
import numericalLibrary.optimization.lossFunctions.NormSquaredLossFunction;
import numericalLibrary.optimization.stoppingCriteria.IterationThresholdStoppingCriterion;
import numericalLibrary.types.MatrixReal;



/**
 * Implements test methods for {@link GaussNewtonAlgorithm}.
 */
public class GaussNewtonAlgorithmTest
{
    ////////////////////////////////////////////////////////////////
    // TEST METHODS
    ////////////////////////////////////////////////////////////////
    
    /**
     * Checks that {@link GaussNewtonAlgorithm} converges to zero in one iteration when the {@link NormSquaredLossFunction} is used.
     */
    @Test
    public void gaussNewtonOnNormSquaredConvergesInOneIteration()
    {
        LocallyQuadraticLoss loss = new NormSquaredLossFunction( 42 );
        loss.setParameters( MatrixReal.random( 42 , 1 , new Random( 42 ) ) );
        GaussNewtonAlgorithm gna = new GaussNewtonAlgorithm( loss );
        gna.setStoppingCriterion( new IterationThresholdStoppingCriterion( 100 ) );
        gna.initialize();
        gna.step();
        MatrixReal optimizedParameters = loss.getParameters();
        assertTrue( optimizedParameters.equalsApproximately( MatrixReal.zero( 42 , 1 ) , 1.0e-6 ) );
    }
    
}
