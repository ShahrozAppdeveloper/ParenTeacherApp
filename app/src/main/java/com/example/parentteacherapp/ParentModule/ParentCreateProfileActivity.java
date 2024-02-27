package com.example.parentteacherapp.ParentModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parentteacherapp.ModelCLass.AddParentDetailToRealtym;
import com.example.parentteacherapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ParentCreateProfileActivity extends AppCompatActivity {
    private final int PICK_IMAGE_REQUEST = 22;
    private Uri filePath;
    ImageView imagepick;
    String currentUser;
    ProgressDialog dialog;
    EditText edname, edrollnumid, edsubject;
    Spinner spinner;
    FirebaseStorage storage;
    Button btncreateprofile;
    private FirebaseAuth mAuth;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String username, subject, rollnum,department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_create_profile);
        Ids();
        Clicklistener();
        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Lawyer");
        arrayList.add("BSCS");
        arrayList.add("BSIT ");
        arrayList.add("BSSE");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected:"+department,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
    private void Ids() {
        imagepick = findViewById(R.id.pickimageid);
        edname = findViewById(R.id.ednameid);
        edrollnumid = findViewById(R.id.edschoolid);
        edsubject = findViewById(R.id.edsubjectid);
        spinner = findViewById(R.id.spinner);
        btncreateprofile = findViewById(R.id.btncreateprofileid);
    }

    private void Clicklistener() {
        imagepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickImage();
            }
        });
        btncreateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = edname.getText().toString().trim();
                subject = edsubject.getText().toString().trim();
                rollnum = edrollnumid.getText().toString().trim();
                if (username.isEmpty() ||
                        subject.isEmpty()||
                        rollnum.isEmpty()
                ) {
                    Toast.makeText(getApplicationContext(), "Please Fill Details", Toast.LENGTH_SHORT).show();
                } else {
                    UploadImageNdDetails();
                    dialog = new ProgressDialog(ParentCreateProfileActivity.this);
                    dialog.setMessage("please wait...");
                    dialog.show();

                }
            }
        });
    }
    private void PickImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,
                resultCode,
                data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null
                && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(),
                        filePath);
                imagepick.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void UploadImageNdDetails()
    {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("ParentProfile");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        currentUser=user.getUid().toString();
        if (filePath != null) {
            StorageReference ref = storageReference.child("images/"
                    + UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            String imageurl=uri.toString();
                                            AddParentDetailToRealtym obj=new AddParentDetailToRealtym(currentUser,username,rollnum,department,imageurl);
                                            databaseReference.child(currentUser).setValue(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        dialog.dismiss();
                                                        firebaseDatabase.getReference("Parent").child(department).child(currentUser).setValue(obj);
                                                        Intent intent=new Intent(ParentCreateProfileActivity.this, ParentDasboardActivity.class);
                                                        startActivity(intent);
                                                        Toast.makeText(getApplicationContext(),"Uploaded",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(getApplicationContext(), "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });
        }else{
            Toast.makeText(getApplicationContext(), "please Select the Image", Toast.LENGTH_SHORT).show();
        }

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
//        String currentUsers=user.getUid().toString();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference profilesRef = database.getReference("ParentProfile");
//        profilesRef.child(currentUsers).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    startActivity(new Intent(ParentCreateProfileActivity.this,ParentDasboardActivity.class));
//                } else {
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // An error occurred while querying the database
//                Toast.makeText(ParentCreateProfileActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}