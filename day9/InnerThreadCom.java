package com.org.genpact.assign.day9;
class Q{
	int i;
	boolean valueset=false;
	
	synchronized void produce(int i) {
		if(valueset)
			try {
//				wait();
			} catch (Exception e) {
				
			}
		this.i=i;
		valueset = true;
		System.out.println("data produced "+i);
//		notify();
	}
	
	synchronized int consume() {
		if(!valueset)
			try {
//				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		System.out.println("data consumed "+i);
		valueset=false;
//		notify();
		return i;
	}
}

class Producer extends Thread{
	Q q;

	public Producer(Q q) {
		super();
		this.q = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		q.produce(5);
	}
}

class Consumer extends Thread{
	Q p;

	public Consumer(Q p) {
		super();
		this.p = p;
	}
	
	@Override
	public void run() {
		int value = p.consume();
		System.out.println("consumed :"+value);
	}
	
	
}


public class InnerThreadCom {
	public static void main(String[] args) {
		Q q = new Q();
		Producer p1 = new Producer(q);
		Consumer c1 = new Consumer(q);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		c1.start();
		
		
		
	}
}
