package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class ExampleUnitTest {
    private lateinit var queue: QueueExample
  @Before
  fun setUp(){
      queue = QueueExample()
  }

    @Test
    fun testPush(){
        queue.push(1)
        assertEquals(1, queue.items.size)
    }

    @Test
    fun testEmpty(){
        val result = queue.isEmpty()
        assertEquals(true, result )
    }

    @Test
    fun testPop(){
        queue.push(2)
        var popItem = queue.pop()
        assertEquals(2, popItem)
    }
    @Test
    fun testPeek(){
        queue.push(4)
        var lastItem = queue.peek()
        assertEquals(4, lastItem)
    }
}