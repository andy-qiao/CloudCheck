package com.check.v3.business;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.check.client.R;
import com.check.v3.api.VolleyErrorHelper;
import com.check.v3.preferences.DataPreference;


public class MainActivity extends Activity
{
  public static final int MENU_EXIT = 2;
  public static final int MENU_HELP = 1;
  boolean isExit;
  private DataPreference mDataPreferences;
  Handler mHandler;
  private static String TAG = "MainActivity";
  
  JSONObject _json_data;
  private RequestQueue mQueue;

//
//  private void showCustomDialog()
//  {
//    CustomAlertDialog.Builder localBuilder1 = new CustomAlertDialog.Builder(this).setIcon(R.drawable.menu_exit);
//    String str = getResources().getString(2131165185);
//    CustomAlertDialog.Builder localBuilder2 = localBuilder1.setTitle(str).setMessage(2131165186);
//    MainActivity.2 local2 = new MainActivity.2(this);
//    CustomAlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton("确定", local2);
//    MainActivity.3 local3 = new MainActivity.3(this);
//    localBuilder3.setNegativeButton("取消", local3).create().show();
//  }

//  public void exit()
//  {
//    if (!this.isExit)
//    {
//      this.isExit = 1;
//      Toast.makeText(getApplicationContext(), "再按一次后退键退出", 0).show();
//      boolean bool1 = this.mHandler.sendEmptyMessageDelayed(0, 2000L);
//    }
//    while (true)
//    {
//      return;
//      boolean bool2 = this.mDataPreferences.saveData("LOGOUT_BY_USER", 1);
//      Intent localIntent1 = new Intent("android.intent.action.MAIN");
//      Intent localIntent2 = localIntent1.addCategory("android.intent.category.HOME");
//      startActivity(localIntent1);
//      System.exit(0);
//    }
//  }

  protected void onCreate(Bundle bundle)
  {
    super.onCreate(bundle);
    setContentView(R.layout.main_activity);
    
    mQueue = ApplicationController.getInstance().getRequestQueue();
    
    _json_data = new JSONObject();
    try {
		_json_data.put("name", "test");
		_json_data.put("password", "12345");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
//    RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
//    mQueue.add(new JsonObjectRequest(Method.POST, "http://42.121.55.211:8088/v3/api/v1/sessions/create", _json_data,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "response : " + response.toString());
//                    }
//                }, new Response.ErrorListener() {
//
//					@Override
//					public void onErrorResponse(VolleyError errInfo) {
//						String errorStr = VolleyErrorHelper.getMessage(getApplicationContext(), errInfo);
//						Log.d(TAG, "error response : " + errorStr);
//					}
//				}));
//    mQueue.start();
    
    Button test_login_btn = (Button)findViewById(R.id.test_login_btn);
    test_login_btn.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
		    mQueue.add(new JsonObjectRequest(Method.POST, "http://42.121.55.211:8088/v3/api/v1/sessions/create", _json_data,
	                new Response.Listener<JSONObject>() {
	                    @Override
	                    public void onResponse(JSONObject response) {
	                        Log.d(TAG, "response : " + response.toString());
	                    }
	                }, new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError errInfo) {
							String errorStr = VolleyErrorHelper.getMessage(getApplicationContext(), errInfo);
							Log.d(TAG, "error response : " + errorStr);
						}
					}));
	    mQueue.start();
		}
    	
    });
//    Context localContext = getApplicationContext();
//    DataPreference localDataPreference = new DataPreference(localContext);
//    this.mDataPreferences = localDataPreference;
//    boolean bool = this.mDataPreferences.saveData("LOGOUT_BY_USER", 0);
//    TextView localTextView1 = (TextView)findViewById(2131296290);
//    TextView localTextView2 = (TextView)findViewById(2131296291);
//    localTextView1.setText("登录成功!");
//    StringBuilder localStringBuilder = new StringBuilder("Session Id: ");
//    String str1 = this.mDataPreferences.getString("SESSION_ID");
//    String str2 = str1;
//    localTextView2.setText(str2);
  }

//  public boolean onCreateOptionsMenu(Menu paramMenu)
//  {
//    MenuItem localMenuItem1 = paramMenu.add(0, 1, 1, "帮助").setIcon(2130837543);
//    MenuItem localMenuItem2 = paramMenu.add(0, 2, 2, "退出").setIcon(2130837541);
//    return super.onCreateOptionsMenu(paramMenu);
//  }

//  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
//  {
//    if (paramInt == 4)
//      exit();
//    boolean bool;
//    for (int i = 0; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
//      return i;
//  }
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case R.id.login_menu_setting:
//			break;
//		case R.id.login_menu_exit:
//			exitDialog(LoginActivity.this, "QQ提示", "亲！您真的要退出吗？");
//			break;
//		default:
//			break;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}