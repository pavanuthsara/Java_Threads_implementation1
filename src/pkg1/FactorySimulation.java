package pkg1;

public class FactorySimulation {
	// maintains the inventory and handle the production
	// based on available inventory
	public static int[] inventory = {0,0,0};
	public static Object lock = new Object();
	
	
	public static void main(String[] args) {
		SupplierIron thread1 = new SupplierIron();
		SupplierWood thread2 = new SupplierWood();
		SupplierCement thread3 = new SupplierCement();
		thread1.start();
		thread2.start();
		thread3.start();
		
		ProductionLine thread4 = new ProductionLine();
		thread4.start();

	}
	
}
