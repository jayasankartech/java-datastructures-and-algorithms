package com.j.datastructure.linkedlist;

public class TestMyLinkedList {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtHead(1);
		list.addAtTail(3);
		list.addAtIndex(1, 2);
		System.out.println(list.get(1));
		list.deleteAtIndex(1);
		System.out.println(list.get(1));

		list.addAtHead(2);
		list.addAtIndex(0, 2);
		System.out.println(list.get(0));
	}
}
