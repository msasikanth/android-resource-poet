# Android Resource Poet

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/dev.sasikanth/android-resource-poet/badge.svg)](https://maven-badges.herokuapp.com/maven-central/dev.sasikanth/android-resource-poet)
![CI Checks](https://github.com/msasikanth/android-resource-poet/actions/workflows/ci.yml/badge.svg)

Kotlin DSL to create Android resource XML

## Adding to your project

```kotlin
implementation("dev.sasikanth:android-resource-poet:<latest-version>")
```

## Basic usage

```kotlin
val xml: String = resourceXml {
    string(name = "app_name") {
        value = "Twine"
        translatable = false
    }

    dimen(name = "ball_radius") {
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
    string(name = "") {
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
    stringArray(name = "") {
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
    stringPlurals(name = "") {
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
    boolean(name = "") {
        value = true // Optional - Default false
    }
}
```
</details>

<details>
    <summary>Color</summary>

```kotlin
resourceXml {
    color(name = "") {
        value = "" // Required
    }
}
```

</details>

<details>
    <summary>Dimen</summary>

```kotlin
resourceXml {
    dimen(name = "") {
        value = "" // Required
    }
}
```

</details>

<details>
    <summary>Integer</summary>

```kotlin
resourceXml {
    integer(name = "") {
        value = "" // Required
    }
}
```

</details>

<details>
    <summary>Integer Array</summary>

```kotlin
resourceXml {
    integerArray(name = "") {
        values = intArrayOf() // Required
    }
}
```

</details>

<details>
    <summary>Style</summary>

```kotlin
resourceXml {
    style(name = "") {
        parent = "" // Optional - Default empty

        item {
            name = "" // Required
            value = "" // Required
        }
    }
}
```

</details>

## License

```
Copyright 2023 Sasikanth Miriyampalli

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
