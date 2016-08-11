package com.example.daggrdemo.ui.activity;

/**
 * Created by pengju.liu on 2016/8/11.
 */

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.example.daggrdemo.AppComponent;
import com.example.daggrdemo.R;
import com.example.daggrdemo.data.GithubApiService;
import com.example.daggrdemo.data.entity.Repo;
import com.example.daggrdemo.ui.adapter.ListAdapter;
import com.example.daggrdemo.utils.SimpleObserver;
import java.util.ArrayList;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReposListActivity extends BaseActivity {

  @BindView(R.id.repos_rv_list) RecyclerView mRvList;

  @BindView(R.id.pbLoading) ProgressBar pbLoading;


  @Inject GithubApiService githubApiService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initView();
  }

  @Override
  public int getLayoutId(){
    //return R.layout.activity_repos_list;
    return R.layout.activity_repo_list;
  }

  @Override
  public void setupActivityComponent(AppComponent appComponent){
    appComponent.inject(this);
  }


  private void initView(){
    LinearLayoutManager manager = new LinearLayoutManager(this);
    manager.setOrientation(LinearLayoutManager.VERTICAL);
    mRvList.setLayoutManager(manager);

    ListAdapter adapter = new ListAdapter();
    mRvList.setAdapter(adapter);
    loadData(adapter);
  }

  private void loadData(final ListAdapter adapter){
    showLoading(true);
    githubApiService.getRepoData(getUser())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SimpleObserver<ArrayList<Repo>>() {
          @Override
          public void onNext(ArrayList<Repo> repos) {
            showLoading(false);
            adapter.setRepos(repos);
          }
          @Override
          public void onError(Throwable e){
            showLoading(false);
          }
        });
  }

  private String getUser(){
    return "bird1015";
  }

  public void showLoading(boolean loading) {
    Log.i("info",loading + " Repos");
    pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
  }
}
