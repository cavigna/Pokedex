package com.example.pokedexmvvm.utils

sealed class Resource<T>(val data: T? = null, val message:String?=null){
    class Sucess<T>(data: T): Resource<T>(data)
    class Error<T>(data: T?=null, message: String): Resource<T>(data, message)
    class Loading<T>(data:T? = null) : Resource<T>(data)
}
