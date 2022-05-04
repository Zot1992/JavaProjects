import java.util.Scanner;

public class Product {
    public String toString(){return product+"\t"+price+"\t"+category;}

    private  String product="default";
    private Float price=0f; //если тип Float, то в конце числа добавляется буква f
    private  String category="default";

    public String getProduct(){return product;}
    public Float getPrice(){return price;}
    public String getCategory(){return category;}

    public Product(){};//конструктор по умолчанию
    public Product(String p, Float pr,String c){
        product=p;
        price=pr;
        category=c;
    }


}
