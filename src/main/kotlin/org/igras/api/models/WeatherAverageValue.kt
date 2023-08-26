package org.igras.api.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import org.igras.api.common.enums.IgrasDecimalFields
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Getter
class WeatherAverageValue() {

    @JsonProperty("Values")
    private val values = mutableMapOf<IgrasDecimalFields, MutableList<BigDecimal>>()

    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")

    private var timeStart : LocalTime = LocalTime.NOON
    private var timeFinish: LocalTime = LocalTime.NOON
    private var dateStart : LocalDate = LocalDate.MIN
    private var dateFinish: LocalDate = LocalDate.MIN

    constructor(field: IgrasDecimalFields, date: LocalDate, time: LocalTime, value: BigDecimal) : this() {
        timeStart = time
        dateStart = date
        add(field, date, value)
    }

    @JsonProperty("period")
    fun period() = "[${dateStart.format(dateFormatter)} - ${dateFinish.format(dateFormatter)}] " +
            ": ${timeStart.format(timeFormatter)} - ${timeFinish.format(timeFormatter)}"

    @JsonIgnore
    fun lastDate() = dateFinish

    @JsonIgnore
    fun isEmpty() = dateFinish == LocalDate.MIN

    fun add(field: IgrasDecimalFields, date: LocalDate, value: BigDecimal) {
        dateFinish = date
        if (!values.contains(field))
            values[field] = ArrayList()
        values[field]?.add(value)
    }
}













































