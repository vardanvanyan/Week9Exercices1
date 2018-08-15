package com.example.vardan.threadexercises.provider;

import android.content.Context;

import com.example.vardan.threadexercises.model.MyModel;
import com.example.vardan.threadexercises.R;

import java.util.ArrayList;
import java.util.List;

public class MyProvider {
    public static int position;
    private static List<MyModel> list = new ArrayList<>();

    public static List<MyModel> getImageLink(Context context) {
        if (!list.isEmpty()) {
            list.clear();
        }
        for (int i = 0; i < context.getResources().getStringArray(R.array.imageUrls).length; i++) {
            list.add(new MyModel(context.getResources().getStringArray(R.array.imageName)[i],
                    context.getResources().getStringArray(R.array.imageUrls)[i], false));
        }
        return list;
    }

    public static MyModel getModelByPosition() {
        return list.get(position);
    }
}
