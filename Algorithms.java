import java.util.Arrays;
//Aditya Bhargava
public class Algorithms {
    public static void main(String[] args) {
        int[] sorted_massive    = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int[] unsorted_massive = {19,14,23,10,17,8,24,13,11,30,22,6,21,15,3,25,16,0,18,9,29,7,12,5,20,26,27,28,1,4,2};
        int[] unsorted = {19,14,23,10,17,8,24,13,11,30,22,6,21,15,3,25,16,0,18,9,29,7,12,5,20,26,27,28,1,4,2};
        int lookingfor = 22;
        SimpleSearch ss = new SimpleSearch(unsorted_massive,lookingfor);
        System.out.println(ss);
        BinarySearch bs = new BinarySearch(sorted_massive,lookingfor);
        System.out.println(bs);
        SortByChoice sbc_min = new SortByChoice(unsorted_massive);
        SortByChoice sbc_max = new SortByChoice(unsorted_massive);
        System.out.println(sbc_min.to_String());
        System.out.println(sbc_max);
        System.out.println(Arrays.toString(unsorted));
        QuickSort qs = new QuickSort(unsorted);
        qs._quickSort(unsorted,0,unsorted.length-1);
        System.out.println(qs.toString(unsorted));
    }
}
//Простой (прямой) поиск произвольного массива (скорость работы О-Большое: O(n) оп.)
class SimpleSearch{
    final private int[] massive;
    final private int lookingfor;
    SimpleSearch(int[] massive,int lookingfor){
        this.massive = massive;
        this.lookingfor = lookingfor;
    }
    public int _todo(){
        int count = 0;
        for (int j : massive) {
            if (j == lookingfor) return count;
            count++;
        }
    return 0;
    }
    public String toString(){
        return "Итераций: "+_todo()+" Индекс: ";

    }
}
//Бинарный (двоичный) поиск отсортированного массива (скорость работы О-Большое: O(log(n)) оп.)
class BinarySearch{
    final private int[] massive;
    final private int lookingfor;
    BinarySearch(int[] massive,int lookingfor){
        this.massive = massive;
        this.lookingfor = lookingfor;
    }
    public int _todo(){
        int count = 0;
        int leftborder = -1;
        int rightborder = massive.length+1;

        while(leftborder<=rightborder){
            count++;
            int center = (leftborder+rightborder)/2;
            if(massive[center]==lookingfor) return count;
            if(massive[center]<lookingfor) leftborder = center;
            else if(massive[center]>lookingfor) rightborder = center;
        }
        return 0;
    }
    public String toString(){
        return "Итераций: "+_todo()+" Индекс: ";
    }
}
//Сортировка выбором (Selected Sort)
class SortByChoice{
    private int[] massive;
    SortByChoice(int[] massive){
        this.massive = massive;
    }
    //Сортируем массив слева-направо (находя минимальное значение)
    public int[] _todo(){
        int _min_value = massive[0];
        int _tmp_value = 0;
        for (int begin = 0, _min_index = 0; begin < massive.length; begin++){
            _min_index = begin;
            for (int i = begin; i < massive.length; i++){
                if (massive[i] < massive[_min_index]) _min_index = i;
            }
            _tmp_value = massive[begin];         //Swap
            massive[begin] = massive[_min_index];
            massive[_min_index] = _tmp_value;
        }
        return massive;
    }
    //Сортируем массив справа-налево, находя максимальное значение
    public int[] todo(){
        int _max_value = massive[massive.length-1];
        int _tmp_value = 0;
        for (int end = massive.length-1,_max_index = massive.length; end > 0; end-- ){
            _max_index = end;
            for(int i = 0; i < end; i++){
                if(massive[i] > massive[_max_index]) _max_index = i;
            }
            _tmp_value = massive[end];        //Swap
            massive[end] = massive[_max_index];
            massive[_max_index] = _tmp_value;
        }
        return massive;
    }
    public String to_String(){
        String str="";
        massive = _todo();
        for (int j: massive){
            str += (j + " ");
        }
        return str;
    }
    public String toString(){
        String str="";
        massive = todo();
        for (int j: massive){
            str += (j + " ");
        }
        return str;
    }
}
//Быстрая Сортировка (Quick Sort)
class QuickSort {
    private int[] massive;
    QuickSort(int[] massive) {
        this.massive = massive;
    }
    public void _quickSort(int[] array, int low, int high) {
        if (array.length == 0) return; //Базовый случай
        if (low >= high) return; //Базовый случай, делить больше нечего
        //Найдем опорный элемент (например, средний)
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        //Разделим массив на 2 части меньше опорного элемента и больше опорного элемента
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) i++;//Пока элементы слева меньше опорного, оставляем их на месте
            while (array[j] > pivot) j--;//Пока элементы справа больше опорного, оставляем их на месте
            if (i <= j) { //Найденные элементы меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        //Пока левая граница не пришла направо, а правая налево
        //рекурсивно вызываем _quickSort
        if (j > low) _quickSort(array, low, j);
        if (i < high) _quickSort(array, i, high);
    }
    public String toString(int[] array) {
        String str = "[";
        int i = 0;
        for ( i=0; i<array.length-1;i++) str += array[i]+", ";
        str += array[i]+"]";
        return str;
    }
}