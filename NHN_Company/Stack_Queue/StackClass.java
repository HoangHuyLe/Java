package com.nhn;

public class StackClass implements Stack {

    private Object[] stk; // Stack
    private int SS;   // Stack Size
    private int SC;   // Stack Counter


    public StackClass(int initialCapacity)
    {
        if(initialCapacity < 1)
            throw new IllegalArgumentException ("initialCapacity must be >= 1");

        stk = new Object[initialCapacity];
        SS = initialCapacity;
        SC = 0;
    }

    public StackClass()
    {
        stk = null;
        SS = SC = 0;
    }

    public Object[] getStack(){
        return stk;
    }

    public void push(Object o)
    {
        if( isfull() )
            return;

        stk[SC] = o;
        SC++;
    }

    public Object pop()
    {
        if( isempty() )
            return null;
        return stk[--SC];
    }

    public Object top(){
        if( isempty() )
            return false;
        return stk[SC - 1];
    };



    public boolean isfull()
    {
        return( SC==SS );
    }

    public boolean isempty()
    {
        return( SC==0 );
    }

    public int getSC(){
        return SC;
    }
}

