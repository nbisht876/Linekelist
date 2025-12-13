public class Queue{
	int beginning;
	int top;
	int arr[];
	public void createQueue(int size)
	{
		arr=new int[size];
		beginning=-1;
		top=-1;
	}

	public void enQueue(int value)
	{
		if(top==arr.length-1)
		{
			System.out.println("Queue is full!!!");
		}
		else
		{
			if(beginning==-1){
			beginning=0;}
			top++;
			arr[top]=value;
		}
	}

	public void deQueue()
	{
		if(beginning==-1 || beginning>top)
		{
			System.out.println("Queue is Empty!!!");
			return;
		}
		
			beginning++;
			if(beginning>top)
			{
				beginning=-1;
				top=-1;
			}
		
	}
}
	
