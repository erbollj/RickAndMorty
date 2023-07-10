package com.geektech.rickandmorty.data.utils

import com.geektech.rickandmorty.data.model.CharacterLocationDto
import com.geektech.rickandmorty.data.model.CharacterResultDto
import com.geektech.rickandmorty.data.model.EpisodeResultDto
import com.geektech.rickandmorty.data.model.LocationResultDto
import com.geektech.rickandmorty.data.model.OriginDto
import com.geektech.rickandmorty.domain.model.CharacterLocationDomain
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import com.geektech.rickandmorty.domain.model.OriginDomain

fun List<CharacterResultDto>.resultListToResultDomainList(): List<CharacterResultDomain> {
    return map {
        CharacterResultDomain(
            it.created,
            it.episode,
            it.gender,
            it.id,
            it.image,
            it.location.characterLocationToCharacterLocationDomain(),
            it.name,
            it.origin.originToOriginDomain(),
            it.species,
            it.status,
            it.type,
            it.url
        )
    }
}

fun OriginDto.originToOriginDomain(): OriginDomain {
    return OriginDomain(this.name, this.url)
}

fun CharacterLocationDto.characterLocationToCharacterLocationDomain(): CharacterLocationDomain {
    return CharacterLocationDomain(this.name, this.url)
}

fun List<LocationResultDto>.locationResultToLocationResultDomain(): List<LocationResultDomain> {
    return map {
        LocationResultDomain(
            it.created,
            it.dimension,
            it.id,
            it.name,
            it.residents,
            it.type,
            it.url
        )
    }
}

fun List<EpisodeResultDto>.episodeResultToEpisodeResultDomain(): List<EpisodeResultDomain> {
    return map {
        EpisodeResultDomain(
            it.episode,
            it.characters,
            it.created,
            it.url,
            it.id,
            it.name,
            it.airDate
        )
    }
}

