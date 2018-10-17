public class Buggy {

    Integer a;
    Integer b;

    public Buggy(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public void play() throws InterruptedException {
        while(a < Integer.MAX_VALUE) {
            synchronized (this.a) {  // threadB can't enter this block to request this.b lock & release threadA
                synchronized (this.b) {
                    this.b.wait();  // Noncompliant; threadA is stuck here holding lock on this.a
                }
            }
            a++;
            b++;
            System.out.println(a);
            System.out.println(b);
        }
    }
}
