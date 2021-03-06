package com.apporioinfolabs.carcategoryview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.apporioinfolabs.carcategoryview.utils.Logs;

public class CarCategoryView extends LinearLayout {

    private Context mContext  = null  ;
    private static final String TAG = "CarCategoryView";
    private TextView text ;

    // interfaces
    private OnCarcategoryViewListeners onCarcategoryViewListeners ;


    public CarCategoryView(Context context) {
        super(context);
        initializeViews(context);
    }

    public CarCategoryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public CarCategoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    @SuppressLint("NewApi")
    public CarCategoryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
    }


    private void initializeViews(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.car_category_view, this);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        try{
            text = findViewById(R.id.text);

            // should place after finding id of every element in whole view.
            setClickAction();
        }catch (Exception e){ Logs.i(TAG , ""+e.getMessage()); }
    }


    public void setClickAction(){
        text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onCarcategoryViewListeners.onElementSelect(""+text.getText());
            }
        });
    }


    public void initialiseListeners(OnCarcategoryViewListeners onCarcategoryViewListeners) {
        this.onCarcategoryViewListeners = onCarcategoryViewListeners ;
    }



    public void setTextValue(String textValue){
        text.setText(""+textValue);
    }


    public interface OnCarcategoryViewListeners{
        void onElementSelect(String data);
    }

}
