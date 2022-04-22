public class Product {
    public String toString(){return product+"\t"+price+"\t"+category;}

    private  String product="default";
    private int price=0;
    private  String category="default";

    public String getProduct(){return product;}
    public int getPrice(){return price;}
    public String getCategory(){return category;}

    public Product(String p, int pr,String c){
        product=p;
        price=pr;
        category=c;
    }
}
