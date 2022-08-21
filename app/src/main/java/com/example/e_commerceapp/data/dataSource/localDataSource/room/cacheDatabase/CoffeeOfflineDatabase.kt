package com.example.e_commerceapp.data.dataSource.localDataSource.room.cacheDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_commerceapp.data.dataSource.remoteDataSource.entities.Coffee

@Database(entities = [Coffee::class], version = 7, exportSchema = false)
abstract class CoffeeOfflineDatabase : RoomDatabase() {

    abstract val coffeeDao: CoffeeDao

    companion object {

        @Volatile
        private var INSTANCE: CoffeeOfflineDatabase? = null

        fun getInstance(context: Context): CoffeeOfflineDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoffeeOfflineDatabase::class.java,
                        "coffee_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}