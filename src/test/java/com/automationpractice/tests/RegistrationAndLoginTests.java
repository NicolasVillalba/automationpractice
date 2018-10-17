package com.automationpractice.tests;

import static org.testng.Assert.assertTrue;

import java.util.StringJoiner;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAnAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SingInPage;
import com.automationpractice.pages.CreateAnAccountPage.CUSTOMER_TITLE;

import ar.com.informatorio.calidad.Exceptions.ReflectionConstrutorInvocationException;
import ar.com.informatorio.calidad.tests.BaseTest;

public class RegistrationAndLoginTests extends BaseTest {

	private String email;
	
	@Test(enabled = true, testName = "Registration Test")
	public void firstStep() throws InterruptedException, ReflectionConstrutorInvocationException {
		
		StringJoiner joinstring = new StringJoiner("_");
		this.email = joinstring.add(RandomStringUtils.random(4, true, false)).add("jhondoe@info.net").toString();

		HomePage homepage = new HomePage(this.driver);

		AuthenticationPage authpage = homepage.clickSingIn(AuthenticationPage.class);

		// janedoe@info.ner & jhondoe was used
		CreateAnAccountPage createAcountform = authpage.insertEmailAndPress(email);

		assertTrue(createAcountform.checkTitle("CREATE AN ACCOUNT"));
		assertTrue(createAcountform.sectionOneHeadingIs("YOUR PERSONAL INFORMATION"));
		assertTrue(createAcountform.sectionTwoHeadingIs("YOUR ADDRESS"));

		createAcountform
				// YOUR PERSONAL INFORMATION
				.pickTitle(CUSTOMER_TITLE.MR)
				.enterFirstName("jhon")
				.enterLasttName("Doe")
				.enterPassWord("very-hard-to-guess-passw")
				.setDateOfBirth("22-09-2017")// TODO:overload parameter with Date goodness
				// YOUR ADDRESS
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
	
	@Test(enabled = true)
	public void loginTest() throws ReflectionConstrutorInvocationException {
		HomePage homePage = new HomePage(this.driver);
		SingInPage singInPage = homePage.clickSingIn(SingInPage.class);
		singInPage.enterEmail("janedoe@info.ner");
		singInPage.enterPassword("very-hard-to-guess-passw");
		singInPage.clickSingInButton();
		assertTrue(singInPage.customerNameIsPresent("Donald Trump"));
	}
}
