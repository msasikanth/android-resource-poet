package dev.sasikanth.android.resource.poet.integer

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_INTEGER
import org.w3c.dom.Element

class IntegerItem internal constructor(private val name: String) : ResourceItem {

  var value: Int? = null

  override fun build(tagFactory: (tagName: String) -> Element): Element {
    val integerTag = tagFactory(TAG_INTEGER)
    integerTag.setAttribute(ATTR_NAME, name)

    if (value == null) {
      error("Integer value cannot be null")
    }
    integerTag.textContent = value.toString()
    return integerTag
  }
}
