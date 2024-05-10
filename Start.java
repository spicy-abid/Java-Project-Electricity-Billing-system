import java.lang.*;
import Classes.*;
import Fileio.*;
import Interfaces.*;
import java.util.Scanner;
public class Start
{
	public static void main(String args[])
	{
		Scanner input= new Scanner(System.in);
		ElectricityBill eb= new ElectricityBill();
		User u=new User();
		NESCO n= new NESCO();
		FileReadWriteDemo frwd=new FileReadWriteDemo();
		
		System.out.println("_________________________________________________");
		System.out.println("      			WELCOME       "); 
		System.out.println("HERE YOU CAN SEE YOUR ELECTRICITY BILL AND Payment ");
		System.out.println("_________________________________________________");
		
		boolean repeat =true;
		while(repeat)
		{
			System.out.println("Here is your option:");
			System.out.println("\t1. User Management");
			System.out.println("\t2. User Bill Mangement");
			System.out.println("\t3. Bill Pyament and slip");
			System.out.println("\t4. Exit");
			
			System.out.println();
			System.out.print("Please select your option: ");
			int option = input.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("_________________________________________________");
					System.out.println("You have chose User Management");
					System.out.println("_________________________________________________");
					
					System.out.println();
					System.out.println("You have the following options:");
					System.out.println("\t1. Register New user");
					System.out.println("\t2. Remove Existing user");
					System.out.println("\t3. Search an user");
					System.out.println("\t4. Show All user");
					System.out.println("\t5. Go Back");
					
					System.out.println();
					System.out.print("Enter you option: ");
					int option1 = input.nextInt();
					switch(option1)
					{
						case 1:
							System.out.println("____________________________________________");
							System.out.println("You have chose to Register New User");
							System.out.println("____________________________________________");
							
							System.out.print("Enter User ID: ");
							int userid1 = input.nextInt();
							System.out.print("Enter User Name: ");
							input.nextLine();
							String name1 = input.nextLine();
							
							
							User c1 = new User(userid1, name1);
							
							if(eb.insertUser(c1))
							{
								System.out.println("User " + c1.getUserId() + " has been Inserted");
							}
							else
							{
								System.out.println("User " + c1.getUserId() + " Can NOT be Inserted");
							}
							System.out.println();
							break;
							
						case 2:
							System.out.println("____________________________________");
							System.out.println("You have chose to Remove an User");
							System.out.println("____________________________________");
							
							System.out.print("Enter an User ID for Removing: ");
							int empId2 = input.nextInt();
							
							User e2 = eb.searchUser(empId2);
							
							if(e2 != null)
							{
								System.out.println("### User Found for Removing ###");
								if(eb.removeUser(e2))
								{
									System.out.println("User " + e2.getUserId() + " has been Removed");
								}
							}
							else 
							{
								System.out.println("### User NOT Found and Can NOT be Removed ###");
							}
							System.out.println();
							break;
							
						case 3: 
						
							System.out.println("____________________________________");
							System.out.println("You have chose to Search an User");
							System.out.println("____________________________________");
							
							System.out.print("Enter an User ID for searching: ");
							int empId3 = input.nextInt();
							
							User e4 = eb.searchUser(empId3);
							
							if(e4 != null)
							{
								System.out.println("### User Found ###");
								System.out.println("User ID: " + e4.getUserId());
								System.out.println("User Name: " + e4.getName());
								
							}
							else
							{
								System.out.println("### User NOT Found ###");
							}
							System.out.println();
							break;
							
						case 4:
							
							System.out.println("___________________________________________");
							System.out.println("You have chose to Show All User");
							System.out.println("___________________________________________");
							
							eb.showAllUser();
							
							break;
							
						case 5:
						
							System.out.println("___________________________________________");
							System.out.println("You have chose to Go Back");
							System.out.println("___________________________________________");
							break;
							
						default:
						
							System.out.println("___________________________________________");
							System.out.println("Invalid Option");
							System.out.println("___________________________________________");
							break;
					}
					System.out.println();
					
					break;
					
					
				case 2:
					System.out.println("___________________________________________");
					System.out.println("You have chose User Bill Management");
					System.out.println("___________________________________________");
					
					System.out.println();
					System.out.println("You have the following options:");
					System.out.println("\t1. Insert New MeterNumber and Unit for User Bills");
					System.out.println("\t2. Show all Meter Bill of a User");
					System.out.println("\t3. Go Back");
					
					System.out.println();
					System.out.print("Enter you option: ");
					int option2 = input.nextInt();
					
					switch(option2)
					{
						case 1:
						
							System.out.println("________________________________________________________________");
							System.out.println("You have chose to Insert New MeterNumber and Unit for User Bills");
							System.out.println("________________________________________________________________");
							
							System.out.print("Enter Valid USER ID: ");
							int userid1 = input.nextInt();
							
							User c1 = eb.searchUser(userid1);
							
							if(c1 != null)
							{
								System.out.println("### Valid User ###");
								System.out.println("At present only NESCO Meter is available");
								System.out.println("\t1. NESCO METER");
								System.out.println("\t2. Go Back");
								System.out.println();
								
								System.out.print("Your Type: ");
								int type = input.nextInt();
								
								Meter a = null;
								
								if(type == 1)
								{
									System.out.println("_______________________________________");
									System.out.println("Creating a NESCO METER Account");
									System.out.println("_______________________________________");
									
									System.out.print("Enter METER Number : ");
									int an = input.nextInt();
									System.out.print("Enter METER USER Name : ");
									input.nextLine();
									String ahn = input.next();
									System.out.print("Enter METER UNIT : ");
									double bl = input.nextDouble();
									
									 n= new NESCO(an, ahn, bl);
									
									
									a=n;
								}
								else if(type == 2)
								{
									System.out.println("____________________________________");
									System.out.println("Going Back.....");
									System.out.println("____________________________________");
								}
								else
								{
									System.out.println("____________________________________");
									System.out.println("Invalid Type");
									System.out.println("____________________________________");
								}
								
								if(a != null)
								{
									if(c1.insertMeter(a))
									{
										System.out.println("Meter "+ a.getMeterNumber()+" has been inserted for " + c1.getUserId());
									}
									else
									{
										System.out.println("Meter "+ a.getMeterNumber()+" can NOT be inserted for " + c1.getUserId());
									}
								}
							}
							else
							{
								System.out.println("### Invalid User..Please enter your valid user id otherwise Meter Can NOT Create Meter Id ###");
							}
							System.out.println();
							break;
							
						case 2:
							
							System.out.println("____________________________________________________________");
							System.out.println("You have chose Show all Meter Bill of a User");
							System.out.println("____________________________________________________________");
							
							System.out.print("Enter User ID: ");
							int userid4 = input.nextInt();
							
							User c4 = eb.searchUser(userid4);
							
							if(c4 != null)
							{
								c4.showDetails();
								c4.showAllMeter();
							}
							else
							{
								System.out.println("### Invalid User ###");
							}
							System.out.println();
							break;
							
						case 3:
						
							System.out.println("___________________________________________");
							System.out.println("You have chose to Go Back");
							System.out.println("___________________________________________");
							break;
							
						default:
						
							System.out.println("___________________________________________");
							System.out.println("Invalid Option");
							System.out.println("___________________________________________");
							break;
					}
					System.out.println();
					break;
					
					
				case 3:
					
					System.out.println("____________________________________");
					System.out.println("You have chose Meter Bill");
					System.out.println("____________________________________");
					
					System.out.println();
					System.out.println("You have the following options:");
					System.out.println("\t1. PAY the BILL");
					System.out.println("\t2. Print THE ELECTRICITY BILL");
					System.out.println("\t3. Go Back");
					
					System.out.println();
					System.out.print("Enter you option: ");
					int option3 = input.nextInt();
					
					switch(option3)
					{
						
						case 1:
						
							System.out.println("____________________________________");
							System.out.println("You have chose to Payment option");
							System.out.println("____________________________________");
							
							System.out.print("Enter Valild User ID: ");
							int userid2 = input.nextInt();
							
							User c2 = eb.searchUser(userid2);
							
							if(c2 != null)
							{
								System.out.println("### Valid User ###");
								
								System.out.print("Enter Meter Number : ");
								int an = input.nextInt();
							
								Meter a = c2.searchMeter(an);
								
								if(a != null)
								{
									
									System.out.println("### Valid Meter ###");
									
									System.out.println();
									System.out.println("You have to pay this amount : " + n.BillOperation());
									
									System.out.print("Enter Your money Amount: ");
									double am = input.nextDouble();
									
									if(n.AfterPayment(am))
									{ 
									
										System.out.println("### Payment Successfull ###");
										System.out.println("New Bill : " + n.getBill());
										
										frwd.writeInFile(c2.getUserId() + " has Pay amount " + am + "Tk from Meter number " + a.getMeterNumber());
									}
									else
									{
										System.out.println("### Invalid Amount ###");
									}									
								}
								else
								{
									System.out.println("### Invalid Meter Number ###");
								}
							}
							else
							{
								System.out.println("### Invalid User (Please write a valid user Id ###) ");
							}
							System.out.println();
							break;
						case 2: 
						
							System.out.println("____________________________________________");
							System.out.println("You have chose to See THE ELECTRICITY BILL");
							System.out.println("____________________________________________");
							
							frwd.readFromFile();
							
							break;
							
						case 3:
						
							System.out.println("____________________________________");
							System.out.println("You have chose to Go Back");
							System.out.println("____________________________________");
							break;
							
						default:
						
							System.out.println("____________________________________");
							System.out.println("Invalid Option");
							System.out.println("____________________________________");
							break;
					}
					System.out.println();
					
					break;
					
				case 4:
					
					System.out.println("____________________________________");
					System.out.println("You have chose to Exit");
					System.out.println("____________________________________");
					
					repeat = false;
					
					break;
					
				default:
					
					System.out.println("____________________________________");
					System.out.println("Invalid Choice...");
					System.out.println("____________________________________");
					
					break;
					 
			}				
		}
	}

}



	
