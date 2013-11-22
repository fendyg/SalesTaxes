import java.text.DecimalFormat;
import java.util.ArrayList;


public class InputParser {
	
	/*
	 * Parse input string that is given and outputs the formatted string
	 * 
	 * list	[ArrayList<String>] : list of the input strings to be parsed
	 */
	public ArrayList<String> parse(ArrayList<String> list) {
		ArrayList<Goods> goodsList = createGoods(list);
		
		ArrayList<String> output = createOutputString(goodsList);
		
		return output;
	}
	
	/*
	 * Create Goods objects based on the input list
	 * 
	 * list	[ArrayList<String>] : list of the input strings to be parsed
	 */
	private ArrayList<Goods> createGoods(ArrayList<String> list) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		
		//Create Goods object for every line in the list
		for(String s : list) {
			int amount = Integer.parseInt(s.substring(0,1));
			String name = s.substring(2,s.lastIndexOf("at")-1);
			float price = Float.parseFloat(s.substring(s.lastIndexOf("at")+3));
			
			Goods g = new Goods(name,amount,price);
			goodsList.add(g);
		}
		return goodsList;
	}
	
	/*
	 * Creates output strings based on the Goods object collection
	 * 
	 * goodsList	[ArrayList<Goods>]: Object collection that contains the item information
	 */	
	private ArrayList<String> createOutputString(ArrayList<Goods> goodsList){
		ArrayList<String> output = new ArrayList<String>();
		DecimalFormat f = new DecimalFormat("####0.00");
		String outputString;
		double salesTaxes = 0;
		double grandTotal = 0;
		
		//loop through all objects in the list
		for(Goods g : goodsList) {
			outputString = "";
			outputString += g.getItemAmount() + " ";
			outputString += g.getItemName() + ": ";
			outputString += f.format(g.getTotalPrice());
			output.add(outputString);
			
			//increment sales tax and grand total
			salesTaxes += g.getItemTax();
			grandTotal += g.getTotalPrice();
		}
		output.add("Sales Taxes: " + f.format(salesTaxes));
		output.add("Total: " + f.format(grandTotal));
		
		return output;
	}
}
