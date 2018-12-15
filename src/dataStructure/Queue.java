package dataStructure;



public class Queue<T> 
{

	int front=0, rear=0;
	
	LinkedList<T> queue= new LinkedList<T>();
	
	public boolean isEmpty()
	{
		if(front==rear)
		{
			return true;
		}
		return false;
	}
	
	public int sizeOf()
	{
		return rear-front;
	}
	
	public T getFront()
	{
		return queue.head.data;
	}
	
	public void enque(T data)
	{
		queue.add(data);
		rear++;
	}
	
	public T deque()
	{
		rear--;
		return queue.remove(queue.head.data);
		
	}
	
	public void display()
	{
		queue.display();
	}
	public void display2()
	{
		queue.display2();
	}
		
	
}
