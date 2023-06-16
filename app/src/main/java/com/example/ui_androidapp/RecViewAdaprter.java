package com.example.ui_androidapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecViewAdaprter extends RecyclerView.Adapter<RecViewAdaprter.ViewHolder>{
    private ArrayList<Books> books=new ArrayList<>();
    Context context;
    String ActivityName;

    public RecViewAdaprter(Context context ,String AcitivityName) {
        this.context = context;
        this.ActivityName=AcitivityName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycle_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookName.setText(books.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImgUrl())
                .into(holder.bookImg);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, BookDetailsActivity2.class);
                intent.putExtra("BookId",books.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.Athour.setText(books.get(position).getAuthor());
        holder.Textauthor.setText(books.get(position).getAuthor()+" a great author");
        holder.ShortDescription.setText(books.get(position).getShortDesc());
        if (books.get(position).getExtandable()){
            holder.othorInfoBook.setVisibility(View.VISIBLE);
            holder.DownArrow.setVisibility(View.GONE);
            //handle with the Delete Button
            if(ActivityName.equals("AllBooks")){
                //don't show the Delete button
                holder.DeleteBtn.setVisibility(View.GONE);

            }
            else if(ActivityName.equals("CurrentlyReadingBook")){
                holder.DeleteBtn.setVisibility(View.VISIBLE);
                holder.DeleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //show an Alert to confirme the delete
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure to delete "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance(context). DeleteFromCurrentlyReadBooks(books.get(position))){
                                    Toast.makeText(context, "books deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(context, "something went wrong please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }

            else if(ActivityName.equals("WantToRead")){
                holder.DeleteBtn.setVisibility(View.VISIBLE);
                holder.DeleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //show an Alert to confirme the delete
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure to delete "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance(context). DeleteFromWantReadBooks(books.get(position))){
                                    Toast.makeText(context, "books deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(context, "something went wrong please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }
            else if(ActivityName.equals("AlreadyRead")){
                holder.DeleteBtn.setVisibility(View.VISIBLE);
                holder.DeleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //show an Alert to confirme the delete
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure to delete "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance(context). DeleteFromAlreadyReadBooks(books.get(position))){
                                    Toast.makeText(context, "books deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(context, "something went wrong please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else{
                holder.DeleteBtn.setVisibility(View.VISIBLE);
                holder.DeleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //show an Alert to confirme the delete
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure to delete "+books.get(position).getName()+"?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance(context). DeleteFromFavoriteBook(books.get(position))){
                                    Toast.makeText(context, "books deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(context, "something went wrong please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        }

        else{
            holder.othorInfoBook.setVisibility(View.GONE);
            holder.DownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
    public void setBooks(ArrayList<Books> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView parent;
        private TextView bookName,Athour,Textauthor,ShortDescription;
        private ImageView bookImg,UpArrow,DownArrow;
        private RelativeLayout othorInfoBook,MainInfoBook;
        private Button DeleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            bookName=itemView.findViewById(R.id.nameBook);
            bookImg=itemView.findViewById(R.id.imgBook);
            Athour=itemView.findViewById(R.id.author);
            Textauthor=itemView.findViewById(R.id.txtAuthor);
            ShortDescription=itemView.findViewById(R.id.shortDescription);
            UpArrow=itemView.findViewById(R.id.arrowUp);
            DownArrow=itemView.findViewById(R.id.arrowDown);
            othorInfoBook=itemView.findViewById(R.id.OtherInfoBook);
            MainInfoBook=itemView.findViewById(R.id.MainInfoBooks);
            DeleteBtn=itemView.findViewById(R.id.deleteBtn);
            UpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book=books.get(getAdapterPosition());
                    book.setExtandable(!book.getExtandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            DownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book=books.get(getAdapterPosition());
                    book.setExtandable(!book.getExtandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
