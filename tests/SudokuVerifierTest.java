import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
	

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void test_valid_string() {
		// TC1
		// This test checks the result is right if the input is a valid input
		int a = v.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("correct string", 0, a);
	}
	
	@Test
	public void test_string_too_short() {
		// TC2
		// This test verify the behavior of the system if the input is incomplete/too short
		// It verify the equivalent class of to short input + the boundary value
		int a = v.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529");
		assertEquals("string too short", -1, a);
	}
	
	@Test
	public void test_string_too_long() {
		// TC3
		// This test verify the behavior of the system if there is a mistake in the input/too long
		// It verify the equivalent class of to long input + the boundary value
		int a = v.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529312");
		assertEquals("string too long", -1, a);
	}
	
	@Test
	public void test_string_contains_letter() {
		// TC4
		// This test is used to test if a letter is in the input
		// It verify the equivalent class of input that contain letter(s)
		int a = v.verify("4173698256321589479587243168254371697915864a2346912758289643571573291684164875293");
		assertEquals("string contains letter(s)", 1, a);
	}
	
	@Test
	public void test_string_contains_symbols() {
		// TC5
		// This test is used to test if a symbol is in the inputs
		// It verify the equivalent class of input that symbol(s)
		int a = v.verify("4173698256321589479587243168254371697915864@2346912758289643571573291684164875293");
		assertEquals("string contains symbol(s)", 1, a);
	}
	
	@Test
	public void test_string_contains_sub_grid_repetition() {
		// TC6
		// This test is used to test if a digit is repeating itself a subgrid
		// It tests the equivalent class of input that contain such a repetition
		int a = v.verify("417377825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("string contains sub-grid-repetition", -2, a);
	}
	
	@Test
	public void test_string_contains_row_repetition() {
		// TC7
		// This test is used to test if a digit is repeating itself a row
				// It tests the equivalent class of input that contain such a repetition
		int a = v.verify("417369825632158957958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("string contains row-repetition", -3, a);
	}
	
	@Test
	public void test_string_contains_column_repetition() {
		// TC8
		// This test is used to test if a digit is repeating itself a column
		// It tests the equivalent class of input that contain such a repetition
		int a = v.verify("417369825632158947958724316825437169791586432346912758289643571573291684461875293");
		assertEquals("string contains column-repetition", -4, a);
	}
	
	@Test
	public void test_string_contains_emoji() {
		// TC9
		// This test verify is a emoji/non-unicode character is in the input
		// It allows the check the equivalent class of inputs that contains symbols
		int a = v.verify("🙂17369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("string contains weird text", 1, a);
	}
	
	@Test
	public void test_0_digit() {
		// TC10
		// This test verify if a 0 digit is in the input
		// It allows to check the equivalent class of input that contains 0
		int a = v.verify("017369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("string contains a 0 digit", -1, a);
	}
	
	@Test
	public void test_below_0_digit() {
		// TC11
		// This test verify if a below 0 digit is in the input
		// It allows to check the equivalent class of input that contains numbers below 0
		int a = v.verify("4-17369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("string contains a 0 digit", -1, a);
	}
	
}
