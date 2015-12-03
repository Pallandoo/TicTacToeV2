package com.haze.maupa.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.app.AlertDialog;
import android.content.DialogInterface; 
import java.util.prefs.Preferences;
import org.w3c.dom.Text;

import java.util.Random;


public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int result = this.getResources().getConfiguration().orientation;
        if (result == 1){
            setContentView(R.layout.activity_main);
        }
        else {
            setContentView(R.layout.horizontal);
        }
        for(int i=0; i<10; i++)
            brackets[i]=0;
    }

    int[] brackets = new int[10];

    public void fill(View v)
    {
        if(canPress==0)
        {
            int id = 0;
            if (R.id.click1 == v.getId())
                id = 1;
            else if (R.id.click2 == v.getId())
                id = 2;
            else if (R.id.click3 == v.getId())
                id = 3;
            else if (R.id.click4 == v.getId())
                id = 4;
            else if (R.id.click5 == v.getId())
                id = 5;
            else if (R.id.click6 == v.getId())
                id = 6;
            else if (R.id.click7 == v.getId())
                id = 7;
            else if (R.id.click8 == v.getId())
                id = 8;
            else if (R.id.click9 == v.getId())
                id = 9;
            if(brackets[id]==0)
            {
                brackets[id] = 1;
                //v.setBackgroundColor(Color.BLUE);
                v.setBackgroundResource(R.drawable.cross);
                checkWin(0);
              //  AIturn();

            }
        }

    }

    void showMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Restart")
                .setMessage("Do you want restart game? If not, game will be closed")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(), "Restart!", Toast.LENGTH_SHORT).show();
                        reset2();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(), "Quit!", Toast.LENGTH_SHORT).show();
                        System.exit(0);
                    }
                })
                .show();
    }

    int isItTie=0;
    void tie(int mode)
    {
        for(int i=1; i<10; i++)
        {
            if(brackets[i]==0)
                isItTie=1;

        }
        if(isItTie==1)
        {
            isItTie=0;

            if(mode==0)
               AIturn();
            else
                canPress=0;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
            TextView textView = (TextView)findViewById(R.id.text1);
            textView.setText("Draw!!");
            showMessage();
            canPress=1;
        }

    }
    public void reset(View view)
    {
        for(int i=0; i<10; i++)
        {
            brackets[i]=0;

        }
        canPress=0;
        isItTie=0;
        TextView textView;
        textView= (TextView)findViewById(R.id.click1);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click2);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click3);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click4);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click5);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click6);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click7);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click8);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click9);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);


    }
    public void reset2()
    {
        for(int i=0; i<10; i++)
        {
            brackets[i]=0;

        }
        canPress=0;
        isItTie=0;
        TextView textView;
        textView= (TextView)findViewById(R.id.click1);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click2);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click3);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click4);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click5);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click6);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click7);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click8);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);
        textView= (TextView)findViewById(R.id.click9);
        textView.setBackgroundColor(Color.WHITE);
        textView.setBackgroundResource(0);


    }
    void checkWin(int mode)
    {
        TextView textView = (TextView)findViewById(R.id.text1);
        if((brackets[1]==1 && brackets[2]==1 && brackets[3]==1) || (brackets[4]==1 && brackets[5]==1 && brackets[6]==1) || (brackets[7]==1 && brackets[8]==1 && brackets[9]==1)
                || (brackets[1]==1 && brackets[4]==1 && brackets[7]==1) || (brackets[2]==1 && brackets[5]==1 && brackets[8]==1) || (brackets[3]==1 && brackets[6]==1 && brackets[9]==1)
                || (brackets[1]==1 && brackets[5]==1 && brackets[9]==1)|| (brackets[3]==1 && brackets[5]==1 && brackets[7]==1))
        {
            Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();


            textView.setText("Win!!");

            showMessage();
            canPress=1;
        }
        else  if((brackets[1]==2 && brackets[2]==2 && brackets[3]==2) || (brackets[4]==2 && brackets[5]==2 && brackets[6]==2) || (brackets[7]==2 && brackets[8]==2 && brackets[9]==2)
                || (brackets[1]==2 && brackets[4]==2 && brackets[7]==2) || (brackets[2]==2 && brackets[5]==2 && brackets[8]==2) || (brackets[3]==2 && brackets[6]==2 && brackets[9]==2)
                || (brackets[1]==2 && brackets[5]==2 && brackets[9]==2)|| (brackets[3]==2 && brackets[5]==2 && brackets[7]==2))
        {

            Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_SHORT).show();
            textView.setText("Lose!!");
            showMessage();
            canPress=1;
        }
        else
            tie(mode);

    }

    int canPress=0;
    void AIturn()
    {
        canPress=1;
        Random r = new Random();
        int gonnaFill=0;
        do
        {
            gonnaFill=r.nextInt(9) + 1;
        }while(brackets[gonnaFill]==1 || brackets[gonnaFill]==2 );
        brackets[gonnaFill]=2;
        TextView textView;
        switch (gonnaFill)
        {
            case 1:
                textView = (TextView)findViewById(R.id.click1);
                break;
            case 2:
                textView = (TextView)findViewById(R.id.click2);
                break;
            case 3:
                textView = (TextView)findViewById(R.id.click3);
                break;
            case 4:
                textView = (TextView)findViewById(R.id.click4);
                break;
            case 5:
                textView = (TextView)findViewById(R.id.click5);
                break;
            case 6:
                textView = (TextView)findViewById(R.id.click6);
                break;
            case 7:
                textView = (TextView)findViewById(R.id.click7);
                break;
            case 8:
                textView = (TextView)findViewById(R.id.click8);
                break;
            case 9:
                textView = (TextView)findViewById(R.id.click9);
                break;
            default:
                textView = (TextView)findViewById(R.id.click1);
                break;
        }
        //textView.setBackgroundColor(Color.RED);
        textView.setBackgroundResource(R.drawable.round);

        checkWin(1);


    }
}
