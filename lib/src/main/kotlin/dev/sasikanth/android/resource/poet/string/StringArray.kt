package dev.sasikanth.android.resource.poet.string

import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_TRANSLATABLE
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import dev.sasikanth.android.resource.poet.common.TAG_STRING_ARRAY
import org.w3c.dom.Document
import org.w3c.dom.Element

class StringArray internal constructor(private val document: Document) : TranslatableStringResourceItem {

    lateinit var name: String

    lateinit var items: Array<String>

    override var translatable: Boolean = true

    private val stringArrayTag = document.createElement(TAG_STRING_ARRAY)

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val stringArrayTag = tagFactory(TAG_STRING_ARRAY)
        stringArrayTag.setAttribute(ATTR_NAME, name)
        if (!translatable) {
            stringArrayTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
        }

        for (item in items) {
            val itemElement = tagFactory(TAG_ITEM)
            itemElement.textContent = item
            stringArrayTag.appendChild(itemElement)
        }

        return stringArrayTag
    }
}
