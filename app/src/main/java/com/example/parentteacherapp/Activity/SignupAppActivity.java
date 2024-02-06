package com.example.parentteacherapp.Activity;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

import com.example.parentteacherapp.ModelCLass.CurrentStatusDetails;
import com.example.parentteacherapp.ParentModule.ParentCreateProfileActivity;
import com.example.parentteacherapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SignupAppActivity extends AppCompatActivity {
    TextView tvlogin;
    Spinner spinner;
    String currentstatus;
    Button btnSignup;
    private FirebaseAuth mAuth;
    EditText edFname,edemail,edpass;
    ProgressDialog dialog;
    String currentUser;
    String uid;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Edu Connect App");
        alertDialogBuilder.setMessage("Do you want to close the App?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the activity
                finishAffinity();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Hide the dialog (do nothing)
                dialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        // calling method
        Ids();
        clicklistener();
        changeColorStatusBar(R.color.green_color);

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
        tvlogin=findViewById(R.id.tvloginid);
        spinner = findViewById(R.id.spinner);
        btnSignup=findViewById(R.id.btncreateacountid);
        edFname=findViewById(R.id.edfirstnameid);
        edemail=findViewById(R.id.edemailid);
        edpass=findViewById(R.id.edpasswordid);
    }
    private void clicklistener(){
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edFname.getText().toString().isEmpty()||
                        edpass.getText().toString().isEmpty()||
                        edemail.getText().toString().isEmpty()
                ){
                    Toast.makeText(SignupAppActivity.this, "Enter Detail please", Toast.LENGTH_SHORT).show();

                }else if(edpass.getText().toString().length()<6){
                    Toast.makeText(SignupAppActivity.this, "Enter valid password", Toast.LENGTH_SHORT).show();
                }else if(!edemail.getText().toString().contains("@gmail.com")){
                    Toast.makeText(SignupAppActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                }
                else{
                    dialog = new ProgressDialog(SignupAppActivity.this);
                    dialog.setMessage("please wait...");
                    dialog.setTitle("ParentTeacherApp");
                    dialog.show();
                    Signup(edemail.getText().toString(),edpass.getText().toString());


                }
            }
        });

    }
    private void Signup(String email,String pass){
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    String uid = user.getUid();
                    Intent intent=new Intent(getApplicationContext(), ParentCreateProfileActivity.class);
                    intent.putExtra("Status",currentstatus);
                    Toast.makeText(SignupAppActivity.this, "welcome"+" "+currentstatus.toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    AddUSerDataToRealtime(uid,edFname.getText().toString(),
                            edemail.getText().toString(),
                            edpass.getText().toString());
                    dialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignupAppActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void AddUSerDataToRealtime(String userid,String name,String email,String pass){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Parent Teacher App").child("Account Details");
        CurrentStatusDetails obj=new CurrentStatusDetails(
                userid,
                name,
                pass,
                email,
                currentstatus);
        myRef.child(userid).setValue(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignupAppActivity.this, "Sucesfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignupAppActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(uid!=null){
            FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
            DatabaseReference ref=firebaseDatabase.getReference("Parent Teacher App").child("Account Details").child(uid);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        CurrentStatusDetails obj=snapshot.getValue(CurrentStatusDetails.class);
                        currentUser=obj.getCurrentstatus();
                        Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
                        intent.putExtra("Status",currentUser);
                        startActivity(intent);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(SignupAppActivity.this, "Error"+error, Toast.LENGTH_SHORT).show();
                }
            });

        }else{

        }
    }
    public void changeColorStatusBar(@ColorRes int color) {
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(window, decorView);
        wic.setAppearanceLightStatusBars(true);
        // You can set any background color to the status bar.
        window.setStatusBarColor(ContextCompat.getColor(this, color));
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        // Show the AlertDialog when the back button is pressed
        alertDialog.show();
    }



}