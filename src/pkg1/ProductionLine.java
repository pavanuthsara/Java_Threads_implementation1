package pkg1;

public class ProductionLine extends Thread {
	// rate of 1 product making - 1000ms
	public void run() {
		while(true) {
			synchronized(FactorySimulation.lock) {
				
				boolean canProduce = (FactorySimulation.inventory[0] >= 1) &&
                         (FactorySimulation.inventory[1] >= 2) &&
                         (FactorySimulation.inventory[2] >= 1);
				
				if(canProduce) {
					FactorySimulation.inventory[0] -= 1; 
					FactorySimulation.inventory[1] -= 2; 
					FactorySimulation.inventory[2] -= 1; 
					System.out.print("Product produced! ");
					System.out.print("Iron: " + FactorySimulation.inventory[0] + " ");
					System.out.print("Wood: " + FactorySimulation.inventory[1] + " ");
					System.out.println("Cement: " + FactorySimulation.inventory[2]);

					FactorySimulation.lock.notifyAll();
				} else {
					System.out.println("Waiting for supplies...");
					try {
						FactorySimulation.lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
