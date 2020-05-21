public class BasicThread implements Runnable {
    private String name;
    public BasicThread(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasicThread{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i +"-"+ this.hashCode() + "-" + this.getName() );
        }
    }

    public static void main(String[] args) {
        BasicThread m1 = new BasicThread("A");
        Thread t1 = new Thread(m1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();


        BasicThread m2 = new BasicThread("B");
        Thread t2 = new Thread(m2);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }
}
