package second;

import java.util.Scanner;


public class ThreadTest extends Thread{
    String name;
	long start, end;
	long ans;
	int x;
		
	public ThreadTest(String name, long start, long end, int x) {
	    this.name=name;
	    this.start=start;
	    this.end=end;
	    this.x=x;
	}
		
	public void run() { 
	       for (long i = start; i < end; i++) { 
	           if (contain(i, x)) ans += i; 
	       }
	}
		
	private boolean contain(long num, int x) { 
	    return String.valueOf(num).contains(String.valueOf(x)); 
	}
	
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int x=sc.nextInt();
		 ThreadTest thread1=new ThreadTest("thread1", 1, 250000000, x);
		 ThreadTest thread2=new ThreadTest("Thread2", 250000000, 500000000, x);
		 ThreadTest thread3=new ThreadTest("Thread3", 500000000, 750000000, x);
		 ThreadTest thread4=new ThreadTest("Thread4", 750000000, 1000000000, x);
		 thread1.start();
		 thread2.start();
		 thread3.start();
		 thread4.start();
		 while(true) {
             if((thread1.isAlive()||thread2.isAlive()||thread3.isAlive()||thread4.isAlive())==false) {
            	 long sum=thread1.ans+thread2.ans+thread3.ans+thread4.ans;
                 System.out.println(sum); 
                 break; 
             }
	     }	
	 }
}