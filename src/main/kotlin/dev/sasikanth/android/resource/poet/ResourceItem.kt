package dev.sasikanth.android.resource.poet

import org.w3c.dom.Element

@ResourceMarker
interface ResourceItem {
  fun build(tagFactory: (tagName: String) -> Element): Element
}
