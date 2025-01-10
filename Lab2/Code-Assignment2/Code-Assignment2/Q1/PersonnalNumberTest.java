package Q1Person;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class PersonnalNumberTest {
	
	private PersonnalNumber pan;
	private PersonnalNumber pan1;

	@BeforeEach
	void setUp() throws Exception {
		pan=new PersonnalNumber("640823-3234");
		
		pan.initializeMonth();
	}

	

}
