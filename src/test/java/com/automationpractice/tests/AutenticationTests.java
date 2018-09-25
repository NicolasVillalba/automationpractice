package com.automationpractice.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAnAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.CreateAnAccountPage.CUSTOMER_TITLE;

import ar.com.informatorio.calidad.tests.BaseTest;

public class AutenticationTests extends BaseTest{
	
	@Test
	public void firstStep() throws InterruptedException {
		
		this.driver.get("http://automationpractice.com/index.php");
		
		HomePage homepage = new HomePage(this.driver);
		
		AuthenticationPage authpage = homepage.clickSingIn();
		
		CreateAnAccountPage createAcountform = authpage.insertEmailAndPress("jhondoe@info.ner");//janedoe was used
		
		assertTrue(createAcountform.checkTitle("CREATE AN ACCOUNT"));
		
		createAcountform
			//.yourPersoncalInfomationSection("YOUR PERSONAL INFORMATION") TODO: assert if subtitle is present
				.pickTitle(CUSTOMER_TITLE.MR)
				.enterFirstName("jhon")
				.enterLasttName("Doe") 
				.enterPassWord("very-hard-to-guess-passw")
				.setDateOfBirth("22-09-2017")//TODO:overload parameter with 
			//.yourAddressSection("YOUR ADDRESS")// TODO: assert if subtitle is present
				.enterAddress("Av. Siempre Viva 666")
				.enterCity("Atlanta")
				.selectState("Georgia")
				.enterPostCode("99501")
				.selectCountry("United States")
				.enterMobilePhone(98434893)
				.enterAddressAlias("")
			.clickRegister();
		
		assertTrue(createAcountform.checkTitle("MY ACCOUNT"));
	}
}
