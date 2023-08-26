package org.igras.api.service

import org.igras.api.common.enums.INDEXED_FIELDS
import org.igras.api.models.WeatherAverageIndexedCollection
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.FileReader
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

val emptyValues = arrayOf("---", "------")
const val delimiter = "\t"

@Service
class WeatherCalculationService {
    fun readData(fileName: String) : WeatherAverageIndexedCollection {
        val lines = BufferedReader(FileReader(fileName)).lines().toList()
        val collection = WeatherAverageIndexedCollection()
        val timeFormatter = DateTimeFormatter.ofPattern("H:mm")
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")
        lines.forEach {
            val parsedLine = it.split(delimiter)
            val date = LocalDate.parse(parsedLine[0], dateFormatter)
            val time = LocalTime.parse(parsedLine[1], timeFormatter)
            parsedLine.forEachIndexed {i, value ->
                INDEXED_FIELDS[i]?.let {
                        it1 -> collection.add(it1, date, time, value)
                }
            }
        }
        return collection
    }
}
