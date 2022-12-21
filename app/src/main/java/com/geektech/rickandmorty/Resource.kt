package com.geektech.rickandmorty

class Resource<T>(val data: T?, message: String?, val status: Status) {
    enum class Status{
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun<T> success(data: T): Resource<T> {
            return Resource(data, null, Status.SUCCESS)
        }

        fun<T> error(message: String): Resource<T> {
            return Resource(null, message, Status.ERROR)
        }

        fun<T> loading(): Resource<T> {
            return Resource(null, null, Status.LOADING)
        }

    }
}