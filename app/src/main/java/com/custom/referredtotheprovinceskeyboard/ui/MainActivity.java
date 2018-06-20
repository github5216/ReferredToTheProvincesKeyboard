package com.custom.referredtotheprovinceskeyboard.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.custom.referredtotheprovinceskeyboard.R;
import com.custom.referredtotheprovinceskeyboard.adapter.CustomKeyboardAdapter;
import com.custom.referredtotheprovinceskeyboard.custom.CustomGridView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomKeyboardAdapter.OnKeyboardClickListener {

    private Button button;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_provinces_keyboard);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_keyboard, null);
        CustomGridView keyBoard = (CustomGridView) view.findViewById(R.id.gv_custom_keyboard);
        CustomKeyboardAdapter adapter = new CustomKeyboardAdapter(this);
        keyBoard.setAdapter(adapter);
        adapter.setOnKeyboardClickListener(this);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//设置PopupWindow的视图内容
        // 设置PopupWindow的背景
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        mPopupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        mPopupWindow.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//            mPopupWindow.showAsDropDown(mTvPlateCodeAbbreviation);
        mPopupWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void OnKeyboardClick(int position) {
        mPopupWindow.dismiss();
        Log.e("LOG", "position = " + position + getResources().getStringArray(R.array.province_abbreviation)[position]);
        button.setText(getResources().getStringArray(R.array.province_abbreviation)[position]);
        Toast.makeText(this, getResources().getStringArray(R.array.province_abbreviation)[position], Toast.LENGTH_SHORT).show();
    }
}
