
class Adder1
{  
static int add(int a, int b)
{
	return a+b;
	}  
static double add(double a, double b)//in Cimpile time Polymorphism(Method Overloading) we cannot write same arguments 
                                     //in the second method 
{
	
	return a+b;}  
}  
class Adder{  
public static void main(String[] args){  
System.out.println(Adder1.add(11,11));  
System.out.println(Adder1.add(12.3,12.6));  
}}

//If there are no matching type arguments in the method, and each 
//method promotes similar number of arguments 
//with only exchanging the types ex. line number 27 and31
//there will be ambiguity.


//Example Of ambiguity
/*class OverloadingCalculation{  
  void sum(int a,long b)
  {
  System.out.println("a method invoked");
  }  
  void sum(long a,int b)
  {
  System.out.println("b method invoked");
  }  //ambiguity error
  
  public static void main(String args[]){  
  OverloadingCalculation obj=new OverloadingCalculation();  
  obj.sum(20,20);//now ambiguity  
  }  
}  */