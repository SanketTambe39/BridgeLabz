package dataStructure;



public class Stack<T> 
{
		int top=-1;
		LinkedList<T> stack = new LinkedList<T>();
	
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		return false;
	}
	
	
	public T peak()
	{
		return stack.pop();
	}
	
	
	public int sizeof()
	{
		return top;
	}
	
	
	public void push(T ele)
	{
		stack.add(ele);
		top++;
	}
	
	public int pop()
	{
		T data = stack.pop();
		return  stack.remove(data);
	}
	
	public void display()
	{
		stack.display();
	}
	
	
}
