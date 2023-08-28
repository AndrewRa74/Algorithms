public class Algorithms {
    public static void main(String[] args) {
        int[] massive = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int lookingfor = 17;
        SimpleSearch ss = new SimpleSearch(massive,lookingfor);
        System.out.println(ss);
        BinarySearch bs = new BinarySearch(massive,lookingfor);
        System.out.println(bs);
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