package proyecto_hilos;

public class Jugador2 extends Thread {
    
    
    

    public int posX, posY, tiempo;

    Thread hilo = new Thread(this);

    public Jugador2(int x, int y, int t) {

        this.posX = x;
        this.posY = y;
        this.tiempo = t;
    }

    public void run() {
        correrLiebre();

    }

    public void correrLiebre() {
        try {
            do {

                Thread.sleep(tiempo);

                if (posY <= 300 && posX <= 860) {

                    posX = posX + 10;
                    posY = posY - 10;

                }
                if (posY >= 50 && posX >= 850) {
                    posX += 9;
                    posY += 10;

                }
                Carreras_con_relevos.lblLiebre.setLocation(posX, posY);
            } while (posX <= 1080);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }
}
