package work.schotte.filereaders;

import java.io.File;

public abstract class FileFinder {
  
  protected String dirpath;
  protected File workdir;
  protected File[] workdircontents;
  
  public FileFinder(String dirpath) {
    this.dirpath = dirpath;
    this.workdir = new File(this.dirpath);
    this.workdircontents = this.workdir.listFiles();
  }
  
  private static String getExportHTMLFilename(String contentfilename) {
    String exportHTMLFilename = "";
    String contentfileextension = null;
    String[] splitcontentfilename = contentfilename.split("[.]");
    if (splitcontentfilename.length > 0) contentfileextension = splitcontentfilename[splitcontentfilename.length - 1];
    if (contentfileextension != null) {
      if ( contentfileextension.equals("txt") ) {
        for (int i = 0; i < splitcontentfilename.length - 1; i++) {
          if (i > 0) exportHTMLFilename += ".";
          exportHTMLFilename += splitcontentfilename[i];
        }
        if (exportHTMLFilename.length() > 0) exportHTMLFilename += ".html";
      }
    }
    return exportHTMLFilename;
  }
  
  public boolean isCurrent() {
    for (File contentfile : workdircontents) {
      if (contentfile.isFile() && contentfile.canRead()) {
        String exportHTMLFilename = getExportHTMLFilename(contentfile.getName());
        if (exportHTMLFilename.length() > 0) {
          File exportHTMLFile = new File(this.dirpath + "/" + exportHTMLFilename);
          if (exportHTMLFile.exists() && exportHTMLFile.isFile()) {
            if (exportHTMLFile.lastModified() < contentfile.lastModified()) return false;
          } else {
            return false;
          }
        } else {
          // TODO: Optionally print out this verbose message
          System.out.println("Skipping " + contentfile.getName() + ", either HTML export file, or unknown");
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
