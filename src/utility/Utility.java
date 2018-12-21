
/******************packages import*****************/

package utility;

import java.util.Scanner;

import algorithms.Jobs;

import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;

/****************** import*****************/


/****************Utility Class Declaration*****************/

public class Utility 
{

/******************I/O Methods Declaration*****************/
	
	Scanner sc = new Scanner(System.in);

/****************** Method for Integer input*****************/
	
	public int getInt()
	{
		return sc.nextInt();
	}
	
/****************** Method for Float input*****************/
	
	public float getFloat()
	{
		return sc.nextFloat();
	}
	
/****************** Method for Boolean input*****************/
	
	public boolean getBoolean()
	{
		return sc.nextBoolean();
	}
	
/****************** Method for Double input*****************/	

	public double getDouble()
	{
		return sc.nextDouble();
	}
	
/****************** Method for a single String input*****************/	
	public String getString()
	{
		return sc.next();
	}
	
/****************** Method for a string line input*****************/
	public String getLine()
	{
		return sc.nextLine();
	}

/****************** Method for print output*****************/
	
	public void print(String str)
	{
		System.out.print(str);	
	}

/****************** Method for print output on nextline*****************/	
	public void println(String str)
	{
		System.out.println(str);	
	}
	
	
/****************** Method for read 1D Integer array*****************/	
	
	public int[] readArray(int n)
	{
		int arr[]= new int[n];
		
		for(int i=0; i<n; i++)
		{
			arr[i]= getInt();
		}
		return arr;
	}

	
/****************** Method for print 1D Integer Array*****************/
	
	public void printArray(int arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			print(" "+arr[i]);
			
		}
		println("");	
	}
	
/****************** Method for print 1d String Array*****************/	
	
	public void printArray(String arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			print(" "+arr[i]);
			
		}
	}
	
/****************** Method for print 1d Char Array*****************/	

	public void printArray(char arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			print(" "+arr[i]);
			
		}
	}
	
	public void printArrayRev(int arr[])
	{
		for(int i=arr.length-1; i>=0; i--)
		{
			
			print(""+arr[i]);
			if(i%4==0)
			{
				print(" ");
			}
		}
	}
/*********************Functional Programs*****************************/
	
/**************Program for replace <<Username>> in a string ************/
	
	public String replaceString(String str, String str2)
	{
		str = str.replaceAll("<<UserName>>", str2);
		System.out.print(str);
		return str;
	}
	
//Program for flipcoin percentage...................................
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
	
//program for checking leap year..........................................	
	public boolean isLeapYear(int year)
	{
		
		if(year%400==0 || year%4==0 && year%100 != 0)
		{
			
			return true;
		}
		
		return false;
		
	}
	
//program for power of 2..........................................
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
	
	
// program for calculating factorial....................
	public static int factorial(int n)
	{
		
		if(n==1)
			return 1;
		
		return factorial(n-1)*n;
		
	}
	
	
//program for calculate harmonic value..........................................	
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

//program for calculating prime factors of a number..........................................
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
	
//program for implementing game of a gambler..........................................
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
	
//program for generating n no. of coupons..........................................
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

//program for reading files................................
	
	public static File getFile(String path)
	{
		File file = new File(path);
		return file;
	}
	
	
