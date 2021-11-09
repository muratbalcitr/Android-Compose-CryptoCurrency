package com.m2lifeapps.cryptocurrenywithcompose.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinDetailResponse(
    var description: String,
    var development_status: String,
    var first_data_at: String,
    var hardware_wallet: Boolean,
    var hash_algorithm: String,
    var id: String,
    @SerializedName("is_active")
    var isActive: Boolean,
    @SerializedName("is_new")
    var isNew: Boolean,
    var last_data_at: String,
    var links: Links,
    @SerializedName("links_extended")
    var linksExtended: List<LinksExtended>,
    var message: String,
    var name: String,
    var open_source: Boolean,
    var org_structure: String,
    var proof_type: String,
    var rank: Int,
    var started_at: String,
    var symbol: String,
    var tags: List<Tag>,
    var team: List<Team>,
    var type: String,
    var whitepaper: Whitepaper
) {
    data class Links(
        var explorer: List<String>,
        var facebook: List<String>,
        var reddit: List<String>,
        var source_code: List<String>,
        var website: List<String>,
        var youtube: List<String>
    )

    data class LinksExtended(
        var stats: Stats,
        var type: String,
        var url: String
    ) {
        data class Stats(
            var contributors: Int,
            var followers: Int,
            var stars: Int,
            var subscribers: Int
        )
    }

    data class Tag(
        var coin_counter: Int,
        var ico_counter: Int,
        var id: String,
        var name: String
    )

    data class Team(
        var id: String,
        var name: String,
        var position: String
    )

    data class Whitepaper(
        var link: String,
        var thumbnail: String
    )
}