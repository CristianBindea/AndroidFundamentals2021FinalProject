package com.cristianbindea.androidfundamentals2021finalproject.ui.alltasksdone;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TaskDoneRVTouchListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private TaskDoneClickListener taskDoneClickListener;

    public TaskDoneRVTouchListener(Context context, final RecyclerView recyclerView, final TaskDoneClickListener taskDoneClickListener) {
        this.taskDoneClickListener = taskDoneClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && taskDoneClickListener != null)
                    taskDoneClickListener.onItemClick(child, recyclerView.getChildAdapterPosition(child));
                return super.onSingleTapUp(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && taskDoneClickListener != null)
                    taskDoneClickListener.onItemLongClick(child, recyclerView.getChildAdapterPosition(child));
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && taskDoneClickListener != null && gestureDetector.onTouchEvent(e)) {
            taskDoneClickListener.onItemClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }


    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}