package PlaywrightPractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext br1 = browser.newContext();
		Page page = br1.newPage();
		page.navigate("https://dev.admin.botshot.ai/auth");
		page.click("input#mat-input-0");
		page.fill("input#mat-input-0", "amar.singh@mailinator.com");
		page.click("input#current-password");
		page.fill("input#current-password", "12345678");
		page.click("//button[@type='submit']");
		page.click("div.container div.btn.btn__yes");
	
	}

}
