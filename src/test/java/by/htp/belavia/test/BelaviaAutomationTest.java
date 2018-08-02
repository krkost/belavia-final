package by.htp.belavia.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.belavia.step.Steps;

public class BelaviaAutomationTest {
	
	private static final String ORIGIN_LOCATION = "Minsk";
	private static final String DESTINATION_LOCATION = "Riga";	
	private Steps steps;
	
	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test
	public void test() {
		steps.openMainPage();
		steps.inputSearchFormOneWayForCurrentDate(ORIGIN_LOCATION, DESTINATION_LOCATION);
		steps.closeDriver();
	}
	

}
