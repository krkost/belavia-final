package by.htp.belavia.test;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.belavia.entity.Ticket;
import by.htp.belavia.step.Steps;

public class ReturnSimpleSearchTest {
	
	private static final String ORIGIN_LOCATION = "Minsk";
	private static final String DESTINATION_LOCATION = "Riga";
	private static final String NUM_WEEK = "2";
	private static final String NUM_DAY = "5";
	private Steps steps;
	
	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test 
	public void testOneWayTickets() {
		steps.openMainPage();
		steps.inputSearchFormReturn(ORIGIN_LOCATION, DESTINATION_LOCATION, NUM_WEEK, NUM_DAY);
		steps.closeDriver();
	}

}
