package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    int count=0;
    int flag;
    int winning[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
      int[] position={2,2,2,2,2,2,2,2,2};
      int active_player=0;
    public void tap( View view)
    {count++;
        ImageView img = (ImageView)view;
        int x=Integer.parseInt(img.getTag().toString());
       if(flag==0) {
           reset(view);
       }
       if(position[x]==2&&count>0)
        {
            position[x]=active_player;
            if(active_player==0)
            {   active_player=1;
                img.setImageResource(R.drawable.zero);
                TextView status= findViewById(R.id.status);
                status.setText(" cross's turn");
            }
            else{
                active_player=0;
                img.setImageResource(R.drawable.x);

                TextView status= findViewById(R.id.status);
                status.setText("  zero's turn");
            }
        }
         flag=1;
      for(int i=0;i<8;i++) {
          if (position[winning[i][0]] == position[winning[i][1]] && position[winning[i][1]] == position[winning[i][2]] && position[winning[i][0]] != 2) {
              flag = 0;
              if (active_player == 1) {
                  TextView status = findViewById(R.id.status);
                  status.setText("  zero's WON");
                  break;
              } else {
                  TextView status = findViewById(R.id.status);
                  status.setText(" cross's WON");
              }
          }
      }
    if(count>=9&&flag==1)
    {
        TextView status= findViewById(R.id.status);
        status.setText("  DRAW!! zero's turn");
        reset(view);
    }
    }
public void reset(View view)
{flag=0;
count=0;
for(int i=0;i<=8;i++)
    position[i]=2;
active_player=0;
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
