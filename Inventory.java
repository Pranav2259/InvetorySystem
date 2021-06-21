package basics;
import java.util.*;
import java.io.*;
abstract class AbstractMethods
	{
	abstract void signUp();
	abstract void purchase_item();
	}
	class User extends AbstractMethods
	{
		String ufname,uname;
		String pass,age;
		int tno,mtchoice,mchoice;
		void signUp()
	{
			Scanner u = new Scanner(System.in);
			try   //exception handling for new user signUp
{
File f = new File("signUp.txt");    //file name in ""
FileWriter fout = new FileWriter(f);
BufferedWriter bout = new BufferedWriter(fout);
//taking user info
System.out.print("\nYour Full Name is = ");
ufname = u.nextLine();
bout.write(ufname);
bout.newLine();
System.out.print("\nNow Please make a Username: ");
uname = u.next();
bout.write(uname);
bout.newLine();
System.out.print("\nCreate a Password = ");
pass = u.next();
bout.write(pass);
bout.newLine();
System.out.print("\nEnter Your Age = ");
age = u.next();
bout.write(age);
bout.newLine();
System.out.print("\n\n\t--- Thanks for your sign up ---");
bout.close();//closing file here
}
catch(Exception e)
{
e.printStackTrace();
}
}
void purchase_item()
{
Scanner b = new Scanner(System.in);
try
{
BufferedReader bin = new BufferedReader(new FileReader("signUp.txt"));//opening file here
System.out.print("\n\t--- Please fill the Follwings --->\n");
System.out.print("\nEnter Username = ");
String username = b.nextLine();
System.out.print("\nEnter Your Passcode = ");
String upass = b.next();
/*String checkuname = bin.readLine();
String checkpass = bin.readLine();
if((username==checkuname)&&(upass==checkpass))//checking user have account or not
{*/
System.out.print("\n\t~~ Welcome to Inventory Management System~~\n");
System.out.print("\n --- Select Item ---");

}
catch(Exception eb)
{
eb.printStackTrace();
}
}
}class Inventory
{
public static void main(String args[])
{
Scanner cH = new Scanner(System.in);
int ch;
System.out.print("\n\t~~~~~~~~~~~~~~~~~~~~~~");
System.out.print("\n\t\t\tInventory Management System");
System.out.print("\n\t----------------------------------------------------------------");
System.out.print("\n\t\t Batch: CSE-CS9 | 2nd Semester | (Year 2021)");
System.out.print("\n\t Group Members - Tanmaya, Himanshu, Prerna, Pranav");
System.out.print("\n\t~~~~~~~~~~~~~~~~~~~~~~\n");
do
{
System.out.print("\n\n ----- Menu -----");
System.out.print("\n 1. New User / Sign Up \n 2. Purchase Item  \n 3. Add Item  \n 4. Delete Item  \n 5. Update Item \n 6. Exit");
System.out.print("\n\nEnter your Choice -> ");
ch = cH.nextInt();
switch(ch)
{
case 1:
User us = new User();
us.signUp();
break;
case 2:
User purchase = new User();
purchase.purchase_item();
break;
default:
System.out.print("\n\t--- Hope You Enjoyed Your Day! ---");
}
}while(ch!=6);
}
}