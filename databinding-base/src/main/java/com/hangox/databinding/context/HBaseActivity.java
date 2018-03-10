package com.hangox.databinding.context;

import android.databinding.DataBindingComponent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hangox.databinding.toast.ToastCake;
import com.hangox.databinding.toast.ToastCakeWorker;


/**
 * Created With Android Studio
 * User hangox
 * Date 16/5/26
 * Time 下午10:05
 * Activity 的父类
 */

public abstract class HBaseActivity extends AppCompatActivity implements ToastCake,LayoutProvider,ComponentProvider {

    protected ToastCakeWorker mToastWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToastWorker = new ToastCakeWorker(this);
        configActionBar();

    }

    protected void configActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null && isShowNavigationUp()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    public HBaseActivity getActivity() {
        return this;
    }


    /**
     * 是否显示返回按键
     * @return
     */
    protected boolean isShowNavigationUp(){
        return true;
    }


    @Override
    public void showL(String message) {
        mToastWorker.showL(message);
    }

    @Override
    public void showS(String message) {
        mToastWorker.showS(message);
    }

    @Override
    public void showL(@StringRes int res) {
        mToastWorker.showL(res);
    }

    @Override
    public void showS(@StringRes int res) {
        mToastWorker.showS(res);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onHomeButtonClick();
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 点击左上角的按钮时候触发
     */
    protected void onHomeButtonClick(){
        finish();
    }

    @Override
    public DataBindingComponent provideComponent() {
        return null;
    }
}
