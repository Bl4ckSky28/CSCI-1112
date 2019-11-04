/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This class is a multi-purpose list element container for shopping carts as it 
can act as an array element or a linked-list element 

It's chief purpose is to contain products and any other ancillary fields 
related to maintaining shopping cart data (like quantities)

Note that this class could be more generalized; however, it is specifically 
designed for the shopping cart application to make this problem a little easier.

authors: Grayson Buchholz, Aaron Coplan, James Taylor 
------------------------------------------------------------------------------*/
public class ListItem {

    // The product contained in this list item
    private final Product product;

    // The next field is only necessary for LinkedList based carts
    public ListItem next;
    public ListItem prev;
    //Any extra fields you need may go here
    public int quantity;
    public double discount = 0.0;
    // Parameterized constructor requires an instance of a Product be passed in
    // Note: You may modify theconstructor as needed
    public ListItem(Product product, int quantity, double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.next = null;
    }

    // Accessor to return the product contained by this list item    
    public Product getProduct() {
        return product;
    }

    // Accessor that sets the discount contained by this list item
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Accessor that sets the quantity contained by this list item
    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
}
