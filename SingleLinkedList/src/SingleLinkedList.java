/**
 * TODO : Need  to take out the Size of list
 */




/**
 * Single Linked List Operation 1. Append_ add at the end 2. Add at begin 3. Add
 * at after 4. Delete first node 5. Delete after 6. Display 7. Length 9. Sort
 * linked list ( insertion sort)
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
	// private Node<T> tail = null;
	private int numberNode = 0;

	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * Inseart at the beginning of LinkedList
	 * 
	 * @param value
	 */
	public void add(T value) {
		Node<T> aNode = new Node<T>(value);

		if (isEmpty()) {
			head = aNode;
			// tail = aNode;
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
			// tail.setNextNode(aNode);
			// this.tail = aNode;
			Node<T> temp = this.head;
			while (true) {
				if (temp.getNextNode() == null) {
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
		// Node<T> foundNode = null;
		if (this.numberNode == 0) {
			System.out.println("Empty List");
		} else {
			Node<T> tmp = head;
			while (true) {
				if (tmp.getNextNode() == null)
					break;
				if (tmp.getNextNode().compareTo(after) == 1) {
					Node<T> aNode = new Node<T>(value);
					tmp = tmp.getNextNode();
					aNode.setNextNode(tmp.getNextNode());
					tmp.setNextNode(aNode);
					this.numberNode++;
					found = true;
					break;
				} else {
					tmp = tmp.getNextNode();
				}

			}
			if (!found) {
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
	 * 
	 * @return
	 */
	public void deleteAt(T value) {
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			boolean notFound = true;
			Node<T> temp = this.head;
			while (true) {
				if (temp.getNextNode() == null)
					break;
				// find the node has same value
				if (temp.getNextNode().compareTo(value) == 1) {
					temp = temp.getNextNode();
					Node<T> nodeNeedDelete = temp.getNextNode();
					temp.setNextNode(nodeNeedDelete.getNextNode());
					this.numberNode--;
					notFound = false;
					break;
				} else {
					temp = temp.getNextNode();
				}
			}
			if (notFound) {
				System.out.println("Cannot found the node!");
			}
		}

	}

	public int length() {
		Node<T> temp = this.head;
		int count =0;
		while(temp!=null) {
			count++;
			temp = temp.getNextNode();
		}
		return count;
	}

	public String toString() {

		if (isEmpty()) {
			return "The linkedlist is empty";
		} else {
			String result = "";
			Node<T> temp = this.head;
			while (true) {
				result += temp.getData() + " ";
				if (temp.getNextNode() == null) {
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
		boolean notFound = true;
		Node<T> temp = head;
		if (isEmpty()) {
			temp = null;
		} else {

			while (temp != null) {
				if (temp.compareTo(value) == 1) {
					notFound = false;
					return temp;
				}
				temp = temp.getNextNode();

			}
			if (notFound)
				temp = null;
		}
		return temp;

	}

//	//Insertion sort
//	public void sortLinkedList() {
//		if(isEmpty())
//			System.out.println("Empty Linked List");
//		else {
//			for(int i =0; i < this.numberNode - 1 ; i ++) {
//				T key = this.head.getData();
//				int j = i - 1;
//			}
//			
//		}
//	}

	/**
	 * Algorithm Find the nth node from THE END
	 */

	public Node<T> findFromTheEnd(int n) {
		Node<T> currentNode = head;
		Node<T> nodeFound = null;

		for (int i = 0; i < n; i++) {
			if (currentNode.getNextNode() == null)
				return null;
			currentNode = currentNode.getNextNode();
		}
		nodeFound = head;
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
			nodeFound = nodeFound.getNextNode();
		}
		return nodeFound;
	}

	/**
	 * reverse linked list Get the Next Node Set Head next to TEMP Set Temp = Head
	 * change Head to NextNode
	 * 
	 * 
	 * Have to set head = temp when done
	 */

	public void reverseLinkedList() {
		if (this.numberNode == 0) {
			System.out.println("Empty list");
		} else {
			Node<T> temp = null;
			Node<T> nextNode = null;
			while (head != null) {
				nextNode = head.getNextNode();
				head.setNextNode(temp);
				temp = head;
				head = nextNode;
			}

			// ! important step
			this.head = temp;
			System.out.println("Finish");
		}
	}
	
	public Node<T> getMiddleNode(){
		Node<T> slow = head;
		Node<T> fast = head;
		int i = 0;
		while(fast.getNextNode()!=null) {
			//moce fast 1 time
			if( i==0) {
				fast = fast.getNextNode();
				i = 1;
			}
			//move fast 1 more time = > fast move two time of slow
			else if( i == 1) {
				slow = slow.getNextNode();
				fast = fast.getNextNode();
				i = 0;
			}
			
		}
		return slow;
	}

	public Node<T> getHead() {
		return head;
	}
	
	public void printLinkedListFromTheEnd(Node<T> aNode) {
		if(aNode==null) {
			return;
			}
		
		else {
			printLinkedListFromTheEnd(aNode.getNextNode());
			System.out.print(" " + aNode.getData());
		}
		
	}

	public static void main(String[] args) {
/**
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();

		System.out.println("Add from the beginning");
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);

		System.out.println(list.toString());
		System.out.println(list.numberNode);

		// no cycle
		System.out.println(list.isCycle(list));
		list.deleteCycle(list);

		// Let add an cycle from node 5 to node 3
		Node<Integer> temp = list.getNodeAt(5);
		System.out.println(temp.getData());
		temp.setNextNode(list.getNodeAt(3));
		System.out.println("Cycle check : " + list.isCycle(list));
		list.deleteCycle(list);
		System.out.println(list.toString());

		System.out.println("====Reverse====");
		list.reverseLinkedList();
		System.out.println("====Reverse====");
		System.out.println(list.toString());
		
		System.out.println("====Reverse===========");
	*/	
		
		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		list1.append(1);
		list1.append(3);
		
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.append(1);
		list2.append(2);
		list2.append(3);
		list2.append(4);
		list2.append(5);
		list2.append(6);
		list2.append(7);
		list2.append(8);
		
		//let add list 1 to join list 2 at Node 4
		list1.getNodeAt(3).setNextNode(list2.getNodeAt(4));;
		
		System.out.println("====List 1====");
		System.out.println(list1.toString());
		System.out.println("====List 2====");
		System.out.println(list2.toString());
		
		Node<Integer> nodeJoin = list1.findJoinNode(list1, list2);
		System.out.println("======Join Node=====");
		if(nodeJoin!=null)
		System.out.println(nodeJoin.getData());
		
		System.out.println("=====Middle of list 1 ====");
		Node<Integer> middle = null ;
		middle = list1.getMiddleNode();
		System.out.println(middle.getData());
		
		System.out.println("=====Middle of list 2 ====");
		Node<Integer> middle2 = null ;
		middle2 = list2.getMiddleNode();
		System.out.println(middle2.getData());
		
		
		System.out.println("=====Print from the end======");
		list1.printLinkedListFromTheEnd(list1.getHead());
		
		
		
		
		/**
		 * 
		 * 
		 * // add 12 after 11 System.out.println("add 6 after 5"); list.addAfter(6, 5);
		 * System.out.println(list.toString()); System.out.println(list.numberNode);
		 * 
		 * System.out.println("Add 7 at the end"); list.append(7);
		 * System.out.println(list.toString()); System.out.println(list.numberNode);
		 * 
		 * // Delete first node System.out.println("Delete first node");
		 * list.deleteFirst(); System.out.println(list.toString());
		 * System.out.println(list.numberNode);
		 * 
		 * // Delete after System.out.println("Delete "); list.deleteAt(5);;
		 * System.out.println(list.toString()); System.out.println(list.numberNode);
		 * 
		 */

		// System.out.println(list.findFromTheEnd(2).getData());
	}

	/*
	 * 8 Floyd algorithm to detect cycle in linked list
	 */
	public boolean isCycle(SingleLinkedList<T> list){
		
		Node<T> fast = list.getHead();
		Node<T> slow = list.getHead();
		while(fast.getNextNode()!=null && slow!= null && fast != null) {
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
			if( slow == fast)
				return true;
		}
		return false;
	}

	/**
	 * How to delete the cycle in linked list
	 * 
	 * @param list
	 */
	public void deleteCycle(SingleLinkedList<T> list) {

		// Detect the cycle in linked list
		Node<T> fast = list.getHead();
		Node<T> slow = list.getHead();

		while (fast.getNextNode() != null && slow != null && fast != null) {
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
			if (slow == fast)
				break;
		}

		// From here will delete the cycle if we FOUND
		if (slow == fast) { // if we find the cycle
			slow = head; // set slow to head

			// increate by one note for both slow and fast node
			while (slow.getNextNode() != fast.getNextNode()) {
				slow = slow.getNextNode();
				fast = fast.getNextNode();
			}

			// delete the next of fast node SET TO NULL to have uncycle linked list
			fast.setNextNode(null);
		} else {
			System.out.println("List does not have cycle");
		}
	}

	public Node<T> findJoinNode(SingleLinkedList<T> list1, SingleLinkedList<T> list2) {
		Node<T> result = null;
		int L1 =0,
				L2 =0,
				d= 0;
		Node<T> tempHead = list1.getHead();
		L1 = list1.length(); //take m steps
//		while(tempHead!=null) {
//			L1++;
//			tempHead = tempHead.getNextNode();
//		}
		tempHead = list2.getHead();
		while(tempHead!=null) {
			L2++;
			tempHead = tempHead.getNextNode();
		}
		
		if (list1.length() != 0 && list2.length() != 0) {
			// I assume temp1 is longest linked list
			Node<T> temp1, temp2;
			if (list1.length() - list2.length() > 0) {
				temp1 = list1.getHead();
				temp2 = list2.getHead();
				d = L1 - L2;
			} else {
				temp1 = list2.getHead();
				temp2 = list1.getHead();
				d = L2 - L1;
			}

			// Travel d steps in longest list
			for (int i = 0; i < d; i++) {
				temp1 = temp1.getNextNode();
			}

			while (temp1 != null && temp2 != null) {
				if (temp1 == temp2) {
					return temp1;

				} else {
					temp1 = temp1.getNextNode();
					temp2 = temp2.getNextNode();
				}
			}
		} else {
			System.out.println("Emtpy list error!!");
		}
		return result;
	}
}
