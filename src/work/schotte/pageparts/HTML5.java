package work.schotte.pageparts;

public class HTML5 {
  private String html5start = "<!DOCTYPE html>\n<html>";
  private String html5end = "</html>";
  protected PageHead head = new PageHead();
  protected PageBody body = new PageBody();
  
  @Override
  public String toString() {
    String html5page = "";
    html5page += html5start + "\n";
    html5page += head.toString() + "\n";
    html5page += body.toString() + "\n";
    html5page += html5end + "\n";
    return html5page;
  }
}
