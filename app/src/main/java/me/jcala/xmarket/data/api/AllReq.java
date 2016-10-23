package me.jcala.xmarket.data.api;


import android.support.annotation.NonNull;

import java.util.List;

import me.jcala.xmarket.conf.ApiConf;
import me.jcala.xmarket.data.pojo.DealItem;
import me.jcala.xmarket.data.dto.Result;
import me.jcala.xmarket.data.pojo.SortTag;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface AllReq {

    /**
     * 用户登录请求
     */
    @POST(ApiConf.login_url)
    Observable<Result<String>> login(
            @Field("username")@NonNull String username,
            @Field("password")@NonNull String password);

    /**
     * 用户注册请求
     */
    @POST(ApiConf.register_url)
    Observable<Result<String>> register(
            @Field("username")  String username,
            @Field("phone")  String phone,
            @Field("password")  String password);

    /**
     * 获取分类列表请求
     */
    @GET(ApiConf.sort_url)
    Observable<Result<List<SortTag>>> sortTag();

    /**
     *获取本校在售商品列表
     */
    @GET(ApiConf.school_url+"/{school}/{page}")
    Observable<Result<List<DealItem>>> schoolDeals(
            @Path("school")  String school,
            @Path("page") int page
    );




}
