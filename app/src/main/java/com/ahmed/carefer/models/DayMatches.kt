package com.ahmed.carefer.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "competition")
data class DayMatches(
    @PrimaryKey val day: Int,
    var matches: List<Matche>,
    var isFavorite: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return Random.nextInt()
    }
}
