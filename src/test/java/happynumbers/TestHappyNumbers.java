package happynumbers;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import happynumbers.utils.HappyNumbersUtils;

public class TestHappyNumbers {	
	
	@Test(dataProvider = "HappyNumbers")	
	public void testHappyNumbers(Integer happyNbr, boolean expected){
		try{
		assertEquals(HappyNumbers.isHappyNumber(happyNbr), expected, "ERROR: "+happyNbr+" should be evaluated as a happy Number");}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="DigitsSum")
	public void testSum(Integer input, Integer expected){
		try{
		assertEquals((int)HappyNumbers.getSum(input), (int)expected, "ERROR: the sum of digits of number "+input+" is not calculated correctly");}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="UnhappyNumbers")
	public void testUnhappyNumbers(Integer unhappyNbr, boolean expected){
		try{
			assertEquals(HappyNumbers.isHappyNumber(unhappyNbr), expected, "ERROR: "+unhappyNbr+" should be evaluated as an unhappy Number");}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHappyNumberOccurence(){
		int count =0;
		for(int i=1; i<=1000; i++){
			
			if(HappyNumbers.isHappyNumber(i)){
				count++;
			}
		}
		assertEquals(count, 143, "ERROR: the number of happy numbers found is not correct");		
	}
	
	//null values as parameter or int will not be accepted by the compiler. 
	//If the risk would exist that some would call isHappyNumber((Integer) null) this is not something to be handled in the isHappyNumber method
	//The NullPointerException would be thrown from outside the called method.
	//I preferred to keep int as parameter type for better performance
	
	
	@DataProvider(name = "DigitsSum")
	public static Object[][] digitsSum() {
		//                     input , expected
		return new Object[][] { {1,            1},
								{10,           1},
								{100,          1},
								{1000,         1},
								{10000,        1},
								{10001,        2},
								{999,          243},
								{998877665,    485},
								{2147483647,   260},
								{-2147483648,  275},
								{999999999,    729},
								{99,           162},
								{9,            81},
								{8,            64},
								{7,            49},
								{4,            16},
								{0,            0}	
		
		};

	}
	
	@Test
	public void testUnhappyData(){ //if an exception is thrown, test will fail
		HappyNumbersUtils.formatDataProvider(false);
	}
	
	@Test
	public void testDataProvider(){ //if an exception is thrown, test will fail
		HappyNumbersUtils.formatDataProvider(true);
	}
	
	@DataProvider(name = "HappyNumbers")
	public static Object[][] hn() {

		return HappyNumbersUtils.formatDataProvider(true);

	}
	
	@DataProvider(name = "UnhappyNumbers")
	public static Object[][] uhn() {

		return HappyNumbersUtils.formatDataProvider(false);

	}
}
