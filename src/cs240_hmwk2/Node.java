/**
 * 
 */
package cs240_hmwk2;

/**
 * @author bjhau
 *
 */
public class Node<T> {

	private Node<T> address;
	private T data;
	
	public Node (Node<T> address, T data)
	{
		this.address = address;
		this.data = data;
	}
	
	public Node (T data)
	{
		address = null;
		this.data = data;
	}

	public Node<T> getAddress() {
		return address;
	}

	public void setAddress(Node<T> address) {
		this.address = address;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
