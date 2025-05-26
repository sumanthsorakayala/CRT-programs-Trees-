// Java Program to demonstrate
// usage of Thread class

class MyThread extends Thread 
{
  	// Overriding the run method
  	@Override
    public void run() 
    {
        for (int i = 0; i < 5; i++) 
        {
            System.out.println(Thread.currentThread().getName()
                               + " - Count : " + i);
            
          	try {
              	// Sleep for 500 milliseconds
                Thread.sleep(500); 
            } 
          	catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

// Main Class
public class Threads 
{
    public static void main(String[] args) 
    {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

      	// Start thread 1
        thread1.start(); 
      
      	// Start thread 2
        thread2.start(); 
    }
}