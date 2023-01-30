package dev.sasikanth.android.resource.poet.dimen

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_DIMEN
import org.w3c.dom.Element

class DimenItem internal constructor() : ResourceItem {

    lateinit var name: String
    lateinit var value: String

    override fun build(tagFactory: (tagName: String) -> Element): Element {
        val dimenTag = tagFactory(TAG_DIMEN)
        dimenTag.setAttribute(ATTR_NAME, name)
        dimenTag.textContent = value
        return dimenTag
    }
}
