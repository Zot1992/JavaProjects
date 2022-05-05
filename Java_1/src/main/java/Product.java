import java.util.Scanner;

public class Product {

    private  String product="default";
    private Float price=0f; //если тип Float, то в конце числа добавляется буква f
    private  String category="default";

    public String toString(){return product+" "+price+" "+category;}
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
