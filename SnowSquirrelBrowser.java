import java.util.ArrayList;
import java.util.HashMap;

public class SnowSquirrelBrowser extends Browser{
	//a)
	private HashMap<String,Double>  installedPlugins = new HashMap<String,Double>();
	private String version;
	private double availableQuota ;
	public String getVersion()
	{
		return version;
	}
	public double  getQuota()
	{
		return availableQuota;
	}
	//b)
	public SnowSquirrelBrowser(String owner,double availableQuota, String version)
	{
		super(owner);
		this.version=version;
		this.availableQuota=availableQuota;
		this.installedPlugins=new HashMap<String,Double>();
	}
	//c)
	public boolean installPlugin(Plugin argument)
	{
		if(installedPlugins.containsKey(argument) || (argument.getQuotaReq()>availableQuota) || (argument.getVersionReq().equals(version)==false))
				{
					return false;
				}
		else
		{
			if((installedPlugins.containsKey(argument)==false) && (argument.getVersionReq().equals(version)) && (argument.getQuotaReq()<=availableQuota))
			{
				installedPlugins.put(argument.getName(), argument.getQuotaReq());
				availableQuota-=argument.getQuotaReq();
				return true;
			}
			
			
		}
		return false;
	}
	public boolean uninstallPlugin(Plugin argument)
	{
		if(installedPlugins.containsKey(argument.getName())==false)
		{
			return false;
		}
		else
		{
			installedPlugins.put(argument.getName(),argument.getQuotaReq() );
			availableQuota+=argument.getQuotaReq();
			return true;
		}
	}
	//d)
	
//e)
	public ArrayList<String> getInstalledPlugins()
	{
		ArrayList<String> list = null;
		double[] values = new double [installedPlugins.size()];
		int j=0;
		for(int i=0;i<installedPlugins.size();i++) 
		{
			values[j] = installedPlugins.get(i);
			j++;
			
		}
		for(int i1=0;i1<values.length;i1++)
		{
			for(int j1=0;j1<values.length;j1++)
			{
				if(values[i1]<values[j1])
				{
					double aux = values[j1];
					values[j1]=values[i1];
					values[i1]=aux;
				}
			}
		}
		for(int i3=0;i3<values.length;i3++)
		{
			for(String name: installedPlugins.keySet())
			{
				if(installedPlugins.get(name)==values[i3])
				{
					list.add(name);
				}
			}
		}
		return list;
	}
					
	
	public boolean usePlugin (String name) 
	{
		if(installedPlugins.containsKey(name)==false )
		{
			return false;
		}
		if((installedPlugins.containsKey(name)==true) && (installedPlugins.get(name)>availableQuota))
		{
			return false;
		}
		if((installedPlugins.containsKey(name)==true) && (installedPlugins.get(name)<=availableQuota))
		{
			installedPlugins.put(name,installedPlugins.get(name)+1);
			availableQuota++;
			return true;
		}
		return false;
			
	}
	public static void main(String[] args)
	{
		SnowSquirrelBrowser r1 = new SnowSquirrelBrowser("Hello", 10.0, "V1");
	}
	
}
