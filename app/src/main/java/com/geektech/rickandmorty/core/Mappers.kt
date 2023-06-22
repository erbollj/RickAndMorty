package com.geektech.rickandmorty.core

import com.geektech.rickandmorty.data.model.*
import com.geektech.rickandmorty.domain.model.*

fun List<CharacterResult>.resultListToResultDomainList(): List<CharacterResultDomain> {
    return map {
        CharacterResultDomain(
            it.created, it.episode, it.gender, it.id, it.image,
            it.location.characterLocationToCharacterLocationDomain(), it.name, it.origin.originToOriginDomain(),
            it.species, it.status, it.type, it.url
        )
    }
}

fun Origin.originToOriginDomain(): OriginDomain {
    return OriginDomain(this.name, this.url)
}

fun CharacterLocation.characterLocationToCharacterLocationDomain(): CharacterLocationDomain {
    return CharacterLocationDomain(this.name, this.url)
}

fun List<LocationResult>.locationResultToLocationResultDomain(): List<LocationResultDomain> {
    return map {
        LocationResultDomain(it.created, it.dimension, it.id, it.name, it.residents, it.type,it.url)
    }
}

fun List<EpisodeResult>.episodeResultToEpisodeResultDomain(): List<EpisodeResultDomain> {
    return map {
        EpisodeResultDomain(it.episode, it.characters, it.created, it.url, it.id, it.name, it.air_date)
    }
}

