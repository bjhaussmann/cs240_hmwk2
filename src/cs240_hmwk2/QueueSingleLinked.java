/**
 * 
 */
package cs240_hmwk2;

/**
 * @author bjhau
 *
 */
public class QueueSingleLinked<T> implements QueueInterface<T> {

	protected Node<T> front;
	protected Node<T> back;
	
	public QueueSingleLinked ()
	{
		front = null;
		back = front;
	}
	
	/**
	 * Adds a new entry to the back of this queue.
	 * @param	newEntry	An object to be added.
	 */
	@Override
	public void enqueue(T newEntry) {
		back = new Node<T>(back.getLink(), newEntry);
	}

	/**
	 * Removes and returns the entry at the front of this queue.
	 * @return	The object at the front of the queue.
	 * @throws	EmptyQueuException	if the queue is empty before the operation.
	 */
	@Override
	public T dequeue() {
		Node<T> currentFront;
		Node<T> nextFront = back;
		if (isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			currentFront.setData(getFront());
			while (nextFront.getLink() != currentFront)
			{
				nextFront = nextFront.getLink();
			}
		}
		return currentFront.getData();
	}

	/**
	 * Retrieves the entry at the front of this queue
	 * @return	The object at the front of the queue.
	 * @throws	EmptyQueueException	if the queue is empty.
	 */
	@Override
	public T getFront() {
		Node<T> currentFront = back;
		if (isEmpty())
		{
			throw new EmptyQueuException();
		}
		else
		{
			while ( currentFront.getLink() != null)
			{
				currentFront = currentFront.getLink();
			}
		}
		return currentFront.getData();
	}

	/**
	 * Detects whether this queue is empty.
	 * @return	True if the queue is empty, or false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (back == front)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	/**
	 * Removes all entries from this queue.
	 */
	@Override
	public void clear() {
		back = front;
	}

}
