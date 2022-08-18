package com.example.e_commerceapp.data.dataSource.localDataSource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_commerceapp.data.dataSource.localDataSource.entities.CoffeeCart

@Database(entities = [CoffeeCart::class], version = 3, exportSchema = false)
abstract class CoffeeDatabase : RoomDatabase() {

    abstract val coffeeDao: CoffeeCartDao

    companion object {

        @Volatile
        private var INSTANCE: CoffeeDatabase? = null

        fun getInstance(context: Context): CoffeeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoffeeDatabase::class.java,
                        "coffe_cart_database"
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