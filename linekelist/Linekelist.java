package Linekelist.linekelist;
public class Linekelist {
	private Node head;
	private Node tail;
	private int length;	

	class Node{
			int value;
			Node next;
			Node(int value)
			{
				this.value=value;
			}	
	}
	public Linekelist(int value)
	{
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
	}

	public void printList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp=temp.next;
		}
	}

	public void addNode(int value)
	{
		Node newNode=new Node(value);
		if(length==0)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		length++;
	}

	public void removeLast()
	{
		if(head==null)
		{
			return;
		}
		if(length==1)
		{
			head=null;
			tail=null;
			length=0;
			return;
		}
		Node temp=head;
		Node prev=head;

		while(temp.next!=null)
		{
			prev=temp;
			temp=temp.next;
		}
		tail=prev;
		tail.next=null;
		length--;
            switch (length) {
                case 0 -> {
                    head=null;
                    tail=null;
                }
                case 1 -> head=tail;
                default -> head=head;
            }
	}
	public void prependNode(int value)
	{
		Node newNode=new Node(value);
		if(length==0)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
		length++;
	}

	public void removeFirst()
	{
		if(head==null)
		{
			return;
		}
		if(length==1)
		{
			head=null;
			tail=null;
			length=0;
			return;
		}
		head=head.next;
		length--;
		if(length==0)
		{
			tail=null;
		}
	}

	public Node get(int index)
	{
		if(index<0 || index>=length)
		{
			System.out.println("Index out of bounds");
			return null;
		}
		Node temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		System.out.println("Value at index "+index+": "+temp.value);
		return temp;
	}

	public void set(int index, int value)
	{
		if(index<0 || index>=length)
		{
			System.out.println("Index out of bounds");
			return;
		}
		Node temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		temp.value=value;
		System.out.println("Value at index "+index+" set to: "+temp.value);
		}	
	
	public boolean insert(int index, int value)
	{
		if(index<0 || index>length)
		{
			return false;
		}
		if(index==0)
		{
			prependNode(value);
			return true;
		}
		if(index==length){
			addNode(value);
		}
		Node newnode=new Node(value);
		Node temp=get(index-1);
		newnode.next=temp.next;
		temp.next=newnode;
		length++;
		return true;
	}

	public void removeNode(int value)
	{
		if(head==null)
		{
			return;
		}
		if(head.value==value)
		{
			head=head.next;
			length--;
			if(length==0)
			{
				tail=null;
			}
			return;
		}
		Node temp=head;
		while(temp.next!=null && temp.next.value!=value)
		{
			temp=temp.next;
		}
		if(temp.next==null)
		{
			System.out.println("Value not found");
			return;
		}
		temp.next=temp.next.next;
		if(temp.next==null)
		{
			tail=temp;
		}
		length--;
	}

	public void getHead()
	{
		System.out.println("Head: "+head.value);
	}

	public void getTail()
	{
		System.out.println("Tail: "+tail.value);

	}

	public void getLength()
	{
		System.out.println("Length: "+length);
	}
}
