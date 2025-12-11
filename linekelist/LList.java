package Linekelist.linekelist;

public class LList {
	public Node head;
	public Node tail;
	public int length;
	
	class Node{
		int value;
		Node next;
		Node(int value)
		{
			this.value=value;
		}
	}
	public LList(int value)
	{
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
	}
	public void add(int index, int value)
	{
		Node node=new Node(value);
		if(head==null)
		{
			node.next=null;
			head=node;
		}
		else if(index==0)
		{
			node.next=head;
			head=node;
		}
		else if(index==length)
		{
			node.next=null;
			tail.next=node;
			tail=node;

		}
		else{
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.next;
			}
			node.next=temp.next;
			temp.next=node;
		}
		length++;
		}
	public void print()
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			System.out.println(tempNode.value);
			tempNode=tempNode.next;
		}
		
	}
	public void delete(int index)
	{
		Node temp=head;
		if(length==0 || length<=index)
		{
			System.out.println("Linked list is empty");
		}
		else if(index==0)
		{
			head=head.next;
		}
		else if(index==length-1)
		{
			Node temp1=head;
			while(temp1.next.next!=null)
			{
				temp1=temp1.next;
			}
			temp1.next=null;
			tail=temp;
		}
		else{
			Node temp2=head;
			for(int i=0;i<index-1;i++){
				temp2=temp2.next;
			}
			temp2.next=temp2.next.next;
		}
length--;
	}
	public static void main(String[] args) {
		LList l1 = new LList(2);
		l1.add(0,2);
		l1.add(1,4);
		l1.add(1,3);
		l1.print();
		l1.delete(4);
		System.out.println("\n");
		l1.print();
		System.out.println("Lenght of linkedlist is "+l1.length);
	}
}

