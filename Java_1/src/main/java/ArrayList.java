
import java.util.Collection;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;//Поле, отвечающее за объем динамического массива по умолчанию
    private int size;//Поле-счетчик, которое хранит в себе количество действительно находящихся в массиве элементов
    transient Object[] elementData; /*Поле, в котором хранятся все элементы коллекции
    Помечено ключевым словом transient – поле не записывается в поток байт при применении стандартного алгоритма сериализации.
    стоит отметить, что поле не отмечено ключевым словом private, а сделано это для того,
    чтобы облегчить доступ к этому полю из вложенных классов (например, SubList). */

    public ArrayList() {}
    public ArrayList(Collection< ? extends E > c){} /*создает списочный массив, инициализируемый элементами из переданной коллекции
    (если хотим создать новый ArrayList на базе какой-то коллекции)*/
    public ArrayList(int initialCapacity){}/*создает списочный массив, имеющий начальную емкость. Если переданный параметр initialCapacity больше 0,
    то создается массив указанного размера (внутреннему полю elementData присваивается ссылка на новый массив типа Object размером initialCapacity).
    Если параметр равен 0, то в таком случае создается пустой массив.
    Если же заданный параметр меньше 0, то генерируется исключение IllegalArgumentException.*/

    public ArrayList(int size, Object[] elementData) {
        this.size = size;
        this.elementData = elementData;
    }

    public int getSize() {return size;}
    public Object[] getElementData() {return elementData;}
}
