package com.example.daggrdemo;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pengju.liu on 2016/8/11.
 */
@Module
public class AppModule {
  private Application application;

  public AppModule(Application application){
    this.application=application;
  }

  @Provides
  public Application provideApplication(){
    return application;
  }
}