
class ConstructorChaining
{   
    public String empName;
    public int empSalary;
    public String address;

    //default constructor of the class
    public ConstructorChaining()
    {
    	//this will call the constructor with String param
        this("Pramila");
    }

    public ConstructorChaining(String name)
    {
    	//call the constructor with (String, int) param
    	this(name, 120035);
    }
    public ConstructorChaining(String name, int sal)
    {
    	//call the constructor with (String, int, String) param
    	this(name, sal, "Mumbai");
    }
    public ConstructorChaining(String name, int sal, String addr)
    {
    	this.empName=name;
    	this.empSalary=sal;
    	this.address=addr;
    }

    void disp() {
    	System.out.println("Employee Name: "+empName);
    	System.out.println("Employee Salary: "+empSalary);
    	System.out.println("Employee Address: "+address);
    }
    public static void main(String[] args)
    {
    	ConstructorChaining obj = new ConstructorChaining();
        obj.disp();
    }
}