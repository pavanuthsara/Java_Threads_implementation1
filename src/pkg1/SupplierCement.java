package pkg1;

public class SupplierCement extends Thread {
	//supplier cement 1 material every 600 ms
	public void run() {
		while(true) {
			synchronized(FactorySimulation.lock) {
				FactorySimulation.inventory[2] += 1; 
				System.out.println("Suppied 1 cement. Cement inventory: " + FactorySimulation.inventory[2]);
				
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
