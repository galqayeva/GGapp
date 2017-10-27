package g.y.v.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import g.y.v.anew.Other.DatabaseHelper;


public class CategoryActivity extends AppCompatActivity {

    EditText etClo,etTra,etEnt,etCos,etRes,etBir,etMed,etJew,etMar,etOth;
    EditText etTClo,etTtra,etTEnt,etTCos,etTRes,etTBir,etTMed,etTJew,etTMar,etTOth;
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
        etCos=(EditText)findViewById(R.id.etCos);
        etRes=(EditText)findViewById(R.id.etRes);
        etBir=(EditText)findViewById(R.id.etBirth);
        etMed=(EditText)findViewById(R.id.etMed);
        etJew=(EditText)findViewById(R.id.etJew);
        etMar=(EditText)findViewById(R.id.etMar);
        etOth=(EditText)findViewById(R.id.etOther);

        etTClo=(EditText)findViewById(R.id.etTclot);
        etTtra=(EditText)findViewById(R.id.etTransp);
        etTEnt=(EditText)findViewById(R.id.etTenter);
        etTCos=(EditText)findViewById(R.id.etTcosmetic);
        etTRes=(EditText)findViewById(R.id.etTrestaurnat);
        etTBir=(EditText)findViewById(R.id.etTbirth);
        etTMed=(EditText)findViewById(R.id.etTmedicin);
        etTJew=(EditText)findViewById(R.id.etTjewelery);
        etTMar=(EditText)findViewById(R.id.etTmarket);
        etTOth=(EditText)findViewById(R.id.etTother);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean insertData = myDB.addData(Integer.parseInt("121212"),
                        etTClo.getText().toString(),Integer.parseInt(etClo.getText().toString()),
                        etTCos.getText().toString(),Integer.parseInt(etCos.getText().toString()),
                        etTMed.getText().toString(),Integer.parseInt(etMed.getText().toString()),
                        etTEnt.getText().toString(),Integer.parseInt(etEnt.getText().toString()),
                        etTRes.getText().toString(),Integer.parseInt(etRes.getText().toString()),
                        etTBir.getText().toString(),Integer.parseInt(etBir.getText().toString()),
                        etTMar.getText().toString(),Integer.parseInt(etMar.getText().toString()),
                        etTtra.getText().toString(),Integer.parseInt(etTra.getText().toString()),
                        etTJew.getText().toString(),Integer.parseInt(etJew.getText().toString()),
                        etTOth.getText().toString(),Integer.parseInt(etOth.getText().toString())


                );
                if(!insertData==true)
                    Log.d("something","getwrong");
            }
        });


    }
}
