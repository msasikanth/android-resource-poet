package dev.sasikanth.android.resource.poet

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

class ResourceXmlTest {

    @Test fun emptyResourcesXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources/>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            // no-op
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun stringResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string name="hello">Hello!</string>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            string {
                name = "hello"
                value = "Hello!"
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun untranslatableStringResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string name="app_name" translatable="false">Twine</string>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            string {
                name = "app_name"
                value = "Twine"
                translatable = false
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun stringArrayResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string-array name="planets_array">
                <item>Mercury</item>
                <item>Venus</item>
                <item>Earth</item>
                <item>Mars</item>
            </string-array>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringArray {
                name = "planets_array"
                items = arrayOf(
                    "Mercury",
                    "Venus",
                    "Earth",
                    "Mars"
                )
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun untranslatableStringArrayResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string-array name="planets_array" translatable="false">
                <item>Mercury</item>
                <item>Venus</item>
                <item>Earth</item>
                <item>Mars</item>
            </string-array>
        </resources>

    """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringArray {
                name = "planets_array"
                items = arrayOf(
                    "Mercury",
                    "Venus",
                    "Earth",
                    "Mars"
                )
                translatable = false
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun stringPluralsResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <plurals name="numberOfSongsAvailable">
                <item quantity="one">%d song found.</item>
                <item quantity="other">%d songs found.</item>
            </plurals>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringPlurals {
                name = "numberOfSongsAvailable"
                item {
                    quantity = "one"
                    value = "%d song found."
                }

                item {
                    quantity = "other"
                    value = "%d songs found."
                }
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun untranslatableStringPluralsResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <plurals name="numberOfSongsAvailable" translatable="false">
                <item quantity="one">%d song found.</item>
                <item quantity="other">%d songs found.</item>
            </plurals>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringPlurals {
                name = "numberOfSongsAvailable"
                translatable = false

                item {
                    quantity = "one"
                    value = "%d song found."
                }

                item {
                    quantity = "other"
                    value = "%d songs found."
                }
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun booleanResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <bool name="adjust_view_bounds">true</bool>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            boolean {
                name = "adjust_view_bounds"
                value = true
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun colorResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
            <?xml version="1.0" encoding="UTF-8" standalone="no"?>
            <resources>
                <color name="app_color_primary">#FFFFFF</color>
            </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            color {
                name = "app_color_primary"
                value = "#FFFFFF"
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun dimenResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <dimen name="font_size">14sp</dimen>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            dimen {
                name = "font_size"
                value = "14sp"
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun idResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <item name="button_ok" type="id"/>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            id {
                name = "button_ok"
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun integerResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <integer name="max_speed">75</integer>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            integer {
                name = "max_speed"
                value = 75
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun integerArrayResosurceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <integer-array name="bits">
                <item>4</item>
                <item>8</item>
                <item>16</item>
            </integer-array>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            integerArray {
                name = "bits"
                values = intArrayOf(4, 8, 16)
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }
}
