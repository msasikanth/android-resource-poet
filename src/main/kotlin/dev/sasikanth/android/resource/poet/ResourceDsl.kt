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

  private val documentBuilder =
    try {
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

  fun string(name: String, init: StringItem.() -> Unit) {
    StringItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun stringArray(name: String, init: StringArray.() -> Unit) {
    StringArray(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun stringPlurals(name: String, init: StringPlurals.() -> Unit) {
    StringPlurals(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun boolean(name: String, init: BooleanItem.() -> Unit) {
    BooleanItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun color(name: String, init: ColorItem.() -> Unit) {
    ColorItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun dimen(name: String, init: DimenItem.() -> Unit) {
    DimenItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun id(name: String) {
    IdItem(name).build(tagFactory = document::createElement).also(resourcesTag::appendChild)
  }

  fun integer(name: String, init: IntegerItem.() -> Unit) {
    IntegerItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun integerArray(name: String, init: IntegerArrayItem.() -> Unit) {
    IntegerArrayItem(name)
      .also(init)
      .build(tagFactory = document::createElement)
      .also(resourcesTag::appendChild)
  }

  fun style(name: String, init: Style.() -> Unit) {
    Style(name)
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
