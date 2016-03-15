package com.example.student.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private int mQuantity = 0;//初始值
   private int mPrice = 5;//初始值
    private final String mNT$ = "NT$";
    private StringBuilder mTotalPriceMessage = new StringBuilder(mNT$);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //按下按鈕執行
    public void submitOrder(View view) {
        displayTotalPrice();
    }

    private void displayQuantuty() {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);//透過ID尋找TextView
        quantityTextView.setText(String.valueOf(mQuantity));//重設
}

    public void displayTotalPrice() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int startIndex = mNT$.length();
        int endIndex = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex,endIndex).append(total)
                .append(mQuantity == 0 ? "\nFree" : "\nThank you!");
        priceTextView.setText(mTotalPriceMessage);
    }

    public void resetTotalPrice() {
        TextView PriceTextView = (TextView)findViewById((R.id.price_text_view));
    PriceTextView.setText("");
    }

    public void increment(View view) {
        //從TextView取得初始值 +1個數量
        ++mQuantity;
        displayQuantuty();
        resetTotalPrice();
    }

    private int getQuantity() {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);//用ID尋找TextView
        String quantitystring = quantityTextView.getText().toString();//轉字串
        return Integer.parseInt(quantitystring);
    }

    public void decrement(View view) {
        //從TextView取得初始值 -1個數量
        int quantity = getQuantity();
        if(quantity > 0){
        }
        --mQuantity;
        displayQuantuty();
        resetTotalPrice();
    }
}
