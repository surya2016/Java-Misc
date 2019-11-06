package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
	
	
	Node<T> root=null;
	
	//creates tree with minimum 1 node
	public BinaryTree(T key)
	{
		root = new Node<T>(key);
	}
	//fetch root node
	public Node<T> getRoot()
	{
		return root;
	}
	// insert child nodes for a parent
	public Node<T> insertNode(Node<T> parent, String loc,List<T> data)
	{
		Node<T> newNode = null;
		int childCount = data.size();
		if(childCount==1)
		{
			if(loc.equalsIgnoreCase("left"))
			{
				parent.setLeft(new Node<T>(data.get(0)));
				newNode = parent.getLeft();
			}
			else if(loc.equalsIgnoreCase("right"))
			{
				parent.setRight(new Node<T>(data.get(0)));
				newNode = parent.getRight();
			}
			else
				System.out.println("Please select a valid location to insert child");
		}
		else if(childCount==2)
		{
			parent.setLeft(new Node<T>(data.get(0)));
			parent.setRight(new Node<T>(data.get(1)));
		}
		
		return newNode;
	}
	
	public static void main(String[] args) {
		
		
		BinaryTree<Integer> bt = new BinaryTree<Integer>(23);
		
		List<Integer> children = new ArrayList<Integer>();
		children.add(67);
		
		bt.insertNode(bt.getRoot(), "right", children);

	}

}
