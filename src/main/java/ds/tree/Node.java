package ds.tree;

public class Node<T> {
 	
	private Node<T> right= null;
	private Node<T> left = null;
	private T data;
	
	
	public Node(T data)
	{
		this.setData(data);
	}
	
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
