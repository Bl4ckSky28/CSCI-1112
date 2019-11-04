/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This class implements the core ideas of the data structures used to implement 
a shopping cart. When products are added to the cart, they are added to the
list. When products are removed from a cart, they are removed from the list.

authors: Grayson Buchholz, Aaron Coplan, James Levy, James Taylor 
------------------------------------------------------------------------------*/
import java.lang.Math;
public class List {

    public enum Type {
        ARRAY,
        LINKEDLIST
    }
 
    // Type of list drives how the list is managed internally
    private final Type type;
    // For a linked-list based list, the head pointer
    private ListItem head;
    private ListItem tail;
    // For an array-based list, the array itself
    private ListItem[] array;
    // The counter to track the number of elements in the list
    private int count;
 
    // Parameterized constructor.  The list type must be provided at 
    // construction because it is used as a switch to determine how the 
    // functions must behave 
    public List(Type type) {
        this.type = type;
        count = 0;
        if(type == Type.ARRAY) {
            array = new ListItem[2];
        } else if(type == Type.LINKEDLIST) {
            head = null;
        }
    }
    
    public void add(Product product, int quantity, double discount) {
        // Determines if product already exists in shopping cart
        boolean found = false;
        if(type == Type.ARRAY) {
            // First position in array is empty
            if(array[0] == null) {
                array[0] = new ListItem(product, quantity, discount);
                count++;
            }
            // Second position in array is empty
            else if(array[1] == null && array[0].getProduct().compareTo(product) != 0) {
                array[1] = new ListItem(product, quantity, discount);
                count++;
            }
            else {
                for(int i=0; i<array.length; i++) {
                    // Check if product exists in shopping cart
                    if(array[i].getProduct().compareTo(product) == 0) {
                        // Change quantity of product
                        array[i].setQuantity(quantity);
                        found = true;
                        break;
                    }
                }
                // Product does not exist in cart
                if(!found) {
                    // Increase array size by one to accommodate new product
                    ListItem[] copy = new ListItem[array.length + 1];
                    for(int i=0; i<array.length; i++) {
                        // Copy elements into new array
                        copy[i] = array[i];
                        // Add new product at the end
                        copy[array.length] = new ListItem(product, quantity, discount); 
                    }
                    // Set copy to original array
                    array = copy;
                    count++;
                }
            }

        } else if(type == Type.LINKEDLIST) {
            // Shopping cart is empty
            if(head == null) {
                // Head becomes new product
                head = new ListItem(product, quantity, discount);
                // Tail is the same as the head since there is only one item
                tail = head;
                tail.next = null;
                tail.prev = null;
                count++;
            // New product is the same as head
            } else if(head.getProduct().compareTo(product) == 0) {
                // Product already exists in cart so increment quantity
                head.setQuantity(quantity);
            } else {
                ListItem current = head;
                while(current.next != null) {
                    // Check if product exists in cart
                    if(current.next.getProduct().compareTo(product) != 0) {
                        current = current.next;
                    } else {
                        // Increment quantity 
                        current.next.setQuantity(quantity);
                        found = true;
                        break;
                    }
                }
                // Product does not exist in cart
                if(!found) {
                    // Adjust head and tail to accommodate new product
                    current.next = new ListItem(product, quantity, discount);
                    current.next.next = null;
                    current.next.prev = tail;
                    tail.next = current.next;
                    tail = current.next;
                    count++;
                }
            }
        }
    }
  
    public boolean remove(Product product) {
        boolean found = false;
        if(type == Type.ARRAY) {
            ListItem[] copy = null;
            for(int i=0; i < array.length; i++) {
                // Check if product exists in cart
                if(array[i].getProduct().compareTo(product) == 0) {
                    found = true;
                    // Decrease array size by one to represent removal of product
                    copy = new ListItem[array.length-1];
                    // Copy elements of array not including removed product
                    for(int j=0; j < i; j++) 
                        copy[j] = array[j];
                    // Copy elements of array after removed product
                    for(int k=i; k < array.length-1; k++) 
                        copy[k] = array[k+1];
                    break;
                }
            }
            // Only set copy to new array if a product is removed
            if(found)
                array = copy;
        } else if(type == Type.LINKEDLIST) {
            // Head is empty, so a product is not removed
            if(head == null)
                return found;
            // Head is product to be removed
            else if(head.getProduct().compareTo(product) == 0) {
                head = head.next;
                found = true;
            // Tail is product to be removed
            } else if(tail.getProduct().compareTo(product) == 0) {
                tail = tail.prev;
                found = true;
            } else {
                // Product to be removed is between head and tail
                ListItem current = head;
                while(current.next != null) {
                    // Check if product exists in cart
                    if(current.next.getProduct().compareTo(product) == 0) {
                        // Skip node
                        current.next = current.next.next;
                        found = true;
                    }
                    if(current.next != null)
                        current = current.next;
                }
            }
        }
        count--;
        return found;
    }
    
