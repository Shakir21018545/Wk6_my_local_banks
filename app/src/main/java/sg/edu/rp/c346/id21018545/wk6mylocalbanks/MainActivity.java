package sg.edu.rp.c346.id21018545.wk6mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewDBS,textViewOCBC ,textViewUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDBS = findViewById(R.id.textViewDBS);
        textViewOCBC = findViewById(R.id.textViewOCBC);
        textViewUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(textViewDBS);
        registerForContextMenu(textViewOCBC);
        registerForContextMenu(textViewUOB);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == textViewDBS){
            wordClicked = "DBS";
        }
        else if (v == textViewOCBC){
            wordClicked = "OCBC";
        }
        else if (v == textViewUOB){
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("DBS") && wordClicked.equalsIgnoreCase("ديسيبل") && wordClicked.equalsIgnoreCase("星展银行")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800111111));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }
        if(wordClicked.equalsIgnoreCase("OCBC")&& wordClicked.equalsIgnoreCase("أوك بي سي") && wordClicked.equalsIgnoreCase("华侨银行")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.OCBC.com"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800363333));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }
        if(wordClicked.equalsIgnoreCase("UOB")&& wordClicked.equalsIgnoreCase("جامعة البحرين") && wordClicked.equalsIgnoreCase("大华银行")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.UOB.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800222212));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }


        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textViewDBS.setText("DBS");
            textViewOCBC.setText("OCBC");
            textViewUOB.setText("UOB");


            return true;
        } else if (id == R.id.arabicSelection) {
            textViewDBS.setText("ديسيبل");
            textViewOCBC.setText("أوك بي سي");
            textViewUOB.setText("جامعة البحرين");

            return true;
        } else if (id == R.id.chineseSelection) {
            textViewDBS.setText("星展银行");
            textViewOCBC.setText("华侨银行");
            textViewUOB.setText("大华银行");

            return true;

        } else {
            textViewDBS.setText("Error translation");
            textViewOCBC.setText("Error translation");
            textViewUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }
}