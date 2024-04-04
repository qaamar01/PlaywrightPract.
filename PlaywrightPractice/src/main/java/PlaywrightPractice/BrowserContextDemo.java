package PlaywrightPractice;

import com.microsoft.playwright.*;

public class BrowserContextDemo {
	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

			BrowserContext b1cx1 = browser.newContext();
			Page page1 = b1cx1.newPage();
			page1.navigate("https://dev.admin.botshot.ai/auth");
			page1.fill("#mat-form-field-label-1", "amar.singh@mailinator.com");
			page1.fill("#current-password", "12345678");

			System.out.println("Botshot Admin Panel");
			
			
			BrowserContext b1cx2 = browser.newContext();
			Page page2 = b1cx2.newPage();
			page2.navigate("https://www.google.com/");
			page2.fill("#APjFqb", "Automation Testing");
			System.out.println("Page2");
			
			page1.close();
			b1cx1.close();
			
		//	page2.close();
		//	b1cx2.close();


		}
	}

}
