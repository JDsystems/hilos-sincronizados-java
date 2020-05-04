package proyecto_hilos;

public class Jugador1 extends Thread {

    Thread hilo = new Thread(this);

    public int posX, posY, tiempo;

    public Jugador1(int x, int y, int t) {
        this.posX = x;
        this.posY = y;
        this.tiempo = t;
    }
  

    public void run() {
        correrTortuga();
        

    }

    public  void correrTortuga() {
        try {
            do {


                Thread.sleep(tiempo);

                if (posY <= 310 && posX <= 340) {
                    posX = posX +  10;
                    posY -= 10;

                }
                if (posY <= 70 || posX >= 320) {
                    posX += 9;
                    posY += 10;


                }
                Carreras_con_relevos.lblTortuga.setLocation(posX, posY);
            } while (posX <= 580);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

   

}
