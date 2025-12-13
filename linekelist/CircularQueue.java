package Linekelist.linekelist;

public class CircularQueue {
	int beginning;
	int top;
	int arr[];
	int size;
	public CircularQueue(int size)
	{
		this.size=size;
		arr=new int[size];
		beginning=-1;
		top=-1;
					System.out.println("Queue is created!!!");

	}
	public boolean isEmpty()
	{
		if(beginning==-1)
		{
			return true;
		}
		return false;
		
	}

	public boolean isFull()
	{
		if(beginning==((top+1)%size))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void enQueue(int value)
	{
		if(isFull())
		{
			System.out.println("Cannot insert "+value+" Queue is Full");
		}
		else if(beginning==-1)
		{
			beginning=0;
			top=0;
			arr[top]=value;
			System.out.println("Succesfully inserted "+value+" at index "+top);

		}
		else
		{
			top=(top+1)%size;
			arr[top]=value;
			System.out.println("Succesfully inserted "+value+" at index "+top);

		}
	}

	public void deQueue()
	{
		int result=-1;
		if(isEmpty())
		{
			System.out.println("Queue is Empty!!!");
			return;
		}
		result=arr[beginning];
		if(beginning==top)
					{
			beginning=top=-1;
		}
		else
		{
			System.out.println("Succesfully removed "+arr[beginning]+" from index "+beginning);
			arr[beginning]=0;
			beginning=(beginning+1)%size;
			
		}
		
	}

	public static void main(String[] args) {
		CircularQueue c=new CircularQueue(4);
		c.enQueue(1);
		c.enQueue(2);
		c.enQueue(3);
		c.enQueue(4);
		c.enQueue(5);
		c.deQueue();
		c.enQueue(5);

	}
}
