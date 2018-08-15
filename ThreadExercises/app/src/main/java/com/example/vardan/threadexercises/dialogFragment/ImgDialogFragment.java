package com.example.vardan.threadexercises.dialogFragment;

import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vardan.threadexercises.R;
import com.example.vardan.threadexercises.provider.MyProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImgDialogFragment extends DialogFragment {
    private String source;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.img_dialog, container, false);
        source = Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        imageView = view.findViewById(R.id.dialog_img);
        httpLoader();

        return view;
    }

    private void httpLoader() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = new File(source + "/" +
                            MyProvider.getModelByPosition().getText() + ".jpg");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    final Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    fileInputStream.close();
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
