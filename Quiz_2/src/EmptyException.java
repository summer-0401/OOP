
public class EmptyException extends Exception {
	public EmptyException(){
		super("list is empty");
	}
	public EmptyException(String args) {
		super(args);
	}
}
