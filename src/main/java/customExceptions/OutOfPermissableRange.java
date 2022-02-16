package customExceptions;

/**
 * 
 * This class is used to define the custom or user defined exception.
 * @author abhishek shandilya
 *
 */

public class OutOfPermissableRange extends Exception {
	public OutOfPermissableRange(String errorDetailMessage) {
		super(errorDetailMessage);
	}
}
