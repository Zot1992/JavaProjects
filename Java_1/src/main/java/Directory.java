public class Directory {
   public int level=0;
   public Object File="define";

   public int getLevel(){return level;}
   public Object getFile(){return File;}

   public Directory(){};
   public Directory( int level,Object File){
      this.level=level;
      this.File=File;
   }
}
