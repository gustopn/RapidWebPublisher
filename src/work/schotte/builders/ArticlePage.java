package work.schotte.builders;

import work.schotte.pages.WebPage;

public class ArticlePage extends WebPage implements Runnable {
  public ArticlePage(String pageTitle, String pageContent) {
    super(pageTitle, pageContent);
  }
  
  public ArticlePage(String page) {
    super(null, null);
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    
  }

}
