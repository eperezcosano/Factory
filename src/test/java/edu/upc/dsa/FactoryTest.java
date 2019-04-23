package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryTest {

    Command command;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        command = null;
    }

    @Test
    public void testFactory() {

        //Load C1
        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", command.execute());

        //In cache C1
        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", command.execute());

        //In cache C1
        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", command.execute());

        //Load C2
        command = CommandFactory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", command.execute());

        //In cache C2
        command = CommandFactory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", command.execute());

        //In cache C1
        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", command.execute());
    }
}
