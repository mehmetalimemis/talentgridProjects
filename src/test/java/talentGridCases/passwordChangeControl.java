package talentGridCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class passwordChangeControl {

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
		Thread.sleep(2000);

		// My account page control
		WebElement myAccountPageTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		myAccountPageTitle.getText().contains("My Account");
		System.out.println("My account page is opened");
		Thread.sleep(2000);

		// Click the change password button
		WebElement changePassword = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[2]"));
		changePassword.click();
		
		//Fill the password fields 
		WebElement oldPassword = driver.findElement(By.id("password"));
		oldPassword.sendKeys("Password01");
		
		WebElement newPassword = driver.findElement(By.id("new_password"));
		newPassword.sendKeys("Password02");

		WebElement confirmationPassword = driver.findElement(By.id("new_password_confirmation"));
		confirmationPassword.sendKeys("Password02");
		Thread.sleep(2000);
		
		// Save the changes
		WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/input[3]"));
		applyButton.click();

		// Changes control
		WebElement updateTitle = driver.findElement(By.id("flash_notice"));
		updateTitle.getText().contains("Password was successfully updated.");
		System.out.println("Password was successfully updated.");
		Thread.sleep(2000);

		// Quit
		driver.quit();
	}
}
