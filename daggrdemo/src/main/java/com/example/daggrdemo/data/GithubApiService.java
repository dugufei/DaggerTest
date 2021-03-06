package com.example.daggrdemo.data;

import com.example.daggrdemo.data.entity.Repo;
import java.util.ArrayList;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by pengju.liu on 2016/8/11.
 */
public interface GithubApiService {
  @GET("/users/{user}/repos") Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
