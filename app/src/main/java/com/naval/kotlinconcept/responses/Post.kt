package com.naval.kotlinconcept.responses

data class Post(val id:Int,
                val userId:Int,
                val title:String,
                val body:String)