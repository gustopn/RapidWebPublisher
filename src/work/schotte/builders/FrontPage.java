package work.schotte.builders;

import work.schotte.pages.WebPage;
import work.schotte.builders.ArticlePage;
import java.util.ArrayList;

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
  
  public boolean buildArticleIndex(ArrayList<ArticlePage> arpgs) {
    // TODO: Should return true value if index has been built successfully and return false on errors.
    return false;
  }
  
  public void buildFrontPage() {
    // TODO: Here the frontpage will be built (meaning there will be a String containing all FrontPage content)
    /* TODO:  BTW. while we are talking about it ... the String should be part of the WebPage object, since WebPage objects should have
     *        a String in the end that contains all of HTML that is written out and it should be @override toString() doing it. 
     */
  }
}
