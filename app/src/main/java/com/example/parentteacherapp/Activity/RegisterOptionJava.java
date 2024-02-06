package com.example.parentteacherapp.Activity;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityRegisterOptionJavaBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterOptionJava extends AppCompatActivity {
    private ActivityRegisterOptionJavaBinding binding;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    FirebaseDatabase database;
    FirebaseAuth auth;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterOptionJavaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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
        //
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        binding.ButtonregID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignupAppActivity.class));
            }
        });
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .requestIdToken("800663102241-5aofsumkf765trearvtgcevdm22ntugh.apps.googleusercontent.com").build();
        gsc = GoogleSignIn.getClient(this, gso);

        binding.appCompatButtongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SigIn();
            }
        });
        binding.btnloginID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
        // Initialize firebase user
        FirebaseUser firebaseUser = auth.getCurrentUser();
        // Check condition
        if (firebaseUser != null) {
            // When user already sign in redirect to profile activity
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
        changeColorStatusBar(R.color.green_color);
    }

    private void SigIn() {
        Intent signinIntent = gsc.getSignInIntent();
        startActivityForResult(signinIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> signintask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = signintask.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());

                gotoNextActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void firebaseAuth(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();

                    HashMap<String, Object> obj = new HashMap<>();
                    obj.put("id", user.getUid());
                    obj.put("name", user.getDisplayName());
                    obj.put("email", user.getEmail());

                    database.getReference(
                            "Parent Teacher App").child("Account Details").child(user.getUid()).setValue(obj);
                    Toast.makeText(RegisterOptionJava.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterOptionJava.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gotoNextActivity() {
        finish();
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
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
        alertDialog.show();
//        super.onBackPressed();
    }

}