//program for reading 2D arrays......................................................	
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
	
	public void print2DArray(int arr[][])
	{
		int m=arr.length;
		int n=arr[0].length;
		PrintWriter writer= new PrintWriter(System.out, true);
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(arr[i][j]==0)
				{
					continue;
				}
				writer.print(arr[i][j]+" ");
			}
			writer.println("\n");
		}
	}
	
	public void print2DArray(String arr[][])
	{
		int m=arr.length;
		int n=arr[0].length;
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				print(arr[i][j]+" ");
			}
			println("");
		}
	}
	public void print2DArray(float arr[][])
	{
		int m=arr.length;
		int n=arr[0].length;
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
	public void print2DArray(boolean arr[][])
	{
		int m=arr.length;
		int n=arr[0].length;
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
		if(str == null || str.trim().isEmpty()) {
			throw new IllegalArgumentException("Value can not be Blank or empty");
		}
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
				str = swap("  ", i, j);
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

	
	public long timer(int ch)
	{
		//long start=0, stop, elapsed=0;
			
			if(ch==1)
			{
				return System.currentTimeMillis();
			}
			else
			{
				return System.currentTimeMillis();
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

/*Program for TicTacToe.............................................*/	
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
	
	public char[][] markATick(char [][]gameArray, char ch, int turn)
	{
		if(turn==1)
		{
			print("Enter Position \n row = ");
			int i= getInt();
			print("col = ");
			int j= getInt();
		
			if(gameArray[i][j] == ' ')
			{
				gameArray[i][j] = ch; 
			}
			else
			{
				println("Already marked.......! \n ");
				markATick(gameArray, ch, turn);
			}
		}
		else
		{
			gameArray = computerTick(gameArray, ch);
			
		}
		return gameArray;
	}
	
	public char[][] initGameArray()
	{
		char [][]gameArray= new char[3][3];
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				gameArray[i][j]=' ';
			}
		}
		
		return gameArray;
	}
	
	public boolean isWin(char gameArray[][])

	{
		
		for(int i=0; i<3; i++)
		{
			if( gameArray[0][i]==gameArray[1][i] && gameArray[2][i]== gameArray[0][i] && gameArray[0][i]!= ' ')
			{
				return true;
			}
			if( gameArray[i][0]==gameArray[i][1] && gameArray[i][0]== gameArray[i][2] && gameArray[i][0]!= ' ')
			{
				return true;
			}
		}
		if( gameArray[0][0]==gameArray[1][1] && gameArray[2][2]== gameArray[0][0] && gameArray[0][0]!= ' ')
		{
			return true;
		}
		if( gameArray[0][2]==gameArray[1][1] && gameArray[2][0]== gameArray[0][2] && gameArray[0][2]!= ' ')
		{
			return true;
		}
		return false;
	}
	
	public char[][] computerTick(char gameArray[][], char tick)
	{
		for(int i=0; i<3; i++)
		{
			if( gameArray[0][i]==gameArray[1][i] && gameArray[2][i]== ' ' && gameArray[1][i]!= ' ')
			{
				gameArray[2][i]= tick;
				return gameArray;
			}
			if(gameArray[2][i]== gameArray[0][i] && gameArray[0][i]!= ' '&& gameArray[1][i]== ' ')
			{
				gameArray[1][i]= tick;
				return gameArray;
			}
			if(gameArray[2][i] == gameArray[1][i] && gameArray[0][i]== ' ' && gameArray[1][i]!= ' ')
			{
				gameArray[0][i]= tick;
				return gameArray;
			}
			if( gameArray[i][0]==gameArray[i][1] && gameArray[i][2] == ' ' && gameArray[i][0]!= ' ')
			{
				gameArray[i][2]= tick;
				return gameArray;
			}
			if (gameArray[i][0]== gameArray[i][2] && gameArray[i][1]== ' ' && gameArray[i][0]!= ' ')
			{
				gameArray[i][1]= tick;
				return gameArray;
			}
			if(gameArray[i][1]== gameArray[i][2] && gameArray[i][0]== ' ' && gameArray[i][1]!= ' ')
			{
				gameArray[i][0]= tick;
				return gameArray;
			}
		}
		if( gameArray[0][0]==gameArray[1][1] && gameArray[0][0]!= ' ' && gameArray[2][2]== ' ')
		{
			gameArray[2][2]= tick;
			return gameArray;
		}
		if( gameArray[2][2]== gameArray[0][0] && gameArray[1][1]== ' ' && gameArray[0][0]!= ' ')
		{
			gameArray[1][1]= tick;
			return gameArray;
		}
		if( gameArray[2][2]==gameArray[1][1] && gameArray[0][0]== ' ' && gameArray[2][2]!= ' ')
		{
			gameArray[0][0]= tick;
			return gameArray;
		}
		if( gameArray[0][2]==gameArray[1][1] && gameArray[0][2]!= ' ' && gameArray[2][0]== ' ')
		{
			gameArray[2][0]= tick;
			return gameArray;
		}
		if(gameArray[2][0]== gameArray[0][2] && gameArray[0][2]!= ' '&& gameArray[1][1]== ' ')
		{
			gameArray[1][1]= tick;
			return gameArray;
		}
		if( gameArray[2][0]==gameArray[1][1] && gameArray[0][2]== ' ' && gameArray[2][0]!= ' ')
		{
			gameArray[0][2]= tick;
			return gameArray;
		}
		
		Random rd=new Random();
		//print("Enter Position \n row = ");
		int i= rd.nextInt(3);
		//print("col = ");
		int j= rd.nextInt(3);
	
		if(gameArray[i][j] == ' ')
		{
			gameArray[i][j] = tick; 
		}
		else
		{
			//println("Already marked.......! \n ");
			markATick(gameArray, tick, 0);
		}
		return gameArray;
		
	}
	
	public void ticTacToe()
	{
		char [][]gameArray= initGameArray();
		int move=0;
		char ch1, ch2, turn;
		
		print("\n------Tic-Tac-Toe-----\n");
		print("Enter the User tick symbol : ");
		ch1 = getString().charAt(0);
		print("Enter the Computer tick symbol : ");
		ch2 = getString().charAt(0);
		
		printGameArray(gameArray);
		
		print("Do you want to make first move (y/n) : ");
		turn = getString().charAt(0);
		
		while(move++<9)
		{
			
			switch(turn)
			{
				
			case 'y': println("User Turn........ ");
					  gameArray=markATick(gameArray, ch1, 1);
					  printGameArray(gameArray);
					  if(isWin(gameArray)==true)
					  {
						  print("You win the game.....!\n");
						  return;
					  }  
					  turn='n';
					  break;
					  
			case 'n': 	println("Computer Turn........ ");
						gameArray=markATick(gameArray, ch2, 0);
			  			printGameArray(gameArray);
			  			if(isWin(gameArray)==true)
						  {
							  print("Computer won the game.....!\n");
							  return;
						  } 
			  			turn='y';
			  			break;
			
			default: print("you entered a wrong choice");
			
			}
			
			
		}
		print("Match is draw......!");
		
	}
//.............................................................................	
	 
	
/* Algorithm Programs ..............................................*/	

    public boolean isAnagram(String str1, String str2)
    {
    	str1 = str1.toLowerCase().replaceAll(" ","");
    	
    	str2 = str2.toLowerCase().replaceAll(" ","");
    	
    	char []ch1= str1.toCharArray();
    	char []ch2= str2.toCharArray();
    	
    	//boolean status= false;
    	
    	if(ch1.length != ch2.length)
    	{
    		return false;
    	}
    	Arrays.sort(ch1);
    	Arrays.sort(ch2);
    	
    	if(Arrays.equals(ch1, ch2))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    public int[] getPrime(int range)
    {
    	int  prime[]= new int[range/2], i=1;
    	int count=0;
    	boolean isprime =false;
    	prime[count++] = 1;
    	prime[count++] = 2;
    	while(i < range)
    	{
    		
    		for(int j=2; j<i; j++)
    		{
    			if( i%j==0)
    			{
    				isprime=false;
    				break;
    			}
    			else
    			{
    				isprime=true;
    			}
    		}
    		if(isprime==true)
    		{
    			prime[count++]= i;;
    		}
    		i++;
    	}
    	
    	return prime;
    }
    public int[][] getPrime2D(int range)
    {
    	int  prime2D[][]= new int[range/100][range/10];
    	
    	int prime[]= getPrime(range);
    	int count=0, limit=100;
    	
    	for(int i=0; i<range/100; i++)
    	{
    		for(int j=0;j<range/10;j++)
    		{
    			if(prime[count]>limit || prime[count]==0) 
    			{
    				break;
    			}
    			prime2D[i][j]=prime[count];
    			count++;
    		}
    		limit= limit+100;
    	}
    	
    	           	
    	//printArray(prime);

    	
    	//print2DArray(prime2D, prime2D.length, prime2D[0].length);
    	return prime2D;
    }
    
    public void getPalPrime(int range)
    {
    	
    	int prime[]=getPrime(range);
    	
    	for(int i=0;i < prime.length; i++)
    	{
    		int temp1= prime[i];
    		int rev=0;
    		while(temp1 != 0) 
    		{
                int temp2 = temp1 % 10;
                rev = rev * 10 + temp2;
                temp1 /= 10;
            }
    		if(prime[i]==rev && prime[i]>0)
    		{
    			print(" "+prime[i]);
    		}
    	}
    	
    		
    	
    }
    
    public int[] getAnagramPrime(int range)
    {
    	int prime[]=getPrime(range);
    	int anagram[]=new int[range];
    	int count1=0,count2=0;
    	//String str1[]=new String[prime.length];
    	for(int i=0;i < prime.length; i++)
    	{
    		for(int j=i;j < prime.length; j++)
    		{
    			if(prime[i]>0 && prime[j]>0 && prime[i]!= prime[j])
    			{
    				String s1= Integer.toString(prime[i]);
    				String s2= Integer.toString(prime[j]);
    				if(isAnagram(s1,s2))
    				{
    					count2 = count1+1;
    					anagram[count1]=prime[i];
    					anagram[count2]=prime[j];
    					count1=count2+1;
    				}
    			}
    		}
	    		
    	}
    	//printArray(anagram);
    	/*for(int i=0; i<anagram.length-1; i=i+2)
    	{
    		if(anagram[i]>0)
    		{
    			println(" "+anagram[i]+" "+anagram[i+1]);
    		}
    	}
    		*/
    	//printArray(anagram);
    		return anagram;
    }
    
    public int[][] getAnagram2DPrime(int range)
    {
    	
    	int anagram[]= getAnagramPrime(range);
    	int anagram2D[][] = new  int[range/100][range/10];
    	int limit=0, count1=0, count2=0;
    	
		for (int j = 0; j < anagram2D.length; j++) 
		{
			for (int i = 0; i < anagram.length - 1; i = i + 2) 
			{
				if (anagram[i] > limit && anagram[i + 1] > limit && anagram[i] < (limit + 100)
						&& anagram[i + 1] < (limit + 100)) 
				{
					anagram2D[j][count2] = anagram[i];
					anagram2D[j][count2 + 1] = anagram[i + 1];
					count2 = count2 + 2;
				}
			}
			limit=limit+100;
		}
		print2DArray(anagram2D);
    	return anagram2D;
    	
    }
    
    
    
    public static boolean binarySearch(int searchEle, int arr[])
    {
    	
    	int low=0, high= arr.length;
    	int mid = 0;
    	arr = bubbleSort(arr);
    	
    	while(high>=low)
    	{
    		mid = (low+high)/2;
    		
    		if(arr[mid]==searchEle)
    		{
    			//print("Element is found at "+mid);
    			return true;
    		}
    		else if(arr[mid] > searchEle)
    		{
    			high = mid-1;
    		}
    		else
    		{
    			low = mid+1;
    		}
    				
    	}
    	//print("Element is not found");
    	return false;
    }
    public static boolean binarySearch(String searchEle, String arr[])
    {
    	
    	int low=0, high= arr.length;
    	int mid = 0;
    	//arr = bubbleSort(arr);
    	int i=-1;
    	while(high>=low)
    	{
    		mid = (low+high)/2;
    		i++;
    		if(arr[mid].equals(searchEle))
    		{
    			//print("Element is found at "+mid);
    			return true;
    		}
    		else if(arr[mid].charAt(i) > searchEle.charAt(i) && i< arr[mid].length() && i< searchEle.length())
    		{
    			high = mid-1;
    			i=0;
    			//break;
    		}
    		else if(arr[mid].charAt(i)< searchEle.charAt(i)&& i< arr[mid].length() && i< searchEle.length())
    		{
    			low = mid+1;
    			i=0;
    			//break;
    		}
    		
    				
    	}
    	//print("Element is not found");
    	return false;
    }
    
    
    public static int[] insertionSort(int arr[])
    {
    	for(int i=1; i<arr.length; i++)
    	{
    		for(int j=i; j>0; j--)
    		{
    			if(arr[j-1]>arr[j])
    			{
    				int temp = arr[j];
    				arr[j]=arr[j-1];
    				arr[j-1]=temp;
    			}
    		}
    	}
    	//printArray(arr);
    	return arr;
    }
    public static String[] insertionSort(String arr[])
    {
    	for(int i=1; i<arr.length; i++)
    	{
    			int j=i-1;
    			String key=arr[i];
    			while (j >= 0 && key.compareTo(arr[j]) < 0) 
    			{
    	            arr[j+1] = arr[j];
    	            j--;
    	        }
    			arr[j+1] = key;
    	}
    	//printArray(arr);
    	return arr;
    }
    
    public static int[] bubbleSort(int arr[])
    {
    	int n= arr.length;
    	for(int i=0; i<n-1; i++)
    	{
    		for(int j=0; j<n-i-1; j++)
    		{
    			if(arr[j]>arr[j+1])
    			{
    				int temp = arr[j];
    				arr[j]=arr[j+1];
    				arr[j+1]=temp;
    			}
    		}
    		//n--;
    	}
    	//printArray(arr);
    	return arr;
    }
    
    public static String[] bubbleSort(String arr[])
    {
    	int n= arr.length;
    	for (int i=0; i<n-1; i++) 
        { 
            for (int j=i+1; j<n; j++) 
            { 
                if (arr[i].compareTo(arr[j]) > 0) 
                { 
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]=temp;
                } 
            } 
        } 
    	//printArray(arr);
    	return arr;
    }
    
 
    public void merge(int []arr, int low, int mid, int high)
    {	 
            int n1 = mid-low + 1; 
            int n2 = high-mid; 
      
            int L[] = new int [n1]; 
            int R[] = new int [n2]; 
      
            for (int i=0; i<n1; ++i) 
                L[i] = arr[low + i]; 
            for (int j=0; j<n2; ++j) 
                R[j] = arr[mid + 1+ j]; 
      
      
            int i = 0, j = 0; 
       
            int k = low; 
            while (i < n1 && j < n2) 
            { 
                if (L[i] <= R[j]) 
                { 
                    arr[k] = L[i]; 
                    i++; 
                } 
                else
                { 
                    arr[k] = R[j]; 
                    j++; 
                } 
                k++; 
            } 
      
            while (i < n1) 
            { 
                arr[k] = L[i]; 
                i++; 
                k++; 
            } 
      
            while (j < n2) 
            { 
                arr[k] = R[j]; 
                j++; 
                k++; 
            } 
        } 
      
         
    public int[] mergeSort(int []arr, int low, int high)
    {
    	
    	if(low<high)
    	{
    		int mid = low+((high-low)/2);
    		mergeSort(arr, low, mid);
    		mergeSort(arr, mid+1, high);
    		merge( arr, low, mid, high);
    	}
    	
    	//printArray(arr);
    	return arr;
    }
	
    
    public void guessANum(int low, int high)
    {
    	int mid=(high+low)/2;
    	
    	if(high<=low)
    	{
    		print("\n Is your number is even number :");
    		char ch=getString().charAt(0);
    		if(ch=='Y'|| ch=='y')
    		{
    		
    			print("\n Your number should be: "+high);
    		
    		}
    		else
    		{
    			print("\n Your number should be: "+(low+1));
    		}
    	}
    	else
    	{
    		print("\n Is you number is between "+low+"-"+mid+" : ");
    		char ch=getString().charAt(0);
    		
    		if(ch=='y' || ch=='Y')
    		{
    			guessANum(low, mid-1);
    		}
    		else
    		{
        		guessANum(mid+1, high);
        	
    		}
    	}
    	
    	
    }
    
 
    
    public int[][] vendingMachine(int change)
    {
    	
    	int [][]arr= { {1,0}, {2,0}, {5,0}, {10,0}, {50,0}, {100,0}, {500,0}, {1000,0}};
    	//print(""+arr.length);
    	int count=0;
    	if(change >= arr[arr.length-1][0])
    	{
    		int temp = change%arr[arr.length-1][0];
    		arr[arr.length-1][1]= (change-temp)/arr[arr.length-1][0];
    		change=temp;
    		count =arr[arr.length-1][1];
    	}
    	while(change>0)
    	{
    			for(int i=0;i<arr.length-1; i++)
    			{
    				if(arr[i][0]<= change && change<arr[i+1][0])
    				{
    					int temp = change%arr[i][0];
    					arr[i][1]= (change-temp)/arr[i][0];
    					change=temp;
    					count =count+arr[i][1];
    					//print(" "+change);
    				}
    			}
    		
    	}
    	//vendingMachine(change);
    	
    	print2DArray(arr);
    	return arr;
    }
    
    
    public int vendingMachine2(int change)
    {
    	
    	int []arr= {1000, 500, 100, 50, 20, 10, 5, 2, 1};
    	
    	int count=0;
    	
    	if(change==0)
    	{
    		return -1;
    	}
    	
    	for(int i=0;i<arr.length; i++)
    	{
    		if(arr[i]<= change)
   			{
    			int temp = change%arr[i];
    			int count2= (change-temp)/arr[i];
    			print("Total Notes used  : ");
    			println(arr[i]+" * "+count2+" = "+(arr[i]*count2));
    			count = count + count2;
    			change=temp;
   				return vendingMachine2(change);
    			
    		}
    	}
    	
    	//print2DArray( arr, 8, 2);
    	return count ;
    }
   
    
    public static int dayOfWeek(int dd, int mm, int yy)
    {
    	//int[]day =;l
    	
    	int y0 = yy-((14 - mm)/12);
    	int x = y0 + (y0/4) - (y0/100) + (y0/400);
    	int m0 = mm +12*((14 - mm)/ 12)-2;
    	int d0 = (dd + x + (31* m0) / 12)%7;

    	return d0;
    }
    
    
    public static double temperatureConversion(double temp, String ch)
    {
    	
    	if(ch.equals("C"))	
    	{
    		temp = (temp*9/5)+32;
    		return temp;
    	}
    	else if(ch.equals("F"))
    	{
    		temp = ((temp-32)*5)/9;
    		return temp;
    	}
    	else
    	{
    		System.out.println("Error Encountered");
    		return -1;
    	}
    	
    }
    
    
    public static double monthlyPayment(int P, int Y, float R)
    {
    	
    	int n =12*Y;
    	double r= R/(12*100);
    	
    	double payment = (P*r)/(1-Math.pow((1-r), -n));
    	
    	return payment;
    	
    }
    
    
    public static double sqrt(int c)
    {
    	double epsilon= 1e-15;
    	double t=c;
    	while(Math.abs(t-(c/t))>(epsilon * t))
    	{
    		t = (t+(c/t))/2;
    	}
    	//System.out.print(""+t);
    	return t;
    }
    
    public static int[] toBinary(int num)
    {
    	int temp[]= new int[32];
    	int i=0;
    	while(num>0)
    	{
    		temp[i++] = num%2;
    		num = num/2;
    	}
    	
    	return temp;
    }
    
    
    public int[] swapNibble(int arr[])
    {
    	int count =0;
    	/*printArray(arr);*/
    	while(count++<4)
    	{
    		int temp=arr[arr.length-1];
    		for(int i=arr.length-1; i>0; i--)
    		{
    			arr[i]=arr[i-1];
    		}
    		arr[0]=temp;
    	}
    	/*printArray(arr);*/
    	
    	/*toDecimal(arr);*/
    	return arr;
    }
    
    public int toDecimal(int arr[])
    {
    	int sum=0;
    	for(int i=arr.length-1; i>=0; i--)
		{
    		
    		sum= (int) (sum+(Math.pow(2,i)*arr[i]));
    		println((int)Math.pow(2,i)+" * "+arr[i]);
    		
		}
    	print("\n "+sum+"");
    	return sum;
    }
    
    
    public void jobScheduler(Jobs jobs[])
    {
    	int n= jobs.length;
    	
    	for(int i = 1; i < n; i++)
    	{
    		for(int j=0; j < n - i; j++)
    		{
    			if(jobs[j+1].deadLine < jobs[j].deadLine) 
    			{
    				Jobs temp = jobs[j+1];
    				jobs[j+1] = jobs[j];
    				jobs[j] = temp;
    			}
    		}
    	}
    	
    	int maxTime = jobs[n-1].deadLine*60;
    	
    	int completionTime = jobs[0].completionTime;
    	//int deadLine = jobs[0].completionTime;
    	print("\n The scheduled jobs are : \n ");
    	print("Job"+jobs[0].label+">>");
    	
    	for(int i=1; i<n; i++)
    	{
    		int deadLine = (jobs[i].deadLine*60)-completionTime; 
    		if((jobs[i].deadLine*60) > completionTime && (jobs[i].completionTime)<deadLine && maxTime>= completionTime)
    		{
    			print("Job"+jobs[i].label+">>");
    			completionTime= completionTime+ jobs[i].completionTime;
    			
    		}
    			
    	}
    	
    	
    	/*for(int i=1; i<=n; i++)
    	{
    		System.out.print("\n Job "+i+"Deadline : "+jobs[i-1].deadLine);
    		 
    		
    		System.out.println("\n Job "+i+"Time to Complete : "+jobs[i-1].completionTime);

    	}*/
    	
    }
    
 
/*****************************Algorithm End*****************/
    
/***************************Data Structure*****************/
    
	 public  String[][] getMonthCalender(int month, int year)
	 {
	    
		 String []days= {"\t S","\t M","\tTu", "\t W","\tTh", "\t F", "\tSa"};
		
		 int day=Utility.dayOfWeek(1, month, year);
		
		 int Month[] ={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		
		 String MonthString[]={"January", "February", "March", "April", "May", "June", "July", 
								"August", "September", "October", "November", "December" };
		
		 if(isLeapYear(year))
		 {
			 Month[1]=29;
		 }
		
		 int weeks= (int)((Month[month-1]+day)/7)+1;
		
		 String calender[][]= new String[weeks][days.length];
		
		 int date=1;
		 int i=0;
		 
		 print("\n\t\t "+MonthString[month-1]+"\t "+year);
		 println("\n\t--------------------------------------------------");
		
		 printArray(days);
		
		
		 println("\n\t--------------------------------------------------");
		
		
		 while(i<day)
		 {
			 calender[0][i]="\t";
			 i++;	
		 }
		
		 i=day;
		
		 for(int j=0; j<weeks; j++)
		 {
			 for(; i<days.length; i++)
			 {
				 if(date<=Month[month-1]) 
				 {
					 calender[j][i]="\t"+date;
					 date++;
				 }
				 else
				 {
					 calender[j][i]="\t";
				 }
			 }
			 
			 i=0;
		 }
		 
		 return calender;
	 
	}
    
    
    
    public static void main(String []args)
	{
		Utility u = new Utility();
	
		u.getAnagram2DPrime(1000);
		
		//String arr[]= {"aksh","swap","good","bad", "john","abcd"};
		
		//int d= u.factorial(5);
		//u.print(""+d);
		//u.printArray(arr);
	}

	

}

