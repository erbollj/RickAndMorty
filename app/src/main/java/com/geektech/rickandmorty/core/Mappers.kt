package com.geektech.rickandmorty.core

import com.geektech.rickandmorty.data.model.*
import com.geektech.rickandmorty.domain.model.*

fun CharacterDomain.characterDomainToCharacter(): Character {
    return Character(
        results = this.resultsDomain.resultListDomainToResultList(),
        info = this.infoDomain.infoDomainToInfo()
    )
}

fun Character.characterToCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        resultsDomain = this.results.resultListToResultDomainList(),
        infoDomain = this.info.infoToInfoDomain()
    )
}

fun InfoDomain.infoDomainToInfo(): Info {
    return Info(count = this.count, next = this.next, pages = this.pages, prev = this.prev)
}

fun Info.infoToInfoDomain(): InfoDomain {
    return InfoDomain(count = this.count, next = this.next, pages = this.pages, prev = this.prev)
}

fun List<CharacterResultDomain>.resultListDomainToResultList(): List<CharacterResult> {
    return map {
        CharacterResult(
            it.created,
            it.episode,
            it.gender,
            it.id,
            it.image,
            it.locationDomain.characterLocationDomainToCharacterLocation(),
            it.name,
            it.originDomain.originDomainToOrigin(),
            it.species,
            it.status,
            it.type,
            it.url
        )
    }
}

fun List<CharacterResult>.resultListToResultDomainList(): List<CharacterResultDomain> {
    return map {
        CharacterResultDomain(
            it.created, it.episode, it.gender, it.id, it.image,
            it.location.characterLocationToCharacterLocationDomain(), it.name, it.origin.originToOriginDomain(),
            it.species, it.status, it.type, it.url
        )
    }
}

fun CharacterResult.resultToResultDomain(): CharacterResultDomain {
    return CharacterResultDomain(this.created, this.episode, this.gender, this.id, this.image,
        this.location.characterLocationToCharacterLocationDomain(), this.name, this.origin.originToOriginDomain(),
        this.species, this.status, this.type, this.url)
}

fun CharacterResultDomain.resultDomainToResult(): CharacterResult {
    return CharacterResult(this.created, this.episode, this.gender, this.id, this.image,
        this.locationDomain.characterLocationDomainToCharacterLocation(), this.name, this.originDomain.originDomainToOrigin(),
        this.species, this.status, this.type, this.url)
}

fun OriginDomain.originDomainToOrigin(): Origin {
    return Origin(this.name, this.url)
}

fun Origin.originToOriginDomain(): OriginDomain {
    return OriginDomain(this.name, this.url)
}

fun CharacterLocationDomain.characterLocationDomainToCharacterLocation(): CharacterLocation {
    return CharacterLocation(this.name, this.url)
}

fun CharacterLocation.characterLocationToCharacterLocationDomain(): CharacterLocationDomain {
    return CharacterLocationDomain(this.name, this.url)
}

fun Location.locationToLocationDomain(): LocationDomain {
    return LocationDomain(this.info.infoToInfoDomain(), this.results.locationResultToLocationResultDomain())
}

fun LocationDomain.locationDomainToLocation(): Location {
    return Location(this.info.infoDomainToInfo(), this.results.locationResultDomainToLocationResultDomain())
}

fun List<LocationResult>.locationResultToLocationResultDomain(): List<LocationResultDomain> {
    return map {
        LocationResultDomain(it.created, it.dimension, it.id, it.name, it.residents, it.type,it.url)
    }
}

fun List<LocationResultDomain>.locationResultDomainToLocationResultDomain(): List<LocationResult> {
    return map {
        LocationResult(it.created, it.dimension, it.id, it.name, it.residents, it.type,it.url)
    }
}

fun Episode.episodeToEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(this.info.infoToInfoDomain(), this.results.episodeResultToEpisodeResultDomain())
}

fun EpisodeDomain.episodeDomainToEpisode(): Episode {
    return Episode(this.info.infoDomainToInfo(), this.results.episodeResultDomainToEpisodeResult())
}

fun List<EpisodeResult>.episodeResultToEpisodeResultDomain(): List<EpisodeResultDomain> {
    return map {
        EpisodeResultDomain(it.episode, it.characters, it.created, it.url, it.id, it.name, it.air_date)
    }
}

fun List<EpisodeResultDomain>.episodeResultDomainToEpisodeResult(): List<EpisodeResult> {
    return map {
        EpisodeResult(it.air_date, it.characters,it.created,it.episode,it.id,it.name,it.url)
    }
}
