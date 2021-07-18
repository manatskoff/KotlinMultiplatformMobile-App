package ru.ivan.kmmproj.dsl


@ArticleDSL
class PageBuilder {

    var number: Int = -1
    var pageBlocks: MutableList<PageBlock> =  mutableListOf()

    fun pageBlocks(block: PageBlockContainer.() -> Unit) {
        val pageBlockContainer = PageBlockContainer().apply(block)
        pageBlocks.addAll(pageBlockContainer.content)
    }

    fun build(): Page = Page(number, pageBlocks);
}




@ArticleDSL
class PageBlockContainer {
    val content: MutableList<PageBlock> = mutableListOf()

    inline fun pageBlock(block: PageBlockBuilder.() -> Unit) =
        PageBlockBuilder().apply(block).build().also {
            content.add(it)
        }
}

fun PageBlockContainer.headerBlock(text:String) = pageBlock {
    type = "header"
    content = text
}
fun PageBlockContainer.mainBlock(text:String) = pageBlock {
    type = "main"
    content = text
}
fun PageBlockContainer.endBlock(text:String) = pageBlock {
    type = "end"
    content = text
}