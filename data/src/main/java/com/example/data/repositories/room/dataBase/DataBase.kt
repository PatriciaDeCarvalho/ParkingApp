package com.example.data.repositories.room.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.repositories.room.dao.LotDao
import com.example.data.repositories.room.dao.ReservationDao
import com.example.data.repositories.room.entities.LotRoom
import com.example.data.repositories.room.entities.ReservationRoom


@Database(
    entities = [LotRoom::class, ReservationRoom::class], version = 1)
abstract class DataBase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "parking_database"
        private lateinit var instance: DataBase

        @Synchronized
        fun getInstance(context: Context): DataBase {
            if (!this::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

    }

    abstract fun getLotsDao(): LotDao
    abstract fun getReservationDao(): ReservationDao

}


