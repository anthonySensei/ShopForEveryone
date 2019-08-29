package com.example.sfe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sfe.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ResetPasswordActivity extends AppCompatActivity {


    private String check = "";
    private TextView resetPasswordTitle, titleQuestions;
    private EditText phoneNumber, question1, question2;
    private Button veridyBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        check = getIntent().getStringExtra("check");


        resetPasswordTitle = findViewById(R.id.reset_password_tv);
        titleQuestions = findViewById(R.id.title_question);
        phoneNumber = findViewById(R.id.find_phone_number);
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        veridyBtn = findViewById(R.id.verified_btn);




    }


    @Override
    protected void onStart() {
        super.onStart();


        phoneNumber.setVisibility(View.GONE);


        if(check.equals("settings")){

            resetPasswordTitle.setText("Set questions");
            titleQuestions.setText("Please set answers to the following security questions");
            veridyBtn.setText("Set");


            displayPreviousAnswers();


            veridyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    setAnswers();



                }
            });
        }else if(check.equals("login")){

            phoneNumber.setVisibility(View.VISIBLE);



            veridyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    verifyUser();

                }
            });
        }

    }

    private void setAnswers(){
        String answer1 = question1.getText().toString().toLowerCase();
        String answer2 = question2.getText().toString().toLowerCase();


        if(question1.equals("") && question2.equals("")){

            Toast.makeText(ResetPasswordActivity.this, "Please answer to the both queastions", Toast.LENGTH_SHORT).show();


        }else{

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                    .child("Users")
                    .child(Prevalent.currentOnlineUser.getPhone());

            HashMap<String, Object> userDataMap = new HashMap<>();
            userDataMap.put("answer1", answer1);
            userDataMap.put("answer2", answer2);


            ref.child("Security questions").updateChildren(userDataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful()){

                        Toast.makeText(ResetPasswordActivity.this, "Security questions was set successfully", Toast.LENGTH_SHORT).show();



                        Intent intent = new Intent(ResetPasswordActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }


                }
            });

        }
    }

    private void displayPreviousAnswers(){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                .child("Users")
                .child(Prevalent.currentOnlineUser.getPhone());


        ref.child("Security questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if(dataSnapshot.exists()){

                    String answ1 = dataSnapshot.child("answer1").getValue().toString();
                    String answ2 = dataSnapshot.child("answer2").getValue().toString();



                    question1.setText(answ1);
                    question2.setText(answ2);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private  void verifyUser(){


        final String phone = phoneNumber.getText().toString();
        final String answer1 = question1.getText().toString().toLowerCase();
        final String answer2 = question2.getText().toString().toLowerCase();


        if(!phone.equals("") && !answer1.equals("") && !answer2.equals("")){


            final DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                    .child("Users")
                    .child(phone);


            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists()){

                        String  mPhone = dataSnapshot.child("phone").getValue().toString();




                        if(dataSnapshot.hasChild("Security questions")){


                            String answ1 = dataSnapshot.child("Security questions").child("answer1").getValue().toString();
                            String answ2 = dataSnapshot.child("Security questions").child("answer2").getValue().toString();

                            if(!answ1.equals(answer1)){

                                Toast.makeText(ResetPasswordActivity.this, "Your first answer is wrong", Toast.LENGTH_SHORT).show();
                            }else if(!answ2.equals(answer2)){

                                Toast.makeText(ResetPasswordActivity.this, "Your second answer is wrong", Toast.LENGTH_SHORT).show();

                            }else{

                                final AlertDialog.Builder builder = new AlertDialog.Builder(ResetPasswordActivity.this);
                                builder.setTitle("New password");


                                final EditText newPasswrod = new EditText(ResetPasswordActivity.this);
                                newPasswrod.setHint("New password");
                                builder.setView(newPasswrod);


                                builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        if(!newPasswrod.getText().toString().equals("")){


                                            ref.child("password")
                                                    .setValue(newPasswrod.getText().toString())
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if(task.isSuccessful()){


                                                                Toast.makeText(ResetPasswordActivity.this, "Password change successfully", Toast.LENGTH_SHORT).show();

                                                                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                                                                startActivity(intent);


                                                            }
                                                        }
                                                    });


                                        }
                                    }
                                });


                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                builder.show();
                            }


                        }


                        else{

                            Toast.makeText(ResetPasswordActivity.this, "You haven't set security questions", Toast.LENGTH_SHORT).show();

                        }


                    }else{


                        Toast.makeText(ResetPasswordActivity.this, "This phone number not exist.", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {




                }
            });


        }else {

            Toast.makeText(this, "Please complete the form.", Toast.LENGTH_SHORT).show();
            
        }



    }

}
