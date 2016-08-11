package com.example.daggrdemo;

import com.example.daggrdemo.data.GithubApiModule;
import com.example.daggrdemo.data.MytestModule;
import com.example.daggrdemo.ui.activity.ReposListActivity;
import dagger.Component;

/**
 * Created by pengju.liu on 2016/8/11.
 */
@Component(modules = { AppModule.class, GithubApiModule.class, MytestModule.class})
public interface AppComponent {
  // inject what
  void inject(ReposListActivity activity);
}