package com.custom.referredtotheprovinceskeyboard.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.custom.referredtotheprovinceskeyboard.R;
import com.custom.referredtotheprovinceskeyboard.adapter.CustomKeyboardAdapter;

/**
 * - @Description:
 * - @Author:  chenjianming
 * - @Time:  2018/6/20 16:27
 */
public class ReferredProvincesKeyboard {

    public static PopupWindow build(Context context, CustomKeyboardAdapter.OnKeyboardClickListener keyboardClickListener) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_keyboard, null);
        CustomGridView keyBoard = (CustomGridView) view.findViewById(R.id.gv_custom_keyboard);
        CustomKeyboardAdapter adapter = new CustomKeyboardAdapter(context);
        keyBoard.setAdapter(adapter);
        adapter.setOnKeyboardClickListener(keyboardClickListener);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//设置PopupWindow的视图内容
        // 设置PopupWindow的背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//            popupWindow.showAsDropDown(mTvPlateCodeAbbreviation);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        return popupWindow;
    }
}
