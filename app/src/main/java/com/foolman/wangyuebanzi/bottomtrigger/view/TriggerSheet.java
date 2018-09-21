package com.foolman.wangyuebanzi.bottomtrigger.view;

/**
 * Created by wangyuebanzi on 2018/9/20.
 */
public class TriggerSheet {
    private static final int FLAG_KEY_POINT_TRIGGER = 1;
    private static final int FLAG_REPLY_EDIT_TRIGGER = 1 << 1;
    private static final int FLAG_REPLY_EMOTION_TRIGGER = 1 << 2;
    private static final int FLAG_REVIEW_ARTICLE_TRIGGER = 1 << 3;
    private static final int FLAG_COMMENT_TRIGGER = 1 << 4;
    private static final int FLAG_COLLECT_TRIGGER = 1 << 5;
    private static final int FLAG_SHARE_TRIGGER = 1 << 6;
    private static final int FLAG_MORE_TRIGGER = 1 << 7;
    private int mFlagTrigger = 0;

    private TriggerSheet(int flagTrigger) {
        this.mFlagTrigger = flagTrigger;
    }

    public boolean keyPointEnable() {
        return (mFlagTrigger & FLAG_KEY_POINT_TRIGGER) != 0;
    }

    public boolean replyEditEnable() {
        return (mFlagTrigger & FLAG_REPLY_EDIT_TRIGGER) != 0;
    }

    public boolean replyEmotionEnable() {
        return (mFlagTrigger & FLAG_REPLY_EMOTION_TRIGGER) != 0;
    }

    public boolean reviewArticleEnable() {
        return (mFlagTrigger & FLAG_REVIEW_ARTICLE_TRIGGER) != 0;
    }

    public boolean commentEnable() {
        return (mFlagTrigger & FLAG_COMMENT_TRIGGER) != 0;
    }

    public boolean collectEnable() {
        return (mFlagTrigger & FLAG_COLLECT_TRIGGER) != 0;
    }

    public boolean shareEnable() {
        return (mFlagTrigger & FLAG_SHARE_TRIGGER) != 0;
    }

    public boolean moreEnable() {
        return (mFlagTrigger & FLAG_MORE_TRIGGER) != 0;
    }

    public int getSheets() {
        return this.mFlagTrigger;
    }

    public static class Builder {
        private int mFlagTrigger = 0;

        public Builder keyPoint() {
            this.mFlagTrigger |= FLAG_KEY_POINT_TRIGGER;
            return this;
        }

        public Builder replyEdit() {
            this.mFlagTrigger |= FLAG_REPLY_EDIT_TRIGGER;
            return this;
        }

        public Builder replyEmotion() {
            this.mFlagTrigger |= FLAG_REPLY_EMOTION_TRIGGER;
            return this;
        }

        public Builder reviewArticle() {
            this.mFlagTrigger |= FLAG_REVIEW_ARTICLE_TRIGGER;
            return this;
        }

        public Builder comment() {
            this.mFlagTrigger |= FLAG_COMMENT_TRIGGER;
            return this;
        }

        public Builder collect() {
            this.mFlagTrigger |= FLAG_COLLECT_TRIGGER;
            return this;
        }

        public Builder share() {
            this.mFlagTrigger |= FLAG_SHARE_TRIGGER;
            return this;
        }

        public Builder more() {
            this.mFlagTrigger |= FLAG_MORE_TRIGGER;
            return this;
        }

        public TriggerSheet build() {
            return new TriggerSheet(this.mFlagTrigger);
        }

        public TriggerSheet build(int flagTrigger) {
            this.mFlagTrigger = flagTrigger;
            return build();
        }


    }
}
