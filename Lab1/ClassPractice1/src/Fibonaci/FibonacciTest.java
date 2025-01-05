package Fibonaci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    Fibonacci fi;
	@Test
	void test() {// fix bug in here 
		fi = new Fibonacci();
		int n = fi.fib(15);
		assertEquals(610,n);
	}
}
