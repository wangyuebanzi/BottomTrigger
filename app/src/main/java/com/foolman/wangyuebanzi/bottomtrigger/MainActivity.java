package com.foolman.wangyuebanzi.bottomtrigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.foolman.wangyuebanzi.bottomtrigger.fragment.ReplyDialogFragment;
import com.foolman.wangyuebanzi.bottomtrigger.view.DefaultTriggerSheet;
import com.foolman.wangyuebanzi.bottomtrigger.view.SheetEntity;
import com.foolman.wangyuebanzi.bottomtrigger.view.SimpleTriggerActionCallback;
import com.foolman.wangyuebanzi.bottomtrigger.view.TriggerSheetView;

public class MainActivity extends AppCompatActivity {
    private TriggerSheetView bottomTriggerSheetView;
    private TriggerSheetView topTriggerSheetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTriggerSheetView();
    }

    private void setupTriggerSheetView() {
        //bottom
        bottomTriggerSheetView = findViewById(R.id.bottom_trigger_sheet);
        bottomTriggerSheetView.loadTriggerSheet(DefaultTriggerSheet.all());
        bottomTriggerSheetView.setActionCallback(new SheetViewCallback());
        SheetEntity sheetEntity = new SheetEntity.Builder().keyPointNum("5")
                .replyEditHint("我就是想玩玩").commentNum("1.2万").build();
        bottomTriggerSheetView.loadSheetData(sheetEntity);

        //top
        topTriggerSheetView = findViewById(R.id.top_trigger_sheet);
        topTriggerSheetView.loadTriggerSheet(DefaultTriggerSheet.article());
        topTriggerSheetView.setActionCallback(new SheetViewCallback());
        topTriggerSheetView.loadSheetData(sheetEntity);

    }

    private void showReply() {
        ReplyDialogFragment replyDialog = new ReplyDialogFragment();
        replyDialog.show(getSupportFragmentManager(), "ssss");
    }

    private void showMore() {
    }

    private void doCollect() {
    }

    class SheetViewCallback extends SimpleTriggerActionCallback {
        @Override
        public void clickMore() {
            showMore();
        }

        @Override
        public void clickCollect() {
            doCollect();
        }

        @Override
        public void clickReplyEdit() {
            showReply();
        }
    }


}
