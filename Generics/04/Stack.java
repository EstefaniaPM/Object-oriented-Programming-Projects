import java.util.ArrayList;
public class Stack<T> {

	private ArrayList< T > elements; // ArrayList stores stack elements
	// no-argument constructor creates a stack of the default size

	public Stack() {
		this( 10 ); // default stack size
	} // end no-argument Stack constructor
	
	// constructor creates a stack of the specified number of elements
	public Stack( int capacity ) {
		int initCapacity = capacity > 0 ? capacity : 10; // validate
		elements = new ArrayList< T >( initCapacity ); // create ArrayList
	} // end one-argument Stack constructor

	// push element onto stack
	public void push( T pushValue ) {
		elements.add( pushValue ); // place pushValue on Stack
	} // end method push
	// return the top element if not empty; else throw EmptyStackException
	public T pop() {
		if ( elements.isEmpty() ) // if stack is empty
			throw new EmptyStackException( "Stack is empty, cannot pop" );
		// remove and return top element of Stack
		return elements.remove( elements.size() - 1 );
	} // end method pop

} // end class Stack< T >