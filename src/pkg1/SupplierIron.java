package pkg1;

public class SupplierIron extends Thread {
	//supplier iron 1 material every 600 ms
	public void run() {
		while(true) {
			synchronized(FactorySimulation.lock) {
				FactorySimulation.inventory[0] += 1; 
				System.out.println("Suppied 1 iron. Iron inventory: " + FactorySimulation.inventory[0]);
				
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
