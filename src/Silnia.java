
//Factorial recursive
public class Silnia {

    public int silnia(int a){
        if (a==0){
            return 1;
        }
        else{
            return a*silnia(a-1);
        }
    }

    public static void main(String[] args) {
        Silnia s = new Silnia();
        System.out.println(s.silnia(5));
    }
}
