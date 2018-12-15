package dataStructure;

import java.util.ArrayList;

public class Deque<T>
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
	
	public T getRear()
	{
		return queue.pop();
	}
	
	public void addFront(T data)
	{
		queue.insert(data, 0);
		rear++;
	}
	
	public void addRear(T data)
	{
		queue.add(data);
		rear++;
	}
	
	public T removeFront()
	{
		rear--;
		return queue.remove(queue.head.data);
		
	}
	public T removeRear()
	{
		
		return queue.remove(queue.pop());
		
	}
	
	public void display()
	{
		queue.display();
	}
	
}
