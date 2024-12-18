package numericalLibrary.optimization.lossFunctions;


import numericalLibrary.optimization.ModelFunction;
import numericalLibrary.types.MatrixReal;



/**
 * Represents a {@link DifferentiableLoss} that behaves quadratically around a specific point.
 * <p>
 * An example of this type of losses has the form:
 * <br>
 * L(\theta) = \sum_i || f( x_i , \theta ) ||^2
 * <br>
 * where:
 * <ul>
 *  <li> f is a {@link ModelFunction} to be optimized,
 *  <li> x_i is the i-th input to the {@link ModelFunction},
 *  <li> \theta is the parameter vector, represented as a column {@link MatrixReal}.
 * </ul>
 * In such case, the Hessian of L(\theta) can be approximated using the Jacobian of f, J, as J^T * J.
 */
public interface LocallyQuadraticLoss
    extends DifferentiableLoss
{
    ////////////////////////////////////////////////////////////////
    // PUBLIC ABSTRACT METHODS
    ////////////////////////////////////////////////////////////////
    
    /**
     * Returns the approximate Hessian of the {@link LocallyQuadraticLoss}.
     * <p>
     * The approximate Hessian matrix is evaluated at the point defined by the parameters set by {@link #setParameters(MatrixReal)}.
     * 
     * @return  approximate Hessian matrix of the {@link LocallyQuadraticLoss}.
     */
    public abstract MatrixReal getGaussNewtonMatrix();
    
}
