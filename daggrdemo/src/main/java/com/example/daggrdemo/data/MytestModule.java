package com.example.daggrdemo.data;

import dagger.Module;
import dagger.Provides;
import java.util.Random;

/**
 * Created by pengju.liu on 2016/8/11.
 */
@Module
public class MytestModule {

  @Provides
  public int provideinfomation(){
    return new Random().nextInt(100);
  }

  @Provides
  public TestService provideApiService(){
    return null;
  }

}
