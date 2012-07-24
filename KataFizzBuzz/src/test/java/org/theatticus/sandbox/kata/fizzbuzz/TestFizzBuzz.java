package org.theatticus.sandbox.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFizzBuzz
{
    FizzBuzz fizzBuzz;

    @Before
    public void createMyFizzBuzz()
    {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void giveMeOne()
    {
        String reply = fizzBuzz.go( 1 );

        Assert.assertNotNull( reply );
        Assert.assertEquals( "1", reply );
    }

    @Test
    public void giveMeTwo()
    {
        String reply = fizzBuzz.go( 2 );

        Assert.assertEquals( "2", reply );
    }

    @Test
    public void giveMeThree()
    {
        String reply = fizzBuzz.go( 3 );

        Assert.assertEquals( "fizz", reply );
    }

    @Test
    public void giveMeFive()
    {
        String reply = fizzBuzz.go( 5 );

        Assert.assertEquals( "buzz", reply );
    }

    @Test
    public void giveMeSix()
    {
        String reply = fizzBuzz.go( 6 );

        Assert.assertEquals( "fizz", reply );
    }

    @Test
    public void giveMeTen()
    {
        String reply = fizzBuzz.go( 10 );

        Assert.assertEquals( "buzz", reply );
    }

    @Test
    public void giveMe15()
    {
        String reply = fizzBuzz.go( 15 );

        Assert.assertEquals( "fizzbuzz", reply );
    }

    @Test
    public void giveMe45()
    {
        String reply = fizzBuzz.go( 45 );

        Assert.assertEquals( "fizzbuzz", reply );
    }

    @Test
    public void giveMe100()
    {
        String reply = fizzBuzz.go( 100 );

        Assert.assertEquals( "buzz", reply );
    }
    
    /*****************************
     *         STAGE 2           * 
     *****************************/
    
    @Test
    public void giveMe31()
    {
        String reply = fizzBuzz.go( 31 );

        Assert.assertEquals( "fizz", reply );
    }
    
    @Test
    public void giveMe43()
    {
        String reply = fizzBuzz.go( 43 );

        Assert.assertEquals( "fizz", reply );
    }
    
    @Test
    public void giveMe73()
    {
        String reply = fizzBuzz.go( 73 );

        Assert.assertEquals( "fizz", reply );
    }
    
    @Test
    public void giveMe52()
    {
        String reply = fizzBuzz.go( 52 );

        Assert.assertEquals( "buzz", reply );
    }
}
