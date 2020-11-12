package com.ateam.mannajob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;


public class LoginActivity extends AppCompatActivity implements MyApplication.OnResponseListener{
    OAuthLogin mOAuthLoginModule = OAuthLogin.getInstance();
    private static Context mContext;

    private static TextView mOauthAT;
    private static TextView mOauthRT;
    private static TextView mOauthExpires;
    private static TextView mOauthTokenType;
    private static TextView mOAuthState;
    EditText ID;
    EditText PASSWORD;
    Button loginButton;
    Button registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        naverLogin();
        init();

    }

    private void init(){
        ID = findViewById(R.id.login_id);
        PASSWORD =findViewById(R.id.login_passwd);

        loginButton = findViewById(R.id.login_ok_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ID.getText().toString();
                String passwd = PASSWORD.getText().toString();

            }
        });
        registerButton=findViewById(R.id.register_m_Btn);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void processResponse(int requestCode, int responseCode, String response) {

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    private void naverLogin(){
        mOAuthLoginModule.init(
                com.ateam.mannajob.LoginActivity.this
                ,"DOUPfgH6gVD3oT4MgNca"
                , "HLrt0ibn45"
                ,"Mannajob"
                //,OAUTH_CALLBACK_INTENT
                // SDK 4.1.4 버전부터는 OAUTH_CALLBACK_INTENT변수를 사용하지 않습니다.
        );
        final OAuthLoginButton mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

    }
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginModule.getAccessToken(mContext);
                String refreshToken = mOAuthLoginModule.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginModule.getExpiresAt(mContext);
                String tokenType = mOAuthLoginModule.getTokenType(mContext);
                Log.d("accessToken : ",accessToken);
                Log.d("refreshToken : ",refreshToken);
                Log.d("expiresAt : ",String.valueOf(expiresAt));
                Log.d("tokenType : ",tokenType);
                Log.d("LoginModule:getState  :",mOAuthLoginModule.getState(mContext).toString());
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };
}