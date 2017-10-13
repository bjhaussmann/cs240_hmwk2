/**
 * 
 */
package cs240_hmwk2;

/**
 * @author bjhau
 *
 */
public class QueueCircLinked<T> implements QueueInterface<T> {
	
	private int maxSize = 10;
	private int size;
	
	private Node<T> back = null;
	private Node<T> free = null;
	
	public QueueCircLinked()
	{
		back.setLink(free);
		free.setLink(back);
		back.setData(null);
		free.setData(null);
	}
	
	/** Adds a new entry to the back of this queue.
	   @param newEntry  An object to be added. */
	@Override
	public void enqueue(T newEntry) {
		Node<T> current = back;
		int count = 1;
		
		if (free.getData() == null)
		{
			while(current.getLink() != back)
			{
				
				current = current.getLink();
				count++;
			}
			if (count == max || (count < 10 && current.getData() == null))
			{
				current.setData(newEntry);
			}
			if (count < 10 && current.getData() != null)
			{
				Node<T> newNode = new Node<T> (back, newEntry);
				current.setLink(newNode);
				back = current;
			}
			else
			{
				throw FullQueueException();
			}
		}
	}

	/** Removes and returns the entry at the front of this queue.
	   @return  The object at the front of the queue. 
	   @throws  EmptyQueueException if the queue is empty before the operation. */
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**  Retrieves the entry at the front of this queue.
	   @return  The object at the front of the queue.
	   @throws  EmptyQueueException if the queue is empty. */
	@Override
	public T getFront() {
		Node<T> current = free;
		
		while (current.getLink() != free)
		{
			current = current.getLink();
		}
		return current.getData();
	}

	/** Detects whether this queue is empty.
	   @return  True if the queue is empty, or false otherwise. */
	@Override
	public boolean isEmpty() {
		Node<T> current = free;
		boolean empty = false;
		
		while(current.getLink() != free)
		{
			if (current.getData() == null)
			{
				empty = true;
			}
			else 
			{
				return false;
			}
			current = current.getLink();
		}
		return empty;
	}

	/** Removes all entries from this queue. */
	@Override
	public void clear() {
		Node<T> current = free;
		
		while (current.getLink() != free)
		{
			current.setData(null);
			current = current.getLink();
		}
	}

}
