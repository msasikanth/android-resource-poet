package dev.sasikanth.android.resource.poet.string

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_QUANTITY
import dev.sasikanth.android.resource.poet.common.ATTR_TRANSLATABLE
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import dev.sasikanth.android.resource.poet.common.TAG_STRING_PLURALS
import org.w3c.dom.Element

class StringPlurals internal constructor() : TranslatableStringResourceItem {
    lateinit var name: String

    override var translatable: Boolean = true

    private val items = mutableListOf<StringPluralItem>()

    fun item(init: StringPluralItem.() -> Unit) {
        val pluralItem = StringPluralItem().also(init)
        items.add(pluralItem)
    }

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val stringPluralTag = tagFactory(TAG_STRING_PLURALS)
        stringPluralTag.setAttribute(ATTR_NAME, name)
        if (!translatable) {
            stringPluralTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
        }

        for (item in items) {
            item.build(tagFactory).also(stringPluralTag::appendChild)
        }

        return stringPluralTag
    }
}

class StringPluralItem internal constructor() : ResourceItem {
    lateinit var quantity: String

    lateinit var value: String

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val itemTag = tagFactory(TAG_ITEM)
        itemTag.setAttribute(ATTR_QUANTITY, quantity)
        itemTag.textContent = value

        return itemTag
    }
}
