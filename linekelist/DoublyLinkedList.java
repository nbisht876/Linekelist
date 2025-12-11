package Linekelist.linekelist;

public class DoublyLinkedList {
	public DoublyNode head;
	public DoublyNode tail;
	int length;

		public class DoublyNode{
			DoublyNode next;
			DoublyNode prev;
			int value;
		}
		
		public void CreateDoublyLinkedList(int value)
		{
			DoublyNode node= new DoublyNode();
			node.value=value;
			node.next=null;
			node.prev=null;
			head=node;
			tail=node;
			length++;
		}

		public void InserDoublyLinkedList(int value, int index)
		{
			DoublyNode node=new DoublyNode();
			if(length==0)
			{
				CreateDoublyLinkedList(value);
			}
			else if(index==0)
			{
				node.value=value;
				node.next=head;
				head.prev=node;
				head=node;
				length++;
			}
			else if(index>=length)
			{
				node.value=value;
				tail.next=node;
				node.prev=tail;
				node.next=null;
				tail=node;
				length++;
			}
			else
			{
				DoublyNode temp=head;
				for(int i=0;i<index-1;i++)
				{
					temp=temp.next;
				}
				node.value=value;
				node.prev=temp;
				node.next=temp.next;
				temp.next.prev=node;
				temp.next=node;
				length++;

			}
		}
		public void TravesalDoublyLinkedList()
		{
			DoublyNode node=head;
			while(node!=null)
			{
				System.out.println(node.value+" -> ");
				node=node.next;
			}
		}

		public void ReverseTraversalDoublyLinkedList()
		{
			DoublyNode node=tail;
			while(node!=null)
			{
				System.out.println(node.value+" -> ");
				node=node.prev;
			}
		}
		public static void main(String args[])
		{
			DoublyLinkedList d=new DoublyLinkedList();
			d.CreateDoublyLinkedList(1);
			d.InserDoublyLinkedList(2, 1);
			d.InserDoublyLinkedList(4, 2);
			d.InserDoublyLinkedList(3, 2);
			d.TravesalDoublyLinkedList();
			d.ReverseTraversalDoublyLinkedList();
		}

}
