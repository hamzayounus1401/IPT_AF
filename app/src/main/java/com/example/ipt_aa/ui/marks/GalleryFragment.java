package com.example.ipt_aa.ui.marks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.R;
import com.example.ipt_aa.Room.Repository;
import com.example.ipt_aa.SessionManager;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class GalleryFragment extends Fragment {
    private GalleryViewModel galleryViewModel;
    ListView listView;
    Button button;
    CircleImageView circleImageView;
    ArrayAdapter adapter;
    List<String> list = new ArrayList<>();
    SessionManager sessionManager;
    Repository repository;
    private Bitmap currentImage;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        button = root.findViewById(R.id.logout_button);
        sessionManager = new SessionManager(getContext());
        circleImageView = root.findViewById(R.id.profile_image);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create(); //Read Update
                alertDialog.setTitle("Change Profile Image");
                alertDialog.setButton("Continue..", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                        photoPickerIntent.setType("image/*");
                        startActivityForResult(photoPickerIntent, 1);
                    }
                });
                alertDialog.show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.deleteAccount();
                sessionManager.logoutUser();

            }
        });

        return root;


    }

    @Override
    public void onStart() {
        super.onStart();
        repository = new Repository(getActivity().getApplication());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri photoUri = data.getData();
            if (photoUri != null) {
                try {
                    currentImage = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), photoUri);
                    circleImageView.getFitsSystemWindows();
                    circleImageView.setImageBitmap(currentImage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

