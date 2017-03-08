package CyclicBarrier_TrooperGame;

import CyclicBarrier_TrooperGame.*;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by toraj on 01/04/2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("******* Trooper Strategy Game Simulator *******");
        System.out.println("*                                             *");
        System.out.println("*             Using CyclicBarrier             *");
        System.out.println("*                  By Touraj                  *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {

            public void run() {
                System.out.println("Cyclic Barrier Reached :: Troopers Ready For Recruiting");
            }

        });

        TrooperBase trooperBase = new TrooperBase();

        Thread trooperProducderThread = new Thread( new ProduceTrooper(cyclicBarrier, trooperBase) , "TrooperProducderThread Thread");
        Thread trooperRecruiterThread = new Thread( new RecruitTrooper(cyclicBarrier, trooperBase) , "TrooperRecruiterThread Thread");
        Thread callTrooperforWarPlaneThread = new Thread( new CallTrooperforWarPlane(cyclicBarrier, trooperBase) , "CallTrooperforWarPlaneThread Thread");

        Thread monitoringDaemonThread = new Thread( new MonitoringDaemon(trooperBase) , "[[ MonitoringDaemonThread Thread ]]");

        trooperProducderThread.start();

        trooperRecruiterThread.start();

        callTrooperforWarPlaneThread.start();

        monitoringDaemonThread.setDaemon(true);
        monitoringDaemonThread.start();



    }

}
