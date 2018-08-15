package com.example.vardan.threadexercises.adapter;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.vardan.threadexercises.activity.MainActivity;
import com.example.vardan.threadexercises.dialogFragment.ImgDialogFragment;
import com.example.vardan.threadexercises.model.MyModel;
import com.example.vardan.threadexercises.provider.MyProvider;
import com.example.vardan.threadexercises.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String KEY_FRAG = "key" ;
    private Context context;
    private List<MyModel> list;
    private TextView textView;

    public MyAdapter(Context context, List<MyModel> list,TextView textView) {
        this.context = context;
        this.list = list;
        this.textView = textView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.list_model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final MyModel model = list.get(position);
        holder.textV.setText(model.getText());
        MyProvider.position = holder.getAdapterPosition();
        final FragmentManager fragmentTransaction = ((MainActivity) context).getFragmentManager();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!model.isImgDownload()) {
                    textView.setText(model.getImageUrl());
                    MyProvider.position = holder.getAdapterPosition();
                } else {
                    textView.setText(model.getText());
                    DialogFragment dialogFragment = new ImgDialogFragment();
                    dialogFragment.show(fragmentTransaction, KEY_FRAG);
                    MyProvider.position = holder.getAdapterPosition();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textV;

        public MyViewHolder(View itemView) {
            super(itemView);
            textV = itemView.findViewById(R.id.text);
        }
    }
}
