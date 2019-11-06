package example.programming.interview;

public class Node<T> {//implements Comparable<T>{

	private T data;
    private Node<T> nextRef;
      
    
    public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }
   
   /* @Override
    public int compareTo(T value) {
        if(value == this.data){
            return 1;
        } else {
            return 0;
        }
    }*/
	
}
