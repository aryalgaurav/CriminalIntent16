package android.nku.edu.criminalintent;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Gaurav on 9/9/2016.
 */
public class ImageDialogFragment extends DialogFragment {

    public static final String ARG_SUSPECT_IMAGE = "SuspectImage";

    public static ImageDialogFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SUSPECT_IMAGE, photoFile);
        ImageDialogFragment fragment = new ImageDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view =  LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.dialog_image_image_view);

        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                File photoFile = (File) getArguments().getSerializable(ARG_SUSPECT_IMAGE);
                Bitmap image = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
                imageView.setImageBitmap(image);
            }
        });

        return new AlertDialog.Builder(getActivity()).setView(imageView).create();
    }
}