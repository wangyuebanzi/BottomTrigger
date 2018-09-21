package com.foolman.wangyuebanzi.bottomtrigger.view;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.foolman.wangyuebanzi.bottomtrigger.R;

/**
 * Created by wangyuebanzi on 2018/9/20.
 */
public class TriggerSheetView extends FrameLayout implements View.OnClickListener {

    public static final String PARAM_KEY_POINT_NUM = "param_key_point_num";
    public static final String PARAM_REPLY_EDIT_HINT_TEXT = "param_reply_edit_hint_num";
    public static final String PARAM_COMMENT_NUM = "param_comment_num";


    private ImageView mKeyPointView;
    private ViewGroup mReplyLayout;
    private TextView mReplyEditView;
    private ImageView mReplyEmotionView;
    private ImageView mReplyEmotionDotView;
    private TextView mReviewArticleView;
    private ViewGroup mReplyCommentLayout;
    private TextView mReplyCommentNumView;

    private ImageView mCollectView;
    private ImageView mShareView;
    private ImageView mMoreView;

    private SparseArray<View> mViews = new SparseArray<>();

    private ActionCallback mActionCallback;

    public TriggerSheetView(@NonNull Context context) {
        this(context, null);
    }

    public TriggerSheetView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriggerSheetView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.bottom_trigger_sheet_layout, this);
        initView();

    }

    private void initView() {
        mKeyPointView = (ImageView) getView(R.id.key_point_trigger);
        mKeyPointView.setOnClickListener(this);
        mReplyLayout = (ViewGroup) getView(R.id.reply_edit_trigger_layout);
        mReplyLayout.setOnClickListener(this);
        mReplyEditView = (TextView) getView(R.id.reply_edit_trigger);
        mReplyEditView.setOnClickListener(this);
        mReplyEmotionView = (ImageView) getView(R.id.reply_emotion_trigger);
        mReplyEmotionView.setOnClickListener(this);
        mReplyEmotionDotView = (ImageView) getView(R.id.reply_emotion_red_dot);
        mReplyEmotionDotView.setOnClickListener(this);
        mReviewArticleView = (TextView) getView(R.id.review_article_trigger);
        mReviewArticleView.setOnClickListener(this);
        mReplyCommentLayout = (ViewGroup) getView(R.id.reply_comment_layout);
        mReplyCommentLayout.setOnClickListener(this);
        mCollectView = (ImageView) getView(R.id.collect_trigger);
        mCollectView.setOnClickListener(this);
        mShareView = (ImageView) getView(R.id.share_trigger);
        mShareView.setOnClickListener(this);
        mMoreView = (ImageView) getView(R.id.more_trigger);
        mMoreView.setOnClickListener(this);

        mReplyCommentNumView = (TextView) getView(R.id.reply_comment_number);
    }

    public View getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = findViewById(viewId);
            if (view == null) {
                throw new RuntimeException("TriggerSheetView do not declare this id !!!");
            }
            if (view != null) {
                mViews.put(viewId, view);
            }
        }
        return view;
    }

    public void loadTriggerSheet(TriggerSheet triggerSheet) {
        enableTrigger(mKeyPointView, triggerSheet.keyPointEnable());
        enableTrigger(mReplyLayout, triggerSheet.replyEditEnable());
        enableTrigger(mReplyEditView, triggerSheet.replyEditEnable());
        enableTrigger(mReplyEmotionView, triggerSheet.replyEmotionEnable());
        enableTrigger(mReviewArticleView, triggerSheet.reviewArticleEnable());
        enableTrigger(mReplyCommentLayout, triggerSheet.commentEnable());
        enableTrigger(mCollectView, triggerSheet.collectEnable());
        enableTrigger(mShareView, triggerSheet.shareEnable());
        enableTrigger(mMoreView, triggerSheet.moreEnable());
    }

    public void loadSheetData(SheetEntity sheetEntity) {
        mReplyEditView.setText(sheetEntity.getReplyEditHint());
        mReplyCommentNumView.setText(sheetEntity.getCommentNum());
    }


    private void enableTrigger(View view, boolean enable) {
        if (view == null) {
            return;
        }
        view.setVisibility(enable ? View.VISIBLE : View.GONE);
    }

    public void setActionCallback(ActionCallback actionCallback) {
        this.mActionCallback = actionCallback;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.key_point_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickKeyPoint();
                }
                break;

            case R.id.reply_edit_trigger_layout:
                if (mActionCallback != null) {
                    mActionCallback.clickReplyLayout();
                }
                break;

            case R.id.reply_edit_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickReplyEdit();
                }
                break;

            case R.id.reply_emotion_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickReplyEmotion();
                }
                break;

            case R.id.review_article_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickReviewArticle();
                }
                break;

            case R.id.reply_comment_layout:
                if (mActionCallback != null) {
                    mActionCallback.clickCommentLayout();
                }
                break;

            case R.id.collect_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickCollect();
                }
                break;

            case R.id.share_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickShare();
                }
                break;

            case R.id.more_trigger:
                if (mActionCallback != null) {
                    mActionCallback.clickMore();
                }
                break;

        }
    }

    public interface ActionCallback {
        void clickKeyPoint();

        void clickReplyLayout();

        void clickReplyEdit();

        void clickReplyEmotion();

        void clickReviewArticle();

        void clickCommentLayout();

        void clickCollect();

        void clickShare();

        void clickMore();
    }


}
