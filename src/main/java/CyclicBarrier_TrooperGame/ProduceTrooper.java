package CyclicBarrier_TrooperGame;

import CyclicBarrier_TrooperGame.Trooper;
import CyclicBarrier_TrooperGame.TrooperBase;
import CyclicBarrier_TrooperGame.Util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by toraj on 01/05/2017.
 */
public class ProduceTrooper implements Runnable {

    CyclicBarrier cyclicBarrier = null;
    TrooperBase trooperBase = null;

    public ProduceTrooper(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public ProduceTrooper(CyclicBarrier cyclicBarrier, TrooperBase trooperBase) {
        this.cyclicBarrier = cyclicBarrier;
        this.trooperBase = trooperBase;
    }

    public void run() {

        for (int i = 1; i <= 10 ; i++) {

            Trooper tr = new Trooper();
            tr.setName(Util.randomStringSolid(5));

            tr.setAmmo(i * 1000);
            tr.setArmor((short) (i * 10));
            tr.setHealth((short) (i * 50));
            tr.setMana((short) (i * 200));
            tr.setStrength(i * 2000);

            //[Touraj] add New CyclicBarrier_TrooperGame.Trooper to Base

            trooperBase.addTrooper(tr);

            System.out.println("CyclicBarrier_TrooperGame.Trooper Created : " + tr.toString());

        }

        try {


            this.cyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
