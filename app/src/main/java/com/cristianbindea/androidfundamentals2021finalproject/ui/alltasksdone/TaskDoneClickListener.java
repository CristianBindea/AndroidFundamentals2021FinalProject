package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasksdone;

import android.view.View;

public interface TaskDoneClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}
