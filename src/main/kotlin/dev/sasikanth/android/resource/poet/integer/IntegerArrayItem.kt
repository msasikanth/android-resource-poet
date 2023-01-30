package dev.sasikanth.android.resource.poet.integer

import dev.sasikanth.android.resource.poet.ResourceItem
import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.TAG_INTEGER_ARRAY
import dev.sasikanth.android.resource.poet.common.TAG_ITEM
import org.w3c.dom.Element

class IntegerArrayItem internal constructor(private val name: String) : ResourceItem {

  lateinit var values: IntArray

  override fun build(tagFactory: (tagName: String) -> Element): Element {
    val integerArrayTag = tagFactory(TAG_INTEGER_ARRAY)
    integerArrayTag.setAttribute(ATTR_NAME, name)

    for (value in values) {
      val item = tagFactory(TAG_ITEM)
      item.textContent = value.toString()
      integerArrayTag.appendChild(item)
    }
    return integerArrayTag
  }
}
