package com.cristianbindea.androidfundamentals2021finalproject.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cristianbindea.androidfundamentals2021finalproject.room.dao.TaskDoneDao;
import com.cristianbindea.androidfundamentals2021finalproject.room.dao.TaskToDoDao;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskDone;
import com.cristianbindea.androidfundamentals2021finalproject.room.entity.TaskToDo;

@Database(entities = {TaskDone.class, TaskToDo.class}, version = 3, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "task-db";
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static TaskDatabase INSTANCE;

    static TaskDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract TaskDoneDao taskDoneDao();

    public abstract TaskToDoDao taskToDoDao();
}
