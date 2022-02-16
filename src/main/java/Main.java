public class Main {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println(a);
        }catch (Exception e) {
            System.out.println("Catch");
            //System.exit(1);
            return;
        } finally {
            System.out.println("Test");
        }
    }
}
