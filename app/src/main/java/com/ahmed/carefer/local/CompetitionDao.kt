package com.ahmed.carefer.local

import androidx.room.*
import com.ahmed.carefer.models.DayMatches
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: DayMatches)

    @Query("SELECT * from competition where day=:day")
    suspend fun getDay(day: Int): DayMatches?

    @Update
    suspend fun update(day: DayMatches)

    @Query("select * from  competition")
    fun getAll(): Flow<List<DayMatches>>
}
