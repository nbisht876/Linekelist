public class Stack
{
	int topOfStack;
	int arr[];
	public void createStack(int size)
	{
		arr=new int[size];
		topOfStack=-1;
				System.out.println("Succesfully created the Stack of size "+size);

	}
	public void push(int value)
	{
		if(topOfStack==arr.length-1)
		{
			System.out.println("Cannot push "+ value+" in the stack. Stack is Full!!!");
		}
		else
		{
		arr[topOfStack+1]=value;
		topOfStack++;
		System.out.println("Succesfully pushed element "+ value+" in the Stack!!!");
		}
	}
	public void pop()
	{
		if(topOfStack==-1)
		{
			System.out.println("Stack is empty!!!");
		}
		else
		{
		System.out.println("Succesfully popped element "+ arr[topOfStack] +" from the Stack!!!");
		topOfStack--;
		}
	}
	public int peek()
	{
		if(topOfStack==-1)
		{
			System.out.println("Stack is empty!!!");
			return 0;
		}
		else
		{
			return arr[topOfStack];
		}
	}
	public static void main(String args[])
	{
		Stack s=new Stack();
		s.createStack(4);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Top element in the Stack is "+s.peek());
		
	}

}