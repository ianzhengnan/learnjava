package ian.collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest{


	public static void main(String[] args){

		PriorityQueue pq = new PriorityQueue();

		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);
		pq.add(-5);

		System.out.println(pq);

		System.out.println(pq.poll());
		
		System.out.println(pq);


	}


}