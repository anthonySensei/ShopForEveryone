package com.example.sfe.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sfe.ChooseProductCategoryActivity;
import com.example.sfe.R;
import com.example.sfe.SearchProductsActivity;

public class AdminProductOptionActivity extends AppCompatActivity {


    private Button chooseCategoriesBtn, chooseSeeAllProductsBtn, chooseBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_option);




        chooseBackBtn = findViewById(R.id.choose_back_btn);
        chooseSeeAllProductsBtn = findViewById(R.id.choose_see_all_products_btn);
        chooseCategoriesBtn = findViewById(R.id.choose_product_categories_btn);




        chooseBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProductOptionActivity.this, AdminCategoryActivity.class);
                startActivity(intent);
            }
        });


        chooseSeeAllProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminProductOptionActivity.this, SearchProductsActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);

            }
        });


        chooseCategoriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProductOptionActivity.this, ChooseProductCategoryActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });



    }
}
