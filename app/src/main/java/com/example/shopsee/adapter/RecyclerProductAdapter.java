package com.example.shopsee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopsee.models.ProductModel;
import com.example.shopsee.R;
import com.example.shopsee.interfaces.ProductInterface;

import java.util.List;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {

    Context context;
    List<ProductModel> productList;
    ProductInterface productInterface;

    public RecyclerProductAdapter(Context context, List<ProductModel> productList, ProductInterface productInterface) {

        this.context = context;
        this.productList = productList;
        this.productInterface = productInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_sample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtproductName.setText(productList.get(position).name);
        holder.image.setImageResource(productList.get(position).image);

        holder.mainProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productInterface.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtproductName;
        ImageView image;

        ConstraintLayout mainProducts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtproductName = itemView.findViewById(R.id.txtproductName);
            image = itemView.findViewById(R.id.imageView);
            mainProducts = itemView.findViewById(R.id.mainProducts);

        }
    }
}
