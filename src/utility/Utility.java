package utility;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.math.*;
import java.util.Arrays;
public class Utility 
{
	
	Scanner sc = new Scanner(System.in);
	
	
	public int getInt()
	{
		return sc.nextInt();
	}
	
	public float getFloat()
	{
		return sc.nextFloat();
	}
	public void print(String str)
	{
		System.out.print(str);	
	}
	public void println(String str)
	{
		System.out.println(str);	
	}
	public boolean getBoolean()
	{
		return sc.nextBoolean();
	}
	
	public double getDouble()
	{
		return sc.nextDouble();
	}
	
	public String getString()
	{
		return sc.next();
	}
	
	public String getLine()
	{
		return sc.nextLine();
	}
	
	public String replaceString(String str, String str2)
	{
		str = str.replaceAll("<<UserName>>", str2);
		System.out.print(str);
		return str;
	}
	
	public void flipCoin(int n)
	{
		
		Random rd= new Random();
		int countT=0, countH=0;
		
		while(n!=0)
		{
			
			int face = rd.nextInt();
			
			if(face<0.5)
			{
				countT++;
			}
			else
			{
				countH++;
			}
			n--;
		}
		
		float perH= (countH*100)/(countH+countT);
		float perT= (countT*100)/(countH+countT);
		
		System.out.print("\n Number of Head Occurs : "+countH+"\n Prcentage Count of Heads : "+perH);
		System.out.println("\n Number of Tails Occurs : "+countT+"\n Prcentage Count of Tails : "+perT);
	}
	
	
	public boolean isLeapYear(int year)
	{
		
		if(year%400==0 || year%4==0 && year%100 != 0)
		{
			
			return true;
		}
		
		return false;
		
	}
	
	public void powerOf2(int n)
	{
		if(n <= 31)
		{
			for(int i=0; i<=n; i++)
			{
				System.out.println((int)Math.pow(2, i));
		
			}
		}
		else
		{
			System.out.println("The number you have given is out of integer limit");
		}
	}
	
	public float harmonicValue(int n)
	{
		float sum=0;
		
		for(int i=1; i <= n; i++)
		{
			sum = sum + (float)1/i;
		}
		System.out.println(sum);
		return sum;	
	}
	
	public void factors(int n)
	{
		//double sqrt= Math.sqrt(n);
		
			System.out.print("The number "+n+" factor is :  ");
			for(int i=2; i*i <= n; i++)
			{
				while(n%i == 0)
				{
					System.out.print(i+" ");
					n= n/i;
				}
			}
		
		if(n>1)
		{
			System.out.println(n);
		}
		
	}
	
	
	public void gambler(int stake, int goal, int n)
	{
		int win=0;
		int bet=0;
		int trials =0;
		while(trials++ <n)
		{
			int cash = stake;
			
			while(cash>0 && cash<goal)
			{
				bet++;
				if(Math.random()<0.5)
				{
					cash++;
				}
				else
				{
					cash--;
				}
				
			}
			if(cash == goal)
			{
				win++;
			}
		}
		
		System.out.println("The Gambler has won "+win+" games out of "+n);
		System.out.println("Winning percentage is :  " +(100*win)/n);
		System.out.println("Average bets = " +bet/n);
	}
	

	public void couponNumber(int n)
	{
	  	int couponNum[]= new int[n];
	  	Random rd = new Random();
	  	int coupon = rd.nextInt(n);
	  	int i=1, count=1;
	  	couponNum[0]=coupon;
	  	
	  	while(i<n)
	  	{
	  		coupon = rd.nextInt(n);
	  		count++;
	  		int flag=0;
	  		for(int j=0; j<i; j++)
	  		{
	  			if(coupon == couponNum[j])
	  			{
	  				flag =1;  
	  			}
	  			
	  		}
	  		if(flag==0)
	  		{
	  			couponNum[i++]=coupon;
	  		}
	  	}
	  	System.out.println(count+" numbers are required to generate "+n+" coupons");
	  	for(i=0; i<n; i++)
	  	{
	  		System.out.print(couponNum[i]+" ");
	  	}
	  	
	}

	public int[][] read2DArrayInt(int m, int n)
	{
		int arr[][]= new int[m][n];
		
		for(int i=0; i<m;i++)
		{
			for(int j=0; j<n;j++)
			{
				System.out.print("Array["+i+"]["+j+"] : ");
				arr[i][j]=getInt();
			}
		}
		return arr;
	}

	public float[][] read2DArrayFloat(int m, int n)
	{
		float arr[][]= new float[m][n];
		
		for(int i=0; i<m;i++)
		{
			for(int j=0; j<n;j++)
			{
				System.out.print("Array["+i+"]["+j+"] : ");
				arr[i][j]=getFloat();
			}
		}
		return arr;
	}
	
	public boolean[][] read2DArrayBoolean(int m, int n)
	{
		boolean arr[][]= new boolean[m][n];
		
		for(int i=0; i<m;i++)
		{
			for(int j=0; j<n;j++)
			{
				System.out.print("Array["+i+"]["+j+"] : ");
				arr[i][j]=getBoolean();
			}
		}
		return arr;
	}
	
