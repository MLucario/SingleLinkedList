
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
			return 0;
		else
			return 1;
	}
}

public class SingleLinkedList<T> {
	private Node<T> head = null;
	private Node<T> tail = null;
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
			tail = aNode;
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
			tail.setNextNode(aNode);
			this.tail = aNode;
			this.numberNode++;
		}
		
	}

	/**
	 * Add After
	 * 
	 * @return
	 */

	public void addAfter(T value, T after) {

		Node<T> tmp = head;
		Node<T> foundNode = null;
		while (true) {
			if (tmp == null)
				break;
			else {
				if (tmp.compareTo(after) == 0) {
					foundNode = tmp;
					break;
				}
			}
			tmp = tmp.getNextNode();
		}
		if (foundNode != null) {
			Node<T> aNode = new Node<T>(value);
			aNode.setNextNode(foundNode.getNextNode());

			if (this.tail == foundNode) {
				tail = aNode;
			}
			foundNode.setNextNode(aNode);
			this.numberNode++;
		} else {
			System.out.println("Cannot Find the node!");
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
			Node<T> temp = this.head;
			Node<T> preNode = null;
			while(true) {
				if(temp.compareTo(value)==0) {
					
					break;
				}
				preNode = temp;
				temp = temp.getNextNode();
			}
			if(this.numberNode==1) {
				this.head.setNextNode(null);
				this.tail.setNextNode(null);
				this.numberNode =0;
			}
			else{
				if(preNode != null) {
					preNode.setNextNode(temp.getNextNode());
					
					this.numberNode--;
				}
				else {
					System.out.println("Cannot find the node");
				}
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
	
	public void sortLinkedList() {
		if(isEmpty())
			System.out.println("Empty Linked List");
		else {
			Node<T> sortedNode = null;
			Node<T> currentNode = this.head;
			
		}
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		
		System.out.println("Add from the beginning");
		list.append(18);
		list.append(100);
		list.append(13);
		list.append(74);
		list.append(15);
		
		System.out.println(list.toString());
		System.out.println(list.numberNode);
		
//		// add 12 after 11
//		list.addAfter(12, 11);
//		System.out.println(list.toString());
//		System.out.println(list.numberNode);
//		
//		//Add at begin
//		list.add(0);
//		System.out.println(list.toString());
//		System.out.println(list.numberNode);
//		
//		// Delete first node
//		
//		list.deleteFirst();
//		System.out.println(list.toString());
//		System.out.println(list.numberNode);
//		
//		// Delete after
//		System.out.println("Delete ");
//		list.deleteAt(11);;
//		System.out.println(list.toString());
//		System.out.println(list.numberNode);
		
	
		
		
		
	}

}
