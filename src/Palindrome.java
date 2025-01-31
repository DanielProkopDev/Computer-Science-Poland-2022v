public class Palindrome {


    public static void main(String[] args) {
        String word = "ALAMALA";
        String word2 = "ALAMAAMALA";

        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(word));
        System.out.println(p.isPalindrome(word2));
    }
    public boolean isPalindrome(String word) {
        char[] arr = word.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
