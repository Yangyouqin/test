package com.example.com.bangbang;

import android.icu.text.SymbolTable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.data.UserData;
import com.xhu.Mapper.UserMapper;
import com.xhu.javaBeans.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //提供以下两种方式进行初始化操作：

        //第一：默认初始化
        Bmob.initialize(this, "47cd947fb9cda932d30e2a3fc9560660");
        // 注:自v3.5.2开始，数据sdk内部缝合了统计sdk，开发者无需额外集成，传渠道参数即可，不传默认没开启数据统计功能
        //Bmob.initialize(this, "Your Application ID","bmob");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
        textView = (TextView) findViewById(R.id.tv1);
        UserMapper userMapper = new UserMapper();
        userMapper.querry("dc5f53d33d");
        //System.out.println("主函数" + userData.getUser().toString());
        new Thread() {
            public void run () {
                System.out.println(1312);
                try {
                    sleep(2000);
                    if (UserData.user != null) {
                        System.out.println("用户信息：" + UserData.user.toString());
                    } else {
                        System.out.println("主函数获取为空");
                    }
                } catch (InterruptedException e) {
                    System.out.println("主函数线程失败");
                    e.printStackTrace();
                }

            }

        }.start();
    }

}
