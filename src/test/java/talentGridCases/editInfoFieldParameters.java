package talentGridCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class editInfoFieldParameters {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\chrome\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.redmine.org/");
		driver.manage().window().maximize();

		// Open the login page
		WebElement loginPage = driver.findElement(By.className("login"));
		loginPage.click();

		// Login e-mail and password
		WebElement YourMailAdress = driver.findElement(By.id("username"));
		YourMailAdress.sendKeys("tauto_qa_account");
		WebElement YourPassword = driver.findElement(By.id("password"));
		YourPassword.sendKeys("Password01");

		// Submit e-mail and password
		WebElement LoginBtn = driver
				.findElement(By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input"));
		LoginBtn.click();

		// Login check
		WebElement accountName = driver.findElement(By.xpath("//*[@id=\"loggedas\"]/a"));
		accountName.getText().contains("tauto_qa_account");
		System.out.println("Login account is tauto_qa_account");
		Thread.sleep(2000);

		// Open the my account page
		WebElement myAccountPage = driver.findElement(By.className("my-account"));
		myAccountPage.click();

		// My account page control
		WebElement myAccountPageTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		myAccountPageTitle.getText().contains("Hesabım");
		System.out.println("My account page is opened");
		Thread.sleep(2000);

		// Edit info parameters
		WebElement newUsername = driver.findElement(By.id("user_firstname"));
		newUsername.clear();
		newUsername.sendKeys("Mehmet");

		WebElement newLastname = driver.findElement(By.id("user_lastname"));
		newLastname.clear();
		newLastname.sendKeys("Memiş");

		WebElement newMail = driver.findElement(By.id("user_mail"));
		newMail.clear();
		newMail.sendKeys("mehmetalimemis93@gmail.com");

		// Edit user language
		WebElement newSelectedLanguage = driver.findElement(By.id("user_language"));
		newSelectedLanguage.click();
		newSelectedLanguage.sendKeys("EN");
		newSelectedLanguage.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Save the changes
		WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"my_account_form\"]/div[1]/input"));
		saveButton.click();

		// Changes control
		WebElement updateTitle = driver.findElement(By.id("flash_notice"));
		updateTitle.getText().contains("Account was successfully updated.");
		System.out.println("Account was successfully updated.");
		Thread.sleep(2000);

		// Quit
		driver.quit();

	}
}
