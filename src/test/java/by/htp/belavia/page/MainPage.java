package by.htp.belavia.page;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage{
	
	private static final String BASE_URL = "https://belavia.by/";

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		driver.get(BASE_URL);
	}

}
