package dev.sasikanth.android.resource.poet.string

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_QUANTITY
import dev.sasikanth.android.resource.poet.common.ATTR_TRANSLATABLE
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import dev.sasikanth.android.resource.poet.common.TAG_STRING_PLURALS
import org.w3c.dom.Document
import org.w3c.dom.Element

class StringPlurals internal constructor(
    private val document: Document,
    root: Element
) : ResourceItem {
    lateinit var name: String

    var translatable: Boolean = true

    private val stringPluralTag = document.createElement(TAG_STRING_PLURALS)

    init {
        root.appendChild(stringPluralTag)
    }

    fun item(init: StringPluralItem.() -> Unit) {
        StringPluralItem(document, stringPluralTag).also(init).build()
    }

    override fun build() {
        stringPluralTag.setAttribute(ATTR_NAME, name)
        if (!translatable) {
            stringPluralTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
        }
    }
}

class StringPluralItem internal constructor(
    document: Document,
    root: Element
) : ResourceItem {
    lateinit var quantity: String

    lateinit var value: String

    private val itemTag = document.createElement(TAG_ITEM)

    init {
        root.appendChild(itemTag)
    }

    override fun build() {
        itemTag.setAttribute(ATTR_QUANTITY, quantity)
        itemTag.textContent = value
    }
}
