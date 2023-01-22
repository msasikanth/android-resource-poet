package dev.sasikanth.android.resource.poet.color

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_COLOR
import org.w3c.dom.Document
import org.w3c.dom.Element

class ColorItem internal constructor(document: Document, rootTag: Element) : ResourceItem {
    
    lateinit var name: String
    lateinit var value: String
    
    private val colorTag = document.createElement(TAG_COLOR)

    override fun build(): Element {
        colorTag.setAttribute(ATTR_NAME, name)
        colorTag.textContent = value
        return colorTag
    }
}
