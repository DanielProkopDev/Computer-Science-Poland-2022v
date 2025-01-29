
//I will be adding sort implementations into this single class for fun.
public class Sort {

//Selection Sort
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


}
