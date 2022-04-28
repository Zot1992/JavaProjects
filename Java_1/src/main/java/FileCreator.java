import java.io.File;
import java.io.IOException;
// метод createNewFile()
public class FileCreator {
    public static void main(String args[])throws IOException
    {
        File file = new File("products.txt");//создает текстовый файл
        if (file.createNewFile()) //Проверка на существование файла
            System.out.println("Файл создан");
        else
            System.out.println("Файл уже существует");
    }
}

