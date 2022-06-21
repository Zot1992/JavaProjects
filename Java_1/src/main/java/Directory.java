import java.io.File;

public class Directory {
   public File file=new File("define");
   public int level=0;

   public Object getFile(){return file;}
   public int getLevel(){return level;}

   public Directory(){};
   public Directory(File file, int level){
      this.file=file;
      this.level=level;
   }
}
