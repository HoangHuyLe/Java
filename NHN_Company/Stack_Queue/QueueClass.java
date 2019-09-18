package com.nhn;

public class QueueClass implements Queue{

    private Object[] q; //Queue
    private int qs; //Queue size
    private int qc; //Queue counter

    public static final int DEFAULT_SIZE=5;

    private int index;

    public QueueClass(int initialCapacity){
        if(initialCapacity < 1)
            throw new IllegalArgumentException ("initialCapacity must be >= 1");
        q = new Object[initialCapacity];
        qs = initialCapacity;
        qc = 0;
    }

    public QueueClass(){
        q = null;
        qs = qc = 0;
    }

    public boolean isempty(){
        return qc==0;
    }

    public boolean isfull(){
        return (qc == qs);
    }

    public void enqueue(Object obj){
        if (isfull())
            return;
        q[qc] = obj;
        qc++;
    }

    public Object dequeue() {
        if(isempty())
            return null;
        Object obj = q[0];
        for(int i =0; i<qc-1; i++){
            q[i]=q[i+1];
        }
        qc--;
        return obj;

    }

    public Object front(){
        if(isempty())
            return null;
        return q[0];
    };

    /**
     * This functin return Queue array
     * @return object
     */
    public Object[] getQueue() {
        return q;
    }

    /**
     * This function get queue counter
     * @return int type
     */
    public int getQC() {
        return qc;
    }
}
