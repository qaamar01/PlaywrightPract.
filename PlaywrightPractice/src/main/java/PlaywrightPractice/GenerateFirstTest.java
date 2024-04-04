package PlaywrightPractice;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class GenerateFirstTest {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      context.tracing().start(new Tracing.StartOptions()
    		    .setScreenshots(true)
    		    .setSnapshots(true)
    		    .setSources(true)); 
      
      Page page = context.newPage();
      page.navigate("https://dev.admin.botshot.ai/auth");
      page.getByPlaceholder("Email Address").click();
      page.getByPlaceholder("Email Address").fill("amar.singh@mailinator.com");
      page.getByPlaceholder("Password").click();
      page.getByPlaceholder("Password").fill("12345678");
      page.locator("button").filter(new Locator.FilterOptions().setHasText("visibility_off")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.locator("div").filter(new Locator.FilterOptions().setHasText("Notification Allow")).first().click();
      page.getByRole(AriaRole.DIALOG).locator("i").click();
      page.locator(".product-menu").click();
      page.getByText("eFront Desk").click();
      
      context.tracing().stop(new Tracing.StopOptions()
    		    .setPath(Paths.get("trace.zip"))) ;
    }
  }
}

