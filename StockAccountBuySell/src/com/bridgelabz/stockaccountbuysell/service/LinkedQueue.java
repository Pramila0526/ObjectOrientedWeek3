package com.bridgelabz.stockaccountbuysell.service;

import java.util.List;
import java.util.NoSuchElementException;
import com.bridgelabz.stockaccountbuysell.model.Transactions;



/****************************************************************************************
 * @author :Pramila0526 
 * Purpose :Linkedlist Using Queue for Deck Of Cards Date
 *         :05/12/2019
 * 
 ****************************************************************************************/
class Node<T> 
{
	 T data;
	Node<T> link;
	public Node<T> next;

	@SuppressWarnings("unchecked")
	// Constructors Of Node
	public Node() {
		link = null;
		data = (T) " ";
	}

	@SuppressWarnings("unchecked")
	public Node(T d, Node<?> n) {
		data = d;
		link = (Node<T>) n;
	}

	@SuppressWarnings("unchecked")
	// Getters Setters
	public void setLink(Node<?> n) {
		link = (Node<T>) n;
	}

	public void setData(T d) {
		data = d;
	}

	public Node<?> getLink() {
		return link;
	}

	public T getData() {
		return data;
	}
}

//Linked Queue Class
public class LinkedQueue<T>
{
	protected static Node<?> front;
	protected static Node<?> rear;
	public static int size;

	public LinkedQueue() 
	{
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty() 
	{
		return front == null;
	}

	public int getSize() 
	{
		return size;
	}

	// Method For Inserting the Node
	public static<T> void insert(T i) 
	{
		Node<T> new_node = new Node<T>(i, null);
		if (rear == null)
		{
			front = new_node;
			rear = new_node;
		} else {
			rear.setLink(new_node);
			rear = rear.getLink();
		}
		size++;
	}

	// Method For removing the Node
	public String remove() 
	{
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node<?> temp = front;
		front = temp.getLink();
		if (front == null)
			rear = null;
		size--;
		return (String) temp.getData();
	}

	// Method to peek front element
	public String peek() 
	{
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return (String) front.getData();
	}

	// Display Linked Queue
	public static void display() 
	{
		if (size == 0) {
			System.out.print("Empty");
			return;
		}
		Node<?> ptr = front;
		while (ptr != rear.getLink()) {
			System.out.print(ptr.getData());
			ptr = ptr.getLink();
		}
	}


public static  void addAllLinkedQueue(List<Transactions> list) {
	// TODO Auto-generated method stub
	for(int i=0;i<list.size();i++)
	{
		insert( list.get(i));
	}
}
}
