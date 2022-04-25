import java.util.Scanner;

public class Product {
    public String toString(){return product+"\t"+price+"\t"+category;}

    public  String product="default";
    private String price="default";
    private  String category="default";

    public String getProduct(){return product;}
    public String getPrice(){return price;}
    public String getCategory(){return category;}

    public Product(){};//конструктор по умолчанию
    public Product(String p, String pr,String c){
        product=p;
        price=pr;
        category=c;
    }


}
