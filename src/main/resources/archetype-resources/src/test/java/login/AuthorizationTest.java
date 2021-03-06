#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.login;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import ${package}.GuiceModule;
import ${package}.pageobjects.login.LoginPage;
import com.google.inject.Inject;

/**
 * Test for presenting how to log in to the page.
 */
@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AuthorizationTest {

	@Inject
	private LoginPage loginPage;

	@Test
	public void loginAsAuthorTest() {
		assertTrue("Login page is not displayed", loginPage.loginAsAuthor().isDisplayed());
	}

	@Test
	public void logoutTest() {
		loginPage.loginAsAuthor().openUserDialog().signOut();
		assertTrue("Login page is not displayed", loginPage.loginPageIsDisplayed());
	}

	/**
	 * After all tests sleep 1 second to let webDriver close the window
	 */
	@AfterClass()
	public static void afterClass() {
		BobcatWait.sleep(1);
	}

}
