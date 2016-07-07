package com.example.apoorvan.contactmanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apoorva N on 7/6/2016.
 */
public class EditContact extends Activity {
    TextView name,phone;
    Uri imageUri;
    ImageView ivContactImage;
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcontact);

        Intent intent=getIntent();


        name = (TextView)findViewById(R.id.nameedit);
        name.setText(intent.getStringExtra("name"));
        phone = (TextView) findViewById(R.id.phoneedit);
        phone.setText(intent.getStringExtra("phone"));
        ivContactImage = (ImageView)findViewById(R.id.imageViewEdit);
        ivContactImage.setImageURI(Uri.parse(intent.getStringExtra("img")));

        Button b=(Button)findViewById(R.id.button2);

        ivContactImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setType("image/*");
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent1, "Select Contact Image"), 1);

            }

        });




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                in.putExtra("name",String.valueOf(name.getText()));
                in.putExtra("phone",String.valueOf(phone.getText()));
                in.putExtra("img",String.valueOf(imageUri));
                Toast.makeText(getApplicationContext(), String.valueOf(name.getText()) + " has been Updated!!!", Toast.LENGTH_SHORT).show();
                startActivity(in);

            }
        });



    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1) {
                imageUri = data.getData();
                ivContactImage.setImageURI(data.getData());
            }
        }
    }
}
