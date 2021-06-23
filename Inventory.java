package basics;
import java.util.*;
import java.io.*;

class Inventory
{
private static String medicine;
private static String stationary;
public static void main(String args[])
{   
    Object k=loadList("userDetail.obj");
    User.userDetail=(ArrayList<User>)k;
    User.userDetail=new ArrayList<User>();
    Menu1();
}
static void Menu1(){
    Scanner cH = new Scanner(System.in);
int ch;
System.out.print("\n\t~~~~");
System.out.print("\n\t\t\tInventory Management System");
System.out.print("\n\t----------------------------------------------------------------");
System.out.print("\n\t\t Batch: CSE-CS9 | 2nd Semester | (Year 2021)");
System.out.print("\n\t Group Members - Tanmaya,Himanshu,Prerna,Pranav");
System.out.print("\n\t~~~~\n");
System.out.print("\n\n ----- Menu -----");
System.out.print("\n 1. New User / Sign Up \n 2. Purchase Item  \n 3. Exit");
System.out.print("\n\nEnter your Choice -> ");
ch = cH.nextInt();
switch(ch)
{
case 1:
Register();
break;
case 2:
login();
break;
case 3:
System.exit(0);
break;
default:{
System.out.print("\n\twrong choice...");
Menu1();}
}
}
static void saveList(Object o,String s)
{
    try{
        File f=new File(s);
        FileOutputStream op=new FileOutputStream(f);
        ObjectOutputStream oos=new ObjectOutputStream(op);
        oos.writeObject(o);
        System.out.println("file saved succesfuly");
        
    }catch(Exception e){
      System.out.println(e);
      e.printStackTrace();    
     }
}
static Object loadList(String s)
{
  try{
        File f=new File(s);
        FileInputStream op=new FileInputStream(f);
        ObjectInputStream oos=new ObjectInputStream(op);
        Object o=oos.readObject();
        System.out.println("file read succesfuly");
        return o;
    }catch(Exception e){
      System.out.println(e);
      return null;
    }
}
public static void Register(){
    User A=new User();
    User.userDetail.add(A);
    saveList(User.userDetail,"userDetail.obj");
    Menu1();
  }
  public static void login(){
    Scanner sc=new Scanner(System.in);
    String x;
    String y;
    System.out.println("enter your username : ");
    x=sc.next();
    System.out.println("Enter your passowrd : ");
    y=sc.next();
    if(x.equals(User.userDetail.get(0).username)&& y.equals(User.userDetail.get(0).pass))
      purchase_item();    
      else
    {
      System.out.println("Wrong username and password entered ");
      login();
    }
  }
  static void purchase_item()
    { 
	  try {
        		Scanner sc = new Scanner(System.in);
            File f1 = new File("tData.txt");
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
            System.out.print("\nLogin Successful \n SELECT Type ---> ?");
            System.out.print("\n1. medicine \n2. stationary");
            System.out.print("\n\nEnter Your Choice -> ");
            int mtchoice;
            mtchoice = sc.nextInt();
            int sum=0;
            int qt;
            switch(mtchoice)
            {
                case 1:
                    {System.out.print("\n--- Available medicine | Select ---> ?\n");
                    System.out.print("\n1. PCM \n2. AVIL \n3. CITRIZEN");
                    System.out.print("\n\nEnter Choice -> ");
                    int mchoice;
                    mchoice = sc.nextInt();
                    switch(mchoice)
                    {
                        case 1:
                            {medicine = "PCM(Rs.100)";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt();
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*100);
                            System.out.print("\n Total Amount to be paid:"+sum);}
                            break;
                        case 2:
                            {medicine = "AVIL(Rs.100)";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt();
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*100);}
                            break;
                        case 3:
                            {medicine = "CITRIZEN(Rs.100";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt(); 
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*100);
                            }
                            break;
                        default:
                            System.out.print("\n\t.... medicine ....");
                    }
                    bw1.write("Inventory Type - medicine | medicine Name: "+medicine+"\n");}
                    break;
                case 2:
                    {System.out.print("\n--- Available stationary | Select ---> ?\n");
                    System.out.print("\n1. pen \n2. books \n3. paper clip");
                    System.out.print("\n\nEnter Choice -> ");
                    int mchoice;
                    mchoice = sc.nextInt();
                    switch(mchoice)
                    {
                        case 1:
                            {stationary = "pen(Rs.10)";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt();
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*10);
                            System.out.print("\n Total Amount to be paid:"+sum);}
                            break;
                        case 2:
                            {stationary = "books(Rs.100)";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt();
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*100);
                            System.out.print("\n Total Amount to be paid:"+sum);}
                            break;
                        case 3:
                            {stationary = "paper clip(Rs.10)";
                            System.out.print("\n quantity---> ?");
                            qt = sc.nextInt();
                            bw1.write("quantity = "+qt+"\n");
                            sum=sum+(qt*10);
                            System.out.print("\n Total Amount to be paid:"+sum);}
                            break;
                        default:
                            System.out.print("\n\t.... stationary ....");
                    }
                    bw1.write("Inventory Type - stationary | stationary: "+stationary+"\n");
                    bw1.write("amount to be paied for inventory"+sum);}
                    break;
                case 3:
                {
                    System.out.print("\n\tThanks for visiting");
                }
                break;
                default:
                    System.out.print("\n\n\t\t** Invalid Choice **");
            }
        }
        catch(Exception e)
        {
            System.out.println();
            e.printStackTrace();
        }
    }}
 class User implements Serializable
    { 
      private static final long serialVersionUID=1L;
      String name;
      String username;
      String pass;  
      static ArrayList<User> userDetail= new ArrayList<User>();
    
      User()
      {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your name : ");
        name=sc.next();
        System.out.println("enter your username  : ");
        username=sc.next();
        System.out.println("Create your password : ");
        pass=sc.next();
        System.out.println("Registration Successful");
        userDetail.add(this);
      }
    }
