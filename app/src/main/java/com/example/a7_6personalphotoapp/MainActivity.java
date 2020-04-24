package com.example.a7_6personalphotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] personals = {R.drawable.andrew, R.drawable.blackcat, R.drawable.carmen, R.drawable.daniel, R.drawable.grasshopper,
            R.drawable.navy, R.drawable.steve, R.drawable.whitecat};
    ImageView pic;
    String person = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic =(ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter (this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Andrew
                        person = "Andrew"; break;
                    case 1: //lil' Dude & Devon
                        person = "lil' Dude & Devon"; break;
                    case 2: //Carmen
                        person = "Carmen"; break;
                    case 3: //Daniel
                        person = "Daniel"; break;
                    case 4: //Joe
                        person = "Joe"; break;
                    case 5: //Devon & Cindy
                        person = "Devon & Cindy"; break;
                    case 6: //Steve
                        person = "Steve"; break;
                    case 7: //Devon & Tiki
                        person = "Devon & Tiki"; break;
                    default:
                        break;
                }

                Toast.makeText(MainActivity.this, person, Toast.LENGTH_SHORT).show();
                pic.setImageResource(personals[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return personals.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(personals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(300,300));
            return pic;
        }
    }
}
