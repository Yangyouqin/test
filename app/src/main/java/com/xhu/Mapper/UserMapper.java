package com.xhu.Mapper;
import android.os.Handler;
import android.os.Message;

import com.data.UserData;
import com.example.com.bangbang.MainActivity;
import com.xhu.javaBeans.User;

import cn.bmob.newim.db.dao.UserDao;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


/**
 * Created by YQ on 2017/11/16.
 */

public class UserMapper {
    public boolean[] Insert(User user) {
        final boolean[] flag = new boolean[1];
        flag[0] = false;
        User u = user;
        u.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    flag[0] = true;
                    //Toast.makeText(AddData.this,"添加数据成功，返回objectId为：",Toast.LENGTH_LONG).show();
                } else {
                    flag[0] = false;
                    // Toast.makeText(MainActivity.this,"添加数据失败！",Toast.LENGTH_LONG).show();
                }
            }
        });
        return flag;
    }
    public  User querry(String id){
        final UserData userData = new UserData();
        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.getObject(id, new QueryListener<User>() {
            @Override
            public void done(User object,BmobException e) {
                if(e==null){
                    getData(object);
                    userData.setUser(object);
                    System.out.println("查询成功");
                }else{
                    System.out.println("查询失败！");
                }
            }
        });
        //System.out.println(userData.getUser().toString());
        return userData.getUser();
    }

    public User getData(User object) {
        if(object!=null){
            UserData.user = object;
            System.out.println("取值成功getData"+UserData.user.toString());
            return object;
        }
        else {
            System.out.print("查询返回的数据为空");
        }
        return null;

    }

    public void delete(String id){

        User p2 = new User();
        p2.setObjectId(id);
        p2.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    //toast("删除成功:"+p2.getUpdatedAt());
                }else{
                    //toast("删除失败：" + e.getMessage());
                }
            }

        });
    }

    public void update(User user){
        //User p2 = new User();
        //p2.setAddress("北京朝阳");
        user.update(user.getId(), new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    //toast("更新成功:"+p2.getUpdatedAt());
                }else{
                    //toast("更新失败：" + e.getMessage());
                }
            }

        });
    }
}
