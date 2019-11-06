package example.programming.interview;

public class SinglyLinkedListImpl<T> {

	private Node<T> head;
    
    public void add(T element){
          
        Node<T> nd = new Node<T>();
        nd.setData(element);
        System.out.println("Adding: "+element);
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                //since there is only one element, both head and 
                //tail points to the same object.
                head = nd;
                break;
            } else if(tmp.getNextRef() == null){
                tmp.setNextRef(nd);
                break;
            } else {
                tmp = tmp.getNextRef();
            }
        }
    }
      
    public void traverse(){
          
        Node<T> tmp = head;
        if(tmp==null)
        {
        	System.out.println("Empty List");
        }
        else 
        {
        	while(true){
                if(tmp == null){
                    break;
                }
                System.out.print(tmp.getData()+"\t");
                tmp = tmp.getNextRef();
            }
        }
        
    }
     
    public void reverse(){
         
        System.out.println("\nreversing the linked list\n");
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while(current != null){
            next = current.getNextRef();
            current.setNextRef(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public T getMiddleElement()
    {
    	Node<T> incBy1 = head;
    	Node<T> incBy2 = head;
    	
    	if(incBy1==null)
    		return null;
    	while(incBy2!=null && incBy2.getNextRef()!=null)
		{
			incBy2 = incBy2.getNextRef().getNextRef();
			incBy1 = incBy1.getNextRef();
		}
    		
    	return incBy1.getData();
    	    	                
    }
     
    public T get3rdLastElement() //assuming list has atleast 3 elements
    {
    	Node<T> incBy1 = head;
    	
    	if(incBy1==null)
    		return null;
    	else
    	{
    		Node<T> incBy3 = head.getNextRef().getNextRef().getNextRef();
    		
    		while(incBy3!=null && incBy3.getNextRef()!=null)
    		{
    			incBy3 = incBy3.getNextRef();
    			incBy1 = incBy1.getNextRef();
    		}
    		
    		return incBy1.getData();
    	}
    	
    }
    
    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        
        System.out.println(sl.head);
        sl.add(1);
        sl.add(34);
        sl.add(67);
        sl.add(98);
        sl.add(99);
        sl.add(34);
        System.out.println();
        sl.traverse();
        System.out.println();
        System.out.println("Middle:"+sl.getMiddleElement());
        System.out.println("3rd last element:"+sl.get3rdLastElement());
        sl.reverse();
        sl.traverse();
    }

}
