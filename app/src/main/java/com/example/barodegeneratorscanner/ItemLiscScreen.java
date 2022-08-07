package com.example.barodegeneratorscanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemLiscScreen extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<Model> list=new ArrayList<>();
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_lisc_screen);

        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/tshirt.png?alt=media&token=4b53c92d-1c02-4753-9e8b-7c1dcfcf0c3a","T-SHIRT"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/frok.png?alt=media&token=d89d99d1-ee29-4cc4-baa6-c9967143ef75","Baby Frock"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/jense.webp?alt=media&token=2c798673-98ab-417f-9592-bd64667e1bd1"," Jeans Pent"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/kot.jpg?alt=media&token=3ba613ef-6307-4920-a74f-7e211d334ba5","Upper"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/shirt.jpg?alt=media&token=03b95018-4216-436b-bad9-1763498f71ee","Shirt"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/shoes.jpg?alt=media&token=f79f26be-19dc-4637-a576-57150e30ec20","Shoes"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/iphone.jpg?alt=media&token=73b15b0a-a5c7-4804-87e4-ae5148b53925","Smart Phone"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/wallet.jpg?alt=media&token=e09a8752-d6c3-4440-a353-1ec15ad3cb98","Wallet"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/watch.jpg?alt=media&token=b301968c-0692-48aa-a294-178777579fbc","Watch"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/belt.jpg?alt=media&token=4d2305a0-2199-4e92-ace4-5bd7914fea5b","Belt"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/hat.jpg?alt=media&token=fc5c1457-cc6a-43b0-baa9-f7b3e76f28b8","Hat"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/bathingsuit.jpg?alt=media&token=c5969927-d78a-40fb-9f2f-4d0192b88363","Bathing Suit"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/glases.jpg?alt=media&token=25649234-0d4b-4c5c-85cb-bb2706ccdb06","Glasses"));
        list.add(new Model("https://firebasestorage.googleapis.com/v0/b/barodegeneratorscanner.appspot.com/o/tshirt.png?alt=media&token=4b53c92d-1c02-4753-9e8b-7c1dcfcf0c3a","Tie"));

        recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter=new Adapter(ItemLiscScreen.this,list);
        recyclerview.setAdapter(adapter);

    }

    private class Model
    {

        String image;
        String name;

        public Model(String image, String name) {
            this.image = image;
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
    {
        ArrayList<Model> list=new ArrayList<>();
        Context context;

        public Adapter(Context context, ArrayList<Model> list) {
            this.context=context;
            this.list=list;
        }

        private void Update(ArrayList<Model> list)
        {
            this.list=list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            //holder.imgview.setImageDrawable(list.get(position).getImage());
            Glide.with(context).load(list.get(position).getImage()).into(holder.imgview);
            holder.name.setText(list.get(position).getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(context,Barcode_generated.class);
                    intent.putExtra("name",list.get(position).getName());
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgview;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imgview=itemView.findViewById(R.id.imgview);
                name=itemView.findViewById(R.id.name);

            }
        }

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}