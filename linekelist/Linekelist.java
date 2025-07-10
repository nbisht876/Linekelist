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
	public void reverse()
	{
		if(head==null || head.next==null)
		{
			return;
		}
		Node prev=null;
		Node current=head;
		Node next=null;
		tail=head; // Update tail to the current head
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev; // Update head to the last processed node
	}
	public Node delete(int index)
	{
		if(index<0 || index>=length){
			return null;
		}
		if(index==0)
		{
			removeFirst();
			return head;
		}
		if(index==length-1)
		{
			removeLast();
			return tail;
			
		}
		Node prev=get(index-1);
		if(prev==null || prev.next==null)
		{
			System.out.println("Index out of bounds");
			return null;
		}
		Node temp=prev.next;
		prev.next=temp.next;
		temp.next=null;
		length--;
		return temp;
	}
	public Node removeNthnodefromlast(int n)
	{
		if(n<1 || n>length)
		{
			System.out.println("Invalid value of n");
			return null;
		}
		Node slow=head;
		Node fast=head;
		for(int i=0;i<n;i++)
		{
			fast=fast.next;
		}
		if(fast==null)
		{
			head=head.next;
			length--;
			if(length==0)
			{
				tail=null;
			}
			return head;
		}
		while(fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next;
		}
		Node toRemove=slow.next;
		slow.next=toRemove.next;
		toRemove.next=null;
		if(slow.next==null)
		{
			tail=slow;
		}
		length--;
		return toRemove;
	}
	public Node findMiddleNode()
	{
		if(head==null)
		{
			return null;
		}
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("Middle Node: "+slow.value);
		return slow;
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
	
	public Node findKthNodeFromEnd(int k)
	{
		if(k<1 || k>length)
		{
			System.out.println("Invalid value of k");
			return null;
		}
		Node slow=head;
		Node fast=head;
		for(int i=0;i<k;i++)
		{
			fast=fast.next;
		}
		while(fast!=null)
		{
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("Kth Node from end: "+slow.value);
		return slow;
	}

	public Node sumofTwoList(Node temp1, Node temp2)
	{
		Node sum=new Node(0); // Dummy node to simplify the addition process
		Node current=sum;
		int carry=0;
		while(temp1!=null || temp2!=null || carry>0)
		{
			int val1=(temp1!=null)?temp1.value:0;
			int val2=(temp2!=null)?temp2.value:0;
			int total=val1+val2+carry;
			carry=total/10;
			current.next=new Node(total%10);
			current=current.next;	
			if(temp1!=null) temp1=temp1.next;
			if(temp2!=null) temp2=temp2.next;
		}
		return sum.next; // Return the next node to skip the initial dummy node
	}

	public void partition(int val)
	{
		Node l1=new Node(0);
		Node l2=new Node(0);
		Node l1Tail=l1;
		Node l2Head=l2;
		Node point=head;
		while(point!=null)
		{
			if(point.value<val)
			{
				l1Tail.value=point.value;
				l1Tail=l1Tail.next;
			}
			else
			{
				l2Head.value=point.value;
				l2Head=l2Head.next;
			}
			point=point.next;
		}
		l1Tail.next=l2Head;
		head=l1;
	}
	public void partitionList(int x)
	{
		Node partitionedList = partition(head, x);
		head = partitionedList;
		tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		System.out.println("Partitioned List:");
		printList();
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
