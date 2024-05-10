package Classes;
import java.lang.*;
import Interfaces.*;
public class NESCO  extends Meter implements INESCO
{
	private final double firstRate=5.72;
	private double secondRate=6;
	private double thirdRate=6.34;
	private double fourthRate=9.94;
	private double fifthRate=11.46;
	private double result;
	protected double bill;
	
	
	public NESCO()
	{
		
	}
	public NESCO(int meterNumber,String meterHolderName, double meterReading)
	{
		super(meterNumber,meterHolderName,meterReading);
		
		
	}
	
	public double getBill()
	{
		return bill;
	}
	public double BillOperation()
	{
		
		try
		{
		
			if(getMeterReading()>76 && getMeterReading()<=200)
			{
				return result=firstRate*getMeterReading();
			
			}
			else if(getMeterReading()>201 && getMeterReading()<=300)
			{
				return result=secondRate*getMeterReading();
			
			}
				else if(getMeterReading()>301 && getMeterReading()<=400)
			{
				return result=thirdRate*getMeterReading();
			
			}
				else if(getMeterReading()>401 && getMeterReading()<=600)
			{
				return result=fourthRate*getMeterReading();
			
			}
			else if(getMeterReading()>600)
			{
				return result=fifthRate*getMeterReading();	
			}
			else
			{
				return result=250;	
			}
		}
		catch(ArithmeticException ex1)
		{
			System.out.print("Arithmetic Exception occured"+ex1);
		}
		catch(RuntimeException e)
		{
			System.out.print("Runtime Exception occured"+e);
		}
		return result;
	}
	public void showDetails()
	{
		System.out.println("Bill Name is: "+getMeterHolderName());
		System.out.println("Meter Id: "+getMeterNumber());
		System.out.println("Unit is: "+getMeterReading());
		System.out.println("Your Electricity bill is: "+BillOperation()+"Tk");
	}
	public boolean AfterPayment(double amount)
	{
		bill=result;
		boolean flag = false;
		if(amount>0 && amount<=bill)
		{
			bill = bill - amount;
			flag = true;
		}
		
		return flag;
	}
	
}