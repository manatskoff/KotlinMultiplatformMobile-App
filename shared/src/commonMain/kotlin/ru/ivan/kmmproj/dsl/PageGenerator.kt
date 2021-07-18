package ru.ivan.kmmproj.dsl

// 1
//fun page(block: (Page) -> Unit): Page {
//    val page = Page()
//    block(page)
//    return page
//}

// 2
//fun page(block: (Page) -> Unit): Page = Page().apply(block)

// 3
fun page(block: PageBuilder.() -> Unit): Page =  PageBuilder().apply(block).build()
fun pageBlock(block: PageBlockBuilder.() -> Unit): PageBlock =  PageBlockBuilder().apply(block).build()




class PageGenerator {
    fun generatePage(): Page = page {
        number = 1
        pageBlocks {
            headerBlock("Header text")
            mainBlock("Main text")
            endBlock("End text")
        }
    }
}
