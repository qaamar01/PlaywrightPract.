package PlaywrightPractice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class PlaywrightLocators2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();

		context.tracing().start(new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));

		Page page = context.newPage();
		page.navigate("https://botshot.ai/");

		// page.locator("div.MuiBox-root
		// button#platform-btn.MuiButton-root.MuiButton-text").click();

		// page.locator("div.MuiBox-root p:has-text('Products List')").click();

		Locator newsLetterInput = page.locator("div.MuiOutlinedInput-root input.MuiOutlinedInput-input");
		newsLetterInput.click();
		newsLetterInput.fill("amar.singh@bigohtech.com");

		page.locator("button:has-text('Subscribe')").click();

		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		
		// page.frameLocator(null)..................to access an element under frame/iframe.

	}

}
