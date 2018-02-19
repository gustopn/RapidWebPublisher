package work.schotte.builders;

import work.schotte.pages.WebPage;

public class FrontPage extends WebPage {
  
  public FrontPage(String pageTitle, String pageContent) {
    super(pageTitle, pageContent);
  
  }

  public FrontPage(String pageTitle) {
    super(pageTitle, "");
  }
  
  public FrontPage() {
    super("unnamed page", "use this only for testing");
    // TODO: This constructor should be removed after!
  }
  
}
