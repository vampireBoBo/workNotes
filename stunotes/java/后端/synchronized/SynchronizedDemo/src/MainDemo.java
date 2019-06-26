
public class MainDemo {
	
	/**
	 * 类锁
	 */
	public synchronized static void firstMath(){
		for(int i=0;i<6;i++){
			System.out.println("firstMath==="+Thread.currentThread().getName()+"====="+i);
		}
	}
	/**
	 * 对象锁
	 */
	public synchronized void methodMath(){
		for(int i=0;i<6;i++){
			System.out.println("methodMath==="+Thread.currentThread().getName()+"====="+i);
		}
	}
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		// 1、此处申明的Demo  对同一个对象 故只有一把锁
		MainDemo demo = new MainDemo();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 2===此处在进程内部申明对象  则每次调用为新的对象，新对象获得自己的锁  【此处申明对象 导致资源锁没有意义】
				//MainDemo demo = new MainDemo();
				demo.methodMath();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 2===此处在进程内部申明对象  则每次调用为新的对象，新对象获得自己的锁  【此处申明对象 导致资源锁没有意义】
				//MainDemo demo = new MainDemo();
				demo.methodMath();
			}
		});
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 2===此处在进程内部申明对象  则每次调用为新的对象，新对象获得自己的锁  【此处申明对象 导致资源锁没有意义】
				MainDemo.firstMath();
			}
		});
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 2===此处在进程内部申明对象  则每次调用为新的对象，新对象获得自己的锁  【此处申明对象 导致资源锁没有意义】
				MainDemo demo = new MainDemo();
				demo.firstMath();
			}
		});
		t3.start();
		t4.start();
	}
}
