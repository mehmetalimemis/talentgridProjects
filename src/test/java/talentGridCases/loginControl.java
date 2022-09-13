package talentGridCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginControl {

		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\\\chrome\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://demo.redmine.org/");
			driver.manage().window().maximize();
			
			//Open the login page
			WebElement loginPage = driver.findElement(By.className("login"));
			loginPage.click();
			
			//Login e-mail and password
			WebElement YourMailAdress = driver.findElement(By.id("username"));
			YourMailAdress.sendKeys("tauto_qa_account");
			WebElement YourPassword = driver.findElement(By.id("password"));
			YourPassword.sendKeys("Password01");
			
			//Submit e-mail and password
			WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input"));
			LoginBtn.click();
			
			//Login check
			WebElement accountName = driver.findElement(By.xpath("//*[@id=\"loggedas\"]/a"));
			accountName.getText().contains("tauto_qa_account");
			System.out.println("Login account is tauto_qa_account");
			
			//Quit
			driver.quit();

		}

	}