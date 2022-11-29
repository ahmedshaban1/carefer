package com.ahmed.carefer.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahmed.carefer.models.DayMatches

@Database(entities = [DayMatches::class], version = 1, exportSchema = false)
@TypeConverters(MatchListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val competitionDao: CompetitionDao
}
