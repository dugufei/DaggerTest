package com.example.daggrdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import butterknife.OnClick;
import com.example.daggrdemo.AppComponent;
import com.example.daggrdemo.R;

/**
 * Created by pengju.liu on 2016/8/11.
 */
public class MainActivity extends BaseActivity {

  @OnClick(R.id.showButton)
  public void onShowRepositoriesClick() {
    startActivity(new Intent(this, ReposListActivity.class));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public int getLayoutId(){
    return R.layout.activity_main;
  }

  @Override
  public void setupActivityComponent(AppComponent appComponent){

  }
}
