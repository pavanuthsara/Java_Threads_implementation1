package pkg1;

public class  SupplierWood extends Thread{
	//supplier wood 1 material every 600 ms
	public void run() {
		while(true) {
			synchronized(FactorySimulation.lock) {
				FactorySimulation.inventory[1] += 1; 
				System.out.println("Suppied 1 wood. Wood inventory: " + FactorySimulation.inventory[1]);
				
				FactorySimulation.lock.notifyAll();
				
			}
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
