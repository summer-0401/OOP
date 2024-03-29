import java.util.*;

public class ProdConSelfTest {
	private Buffer buffer;
	private Producer producer;
	private Consumer consumer;
	
	public ProdConSelfTest() {
		buffer = new Buffer(15);
		producer = new Producer(buffer);
		consumer = new Consumer(buffer);
	}
	
	private class Producer extends Thread{
		private final Buffer buffer;
		
		public Producer(Buffer buf) {
			buffer = buf;
		}
		
		public void produce() throws InterruptedException{
			Random rand = new Random();
			for(int i=0;i<buffer.getSize();i++)
				buffer.add(rand.nextDouble()*100);
		}
		
		public void run() {
			try{
				produce();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class Consumer extends Thread{
		private final Buffer buffer;
		
		public Consumer(Buffer buf) {
			buffer = buf;
		}
		
		public void consume() throws InterruptedException{
			for(int i=buffer.getSize();i>=0;i--)
				buffer.remove();
		}
		
		public void run() {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startThread() {
		producer.start();
		consumer.start();
	}
}
