
//I will be adding sort implementations into this single class for fun.
public class Sort {


    public static void main(String[] args) {

        int count=0;
        int[] a = new int[500];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*250);
        }


        for (int toInd=a.length-1; toInd>0; toInd--) {
            int indMax=0;

            for (int k=1; k<=toInd; k++)
                if(a[indMax] < a[k])indMax = k;


            int temp = a[toInd];
            a[toInd] = a[indMax];
            a[indMax] = temp;
            count++;
        }


        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println("\n"+count);

    }
//Bubble sort
    public static void bubbleSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j-1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

//Selection Sort
    public static void selectionSort(int[] a) {
        for (int i = a.length-1; i > 0; i--) {

            int max=0;
            for (int j = 1; j<=i; j++) {
                if (a[max]<a[j]) {
                    max=j;
                }
            }
            int temp=a[max];
            a[max]=a[i];
            a[i]=temp;

        }

}

     //Insertion sort

    public static void insertionSort(int[] a) {
        int p,j;
        for (int i=1; i<a.length; i++) {
            p=a[i];
            j=i-1;
            while(j>=0 && a[j]>p) {
                a[j+1]=a[j];
                --j;
            }
            a[j+1]=p;
        }
    }

//Merge sort
    int[] tempTab;
    public  void merge(int[] a, int left, int mid, int right){
        tempTab=new int[a.length];
        int i,j;

        for (i = mid+1;i>left;i--){
            tempTab[i-1]=a[i-1];
        }

        for (j = mid; j<right; j++){
            tempTab[right+mid-j]=a[j+1];
        }

        for (int k = left;k<=right;k++){
            if (tempTab[j]<tempTab[i]){
                a[k]=tempTab[j--];
            }else {
                a[k]=tempTab[i++];
            }
        }

    }

public void mergeSort(int[] a, int left, int right){
        if (right<=left){
            return;
        }
        int mid = (right+left)/2;
        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);
        merge(a, left, mid, right);
}


//Bucket sort
    //requires assumptions as for example: array should be evenly distributed if you aim for better complexity otherwise it would be O(n^2),
    // we need to know difference between smallest and biggest value in the array etc. check below
    //if we can fulfill assumptions it can be very fast sort algorithm, although including time spent on looping through
    // the array to find biggest value etc isnt best idea -> but we can get that information before passing array to method
    // that would change below implementation(keep that in mind)

    public int dist(int i , int max, int numberOfBuckets){
        return (int) ((double) i / max * (numberOfBuckets-1));
    }

    public void bucketSort(int[] a){
       int nOB= (int) Math.sqrt(a.length);
       int max = Integer.MIN_VALUE;
       int index=0;
       Comparator<Integer> comp= Comparator.naturalOrder();
       Vector<Vector<Integer>> buckets = new Vector<>(nOB);

        for (int i = 0; i < nOB; i++) {
           buckets.add(new Vector<>());
        }
        for (int i : a){
            max= Math.max(i,max);
        }
        for (int i : a){
            buckets.get(dist(i,max,nOB)).add(i);
        }
        for (Vector<Integer> bucket: buckets){
            bucket.sort(comp);
        }

       for (Vector<Integer> bucket: buckets){
           for (int j=0;j<bucket.size();j++){
               a[index] = bucket.get(j);
               index++;
           }
       }
    }


    
}
