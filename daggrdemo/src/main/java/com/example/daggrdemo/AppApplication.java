package com.example.daggrdemo;

import android.app.Application;
import com.example.daggrdemo.data.GithubApiModule;
import com.example.daggrdemo.data.MytestModule;

/**
 * Created by pengju.liu on 2016/8/11.
 */
public class AppApplication extends Application {

  private static AppApplication sInstance;
  private AppComponent appComponent;

  @Override
  public void onCreate(){
    super.onCreate();
    this.sInstance = this;
    setupCompoent();
  }

  private void setupCompoent(){
    appComponent = DaggerAppComponent.builder()
        .githubApiModule(new GithubApiModule())
        .appModule(new AppModule(this))
        .mytestModule(new MytestModule())
        .build();
  }

  public static AppApplication getsInstance(){
    return sInstance;
  }

  public AppComponent getAppComponent(){
    return appComponent;
  }
}
