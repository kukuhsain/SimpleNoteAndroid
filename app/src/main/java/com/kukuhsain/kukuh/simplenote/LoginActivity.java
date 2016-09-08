package com.kukuhsain.kukuh.simplenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_action_bar) TextView tvTitleActionBar;
    @BindView(R.id.tv_fb_token) TextView tvFbToken;
    @BindView(R.id.fb_login_button) LoginButton fbLoginButton;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate...");
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tvTitleActionBar.setText("New Login");

        callbackManager = CallbackManager.Factory.create();
        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Timber.d("fb login: onSuccess...");
                Timber.d(loginResult.getAccessToken().getToken());
                tvFbToken.setVisibility(View.VISIBLE);
                tvFbToken.setText(loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                Timber.d("fb login: onCancel...");
            }

            @Override
            public void onError(FacebookException error) {
                Timber.d("fb login: onError...");
                Timber.d(error.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.d("onRestart...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.d("onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.d("onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy...");
    }
}

