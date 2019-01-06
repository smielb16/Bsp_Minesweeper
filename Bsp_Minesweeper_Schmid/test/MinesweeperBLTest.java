/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author elisc
 */
@RunWith(value = Parameterized.class)
public class MinesweeperBLTest {
    
    @Parameterized.Parameter(value = 0)
    public int col;

    @Parameterized.Parameter(value = 1)
    public int timesCalled;
    
    @Parameterized.Parameter(value = 2)
    public int colexp;

    @Parameterized.Parameters(name = "Test")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
            {1, 4, 6-4},
            {2, 2, 6-2},
            {3, 5, 6-5},
            {4, 1, 6-1},
            {5, 1, 6-1},
            {6, 3, 6-3},
        });
    }
    
    public MinesweeperBLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setField method, of class MinesweeperBL.
     */
    @Test
    public void testSetField() {
        System.out.println("setField");
        int row = 0;
        int col = 0;
        MinesweeperBL instance = null;
        int expResult = 0;
        int result = instance.setField(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
