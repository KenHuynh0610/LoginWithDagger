package com.example.myapplication

class QueueExample {
    var last = -1
    var items: ArrayList<Int> = ArrayList()

    fun push(item:Int){
        last++
        items.add(item)
    }

    fun isEmpty():Boolean {
        return last == -1
    }

    fun pop(): Int?{
        if(isEmpty()){
            return null
        }
        val lastItem = items[last]
        last -= 1
        return lastItem
    }

    fun peek(): Int?{
        if (isEmpty()){
            return null
        }
        return items[last]
    }
}