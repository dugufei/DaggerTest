package com.example.daggrdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.daggrdemo.AppApplication;
import com.example.daggrdemo.AppComponent;

/**
 * Created by pengju.liu on 2016/8/11.
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    setupActivityComponent(AppApplication.getsInstance().getAppComponent());
  }

  protected abstract void setupActivityComponent(AppComponent appComponent);
  protected abstract int getLayoutId();

}
