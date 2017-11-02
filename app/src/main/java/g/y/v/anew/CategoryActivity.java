package g.y.v.anew;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import g.y.v.anew.Other.DatabaseHelper;


public class CategoryActivity extends AppCompatActivity {

    EditText etClo,etTra,etEnt,etMed,etOth;
    EditText etTClo,etTtra,etTEnt,etTMed,etTOth;
    Button button;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        myDB = new DatabaseHelper(getApplicationContext());

        etClo=(EditText)findViewById(R.id.etCloth);
        etTra=(EditText)findViewById(R.id.etTransp);
        etEnt=(EditText)findViewById(R.id.etEntr);
        etMed=(EditText)findViewById(R.id.etMed);
        etOth=(EditText)findViewById(R.id.etOther);

        etTClo=(EditText)findViewById(R.id.etTclot);
        etTtra=(EditText)findViewById(R.id.etTtrans);
        etTEnt=(EditText)findViewById(R.id.etTenter);
        etTMed=(EditText)findViewById(R.id.etTmedicin);
        etTOth=(EditText)findViewById(R.id.etTother);


        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                String sDate = c.get(Calendar.YEAR) + "-"
                        + (c.get(Calendar.MONTH)+1)
                        + "-" + c.get(Calendar.DAY_OF_MONTH);

                if(etClo.getText().toString().equals("")){
                    etClo.setText("0");
                }
                if(etTra.getText().toString().equals("")){
                    etTra.setText("0");
                }
                if(etEnt.getText().toString().equals("")){
                    etEnt.setText("0");
                }
                if(etMed.getText().toString().equals("")){
                    etMed.setText("0");
                }
                if(etOth.getText().toString().equals("")){
                    etOth.setText("0");
                }


                boolean insertData = myDB.addData(sDate,
                        etTClo.getText().toString(),Integer.parseInt(etClo.getText().toString()),
                        etTMed.getText().toString(),Integer.parseInt(etMed.getText().toString()),
                        etTEnt.getText().toString(),Integer.parseInt(etEnt.getText().toString()),
                        etTtra.getText().toString(),Integer.parseInt(etTra.getText().toString()),
                        etTOth.getText().toString(),Integer.parseInt(etOth.getText().toString())

                );
                if(!insertData==true)
                    Log.d("something","getwrong");


                AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                alertDialog.setTitle("Congrulations");
                alertDialog.setMessage("Your record is added");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();

            }
        });

        demo();

    }

    public  void demo(){

        Cursor data = myDB.getListContents("clothesM");

        String gunay = "";
        if(data.getCount() != 0)
        {
            while(data.moveToNext())
            {
                gunay=gunay+ "--"+data.getString(0)+"--";
            }
            Log.d("Gunay",gunay);

        }
    }
}
