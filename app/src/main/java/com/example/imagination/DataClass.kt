package com.example.imagination

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

data class Ratings(
    val Source: String,
    val Value: String
)


data class Result(
    val Ratings: List<Ratings>?,
    val Title: String?,
    val Released: String?,
    var Genre: String?,
    val Director: String?,
    val Writer: String?,
    val Actors: String?,
    var Plot: String?,
    val Language: String?,
    val Country: String?,
    val Awards: String?,
    val Poster: String?,
    val Production: String?,
    val Type: String?,
    val Runtime: String?

)

data class Detected(
    val lang: String?
)

data class Translation(
    val code: Int?,
    val lang: String?,
    val detected: Detected,
    val text: List<String>
)
