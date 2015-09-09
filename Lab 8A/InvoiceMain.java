/*
 * Name: Joseph Godfrey
 * Date: 25/March/2015
 * Course: CSC 212
 * Program: Lab Ch8A 
 * 
 * Purpose: This program is a simple test program
 * for the Invoice class
 */
public class InvoiceMain {

	public static void main(String[] args) {

		Invoice purchaseOne = new Invoice("XP-101", "Glidden paint, gallon", 4,
				22.29);
		Invoice purchaseTwo = new Invoice("PB-203", "paint brush, 3 inch", 2,
				10.19);
		// Invoice purchaseThree = new Invoice("CC-105", "hammer", 1, -4.19);

		System.out.println("Purchase One: " + purchaseOne);
		System.out.println("Purchase Two: " + purchaseTwo);

		purchaseOne.setQuantity(6);
		purchaseTwo.setItemPrice(9.59);

		System.out.println(purchaseOne.getQuantity() + " of "
				+ purchaseOne.getPartNum() + " is $"
				+ purchaseOne.getInvoiceAmount());
		System.out.println(purchaseTwo.getQuantity() + " of "
				+ purchaseTwo.getPartNum() + " is $"
				+ purchaseTwo.getInvoiceAmount());

	}

}
