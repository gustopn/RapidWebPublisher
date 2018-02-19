package work.schotte;

import java.util.ArrayList;
import work.schotte.builders.ArticlePage;
import work.schotte.builders.FrontPage;
import work.schotte.filereaders.ArticleTextFileFinder;

public class Publisher {

  public static void main(String[] args) {
    
    FrontPage fp = new FrontPage();
    ArticleTextFileFinder atff = new ArticleTextFileFinder();
    String[] foundTextFiles = atff.getFoundTextFiles();
    ArrayList<ArticlePage> arpgs = new ArrayList<>();
    for (String foundTextFile : foundTextFiles ) {
      arpgs.add(new ArticlePage(foundTextFile));
      // TODO: Build article pages in parallel threads.
    
    }
    
  }

}
