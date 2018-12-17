package dataStructure;



public class Stack<T> 
{
		int top=0;
		LinkedList<T> stack = new LinkedList<T>();
	
	public boolean isEmpty()
	{
		if(top==0)
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
		top++;
		stack.add(ele);
		
	}
	
	public T pop()
	{
		//top--;
		return  stack.pop();
	}
	
	public void display()
	{
		stack.display();
	}
	public void display2()
	{
		stack.display2();
	}
	
	
	
}
