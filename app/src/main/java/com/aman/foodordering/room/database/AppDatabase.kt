package com.aman.foodordering.room.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.aman.foodordering.room.dao.FoodDao
import com.aman.foodordering.room.entity.Food
import com.aman.foodordering.worker.DataInitializer

@Database(entities = [Food::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        private const val TAG = "AppDatabase"
        private const val DATABASE_NAME = "food_application.db"

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    Log.d(TAG, " >>> Creating new database instance")
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d(TAG, " >>> DB has been created")
                            val request = OneTimeWorkRequestBuilder<DataInitializer>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }).build()
                }
            }
            Log.d(TAG, " >>> Getting the database instance")
            return INSTANCE
        }
    }
}