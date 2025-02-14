package Decesion_Table;

public class PhoneSubscription {
	boolean international,loyal,autoReneual;
	int price;
	public void setinternational(boolean inter)
	{
		this.international=inter;
	}
	public void setloyal(boolean loyal)
	{
		this.loyal=loyal;
	}
	public void setautoReneual(boolean autoReneual)
	{
		this.autoReneual=autoReneual;
	}
	public int priceperMonth()
	{
		if(international)
		{
			if(autoReneual||loyal)
				price=30;
			else
				price=32;	
		}
		else
		{
			if(autoReneual||loyal)
				price=10;
			else
				price=15;
		}
		return price;
	}

}