	public void print2DArray(int arr[][],int m, int n)
	{
		PrintWriter writer= new PrintWriter(System.out, true);
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				writer.print(arr[i][j]+" ");
			}
			writer.println();
		}
	}
	public void print2DArray(float arr[][],int m, int n)
	{
		PrintWriter writer= new PrintWriter(System.out, true);
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				writer.print(arr[i][j]+" ");
			}
			writer.println();
		}
	}
	public void print2DArray(boolean arr[][],int m, int n)
	{
		PrintWriter writer= new PrintWriter(System.out, true);
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				writer.print(arr[i][j]+" ");
			}
			writer.println();
		}
	}

	public void triplet(int n)
	{
		int arr[]= new int[n];
		for(int i=0; i< n; i++)
		{
			print("arr["+i+"]:");
			arr[i]= getInt();
		}
		for(int i=0; i<n-2; i++)
		{
			for(int j=i+1; j<n-1; j++)
			{
				for(int k=i+2; k<n; k++)
				{
			
					if((arr[i]+arr[j]+arr[k])==0)
					{
						print("The triplet is found :  ");
						println(""+arr[i]+" "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
	}
 	
	public  String swap(String str, int i, int j)
	{
		char ch[]=str.toCharArray();
		
		char temp = ch[i];
		ch[i]= ch[j];
		ch[j] = temp;
		
		return String.valueOf(ch);
	}

	public void permutationRecursion(String str, int i, int n)
	{
		
		if(i==n)
		{
			println(str);
		}
		else
		{
			int j=i;
			
			while(j<n)
			{
				str = swap(str, i, j);
				permutationRecursion( str, i+1, n);
				str=swap(str, i, j);	
				j++;
			}
			
		}
		
	}

	public void permutationIterative(String str)
	{
		int n=str.length();
			
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++)
			{
				str=swap(str, i, j);
				println(str);
			}
		}
		
	}

	public void eucledianDistance(int arg1, int arg2)
	{
		
		double dist= Math.sqrt(Math.pow(arg1, 2)+Math.pow(arg2, 2));
		print("Euclidean distance from (x, y) to (0, 0) is : "+dist);
		
	}

	public void quadraticEqnRoot()
	{
		print("Enter the values of a*x*x + b*x + c :\n a : ");
		double a = getDouble();
		print("\n b : ");
		double b = getDouble();
		print("\n c : ");
		double c = getDouble();
		
		double delta = Math.sqrt((b*b) - (4*a*c));
		
		if(delta>=0)
		{
			float x1 = (float) ((-b + delta)/(2*a));
			float x2 = (float) ((-b - delta)/(2*a));
		
			print("\n Roots of the Equation "+a+"x*x + "+b+"*x + "+c+ "is : \n \t X1 : "+x1+" \t X2 : "+x2);
		}
		else
		{
			print("The roots are not real");
		}
		
	}

	
	public void stopWatch()
	{
		
		long start=0, stop = 0, elapsed;
		while(true) 
		{	
			print("Enter the operation : \n 1.Start \n 2. Stop \n 3. Elapsed time \n 4.Exit");
			int ch =getInt();
			
			if(ch==1)
			{
				start = System.currentTimeMillis();
				print("Start time is : "+start);
			}
			else if(ch ==2)
			{
				
				if(start == 0)
				{
					println("You doesn't start stopwatch yet");
				}
				else
				{
					stop = System.currentTimeMillis();
					println("Stop time is : "+stop);
				}
				
			}
			else if(ch==3)
			{
				if(start == 0)
				{
					println("You doesn't start and Stop stopwatch yet");
				}
				else
				{
					elapsed= stop-start;
					println("The elapsed time is : "+elapsed);
					
				}
			}
			else if(ch==4)
			{
				return;
			}
			else
			{
				print("You entered a wrong choice");
			}
		}
	}
	
	public void windChill(double t, double v)
	{
		if(	Math.abs(t)<=50 && v>3 || v<=120 )
		{
			double w = 35.74 + (0.6215 * t) +(((0.4275 *t)-35.75)*Math.pow(v, 0.16));
			
			println("The effective temperature (the wind chill) is : "+w);
		}
		else
		{
			println("the formula is not valid if |t|>50 & 3<v<120 ");
		}
		
	}

	public void printGameArray(char[][]arr)
	{
		print("--------------\n");
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				print(" | "+arr[i][j]);
			}
			print(" |\n--------------\n");
		}
	}
	
	
	public char[][] makeATick(char [][]gameArray, char ch)
	{
		for(int i=0; i<gameArray.length; i++)
		{
			for(int j=0; j<gameArray[0].length; j++)
			{
				gameArray[i][j]=ch;
			}
		}
		return gameArray;
	}
	
	
	
	public void ticTacToe()
	{
		
		char [][]gameArray= new char[3][3];
		
		
		
		printGameArray(gameArray);
		
	}
	
	
	
	public static void main(String []args)
	{
		Utility u= new Utility();
		u.ticTacToe();
	}

}

