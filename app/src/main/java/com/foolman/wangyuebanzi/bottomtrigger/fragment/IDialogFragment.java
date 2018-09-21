package com.foolman.wangyuebanzi.bottomtrigger.fragment;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by wangyuebanzi on 2018/9/21.
 */
public class IDialogFragment {

    public interface OnDismissListener {
        void onDismiss();
    }

    public interface OnClickListener {
        boolean onClick(View v);
    }

    public interface OnKeyListener extends DialogInterface.OnKeyListener {
        boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }

    public interface OnBackPressedListener {
        void onBackPressed();
    }

    public interface OnCancelListener {
        // 回调时机：
        // 1. setCanceledOnTouchOutside(true)
        // 2. 按下back键
        void onCancel(DialogInterface dialog);
    }

    public interface OnShowListener extends DialogInterface.OnShowListener {
        void onShow(DialogInterface dialog);
    }

    public interface OnDialogStateChangedListener {
        void onDialogStateChanged(String key, int type, int code, Object value);
    }
}
