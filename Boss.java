
public class Boss  extends Monster{
	//a)
	private int stage;
	private final int initialHealth;
	
	//b)
	public Boss(int health,int power)
	{
		super(health,power);
		this.initialHealth=health;
		stage=1;
		
	}
	//c)
	public String toString()
	{
		return super.toString()+"\n"+"Stage:"+stage+"\n";
	}
	//d)
	public void takeDamage(int damage)
	{
		while(super.health!=0)
		{
			super.takeDamage(damage);
			int procentHealth=(int)(super.health*100/initialHealth);
			if(procentHealth>=20||  procentHealth<=50)
			{
				power=super.dealDamage()*2;
				stage++;
			}
		}
	}
	public static void main(String[] args)
	{
		 Boss bossMonster = new Boss(500, 50);
	}
	

}
