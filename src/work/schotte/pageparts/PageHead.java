package work.schotte.pageparts;

public class PageHead {
  protected String charset = "\t<meta charset=\"UTF-8\">";
  protected String headstart = "<head>";
  protected String headend = "</head>";
  
  @Override
  public String toString() {
    String head = "";
    head += headstart + "\n";
    head += charset + "\n";
    head += headend + "\n";
    return head;
  }
  
}
