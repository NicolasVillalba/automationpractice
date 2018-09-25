package com.automationpractice.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ar.com.informatorio.calidad.pages.BasePage;

public class CreateAnAccountPage extends BasePage {
	
	/*CREATE AN ACCOUNT SECTION*/
	@FindBy(how = How.CLASS_NAME, using = "page-heading")
	private WebElement pageHaeding;
	
	@FindBy(how = How.NAME, using = "id_gender")
	private List<WebElement> title;
	
	@FindBy(how = How.ID, using = "customer_firstname")
	private WebElement firstName;
	
	@FindBy(how = How.ID, using = "customer_lastname")
	private WebElement lastName;
	
	private WebElement email;
	
	private WebElement passwd;
	
	@FindBy(how = How.XPATH, using = "(//*[@id=\"account-creation_form\"]/div[1]/div[6]/div/descendant::select)")
	List<WebElement> dateOfBirth;
//	TODO ask for this mapping
//	Map<String, WebElement> map;
	
	/*YOUR ADDRESS SECTION*/
	private WebElement newsletter;
	
	private WebElement optin;
	
	private WebElement firstname;
	
	private WebElement lastname;
	
	private WebElement address1;
	
	private WebElement city;
	
	private WebElement id_state;
	
	private WebElement postcode;
	
	private WebElement id_country;
	
	private WebElement phone_mobile;
	
	private WebElement alias;
	
	private WebElement submitAccount;
	
	public Boolean yourPersoncalInfomationSection(String text) {	
		//TODO create a verification for the text in the sub-heading
		//tobe YOUR PERSONAL INFORMATION
		return false;
	}
	
	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Check the heading that names the page
	 * @param text
	 * @return
	 */
	public Boolean checkTitle(String text) {
		return this.waitAndVerifyElementText(this.pageHaeding, text);
	}
	
	/**
	 * Customer Title [Mr., Mrs.]
	 * @param selected
	 * @return
	 */
	public CreateAnAccountPage pickTitle(CUSTOMER_TITLE selected) {
		if(selected.equals(CUSTOMER_TITLE.MR)) 
			title.get(0).click();
		if(selected.equals(CUSTOMER_TITLE.MRS)) 
			title.get(1).click();
		return this;
	}
	
	/**
	 * Customer First Name
	 * @param name
	 * @return
	 */
	public CreateAnAccountPage enterFirstName(String name) {
		this.firstName.sendKeys(name);
		this.firstname.sendKeys(name);
		return this;
	}
	
	/**
	 * Customer Last Name
	 * @param name
	 * @return
	 */
	public CreateAnAccountPage enterLasttName(String name) {
		this.lastName.sendKeys(name);
		this.lastname.sendKeys(name);
		return this;
	}
	
	/**
	 * Check that the email that is assigned directly
	 * by the system is correct
	 * @return
	 */
	public Boolean checkEmailField(String email) {
		return this.email.getText().compareTo(email) == 0;
	}
	
	/**
	 * 
	 * @param passwd
	 * @return
	 */
	public CreateAnAccountPage enterPassWord(String passwd) {
		this.passwd.sendKeys(passwd);
		return this;
	}

	
	/**
	 * Helper method to check the text of the heading
	 * in {@code} checkTitle(String name) {@code}
	 * @param element
	 * @param str
	 * @return
	 */
	private Boolean waitAndVerifyElementText(WebElement element, String str) {
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		return wait.until(ExpectedConditions.textToBePresentInElement(element, str));
	}
	
	/**
	 * Sets a given date using this format dd-MM-yyy
	 * @param isoDate
	 * @return
	 */
	public CreateAnAccountPage setDateOfBirth(String ddMMyyy) {
		LocalDate date = LocalDate.parse(ddMMyyy, DateTimeFormatter.ofPattern("dd-MM-yyy"));
		String d = Integer.toString(date.getDayOfMonth());
		String m = Integer.toString(date.getMonth().getValue());
		String y = Integer.toString(date.getYear());
		this.setRadios(d, m, y);
		return this;
		
	}
	
	/**
	 * Sets a given date using ISO_DATE format  Example: 2011-12-03
	 * @param isoDate
	 * @return
	 */
	public CreateAnAccountPage setDateOfBirthISO(String isoDate) {
		LocalDate date = LocalDate.parse(isoDate, DateTimeFormatter.ISO_LOCAL_DATE);
		String d = Integer.toString(date.getDayOfMonth());
		String m = Integer.toString(date.getMonth().getValue());
		String y = Integer.toString(date.getYear());
		this.setRadios(d, m, y);
		return this;
		
	}
	
	/**
	 * Sets the system current date
	 * @return
	 */
	public CreateAnAccountPage setDateOfBirth() {
		LocalDate date = LocalDate.now();
		String d = Integer.toString(date.getDayOfMonth());
		String m = Integer.toString(date.getMonth().getValue());
		String y = Integer.toString(date.getYear());
		this.setRadios(d, m, y);
		return this;
	}
	
	private void setRadios(String day, String month, String year) {
		List<Select> selects = this.dateOfBirth
				.stream()
				.map(Select::new)
				.collect(Collectors.toList());
		
		selects.get(0).selectByValue(day);
		selects.get(1).selectByValue(month);//verify the value atribute of tag option
		selects.get(2).selectByValue(year);
	}
	
	/**
	 * gets the checkbox under date of birth section and select it
	 * @return
	 */
	public CreateAnAccountPage checkSingUpForNewsLetter() {
		if(newsletter.isSelected()) {
			return this;
		}
		newsletter.click();
		return this;
	}
	
	/**
	 * gets the checkbox under newletter checkbox
	 * @return
	 */
	public CreateAnAccountPage checkReceiveSpecialOffersFromOurPartners() {
		if(optin.isSelected()) {
			return this;
		}
		optin.click();
		return this;
	}
	
	public Boolean yourAddressSection(String text) {
		//TODO: look for the title in the second sub-heading
		return false;
	}
	
	public CreateAnAccountPage enterAddress(String address) {
		this.address1.sendKeys(address);
		return this;
	}
	
	public CreateAnAccountPage enterCity(String city) {
		this.city.sendKeys(city);
		return this;
	}
	
	public CreateAnAccountPage selectState(String state) {
		Select stateSelect = new Select(this.id_state);
		stateSelect.selectByVisibleText(state);
		return this;
	}
	
	public CreateAnAccountPage enterPostCode(String code) {
		this.postcode.sendKeys(code);
		return this;
	}
	
	public CreateAnAccountPage selectCountry(String name) {
		Select select = new Select(this.id_country);
		select.selectByVisibleText(name);
		return this;
	}
	
	public CreateAnAccountPage enterMobilePhone(Integer number) {
		this.phone_mobile.sendKeys(Integer.toString(number));
		return this;
	}
	
	public CreateAnAccountPage enterAddressAlias(String alias) {
		alias = (alias.length() == 0) ? this.firstName.getText() + this.lastName.getText() + " HOME": alias;
		this.alias.sendKeys(alias);
		return this;
	}
	
	public void clickRegisterButton() {
		this.submitAccount.click();
	}
	
	public void clickRegister() {
		this.submitAccount.click();
	}
	
	public enum CUSTOMER_TITLE {
		MR,
		MRS
	}

}
