package com.geektech.rickandmorty.core

import com.geektech.rickandmorty.data.model.*
import com.geektech.rickandmorty.domain.model.*

fun CharacterDomain.characterDomainToCharacter(): Character {
    return Character(
        results = this.resultDomains.resultDomainToResult(),
        id = this.id,
        info = this.infoDomain.infoDomainToInfo()
    )
}

fun Character.characterToCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        resultDomains = this.results.resultToResultDomain(),
        id = this.id,
        infoDomain = this.info.infoToInfoDomain()
    )
}

fun InfoDomain.infoDomainToInfo(): Info {
    return Info(count = this.count, next = this.next, pages = this.pages, prev = this.prev)
}

fun Info.infoToInfoDomain(): InfoDomain {
    return InfoDomain(count = this.count, next = this.next, pages = this.pages, prev = this.prev)
}

fun List<ResultDomain>.resultDomainToResult(): List<Result> {
    return map {
        Result(
            it.created, it.episode, it.gender, it.id, it.image,
            it.locationDomain.locationDomainToLocation(), it.name, it.originDomain.originDomainToOrigin(),
            it.species, it.status, it.type, it.url
        )
    }
}

fun List<Result>.resultToResultDomain(): List<ResultDomain> {
    return map {
        ResultDomain(
            it.created, it.episode, it.gender, it.id, it.image,
            it.location.locationToLocationDomain(), it.name, it.origin.originToOriginDomain(),
            it.species, it.status, it.type, it.url
        )
    }
}

fun OriginDomain.originDomainToOrigin(): Origin {
    return Origin(this.name, this.url)
}

fun Origin.originToOriginDomain(): OriginDomain {
    return OriginDomain(this.name, this.url)
}

fun LocationDomain.locationDomainToLocation(): Location {
    return Location(this.name, this.url)
}

fun Location.locationToLocationDomain(): LocationDomain {
    return LocationDomain(this.name, this.url)
}