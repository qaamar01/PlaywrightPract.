package PlaywrightPractice;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightLocaters {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://botshot.ai/");
		
		// Parent-Child css selector....................
		//page.locator("Div.MuiBox-root.css-zwe8s3 .MuiButton-root").click();
		
		
		// has-text css selector ......................................
	    page.locator("div.MuiBox-root button:has-text('resources')").click();

		// (In case of single element).....................

		// page.locator("text =Hotel Performance Audit").click();
		// page.locator is function to locate a web element on any web page.

		// (In case of multiple element with same text)...................

		Locator totalProducts = page.locator("text =Products");

		// Printing all available element options on the web page.............
		//List<String> productList = totalProducts.allTextContents();
		//for (String e : productList)
		//System.out.println(e);
		//System.out.println(productList);
		
		//OR..........
		
		//productList.forEach(menu->System.out.println(menu));
		
		//OR............
		
		for (int i=0;i<totalProducts.count();i++) {
			System.out.println(totalProducts.nth(i).textContent());
		}
				
		// Clicking on the first element in the list.............
		
		int productsMenu = totalProducts.count();
		System.out.println(productsMenu);
		//totalProducts.first().click();
		
	    


    }
}
