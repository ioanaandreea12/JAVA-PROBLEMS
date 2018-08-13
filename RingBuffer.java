
public class RingBuffer extends Buffer{
	//a)
	private int start;
	private int end;
	private int elementCount;
	//b)
	public RingBuffer(int capacity)
	{
		super(capacity);
		this.start=0;
		this.end=0;
		this.elementCount=0;
	}
	
	public RingBuffer()
	{
		super(10);
	}
	//c)
	public boolean isFull()
	{
		if(elementCount ==buffer.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//d)
	public boolean isEmpty()
	{
		if(elementCount==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//e)
	public void clear()
	{
		super.clear();
		elementCount++;
		start=0;
		end=0;
	}
	//f)
	public void addToBuffer(int argument)
	{
		if(isFull()==true)
		{
			System.out.println("Buffer is full!");
		}
		else
		{
			if(end+1==start && buffer[end-1]==-1)
			{
				buffer[end-1]=argument;
				elementCount++; 
				end=end-1;
			}
			else
			{
				if(end==buffer.length)
				{
					for(int i=0;i<buffer.length;i++)
					{
						if(buffer[i]==-1)
						{
							buffer[i]=argument;
							elementCount++;
							end=i;
							break;
						}
					}
				}
				else
				{
					buffer[end+1]= 	argument;
					end++;
				}
			}
		}
	}


//g)
public int getFromBuffer()
{
	if(isEmpty()==true)
	{
		System.out.println("Buffer is empty");
	}
	else
	{
		int argument = buffer[start];
		buffer[start]=-1;
		elementCount--;
		if(start==buffer.length)
		{
			for(int i=0;i<buffer.length;i++)
			{
				if(buffer[i]!=-1)
			{
					start=i;
					break;
			}
			}
		}
		else
		{
			if(start+1==end)
			{
				for(int i=0;i<start;i++)
				{
					if(buffer[i]!=-1)
					{
						start=i;
						break;
					}
				}
			}
			else
			{
				start--;
			}
		}
		return argument;
	}
	return 0;

}
public static void main(String[] args)
{
	 RingBuffer buff = new RingBuffer(5);
}


}
