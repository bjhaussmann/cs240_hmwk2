/**
 * 
 */
package cs240_hmwk2;

import java.util.EmptyStackException;

/**
 * @author bjhau
 *
 */
public class StackFixedSize<T> implements StackInterface<T>{

	private final static int defaultSize = 10;	//default fixed size
	private final T[] stack;
	private int numOfEntries;	//entry counter
	
	public StackFixedSize() 
	{
		this(defaultSize);
	}
	
	/**
	 * Constructor for stack with passed fixed size.
	 * @param size	Fixed size of the stack. Default is 10.
	 */
	public StackFixedSize(int size) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[size];	//unchecked cast
		stack = tempStack;
		numOfEntries = 0;	//entry counter
	}
	
	/**	
	 *  Adds a new entry to the top of this stack.
	 *	@param	newEntry	An object to be added to the stack.
	 *	@throws	ArrayIndexOutOfBoundsException	Not enough room in the stack for the new entry.
	 */	
	@Override
	public void push(T newEntry) {
		if (numOfEntries < stack.length)
		{
			stack[numOfEntries] = newEntry;	//add new data to stack
			numOfEntries++;	//increment entry counter
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Removes and returns this stack's top entry.
	 * @return	The object at the top of the stack.
	 * @throws	EmptyStackException if the stack is empty before the operation.
	 */
	@Override
	public T pop() throws EmptyStackException {
		
		if (numOfEntries < 1) {
			throw new EmptyStackException();
		}
		
		T topEntry;	//temp to save top entry data
		
		topEntry = stack[numOfEntries];	//save top entry
		stack[numOfEntries] = null;	//clear the top entry
		numOfEntries--;	//decrement entry counter
		
		return topEntry;	//return saved data for top entry
	}

	/**
	 * Retrieves this stack's top entry.
	 * @return	The object at the top of the stack.
	 * @throws	EmptyStackException if the stack is empty.
	 */
	@Override
	public T peek()  throws EmptyStackException{
		if ( numOfEntries < 1) {
			throw new EmptyStackException();
		}
		
		return (stack[numOfEntries]);
	}

	/**
	 * Detects whether this stack is empty.
	 * @return	True if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (numOfEntries < 1)
		{
			return true;	//stack is empty
		}
		else
		{
			return false;	//stack is not empty
		}
	}

	/**
	 * Removes all entries from this stack.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < numOfEntries; i++)
		{
			stack [i] = null;	//clear the stack
		}
		
		numOfEntries = 0;	//reset the entry counter
	}
}
