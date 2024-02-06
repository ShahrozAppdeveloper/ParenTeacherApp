package com.example.parentteacherapp.Activity;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parentteacherapp.ParentModule.ParentDasboardActivity;
import com.example.parentteacherapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {
    Spinner spinner;
    private FirebaseAuth mAuth;
    String currentstatus;
    EditText edemail,edpass;
    TextView tvforgotpass,tvsignup;
    Button btnlogin;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);
        changeColorStatusBar(R.color.green_color);
        // calling method()
        Ids();
        clickListener();

        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Lawyer");
        arrayList.add("Parent");
        arrayList.add("Teacher");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentstatus = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected:"+currentstatus,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
    private void Ids(){
        spinner = findViewById(R.id.spinner);
        edemail=findViewById(R.id.edemailid);
        edpass=findViewById(R.id.edpasswordid);
        tvforgotpass=findViewById(R.id.forgotpassId);
        btnlogin=findViewById(R.id.btnloginid);
        tvsignup=findViewById(R.id.signuptvid);
    }
    private void clickListener(){
        tvforgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgotpasswordActivity.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edemail.getText().toString().isEmpty() ||
                        edpass.getText().toString().isEmpty()){
                    Toast.makeText(SignInActivity.this, "Enter Email and password", Toast.LENGTH_SHORT).show();
                }else if(!edemail.getText().toString().contains("@gmail.com")){
                    Toast.makeText(SignInActivity.this, "Please Enter valid Email", Toast.LENGTH_SHORT).show();
                }else if(edpass.getText().toString().length()<6){
                    Toast.makeText(SignInActivity.this, "Please Enter valid Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    dialog = new ProgressDialog(SignInActivity.this);
                    dialog.setMessage("please wait...");
                    dialog.show();
                    SignIn(edemail.getText().toString(),edpass.getText().toString());
                }
            }
        });
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignupAppActivity.class));
            }
        });
    }
    private void SignIn(String email,String pass){
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Intent intent=new Intent(getApplicationContext(), ParentDasboardActivity.class);
                    intent.putExtra("Status",currentstatus);
                    Toast.makeText(SignInActivity.this, "welcome"+currentstatus, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    dialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignInActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void changeColorStatusBar(@ColorRes int color) {
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(window, decorView);
        wic.setAppearanceLightStatusBars(true);
        // You can set any background color to the status bar.
        window.setStatusBarColor(ContextCompat.getColor(this, color));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SignInActivity.this,SignupAppActivity.class));
    }

}