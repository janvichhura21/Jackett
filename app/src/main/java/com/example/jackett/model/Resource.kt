package com.example.jackett.model

sealed class Resource{

    class Succes(val data: MutableList<UMQ>):Resource()
}
