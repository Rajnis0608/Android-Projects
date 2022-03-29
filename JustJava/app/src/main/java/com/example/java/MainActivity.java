package com.example.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants chocolate topping
     * @return the price
     */
    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate) {
        int price = quantity * 5;
        if (hasWhippedCream){
            price += 1*quantity;
        }
        if(hasChocolate){
            price += 2*quantity;
        }
        return price;
    }

    /**
     * Create summary of the order.
     *
     * @param userName is name of customer
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */

    private String createOrderSummary(String userName, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage ="";
        priceMessage += getString(R.string.name_summary) + userName;
        priceMessage += "\n" + getString(R.string.quantity_summary) + quantity;
        if(hasWhippedCream){
            priceMessage += "\n" + getString(R.string.whipped_cream_summary) ;
        }
        if(hasChocolate){
            priceMessage += "\n" + getString(R.string.chocolate_summary);
        }
        priceMessage += " \n" + getString(R.string.total) + price ;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method is called when the order button is clicked.
     */
    @SuppressLint("StringFormatInvalid")
    public void submitOrder(View view) {
        // Figure out if the user wants whipped cream topping
        CheckBox  whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox  chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        //Calculating Price
        int price = calculatePrice(hasWhippedCream,hasChocolate);

        // Getting user name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String userName = nameField.getText().toString();
        String priceMessage = createOrderSummary(userName,price,hasWhippedCream,hasChocolate);

        //Email Intent
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"rajnis0608@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject,userName));
        email.putExtra(Intent.EXTRA_TEXT, priceMessage);
        email.setType("message/rfc822");
        startActivity(email);

//        //Display order summary
//        displayMessage(priceMessage);
    }

    /**
     * This Method is called when the + button is clicked
     */
    public void increment(View view) {
        if(quantity == 100){
            Toast.makeText(this,getString(R.string.limit_increased),Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This Method is called when the - button is clicked
     */
    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(this,getString(R.string.limit_decreased),Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }

}