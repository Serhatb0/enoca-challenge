public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 10; i++) {
            int y = i;
            if (i == 0) {
                System.out.println("*");
            }
            if (i % 2 == 0 && i != 0) {
                System.out.println();
                while (y > 0) {
                    System.out.print("*");
                    y--;
                }
                System.out.println();

            }
        }
    }
}
