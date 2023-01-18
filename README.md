# Android Resource Poet [WIP]

DSL to create Android resource XML from Kotlin.

For example (API is still WIP, not finalised or fully built yet):

```kotlin
val xml: String = resourceXml {
    string {
        name = "app_name"
        value = "Twine"
        translatable = false
    }

    dimen {
        name = "ball_radius"
        value = "30dp"
    }

    enumAttr {
        name = "type"
        enum {
            name = "type_1"
            value = 0
        }
        enum {
            name = "type_2"
            value = 1
        }
    }
}

// Write XML to file
fileWriter.write(xml)
```
