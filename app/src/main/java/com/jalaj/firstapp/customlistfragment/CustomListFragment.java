package com.jalaj.firstapp.customlistfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListFragment extends ListFragment {

    ArrayList<CustomListData> arrayList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View fragmentView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_custom_list, null, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayList = new ArrayList<>();
        arrayList.add(new CustomListData(R.id.image,"image1"));
        arrayList.add(new CustomListData(R.id.image,"image1"));
        arrayList.add(new CustomListData(R.id.image,"image1"));

        setListAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.linear_under_frag,parent,false);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.mFragImgVw);
                TextView textView = (TextView) convertView.findViewById(R.id.mFragTxtVw);

                imageView.setImageResource(arrayList.get(position).getImageResource());
                textView.setText(arrayList.get(position).getImageDescription());

                return convertView;
            }
        });

    }

    public static class CustomListData
    {
        public CustomListData(int imageResource, String imageDescription) {
            this.imageResource = imageResource;
            this.imageDescription = imageDescription;
        }

        int imageResource;
        String imageDescription;

        public int getImageResource() {
            return imageResource;
        }

        public void setImageResource(int imageResource) {
            this.imageResource = imageResource;
        }

        public String getImageDescription() {
            return imageDescription;
        }

        public void setImageDescription(String imageDescription) {
            this.imageDescription = imageDescription;
        }
    }


}
