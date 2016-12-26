package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Global variables.
     **/
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        // Grab the cream checkbox and its value.
        CheckBox CreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = CreamCheckBox.isChecked();

        // Grab the chocolate checkbox and its value.
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Grab the name EditText view and its value.
        EditText nameInput = (EditText) findViewById(R.id.name_view);
        String name = nameInput.getText().toString();

        String orderSummary = createOrderSummary(quantity, calculatePrice(quantity, 5), hasWhippedCream, hasChocolate, name);
        displayMessage(orderSummary);
    }

    /**
     * this method will increment the quantity
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * this method will decrement the quantity
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method calculates the price of a given quantity of coffees.
     *
     * @param quantity    of number of coffees to order.
     * @param currentCost of the cup of coffee.
     */
    private int calculatePrice(int quantity, int currentCost) {
        int price = quantity * currentCost;
        return price;
    }

    /**
     * This method creates an order summary text.
     *
     * @param quantity        of number of coffees to order.
     * @param price           of total cost
     * @param addWhippedCream creamCheckBox value
     * @param name            of the person who ordered.
     */
    private String createOrderSummary(int quantity, int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String summary = "Name: " + name + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you! Please order again and again." + "\nAdd Whipped Cream? " + addWhippedCream + "\nAdd Chocolate? " + addChocolate;
        return summary;
    }


}
