
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




    
}
