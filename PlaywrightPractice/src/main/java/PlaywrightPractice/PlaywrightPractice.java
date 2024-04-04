package PlaywrightPractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightPractice {

	public static void main(String[] args) {
	  
		Playwright playwright=Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(lp);
		
	// 	Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.google.co.in/");
		
		String title = page.title();
		
		System.out.println("Page title =" + title);
		
		String url = page.url();
		
		System.out.println("Page url is " + url);
		
		browser.close();
		playwright.close();
		
				

	}

}
