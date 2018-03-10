package work.schotte.builders;

import work.schotte.pages.WebPage;

public class ArticlePage extends WebPage implements Runnable {
  

  @Override
  public void run() {
    // TODO Auto-generated method stub
    System.out.println("ArticleThread");
    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
