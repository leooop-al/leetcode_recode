package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.merge("123", 1, Integer::sum);
        map.merge("123", 4, Integer::sum);
        System.out.println(map);
    }

}
