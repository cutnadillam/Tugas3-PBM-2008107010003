package id.ac.unsyiah.android.tugas03_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, NPM, jurusan;
    Button submit;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        NPM = (EditText) findViewById(R.id.npm);
        jurusan = (EditText) findViewById(R.id.jurusan);
        submit = (Button) findViewById(R.id.submit);
        DB = new DBHelper(this);

        submit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String npm = NPM.getText().toString();
                String jurusan_user = jurusan.getText().toString();

                if(user.equals("")||npm.equals("")||jurusan_user.equals(("")))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertData(user,npm,jurusan_user);
                    if(insert==true){
                        Toast.makeText(MainActivity.this, "berhasil memasukkan data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }));
    }
}