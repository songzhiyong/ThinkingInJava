package com.jerome.basic;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 关于原子整型和一般整型
 * @author Jerome Song
 * 
 * 
 * There are two main uses of AtomicInteger:
 * As an atomic counter (incrementAndGet(), etc) that can be used by many threads concurrently
 * As a primitive that supports compare-and-swap instruction (compareAndSet()) to implement 
 * non-blocking algorithms.
 * Here is an example of non-blocking random number generator from Brian Göetz's Java Concurrency 
 * In Practice:
 * 

public class AtomicPseudoRandom extends PseudoRandom {
    private AtomicInteger seed;
    AtomicPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public int nextInt(int n) {
        while (true) {
            int s = seed.get();
            int nextSeed = calculateNext(s);
            if (seed.compareAndSet(s, nextSeed)) {
                int remainder = s % n;
                return remainder > 0 ? remainder : remainder + n;
            }
        }
    }
}
As you can see, it basically works almost the same way as incrementAndGet(), 
but performs arbitrary calculation (calculateNext()) instead of 
increment (and processes the result before return).
 *
 */
public class AtomicIntegerCompareTest {
	private int value;
	
	public AtomicIntegerCompareTest(int value){
		this.value = value;
	}
	
	public synchronized int increase(){
		return value++;
	}
	
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		
		AtomicIntegerCompareTest test = new AtomicIntegerCompareTest(0);
		for( int i=0;i< 10000000;i++){
			test.increase();
		}
		long end = System.currentTimeMillis();
		System.out.println("time elapse:"+(end -start));
		
		long start1 = System.currentTimeMillis();
		
		AtomicInteger atomic = new AtomicInteger(0);
		
		for( int i=0;i< 10000000;i++){
			atomic.incrementAndGet();
		}
		long end1 = System.currentTimeMillis();
		System.out.println("time elapse:"+(end1 -start1) );
		
		
	}
}
