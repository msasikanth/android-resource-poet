package dev.sasikanth.android.resource.poet.boolean

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_BOOLEAN
import org.w3c.dom.Element

class BooleanItem internal constructor(private val name: String) : ResourceItem {

  var value: Boolean = false

  override fun build(tagFactory: (tagName: String) -> Element): Element {
    val booleanTag = tagFactory(TAG_BOOLEAN)
    booleanTag.setAttribute(ATTR_NAME, name)
    booleanTag.textContent = value.toString()
    return booleanTag
  }
}
