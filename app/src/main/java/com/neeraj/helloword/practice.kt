package com.neeraj.helloword

fun main(){
    var age=21
    when(age){
        in 1..16 -> println("You may drive now")
        in 17..18 -> println("You may vote now")
        in 21..100
        -> println("Now you may drink")
        else -> println("You're too young")
    }
}