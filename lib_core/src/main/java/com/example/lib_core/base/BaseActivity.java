package com.example.lib_core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lib_core.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private boolean isStatus; //沉浸式
    private boolean isFullScreen;  //全屏
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder=ButterKnife.bind(this);
        initView();
        initData();
    }
    protected abstract void initData();
    protected abstract void initView();
    /**
         * 绑定跟布局id
         * @return
         */
        public abstract int bindLayoutId();
        /**
         * 显示吐司
         * @param msg
         */
        public void showToast(String msg){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
        /**
         * 无参跳转
         * @param clazz
         */
        public void startActivity(Class<?> clazz){
            startActivity(new Intent(this,clazz));
        }
        /**
         * 有参跳转
         * @param bundle
         * @param clazz
         */
        public void startActivity(Bundle bundle,Class<?> clazz){
            Intent intent=new Intent(this,clazz);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        /**
         *   沉浸式
         * @param status
         */
        public void isStatus(boolean status){
            if (status){
                //沉浸式代码
            }
    }

    /**
     * 全面屏
     * @param fullscreen
     */
    public void isFullscreen(boolean fullscreen){
        if (fullscreen){
            //全面代码
        }
    }
// Activity 生命周期
    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();  //解绑
        }
    }
}
