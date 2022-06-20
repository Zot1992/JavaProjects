public class Directory {
   public Object File="define";
   public int level=0;

   public Object getFile(){return File;}
   public int getLevel(){return level;}

   public Directory(){};
   public Directory(Object File, int level){
      this.File=File;
      this.level=level;

   }
}
