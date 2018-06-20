package com.custom.keyboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.custom.keyboard.R;
import com.custom.keyboard.adapter.CustomKeyboardAdapter;
import com.custom.keyboard.custom.ReferredProvincesKeyboard;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomKeyboardAdapter.OnKeyboardClickListener {

    private Button button;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_provinces_keyboard);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        popupWindow = ReferredProvincesKeyboard.build(this, this);
    }

    @Override
    public void OnKeyboardClick(int position) {
        popupWindow.dismiss();
        Log.e("LOG", "position = " + position + getResources().getStringArray(R.array.province_abbreviation)[position]);
        button.setText(getResources().getStringArray(R.array.province_abbreviation)[position]);
        Toast.makeText(this, getResources().getStringArray(R.array.province_abbreviation)[position], Toast.LENGTH_SHORT).show();
    }
}
