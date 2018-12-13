package dataStructure;

import java.util.ArrayList;

public class HashingFunction<T>
{
	
	ArrayList<OrederedList<T>> slot= new ArrayList<OrederedList<T>>();
	
	public void display()
	{
		for(int i=0; i<11; i++)
		{
			
			if(slot.get(i) != null)
			{
				System.out.print("Slot "+i+" :");
				slot.get(i).display();
				System.out.println();
			}
			else
			{
				System.out.println(" "+slot.get(i)+" ");
			}
				
		}
	}
	
	public void createEmptySlot()
	{
		for(int i=0; i<11; i++)
		{
			OrederedList<T> list= new OrederedList<T>();
			slot.add( i, list);
		}
	}
	
	public void hashFunction(T arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			T ele = arr[i];
			int index = (int)ele % 11;
			System.out.println(ele+" "+index);
			slot.set(index, slot.get(index).add(slot.get(index), ele));
			
		}
		
	}
	
	public void push(T ele)
	{
		int index = (int)ele % 11;
		System.out.println(ele+" "+index);
		slot.set(index, slot.get(index).add(slot.get(index), ele));
		
	}
	
	public void pop(T ele)
	{
		int index = (int)ele % 11;
		slot.set(index, slot.get(index).remove(slot.get(index),ele));
	}
	
	public boolean search(T ele)
	{
		int index = (int)ele % 11;
		
		if(slot.get(index).isEmpty()==1)
		{
			if(slot.get(index).search(ele)==-1)
			{
				System.out.println("\n The element is not found");
				push(ele);
				return false;
			}
			else
			{
				System.out.println("\n The element is found");
				pop( ele);
				return true;
			}
			
		}
		else
		{
			System.out.println("\n The element is not found");
			push(ele);
			return false;
		}
		
	}
	
	
}
