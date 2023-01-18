package dev.sasikanth.android.resource.poet

import org.w3c.dom.Document
import org.w3c.dom.Element

fun ResourceXml.string(init: StringItem.() -> Unit) {
    val stringItem = StringItem(document, resourcesTag)
    stringItem.init()
    stringItem.build()
}

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
