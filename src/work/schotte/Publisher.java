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
    for ( String foundTextFile : foundTextFiles ) {
      arpgs.add( new ArticlePage( foundTextFile ) );
    }
    int artclno = arpgs.size();
    Thread[] arttrds = new Thread[artclno];
    for (Thread arttrdi : arttrds) {
      arttrdi = new Thread(arpgs.get(--artclno));
      arttrdi.start();
    }
    for (Thread arttrdi : arttrds) {
      try {
        arttrdi.join();
      } catch (InterruptedException e) {
        // I am just going to ignore this,
        // because here this exception should not happen anyway
        e.printStackTrace();
      }
    }
    if (fp.buildArticleIndex(arpgs)) {
      fp.buildFrontPage();
    }
  }

}
