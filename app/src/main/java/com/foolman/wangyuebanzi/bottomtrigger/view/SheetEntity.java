package com.foolman.wangyuebanzi.bottomtrigger.view;

/**
 * Created by wangyuebanzi on 2018/9/21.
 */
public class SheetEntity {

    private String mKeyPointNum;
    private String mReplyEditHint;
    private String mCommentNum;

    private SheetEntity(String keyPointNum, String replyEditHint, String commentNum) {
        this.mKeyPointNum = keyPointNum;
        this.mReplyEditHint = replyEditHint;
        this.mCommentNum = commentNum;
    }

    public String getKeyPointNum() {
        return mKeyPointNum;
    }

    public String getReplyEditHint() {
        return mReplyEditHint;
    }

    public String getCommentNum() {
        return mCommentNum;
    }

    public static class Builder {
        private String mKeyPointNum;
        private String mReplyEditHint;
        private String mCommentNum;

        public Builder keyPointNum(String keyPointNum) {
            this.mKeyPointNum = keyPointNum;
            return this;
        }

        public Builder replyEditHint(String replyEditHint) {
            this.mReplyEditHint = replyEditHint;
            return this;
        }

        public Builder commentNum(String commentNum) {
            this.mCommentNum = commentNum;
            return this;
        }

        public SheetEntity build() {
            return new SheetEntity(mKeyPointNum, mReplyEditHint, mCommentNum);
        }
    }
}
