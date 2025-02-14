

package Decesion_Table;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PhoneSubscriptionTest {
	PhoneSubscription ps;

	@BeforeEach
	void setUp() throws Exception {
		ps=new PhoneSubscription();
	}

	@ParameterizedTest(name="International= {0},Auto-reneual={1},Loyal= {2},result= {3}")
	@CsvSource({"false,true,false,10","false,false,false,15","true,false,false,32","true,false,true,30"})
	void testPriceperMonth(boolean inter,boolean auto, boolean loyal, int price) 
	{
		ps.setautoReneual(auto);
		ps.setinternational(inter);
		ps.setloyal(loyal);
		assertEquals(price,ps.priceperMonth());
	}
	

}
