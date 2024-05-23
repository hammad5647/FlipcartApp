package com.example.shopsee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopsee.adapter.RecyclerProductAdapter;
import com.example.shopsee.interfaces.ProductInterface;
import com.example.shopsee.databinding.ActivityMainBinding;
import com.example.shopsee.models.ProductModel;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ProductModel> productList = new ArrayList<>();

    List<CarouselItem> carouselItems = new ArrayList<>();
    ActivityMainBinding binding;
    ProductInterface productInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cartBtn.setVisibility(View.GONE);
            }
        });

        binding.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                binding.cartBtn.setVisibility(View.VISIBLE);
                return false;
            }
        });


        productList.add(new ProductModel(R.drawable.tshirt1, "T-Shirts For Men"));
        productList.add(new ProductModel(R.drawable.pant3, "Pants For Men "));
        productList.add(new ProductModel(R.drawable.womendress1, "Women Pure Cotton Dress"));
        productList.add(new ProductModel(R.drawable.womenpant1, "Women's Trouser"));
        productList.add(new ProductModel(R.drawable.kids1, "Dress For Kis"));
        productList.add(new ProductModel(R.drawable.laptop1, "HP Laptop 512/8GB"));
        productList.add(new ProductModel(R.drawable.washingmachine1, " LG Washing Machine"));
        productList.add(new ProductModel(R.drawable.frige1, "Samsung Refrigerator's"));
        productList.add(new ProductModel(R.drawable.samsung1, "Samsung S24"));
        productList.add(new ProductModel(R.drawable.earphone1, "Boat Earphone"));

        carouselItems.add(new CarouselItem(R.drawable.adimage1));
        carouselItems.add(new CarouselItem(R.drawable.adimage2));
        carouselItems.add(new CarouselItem(R.drawable.adimage3));
        carouselItems.add(new CarouselItem(R.drawable.adimage4));
        carouselItems.add(new CarouselItem(R.drawable.adimage5));
        carouselItems.add(new CarouselItem(R.drawable.adimage6));
        carouselItems.add(new CarouselItem(R.drawable.adimage7));
        carouselItems.add(new CarouselItem(R.drawable.adimage8));

        binding.imageCarousel.setAutoPlay(true);
        binding.imageCarousel.setAutoPlayDelay(3000);
        binding.imageCarousel.setData(carouselItems);

        productInterface = new ProductInterface() {

            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("image", productList.get(position).image);
                intent.putExtra("item_name", productList.get(position).name);
                intent.putExtra("item_price", productList.get(position).price);
                intent.putExtra("image", productList.get(position).image);
                intent.putExtra("image", productList.get(position).image);


                startActivity(intent);
            }
        };

        RecyclerProductAdapter adapter = new RecyclerProductAdapter(this, productList, productInterface);
        binding.recylceViewProducts.setAdapter(adapter);

        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                alertBox();
            }
        });
    }

    void alertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are You Sure ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}