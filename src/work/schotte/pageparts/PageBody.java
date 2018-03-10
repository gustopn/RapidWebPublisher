package work.schotte.pageparts;

public class PageBody {

  protected String bodystart = "<body>";
  protected String bodyend = "</body>";
  
  @Override
  public String toString() {
    String body = "";
    body += bodystart + "\n";
    body += bodyend + "\n";
    return body;
  }
}
