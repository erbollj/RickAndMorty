package com.geektech.rickandmorty.core

import com.geektech.rickandmorty.data.model.Character
import com.geektech.rickandmorty.domain.model.CharacterDomain

fun CharacterDomain.characterDomainToCharacter(): Character {
    return Character(info = this.info, results = this.results)
}

fun Character.characterToCharacterDomain(): CharacterDomain {
    return CharacterDomain(info = this.info, results = this.results)
}
