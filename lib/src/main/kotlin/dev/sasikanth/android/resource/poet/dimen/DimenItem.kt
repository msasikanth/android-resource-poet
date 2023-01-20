package dev.sasikanth.android.resource.poet.dimen

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_DIMEN
import org.w3c.dom.Document
import org.w3c.dom.Element

class DimenItem internal constructor(
    document: Document,
    rootTag: Element
) : ResourceItem {

    lateinit var name: String
    lateinit var value: String

    private val dimenTag = document.createElement(TAG_DIMEN)

    init {
        rootTag.appendChild(dimenTag)
    }

    override fun build() {
        dimenTag.setAttribute(ATTR_NAME, name)
        dimenTag.textContent = value
    }
}