package com.ateam.mannajob;

import android.content.Context;
import android.os.Bundle;
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
        ID = findViewById(R.id.editTextId);
        PASSWORD =findViewById(R.id.editTextPassword);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ID.getText().toString();
                String passwd = PASSWORD.getText().toString();


            }
        });
        registerButton=findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void processResponse(int requestCode, int responseCode, String response) {

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    private void naverLogin(){
        mOauthAT = (TextView) findViewById(R.id.oauth_access_token);
        mOauthRT = (TextView) findViewById(R.id.oauth_refresh_token);
        mOauthExpires = (TextView) findViewById(R.id.oauth_expires);
        mOauthTokenType = (TextView) findViewById(R.id.oauth_type);
        mOAuthState = (TextView) findViewById(R.id.oauth_state);
        mOAuthLoginModule.init(
                com.kel.foodbest.LoginActivity.this
                ,"w7uEYyc3AeYOmO9_XMbc"
                , "mdP7muOCeR"
                ,"FoodBest"
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
                mOauthAT.setText(accessToken);
                mOauthRT.setText(refreshToken);
                mOauthExpires.setText(String.valueOf(expiresAt));
                mOauthTokenType.setText(tokenType);
                mOAuthState.setText(mOAuthLoginModule.getState(mContext).toString());
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };


}