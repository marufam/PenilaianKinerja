package com.project.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.florent37.R;
import com.project.application.rest.ApiClient;
import com.project.application.rest.ApiInterface;
import com.project.application.rest.pojo.Guru;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        final SharedPreferences.Editor editor = pref.edit();

        if(!pref.getString("kodeguru","").toString().isEmpty()){
            Intent a = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(a);
            finish();
        }

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestBody reqnip = RequestBody.create(MediaType.parse("multipart/form-data"), username.getText().toString());
                RequestBody reqTanggallahir = RequestBody.create(MediaType.parse("multipart/form-data"), password.getText().toString());
                RequestBody reqAction = RequestBody.create(MediaType.parse("multipart/form-data"), "LOGIN");

                ApiInterface mApiInterface = ApiClient.GetGuru().create(ApiInterface.class);
                Call<Guru> logincall = mApiInterface.loginguru(reqnip, reqTanggallahir, reqAction);
                logincall.enqueue(new Callback<Guru>() {

                    @Override
                    public void onResponse(Call<Guru> call, Response<Guru> response) {

                        Log.d("JSON", String.valueOf(response.body().getJumlah().toString()));
//                        Toast.makeText(LoginActivity.this, ""+String.valueOf(response.body().getJumlah().toString()), Toast.LENGTH_SHORT).show();
                        Log.d("JSON", response.body().getGuru().get(0).getNip().toString());
                        if(response.body().getJumlah().toString().equalsIgnoreCase("1")){
                            Toast.makeText(LoginActivity.this, "Success ", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(getApplicationContext(), MainActivity.class);
                            editor.putString("kodeguru", response.body().getGuru().get(0).getKodeguru());
                            editor.putString("nama", response.body().getGuru().get(0).getNama());
                            editor.putString("nip", response.body().getGuru().get(0).getNip());
                            editor.putString("jenisguru", response.body().getGuru().get(0).getJenisguru());
                            editor.commit();
                            startActivity(a);
                            finish();

                        }else{
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Guru> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                        Log.d("Error Login", t.toString());
                    }
                });
            }


        });
    }
}
