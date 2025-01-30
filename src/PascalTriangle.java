

public class PascalTriangle {
//Revursive, cant align triangle properly on display, because we would have to run factorial recursive call twice,
    //first to get biggest number for given n to know its length, later on to apply that length for alignment
    //exactly what we have in method printPascal1()
    public void printPascal(int n) {

       for(int i=0;i<=n;i++) {

           int[] arr = new int[i+1];
          for (int j=0;j<=i;j++) {
              arr[j] = (silnia(i))/(silnia(j)*(silnia(i-j)));
          }
        for (int j=n-i;j>0;j--) {

            System.out.print(" ");
        }

           if(i<5){
               System.out.print(" ");
           }
           if (i<9){
               System.out.print(" ");
           }
           if (i<10){
               System.out.print(" ");
           }
        for (int j=0;j<=i;j++) {
            System.out.print(arr[j]+" ");
        }
           System.out.println();
       }
    }
    public int silnia(int a){
        if (a==0){
            return 1;
        }
        else{
            return a*silnia(a-1);
        }
    }
//coefficient properties of pascal triangle, requires 2d array, 2d array later on displayed -> better approach, maxNumber dynamically achieved

    public void printPascal1(int n) {
        int[][] triangle = new int[n + 1][];
        int maxNumber = 1;


        for (int i = 0; i <= n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = triangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                maxNumber = Math.max(maxNumber, triangle[i][j]);
            }
        }

        int maxWidth = String.valueOf(maxNumber).length();


        for (int i = 0; i <= n; i++) {
            int spaces = (n - i) * (maxWidth + 1) / 2;
            System.out.print(" ".repeat(spaces));

            for (int j = 0; j <= i; j++) {
                System.out.printf("%" + maxWidth + "d ", triangle[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        pt.printPascal(10);
        pt.printPascal1(10);
    }
}
