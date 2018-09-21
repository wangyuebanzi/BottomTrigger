package com.foolman.wangyuebanzi.bottomtrigger.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.foolman.wangyuebanzi.bottomtrigger.R;

/**
 * Created by wangyuebanzi on 2018/9/21.
 */
public class BaseDialogFragment extends DialogFragment {

    public static final float DEFAULT_DIM_AMOUNT = 0.5f;
    static final String PARAMS_CANCEL = "params_cancel";
    static final String PARAMS_DIM_AMOUNT = "params_dim_amount";
    private IDialogFragment.OnDismissListener onDialogDismissListener;
    private IDialogFragment.OnBackPressedListener onDialogBackPressedListener;
    private IDialogFragment.OnCancelListener onCancelListener;
    private IDialogFragment.OnShowListener onShowListener;
    private IDialogFragment.OnKeyListener onKeyListener;

    private boolean mFinishActivityWhenDismiss = true;
    private boolean mFinishActivityWhenDismissEnabled = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (!hasShadow()) {
            setStyle(DialogFragment.STYLE_NO_FRAME,
                    android.R.style.Theme_NoTitleBar_Fullscreen);
        }*/

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        Bundle args = getArguments();
        boolean cancel = false;
        if (args != null) {
            cancel = args.getBoolean(PARAMS_CANCEL);
        }
        dialog.setCanceledOnTouchOutside(cancel);
        dialog.setOnShowListener(onShowListener);
        dialog.setOnKeyListener(onKeyListener);

        if (dialog.getWindow() != null) {
            setCustomWindow(dialog.getWindow());
        }
        return dialog;
    }


    protected void setCustomWindow(@NonNull Window window) {
        float dimAmount = DEFAULT_DIM_AMOUNT;
        if (getArguments() != null) {
            dimAmount = getArguments().getFloat(PARAMS_DIM_AMOUNT, DEFAULT_DIM_AMOUNT);
        }
        window.setDimAmount(dimAmount);
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        if (!hasShadow()) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    public void setFinishActivityWhenDismiss(boolean finishActivityWhenDismiss) {
        mFinishActivityWhenDismiss = finishActivityWhenDismiss;
    }

    public void setmFinishActivityWhenDismissEnabled(boolean mFinishActivityWhenDismissEnabled) {
        this.mFinishActivityWhenDismissEnabled = mFinishActivityWhenDismissEnabled;
    }

    public boolean isFinishActivityWhenDismissEnabled() {
        return mFinishActivityWhenDismissEnabled;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDialogDismissListener != null) {
            onDialogDismissListener.onDismiss();
        }
        if (mFinishActivityWhenDismissEnabled && mFinishActivityWhenDismiss && getActivity() != null) {
            getActivity().finish();
        }
    }

    public void setOnDismissListener(IDialogFragment.OnDismissListener dismissListener) {
        onDialogDismissListener = dismissListener;
    }

    public boolean hasShadow() {
        return false;
    }

    public boolean isShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    @Override
    public void dismiss() {
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }


    public void setOnDialogBackPressedListener(IDialogFragment.OnBackPressedListener onDialogBackPressedListener) {
        this.onDialogBackPressedListener = onDialogBackPressedListener;
    }

    public void setOnShowListener(IDialogFragment.OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    public void setOnKeyListener(IDialogFragment.OnKeyListener onKeyListener) {
        this.onKeyListener = onKeyListener;
    }

    public void setOnCancelListener(IDialogFragment.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }


}
