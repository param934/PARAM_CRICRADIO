package com.example.cricradio.api

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class VenueResponse(
    @SerialName("statusCode") val statusCode: Int? = null,
    @SerialName("responseData") val responseData: VenueData? = null
)

@Serializable
data class VenueData(
    @SerialName("message") val message: String? = null,
    @SerialName("result") val venueResult: VenueResult? = null
)

@Serializable
data class VenueResult(
    @SerialName("_id") val id: String? = null,
    @SerialName("firstUmpire") val firstUmpire: String? = null,
    @SerialName("format") val format: String? = null,
    @SerialName("key") val key: String? = null,
    @SerialName("matchReferee") val matchReferee: String? = null,
    @SerialName("related_name") val relatedName: String? = null,
    @SerialName("season") val season: Season? = null,
    @SerialName("secoundUmpire") val secondUmpire: String? = null,
    @SerialName("start_date") val startDate: StartDate? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("teams") val teams: Teams? = null,
    @SerialName("thirdUmpire") val thirdUmpire: String? = null,
    @SerialName("toss") val toss: Toss? = null,
    @SerialName("venue") val venue: String? = null,
    @SerialName("venueDetails") val venueDetails: VenueDetails? = null,
    @SerialName("venueStats") val venueStats: VenueStats? = null,
    @SerialName("weather") val weather: Weather? = null
)


@Serializable
data class VenueDetails(
    @SerialName("_id") val id: String? = null,
    @SerialName("venueScraptitle") val venueScraptitle: String? = null,
    @SerialName("capacity") val capacity: Int? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("photo") val photo: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("smallName") val smallName: String? = null,
    @SerialName("longName") val longName: String? = null,
    @SerialName("venueLocation") val venueLocation: String? = null
)
@Serializable
data class Weather(
    @SerialName("location") val location: String? = null,
    @SerialName("condition") val condition: WeatherCondition? = null,
    @SerialName("chance_of_rain") val chanceOfRain: Int? = null,
    @SerialName("temp_c") val temperature: Double? = null,
    @SerialName("last_updated") val lastUpdated: String? = null
)
@Serializable
data class WeatherCondition(
    @SerialName("code") val code: Int? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("text") val text: String? = null
)


@Serializable
data class VenueStats(
    @SerialName("matchesPlayed") val matchesPlayed: Int? = null,
    @SerialName("lowestDefended") val lowestDefended: Int? = null,
    @SerialName("highestChased") val highestChased: Int? = null,
    @SerialName("batFirstWins") val batFirstWins: Int? = null,
    @SerialName("ballFirstWins") val ballFirstWins: Int? = null,
    @SerialName("battingFirst") val battingFirst: BattingStats? = null,
    @SerialName("battingSecond") val battingSecond: BattingStats? = null
)

@Serializable
data class MatchResponse(
    @SerialName("statusCode") val statusCode: Int?,
    @SerialName("responseData") val responseData: MatchData?
)

@Serializable
data class MatchData(
    @SerialName("message") val message: String?,
    @SerialName("result") val result: MatchResult?
)

@Serializable
data class MatchResult(
    @SerialName("_id") val id: String? = null,
    @SerialName("key") val key: String? = null,
    @SerialName("format") val format: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("related_name") val relatedName: String? = null,
    @SerialName("season") val season: Season? = null,
    @SerialName("start_date") val startDate: StartDate? = null,
    @SerialName("firstUmpire") val firstUmpire: String? = null,
    @SerialName("secoundUmpire") val secondUmpire: String? = null,
    @SerialName("thirdUmpire") val thirdUmpire: String? = null,
    @SerialName("matchReferee") val matchReferee: String? = null,
    @SerialName("toss") val toss: Toss? = null,
    @SerialName("announcement1") val announcement1: String? = null,
    @SerialName("announcement2") val announcement2: String? = null,
    @SerialName("teams") val teams: Teams? = null,
    @SerialName("now") val now: MatchNow? = null,
    @SerialName("currentBattingOrder") val currentBattingOrder: Int? = null,
    @SerialName("settingObj") val settingObj: SettingObj? = null,
    @SerialName("lastCommentary") val lastCommentary: Commentary? = null,
    @SerialName("venue") val venue: String? = null,
    @SerialName("venueDetails") val venueDetails: VenueDetails? = null,
    @SerialName("venueStats") val venueStats: VenueStats? = null,
    @SerialName("weather") val weather: Weather? = null
)

@Serializable
data class Season(
    @SerialName("key") val key: String? = null,
    @SerialName("name") val name: String? = null
)

@Serializable
data class StartDate(
    @SerialName("timestamp") val timestamp: Long? = null,
    @SerialName("iso") val iso: String? = null,
    @SerialName("str") val formattedDate: String? = null,
    @SerialName("sky_check_ts") val skyCheckTs: Long? = null
)

@Serializable
data class Toss(
    @SerialName("won") val won: String? = null,
    @SerialName("decision") val decision: String? = null,
    @SerialName("str") val tossStr: String? = null
)

@Serializable
data class Teams(
    @SerialName("a") val teamA: Team? = null,
    @SerialName("b") val teamB: Team? = null
)

@Serializable
data class Score(
    @SerialName("runs") val runs: Int? = null,
    @SerialName("overs") val overs: String? = null,
    @SerialName("wickets") val wickets: Int? = null,
    @SerialName("declare") val declare: Boolean? = null
)

@Serializable
data class Team(
    @SerialName("name") val name: String? = null,
    @SerialName("shortName") val shortName: String? = null,
    @SerialName("logo") val logo: String? = null,
    @SerialName("a_1_score") val firstInningScoreA: Score? = null,
    @SerialName("a_2_score") val secondInningScoreA: Score? = null,
    @SerialName("b_1_score") val firstInningScoreB: Score? = null,
    @SerialName("b_2_score") val secondInningScoreB: Score? = null
)


@Serializable
data class MatchNow(
    @SerialName("run_rate") val runRate: String? = null,
    @SerialName("req_run_rate") val requiredRunRate: String? = null,
    @SerialName("sessionLeft") val sessionLeft: String? = null
)

@Serializable
data class SettingObj(
    @SerialName("currentTeam") val currentTeam: String? = null,
    @SerialName("currentInning") val currentInning: Int? = null
)

@Serializable
data class Commentary(
    @SerialName("primaryText") val primaryText: String? = null,
    @SerialName("secondaryText") val secondaryText: String? = null,
    @SerialName("tertiaryText") val tertiaryText: String? = null,
    @SerialName("isDone") val isDone: Boolean? = null
)


@Serializable
data class BattingStats(
    @SerialName("averageScore") val averageScore: Int? = null,
    @SerialName("highestScore") val highestScore: Int? = null,
    @SerialName("lowestScore") val lowestScore: Int? = null,
    @SerialName("paceWickets") val paceWickets: Int? = null,
    @SerialName("spinWickets") val spinWickets: Int? = null
)

