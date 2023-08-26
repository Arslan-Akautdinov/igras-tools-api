package org.igras.api.common.enums

import org.igras.api.common.enums.IgrasDecimalFields.*

val INDEXED_FIELDS = mutableMapOf<Int, IgrasDecimalFields>(
    0  to Date,
    1  to Time,
    2  to AirTemperatureOutsideInCelsius,
    3  to MaximumAirTemperatureInCelsius,
    4  to MinimumAirTemperatureInCelsius,
    5  to AirHumidityOutsidePercent,
    6  to DewPointInCelsius,
    7  to WindSpeedInKmPerHour,
    8  to DirectionOfTheWin,
    9  to DistanceCoveredByTheWindDuringTheMeasurementTimeKM,
    10 to MaximumWindSpeedInMilePerSec,
    11 to TheLargestDeviationOfTheWindDirection,
    12 to CoolingEffectOfTheWindInCelsius,
    13 to HeatIndexHumidityEffectInCelsiusDecimal,
    14 to IndexDecimalThermalOfTemperatureHumidityAndWindInCelsius,
    15 to IndexDecimalOfTemperatureHumiditySunAndWindInCelsius,
    16 to AtmosphericPressureInHpa,
    17 to TotalPrecipitationInMM,
    18 to IntensityOfPrecipitationMMPerHour,
    19 to SolarRadiationWPerM2,
    20 to IntensityOfSolarEnergyLangley,
    21 to MaximumSolarRadiation,
    22 to UVIndexDecimal,
    23 to DoseOfUVRadiation,
    24 to MaximumUVIndexDecimal,
    25 to DegreeOfHeating,
    26 to DegreeOfCooling,
    27 to TemperatureRoomInCelsius,
    28 to HumidityRoomInCelsius,
    29 to DewPointRoomInCelsius,
    30 to HeatIndexInTheRoomInCelsiusDecimal,
    31 to EquilibriumMoistureContentPercent,
    32 to AirDensityKgImCube,
    33 to TemperatureOfTheSecondThermometerInCelsius,
)