//Andrew Calise
package SLinkedList;


public class TestSLinkedList {
	public static void main(String[] args) {
		SLinkedList<Integer> intList = new SLinkedList<Integer>();
		int[] arr = {9, 12, 7, 3, 6, 5};
		for (int n: arr) {
			intList.addLast(n);
		}
		intList.display();
		
		intList.addFirst(20);
		intList.display();
		
		System.out.println("is 12 in the list: " + (intList.search(12) != null));
		System.out.println("is 2 in the list: " + (intList.search(2) != null));
		System.out.println("is 5 in the list: " + (intList.search(5) != null));
		intList.update(7, 23);
		intList.display();
		
		SLinkedList<Integer> intList2 = new SLinkedList<Integer>();
		intList2.addLast(1);
		intList2.display();
		intList2.removeFirst();
		intList2.display();
	}
}

class Node<E>{
	E element;
	Node<E> next;
	
	public Node(E e){
		element = e;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setElement(E e) {
		element = e;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> n) {
		next = n;
	}
	
	public void displayNode() {
		System.out.print("The element in this node is: " + this.element);
	}
}

class SLinkedList<E>{
	Node<E> head;
	Node<E> tail;
	int size;
	
	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty(){
		return (head == null);
	}
	
	public E getFirst() {
		return head.getElement();
	}
	
	public E getLast() {
		return tail.getElement();
	}
	
	public Node<E> getHead(){
		return head;
	}
	
	public void setHead(Node<E> n) {
		head = n;
	}
	
	public Node<E> getTail(){
		return tail;
	}
	
	public void setTail(Node<E> n) {
		tail = n;
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		if (this.isEmpty()) {
			head = newNode;
			tail = newNode;
        } 
		else {
            newNode.setNext(head); 
            head = newNode;
        }
        size++;
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (this.isEmpty()) {
			head = newNode;
			tail = newNode;
        } 
		else {
            tail.setNext(newNode);;
            tail = newNode;
        }
        size++;
	}
	
	public E removeFirst() {
		Node<E> first = head;
		head = head.next;
		return first.getElement();
	}
	
	//cannot implement removeLast() in O(1) time
	
	
	public void display() {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.getElement() + " -> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
	
	public Node<E> search(E key){
		Node<E> current = head;
		while (current != null) {
			if (current.getElement() == key) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public Node<E> update(E key, E e) {
		Node<E> nodeToUpdate = search(key);
		if (nodeToUpdate != null)
			nodeToUpdate.setElement(e);
		return nodeToUpdate;
	}
	
}

