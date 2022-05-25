

import java.util.Collection;
import java.util.Objects;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;//Поле, отвечающее за объем динамического массива по умолчанию
    private int size;//Текущий размер списка
    transient Object[] elementData; /*Поле, в котором хранятся все элементы коллекции
    Помечено ключевым словом transient – поле не записывается в поток байт при применении стандартного алгоритма сериализации.
    Стоит отметить, что поле не отмечено ключевым словом private, а сделано это для того,
    чтобы облегчить доступ к этому полю из вложенных классов (например, SubList). */

    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }//по умолчанию список будет пустой

    public ArrayList(Collection<? extends E> c) {
    } /*создает списочный массив, инициализируемый элементами из переданной коллекции
    (если хотим создать новый ArrayList на базе какой-то коллекции)*/

    public ArrayList(int initialCapacity) {/* Создает списочный массив, имеющий начальную емкость. Если переданный параметр initialCapacity больше 0,
    то создается массив указанного размера (внутреннему полю elementData присваивается ссылка на новый массив типа Object размером initialCapacity).
    Если параметр равен 0, то в таком случае создается пустой массив.
    Если же заданный параметр меньше 0, то генерируется исключение IllegalArgumentException.*/
        if (initialCapacity > 0) { // если начальный размер больше 0, то создается массив такого размера которого укажем
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) { //если начальный размер 0, то список будет равен пустому.
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index, size); //проверяем индекс
        return elementData(index);
    }

    public boolean add(E element) { //Классическое добавление элементов в списочный массив осуществляется с помощью перегруженных вариантов метода add().
        if (elementData.length > size) {
            elementData[size] = element;
        }//В конце массива присваиваем тот элемент, который хотим добавить.}
        else {
            Object[] newData = elementData;
            elementData = new Object[newData.length * 2];//создаем массив размером в 2 раза больше
            for (int i = 0; i < elementData.length; i++) {
                newData[i] = elementData[i];
            }
            elementData[size + 1] = element;
        }//В конце массива присваиваем тот элемент, который хотим добавить.
        size++;
        return true;
    }

    void remove(int index) { //удаляет указанный по индексу элемент из списка
        Object[] newData = new Object[elementData.length - 1];
        for (int i = 0; i < index; i++) {
            newData[i] = elementData[i];
        }
        for (int i = index + 1; i < elementData.length; i++) {
            newData[i - 1] = elementData[i];
        }
        elementData = newData;
        size--;
    }
}
