package com.kennethmanuel.week8

import java.io.Serializable

data class Event(
    val id: Int,
    val name: String,
    val desc: String,
    val pic: Int,
    val evenDate: String,
    val crewNeeded: Int,
    val crewNumber: Int
) : Serializable {
    override fun toString(): String {
        return name
    }
}
