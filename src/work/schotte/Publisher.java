package work.schotte;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import work.schotte.pageparts.HTML5;
import work.schotte.builders.ArticlePage;
import work.schotte.builders.FrontPage;
import work.schotte.filereaders.ArticleTextFileFinder;
import work.schotte.filereaders.SectionFileFinder;

public class Publisher {
  
  private static boolean askToCreateDir(String dirabsolutepath) {
    boolean answer = false;
    Scanner scan = new Scanner(System.in);
    System.out.print("Article directory " + dirabsolutepath + " not found, create?\n[Yes or No]: ");
    answer = scan.nextLine().equals("Yes");
    scan.close();
    return answer;
  }
  
  private static boolean prepareDirectory(File webdir, String articlesdirpath, String sectionsdirpath) {
    // Can we write into this directory?
    if (!webdir.canWrite()) return false;
    // Is there a directory to store articles?
    File articlesdir = new File(articlesdirpath);
    if (!articlesdir.exists()) {
      if ( askToCreateDir(articlesdirpath) ) {
        if (articlesdir.mkdir()) System.out.println(articlesdirpath + " successfully created.");
      } else {
        return false;
      }
    }
    // Is there a sections directory?
    File sectionsdir = new File(sectionsdirpath);
    if (!sectionsdir.exists()) return false;
    // Something else? (TODO)
    return true;
  }
  
  private static void printUsageHelp(String[] givenArguments) {
    System.out.print("Invalid arguments: ");
    for (String argumentInstance : givenArguments) {
      System.out.print(argumentInstance);
    }
    System.out.println("\n");
    System.out.println("Only one argument, the destination directory of the webpage, is supported");
  }
  
  public static void main(String[] args) {
    
    if (args.length != 1) {
      printUsageHelp(args);
      System.exit(1);
    }
    
    String givenpath = args[0];
    File webdir = new File(givenpath);
    
    if (!webdir.exists()) {
      if ( ! webdir.getParentFile().canWrite() ) {
        System.out.println("We do not have sufficient rights to create a directory inside of " + webdir.getParent() + ", leaving now!");
        System.exit(1);
      }
      System.out.println("Destination directory of webpage does not exist, do you want to create a new one?");
      System.out.print("Answer Yes/No: ");
      Scanner scan = new Scanner(System.in);
      if ( scan.nextLine().toLowerCase().equals("yes") ) {      
        webdir.mkdir();
      } else {
        System.out.println("Directory does not exist and we do not want to create one, leaving now!");
        System.exit(1);
      }
    }
    
    if (!webdir.isDirectory()) {
      System.out.println("Path " + webdir.getAbsolutePath() + " is not a directory, leaving now!");
      System.exit(1);
    }
    String articlesdirpath = webdir.getAbsolutePath() + "/articles";
    String sectionsdirpath = webdir.getAbsolutePath() + "/sections";
    if (prepareDirectory(webdir, articlesdirpath, sectionsdirpath)) {
      // TODO: Start collecting articles comparing their creation time to what we already have exported
      ArticleTextFileFinder articleFinder = new ArticleTextFileFinder(articlesdirpath);
      articleFinder.isCurrent();
      // TODO: At same time start collecting front page sections and their creation time to what we already have exported
      SectionFileFinder sectionFinder = new SectionFileFinder(sectionsdirpath);
    }
  
    
    System.out.println(new HTML5());
    
    /*
    FrontPage fp = new FrontPage();
    ArticleTextFileFinder atff = new ArticleTextFileFinder();
    String[] foundTextFiles = atff.getFoundTextFiles();
    ArrayList<ArticlePage> arpgs = new ArrayList<>();
    for ( String foundTextFile : foundTextFiles ) {
      arpgs.add( new ArticlePage( foundTextFile ) );
    }
    Thread[] arttrds = null;
    {
      int artclno = arpgs.size();
      arttrds = new Thread[artclno--];
      while (artclno >= 0) {
        arttrds[artclno] = new Thread(arpgs.get(artclno));
        arttrds[artclno].start();
        artclno--;
      }
    }
    for (Thread arttrdi : arttrds) {
      try {
        System.out.println("Going to wait for a thread");
        arttrdi.join();
        System.out.println("Now completed waiting");
      } catch (InterruptedException e) {
        // I am just going to ignore this,
        // because here this exception should not happen anyway
        e.printStackTrace();
      }
    }
    if (fp.buildArticleIndex(arpgs)) {
      fp.buildFrontPage();
    }
    */
  }

}
