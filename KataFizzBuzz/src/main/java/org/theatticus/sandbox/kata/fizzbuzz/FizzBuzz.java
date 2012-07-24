package org.theatticus.sandbox.kata.fizzbuzz;

public class FizzBuzz
{
    public String go( int index )
    {
        String reply = "";
        String strIndex = String.valueOf( index );
        
        reply = filterTheThree( index, reply, strIndex );
        reply = filterTheFive( index, reply, strIndex );
        reply = filterOtherNumbers( reply, strIndex );

        return reply;
    }

    private String filterOtherNumbers( String reply, String strIndex )
    {
        if ( reply.isEmpty() )
        {
            reply = strIndex;
        }
        return reply;
    }

    private String filterTheFive( int index, String reply, String strIndex )
    {
        if ( index % 5 == 0 || strIndex.contains( "5" ))
        {
            reply = reply.concat( "buzz" );
        }
        return reply;
    }

    private String filterTheThree( int index, String reply, String strIndex )
    {
        if ( index % 3 == 0 || strIndex.contains( "3" ) )
        {
            reply = reply.concat( "fizz" );
        }
        return reply;
    }
}
