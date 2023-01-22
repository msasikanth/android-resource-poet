package dev.sasikanth.android.resource.poet.id

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_TYPE
import dev.sasikanth.android.resource.poet.common.ATTR_TYPE_ID
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import org.w3c.dom.Document
import org.w3c.dom.Element

class IdItem internal constructor(document: Document, rootTag: Element) : ResourceItem {

    lateinit var name: String

    private val idItemTag = document.createElement(TAG_ITEM)

    override fun build(): Element {
        idItemTag.setAttribute(ATTR_TYPE, ATTR_TYPE_ID)
        idItemTag.setAttribute(ATTR_NAME, name)
        return idItemTag
    }
}
