package by.htp.belavia.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.belavia.step.Steps;

public class BelaviaAutomationTest {
	
	private static final String ORIGIN_LOCATION = "Minsk";
	private static final String DESTINATION_LOCATION = "Riga";
	private static final String END_DATE = "18-11-01";
	private Steps steps;
	
	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test
	public void testOneWayTickets() {
		steps.openMainPage();
		steps.inputSearchFormOneWayForCurrentDate(ORIGIN_LOCATION, DESTINATION_LOCATION);
		steps.listOfOneWayTickets(END_DATE);
		steps.closeDriver();
	}
	

}
