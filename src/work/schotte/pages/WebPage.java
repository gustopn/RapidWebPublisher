package work.schotte.pages;

import work.schotte.pageparts.*;

public abstract class WebPage {
  private PageHead head;
  private PageBody body;
  private HTML5 html5;
  
  public WebPage(String pageTitle, String pageContent) {
    this.head = new PageHead(pageTitle);
    this.body = new PageBody(pageContent);
    this.html5 = new HTML5();
  }
  
  public PageHead getPageHead() {
    return this.head;
  }
  
  public PageBody getPageBody() {
    return this.body;
  }
  
  @Override
  public String toString() {
    String output = new String();
    output += this.html5.getBegin();
    output += this.head.toString();
    output += this.body.toString();
    output += this.html5.getEnd();
    return output;
  }
}
