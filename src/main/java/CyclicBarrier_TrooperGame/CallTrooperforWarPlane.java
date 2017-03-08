package CyclicBarrier_TrooperGame;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by toraj on 01/05/2017.
 */
public class CallTrooperforWarPlane implements Runnable{

    CyclicBarrier cyclicBarrier = null;
    TrooperBase trooperBase = null;

    public CallTrooperforWarPlane(CyclicBarrier cyclicBarrier, TrooperBase trooperBase) {
        this.cyclicBarrier = cyclicBarrier;
        this.trooperBase = trooperBase;
    }


    public void run() {

        try {

            this.cyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <=15 ; i++) {

            Trooper trooper;

            trooper = trooperBase.pollTrooper();

            if (trooper == null) {
                continue;
            }

            System.out.println("CyclicBarrier_TrooperGame.Trooper on Board (WarPlane) : " + trooper.toString());
        }


    }
}
