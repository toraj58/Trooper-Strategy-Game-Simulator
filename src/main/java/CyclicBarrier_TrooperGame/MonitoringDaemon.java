package CyclicBarrier_TrooperGame;

import CyclicBarrier_TrooperGame.TrooperBase;

/**
 * Created by toraj on 01/05/2017.
 */
public class MonitoringDaemon implements Runnable {

    TrooperBase trooperBase = null;

    public MonitoringDaemon(TrooperBase trooperBase) {
        this.trooperBase = trooperBase;
    }

    public void run() {

        System.out.println("Monitoring Daemon Thread Started ...");

        while (true) {

            System.out.println("Number of Troopers in Base : " + trooperBase.getNumberofTroopersInBase());

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
