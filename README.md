# Android Resource Poet

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
val fileWriter: OutputStreamWriter = // configure file output stream
fileWriter.write(xml)
```

## Supported resource types (WIP)

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

<details>
    <summary>Color</summary>

```kotlin
resourceXml {
    color {
        name = "" // Required
        value = "" // Required
    }
}
```
</details>

<details>
    <summary>Dimen</summary>

```kotlin
resourceXml {
    dimen {
        name = "" // Required
        value = "" // Required
    }
}
```
</details>

<details>
    <summary>Integer</summary>

```kotlin
resourceXml {
    integer {
        name = "" // Required
        value = "" // Required
    }
}
```
</details>

<details>
    <summary>Integer Array</summary>

```kotlin
resourceXml {
    integerArray {
        name = "" // Required
        values = intArrayOf() // Required
    }
}
```
</details>

<details>
    <summary>Style</summary>

```kotlin
resourceXml {
    style {
        name = "" // Required
        parent = "" // Optional - Default empty

        item {
            name = "" // Required
            value = "" // Required
        }
    }
}
```
</details>
