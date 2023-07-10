package com.geektech.rickandmorty.presentation.utils

import androidx.paging.PagingData
import androidx.paging.map
import com.geektech.rickandmorty.domain.model.CharacterLocationDomain
import com.geektech.rickandmorty.domain.model.CharacterResultDomain
import com.geektech.rickandmorty.domain.model.EpisodeResultDomain
import com.geektech.rickandmorty.domain.model.LocationResultDomain
import com.geektech.rickandmorty.domain.model.OriginDomain
import com.geektech.rickandmorty.presentation.models.CharacterLocationUI
import com.geektech.rickandmorty.presentation.models.CharacterResultUI
import com.geektech.rickandmorty.presentation.models.EpisodeResultUI
import com.geektech.rickandmorty.presentation.models.LocationResultUI
import com.geektech.rickandmorty.presentation.models.OriginUI

fun PagingData<CharacterResultDomain>.pagingCharacterResultDomainToPCRUI(): PagingData<CharacterResultUI> {
    return map {
        CharacterResultUI(
            it.created,
            it.episode,
            it.gender,
            it.id,
            it.image,
            it.locationDomain.characterLocationDomainToCharacterLocationUI(),
            it.name,
            it.originDomain.originDomainToOriginUI(),
            it.species,
            it.status,
            it.type,
            it.url
        )
    }
}

fun OriginDomain.originDomainToOriginUI(): OriginUI {
    return OriginUI(this.name, this.url)
}

fun CharacterLocationDomain.characterLocationDomainToCharacterLocationUI(): CharacterLocationUI {
    return CharacterLocationUI(this.name, this.url)
}

fun PagingData<LocationResultDomain>.locationResultTDomainLocationResultUI(): PagingData<LocationResultUI> {
    return map {
        LocationResultUI(
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

fun PagingData<EpisodeResultDomain>.episodeResultDomainToEpisodeResultUI(): PagingData<EpisodeResultUI> {
    return map {
        EpisodeResultUI(
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