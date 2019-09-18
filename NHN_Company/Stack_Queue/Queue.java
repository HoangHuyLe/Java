package com.nhn;

public interface Queue
{
	public Object front();
	public void enqueue(Object o);
	public Object dequeue();
}