    public void clear() {
        if(type == Type.ARRAY) {
            // Set array to new empty array
            array = new ListItem[2];
        } else if(type == Type.LINKEDLIST) {
            // Head is null, so list is empty
            head = null;
        }
        count = 0;
    }
    
    public boolean isEmpty() {
        if(count == 0)
            return true;
        return false;
    }
    
    public int length() {
        return count;
    }
    
    public Product get(int i) {
        if(type == Type.ARRAY) {
            // Access product for given listItem
            return array[i].getProduct();
        } else if(type == Type.LINKEDLIST) {
            ListItem current = head;
            // Keep track of position in list
            int index = 0;
            // Iterate through list
            while(current != null) {
                // Compare position to desired position
                if(i == index) 
                    return current.getProduct();
                index++;
                current = current.next;
            }
        }
        // Position out of range, so return null
        return null;
    }

    public double subtotal() {
        double cost = 0.0;
        if(type == Type.ARRAY) {
            // Sum cost
            for(int i=0; i < count; i++)
                // Cost = product price with discount applied * quantity
                cost += (array[i].getProduct().getPrice() - (array[i].getProduct().getPrice() * array[i].discount)) * array[i].quantity;
        
        } else if(type == Type.LINKEDLIST) {
            ListItem current = head;
            while(current != null) {
                // Cost = product price with discount applied * quantity
                cost += (current.getProduct().getPrice() - (current.getProduct().getPrice() * current.discount)) * current.quantity;
                current = current.next;
            }
        }
        // Round cost to 2 decimal places
        double scale = Math.pow(10, 2);
        return Math.round(cost * scale) / scale;
    }

    public boolean applyDiscount(Product product, double discount) {
        double price = 0.0;
        if(type == Type.ARRAY) {
            // Ensure that discount is between 0 and 1
            if(0.0 < discount && discount < 1.0) {
                for(int i=0; i < array.length; i++) {
                    // Check if product exists in cart
                    if(array[i].getProduct().compareTo(product) == 0) {
                        // Set discout of item
                        array[i].setDiscount(discount);
                        return true;
                    }
                }
            }
        } else if(type == Type.LINKEDLIST) {
            // Ensure that discount is between 0 and 1
            if(0.0 < discount && discount < 1.0) {
                ListItem current = head;
                while(current != null) {
                    // Check if product exists in cart
                    if(current.getProduct().compareTo(product) == 0) {
                        // Set discount of item
                        current.setDiscount(discount);
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

   
    public String toString() {
        String s = "[";
        int i = 0;
        if(type == Type.ARRAY) {
            if(array[0] == null)
                i++;
            else {
                s += array[i].getProduct().getName() + ": " + array[i].getProduct().getPrice() + ": " + array[i].quantity + ": " + array[i].discount;
                i++;
            }
            if(array[1] == null) 
                i++;
            else {
                s += ", ";
                s += array[i].getProduct().getName() + ": " + array[i].getProduct().getPrice() + ": " + array[i].quantity + ": " + array[i].discount;
                i++;
            }
            while(i < array.length) {
                if(i > 0)
                    s += ", ";
                s += array[i].getProduct().getName() + ": " + array[i].getProduct().getPrice() + ": " + array[i].quantity + ": " + array[i].discount;
                i++;
            }
            s += "]";
        } else if(type == Type.LINKEDLIST) {
            ListItem current = head;
            for(int j=0; j < count; j++) {
                if(j > 0)
                    s += ", ";
                s += current.getProduct().getName() + ": " + current.getProduct().getPrice() + ": " + current.quantity + ": " + current.discount;
                current = current.next;
            }
            s += "]";
        }
        return s; 
    }
}
