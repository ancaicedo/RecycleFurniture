/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.io.*;
import java.util.Vector;

/**
 * OrderForm is a simple class that produces the formatted order form in a .txt format. 
 * It contains private variables for each part of the form and a Boolean variable.
 */

public class OrderForm {
    private String furniture;
    private String type;
    private String manufacturer;
    private Boolean overflow;
    private int amount;
    private int price = 0;
    private Vector<String> ID;

    // Constructor
    public OrderForm() {
    }
    
    /**
     * @summary Fills OrderForm class with results from user input
     * 
     * @description Uses stored user input values and SQL library 
     * to initialize all the fields of the OrderForm class 
     * 
     * @param f, a, ids, p, m, t, b
     * 
     * @return
     */
    public OrderForm(String f, int a, Vector<String> ids, Vector<Integer> p, String m, String t, Boolean b) {
        this.furniture = f;
        this.type = t;
        this.manufacturer = m;
        this.overflow = b;
        this.amount = a;
        this.ID = ids;

        int l = p.size();
        for (int i = 0; i < l; i++) {
            this.price += p.get(i);
        }
    }

    // Generate order form
     /**
     * @summary Outputs the order into a .txt file
     * 
     * @description Produces a formatted order in a .txt format. If an order is not possible, 
     * it outputs the names of suggested manufacturers that sell the requested furnitrue.
     * 
     * @param
     * 
     * @return 
     */
    public void generateOrder() throws IOException {
        try {
            File myOutput = new File("order.txt");
            FileWriter myWriter = new FileWriter(myOutput);
            myWriter.write("Furniture Order Form\n\n");

            myWriter.write("Faculty Name:\n");
            myWriter.write("Contact:\n");
            myWriter.write("Date:\n\n");

            myWriter.write("Original Request: " + this.type + " " + this.furniture + ", " + this.amount + "\n\n");

            if (!ID.isEmpty()) {
                myWriter.write("Items Ordered\n");
                for (int i = 0; i < this.ID.size(); i++) {
                    myWriter.write("ID: " + this.ID.get(i) + "\n");
                }
                myWriter.write("Total Price: $" + this.price);

                if (overflow) {
                    myWriter.write("\n\n");
                }
                
            }

            if (overflow) {
                myWriter.write("Complete order could not be fulfilled based on current inventory.\n");
                myWriter.write("Try reducing the amount of furniture requested or visit any of these manufacturers:\n");
                myWriter.write(manufacturer);
            }

            myWriter.write("\n\nThank you, come again :)");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred with IO.");
            e.printStackTrace();
        }
    }

    // Getters
     /**
     * @summary Returns furniture variable
     * 
     * @description Returns private String variable furniture from class OrderForm
     * 
     * @param
     * 
     * @return furniture
     */
    public String getFurniture() {
        return this.furniture;
    }
     /**
     * @summary Returns type variable
     * 
     * @description Returns private String variable type from class OrderForm
     * 
     * @param
     * 
     * @return type
     */
    public String getType() {
        return this.type;
    }
    
     /**
     * @summary Returns manufacturer variable
     * 
     * @description Returns private String variable manufacturer from class OrderForm
     * 
     * @param
     * 
     * @return manufacturer
     */
    public String getManufacturer() {
        return this.manufacturer;
    }
    
    /**
     * @summary Returns overflow variable
     * 
     * @description Returns private Boolean variable overflow from class OrderForm
     * 
     * @param
     * 
     * @return overflow
     */
    public Boolean getOverflow() {
        return this.overflow;
    }
    
    /**
     * @summary Returns amount variable
     * 
     * @description Returns private int variable amount from class OrderForm
     * 
     * @param
     * 
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }
    
    /**
     * @summary Returns price variable
     * 
     * @description Returns private int variable price from class OrderForm
     * 
     * @param
     * 
     * @return price
     */
    public int getPrice() {
        return this.price;
    }
    
    /**
     * @summary Returns ID variable
     * 
     * @description Returns private int variable ID from class OrderForm
     * 
     * @param
     * 
     * @return ID
     */
    public Vector<String> getID() {
        return this.ID;
    }

    // Setters
    /**
     * @summary Sets furniture variable
     * 
     * @description Sets private String variable furniture from class OrderForm
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    
    /**
     * @summary Sets type variable
     * 
     * @description Sets private String variable type from class OrderForm
     * 
     * @param type
     * 
     * @return
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @summary Sets manufacturer variable
     * 
     * @description Sets private String variable manufacturer from class OrderForm
     * 
     * @param manufacturer
     * 
     * @return
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @summary Sets overflow variable
     * 
     * @description Sets private Boolean variable overflow from class OrderForm
     * 
     * @param overflow
     * 
     * @return
     */
    public void setOverflow(Boolean overflow) {
        this.overflow = overflow;
    }
    
    /**
     * @summary Sets amount variable
     * 
     * @description Sets private int variable amount from class OrderForm
     * 
     * @param amount
     * 
     * @return
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

     /**
     * @summary Sets price variable
     * 
     * @description Sets private int variable price from class OrderForm
     * 
     * @param price
     * 
     * @return
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
     /**
     * @summary Sets ID variable
     * 
     * @description Sets private Vector<String> variable ID from class OrderForm
     * 
     * @param ID
     * 
     * @return
     */
    public void setID(Vector<String> ID) {
        this.ID = ID;
    }
}
