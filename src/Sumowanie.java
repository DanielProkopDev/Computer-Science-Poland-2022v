
//Recursive Sum of numbers from input value to 1;
public class Sumowanie {

    public int sum(int a){
        if (a == 0){
            return a;
        }
        else {
            return a + sum(a-1);
        }
    }

    public static void main(String[] args) {
        Sumowanie sumowanie = new Sumowanie();
        System.out.println(sumowanie.sum(5));
    }
}
