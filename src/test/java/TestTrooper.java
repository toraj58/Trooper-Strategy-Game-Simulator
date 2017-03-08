import CyclicBarrier_TrooperGame.Trooper;
import CyclicBarrier_TrooperGame.TrooperBase;
import CyclicBarrier_TrooperGame.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by toraj on 01/05/2017.
 */
public class TestTrooper {

    static TrooperBase trooperBase = new TrooperBase();

    @Before
    public void init() {

        for (int i = 1; i <=3 ; i++) {

            Trooper trooper = new Trooper();
            trooper.setName(Util.randomStringSolid(5));
            trooper.setArmor((short) (i * 10));
            trooper.setHealth((short) (i * 50));
            trooper.setAmmo(i * 1000);
            trooper.setStrength(i * 2000);
            trooper.setMana((short) (i * 200));
            //[Touraj] add New CyclicBarrier_TrooperGame.Trooper to Base

            trooperBase.addTrooper(trooper);

            System.out.println("CyclicBarrier_TrooperGame.Trooper Created : " + trooper.toString());

        }

    }

    @Test
    public void testPoll() {

        System.out.println("testPoll Begin...");

        Trooper tr = null;
        tr = trooperBase.pollTrooper();

        System.out.println("Trooper is : " + tr.toString());

        Assert.assertNotNull(tr);

    }

}
