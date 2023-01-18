package dev.sasikanth.android.resource.poet.string

import dev.sasikanth.android.resource.poet.common.ATTR_NAME
import dev.sasikanth.android.resource.poet.common.ATTR_TRANSLATABLE
import dev.sasikanth.android.resource.poet.ResourceMarker
import dev.sasikanth.android.resource.poet.common.TAG_STRING
import org.w3c.dom.Document
import org.w3c.dom.Element

@ResourceMarker
class StringItem internal constructor(
    document: Document,
    root: Element
) {
    lateinit var name: String

    lateinit var value: String

    var translatable: Boolean = true

    private val stringTag = document.createElement(TAG_STRING)

    init {
        root.appendChild(stringTag)
    }

    fun build() {
        stringTag.setAttribute(ATTR_NAME, name)
        if (!translatable) {
            stringTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
        }
        stringTag.textContent = value
    }
}
