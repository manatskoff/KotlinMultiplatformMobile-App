package ru.ivan.kmmproj.dsl

class PageBlockBuilder {

    var type = ""
    var content = ""

    fun build(): PageBlock = PageBlock(type, content)
}