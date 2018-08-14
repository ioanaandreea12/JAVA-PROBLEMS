import java.util.ArrayList;
import java.util.HashMap;

public class FruitySmartPhone extends Phone
{
	//a)
	private HashMap<String,Integer> installedApps ;
	private int cpuSpeed;
	private int freeMemory;
	public int getCpuSpeed()
	{
		return cpuSpeed;
	}
	public int getFreeMemory()
	{
		return freeMemory;
	}
	//b)
	public FruitySmartPhone(String owner,int freeMemory,int cpuSpeed)
	{
		super(owner);
		this.freeMemory=freeMemory;
		this.cpuSpeed=cpuSpeed;
		this.installedApps = new HashMap<String,Integer>();
	}
	//c)
	public boolean installApp(App argument)
	{
		if(installedApps.containsKey(argument.getName()) || (argument.getMemoryReq()>freeMemory) || (argument.getCpuReq()>cpuSpeed))
		{
			return false;
		}
		else
		{
			installedApps.put(argument.getName(), argument.getMemoryReq());
			freeMemory -=argument.getMemoryReq();
			return true;
		}
	}
	public boolean uninstallApp(App argument)
	{
		if(installedApps.containsKey(argument.getName())==false)
		{
			return false;
		}
		else
		{
			installedApps.remove(argument.getName(),argument.getMemoryReq());
			freeMemory+=argument.getMemoryReq();
			return true;
		}
	}
	//d)
	public boolean useApp (String name)
	{
		if((installedApps.containsKey(name)!=false))
		{
			return false;
		}
		if((installedApps.containsKey(name)==true) && (installedApps.get(name)>freeMemory))
		{
			installedApps.put(name, installedApps.get(name)+1);
			freeMemory++;
			return true;
		}
		return false;
	}
	//e)
	public ArrayList<String> getInstalledApps()
	{
		ArrayList<String> list = null;
		int [] memory = new int [installedApps.size()];
		int j=0;
		for(int i=0;i<installedApps.size();i++)
		{
			memory[j] = installedApps.get(i);
			j++;
		}
		for(int i=0;i<memory.length;i++)
		{
			for(int j1=1;j1<memory.length-1;j1++)
			{
				if(memory[j1]<memory[i])
				{
					int aux = memory[j1];
					memory[j1]=memory[i];
					memory[i]=aux;
				}
			}
		}
		int k=0;
		while(j<memory.length)
		{
			for(String name : installedApps.keySet())
			{
				if(memory[k]==installedApps.get(name))
				{
					list.add(name);
				}
			}
			k++;
		}
		return list;
	
	}
	public static void main(String[] args)
	{
		FruitySmartPhone r1 = new FruitySmartPhone("Hello", 5, 10);
	}
}
