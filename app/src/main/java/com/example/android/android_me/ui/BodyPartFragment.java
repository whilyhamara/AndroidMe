package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
//membuat variabel TAG
    private static final String TAG = "BodyPartFragment";

//  variabel global untuk memanggil list gambar heads atau bodies atau legs
    private List<Integer> mImageIds;
    private int mListIndex;
//  constructor class
    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//Pada awal saat melakukan “create fragment” berikan statment jika “saved instance” tidak ‘null’
//maka variabel array dan index memanggil keadaan sebelumnya
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

//      inisialisasi layout fragment
        View rooView = inflater.inflate(R.layout.fragment_body_part, container, false);

//      mereferensikan imageview ke layout fragment
        final ImageView imageView = (ImageView) rooView.findViewById(R.id.body_part_image_view);

//      Set the image agar tampil saat app dibuka
        imageView.setImageResource(mImageIds.get(mListIndex));
//      merubah index dari gambar yang terdapat pada ImageView tersebut
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment position as long as the index remains <= the size of the image ids list
                if(mListIndex < mImageIds.size()-1) {
                    mListIndex++;
                } else {
                    // The end of list has been reached, so return to beginning index
                    mListIndex = 0;
                }
                // Set the image resource to the new list item
                imageView.setImageResource(mImageIds.get(mListIndex));
            }
        });


//        return rooView
        return rooView;
    }

//membuat method setter nya list gambar heads atau bodies atau legs
    public void setmImageIds(List<Integer> mImageIds) {

        this.mImageIds = mImageIds;
    }

    public void setmListIndex(Integer mListIndex) {

        this.mListIndex = mListIndex;
    }

    /**
     * Save the current state of this fragment
     */
    @Override
//    untuk menyimpan variabel array beserta index (seperti Session pada pemrograman web)
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }

}
