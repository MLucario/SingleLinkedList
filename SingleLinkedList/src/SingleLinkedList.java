
/**
  Single Linked List Operation
1. Append_ add at the end
2. Add at begin
3. Add at after
4. Delete first node
5. Delete after
6. Display
7. Length
9. Sort linked list ( insertion sort)
*/

class Node<T> implements Comparable<T> {
	private T data;
	private Node<T> nextNode;
	// private int index;

	public Node(T data) {
		this.data = data;
		this.nextNode = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public int compareTo(T o) {
		if (o == this.data)
			return 1;
		else
			return 0;
	}
}

public class SingleLinkedList<T> {
	private Node<T> head = null;
	//private Node<T> tail = null;
	private int numberNode = 0;

	/**
	 * Inseart at the beginning of LinkedList
	 * 
	 * @param value
	 */
	public void add(T value) {
		Node<T> aNode = new Node<T>(value);

		if (isEmpty()) {
			head = aNode;
			//tail = aNode;
		} else {
			aNode.setNextNode(head);
			this.head = aNode;
		}
		this.numberNode++;
	}

	/**
	 * Add at the end of LinkedList
	 * 
	 * @param value
	 */
	public void append(T value) {

		if (isEmpty()) {
			add(value);
		} else {
			Node<T> aNode = new Node<T>(value);
			//tail.setNextNode(aNode);
			//this.tail = aNode;
			Node<T> temp = this.head;
			while(true) {
				if(temp.getNextNode() == null) {
					temp.setNextNode(aNode);
					this.numberNode++;
					break;
				}
				temp = temp.getNextNode();
			}
			
		}
		
	}

	/**
	 * Add After
	 * 
	 * @return
	 */

	public void addAfter(T value, T after) {

		boolean found = false;
		//Node<T> foundNode = null;
		if(this.numberNode == 0) {
			System.out.println("Empty List");
		}
		else {
			Node<T> tmp = head;
			while (true) {
				if(tmp.getNextNode()== null) break;
				if (tmp.getNextNode().compareTo(after)==1 ) {
					Node<T> aNode = new Node<T>(value);
					tmp = tmp.getNextNode();
					aNode.setNextNode(tmp.getNextNode());
					tmp.setNextNode(aNode);
					this.numberNode ++;
					found = true;
					break;
				}
				else {
					tmp = tmp.getNextNode();
				}
					
				}
				if(!found) {
					System.out.println("Cannot find Node");
				}
			}
	}

	/**
	 * Delete at first
	 * 
	 * @return
	 */
	public void deleteFirst() {
		if (isEmpty()) {
			System.out.println("Linked List is empty");
		} else {
			this.head = this.head.getNextNode();
			this.numberNode--;
		}
	}

	/**
	 * Delete at node
	 * @return
	 */
	public void deleteAt(T value) {
		if(isEmpty()) {
			System.out.println("LinkedList is empty");
		}
		else {
			boolean notFound = true;
			Node<T> temp = this.head;
			while(true) {
				if(temp.getNextNode()== null) break;
				//find the node has same value
				if(temp.getNextNode().compareTo(value)==1) {
					temp = temp.getNextNode();
					Node<T> nodeNeedDelete = temp.getNextNode();
					temp.setNextNode(nodeNeedDelete.getNextNode());
					this.numberNode --;
					notFound = false;
					break;
				}
				else {
					temp = temp.getNextNode();
				}
			}
			if(notFound) {
				System.out.println("Cannot found the node!");
			}
		}
		
		
	}
	
	public int length() {
		return this.numberNode;
	}
	public String toString() {
		
		if(isEmpty()) {
			return "The linkedlist is empty";
		}
		else {
			String result ="";
			Node<T> temp = this.head;
			while(true) {
				result += temp.getData() + " ";
				if(temp.getNextNode()==null) {
					break;
				}
				temp = temp.getNextNode();
				
			}
			return result;
		}
		
	}
	public boolean isEmpty() {
		return this.numberNode == 0 ? true : false;
	}
	
	public Node<T> getNodeAt(T value) {
		if(isEmpty())
			return null;
		while(true) {
			Node<T> temp = head;
			if(temp.compareTo(value)==0) {
				return temp;
			}
			if(temp.getNextNode()==null)
				break;
			temp = temp.getNextNode();
			
		}
		return null;
	}
	
	//Insertion sort
	public void sortLinkedList() {
		if(isEmpty())
			System.out.println("Empty Linked List");
		else {
			Node<T> sortedNode = null;
			Node<T> currentNode = this.head;
			
		}
	}

	
	/**Algorithm
	 *  Find the nth node from THE END
	 */
	
	public Node<T> findFromTheEnd(int n){
		Node<T> currentNode = head;
		Node<T> nodeFound = null;
		
		for(int i =0; i<n; i++) {
			if(currentNode.getNextNode()==null) return null;
			currentNode = currentNode.getNextNode();
		}
		nodeFound = head;
		while(currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
			nodeFound = nodeFound.getNextNode();
		}
		return nodeFound;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		
		System.out.println("Add from the beginning");
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		System.out.println(list.toString());
		System.out.println(list.numberNode);
/**
		 

		// add 12 after 11
		System.out.println("add 6 after 5");
		list.addAfter(6, 5);
		System.out.println(list.toString());
		System.out.println(list.numberNode);
		
		System.out.println("Add 7 at the end");
		list.append(7);
		System.out.println(list.toString());
		System.out.println(list.numberNode);
		
		// Delete first node
		System.out.println("Delete first node");
		list.deleteFirst();
		System.out.println(list.toString());
		System.out.println(list.numberNode);
		
		// Delete after
		System.out.println("Delete ");
		list.deleteAt(5);;
		System.out.println(list.toString());
		System.out.println(list.numberNode);
		
 */
		
		
		System.out.println(list.findFromTheEnd(2).getData());
	}

}
