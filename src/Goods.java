
public class Goods {
	private String itemName;
	private int itemAmount;
	private double itemPrice;
	private double itemTax;
	private boolean imported;
	private boolean taxable;
	
	/* 
	 * Define non taxable items for the scope of the project
	 * For future development: Goods object can be extended to multiple subclass 
	 * (Book,Food,Medical) to facilitate custom attributes and easier tax calculation
	 */
	private String[] nonTaxableItems = {
			"book",
			"chocolate",
			"headache pills"
	};
	
	public Goods(String name, int amount, double price){
		this.itemName = name;
		this.itemAmount = amount;
		this.itemPrice = price;
		this.taxable = isTaxable(name);
		this.imported = isImported(name);
		this.itemTax = calculateTax(this.taxable,this.imported,this.itemPrice);
	}
	
	/* Getter */
	public String getItemName(){
		return this.itemName;
	}
	
	public int getItemAmount(){
		return this.itemAmount;
	}
	
	public double getItemTax(){
		return this.itemTax;
	}
	
	public double getTotalPrice(){
		return this.itemAmount * (this.itemPrice+this.itemTax);
	}
	
	/*
	 * Check passed itemName and returns false if the item name is listed
	 * as a non-taxable item
	 * Exempt items are: books, food, medical products
	 * 
	 * itemName	[String]: item name to be checked
	 */
	private boolean isTaxable(String itemName){
		int itemListLength = nonTaxableItems.length;
		//Loop through all nonTaxableItems
		for(int i=0; i<itemListLength; i++){
			if(itemName.toLowerCase().contains(nonTaxableItems[i])){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Check passed itemName and returns true if item is imported
	 * 
	 * itemName	[String]: item name to be checked
	 */
	private boolean isImported(String itemName){
		if(itemName.toLowerCase().contains("imported")){
			return true;
		}
		return false;
	}
	
	/*
	 * Calculate tax based on whether the item is imported or taxable
	 * 
	 * taxable	[boolean]: If the item is a taxable item
	 * imported	[boolean]: If the item is an imported item
	 * 
	 */
	private double calculateTax(boolean taxable, boolean imported, double price) {
		double itemTax=0, basicTax=0, importedTax=0;
		
		if(taxable){
			basicTax = 0.1 * price;
			//round up to the nearest 5 cents
			basicTax = Math.ceil(basicTax * 20.0) / 20.0;
			itemTax += basicTax;
		}
		
		if(imported){
			importedTax = 0.05 * price;
			//round up to the nearest 5 cents
			importedTax = Math.ceil(importedTax * 20.0) / 20.0;
			itemTax += importedTax;
		}
		
		return itemTax;
	}
	
}
