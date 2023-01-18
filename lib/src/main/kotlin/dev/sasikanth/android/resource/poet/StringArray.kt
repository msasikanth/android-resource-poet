package dev.sasikanth.android.resource.poet

import org.w3c.dom.Document
import org.w3c.dom.Element

@ResourceMarker
class StringArray internal constructor(
    private val document: Document,
    root: Element
) {

    lateinit var name: String

    lateinit var items: Array<String>

    var translatable: Boolean = true

    private val stringArrayTag = document.createElement(TAG_STRING_ARRAY)

    init {
        root.appendChild(stringArrayTag)
    }

    fun build() {
        stringArrayTag.setAttribute(ATTR_NAME, name)
        if (!translatable) {
            stringArrayTag.setAttribute(ATTR_TRANSLATABLE, translatable.toString())
        }

        for (item in items) {
            val itemElement = document.createElement(TAG_ITEM)
            itemElement.textContent = item
            stringArrayTag.appendChild(itemElement)
        }
    }
}