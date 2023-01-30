package dev.sasikanth.android.resource.poet.style

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_PARENT
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import dev.sasikanth.android.resource.poet.common.TAG_STYLE
import org.w3c.dom.Element

class Style : ResourceItem {

    lateinit var name: String
    var parent: String = ""

    private val items = mutableListOf<StyleItem>()

    fun item(init: StyleItem.() -> Unit) {
        val styleItem = StyleItem().also(init)
        items.add(styleItem)
    }

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val styleTag = tagFactory(TAG_STYLE)
        styleTag.setAttribute(ATTR_NAME, name)
        styleTag.setAttribute(ATTR_PARENT, parent)

        for (item in items) {
            item.build(tagFactory).also(styleTag::appendChild)
        }

        return styleTag
    }
}

class StyleItem : ResourceItem {

    lateinit var name: String
    lateinit var value: String

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val itemTag = tagFactory(TAG_ITEM)
        itemTag.setAttribute(ATTR_NAME, name)
        itemTag.textContent = value
        return itemTag
    }
}
