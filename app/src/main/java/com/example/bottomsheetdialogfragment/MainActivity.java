package com.example.bottomsheetdialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bottomsheetdialogfragment.model.Order;
import com.example.bottomsheetdialogfragment.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenBottomSheet = (Button) findViewById(R.id.btn_open_bottom_sheet);
        btnOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOpenBottomSheetDialogFragment();
            }
        });

    }

    private void clickOpenBottomSheetDialogFragment() {
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("Bim Bim Viet Nam 1x5"));
        listProduct.add(new Product("Mi Hao Hao 1x5"));
        listProduct.add(new Product("Kho Ga La Chanh 1x5"));
        listProduct.add(new Product("Pessi 1x5"));
        listProduct.add(new Product("Xuc xich 1x5"));

        Order order = new Order("200.000VND",listProduct,"Nguyen Co Thach,My Dinh,Nam Tu Liem,Ha Noi");
        MyBottomSheetDialogFragment sheetDialogFragment= MyBottomSheetDialogFragment.newInstance(order);
        sheetDialogFragment.show(getSupportFragmentManager(),sheetDialogFragment.getTag());
//        sheetDialogFragment.setCancelable(false);

    }
}