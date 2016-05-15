package ian.threads;

import java.util.concurrent.RecursiveTask;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

class CalTask extends RecursiveTask<Integer>{

	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;

	//累加从start到end的元素
	public CalTask(int[] arr, int start, int end){
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute(){
		int sum = 0;
		if (end - start < THRESHOLD) {
			for (int i = start; i < end ; i++) {
				sum += arr[i];
			}
			return sum;
		}else{
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			//
			left.fork();
			right.fork();
			// 累加返回值
			return left.join() + right.join();
		}
	}
}

public class Sum{

	public static void main(String[] args) throws Exception{
		int[] arr = new int[100];
		Random rand = new Random();
		int total = 0;

		for (int i = 0, len = arr.length; i < len ; i++) {
			int tmp = rand.nextInt(20);
			total += (arr[i] = tmp);
		}
		// 这个值是为了验证下面计算的是否正确
		System.out.println(total);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		// 获得多线程的返回值求和结果
		System.out.println(future.get());
		// 关闭线程池
		pool.shutdown();
	}
}