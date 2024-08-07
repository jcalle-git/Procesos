package Produc;

public class Main {
    // ESTO ES EL MODELO DE UNA ITV CON UN TOTAL DE HASTA 4 PUESTO UN TOTAL DE COCHES DE 10 COCHES y 4 PUESTOS
    // Esto se obtiene con el random
    public static void main(String[] args) {
        int pueRandom = (int) (Math.random()*1 + 4);
        int vehRandom = (int) (Math.random()*1 + 10);
        ColaProd c = new ColaProd();
        System.out.println(vehRandom+" Vehiculos seran atendidos por "+pueRandom+" puestos.");

        //Creacion de Vehiculos (productor hay que usar la variable random de vehRandom)
        Productor[] p = new Productor[vehRandom];
        for (int i = 0; i < vehRandom; i++) {
            p[i] = new Productor(i+1, c);
            p[i].start();
        }
        //Creacion de Puestos (Consumidor) hay que usar la variable de random pueRandom
        Consumidor[] cm = new Consumidor[pueRandom];
        for (int i = 0; i < pueRandom; i++) {
            cm[i] = new Consumidor(i+1, c);
            cm[i].start();
        }
        
        // Nos aseguramos que los vehiculos acaban
        for (int i = 0; i < vehRandom; i++) {
            try {
                p[i].join();
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println("Error en el join de los vehiculos");
            }
        }
        
     // Nos aseguramos que los Puestos acaban
        //Espera a que terminen todos los puestos (consumidores)
        for (int i = 0; i < pueRandom; i++) {
            try {
                cm[i].join();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }

        //Cerramos todo Sacamos mensaje final, despues de que todo este terminado
        System.out.println("Terminado; Tiempo acumulao de "+c.getTiempoTotal());
        
    }

}
