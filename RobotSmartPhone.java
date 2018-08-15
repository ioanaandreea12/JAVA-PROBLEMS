import java.util.ArrayList;
import java.util.HashMap;

public class RobotSmartPhone extends Phone{
	//a)
	private ArrayList<Purchase>  purchaseHistory;
	private String[] authorisedModes ;
	//b)
	public RobotSmartPhone(String owner, String[] authorisedModes)
	{
		super(owner);
		if((authorisedModes.length==2 ) && ((authorisedModes[0].equals("RobotPay")) || authorisedModes[0].equals("DroidCard")) && ((authorisedModes[1].equals("RobotPay")) || (authorisedModes[1].equals("DroidCard"))))
				{
						this.authorisedModes=authorisedModes;
				}
						
		if((authorisedModes.length==1 ) && ((authorisedModes[0].equals("RobotPay")) || authorisedModes[0].equals("DroidCard")))
				{
						this.authorisedModes=authorisedModes;
				}
		this.purchaseHistory=new ArrayList<Purchase>();
	}
	//c)
	public boolean processPayment(Purchase object)
	{
		for(int i=0;i<authorisedModes.length;i++)
		{
			if(authorisedModes[i]==object.getMode())
			{
				purchaseHistory.add(object);
				return true;
			}
		}
		return false;
	}
//d)
	public ArrayList<Purchase> getPurchaseHistory()
	{
		return purchaseHistory;
	}
	public ArrayList<Purchase> getPurchaseHistory(String mode) 
	{
		ArrayList<Purchase> list = null;
		for(int i=0;i<purchaseHistory.size();i++)
		{
			if(purchaseHistory.get(i).getMode()==mode)
			{
				list.add(purchaseHistory.get(i));
			}
		}
		return list;
	}
	//e)
	public HashMap<String,Double>  getSummaryByCategory ()
	{
		HashMap<String,Double> map = new HashMap<String,Double>();
		for(int i=0;i<purchaseHistory.size();i++)
		{
			if(map.containsKey(purchaseHistory.get(i).getCategory()))
			{
			map.put(purchaseHistory.get(i).getCategory(), map.get(purchaseHistory.get(i).getCategory())+purchaseHistory.get(i).getValue());
			}
			else
			{
				map.put(purchaseHistory.get(i).getCategory(),purchaseHistory.get(i).getValue());
			}
		}
		return map;
	}
}
