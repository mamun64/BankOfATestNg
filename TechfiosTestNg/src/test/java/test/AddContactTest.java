package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactFormPage;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;
import util.Xls_Reader;

public class AddContactTest {
	
Xls_Reader reader = new Xls_Reader(".\\Data\\TestNGData.xlsx");
		
String email= reader.getCellData("Sheet1", "Email", 2);
String password= reader.getCellData("Sheet1", "Password", 2);
String name= reader.getCellData("Sheet1", "Name", 2);
String company= reader.getCellData("Sheet1", "Company", 2);
String Email= reader.getCellData("Sheet1", "EmailAddress", 2);
String phone= reader.getCellData("Sheet1", "Phone", 2);
String address= reader.getCellData("Sheet1", "Address", 2);
String city= reader.getCellData("Sheet1", "City", 2);
String state= reader.getCellData("Sheet1", "State", 2);
String zip= reader.getCellData("Sheet1", "Zipcode", 2);
String country= reader.getCellData("Sheet1", "Country", 2);



@Test
public void AddContact() {
	
	WebDriver driver= BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
	
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
	login.Login(email, password);
	
	HomePage home= PageFactory.initElements(driver, HomePage.class);
	home.verifyPageLogin();
	home.navigatingToAddContacr();
	
	AddContactFormPage contact=PageFactory.initElements(driver, AddContactFormPage.class);
	contact.fillingForm(name, company, Email, phone, address, city, state, zip, country);
	
	driver.close();
	driver.quit();
	
	
	
	
	
	
	
}









}
