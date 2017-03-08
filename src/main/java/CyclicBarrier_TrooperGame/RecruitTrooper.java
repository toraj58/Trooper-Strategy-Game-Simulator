package CyclicBarrier_TrooperGame;

import CyclicBarrier_TrooperGame.Trooper;
import CyclicBarrier_TrooperGame.TrooperBase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by toraj on 01/05/2017.
 */
public class RecruitTrooper implements Runnable {

    CyclicBarrier cyclicBarrier = null;
    TrooperBase trooperBase = null;

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public RecruitTrooper(CyclicBarrier cyclicBarrier, TrooperBase trooperBase) {
        this.cyclicBarrier = cyclicBarrier;
        this.trooperBase = trooperBase;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {

        try {

            this.cyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <=5 ; i++) {

            Trooper trooper;

            trooper = trooperBase.pollTrooper();

            //Touraj : There is an Implicit Race Condotion Between CyclicBarrier_TrooperGame.RecruitTrooper and Call for Warplane Threads
            // So Checking if Polling a CyclicBarrier_TrooperGame.Trooper form CyclicBarrier_TrooperGame.TrooperBase returns Null

            if (trooper == null) {
                continue;
            }

            System.out.println("CyclicBarrier_TrooperGame.Trooper Recruited : " + trooper.toString());
        }
    }
}
