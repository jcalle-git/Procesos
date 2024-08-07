package Produc;

public class Productor extends Thread{
    private int name;
    private ColaProd c;

    public Productor(int name, ColaProd c) {
        super();
        this.name = name;
        this.c = c;

    }
    
    @Override
    public void run() {
        c.nuevoCoche(name);
    }
}
