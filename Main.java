import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;
import java.lang.Comparable;

public class Main{
    public static void main(String args[]) throws Exception{
        Randomize randomizer = new Randomize();
        Sort Sorter= new Sort();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        randomizer.randomizeArray(a, 10000000, 10000000);
        randomizer.randomizeArray(b, 100, 100);
        //System.out.println(a.toString());
        System.out.println("merge sort:");
        System.out.println(Sorter.isSorted(a)); 
        Sorter.mergeSort(a);
        System.out.println(Sorter.isSorted(a));
        System.out.println("bubble sort:");
        System.out.println(Sorter.isSorted(b)); 
        Sorter.bubbleSort(b);
        System.out.println(Sorter.isSorted(b));
        //System.out.print(a.toString());
    }
}
class Randomize{
    public void randomizeArray(ArrayList<Integer> a, int size, int upperBounds){
        Random random = new Random();
        Integer tempInteger;
        String tempString;
        for (int i = 0; i < size; i++){
            tempInteger = random.nextInt(upperBounds);
            tempString = tempInteger.toString();
            a.add(Integer.parseInt(tempString));
        }
    }
}
class Sort{
    
    public <E extends Comparable<E>> void mergeArray(ArrayList<E> a, int start, int middle, int end){
        int i = start;
        int j = middle;
        //int k = 0;
        ArrayList<E> tempArray = new ArrayList<>();

        while(i < middle && j < end){
            if (a.get(i).compareTo(a.get(j))<=0){
                //tempArray[k] = a[i];
                tempArray.add(a.get(i));
                i++;
                //k++;
            }else{
                //tempArray[k] = a[j];
                tempArray.add(a.get(j));
                j++;
                //k++;
            }
            
        }
        while (i < middle){
            //tempArray[k] = a[i];
            tempArray.add(a.get(i));
            i++;
            //k++;
        }
        while (j < end){
            //tempArray[k] = a[j];
            tempArray.add(a.get(j));
            j++;
            //k++;
        }
        for (i = start; i < end; i++){
        //a[i] tempArray[i - start];
        a.set(i,tempArray.get(i - start));
        }
    }
    public <E extends Comparable<E>> void mergeSort(ArrayList<E> a){
        int start = 0;
        int end = a.size();
        int middle = (start + end)/2;
        if (end - start <= 1){
            return;
        }
        mergeSort(a,start, middle);
        mergeSort(a,middle, end);
        mergeArray(a,start,middle,end);

    }
    public <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end){
        int middle = (start + end)/2;
        if (end - start <= 1){
            return;
        }
        mergeSort(a,start, middle);
        mergeSort(a,middle, end);
        mergeArray(a,start,middle,end);
    }
    public <E extends Comparable<E>> boolean isSorted(ArrayList<E> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).compareTo(array.get(i+1)) > 0){return false;}
        }
        return true;
    }
    public <E extends Comparable<E>> void bubbleSort(ArrayList<E> a){
        for (int j = a.size();j >= 1; j --){
            for (int i = 0; i < a.size()-1; i++){
            if (a.get(i).compareTo(a.get(i)) > 0) {
                swap(a, i ,i+1);
            }
        }
    }
    }
    public <E> void swap(ArrayList<E> a, int i ,int j){
        E temp = a.get(i);
        a.set(i, a.get(i+1));
        a.set(i+1, temp);
    }
    
}