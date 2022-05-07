import java.util.Scanner;

public class Product {

    private  String product="default";
    private String price="default";
    private  String category="default";

    public String toString(){return product+" "+price+" "+category;}
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
