package com.bridgelabz.fellowship.datastructure;

public class Stack<T>
{
	  static int size=10;
	  static int top=-1;
	  static String a[]=new String[size];
	
	public static<T> void push(T s1)
	{
		if(top==size-1)
		{
			System.out.println("**Stack is Full**Cannot Perform Push Operation**");
		}
		else
		{
			top++;
			a[top]=(String) s1;
		}
	}
	public static void pop()
	{
		if(top==-1)
		{
			System.out.println("**Stack is Empty**Cannot Perform Pop Operation**");
		}
		else
		{
			top--;
		}
	}
	public static void display()
	{
		if(top>0)
		{
		for(int i=top;i>=0;i--)
		{
			System.out.println("|" +a[i]+ "|");
			System.out.println("---");
		}
		}
		else
		{
			System.out.println("**No ELements to Display**");
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Stack st=new Stack();
		st.push("a");
		st.push("b");
		st.push("c");
		System.out.println();
		System.out.println("=====Elements After push Operation=====");
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		System.out.println("=====Elements After pop Operation=====");
		System.out.println();
		st.display();
		
		}
}

