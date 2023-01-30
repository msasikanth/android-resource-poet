package dev.sasikanth.android.resource.poet

import dev.sasikanth.android.resource.poet.boolean.BooleanItem
import dev.sasikanth.android.resource.poet.color.ColorItem
import dev.sasikanth.android.resource.poet.common.TAG_RESOURCES
import dev.sasikanth.android.resource.poet.dimen.DimenItem
import dev.sasikanth.android.resource.poet.id.IdItem
import dev.sasikanth.android.resource.poet.integer.IntegerArrayItem
import dev.sasikanth.android.resource.poet.integer.IntegerItem
import dev.sasikanth.android.resource.poet.string.StringArray
import dev.sasikanth.android.resource.poet.string.StringItem
import dev.sasikanth.android.resource.poet.string.StringPlurals
import dev.sasikanth.android.resource.poet.style.Style
import java.io.StringWriter
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun resourceXml(init: ResourceXml.() -> Unit): String {
    val resourceXml = ResourceXml()
    resourceXml.init()

    return resourceXml.toString()
}

@ResourceMarker
class ResourceXml {

    private val documentBuilder = try {
        DocumentBuilderFactory.newInstance().newDocumentBuilder()
    } catch (e: ParserConfigurationException) {
        error("Failed to create the XML builder")
    }
    private val document = documentBuilder.newDocument()
    private val resourcesTag = document.createElement(TAG_RESOURCES)

    private val transformerFactory by lazy { TransformerFactory.newInstance() }

    init {
        document.appendChild(resourcesTag)
    }

    fun string(init: StringItem.() -> Unit) {
        StringItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun stringArray(init: StringArray.() -> Unit) {
        StringArray()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun stringPlurals(init: StringPlurals.() -> Unit) {
        StringPlurals()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun boolean(init: BooleanItem.() -> Unit) {
        BooleanItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun color(init: ColorItem.() -> Unit) {
        ColorItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun dimen(init: DimenItem.() -> Unit) {
        DimenItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun id(init: IdItem.() -> Unit) {
        IdItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun integer(init: IntegerItem.() -> Unit) {
        IntegerItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun integerArray(init: IntegerArrayItem.() -> Unit) {
        IntegerArrayItem()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    fun style(init: Style.() -> Unit) {
        Style()
            .also(init)
            .build(tagFactory = document::createElement)
            .also(resourcesTag::appendChild)
    }

    override fun toString(): String {
        val stringWriter = StringWriter()
        val result = StreamResult(stringWriter)
        val transformer = transformerFactory.newTransformer()
        val source = DOMSource(document)
        transformer.setOutputProperty(OutputKeys.INDENT, "yes")
        transformer.transform(source, result)
        return stringWriter.toString()
    }
}