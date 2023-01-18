package dev.sasikanth.android.resource.poet

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
        StringItem(document, resourcesTag).also(init).build()
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
