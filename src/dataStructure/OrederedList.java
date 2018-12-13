package dataStructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrederedList<T>
{
	//OrederedList<T> list=new OrederedList<T>();
		Node<T> head = null;	
		Node<T> tail = null;
		
		int count=-1;
		
		public  OrederedList<T> add(OrederedList<T> list, T data)
		{

			list.add(data);
			count++;
			return list;
		}
		public  OrederedList<T> remove(OrederedList<T> list, T data)
		{

			list.remove(data);
			count--;
			return list;
		}
		public  void add(T data)
		{
			
			if(head==null || head.data.toString().compareTo(data.toString())>=0 )
			{
				Node<T> n =new Node<T>(data, null);
				n.next=head;
				head=n;
				//tail=headZ
			}
			else
			{
				Node<T> newNode= new Node<T>(data, null);
				Node<T> temp=head;
				
				Node<T> previous = null;

				        while(temp!=null)
				        {
				            if(temp.data.toString().compareTo(data.toString()) > 0)
				            {
				                break;
				            }
				            previous = temp; 
				            temp = temp.next;
				        }
				   
				        
				            		
				            newNode.next=temp;
				            
				            previous.next=newNode;
			}
			
			count++;
			//return list;
		}
		
	

		public int isEmpty()
		{
			if(head==null)
			{
				return-1;		
			}
			return 1;
		}
		
		public int size()
		{
			return count;
		}
		
		public int remove(T ele)
		{
			if(isEmpty()== -1)
			{
				return -1;
			}
			else if(head.data == ele)
			{
				Node<T> temp = head.next;
				head =temp;
			}
			else if(head.next==null)
			{
				return -1;
			}
			else
			{
				Node<T> temp=head;
				
				while(temp.next.data.toString().compareTo(ele.toString())!=0 && temp.next.next != null)
				{
					temp =temp.next;
				}
				if(temp.next.data.toString().compareTo(ele.toString())==0)
				{
					Node<T> temp2 = temp.next.next;
					temp.next.next=null;
					temp.next=temp2;
					count--;
				}
				else
				{
					return-1;
				}
			}
			return 1;
		}
		
		public int writeList(String fileName) throws IOException
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			
			Node<T> temp = head;
			while(temp.next!=null)
			{
				
				out.write(temp.data.toString()+" ");
				temp=temp.next;
			}
			out.write(temp.data.toString());
			out.close();
			return -1;
		}
		
		public int search(T ele)
		{
			
			int count2=1;
			if(isEmpty()== -1)
			{
				return -1;
			}
			else if(head.data==ele)
			{
				return 0;
			}
			else
			{
				Node<T> temp=head;
				display();
				while(temp.next != null)
				{
					if(temp.data.toString().compareTo(ele.toString())==0)
					{
						return count2;
					}
					temp =temp.next;
					count2++;
				}
				if(temp.data.toString().compareTo(ele.toString())==0)
				{
					return count2;
				}
			}
			return -1;
					
		}
		
		public void display()
		{
			if(head==null)
			{
				System.out.print(" null ");
			}
			else
			{
				Node<T> temp=head;
				while(temp.next != null)
				{
					System.out.print(" "+temp.data+"-->>");
					temp=temp.next;
				}
				System.out.print(" "+temp.data+" ");
			}

		}
	
}
