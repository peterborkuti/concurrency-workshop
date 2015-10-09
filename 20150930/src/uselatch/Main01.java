package uselatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import common.Sleeper;

public class Main01 {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(8);

		Future<?> f = executor.submit(new Sleeper());

		f.get();

		f = executor.submit(new Sleeper());

		f.get();

	}

}
