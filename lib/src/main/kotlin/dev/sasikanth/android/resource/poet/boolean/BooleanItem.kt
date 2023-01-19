package dev.sasikanth.android.resource.poet.boolean

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_BOOLEAN
import org.w3c.dom.Document
import org.w3c.dom.Element

class BooleanItem internal constructor(
    document: Document,
    root: Element
) : ResourceItem {

    lateinit var name: String
    var value: Boolean = false

    private val booleanTag = document.createElement(TAG_BOOLEAN)

    init {
        root.appendChild(booleanTag)
    }

    override fun build() {
        booleanTag.setAttribute(ATTR_NAME, name)
        booleanTag.textContent = value.toString()
    }
}
