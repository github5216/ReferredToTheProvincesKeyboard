package com.custom.referredtotheprovinceskeyboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.custom.referredtotheprovinceskeyboard.R;

/**
 * - @Description:
 * - @Author:  chenjianming
 * - @Time:  2018/3/26 15:36
 */
public class CustomKeyboardAdapter extends BaseAdapter {
    private Context mContext;

    public OnKeyboardClickListener onKeyboardClickListener;

    public void setOnKeyboardClickListener(OnKeyboardClickListener onKeyboardClickListener) {
        this.onKeyboardClickListener = onKeyboardClickListener;
    }

    public interface OnKeyboardClickListener {
        void OnKeyboardClick(int position);
    }


    public CustomKeyboardAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mContext.getResources().getStringArray(R.array.province_abbreviation).length;
    }

    @Override
    public String getItem(int position) {
        return mContext.getResources().getStringArray(R.array.province_abbreviation)[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        KeyboardViewHolder viewHolder;

        if (convertView == null) {

            // 获得容器
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_keyboard, null);
            viewHolder = new KeyboardViewHolder(convertView);

            // 初始化组件

            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (CustomKeyboardAdapter.KeyboardViewHolder) convertView.getTag();
        }
        viewHolder.mTvKeyboard.setText(getItem(position));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKeyboardClickListener.OnKeyboardClick(position);
            }
        });
        return convertView;
    }

    public class KeyboardViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvKeyboard;

        public KeyboardViewHolder(View view) {
            super(view);
            mTvKeyboard = (TextView) view.findViewById(R.id.tv_keyboard);

        }
    }
}
