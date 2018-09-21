package com.foolman.wangyuebanzi.bottomtrigger.view;

/**
 * Created by wangyuebanzi on 2018/9/20.
 */
public class DefaultTriggerSheet {
    private static final int ARTICLE_TRIGGER_SHEET = 0b11111110;
    private static final int LIVE_TRIGGER_SHEET = 0b1111111;

    public static TriggerSheet article() {
        return new TriggerSheet.Builder().build(ARTICLE_TRIGGER_SHEET);
    }

    public static TriggerSheet live() {
        return new TriggerSheet.Builder().build(LIVE_TRIGGER_SHEET);
    }

    public static TriggerSheet all() {
        return new TriggerSheet.Builder().keyPoint().replyEdit()
                .replyEmotion().reviewArticle().comment()
                .collect().share().more().build();
    }

}
