package PlaywrightPractice;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
//		BrowserContext br1 = browser.newContext();
//		Page page = br1.newPage();
//		page.navigate("https://dev.admin.botshot.ai/auth");
//		page.click("input#mat-input-0");
//		page.fill("input#mat-input-0", "amar.singh@mailinator.com");
//		page.click("input#current-password");
//		page.fill("input#current-password", "12345678");
//		page.click("//button[@type='submit']");
//		page.click("div.container div.btn.btn__yes");
	
		
		// To store login data...................................
		//br1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("adminLogin.json")));  
	
		
		
		//To fetch saved login JSON file.............................
		BrowserContext br1=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("adminLogin.json"))); 
		Page page = br1.newPage();
		page.navigate("https://dev.admin.botshot.ai/auth");
		Thread.sleep(5000);
        page.click("div.container div.btn.btn__yes");
        Thread.sleep(3000);
        page.click("div.menu_button");
        Thread.sleep(2000);
        page.click("div.menu.ng-star-inserted div:has-text('eFront Desk')");
        
        
        
	
	}
	
}
