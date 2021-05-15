package com.j.datastructure.linkedlist;

public class MyLinkedList {

	private Node head;

	private int size;

	class Node {
		public int data;

		public Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int aData, Node aNext) {
			this.data = aData;
			this.next = aNext;
		}

		public Node getNext() {
			return this.next;
		}

		public int getData() {
			return this.data;
		}

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index == 0) {
			if (head == null) {
				return -1;
			}
			return head.data;
		}
		if (this.size < index) {
			return -1;
		}

		Node temp = getNode(index);

		if (temp == null) {
			return -1;
		}
		return temp.data;

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	private Node getNode(int index) {
		if (!isElementIndex(index)) {
			return null;
		}
		Node x = head;
		for (int i = 0; i < index; i++)
			x = x.next;
		return x;

	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public void addAtHead(int aData) {
		Node newNode = new Node(aData, null);
		size++;
		if (this.head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;

	}

	public void addAtTail(int aData) {
		Node newNode = new Node(aData, null);
		if (head == null) {
			addAtHead(aData);
			size++;
			return;
		}
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
	 * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
	 * be inserted.
	 */
	public void addAtIndex(int index, int val) {

		if (index == 0) {
			head = new Node(val, head);
			size++;
			return;
		}
		if (index > size) {
			return;
		}
		if (size == index) {
			addAtTail(val);
			return;
		}
		Node node = new Node(val, null);
		Node current = this.head;

		Node temp = getNode(index - 1);
		if (temp != null) {
			current = temp;
		}
		node.next = current.next;
		current.next = node;
		size++;

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		if (head == null) {
			return;

		}
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		Node temp = getNode(index - 1);

		if (temp.next != null) {
			temp.next = temp.next.next;
			size--;
		}

	}
}