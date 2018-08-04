package by.htp.belavia.test;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.belavia.entity.Ticket;
import by.htp.belavia.step.Steps;

public class OneWayTicketsWithClassesTest {

	private static final String ORIGIN_LOCATION = "Minsk";
	private static final String DESTINATION_LOCATION = "Riga";
	private static final String END_DATE = "18-11-01";
	private Steps steps;

	@BeforeMethod (groups = { "one-way" })
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test (groups = { "one-way.classes" })
	public void testOneWayTicketsWithClasses() {
		steps.openMainPage();
		steps.inputSearchFormOneWayForCurrentDate(ORIGIN_LOCATION, DESTINATION_LOCATION);
		List<Ticket> tickets = steps.listOfOneWayTicketsWithClasses(END_DATE);
		Collections.sort(tickets, Ticket.COMPARE_BY_PRICE);
		System.out.println(tickets);

	}

}
