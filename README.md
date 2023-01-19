# Android Resource Poet [WIP]

DSL to create Android resource XML from Kotlin.

## Adding to your project

```kotlin
// TBD
```

## Basic usage

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
}

// Write XML to file
val fileWriter: OutputStreamWriter = // config file output stream
fileWriter.write(xml)
```

## Supported resource types (WIP and continuously updated)

<details>
    <summary>String</summary>

```kotlin
resourceXml {
    string {
        name = "" // Required
        value = "" // Required
        translatable = false // Optional - Default true
    }
}
````
</details>

<details>
    <summary>String Array</summary>

```kotlin
resourceXml {
    stringArray {
        name = "" // Required
        items = arrayOf("") // Required
        translatable = false // Optional - Default true
    }
}
````
</details>

<details>
    <summary>Plurals</summary>

```kotlin
resourceXml {
    stringPlurals {
        name = "" // Required
        translatable = false // Optional - Default true
        item {
            quantity = "" // Required
            value = "" // Required
        }
    }
}
````
</details>

<details>
    <summary>Boolean</summary>

```kotlin
resourceXml {
    boolean {
        name = "" // Required
        value = true // Optional - Default false
    }
}
```
</details>
