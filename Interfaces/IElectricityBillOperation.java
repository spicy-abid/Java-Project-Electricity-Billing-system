package Interfaces;
import java.lang.*;
import Classes.*;

public interface IElectricityBillOperation
{
	public abstract boolean insertUser(User c);
	public abstract boolean removeUser(User c);
	public abstract User searchUser(int userId);
	public abstract void showAllUser();
}