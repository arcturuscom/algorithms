package singlyLinkedApp.impl;

import singlyLinkedApp.SinglyLinkedList;
import singlyLinkedApp.beans.Node;

public class SinglyLinkedListImpl implements SinglyLinkedList {

	private Node head;
	private Node tail;

	public SinglyLinkedListImpl() {
		head = null;
		tail = null;
	}

	@Override
	public void appendNode(int val) {
		Node node = new Node(val, null);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.setNext(node);
			tail = node;
		}

	}

	@Override
	public void removeTail() {
		if (tail == null) {
			System.out.println("List is Empty!!! Deletion is not possible");
			return;
		}

		else {
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				Node previousToTail = head;
				while (previousToTail.getNext() != tail)
					previousToTail = previousToTail.getNext();
				tail = previousToTail;
				tail.setNext(null);
			}
		}
	}

	@Override
	public void removeAllNodesGreaterThanGivenNumber(int targetNumber) {
		if (head == null)
			return;
		else {

			if (head == tail) {
				head = null;
				tail = null;
			} else {

				Node currentNode = head;
				Node previousCurrentNode = head;
				// loop until we find the node we aim to delete
				while (currentNode != null && currentNode.getData() <= targetNumber) {
					previousCurrentNode = currentNode;
					currentNode = currentNode.getNext();
				}
				if(currentNode != null){
					// case : head node nmber > targetNumber
					if(previousCurrentNode == currentNode){
						head = currentNode.getNext();
					}else{
						previousCurrentNode.setNext(currentNode.getNext());
					}	
					// recursive call
					removeAllNodesGreaterThanGivenNumber(targetNumber);
				}
			}
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}


	public String toString() {
		if (head == null) {
			return "Linked list is empty";
		} else {
			StringBuilder stringView = new StringBuilder();

			// using StringBuilder inside loops is very efficient
			for (Node x = head; x != null; x = x.getNext())
				stringView.append(x.toNodeString());

			return stringView.toString();
		}
	}

}
