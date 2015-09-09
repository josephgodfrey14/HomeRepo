/*
 * Name: Joseph Godfrey
 * Date: 25/March/2015
 * Course: CSC 212
 * Program: Lab Ch8A 
 * 
 * Purpose: An invoice object represents the information
 * of the purchase of an item from a store
 */

public class Invoice {

	// fields
	private String partNum;
	private String partDescription;
	private int quantity;
	private double itemPrice;

	// constructor
	public Invoice(String partNum, String partDescription, int quantity,
			double itemPrice) {
		setPartNum(partNum);
		setPartDescription(partDescription);
		setQuantity(quantity);
		setItemPrice(itemPrice);

	}

	// instance methods
	// return a string of the invoice object

	// accessors

	public String toString() {// returns the string representation of the
								// invoice
		return "Part " + partNum + ", " + partDescription + " purchase "
				+ quantity + " items at $" + itemPrice + " each";
	}

	public String getPartNum() {// returns the part number
		return partNum;
	}

	public String getPartDescription() {// returns the part description
		return partDescription;
	}

	public int getQuantity() {// returns the part quantity
		return quantity;
	}

	public double getItemPrice() {// returns the part price
		return itemPrice;
	}

	public double getInvoiceAmount() {// calculates and returns the total $ of
										// the invoice
		return (quantity * itemPrice);
	}

	// mutators
	/*
	 * // constructor helper public void setFields(String partNum, String
	 * partDescription, int quantity, double itemPrice){ if
	 * (partNum.equals(null) || partDescription.equals(null) || quantity < 1 ||
	 * itemPrice <= 0.0){ throw new IllegalArgumentException(); } this.partNum =
	 * partNum; this.partDescription = partDescription; this.quantity =
	 * quantity; this.itemPrice = itemPrice; }
	 */
	public void setPartNum(String partNum) {// sets the part number
		this.partNum = partNum;
	}

	public void setPartDescription(String partDescription) {// sets the part
															// description
		this.partDescription = partDescription;
	}

	public void setQuantity(int quantity) {// sets the part quantity
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity is invalid");
		}
		this.quantity = quantity;
	}

	public void setItemPrice(double itemPrice) {// sets the price per part
		if (itemPrice < 0.0) {
			throw new IllegalArgumentException("Price per item is invalid");
		}
		this.itemPrice = itemPrice;
	}

}
