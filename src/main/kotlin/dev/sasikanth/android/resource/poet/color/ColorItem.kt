package dev.sasikanth.android.resource.poet.color

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_COLOR
import org.w3c.dom.Element

class ColorItem internal constructor(private val name: String) : ResourceItem {

  lateinit var value: String

  override fun build(tagFactory: (tagName: String) -> Element): Element {
    val colorTag = tagFactory(TAG_COLOR)
    colorTag.setAttribute(ATTR_NAME, name)
    colorTag.textContent = value
    return colorTag
  }
}
