public class MathMain {



    public static void main(  String[] args) throws InterruptedException {
        int a = 10;
        int b = 20;
// Formatting issues
        System.out.println(MathUtil.multiply(a,   b));
        System.out.println(MathUtil.divide(a, b));
        System.out.println(MathUtil.sum(a,   b));
        System.out.println(MathUtil.subtract(a, b));


        Buggy buggy = new Buggy(a, b);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    buggy.play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    buggy.play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t.join();
        t2.join();

        System.out.println(50/0);
    }


}
