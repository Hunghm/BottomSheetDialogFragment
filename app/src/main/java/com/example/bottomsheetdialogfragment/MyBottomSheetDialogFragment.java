package com.example.bottomsheetdialogfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bottomsheetdialogfragment.model.Order;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private static final String KEY_ORDER_OBJECT = "order_object";
    private Order mOrder;
    private TextView tvPrice, tvProductName, tvDeliveryAddress;
    private Button btnCancel;


    public static MyBottomSheetDialogFragment newInstance(Order order) {
        MyBottomSheetDialogFragment myBottomSheetDialogFragment = new MyBottomSheetDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_ORDER_OBJECT, order);

        myBottomSheetDialogFragment.setArguments(bundle);
        return myBottomSheetDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundleReceive = getArguments();
        if (bundleReceive != null) {
            mOrder = (Order) bundleReceive.get(KEY_ORDER_OBJECT);
        }


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View viewDialog = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet_fragment, null);
        bottomSheetDialog.setContentView(viewDialog);
        initView(viewDialog);
        setDataOrder();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        BottomSheetBehavior behavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        return bottomSheetDialog;
    }

    private void initView(View view){
        tvPrice = view.findViewById(R.id.tv_price);
        tvProductName = view.findViewById(R.id.tv_product_name);
        tvDeliveryAddress = view.findViewById(R.id.tv_dilivery_address);
        btnCancel = view.findViewById(R.id.btn_cancel);
    }

    private void setDataOrder(){
        if (mOrder == null){
            return;
        }
        tvPrice.setText(mOrder.getPrice());
        tvProductName.setText(mOrder.getListProductName());
    }

}
