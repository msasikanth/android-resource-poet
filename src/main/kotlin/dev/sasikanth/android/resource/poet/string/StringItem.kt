package dev.sasikanth.android.resource.poet.string

import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_TRANSLATABLE
import dev.sasikanth.android.resource.poet.common.TAG_STRING
import org.w3c.dom.Element

class StringItem internal constructor(private val name: String) : TranslatableStringResourceItem {

  lateinit var value: String

  override var translatable: Boolean = true

  override fun build(tagFactory: (tagName: String) -> Element): Element {
    val stringTag = tagFactory(TAG_STRING)
    stringTag.setAttribute(ATTR_NAME, name)
    if (!translatable) {
      stringTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
    }
    stringTag.textContent = value

    return stringTag
  }
}
