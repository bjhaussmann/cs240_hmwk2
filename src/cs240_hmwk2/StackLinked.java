/**
 * 
 */
package cs240_hmwk2;

/**
 * @author bjhau
 *
 */
public class StackLinked<T> implements StackInterface<T> {

	protected Node<T> head = new Node<T>(null, null);	//first node
	protected Node<T> tail = new Node<T>(head);	//last node
	protected int numOfNodes = 0;	//number of nodes
	
	/**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry  An object to be added to the stack.
	 */
	@Override
	public void push(T newEntry) {
		Node<T> nd = new Node<T>(tail.getAddress(), newEntry);	//set address of new node to the node before tail
		tail.setAddress(nd.getAddress());	//set tail address to new node's address
	}

	/**
	 * Removes and returns this stack's top entry.
	 * @return  The object at the top of the stack.
	 * @throws  EmptyStackException if the stack is empty before the operation.
	 */
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves this stack's top entry.
	 * @return  The object at the top of the stack.
	 * @throws  EmptyStackException if the stack is empty.
	 */
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Detects whether this stack is empty.
	 * @return  True if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		if( tail.getAddress() == head)	//if tail address is set to head then no nodes in list so empty.
		{
			return true;
		}
		else return false;
	}

	/**
	 * Removes all entries from this stack.
	 */
	@Override
	public void clear() {
		tail.setAddress(head);	//set tail address to head and garbage collector will delete unlinked nodes.
	}

}
