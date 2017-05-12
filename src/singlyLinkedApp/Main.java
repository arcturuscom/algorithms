package singlyLinkedApp;

import singlyLinkedApp.impl.SinglyLinkedListImpl;

public class Main {
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedListImpl();
		sll.appendNode(5);
		sll.appendNode(2);
		sll.appendNode(15);
		sll.appendNode(10);
		sll.appendNode(7);

		System.out.println("appended "+sll);

		sll.removeTail();
		System.out.println("removed "+sll);

		sll.appendNode(7);
		System.out.println("appended "+sll);

		sll.appendNode(8);
		System.out.println("appended "+sll);

		sll.removeAllNodesGreaterThanGivenNumber(1);

		System.out.println("after deletion nodes that are great than 2 " + sll);

	}

}
