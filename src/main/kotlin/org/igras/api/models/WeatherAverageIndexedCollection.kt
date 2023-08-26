package org.igras.api.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.igras.api.common.enums.IgrasDecimalFields
import org.igras.api.service.emptyValues
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class WeatherAverageIndexedCollection {
    private var index = 0

    @JsonProperty("items")
    private val items = LinkedList<WeatherAverageValue>()

    private val ignoredToAdd = setOf<IgrasDecimalFields>(
        IgrasDecimalFields.Date,
        IgrasDecimalFields.Time,
        IgrasDecimalFields.DirectionOfTheWin,
        IgrasDecimalFields.TheLargestDeviationOfTheWindDirection,
    )

    @JsonIgnore
    fun getLast() = items.last()

    fun add(field: IgrasDecimalFields, date: LocalDate, time: LocalTime, weatherValue: String) {
        if (ignoredToAdd.contains(field)) return
        val value = if (!emptyValues.contains(weatherValue)) BigDecimal(weatherValue) else BigDecimal.ZERO
        if (items.lastIndex != index) {
            val averageValue = WeatherAverageValue(field, date, time, value)
            items.add(averageValue)
            return
        }
        val item = items[index]
        if (item.isEmpty()) {
            item.add(field, date, value)
            return
        }
        if (item.lastDate() != date) {
            item.add(field, date, value)
            index ++
            return
        }

        item.add(field, date, value)
    }
}