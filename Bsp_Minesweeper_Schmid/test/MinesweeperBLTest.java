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
    public int row;

    @Parameterized.Parameter(value = 1)
    public int col;

    @Parameterized.Parameters(name = "Test")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
            {1, 4},
            {2, 2},
            {3, 5},
            {4, 1},
            {5, 1},
            {6, 3},
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
        MinesweeperBL bl = new MinesweeperBL(8, 20);
        int result = bl.setField(row, col);
        FieldValue value = bl.getStatus(row, col);
        int exp = determine(value);
        if(0 <= result && result <= 8){
            result = 1;
        }
        assertEquals(exp, result);
    }
    
    public int determine(FieldValue value){
        switch(value){
            case OPEN:
                return 1;
            case BOMB:
                return -1;
        }
        return -2;
    }
    
}
