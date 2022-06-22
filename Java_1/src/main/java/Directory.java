import java.io.File;

public class Directory {
   private File file=new File("define");
   private int level=0;

   public File getFile(){return file;}
   public int getLevel(){return level;}

   public Directory(){};
   public Directory(File file, int level){
      this.file=file;
      this.level=level;
   }
}
