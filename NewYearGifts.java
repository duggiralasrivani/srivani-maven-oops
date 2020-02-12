package Task2;
import java.util.*;

public class NewYearGifts {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Chochy> chochys=new ArrayList<Chochy>();
	static ArrayList<Chochy> candies=new ArrayList<Chochy>();
	static ArrayList<Sweety> sweets=new ArrayList<Sweety>();
	static HashMap<String,Integer> nameTowght=new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToCost=new HashMap<String,Integer>();
	static int sweetywght,sweetycost;
	//using comparator
	public static void main(String[] args)
	{
		inputchochys();
		inputSweets();
		System.out.println("sum of the wgt of the gift is:"+TotalCalculate());
		System.out.println("What type of sort do you want ? : 1. By Prices 2. By Wghts");
		             int sortproc=sc.nextInt();
		if(sortproc==1)
		{
			Comparator<Chochy> compareByPrice=(Chochy a,Chochy b)->((Integer)a.getPrice()).compareTo(b.getPrice());
			Collections.sort(chochys,compareByPrice);
		}
		else
		{
			Comparator<Chochy> compareByWeight=(Chochy a,Chochy b)->((Integer)a.getWeight()).compareTo(b.getWeight());
			Collections.sort(chochys,compareByWeight);
		}
		System.out.println("Results of sorting  is");
		for(Chochy chochy: chochys)
		{
			System.out.println(chochy.getPrice());
		}
		calRangeofPrices(sortproc);
	}
	//sweets inputs
	public static void inputSweets()
	{
		
		System.out.println("press the no of sweets in gifts you want:\n");
		int noOfsweetys=sc.nextInt();
		for(int sweercnt=1; sweercnt<=noOfsweetys;sweercnt++)
		{
			System.out.println("Enter the Sweety type(Enter the number): 1.halwa 2.Gulabjamun 3.kaja ");
			System.out.println("press the wght of the Sweety you want");
			int sweetywght=sc.nextInt();
			System.out.println("press the price of the Sweety you want");
			int sweetycost=sc.nextInt();
			Sweety Sweety=new Sweety(sweetywght,sweetycost);
			sweets.add(Sweety);
		}
	}
	public static int TotalCalculate()
	{
		int totwght=0;
		for(Chochy choco: chochys)
		{
			totwght+=choco.getWeight();
		}
		for(Sweety Sweety:sweets)
		{
			totwght+=Sweety.getWeight();
		}
		return totwght;
	}
	public static void inputchochys()
	{
		System.out.println("press the no of chochys in gifts you want:\n");
		int countofchochys=sc.nextInt();
		for(int Countofchocos=1; Countofchocos<=countofchochys;Countofchocos++)
		{
			System.out.println("press the chochytype : 1. 5star 2.dairymilk 3.kitkat");
		             	int chochyType=sc.nextInt();
			System.out.println("Enter the wght of the chochy you want");
			            int chochywght=sc.nextInt();
			System.out.println("Enter the price of the Chochy you want");
			int chochyCost=sc.nextInt();
			if(chochyType==1)
			{
				System.out.println("press the name of the candy you want");
				String namOfCandy=sc.next();
				if(nameTowght.containsKey(namOfCandy))
				{
					nameTowght.put(namOfCandy,(int)nameTowght.get(namOfCandy)+chochywght);
				}
				else 
					nameTowght.put(namOfCandy,chochywght);
				if(nameToCost.containsKey(namOfCandy))
				{
					nameToCost.put(namOfCandy,(int)nameToCost.get(namOfCandy)+chochyCost);
				}
				else
					nameToCost.put(namOfCandy,chochyCost);
			}
			Chochy choco =new Chochy(chochywght,chochyCost);
			chochys.add(choco);
			if(chochyType==1)
			{
				candies.add(choco);
			}
		}
	}
	public static void calRangeofPrices(int sortproc)
	{
		Scanner sc=new Scanner(System.in);
	   System.out.println("Range calculations:");
	   int lowrange,highrange;
	   if(sortproc==1)
	   {
		   System.out.println("press the lowrange of the price:");
		   lowrange=sc.nextInt();
		   
		   System.out.println("press the highrange of the price");
		   highrange=sc.nextInt();
		   
		   Set<Map.Entry<String,Integer>> candySet=nameToCost.entrySet();
		   Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
		   while(candyIterator.hasNext())
		   {
			   Map.Entry candyElement=(Map.Entry)candyIterator.next();
			   int presentPrice=(int)candyElement.getValue();
			   if(presentPrice>= lowrange && presentPrice<=highrange)
				   System.out.println(candyElement.getKey());
		   }
	   }
	   else
	   {
		   System.out.println("press the lowrange of the weight:");
		   lowrange=sc.nextInt();
		   System.out.println("press the highrange of the weight:");
		   highrange=sc.nextInt();
		   Set<Map.Entry<String,Integer>> candySet=nameTowght.entrySet();
		   Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
		   while(candyIterator.hasNext())
		   {
			   Map.Entry candyElement=(Map.Entry)candyIterator.next();
			   int currwght=(int)candyElement.getValue();
			   if(currwght>= lowrange && currwght<=highrange)
				   System.out.println(candyElement.getKey());
		   }
		   
	   }
	}
}
