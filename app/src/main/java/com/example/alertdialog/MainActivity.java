package com.example.alertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button textOnly, drawing, drawingAndButton, randomAndButton, randomTwoButtons;
    AlertDialog.Builder adb;
    LinearLayout LL;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOnly = findViewById(R.id.button);
        drawing = findViewById(R.id.button2);
        drawingAndButton = findViewById(R.id.button3);
        randomAndButton = findViewById(R.id.button4);
        randomTwoButtons = findViewById(R.id.button5);
        LL = findViewById(R.id.Linear);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        String str = item.getTitle().toString();
        if(str.equals("Credits"))
        {
            Intent si = new Intent(this, Credits.class);
            startActivity(si);
        }
        return true;
    }

    public void showTextOnly(View view)
    {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Button one: only text");
        adb.setMessage("This is a simple message");
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void showImage(View view)
    {
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.ic_launcher_background);

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Button two: image and text");
        adb.setMessage("Message above the image");
        adb.setView(image);
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void showImageAndButton(View view)
    {
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.ic_launcher_background);

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Button three: image, text and button");
        adb.setMessage("Message above the image");
        adb.setView(image);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void showRandomAndButton(View view)
    {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Button four: random color and button");
        adb.setNeutralButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                LL.setBackgroundColor(color);
            }
        });
        adb.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void showRandomTwoButtons(View view)
    {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Button four: random color and button");
        adb.setNeutralButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                LL.setBackgroundColor(color);
            }
        });
        adb.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });
        adb.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                LL.setBackgroundColor(256256256);
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
}