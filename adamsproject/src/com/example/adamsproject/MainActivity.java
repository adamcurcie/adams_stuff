package com.example.adamsproject;

import java.util.*;
import java.text.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  
    //variables
    Button button;
    TextView TV;
    Date Dnow;
    TextView TV1;
    
    
    //Array of outputs for what to do when certain time intervals are provoked in for loop
    String[] toDo = {"Sleeping", "Having Coffee", "Eating Breakfast", "Playing Around", "Eating Lunch", "Napping :D" ,
            "Snacking/Playing/Cooking!" , "Having Dinner", "Taking a Bath", "Getting Ready for BedTime!"};    
   
    
    String[] sTime={ ":06:15:15",":08:15:15",":11:15:15",":12:15:15",
            ":15:15:15",":17:15:15",":18:15:15",":19:15:15",":20:15:15",":22:15:15"};
    //time interval used to allocate a precise time as a string to parse
    // into a "time" date variable in combination with FDD for current
    // date at a particular time.
    
    
    Date[] times={null,null,null,null,null,null,null,null,null,null};
    //For loop to assign String Time array elements to "times" array elements for
    // actual time comparison points.
    
    //Two date formats used- ft is the full date format which includes the combination of the ft1 and sTime String array component    
    DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss",Locale.US);
    DateFormat df1= new SimpleDateFormat("dd:MM:yyyy",Locale.US);
    
    // get current date with for parsing into "time" date variables so you
    // can always test against the current day instead of a day in 1970()
    
    Date dnow = new Date();
    String today = df1.format(dnow);
    
    
    @Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    TV1=(TextView)findViewById(R.id.tv1);
    TV=(TextView)findViewById(R.id.tv);  
    TV.setText("The Time is : "+df.format(dnow));
    
    button=(Button)findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
             for (int x = 0; x < sTime.length; x++) {


                   //assigns times to comparison points "times"

                 try {
                    times[x]=df.parse((today)+(sTime[x]));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                  //compares current time and date to the time assigned in times array
                    if ((dnow).before(times[x])){
                        TV1.setText("Right now you should be "+toDo[x]);
                        break;
                }   else {
                     TV1.setText("Sleeeeep!!!...ZZZzzz");
                }

           }
          }   
        });
       } 
     }
    
    

   
    


