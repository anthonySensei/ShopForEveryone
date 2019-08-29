package com.example.sfe.NotRegisteredUser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sfe.ChooseProductCategoryActivity;
import com.example.sfe.ProductCategoryActivity;
import com.example.sfe.R;

public class NotRegisteredUserChooseCategoryActivity extends AppCompatActivity {

    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_registered_user_choose_category);


        tShirts = (ImageView) findViewById(R.id.unregistered_user_t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.unregistered_user_sports_t_shirts);
        femaleDresses = (ImageView) findViewById(R.id.unregistered_user_female_dresses);
        sweathers = (ImageView) findViewById(R.id.unregistered_user_sweathers);

        glasses = (ImageView) findViewById(R.id.unregistered_user_glasses);
        hatsCaps = (ImageView) findViewById(R.id.unregistered_user_hats_caps);
        walletsBagsPurses = (ImageView) findViewById(R.id.unregistered_user_purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.unregistered_user_shoes);

        headPhonesHandFree = (ImageView) findViewById(R.id.unregistered_user_headphones_handfree);
        Laptops = (ImageView) findViewById(R.id.unregistered_user_laptop_pc);
        watches = (ImageView) findViewById(R.id.unregistered_user_watches);
        mobilePhones = (ImageView) findViewById(R.id.unregistered_user_mobilephones);


        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });


        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "sports tShirts");
                startActivity(intent);
            }
        });

        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });

        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });



        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });


        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Wallets Bags Purses");
                startActivity(intent);
            }
        });



        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });



        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "headPhones HandFree");
                startActivity(intent);
            }
        });

        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotRegisteredUserChooseCategoryActivity.this, NotRegisteredProductCategoryActivity.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });


    }
}
