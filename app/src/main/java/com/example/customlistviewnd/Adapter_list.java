package com.example.customlistviewnd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_list extends ArrayAdapter
{
    private int[] imageList;
    private String[] nameList;
    private String[] descriptionList;

    public Adapter_list(Context context, int[] imageList, String[] nameList, String[] descriptionList)
    {
        super(context, 0, nameList);
        this.imageList = imageList;
        this.nameList = nameList;
        this.descriptionList = descriptionList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView1 = convertView.findViewById(R.id.text_view1);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(imageList[position]);
        textView1.setText(nameList[position]);
        textView2.setText(descriptionList[position]);

        return convertView;
    }
}
