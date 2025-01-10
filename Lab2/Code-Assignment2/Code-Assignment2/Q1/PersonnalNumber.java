package personinfo;

import java.util.HashMap;
import java.util.Map;

//We will assume that the following code will accept birth date from 1922 to 2022.
public class PersonnalNumber {
	
	private String PAN;
	private String PANPart;
	private int monthNo;
	private int year;
	private int date;
	private int Day;
	private int checkSumDigit;
	private int genderDigit;
	private Map<Integer,String>month=new HashMap<Integer,String>();
	
	public PersonnalNumber(String PNo) throws Exception
	{
		this.monthNo=Integer.parseInt(PNo.substring(2, 4));
		this.year=Integer.parseInt(PNo.substring(0, 2));
		this.date=Integer.parseInt(PNo.substring(4, 6));
		this.genderDigit= Integer.parseInt(PNo.substring(9, 10));
		this.Day=Integer.parseInt(PNo.substring(4, 6));
		this.checkSumDigit=Integer.parseInt(PNo.substring(10,11));
		this.PANPart=PNo.substring(0,10);
		String pattern="^[0-9]{6}-[0-9]{4}$";
		if(PNo.matches(pattern) && checkValidity())
		{
			this.PAN=PNo;
		}
		else
			throw new Exception("Personal Number is invalid");
		
	}
	
	private boolean checkValidity() {
		
		if(checkMonth() && checkDay() && checkCheckSumDigit())
		    return true;
		else
			return false;
	}

	public void initializeMonth()
	{
		month.put(1, "January");
		month.put(2, "February");
		month.put(3, "March");
		month.put(4, "April");
		month.put(5, "May");
		month.put(6, "June");
		month.put(7, "July");
		month.put(8, "August");
		month.put(9, "September");
		month.put(10, "October");
		month.put(11, "November");
		month.put(12, "December");
	}
	
	
	public String getMonth() {
		
		String ret="";
		//add your code
		
		return ret;
	}
	
	public int getYear() {

		int ret=0;
		//add your code
		
		return ret;
	}
	
	public String getDate() {
		
		String ret="";
		//add your code
		
		return ret;
	}
	public String getSex() {
		
		String ret="";
		//add your code
		
		return ret;
	}

	public int getCheckSum() {
		int ret=0;
		//add your code
		
		return ret;
	}

	public int calculateMultiplication() {
		
		int multiPlyString[]=new int[]{2,1,2,1,2,1,0,2,1,2};
		int multiply=0;
		int sum=0;
		char[] panPart=this.PANPart.toCharArray();
		for(int i=0;i<multiPlyString.length;i++)
		{
			if(panPart[i]!='-')
			{
			multiply=Math.abs(((panPart[i]-'0')*multiPlyString[i]));
			if(multiply>=10)
			{
				sum+=multiply/10;
				sum+=multiply%10;
			}
			else
			   sum+=multiply;
			}
			
		}
		return sum;
	}
	
	public boolean checkMonth()
	{
		
		if(this.monthNo<=12 || this.monthNo>=1)
			return true;
		else
			return false;
			
	}
	
	
	
	
	public boolean checkLeapYear()
	{
		if((this.getYear()%4==0 && this.getYear()%100!=0) || this.getYear()%400==0)
			return true;
			return false;
	}
	
	public boolean checkDay()
	{
		if(this.monthNo==2)
		{
			if(checkLeapYear() && (this.Day<=29))
			   return true;
			else if(!checkLeapYear() && (this.Day<=28))
				  return true;
			else 
				  return false;
		}
		
		if (this.monthNo <= 7) {
			if ((this.monthNo % 2 == 1)&&(this.Day<=31))
			   return true;
			else if((this.monthNo % 2 == 0)&&(this.Day<=30))
			   return true;
			else
			   return false;	
			}
		
		if ((this.monthNo % 2 == 0)&&(this.Day<=31))
			return true;
		else if((this.monthNo % 2 == 1)&&(this.Day<=30))
			return true;
		else
			return false;
			
	}
	
	public boolean checkCheckSumDigit()
	{
		return (this.checkSumDigit==this.calculateCheckSum());
	}

}
