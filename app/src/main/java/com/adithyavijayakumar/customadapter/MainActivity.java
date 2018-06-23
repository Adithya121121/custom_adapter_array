package com.adithyavijayakumar.customadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String[] mName;
    String[] mdesc;
    int[] image = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list_view);
        Resources r = getResources();
        mName = r.getStringArray(R.array.names);
        mdesc = r.getStringArray(R.array.description);
        CustomAdapter adapter = new CustomAdapter(this,mName,image,mdesc);
        l.setAdapter(adapter);
    }


}
    class CustomAdapter extends ArrayAdapter<String>{
            Context context;
            int[] image;
            String[] titles;
            String[] description;
            CustomAdapter(Context c,String[] names,int[] imgs, String[] descc){
                super(c,R.layout.activity_single_row,R.id.tv_title,names);
                this.image = imgs;
                this.context = c;
                this.titles = names;
                this.description = descc;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = convertView;
                if(v==null){
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v =  inflater.inflate(R.layout.activity_single_row,parent,false);

                }

          ImageView thumnail =(ImageView) v.findViewById(R.id.image_view);
            TextView name = (TextView) v.findViewById(R.id.tv_title);
            TextView desc = (TextView) v.findViewById(R.id.tv_desc);
            thumnail.setImageResource(image[position]);
            name.setText(titles[position]);
            desc.setText(description[position]);
            return v;
        }
    }