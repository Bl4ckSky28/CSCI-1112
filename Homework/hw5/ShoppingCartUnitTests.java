/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program performs unit testing on the ShoppingCart class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/

public class ShoppingCartUnitTests {
	// The master list of products
	static Product[] inventory = InventoryHelper.getMultipleProducts();

	// ------------------------------------------------------------------------
    // Entry Point
    // ------------------------------------------------------------------------
    /// Entry Point.  The main program executes a set of UnitTests on the 
    /// various methods in the ShoppingCart class to test different levels of 
    /// functionality.
	public static void main(String[] args) {
		
		if(testConstructor()) 
			System.out.println("testConstructor: succeeded");
		else 
			System.out.println("testConstructor: failed");

		if(testAdd()) 
			System.out.println("testAdd: succeeded");
		else 
			System.out.println("testAdd: failed");

		if(testGet())
			System.out.println("testGet: succeeded");
		else
			System.out.println("testGet: failed");

		if(testRemove())
			System.out.println("testRemove: succeeded");
		else
			System.out.println("testRemove: failed");

		if(testClear())
			System.out.println("testClear: succeeded");
		else
			System.out.println("testClear: failed");

		if(testAddAgain())
			System.out.println("testAddAgain: succeeded");
		else
			System.out.println("testAddAgain: failed");

		if(testSubTotal()) 
			System.out.println("testSubTotal: succeeded");
		else
			System.out.println("testSubTotal: failed");

		if(testCheckOut()) 
			System.out.println("testCheckOut: succeeded");
		else
			System.out.println("testCheckOut: failed");

		if(testQuantity()) 
			System.out.println("testQuantity: succeeded");
		else
			System.out.println("testDiscount: failed");

		if(testDiscount()) 
			System.out.println("testDiscount: succeeded");
		else
			System.out.println("testDiscount: failed");
		
	}
	// ------------------------------------------------------------------------
	/// Validates that a new cart of both types is constructred correctly
	public static boolean testConstructor() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		// Validate that both carts are empty
		if(!arraycart.isEmpty() || !llcart.isEmpty())
			return false;

		// Validate the length of both carts is zero
		if (arraycart.length() != 0 || llcart.length() != 0)
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that add method works correctly
	public static boolean testAdd() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		// Implement add method
		arraycart.add(InventoryHelper.getSingleProduct(), 1, 0.0);
		llcart.add(InventoryHelper.getSingleProduct(), 1, 0.0);
		
		// Validate that both carts are not empty
		if(arraycart.isEmpty() || llcart.isEmpty()) 
			return false;

		// Validate that length of both carts is expected length
		if(arraycart.length() != 1 || llcart.length() != 1)
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that get method works correctly 
	public static boolean testGet() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}

		// Validate that products are in expected positions in both carts
		if(arraycart.get(0).compareTo(inventory[0]) != 0 || arraycart.get(1).compareTo(inventory[1]) != 0 || arraycart.get(2).compareTo(inventory[2]) != 0)
			return false;
		if(llcart.get(0).compareTo(inventory[0]) != 0 || llcart.get(1).compareTo(inventory[1]) != 0 || llcart.get(2).compareTo(inventory[2]) != 0)
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that remove method works correctly
	public static boolean testRemove() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}
		
		Product wrongProduct = new Product("Phone", 1000.0);
		Product singleProduct = inventory[2];
		arraycart.remove(singleProduct);
		llcart.remove(singleProduct);

		// Validate that both carts are not empty
		if(arraycart.isEmpty() || llcart.isEmpty())
			return false;

		// Validate that length of both carts is expected length
		if(arraycart.length() != 2 || llcart.length() != 2)
			return false;

		// Validate that products are in expected positions in both carts
		if(arraycart.get(0).compareTo(inventory[0]) != 0 || arraycart.get(1).compareTo(inventory[1]) != 0 || llcart.get(0).compareTo(inventory[0]) != 0 || llcart.get(1).compareTo(inventory[1]) != 0)
			return false;

		// Validate that product not in cart cannot be removed
		if(arraycart.remove(wrongProduct) || llcart.remove(wrongProduct))
			return false;
		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that clear method works correctly
	public static boolean testClear() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}
		
		// Validate that both carts are filled correctly
		if(!arraycart.isEmpty() && !llcart.isEmpty() && arraycart.length() == 3 && llcart.length() == 3) {
			// Implement clear
			arraycart.clear();
			llcart.clear();

			// Validate that both carts are empty
			if(!arraycart.isEmpty() || !llcart.isEmpty())
				return false;

			// Validate that both carts are expected length
			if(arraycart.length() != 0 || llcart.length() != 0)
				return false;
		}
		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that products can be added to a previously emptied cart
	public static boolean testAddAgain() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		arraycart.add(InventoryHelper.getSingleProduct(), 1, 0.0);
		llcart.add(InventoryHelper.getSingleProduct(), 1, 0.0);

		arraycart.clear();
		llcart.clear();

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}

		// Validate that both carts are not empty
		if(arraycart.isEmpty() || llcart.isEmpty()) 
			return false;

		// Validate that both carts are expected length
		if(arraycart.length() != 3 || llcart.length() != 3)
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that subtotal method works correctly
	public static boolean testSubTotal() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}
		
		// Validate that subtotal for both carts is correct
		if(arraycart.subtotal() != 175.48 || llcart.subtotal() != 175.48)
			return false;
		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that checkout method works correctly
	public static boolean testCheckOut() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}

		// Validates that subtotal for both carts is correct
		if(arraycart.subtotal() != 175.48 || llcart.subtotal() != 175.48)
			return false;

		// Validates that final total for both carts is correct
		if(arraycart.checkout(0.05) != 184.25 || llcart.checkout(0.05) != 184.25)
			return false;

		// Validates that both carts are empty
		if(!arraycart.isEmpty() || !llcart.isEmpty())
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that quantities work correctly
	public static boolean testQuantity() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}
		arraycart.add(inventory[0], 1, 0.0);
		llcart.add(inventory[0], 1, 0.0);

		// Validate that both carts are expected length
		if(arraycart.length() != 3 || llcart.length() != 3)
			return false;

		// Validate that subtotals are as expected
		if(arraycart.subtotal() != 180.97 || llcart.subtotal() != 180.97)
			return false;

		return true;
	}
	// -----------------------------------------------------------
	/// Validates that discounts are applied correctly
	public static boolean testDiscount() {
		ShoppingCart arraycart = new ShoppingCart(List.Type.ARRAY);
		ShoppingCart llcart = new ShoppingCart(List.Type.LINKEDLIST);

		for(Product product : inventory) {
			arraycart.add(product, 1, 0.0);
			llcart.add(product, 1, 0.0);
		}

		arraycart.applyDiscount(inventory[0], 0.5);
		llcart.applyDiscount(inventory[0], 0.5);

		// Validate that subtotals are as expected
		if(arraycart.subtotal() != 172.74 || llcart.subtotal() != 172.74)
			return false;

		return true;
	}
}
