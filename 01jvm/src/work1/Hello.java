package work1;

public class Hello {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            if(i % 2 != 0){
                a = a + i;
            }
        }
        System.out.println(a);
    }
}
