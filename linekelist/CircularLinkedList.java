package Linekelist.linekelist;

public class CircularLinkedList {
	Node head;
	Node tail;
	public int size;

	public class Node{
		Node next;
		int value;
		
	}
	public Node CreateCircularLL(int value)
	{
		Node node=new Node();
		node.value=value;
		node.next=node;
		head=node;
		tail=node;
		size++;
		return head;
	}
	public void insert(int value, int index)
	{
		Node node=new Node();
		if(index==0)
		{
			node.next=head;
			head=node;
			tail.next=node;
			size++;
		}
		else if(index>=size)
		{
			node.next=tail.next;
			tail.next=node;
			tail=node;
		}
		else
		{
			
		}
	}
	public static void main(String[] args) {
		CircularLinkedList c=new CircularLinkedList();
		System.out.println(c.CreateCircularLL(5).next.value);
	}
}

