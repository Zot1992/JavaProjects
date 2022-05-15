
import java.util.Arrays;
import java.util.Collection;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;//Поле, отвечающее за объем динамического массива по умолчанию
    private int size;//Поле-счетчик, которое хранит в себе количество действительно находящихся в массиве элементов
    transient E[] elementData; /*Поле, в котором хранятся все элементы коллекции
    Помечено ключевым словом transient – поле не записывается в поток байт при применении стандартного алгоритма сериализации.
    стоит отметить, что поле не отмечено ключевым словом private, а сделано это для того,
    чтобы облегчить доступ к этому полю из вложенных классов (например, SubList). */

    public int getSize() {return size;}
    public E[] getElementData() {return elementData;}

    public ArrayList() {}

    public ArrayList(Collection< ? extends E > c){} /*создает списочный массив, инициализируемый элементами из переданной коллекции
    (если хотим создать новый ArrayList на базе какой-то коллекции)*/

    public ArrayList(int initialCapacity){}/*создает списочный массив, имеющий начальную емкость. Если переданный параметр initialCapacity больше 0,
    то создается массив указанного размера (внутреннему полю elementData присваивается ссылка на новый массив типа Object размером initialCapacity).
    Если параметр равен 0, то в таком случае создается пустой массив.
    Если же заданный параметр меньше 0, то генерируется исключение IllegalArgumentException.*/



    public Arrays.copyOf(elementData, newCapacity(minCapacity)){}

    private E[] grow() {return grow(size + 1);}

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;//записываем в переменную текущий массив
        int newCapacity = oldCapacity + (oldCapacity >> 1); /*осуществляется вычисление нового размера массива. Он вычисляется по следующей формуле.
        >> 1 – побитовый сдвиг вправо на единицу (оператор, который уменьшает число до его половины). По сути, означает деление на 2 в степени 1.
        Получается, что мы делим 10 на 2 и прибавляем 10. Итого, новая емкость массива равна 15, но так как мы добавляем 11 элемент, то 15+1 = 16.*/




        return;
    }

    private void add(E e, E[] elementData, int s){ /*Внутри (public boolean add) метода происходит вызов перегруженного варианта метода add(),
    помеченный как private, который в свою очередь на вход принимает три параметра: добавляемый элемент, внутренний массив и его размер (size).*/
        if (size == elementData.length){elementData = grow();} /*В закрытом методе происходит проверка: если переданный параметр размера равен длине
    внутреннего массива (то есть массив заполнен)*/
        elementData[s] = e;
        size = s + 1;
    }



    public boolean add(E element){ //Классическое добавление элементов в списочный массив осуществляется с помощью перегруженных вариантов метода add().

        return true;
    }


}
