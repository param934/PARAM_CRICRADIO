package com.example.cricradio.Api

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DataClass(
    @SerialName("statusCode") val statusCode: Int,
    @SerialName("responseData") val responseData: ResponseData?
)

@Serializable
data class ResponseData(
    @SerialName("message") val message: String,
    @SerialName("result") val result: MatchResult?
)

@Serializable
data class MatchResult(
    @SerialName("powerplay") val powerplay: String?,
    @SerialName("powerplayOver") val powerplayOver: Int,
    @SerialName("key") val key: String,
    @SerialName("status") val status: String,
    @SerialName("format") val format: String,
    @SerialName("announcement1") val announcement1: String?,
    @SerialName("announcement2") val announcement2: String?,
    @SerialName("teams") val teams: Teams,
    @SerialName("now") val now: MatchNow?,
    @SerialName("currentBattingOrder") val currentBattingOrder: Int,
    @SerialName("settingObj") val settingObj: SettingObj?,
    @SerialName("lastCommentary") val lastCommentary: Commentary?
)

@Serializable
data class Teams(
    @SerialName("a") val teamA: Team,
    @SerialName("b") val teamB: Team
)

@Serializable
data class Team(
    @SerialName("name") val name: String,
    @SerialName("shortName") val shortName: String,
    @SerialName("logo") val logo: String,
    @SerialName("a_1_score") val firstInningScoreA: Score? = null, // Nullable in case missing
    @SerialName("a_2_score") val secondInningScoreA: Score? = null,
    @SerialName("b_1_score") val firstInningScoreB: Score? = null,
    @SerialName("b_2_score") val secondInningScoreB: Score? = null
)

@Serializable
data class Score(
    @SerialName("runs") val runs: Int,
    @SerialName("overs") val overs: String,
    @SerialName("wickets") val wickets: Int,
    @SerialName("declare") val declare: Boolean
)

@Serializable
data class MatchNow(
    @SerialName("run_rate") val runRate: String?,
    @SerialName("req_run_rate") val requiredRunRate: String?,
    @SerialName("sessionLeft") val sessionLeft: String?
)

@Serializable
data class SettingObj(
    @SerialName("currentTeam") val currentTeam: String,
    @SerialName("currentInning") val currentInning: Int
)

@Serializable
data class Commentary(
    @SerialName("primaryText") val primaryText: String?,
    @SerialName("secondaryText") val secondaryText: String?,
    @SerialName("tertiaryText") val tertiaryText: String?,
    @SerialName("isDone") val isDone: Boolean
)
