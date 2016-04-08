package com.example.dell.comp438_a2_1120759;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    String userinsert="";
    String number1 = "0", number2 = "0",memory="0";
    String toSaveIn="";
    static char op;
    TextView text;
    int negativecheck=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.SolutionText);
          text.setText("0");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


// to add on the text what the user had typed and
// concat them on the screen

    public void onClick(View v){

        if(v.getId()==R.id.btn_0) {
            userinsert=userinsert+'0';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_1){
            userinsert=userinsert+'1';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_2){
            userinsert=userinsert+'2';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_3){
            userinsert=userinsert+'3';
            text.setText(userinsert);

        }
        else if (v.getId()== R.id.btn_4){
            userinsert=userinsert+'4';
            text.setText(userinsert);

        }
        else if (v.getId()== R.id.btn_5){
            userinsert=userinsert+'5';
            text.setText(userinsert);

        }
        else if (v.getId()== R.id.btn_6){
            userinsert=userinsert+'6';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_7){
            userinsert=userinsert+'7';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_8){
            userinsert=userinsert+'8';
            text.setText(userinsert);
        }
        else if (v.getId()== R.id.btn_9){
            userinsert=userinsert+'9';
            text.setText(userinsert);

        }
        else if(v.getId()==R.id.btn_plus){
            userinsert=userinsert+'+';
            text.setText(userinsert);
        }

        else if(v.getId()==R.id.btn_min){
            userinsert=userinsert+'-';
            text.setText(userinsert);
        }
        else if(v.getId()==R.id.btn_mul){
            userinsert=userinsert+'*';
            text.setText(userinsert);
        }
        else if(v.getId()==R.id.btn_div){
            userinsert=userinsert+'/';
            text.setText(userinsert);
        }

        else if (v.getId()==R.id.btn_equ){
            userinsert= equal();
            text.setText(userinsert);


        }
        else if (v.getId()==R.id.btn_n){
            userinsert= negate(userinsert);
            text.setText(userinsert);


        }
        else if(v.getId()==R.id.btn_mplus){
            for(int charindex=1;charindex<userinsert.length();charindex++) {
                if (userinsert.charAt(charindex) == '+' || userinsert.charAt(charindex) == '-' || userinsert.charAt(charindex) == '*' || userinsert.charAt(charindex) == '/') {
                    memory=equal();
                    text.setText("");

                }

                else memory=userinsert;
                text.setText("");
            }}

        else if(v.getId()==R.id.btn_mr){
            userinsert=userinsert+memory;
            text.setText(userinsert);
        }
        else if(v.getId()==R.id.btn_mc){
            userinsert="0";

        }
        else if(v.getId()==R.id.btn_c){
            text.setText(" ");

        }
        else if(v.getId()==R.id.btn_back){
            if(userinsert.length()!=1||userinsert.length()==0){
                userinsert=userinsert.substring(0,userinsert.length()-1);
                text.setText(userinsert);

            }
            else{
                userinsert="0";
                text.setText(" ");}
        }

    }



public String negate(String input){
    return (input)+"-";
}

    public String equal(){
        String Result="";
        for(int charindex=1;charindex<userinsert.length();charindex++) {
            if (userinsert.charAt(charindex) == '+' || userinsert.charAt(charindex) == '-' || userinsert.charAt(charindex) == '*' || userinsert.charAt(charindex) == '/') {
                number1 = userinsert.substring(0, charindex);
                number2 = userinsert.substring(charindex + 1, userinsert.length());
                Result = String.valueOf(findResult(userinsert.charAt(charindex), Integer.parseInt(number1), Integer.parseInt(number2)));

            }

        }
        return Result;
    }

    public int findResult(char operation,int firstnum,int secondnum){
        int result=0;
        if(operation=='+'){
            result=firstnum+secondnum;

        }
        else if(operation=='-')
            result=firstnum-secondnum;
        else if(operation=='*')
            result=firstnum*secondnum;
        else if(operation=='/'){
            if(secondnum!=0){
                result=firstnum/secondnum;
           }

             else{
                Toast.makeText(this, "Error, division by zeor ", Toast.LENGTH_LONG).show();
                userinsert="0";
            }

        }
        return result;
    }




}
